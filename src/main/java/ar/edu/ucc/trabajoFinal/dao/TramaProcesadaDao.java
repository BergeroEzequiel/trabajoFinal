package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.dto.TramaFiltradaDto;
import ar.edu.ucc.trabajoFinal.model.TramaFiltrada;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.TramaProcesada;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Restrictions;

@Repository
public class TramaProcesadaDao extends DaoGenericoImp<TramaProcesada, Long> implements ITramaProcesadaDao {

    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Override
    public List<TramaProcesada> getTramasProcesadasByFecha(Date fechaDesde, Date fechaHasta,
            Long idTipoProcesamiento) throws ParseException {
        List<TramaProcesada> listadoTramasProcesadas = this.getByCriteria(
                Restrictions.ge("fecha", dateFormatter.parse(dateFormatter.format(fechaDesde))),
                Restrictions.le("fecha", dateFormatter.parse(dateFormatter.format(fechaHasta))),
                idTipoProcesamiento != null
                        ? Restrictions.eq("tipoProcesamiento.id", idTipoProcesamiento)
                        : Restrictions.sqlRestriction("1 = 1"));
        return listadoTramasProcesadas;
    }

    @Override
    public List<TramaProcesada> getTramasProcesadasByHora(Time horaDesde, Time horaHasta,
            Long idTipoProcesamiento) throws ParseException {
        return this.getByCriteria(Restrictions.ge("hora", horaDesde),
                Restrictions.le("hora", horaHasta),
                Restrictions.eq("fecha", dateFormatter.parse(dateFormatter.format(new Date()))),
                idTipoProcesamiento != null
                        ? Restrictions.eq("tipoProcesamiento.id", idTipoProcesamiento)
                        : Restrictions.sqlRestriction("1 = 1"));
    }

    @Override
    public List<TramaFiltradaDto> getTramasProcesadasByTiempoAndTipoProcesamiento(
            String[] nombreVariable, Date fechaDesde, Date fechaHasta, Time horaDesde,
            Time horaHasta, Long idTipoProcesamiento, Long idNodo) throws ParseException {

        ArrayList<TramaFiltrada> listadoTramas = new ArrayList<>();
        List<TramaFiltradaDto> listadoFinal = new LinkedList<>();

        for (String variable : nombreVariable) {
            String query = "SELECT " + variable + " AS valor, hora AS hora, fecha as fecha "
                    + "FROM monitoreo_procesado "
                    + "WHERE id_nodo = :idNodo "
                    + "and id_tipo_procesamiento = :tipoProcesamiento "
                    + "and fecha >= :fechaDesde and fecha <= :fechaHasta "
                    + "and hora >= TIME(:horaDesde) and hora <= TIME(:horaHasta) "
                    + "ORDER BY hora";

            List<Object[]> listadoTramasProcesadas = this.currentSession().createSQLQuery(query)
                    .setParameter("tipoProcesamiento", idTipoProcesamiento)
                    .setParameter("idNodo", idNodo)
                    .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                    .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta)))
                    .setParameter("horaDesde", horaDesde)
                    .setParameter("horaHasta", horaHasta).list();

            for (Object[] t : listadoTramasProcesadas) {
                TramaFiltrada trama = new TramaFiltrada();
                trama.setValor((float) t[0]);
                trama.setHora(timeFormatter.format(t[1]));
                trama.setFecha(dateFormatter.format(t[2]));
                listadoTramas.add(trama);
            }
            
            listadoFinal.add(new TramaFiltradaDto(variable, (List<TramaFiltrada>) listadoTramas.clone()));
            listadoTramas.clear();

        }

        return listadoFinal;
    }

}
