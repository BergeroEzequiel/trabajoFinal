package ar.edu.ucc.trabajoFinal.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.INodoDao;
import ar.edu.ucc.trabajoFinal.dao.NodoDao;
import ar.edu.ucc.trabajoFinal.dto.NodoDto;
import ar.edu.ucc.trabajoFinal.model.Nodo;

@Service
@Transactional
public class NodoService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Nodo, Long> nodoDao;

	INodoDao nodoDaoParticular;
	
	@PostConstruct
	public void init() {
		nodoDaoParticular = (NodoDao) nodoDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Nodo getNodo(Long id) {
		Nodo nodo = nodoDaoParticular.load(id);
		return nodo;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Nodo> getNodos() {
		List<Nodo> nodos = nodoDaoParticular.getAll();
		return nodos;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Nodo> getNodosActivos() {
		List<Nodo> nodos = nodoDaoParticular.getNodosActivos();
		return nodos;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Nodo grabarNodo(Nodo nodo) throws ParseException {
		log.info("Guardando: " + nodo.toString());		
		nodoDaoParticular.saveOrUpdate(nodo);
		return nodo;
	}
	
}
