package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Alerta;

public interface IAlertaDao extends DaoGenerico<Alerta, Long>{

	public List<Alerta> getAlertasByNodo(int nodo);
}
