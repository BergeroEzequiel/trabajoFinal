package ar.edu.ucc.trabajoFinal.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.TramaProcesada;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

@Repository
public class TramaProcesadaDao extends DaoGenericoImp<TramaProcesada, Long> implements ITramaProcesadaDao{
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Override
    public List<TramaProcesada> getTramasProcesadasByFecha(Date fechaDesde, Date fechaHasta, 
                                                            Long idTipoProcesamiento) throws ParseException{
        List<TramaProcesada> listadoTramasProcesadas = this.getByCriteria(
                                Restrictions.ge("fecha", dateFormatter.parse(dateFormatter.format(fechaDesde))),
                                Restrictions.le("fecha", dateFormatter.parse(dateFormatter.format(fechaHasta))),
                                idTipoProcesamiento != null ? 
                                        Restrictions.eq("tipoProcesamiento.id", idTipoProcesamiento): 
                                        Restrictions.sqlRestriction("1 = 1"));
        return listadoTramasProcesadas;
    }

    @Override
    public List<TramaProcesada> getTramasProcesadasByHora(Time horaDesde, Time horaHasta, 
                                                            Long idTipoProcesamiento) throws ParseException{
        return this.getByCriteria(Restrictions.ge("hora", horaDesde), 
                                Restrictions.le("hora", horaHasta),
                                Restrictions.eq("fecha", dateFormatter.parse(dateFormatter.format(new Date()))),
                                idTipoProcesamiento != null ? 
                                        Restrictions.eq("tipoProcesamiento.id", idTipoProcesamiento): 
                                        Restrictions.sqlRestriction("1 = 1"));
    }

    @Override
    public List<TramaProcesada> getTramasProcesadasByTiempoAndTipoProcesamiento(
            String nombreVariable, Date fechaDesde, Date fechaHasta, Time horaDesde, 
            Time horaHasta, Long idTipoProcesamiento, Long idNodo) throws ParseException {
        
        String query = "SELECT " + nombreVariable + " "
                + "FROM monitoreo_procesado "
                + "WHERE id_nodo = :idNodo "
                + "and id_tipo_procesamiento = :tipoProcesamiento "
                + "and fecha >= :fechaDesde and fecha <= :fechaHasta "
                + "and hora >= :horaDesde and hora <= :horaHasta";
        
        
        List listadoTramasProcesadas = this.currentSession().createSQLQuery(query)
                .setParameter("tipoProcesamiento", idTipoProcesamiento)
                .setParameter("idNodo", idNodo)
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta)))
                .setParameter("horaDesde", horaDesde)
                .setParameter("horaHasta", horaHasta).list();
        
        return listadoTramasProcesadas;
    }

}
