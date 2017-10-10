package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import ar.edu.ucc.trabajoFinal.model.Trama;

public interface ITramaDao extends DaoGenerico<Trama, Long>{
	
	public List<Trama> getTramaByNodo(int nodo);
	
	public Query getTramaMaximos(Date fechaDesde, Date fechaHasta, int nodo);
	
	public Query getTramaMinimos(Date fechaDesde, Date fechaHasta, int nodo);
	
	public Query getTramaPromedio(Date fechaDesde, Date fechaHasta, int nodo);

}
