package ar.edu.ucc.trabajoFinal.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.AlertaDao;
import ar.edu.ucc.trabajoFinal.dao.CriticidadDao;
import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IAlertaDao;
import ar.edu.ucc.trabajoFinal.dao.ICriticidadDao;
import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class AlertaService {

    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    DaoGenerico<Alerta, Long> alertaDao;

    @Autowired
    DaoGenerico<Criticidad, Long> criticidadDao;

    IAlertaDao alertaDaoParticular;
    ICriticidadDao criticidadDaoParticular;

    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @PostConstruct
    public void init() {
        alertaDaoParticular = (AlertaDao) alertaDao;
        criticidadDaoParticular = (CriticidadDao) criticidadDao;

    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Alerta> getAlertasByFecha(String fechaDesde, String fechaHasta, Long idNodo, String prioridad) throws ParseException {
        Criticidad criticidad = null;
        if(prioridad != null && !prioridad.isEmpty())
            criticidad = this.criticidadDaoParticular.getCriticidadByPrioridad(prioridad);
        List<Alerta> alertas = alertaDaoParticular.getAlertasByFecha(fechaDesde, fechaHasta, idNodo, criticidad);
        return alertas;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Alerta grabarAlerta(Alerta alerta) {

        log.info("Guardando: " + alerta.toString());
        alertaDaoParticular.saveOrUpdate(alerta);
        return alerta;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<Alerta> getAlertas(Time horaDesde, Time horaHasta, String prioridad) throws ParseException {
        Criticidad criticidad = null;
        if(prioridad != null && !prioridad.isEmpty())
            criticidad = this.criticidadDaoParticular.getCriticidadByPrioridad(prioridad);
        List<Alerta> alertas = this.alertaDaoParticular.getAlertas(horaDesde, horaHasta, criticidad);
        return alertas;
    }
}
