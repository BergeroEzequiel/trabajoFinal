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
import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IAlertaDao;
import ar.edu.ucc.trabajoFinal.model.Alerta;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

@Service
@Transactional
public class AlertaService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Alerta, Long> alertaDao;

	IAlertaDao alertaDaoParticular;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	@PostConstruct
	public void init() {
		alertaDaoParticular = (AlertaDao) alertaDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Alerta> getAlertasByNodo(Long idNodo, Date fechaDesde, Date fechaHasta) throws ParseException{		
		List<Alerta> alertas = alertaDaoParticular.getAlertasByNodo(idNodo, fechaDesde, fechaHasta);
		return alertas;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Alerta grabarAlerta(Alerta alerta) {

		log.info("Guardando: " + alerta.toString());
		alertaDaoParticular.saveOrUpdate(alerta);
		return alerta;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<Alerta> getAlertas(Time horaDesde, Time horaHasta) throws ParseException {		
		List<Alerta> alertas = this.alertaDaoParticular.getAlertas(horaDesde, horaHasta);
		return alertas;
	}
}
