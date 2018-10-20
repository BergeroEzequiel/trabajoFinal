/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.User;

/**
 *
 * @author ezequiel
 */
public interface IUserDao extends DaoGenerico<User, Long> {
    
    User findById(Long id);
     
    User findBySSO(String sso);
    
}
