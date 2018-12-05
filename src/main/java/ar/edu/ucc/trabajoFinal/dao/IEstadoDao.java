/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.Estado;

/**
 *
 * @author ezequiel
 */
public interface IEstadoDao extends DaoGenerico<Estado, Long>{
    
    public Estado getEstadoById(Long id);
    
}
