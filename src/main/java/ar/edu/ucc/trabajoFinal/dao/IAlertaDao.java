package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.Nodo;

public interface IAlertaDao extends DaoGenerico<Alerta, Long>{

	public List<Alerta> getAlertasByNodo(Nodo nodo);
	
	public List<Alerta> getAlertas();
}
