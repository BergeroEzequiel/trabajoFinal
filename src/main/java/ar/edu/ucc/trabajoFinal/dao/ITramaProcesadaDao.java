package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.TramaFiltrada;
import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaProcesada;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ITramaProcesadaDao extends DaoGenerico<TramaProcesada, Long>{
    

    /**
     * Devuelve una lista de tramas procesadas entre las dos fechas que se le pasan como parámetro.
     * @param fechaDesde
     * @param fechaHasta
     * @return List TramaProcesada
     */
    public List<TramaProcesada> getTramasProcesadasByFecha(Date fechaDesde, Date fechaHasta, Long idTipoProcesamiento) throws ParseException;

    /**
     * Recibe un rango horario (horaDesde y horaHasta). Busca todas las 
     * tramas procesadas del DIA ACTUAL que se encuentren en el rango horario.
     *
     * @param horaDesde
     * @param horaHasta
     * @return Listado de TramaProcesada
     */
    public List<TramaProcesada> getTramasProcesadasByHora(Time horaDesde, Time horaHasta, Long idTipoProcesamiento) throws ParseException;
    
    public List<TramaFiltrada> getTramasProcesadasByTiempoAndTipoProcesamiento(
            String nombreVariable, Date fechaDesde, Date fechaHasta, Time horaDesde, 
            Time horaHasta,  Long idTipoProcesamiento, Long idNodo) throws ParseException;

}
