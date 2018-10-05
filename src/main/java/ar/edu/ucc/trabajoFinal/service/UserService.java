/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.UserDao;
import ar.edu.ucc.trabajoFinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserDao dao;
 
    public User findById(Long id) {
        return dao.findById(id);
    }
 
    public User findBySso(String sso) {
        return dao.findBySSO(sso);
    }
    
}
