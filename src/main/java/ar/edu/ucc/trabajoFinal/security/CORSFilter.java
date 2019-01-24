/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Solucion sacada de este link https://gist.github.com/zeroows/80bbe076d15cb8a4f0ad
 * 
 * Al parecer, todos los navegadores envian una peticion de tipo OPTIONS para verificar
 * los verbos que soporta el servidor (lo hacen como medida de seguridad parece).
 * De modo que para hacer el login, el navegador envia una request de tipo OPTIONS y luego, 
 * si todo esta OK, envía el POST.
 * 
 * Lo que hace el filtro es interceptar las request, y especificamente a las que tienen verbo OPTIONS ya que 
 * esas son las problemáticas. De modo que cuando llega una de ese tipo, le enviamos una response diciendo que todos los 
 * métodos permitidos son GET, POST, PUT, DELETE.
 * 
 * Para saber que se setea en los header ver https://developer.mozilla.org/es/docs/Web/HTTP/Headers#CORS
 * 
 * Leer este caso https://stackoverflow.com/questions/47564671/how-to-specify-response-headers-to-cors
 * y tambien este https://stackoverflow.com/questions/42221602/response-for-preflight-has-invalid-http-status-code-401-angular
 * @author ezequiel
 */
public class CORSFilter extends OncePerRequestFilter {

    private static final Log LOG = LogFactory.getLog(CORSFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");

        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            LOG.trace("Sending Header....");
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//			response.addHeader("Access-Control-Allow-Headers", "Authorization");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.addHeader("Access-Control-Max-Age", "10"); //el loco tenia 1 aca
        }

        filterChain.doFilter(request, response);
    }

}
