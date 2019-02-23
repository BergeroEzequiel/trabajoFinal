package ar.edu.ucc.trabajoFinal.dao;

import java.io.Serializable;

import ar.edu.ucc.trabajoFinal.model.UnidadMedida;

public interface IUnidadMedidaDao extends DaoGenerico <UnidadMedida, Long> {
    
    public UnidadMedida getUMById(Long id);

}
