/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 *
 * @author ezequiel
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    
    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

//    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
//        super(authenticationManager, authenticationEntryPoint);
//    }
    
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader("Authorization");
        boolean tokenValid;
        Claims token = null;

        if (!requiresAuthentication(header)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            token = Jwts.parser()
                    .setSigningKey("clave.secreta".getBytes())
                    .parseClaimsJws(header.replace("Bearer ", ""))
                    .getBody();

            tokenValid = true;
        } catch (JwtException | IllegalArgumentException e) {
            tokenValid = false;
        }

        UsernamePasswordAuthenticationToken authentication = null;

        if (tokenValid) {
            String username = token.getSubject();
            Object roles = token.get("authorities");

            Collection<? extends GrantedAuthority> authorities
                    = Arrays.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
                            .readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));

            authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);

        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    protected boolean requiresAuthentication(String header) {

        if (header == null || !header.startsWith("Bearer ")) {
            return false;
        }
        return true;
    }

}
