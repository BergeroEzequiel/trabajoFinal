package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.utils.Hora;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.AlertaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import ar.edu.ucc.trabajoFinal.utils.Fecha;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

@Repository
public class AlertaDao extends DaoGenericoImp<Alerta, Long> implements IAlertaDao {
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Override
    public List<Alerta> getAlertasByFecha(String fechaDesde, String fechaHasta, Long idNodo, Criticidad criticidad) throws ParseException{
        Calendar c = Calendar.getInstance();
        c.setTime(dateFormatter.parse(fechaHasta));
        c.add(Calendar.DATE, 1);
        return this.getByCriteria(
                idNodo != null? Restrictions.eq("nodo.id", idNodo) : Restrictions.sqlRestriction("1 = 1"),
                Restrictions.eq("visualizar", true),
                criticidad != null? Restrictions.eq("criticidad", criticidad) : Restrictions.sqlRestriction("1 = 1"),
                Restrictions.ge("fecha", dateFormatter.parse(fechaDesde)),
                Restrictions.lt("fecha", dateFormatter.parse(dateFormatter.format(c.getTime()))));
    }

    
    @Override
    public List<Alerta> getAlertas(Time horaDesde, Time horaHasta, Criticidad criticidad) throws ParseException{
        return this.getByCriteria( 
                Restrictions.eq("visualizar", true),
                criticidad != null ? Restrictions.eq("criticidad.id", criticidad.getId()): Restrictions.sqlRestriction("1 = 1"),
                Restrictions.ge("hora", horaDesde), 
                Restrictions.le("hora", horaHasta),
                Restrictions.eq("fecha", dateFormatter.parse(dateFormatter.format(new Date()))));
    }

    @Override
    public List<AlertaAuxiliar> getAlertasAMostrar(Time horaDesde, Time horaHasta, 
                                                    Criticidad criticidad) {
        try {
            //Ponemos fecha menor igual x q el formatter termina generando algo como 2018-05-31 00:00:00
            List list = ((Query) this.currentSession()
                .createQuery("select nodo.id AS nodo, variableAfectada AS variableAfectada, COUNT(distinct id) AS cantidadRepeticiones "
                        + "from Alerta "
                        + "where fecha >= :fechaActual and hora >= :horaDesde and hora <= :horaHasta "
                        + "and criticidad.id = :criticidad and visualizar = false "  
                        + "GROUP BY nodo, variableAfectada "
                        + "ORDER BY nodo "))
                .setParameter("horaDesde", horaDesde)
                .setParameter("horaHasta", horaHasta)
                .setParameter("fechaActual", dateFormatter.parse(dateFormatter.format(new Date())))
                .setParameter("criticidad", criticidad.getId())
                .setResultTransformer(Transformers.aliasToBean(AlertaAuxiliar.class)).list();
            System.out.println(dateFormatter.parse(dateFormatter.format(new Date())));
            return list;
        } catch (Exception e) {
            System.out.println("SE ROMPIO LA QUERY");
            return null;
        }
    }

    @Override
    public List<Alerta> getDetalleAlerta(Alerta alerta) {
        Time horaDesde = null;
        switch (alerta.getCriticidad().getPrioridad()) {
            case "Critica":
                horaDesde = Hora.restarMinutos(alerta.getHora(), 2);
                break;
            case "Alta":
                horaDesde = Hora.restarMinutos(alerta.getHora(), 10);
                break;
            case "Media":
                horaDesde = Hora.restarMinutos(alerta.getHora(), 30);
                break;
            case "Baja":
                horaDesde = Hora.restarMinutos(alerta.getHora(), 60);
                break;
            default:
                horaDesde = null;
        }
        return this.getByCriteria(
            Restrictions.eq("visualizar", false),
            Restrictions.eq("criticidad", alerta.getCriticidad()),
            Restrictions.eq("nodo", alerta.getNodo()),
            Restrictions.eq("variableAfectada", alerta.getVariableAfectada()),
            Restrictions.eq("fecha", alerta.getFecha()),
            Restrictions.le("hora", alerta.getHora()),
            Restrictions.ge("hora", horaDesde));

    }

}
