/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.Criticidad;

/**
 *
 * @author ezequiel
 */
public interface ICriticidadDao extends DaoGenerico<Criticidad, Long>{
    
    public Criticidad getCriticidadByPrioridad(String prioridad);
    
}
