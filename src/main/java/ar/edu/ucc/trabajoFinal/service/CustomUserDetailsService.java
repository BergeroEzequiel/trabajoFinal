/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.model.Estado;
import ar.edu.ucc.trabajoFinal.model.User;
import ar.edu.ucc.trabajoFinal.model.UserProfile;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel
 */
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;
     
    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        User user = userService.findBySso(ssoId);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(), 
                 user.getEstado().getId().equals(Estado.ACTIVO), true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        
        UserProfile userProfile = user.getUserProfile();
        System.out.println("Rol del usuario : " + userProfile);
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
            
        System.out.print("authorities :"+authorities);
        return authorities;
    }  
}
