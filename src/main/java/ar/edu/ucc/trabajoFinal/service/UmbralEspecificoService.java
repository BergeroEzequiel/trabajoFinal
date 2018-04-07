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
import ar.edu.ucc.trabajoFinal.dao.IUmbralEspecificoDao;
import ar.edu.ucc.trabajoFinal.dao.NodoDao;
import ar.edu.ucc.trabajoFinal.dao.UmbralDao;
import ar.edu.ucc.trabajoFinal.dao.UmbralEspecificoDao;
import ar.edu.ucc.trabajoFinal.dto.UmbralEspecificoDto;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Umbral;
import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;

@Service
public class UmbralEspecificoService {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Umbral, Long> umbralDao;

	IUmbralDao umbralDaoParticular;
	
	@Autowired
	DaoGenerico<UmbralEspecifico, Long> umbralEspDao;

	IUmbralEspecificoDao umbralEspDaoParticular;
	
	@Autowired
	DaoGenerico<Nodo, Long> nodoDao;
	
	INodoDao nodoDaoParticular;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	@PostConstruct
	public void init() {
		umbralEspDaoParticular = (UmbralEspecificoDao) umbralEspDao;
		umbralDaoParticular = (UmbralDao) umbralDao;
		nodoDaoParticular = (NodoDao) nodoDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<UmbralEspecificoDto> getUmbrales(Long idNodo) {
		Nodo nodo = nodoDaoParticular.load(idNodo);
		List<Umbral> umbrales;
		List<UmbralEspecifico> umbralesEsp;
		if (nodo != null) {
			umbrales = umbralDaoParticular.getAll();
			umbralesEsp = umbralEspDaoParticular.getUmbralEspByNodo(idNodo);
		} else return new ArrayList<UmbralEspecificoDto>();

		
		List<UmbralEspecificoDto> umbralesEspDto = new ArrayList<UmbralEspecificoDto>();

		ArrayList<String> variablesEspecificas = new ArrayList<String>();
		
		UmbralEspecificoDto umbralEspDto;
		for (UmbralEspecifico umbralEsp : umbralesEsp) {
			umbralEspDto = new UmbralEspecificoDto();
			umbralEspDto.setNombreVariable(umbralEsp.getNombreVariable());
			umbralEspDto.setValorMax(umbralEsp.getValorMax());
			umbralEspDto.setValorMin(umbralEsp.getValorMin());
			umbralEspDto.setFechaUltimaModificacion(dateFormatter.format(umbralEsp.getUltimaModificacion()));
			umbralEspDto.setActivo(umbralEsp.isActivo());
			umbralEspDto.setTipo(umbralEsp.getTipo());
			umbralEspDto.setId(umbralEsp.getId());
			umbralEspDto.setIdNodo(umbralEsp.getIdNodo());
			
			umbralesEspDto.add(umbralEspDto);
			variablesEspecificas.add(umbralEsp.getNombreVariable());
		}
		for (Umbral umbral : umbrales) {
			if (!variablesEspecificas.contains(umbral.getNombreVariable())) {
				umbralEspDto = new UmbralEspecificoDto();
				umbralEspDto.setNombreVariable(umbral.getNombreVariable());
				umbralEspDto.setValorMax(umbral.getValorMax());
				umbralEspDto.setValorMin(umbral.getValorMin());
				umbralEspDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
				umbralEspDto.setActivo(umbral.isActivo());
				umbralEspDto.setTipo(umbral.getTipo());
				umbralEspDto.setId(umbral.getId());
				umbralEspDto.setIdNodo(idNodo);
				
				umbralesEspDto.add(umbralEspDto);
			}
		}
		
		return umbralesEspDto;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public UmbralEspecificoDto grabarUmbralEspecifico(UmbralEspecificoDto umbralEspDto) throws ParseException {

		log.info("Guardando: " + umbralEspDto.toString());

		UmbralEspecifico umbralEsp = new UmbralEspecifico();
		umbralEsp.setNombreVariable(umbralEspDto.getNombreVariable());
		umbralEsp.setValorMax(umbralEspDto.getValorMax());
		umbralEsp.setValorMin(umbralEspDto.getValorMin());
		umbralEsp.setUltimaModificacion(dateFormatter.parse(umbralEspDto.getFechaUltimaModificacion()));
		umbralEsp.setActivo(umbralEspDto.isActivo());
		umbralEsp.setTipo(umbralEspDto.getTipo());
		umbralEsp.setIdNodo(umbralEspDto.getIdNodo());
		
		umbralEspDaoParticular.saveOrUpdate(umbralEsp);
		umbralEspDto.setId(umbralEsp.getId());
		
		return umbralEspDto;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public UmbralEspecificoDto actualizarUmbralEspecifico(UmbralEspecificoDto umbralEspDto) throws ParseException {

		log.info("Actualizando: " + umbralEspDto.toString());

		UmbralEspecifico umbralEsp = umbralEspDaoParticular.load(umbralEspDto.getId());
		
		umbralEsp.setNombreVariable(umbralEspDto.getNombreVariable());
		umbralEsp.setValorMax(umbralEspDto.getValorMax());
		umbralEsp.setValorMin(umbralEspDto.getValorMin());
		umbralEsp.setUltimaModificacion(dateFormatter.parse(umbralEspDto.getFechaUltimaModificacion()));
		umbralEsp.setActivo(umbralEspDto.isActivo());
		umbralEsp.setTipo(umbralEspDto.getTipo());
		umbralEsp.setIdNodo(umbralEspDto.getIdNodo());
		
		umbralEspDaoParticular.saveOrUpdate(umbralEsp);
		
		return umbralEspDto;
	}
}
