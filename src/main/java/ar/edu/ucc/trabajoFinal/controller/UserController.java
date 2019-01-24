/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.controller;

import ar.edu.ucc.trabajoFinal.dto.UserDto;
import ar.edu.ucc.trabajoFinal.model.Usuario;
import ar.edu.ucc.trabajoFinal.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ezequiel
 */
@RestController
@RequestMapping("/api")  
public class UserController {
    
    @Autowired
    UserService usuarioService;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuario", 
                    method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario user)
                    throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usuarioService.grabarNuevoUsuario(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsuarios()
                    throws Exception {

        List<Usuario> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity(usuarios, HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuariosByState", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsuariosByState(@RequestParam(value = "state", required = true) String state)
                    throws Exception {

        List<Usuario> usuarios = usuarioService.getUsuariosByState(state);
        return new ResponseEntity(usuarios, HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuario", 
                    method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario)
                    throws Exception {
        Usuario usuarioRespuesta = usuarioService.actualizarUsuario(usuario);
        return new ResponseEntity(usuarioRespuesta,HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/usuarioPassword", 
                    method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> actualizarPasswordUsuario(@RequestBody UserDto usuarioDto)
                    throws Exception {
        try {
            Usuario usuarioRespuesta = usuarioService.actualizarPasswordUsuario(usuarioDto);
            return new ResponseEntity(usuarioRespuesta,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/passwordOlvidado", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> blanquearPassword(@RequestParam(value = "username", required = true) String username)
                    throws Exception {
        try {
            usuarioService.blanquearPassword(username);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.CONFLICT);
        }
    }
    
}
