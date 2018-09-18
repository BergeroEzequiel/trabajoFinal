package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Umbral;

public interface IUmbralDao extends DaoGenerico<Umbral, Long>{
	
	public Umbral getUmbralGenericoByVariable(String nombreVariable);

	public List<Umbral> getUmbralesEspByNodo(Long idNodo);
	
	public List<Umbral> getUmbralesGenericos();
	
}
