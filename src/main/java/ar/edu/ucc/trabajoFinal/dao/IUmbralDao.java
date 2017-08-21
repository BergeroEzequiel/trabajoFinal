package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.Umbral;

public interface IUmbralDao extends DaoGenerico<Umbral, Long>{
	
	public Umbral getUmbralByVariable(String nombreVariable);

}
