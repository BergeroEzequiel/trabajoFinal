package ar.edu.ucc.trabajoFinal.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;

public interface ITramaDao extends DaoGenerico<Trama, Long> {

	public List<Trama> getTramaByNodo(Long idNodo);

	public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta);

	public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta);

	public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta);

	public List<TramaPotencias> getPotenciasNodos() throws ParseException;

	public TramaPotencias getPotenciasAcumuladasParque();

}
