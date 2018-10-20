/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel
 */
@Repository
public class UserDao extends DaoGenericoImp<User, Long> implements IUserDao{

    @Override
    public User findById(Long id) {
        return this.getByCriteria(Restrictions.eq("id", id)).get(0);
    }
 
    @Override
    public User findBySSO(String sso) {
        return this.getByCriteria(Restrictions.eq("ssoId", sso)).get(0);
    }
    
}
