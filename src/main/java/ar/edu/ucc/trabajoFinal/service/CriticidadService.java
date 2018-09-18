package ar.edu.ucc.trabajoFinal.service;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.CriticidadDao;
import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.ICriticidadDao;
import ar.edu.ucc.trabajoFinal.model.Criticidad;

@Service
@Transactional
public class CriticidadService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Criticidad, Long> criticidadDao;

	ICriticidadDao criticidadDaoParticular;
	
	@PostConstruct
	public void init() {
		criticidadDaoParticular = (CriticidadDao) criticidadDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Criticidad> getCriticidades() {

		List<Criticidad> criticidades = criticidadDaoParticular.getAll();
		return criticidades;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Criticidad grabarCriticidad(Criticidad criticidad) throws ParseException {
		log.info("Guardando: " + criticidad.toString());
		criticidadDaoParticular.saveOrUpdate(criticidad);
		return criticidad;
	}
}
	
