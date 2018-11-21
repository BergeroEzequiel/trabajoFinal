/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IUserDao;
import ar.edu.ucc.trabajoFinal.dao.UserDao;
import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import ar.edu.ucc.trabajoFinal.model.User;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostConstruct
    public void init() {
            usuarioDaoParticular = (UserDao) usuarioDao;
    }
 
    public User findById(Long id) {
        return usuarioDaoParticular.findById(id);
    }
 
    public User findBySso(String sso) {
        return usuarioDaoParticular.findBySSO(sso);
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public User grabarUsuario(User user) {
        
        usuarioDaoParticular.saveOrUpdate(user);
        return user;
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<User> getUsuarios() throws ParseException {
        List<User> usuarios = this.usuarioDaoParticular.getAll();
        return usuarios;
    }
    
}
