package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Trama;

public interface ITramaDao extends DaoGenerico<Trama, Long>{
	
	public List<Trama> getTramaByNodo(int nodo);

}
