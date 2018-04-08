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
import ar.edu.ucc.trabajoFinal.dao.IUmbralDao;
import ar.edu.ucc.trabajoFinal.dao.UmbralDao;
import ar.edu.ucc.trabajoFinal.dto.UmbralDto;
import ar.edu.ucc.trabajoFinal.model.Umbral;

@Service
@Transactional
public class UmbralService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Umbral, Long> umbralDao;

	IUmbralDao umbralDaoParticular;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	@PostConstruct
	public void init() {
		umbralDaoParticular = (UmbralDao) umbralDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public UmbralDto getUmbral(Long id) {
		
		log.info("Cargando umbral: " + id);

		Umbral umbral = umbralDaoParticular.load(id);
		UmbralDto umbralDto = new UmbralDto();
		umbralDto.setNombreVariable(umbral.getNombreVariable());
		umbralDto.setValorMax(umbral.getValorMax());
		umbralDto.setValorMin(umbral.getValorMin());
		umbralDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
		umbralDto.setActivo(umbral.isActivo());
		umbralDto.setTipo(umbral.getTipo());
		
		return umbralDto;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<UmbralDto> getUmbrales() {
		log.info("Buscando todos las tramas");

		List<Umbral> umbrales = umbralDaoParticular.getAll();
		
		List<UmbralDto> umbralesDto = new ArrayList<UmbralDto>();

		UmbralDto umbralDto;
		for (Umbral umbral : umbrales) {
			umbralDto = new UmbralDto();
			umbralDto.setNombreVariable(umbral.getNombreVariable());
			umbralDto.setValorMax(umbral.getValorMax());
			umbralDto.setValorMin(umbral.getValorMin());
			umbralDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
			umbralDto.setActivo(umbral.isActivo());
			umbralDto.setTipo(umbral.getTipo());
			umbralDto.setId(umbral.getId());
			
			umbralesDto.add(umbralDto);
		}

		return umbralesDto;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Umbral getUmbralByVariable(String nombreVariable){
		
		Umbral umbral = umbralDaoParticular.getUmbralByVariable(nombreVariable);
//		UmbralDto umbralDto = new UmbralDto();
//		umbralDto.setNombreVariable(umbral.getNombreVariable());
//		umbralDto.setValorMax(umbral.getValorMax());
//		umbralDto.setValorMin(umbral.getValorMin());
//		umbralDto.setFechaUltimaModificacion(dateFormatter.format(umbral.getUltimaModificacion()));
//		umbralDto.setActivo(umbral.isActivo());
//		umbralDto.setTipo(umbral.getTipo());
		
		return umbral;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public UmbralDto grabarUmbral(UmbralDto umbralDto) throws ParseException {

		log.info("Guardando: " + umbralDto.toString());

		Umbral umbral = new Umbral();
		umbral.setNombreVariable(umbralDto.getNombreVariable());
		umbral.setValorMax(umbralDto.getValorMax());
		umbral.setValorMin(umbralDto.getValorMin());
		umbral.setUltimaModificacion(dateFormatter.parse(umbralDto.getFechaUltimaModificacion()));
		umbral.setActivo(umbralDto.isActivo());
		umbral.setTipo(umbralDto.getTipo());
		
		umbralDaoParticular.saveOrUpdate(umbral);
		umbralDto.setId(umbral.getId());
		
		return umbralDto;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public UmbralDto actualizarUmbral(UmbralDto umbralDto) throws ParseException {

		log.info("Actualizando: " + umbralDto.toString());

		Umbral umbral = umbralDaoParticular.load(umbralDto.getId());
		
		umbral.setNombreVariable(umbralDto.getNombreVariable());
		umbral.setValorMax(umbralDto.getValorMax());
		umbral.setValorMin(umbralDto.getValorMin());
		umbral.setUltimaModificacion(dateFormatter.parse(umbralDto.getFechaUltimaModificacion()));
		umbral.setActivo(umbralDto.isActivo());
		umbral.setTipo(umbralDto.getTipo());
		
		umbralDaoParticular.saveOrUpdate(umbral);
		
		return umbralDto;
	}		
		
}
