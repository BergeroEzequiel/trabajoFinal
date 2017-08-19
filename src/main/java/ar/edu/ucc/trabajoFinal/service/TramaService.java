package ar.edu.ucc.trabajoFinal.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.ITramaDao;
import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Trama;



@Service
@Transactional
public class TramaService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Trama, Long> tramaDao;

	ITramaDao tramaDaoParticular;

	@PostConstruct
	public void init() {
		tramaDaoParticular = (TramaDao) tramaDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public TramaDto getTrama(Long id) {

		log.info("Cargando trama: " + id);

		Trama trama = tramaDaoParticular.load(id);
		
		TramaDto tramaDto = new TramaDto();
		tramaDto.setCorrienteContinua(trama.getCorrienteContinua());
		tramaDto.setCorrienteInterna(trama.getCorrienteInterna());
		tramaDto.setCorrienteRed(trama.getCorrienteRed());
		tramaDto.setDesfasaje(trama.getDesfasaje());
		tramaDto.setEstado(trama.getEstado());
		tramaDto.setFecha(trama.getFecha());
		tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
		tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
		tramaDto.setHora(trama.getHora());
		tramaDto.setHumedad(trama.getHumedad());
		tramaDto.setIpNodo(trama.getIpNodo());
		tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
		tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
		tramaDto.setPotenciaRed(trama.getPotenciaRed());
		
		//--------COMPLETAR CAMPOS ------------------------------
		return tramaDto;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<TramaDto> getTramas() {

		log.info("Buscando todos las tramas");

		List<Trama> tramas = tramaDaoParticular.getAll();
		
		List<TramaDto> tramasDto = new ArrayList<TramaDto>();

		TramaDto tramaDto;
		for (Trama trama : tramas) {
			tramaDto = new TramaDto();
			tramaDto.setCorrienteContinua(trama.getCorrienteContinua());
			tramaDto.setCorrienteInterna(trama.getCorrienteInterna());
			tramaDto.setCorrienteRed(trama.getCorrienteRed());
			tramaDto.setDesfasaje(trama.getDesfasaje());
			tramaDto.setEstado(trama.getEstado());
			tramaDto.setFecha(trama.getFecha());
			tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
			tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
			tramaDto.setHora(trama.getHora());
			tramaDto.setHumedad(trama.getHumedad());
			tramaDto.setIpNodo(trama.getIpNodo());
			tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
			tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
			tramaDto.setPotenciaRed(trama.getPotenciaRed());
			
			tramasDto.add(tramaDto);
		}

		return tramasDto;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<TramaDto> getTramasByNodo(int ipNodo){
		
		log.info("Filtrando tramas con el ipNodo: " + ipNodo);
		
		List<Trama> tramas = tramaDaoParticular.getTramaByNodo(ipNodo);
		
		List<TramaDto> tramasDto = new ArrayList<TramaDto>();
		
		TramaDto tramaDto;
		for (Trama trama : tramas) {
			tramaDto = new TramaDto();
			tramaDto.setCorrienteContinua(trama.getCorrienteContinua());
			tramaDto.setCorrienteInterna(trama.getCorrienteInterna());
			tramaDto.setCorrienteRed(trama.getCorrienteRed());
			tramaDto.setDesfasaje(trama.getDesfasaje());
			tramaDto.setEstado(trama.getEstado());
			tramaDto.setFecha(trama.getFecha());
			tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
			tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
			tramaDto.setHora(trama.getHora());
			tramaDto.setHumedad(trama.getHumedad());
			tramaDto.setIpNodo(trama.getIpNodo());
			tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
			tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
			tramaDto.setPotenciaRed(trama.getPotenciaRed());
			
			tramasDto.add(tramaDto);
		}
		return tramasDto;
		
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public TramaDto grabarTrama(TramaDto tramaDto) {

		log.info("Guardando: " + tramaDto.toString());

		Trama trama = new Trama();
		trama.setCorrienteContinua(tramaDto.getCorrienteContinua());
		trama.setCorrienteInterna(tramaDto.getCorrienteInterna());
		trama.setCorrienteRed(tramaDto.getCorrienteRed());
		trama.setDesfasaje(tramaDto.getDesfasaje());
		trama.setEstado(tramaDto.getEstado());;
		trama.setFecha(tramaDto.getFecha());
		trama.setFrecuenciaCorriente(tramaDto.getFrecuenciaCorriente());
		trama.setFrecuenciaTension(tramaDto.getFrecuenciaTension());
		trama.setHora(tramaDto.getHora());
		trama.setHumedad(tramaDto.getHumedad());
		trama.setIpNodo(tramaDto.getIpNodo());
		trama.setPotenciaContinua(tramaDto.getPotenciaContinua());
		trama.setPotenciaInterna(tramaDto.getPotenciaInterna());
		trama.setPotenciaRed(tramaDto.getPotenciaRed());
		trama.setPvm(tramaDto.getPvm());
		trama.setTemperatura1(tramaDto.getTemperatura1());
		trama.setTemperatura2(tramaDto.getTemperatura2());
		trama.setTemperatura3(tramaDto.getTemperatura3());
		trama.setTemperatura4(tramaDto.getTemperatura4());
		trama.setTemperatura5(tramaDto.getTemperatura5());
		trama.setTensionContinua(tramaDto.getTensionContinua());
		trama.setTensionInterna(tramaDto.getTensionInterna());
		trama.setTensionRed(tramaDto.getTensionRed());
		trama.setTensionTierra(tramaDto.getTensionTierra());
		
		tramaDaoParticular.saveOrUpdate(trama);
		tramaDto.setId(trama.getId());		

		return tramaDto;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public TramaDto actualizarTrama(TramaDto tramaDto) {

		log.info("Actualizando: " + tramaDto.toString());

		Trama trama = tramaDaoParticular.load(tramaDto.getId());
		
		trama.setCorrienteContinua(tramaDto.getCorrienteContinua());
		trama.setCorrienteInterna(tramaDto.getCorrienteInterna());
		trama.setCorrienteRed(tramaDto.getCorrienteRed());
		trama.setDesfasaje(tramaDto.getDesfasaje());
		trama.setEstado(tramaDto.getEstado());;
		trama.setFecha(tramaDto.getFecha());
		trama.setFrecuenciaCorriente(tramaDto.getFrecuenciaCorriente());
		trama.setFrecuenciaTension(tramaDto.getFrecuenciaTension());
		trama.setHora(tramaDto.getHora());
		trama.setHumedad(tramaDto.getHumedad());
		trama.setIpNodo(tramaDto.getIpNodo());
		trama.setPotenciaContinua(tramaDto.getPotenciaContinua());
		trama.setPotenciaInterna(tramaDto.getPotenciaInterna());
		trama.setPotenciaRed(tramaDto.getPotenciaRed());
		trama.setPvm(tramaDto.getPvm());
		trama.setTemperatura1(tramaDto.getTemperatura1());
		trama.setTemperatura2(tramaDto.getTemperatura2());
		trama.setTemperatura3(tramaDto.getTemperatura3());
		trama.setTemperatura4(tramaDto.getTemperatura4());
		trama.setTemperatura5(tramaDto.getTemperatura5());
		trama.setTensionContinua(tramaDto.getTensionContinua());
		trama.setTensionInterna(tramaDto.getTensionInterna());
		trama.setTensionRed(tramaDto.getTensionRed());
		trama.setTensionTierra(tramaDto.getTensionTierra());
		
		tramaDaoParticular.saveOrUpdate(trama);
		
		return tramaDto;
	}

}
