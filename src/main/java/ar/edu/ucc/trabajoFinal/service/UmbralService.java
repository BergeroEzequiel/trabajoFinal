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
	
//	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
//	public UmbralDto getUmbral(Long id) {
//		
//		log.info("Cargando umbral: " + id);
//
//		Umbral umbral = umbralDaoParticular.load(id);
//		UmbralDto umbralDto = new UmbralDto();
//		umbralDto.setNombreVariable(umbral.getNombreVariable());
//		umbralDto.setValorMax(umbral.getValorMax());
//		umbralDto.setValorMin(umbral.getValorMin());
//		umbralDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
//		umbralDto.setActivo(umbral.isActivo());
//		umbralDto.setTipo(umbral.getTipo());
//		
//		return umbralDto;
//	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesGenericos() {
		log.info("Buscando todos las tramas");

		List<Umbral> umbrales = umbralDaoParticular.getUmbralesGenericos();
		
//		List<UmbralDto> umbralesDto = new ArrayList<UmbralDto>();

//		UmbralDto umbralDto;
//		for (Umbral umbral : umbrales) {
//			umbralDto = new UmbralDto();
//			umbralDto.setNombreVariable(umbral.getNombreVariable());
//			umbralDto.setValorMax(umbral.getValorMax());
//			umbralDto.setValorMin(umbral.getValorMin());
//			umbralDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
//			umbralDto.setActivo(umbral.isActivo());
//			umbralDto.setTipo(umbral.getTipo());
//			umbralDto.setId(umbral.getId());
//			
//			umbralesDto.add(umbralDto);
//		}

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

//		Umbral umbral = new Umbral();
//		umbral.setNombreVariable(umbralDto.getNombreVariable());
//		umbral.setValorMax(umbralDto.getValorMax());
//		umbral.setValorMin(umbralDto.getValorMin());
//		umbral.setUltimaModificacion(dateFormatter.parse(umbralDto.getFechaUltimaModificacion()));
//		umbral.setActivo(umbralDto.isActivo());
//		umbral.setTipo(umbralDto.getTipo());
		
		umbralDaoParticular.saveOrUpdate(umbral);
		
		return umbral;
	}
	
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
//	public Umbral actualizarUmbral(Umbral umbral) throws ParseException {
//
//		log.info("Actualizando: " + umbral.toString());
//
//		Umbral umbralDto = umbralDaoParticular.load(umbral.getId());
//		
////		umbral.setNombreVariable(umbralDto.getNombreVariable());
////		umbral.setValorMax(umbralDto.getValorMax());
////		umbral.setValorMin(umbralDto.getValorMin());
////		umbral.setUltimaModificacion(dateFormatter.parse(umbralDto.getFechaUltimaModificacion()));
////		umbral.setActivo(umbralDto.isActivo());
////		umbral.setTipo(umbralDto.getTipo());
//		
//		umbralDaoParticular.saveOrUpdate(umbral);
//		
//		return umbral;
//	}		
		
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesEspByNodo(Nodo nodo) {
//		Nodo nodo = nodoDaoParticular.load(idNodo);
//		if (nodo != null) {
			return umbralDaoParticular.getUmbralesEspByNodo(nodo);
//		} else return new ArrayList<Umbral>();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesNodo(Long idNodo) {
		Nodo nodo = nodoDaoParticular.load(idNodo);
		List<Umbral> umbrales;
		List<Umbral> umbralesEsp;
		if (nodo != null) {
			umbrales = umbralDaoParticular.getUmbralesGenericos();
			umbralesEsp = umbralDaoParticular.getUmbralesEspByNodo(nodo);
		} else return new ArrayList<Umbral>();

		
		List<Umbral> umbralesMerge = new ArrayList<Umbral>();

		ArrayList<String> variablesEspecificas = new ArrayList<String>();
		
		UmbralEspecificoDto umbralEspDto;
		for (Umbral umbralEsp : umbralesEsp) {
//			umbralEspDto = new UmbralEspecificoDto();
//			umbralEspDto.setNombreVariable(umbralEsp.getNombreVariable());
//			umbralEspDto.setValorMax(umbralEsp.getValorMax());
//			umbralEspDto.setValorMin(umbralEsp.getValorMin());
//			umbralEspDto.setFechaUltimaModificacion(dateFormatter.format(umbralEsp.getUltimaModificacion()));
//			umbralEspDto.setActivo(umbralEsp.isActivo());
//			umbralEspDto.setTipo(umbralEsp.getTipo());
//			umbralEspDto.setId(umbralEsp.getId());
//			umbralEspDto.setIdNodo(umbralEsp.getIdNodo());
			
			umbralesMerge.add(umbralEsp);
			variablesEspecificas.add(umbralEsp.getNombreVariable());
		}
		for (Umbral umbral : umbrales) {
			if (!variablesEspecificas.contains(umbral.getNombreVariable())) {
//				umbralEspDto = new UmbralEspecificoDto();
//				umbralEspDto.setNombreVariable(umbral.getNombreVariable());
//				umbralEspDto.setValorMax(umbral.getValorMax());
//				umbralEspDto.setValorMin(umbral.getValorMin());
//				umbralEspDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
//				umbralEspDto.setActivo(umbral.isActivo());
//				umbralEspDto.setTipo(umbral.getTipo());
//				umbralEspDto.setId(umbral.getId());
//				umbralEspDto.setIdNodo(idNodo);
				
				umbralesMerge.add(umbral);
			}
		}
		
		return umbralesMerge;
	}
	
}
