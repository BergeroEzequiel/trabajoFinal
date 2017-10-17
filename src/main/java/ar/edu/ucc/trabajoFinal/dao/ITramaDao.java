package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;

public interface ITramaDao extends DaoGenerico<Trama, Long> {

	public List<Trama> getTramaByNodo(int nodo);

	public TramaAuxiliar getTramaMaximos(Date fechaDesde, Date fechaHasta, int nodo);

	public TramaAuxiliar getTramaMinimos(Date fechaDesde, Date fechaHasta, int nodo);

	public TramaAuxiliar getTramaPromedio(Date fechaDesde, Date fechaHasta, int nodo);

}
