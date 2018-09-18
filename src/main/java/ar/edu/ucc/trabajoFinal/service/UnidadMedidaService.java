package ar.edu.ucc.trabajoFinal.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IUnidadMedidaDao;
import ar.edu.ucc.trabajoFinal.dao.UnidadMedidaDao;
import ar.edu.ucc.trabajoFinal.model.UnidadMedida;

@Service
@Transactional
public class UnidadMedidaService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<UnidadMedida, Long> umDao;

	IUnidadMedidaDao umDaoParticular;
	
	@PostConstruct
	public void init() {
		umDaoParticular = (UnidadMedidaDao) umDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<UnidadMedida> getUnidadesMedida() {

		List<UnidadMedida> medidas = umDaoParticular.getAll();
		return medidas;
	}
}
	
