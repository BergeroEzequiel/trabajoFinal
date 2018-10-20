/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.controller;

import ar.edu.ucc.trabajoFinal.model.User;
import ar.edu.ucc.trabajoFinal.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ezequiel
 */
@Controller
public class UserController {
    
    @Autowired
    UserService usuarioService;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuario", 
                    method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> crearUsuario(@RequestBody User user)
                    throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usuarioService.grabarUsuario(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsuarios()
                    throws Exception {

        List<User> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity(usuarios, HttpStatus.OK);
    }

    
}
