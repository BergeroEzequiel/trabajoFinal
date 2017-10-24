package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;

public interface ITramaDao extends DaoGenerico<Trama, Long> {

	public List<Trama> getTramaByNodo(int nodo);
	
	public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta);
	
	public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta);
	
	public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta);
	
	public List<TramaPotencias> getPotenciasNodos();

}
