/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.EstadoDao;
import ar.edu.ucc.trabajoFinal.dao.IEstadoDao;
import ar.edu.ucc.trabajoFinal.dao.IUserDao;
import ar.edu.ucc.trabajoFinal.dao.UserDao;
import ar.edu.ucc.trabajoFinal.dto.UserDto;
import ar.edu.ucc.trabajoFinal.model.Estado;
import ar.edu.ucc.trabajoFinal.model.User;
import java.text.ParseException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    DaoGenerico<User, Long> usuarioDao;

    IUserDao usuarioDaoParticular;
    
    @Autowired
    DaoGenerico<Estado, Long> estadoDao;
    
    IEstadoDao estadoDaoParticular;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostConstruct
    public void init() {
            usuarioDaoParticular = (UserDao) usuarioDao;
            estadoDaoParticular = (EstadoDao) estadoDao;
    }
 
    public User findById(Long id) {
        return usuarioDaoParticular.findById(id);
    }
 
    public User findBySso(String sso) {
        return usuarioDaoParticular.findBySSO(sso);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public User grabarNuevoUsuario(User user) {
        if(user.getId() == null){
            user.setEstado(estadoDaoParticular.getEstadoById(Estado.PENDIENTE));
            user.setUserProfile(null);
            usuarioDaoParticular.saveOrUpdate(user);
            return user;
        }
        
        throw new RuntimeException("Este método solo crea usuarios. Envie un User con id nulo por favor.");
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<User> getUsuarios() throws ParseException {
        List<User> usuarios = this.usuarioDaoParticular.getAll();
        return usuarios;
    }
    
    public List<User> getUsuariosByState(String state){
        return usuarioDaoParticular.getUsuariosByState(state);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public User actualizarPasswordUsuario(UserDto userDto) {
        if(userDto.getPassword().equals(userDto.getPasswordNuevo()))
            throw new RuntimeException("Los password son iguales. Para cambiar "
                    + "la password debe ingresar una distinta a la anterior.");
        if(userDto.getId() == null)
            throw new RuntimeException("ID nulo. No se puede actualizar la password de un usuario sin ID.");
        
        User usuario = this.usuarioDaoParticular.findById(userDto.getId());
        usuario.setPassword(bCryptPasswordEncoder.encode(userDto.getPasswordNuevo()));
        usuarioDaoParticular.saveOrUpdate(usuario);
        
        return usuario;
    }
    
    /**
     * Este método sirve para actualizar todos los datos de un usuario, MENOS 
     * la PASSWORD e ID.
     * @param user
     * @return 
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public User actualizarUsuario(User user) {
        if(user.getId() == null)
            throw new RuntimeException("ID nulo. No se puede actualizar un usuario sin ID.");
        
        User usuarioOriginal = this.usuarioDaoParticular.findById(user.getId());
        usuarioOriginal.setEmail(user.getEmail());
        usuarioOriginal.setEstado(user.getEstado());
        usuarioOriginal.setFirstName(user.getFirstName());
        usuarioOriginal.setSsoId(user.getSsoId());
        usuarioOriginal.setUserProfile(user.getUserProfile());
        
        usuarioDaoParticular.saveOrUpdate(usuarioOriginal);
        
        return usuarioOriginal;
    }
    
}
