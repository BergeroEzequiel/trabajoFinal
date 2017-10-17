package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
<<<<<<< HEAD

public interface ITramaDao extends DaoGenerico<Trama, Long> {
=======
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f

	public List<Trama> getTramaByNodo(int nodo);
	
	public TramaAuxiliar getTramaMaximos(Date fechaDesde, Date fechaHasta, int nodo);
	
	public TramaAuxiliar getTramaMinimos(Date fechaDesde, Date fechaHasta, int nodo);
	
	public TramaAuxiliar getTramaPromedio(Date fechaDesde, Date fechaHasta, int nodo);

}
