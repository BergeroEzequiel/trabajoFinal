package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.AlertaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

@Repository
public class AlertaDao extends DaoGenericoImp<Alerta, Long> implements IAlertaDao {
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    //FALTA AGREGAR EL PERIODO DE TIEMPO COMO FILTRO ACA!!!
    @Override
    public List<Alerta> getAlertasByNodo(Long idNodo, Date fechaDesde, Date fechaHasta) throws ParseException{
        return this.getByCriteria(Restrictions.eq("nodo.id", idNodo),
                Restrictions.eq("visualizar", true), 
                Restrictions.ge("fecha", dateFormatter.parse(dateFormatter.format(fechaDesde))),
                Restrictions.le("fecha", dateFormatter.parse(dateFormatter.format(fechaHasta))));
    }

    
    @Override
    public List<Alerta> getAlertas(Time horaDesde, Time horaHasta) throws ParseException{
        return this.getByCriteria(Restrictions.eq("visualizar", true), 
                Restrictions.eq("visualizar", true), 
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

}
