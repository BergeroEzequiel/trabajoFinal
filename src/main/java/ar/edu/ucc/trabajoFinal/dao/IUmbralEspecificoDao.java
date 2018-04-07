package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;

public interface IUmbralEspecificoDao extends DaoGenerico<UmbralEspecifico, Long>{
	
	public List<UmbralEspecifico> getUmbralEspByNodo(Long idNodo);
	
	public List<UmbralEspecifico> getUmbralEspByNodo(String modulo, int numero);

}