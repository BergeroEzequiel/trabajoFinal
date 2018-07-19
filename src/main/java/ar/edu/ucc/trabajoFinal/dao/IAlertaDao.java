package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.AlertaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

public interface IAlertaDao extends DaoGenerico<Alerta, Long> {

    /**
     * Busca todas las alertas a visualizar de un determinado nodo y 
     * en un rango de fechas determinado.
     * @param idNodo
     * @return listadoDeAlertas
     */
    public List<Alerta> getAlertasByNodo(Long idNodo, Date fechaDesde, Date fechaHasta, Criticidad criticidad) throws ParseException;

    /**
     * Recibe un rango horario (horaDesde y horaHasta) y una Criticidad. Busca todas las alertas
     * a visualizar de el DIA ACTUAL con esa criticidad y en ese rango horario.
     *
     * @param horaDesde
     * @param horaHasta
     * @param criticidad
     * @return listadoDeAlertas
     * @throws java.text.ParseException
     */
    public List<Alerta> getAlertas(Time horaDesde, Time horaHasta, Criticidad criticidad) throws ParseException;

    public List<AlertaAuxiliar> getAlertasAMostrar(Time horaDesde, Time horaHasta,
            Criticidad criticidad);
}
