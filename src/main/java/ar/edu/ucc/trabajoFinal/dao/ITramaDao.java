package ar.edu.ucc.trabajoFinal.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;
import ar.edu.ucc.trabajoFinal.model.TramaUltimasPotencias;
import java.sql.Time;

public interface ITramaDao extends DaoGenerico<Trama, Long>{
	
	public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta) throws ParseException;
	
	public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta) throws ParseException;
	
	public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta) throws ParseException;
        
        public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta, 
                                                    Time horaDesde, Time horaHasta) throws ParseException;
	
	public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta, 
                                                    Time horaDesde, Time horaHasta) throws ParseException;
	
	public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta, 
                                                    Time horaDesde, Time horaHasta) throws ParseException;

	public List<Trama> getTramaByNodo(Long idNodo);

	public List<TramaPotencias> getPotenciasNodos() throws ParseException;

	public TramaPotencias getPotenciasAcumuladasParque();
        
        public List<TramaUltimasPotencias> getUltimasPotenciasPorNodos() throws ParseException;

}
