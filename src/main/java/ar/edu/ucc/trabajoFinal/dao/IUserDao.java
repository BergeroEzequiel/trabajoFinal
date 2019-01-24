/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.UserProfile;
import ar.edu.ucc.trabajoFinal.model.Usuario;
import java.util.List;

/**
 *
 * @author ezequiel
 */
public interface IUserDao extends DaoGenerico<Usuario, Long> {
    
    Usuario findById(Long id);
     
    Usuario findBySSO(String sso);
    
    List<Usuario> getUsuariosByState(String state);
    
    List<Usuario> getUsuariosByIdRol(Long idRol);
    
}
