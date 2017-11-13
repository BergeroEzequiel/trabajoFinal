package ar.edu.ucc.trabajoFinal.service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;
import ar.edu.ucc.trabajoFinal.utils.TramaControl;

@Service
@Transactional
public class TramaService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Trama, Long> tramaDao;

	ITramaDao tramaDaoParticular;

	TramaControl tramaControl;

	// Para hacer el control asincrono
	ExecutorService pool = Executors.newCachedThreadPool();

	@PostConstruct
	public void init() {
		tramaDaoParticular = (TramaDao) tramaDao;
	}

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	// String -> Date
	// SimpleDateFormat.parse(String);

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public TramaDto getTrama(Long id) {

		log.info("Cargando trama: " + id);

		Trama trama = tramaDaoParticular.load(id);

		log.info("trama cargada:" + trama.toString());

		TramaDto tramaDto = new TramaDto();
		tramaDto.setId(trama.getId());
		tramaDto.setCorrienteContinua(trama.getCorrienteContinua());
		tramaDto.setCorrienteInterna(trama.getCorrienteInterna());
		tramaDto.setCorrienteRed(trama.getCorrienteRed());
		tramaDto.setDesfasaje(trama.getDesfasaje());
		tramaDto.setEstado(trama.getEstado());
		tramaDto.setFecha(dateFormatter.format(trama.getFecha()));
		tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
		tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
		tramaDto.setHora(timeFormatter.format(trama.getHora()));
		tramaDto.setHumedad(trama.getHumedad());
		tramaDto.setModulo(trama.getModulo());
		tramaDto.setNumero(trama.getNumero());
		tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
		tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
		tramaDto.setPotenciaRed(trama.getPotenciaRed());
		tramaDto.setPvm(trama.getPvm());
		tramaDto.setTemperatura1(trama.getTemperatura1());
		tramaDto.setTemperatura2(trama.getTemperatura2());
		tramaDto.setTemperatura3(trama.getTemperatura3());
		tramaDto.setTemperatura4(trama.getTemperatura4());
		tramaDto.setTemperatura5(trama.getTemperatura5());
		tramaDto.setTensionContinua(trama.getTensionContinua());
		tramaDto.setTensionInterna(trama.getTensionInterna());
		tramaDto.setTensionRed(trama.getTensionRed());
		tramaDto.setTensionTierra(trama.getTensionTierra());

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
			tramaDto.setId(trama.getId());
			tramaDto.setCorrienteContinua(trama.getCorrienteContinua());
			tramaDto.setCorrienteInterna(trama.getCorrienteInterna());
			tramaDto.setCorrienteRed(trama.getCorrienteRed());
			tramaDto.setDesfasaje(trama.getDesfasaje());
			tramaDto.setEstado(trama.getEstado());
			tramaDto.setFecha(dateFormatter.format((trama.getFecha())));
			tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
			tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
			tramaDto.setHora(timeFormatter.format((trama.getHora())));
			tramaDto.setHumedad(trama.getHumedad());
			tramaDto.setModulo(trama.getModulo());
			tramaDto.setNumero(trama.getNumero());
			tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
			tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
			tramaDto.setPotenciaRed(trama.getPotenciaRed());
			tramaDto.setPvm(trama.getPvm());
			tramaDto.setTemperatura1(trama.getTemperatura1());
			tramaDto.setTemperatura2(trama.getTemperatura2());
			tramaDto.setTemperatura3(trama.getTemperatura3());
			tramaDto.setTemperatura4(trama.getTemperatura4());
			tramaDto.setTemperatura5(trama.getTemperatura5());
			tramaDto.setTensionContinua(trama.getTensionContinua());
			tramaDto.setTensionInterna(trama.getTensionInterna());
			tramaDto.setTensionRed(trama.getTensionRed());
			tramaDto.setTensionTierra(trama.getTensionTierra());

			tramasDto.add(tramaDto);
		}

		return tramasDto;
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<TramaDto> getTramasByNumero(int numero){
		
		log.info("Filtrando tramas del modulo Solar con el numero: " + numero);
		
		List<Trama> tramas = tramaDaoParticular.getTramaByNumero(numero);
		

		List<TramaDto> tramasDto = new ArrayList<TramaDto>();

		TramaDto tramaDto;
		for (Trama trama : tramas) {
			tramaDto = new TramaDto();
			tramaDto.setCorrienteContinua(trama.getCorrienteContinua());
			tramaDto.setCorrienteInterna(trama.getCorrienteInterna());
			tramaDto.setCorrienteRed(trama.getCorrienteRed());
			tramaDto.setDesfasaje(trama.getDesfasaje());
			tramaDto.setEstado(trama.getEstado());
			tramaDto.setFecha(dateFormatter.format(trama.getFecha()));
			tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
			tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
			tramaDto.setHora(timeFormatter.format(trama.getHora()));
			tramaDto.setHumedad(trama.getHumedad());
			tramaDto.setModulo(trama.getModulo());
			tramaDto.setNumero(trama.getNumero());
			tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
			tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
			tramaDto.setPotenciaRed(trama.getPotenciaRed());

			tramasDto.add(tramaDto);
		}
		return tramasDto;

	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public TramaDto grabarTrama(TramaDto tramaDto) throws ParseException {

		log.info("Guardando: " + tramaDto.toString());

		Trama trama = new Trama();
		trama.setCorrienteContinua(tramaDto.getCorrienteContinua());
		trama.setCorrienteInterna(tramaDto.getCorrienteInterna());
		trama.setCorrienteRed(tramaDto.getCorrienteRed());
		trama.setDesfasaje(tramaDto.getDesfasaje());
		trama.setEstado(tramaDto.getEstado());
		;
		trama.setFecha(dateFormatter.parse(tramaDto.getFecha()));
		trama.setFrecuenciaCorriente(tramaDto.getFrecuenciaCorriente());
		trama.setFrecuenciaTension(tramaDto.getFrecuenciaTension());
		trama.setHora(Time.valueOf(tramaDto.getHora()));
		trama.setHumedad(tramaDto.getHumedad());
		trama.setModulo(tramaDto.getModulo());
		trama.setNumero(tramaDto.getNumero());
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
		trama.setEstadoControl(tramaDto.getEstadoControl());
		trama.setPotenciaContinua(trama.calcularPotenciaContinua());
		trama.setPotenciaInterna(trama.calcularPotenciaInterna());
		trama.setPotenciaRed(trama.calcularPotenciaRed());
		
		tramaDaoParticular.saveOrUpdate(trama);
		tramaDto.setId(trama.getId());	
		tramaDto.setPotenciaContinua(trama.getPotenciaContinua());
		tramaDto.setPotenciaInterna(trama.getPotenciaInterna());
		tramaDto.setPotenciaRed(trama.getPotenciaRed());
		
		//this.controlarTrama(tramaDto);
		return tramaDto;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public TramaDto actualizarEstadoControlTrama(TramaDto tramaDto) throws ParseException {

		log.info("Actualizando: " + tramaDto.toString());

		Trama trama = tramaDaoParticular.load(tramaDto.getId());
		trama.setEstadoControl(tramaDto.getEstadoControl());		

		tramaDaoParticular.saveOrUpdate(trama);

		return tramaDto;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<TramaDto> getPotenciasNodos() throws ParseException{
		
		log.info("Obteniendo valores de las 3 potencias de cada nodo...");
		List<TramaPotencias> tramasPotencias = tramaDaoParticular.getPotenciasNodos();
		System.out.println(tramasPotencias.size());
		TramaDto tramaDto;
		List<TramaDto> tramasDto = new ArrayList<TramaDto>();
		
		for (TramaPotencias tramaPotencia : tramasPotencias) {
			log.info(tramaPotencia.toString());
			tramaDto = new TramaDto();
			tramaDto.setPotenciaContinua(tramaPotencia.getPotenciaContinua());
			tramaDto.setPotenciaInterna(tramaPotencia.getPotenciaInterna());
			tramaDto.setPotenciaRed(tramaPotencia.getPotenciaRed());
			tramaDto.setNumero(tramaPotencia.getNumero());
			tramaDto.setHora(timeFormatter.format(tramaPotencia.getHora()));
			
			tramasDto.add(tramaDto);
			
		}
						
		return tramasDto;
		
	}

}
