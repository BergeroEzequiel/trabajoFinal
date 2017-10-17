package ar.edu.ucc.trabajoFinal.service;

import java.sql.Time;
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
import ar.edu.ucc.trabajoFinal.dao.ITramaDao;
import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Trama;
<<<<<<< HEAD
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ar.edu.ucc.trabajoFinal.utils.TramaControl;
=======
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
import ar.edu.ucc.trabajoFinal.utils.TramaControlHandler;

@Service
@Transactional
public class TramaService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Trama, Long> tramaDao;

	ITramaDao tramaDaoParticular;
<<<<<<< HEAD

	TramaControl tramaControl;

	// Para hacer el control asincrono
	ExecutorService pool = Executors.newCachedThreadPool();
=======
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f

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
		tramaDto.setIpNodo(trama.getIpNodo());
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
			tramaDto.setIpNodo(trama.getIpNodo());
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
	public List<TramaDto> getTramasByNodo(int ipNodo) {

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
			tramaDto.setFecha(dateFormatter.format(trama.getFecha()));
			tramaDto.setFrecuenciaCorriente(trama.getFrecuenciaCorriente());
			tramaDto.setFrecuenciaTension(trama.getFrecuenciaTension());
			tramaDto.setHora(timeFormatter.format(trama.getHora()));
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
<<<<<<< HEAD
		tramaDto.setId(trama.getId());

		// Controlar de forma asincrona
		TramaControlHandler tch = new TramaControlHandler();
		tch.encolarTrama(tramaDto);
		pool.execute(tch);

=======
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
		return tramaDto;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public TramaDto actualizarTrama(TramaDto tramaDto) throws ParseException {

		log.info("Actualizando: " + tramaDto.toString());

		Trama trama = tramaDaoParticular.load(tramaDto.getId());

		trama.setCorrienteContinua(tramaDto.getCorrienteContinua());
		trama.setCorrienteInterna(tramaDto.getCorrienteInterna());
		trama.setCorrienteRed(tramaDto.getCorrienteRed());
		trama.setDesfasaje(tramaDto.getDesfasaje());
		trama.setEstado(tramaDto.getEstado());
		trama.setFecha(dateFormatter.parse(tramaDto.getFecha()));
		trama.setFrecuenciaCorriente(tramaDto.getFrecuenciaCorriente());
		trama.setFrecuenciaTension(tramaDto.getFrecuenciaTension());
		trama.setHora(new Time(timeFormatter.parse(tramaDto.getHora()).getTime()));
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

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public TramaDto getTramaPromedios(Date fechaDesde, Date fechaHasta, int nodo) {
		
		TramaAuxiliar tramaAuxPromedios = tramaDaoParticular.getTramaMaximos(fechaDesde, fechaHasta, nodo);
		TramaDto tramaDto = new TramaDto();
		tramaDto.setCorrienteContinua(tramaAuxPromedios.getCorrienteContinua());
		tramaDto.setCorrienteInterna(tramaAuxPromedios.getCorrienteInterna());
		tramaDto.setCorrienteRed(tramaAuxPromedios.getCorrienteRed());
		tramaDto.setDesfasaje(tramaAuxPromedios.getDesfasaje());
		tramaDto.setFrecuenciaCorriente(tramaAuxPromedios.getFrecuenciaCorriente());
		tramaDto.setFrecuenciaTension(tramaAuxPromedios.getFrecuenciaTension());
		tramaDto.setHumedad(tramaAuxPromedios.getHumedad());
		tramaDto.setPotenciaContinua(tramaAuxPromedios.getPotenciaContinua());
		tramaDto.setPotenciaInterna(tramaAuxPromedios.getPotenciaInterna());
		tramaDto.setPotenciaRed(tramaAuxPromedios.getPotenciaRed());
		tramaDto.setPvm(tramaAuxPromedios.getPvm());
		tramaDto.setTemperatura1(tramaAuxPromedios.getTemperatura1());
		tramaDto.setTemperatura2(tramaAuxPromedios.getTemperatura2());
		tramaDto.setTemperatura3(tramaAuxPromedios.getTemperatura3());
		tramaDto.setTemperatura4(tramaAuxPromedios.getTemperatura4());
		tramaDto.setTemperatura5(tramaAuxPromedios.getTemperatura5());
		tramaDto.setTensionContinua(tramaAuxPromedios.getTensionContinua());
		tramaDto.setTensionInterna(tramaAuxPromedios.getTensionInterna());
		tramaDto.setTensionRed(tramaAuxPromedios.getTensionRed());
		tramaDto.setTensionTierra(tramaAuxPromedios.getTensionTierra());

		return tramaDto;

	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public TramaDto getTramaMaximos(Date fechaDesde, Date fechaHasta, int nodo) {
		
		TramaAuxiliar tramaAuxMaximos = tramaDaoParticular.getTramaMaximos(fechaDesde, fechaHasta, nodo);
		this.log.info(tramaAuxMaximos.getCorrienteRed());
		TramaDto tramaDto = new TramaDto();
		tramaDto.setCorrienteContinua(tramaAuxMaximos.getCorrienteContinua());
		tramaDto.setCorrienteInterna(tramaAuxMaximos.getCorrienteInterna());
		tramaDto.setCorrienteRed(tramaAuxMaximos.getCorrienteRed());
		tramaDto.setDesfasaje(tramaAuxMaximos.getDesfasaje());
		tramaDto.setFrecuenciaCorriente(tramaAuxMaximos.getFrecuenciaCorriente());
		tramaDto.setFrecuenciaTension(tramaAuxMaximos.getFrecuenciaTension());
		tramaDto.setHumedad(tramaAuxMaximos.getHumedad());
		tramaDto.setPotenciaContinua(tramaAuxMaximos.getPotenciaContinua());
		tramaDto.setPotenciaInterna(tramaAuxMaximos.getPotenciaInterna());
		tramaDto.setPotenciaRed(tramaAuxMaximos.getPotenciaRed());
		tramaDto.setPvm(tramaAuxMaximos.getPvm());
		tramaDto.setTemperatura1(tramaAuxMaximos.getTemperatura1());
		tramaDto.setTemperatura2(tramaAuxMaximos.getTemperatura2());
		tramaDto.setTemperatura3(tramaAuxMaximos.getTemperatura3());
		tramaDto.setTemperatura4(tramaAuxMaximos.getTemperatura4());
		tramaDto.setTemperatura5(tramaAuxMaximos.getTemperatura5());
		tramaDto.setTensionContinua(tramaAuxMaximos.getTensionContinua());
		tramaDto.setTensionInterna(tramaAuxMaximos.getTensionInterna());
		tramaDto.setTensionRed(tramaAuxMaximos.getTensionRed());
		tramaDto.setTensionTierra(tramaAuxMaximos.getTensionTierra());

		return tramaDto;

	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public TramaDto getTramaMinimos(Date fechaDesde, Date fechaHasta, int nodo) {
		
		TramaAuxiliar tramaAuxMinimos = tramaDaoParticular.getTramaMaximos(fechaDesde, fechaHasta, nodo);
		TramaDto tramaDto = new TramaDto();
		tramaDto.setCorrienteContinua(tramaAuxMinimos.getCorrienteContinua());
		tramaDto.setCorrienteInterna(tramaAuxMinimos.getCorrienteInterna());
		tramaDto.setCorrienteRed(tramaAuxMinimos.getCorrienteRed());
		tramaDto.setDesfasaje(tramaAuxMinimos.getDesfasaje());
		tramaDto.setFrecuenciaCorriente(tramaAuxMinimos.getFrecuenciaCorriente());
		tramaDto.setFrecuenciaTension(tramaAuxMinimos.getFrecuenciaTension());
		tramaDto.setHumedad(tramaAuxMinimos.getHumedad());
		tramaDto.setPotenciaContinua(tramaAuxMinimos.getPotenciaContinua());
		tramaDto.setPotenciaInterna(tramaAuxMinimos.getPotenciaInterna());
		tramaDto.setPotenciaRed(tramaAuxMinimos.getPotenciaRed());
		tramaDto.setPvm(tramaAuxMinimos.getPvm());
		tramaDto.setTemperatura1(tramaAuxMinimos.getTemperatura1());
		tramaDto.setTemperatura2(tramaAuxMinimos.getTemperatura2());
		tramaDto.setTemperatura3(tramaAuxMinimos.getTemperatura3());
		tramaDto.setTemperatura4(tramaAuxMinimos.getTemperatura4());
		tramaDto.setTemperatura5(tramaAuxMinimos.getTemperatura5());
		tramaDto.setTensionContinua(tramaAuxMinimos.getTensionContinua());
		tramaDto.setTensionInterna(tramaAuxMinimos.getTensionInterna());
		tramaDto.setTensionRed(tramaAuxMinimos.getTensionRed());
		tramaDto.setTensionTierra(tramaAuxMinimos.getTensionTierra());

		return tramaDto;

	}

}
