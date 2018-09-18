package ar.edu.ucc.trabajoFinal.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import ar.edu.ucc.trabajoFinal.dao.IUmbralDao;
import ar.edu.ucc.trabajoFinal.dao.UmbralDao;
import ar.edu.ucc.trabajoFinal.dto.UmbralDto;
import ar.edu.ucc.trabajoFinal.dto.UmbralEspecificoDto;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Umbral;
import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;

@Service
@Transactional
public class UmbralService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Umbral, Long> umbralDao;

	IUmbralDao umbralDaoParticular;
	
	@Autowired
	DaoGenerico<Nodo, Long> nodoDao;
	
	INodoDao nodoDaoParticular;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	@PostConstruct
	public void init() {
		umbralDaoParticular = (UmbralDao) umbralDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesGenericos() {
		log.info("Buscando todos los umbrales genericos");
		List<Umbral> umbrales = umbralDaoParticular.getUmbralesGenericos();
		return umbrales;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Umbral getUmbralGenericoByVariable(String nombreVariable){		
		Umbral umbral = umbralDaoParticular.getUmbralGenericoByVariable(nombreVariable);
		return umbral;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Umbral grabarUmbral(Umbral umbral) throws ParseException {
		log.info("Guardando: " + umbral.toString());
		umbralDaoParticular.saveOrUpdate(umbral);
		return umbral;
	}		
		
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesEspByNodo(Long idNodo) {
		return umbralDaoParticular.getUmbralesEspByNodo(idNodo);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesNodo(Long idNodo) {
		List<Umbral> umbrales = umbralDaoParticular.getUmbralesGenericos();;
		List<Umbral> umbralesEsp = umbralDaoParticular.getUmbralesEspByNodo(idNodo);
		
		List<Umbral> umbralesMerge = new ArrayList<Umbral>();

		ArrayList<String> variablesEspecificas = new ArrayList<String>();
		
		for (Umbral umbralEsp : umbralesEsp) {			
			umbralesMerge.add(umbralEsp);
			variablesEspecificas.add(umbralEsp.getNombreVariable());
		}
		for (Umbral umbral : umbrales) {
			if (!variablesEspecificas.contains(umbral.getNombreVariable())) {
				umbralesMerge.add(umbral);
			}
		}
		
		return umbralesMerge;
	}
	
}
