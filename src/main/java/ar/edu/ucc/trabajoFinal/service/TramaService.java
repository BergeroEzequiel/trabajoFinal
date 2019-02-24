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
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;
import ar.edu.ucc.trabajoFinal.model.TramaUltimasPotencias;
import ar.edu.ucc.trabajoFinal.utils.Hora;
import ar.edu.ucc.trabajoFinal.utils.NodoMapper;
import ar.edu.ucc.trabajoFinal.utils.TramaControl;
import java.util.Date;

@Service
@Transactional
public class TramaService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Trama, Long> tramaDao;

	ITramaDao tramaDaoParticular;

	TramaControl tramaControl;

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
//		tramaDto.setModulo(trama.getModulo());
//		tramaDto.setNodo(trama.getNodo());
		tramaDto.setNodo(trama.getNodo());
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
	public List<Trama> getTramas() {

		log.info("Buscando todos las tramas");

		List<Trama> tramas = tramaDaoParticular.getAll();

		return tramas;
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<TramaDto> getTramasByNodo(Long idNodo){
		
		log.info("Filtrando tramas del modulo Solar con el nodo: " + idNodo);
		
		List<Trama> tramas = tramaDaoParticular.getTramaByNodo(idNodo);
		

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
//			tramaDto.setModulo(trama.getModulo());
//			tramaDto.setNodo(trama.getNodo());
			tramaDto.setNodo(trama.getNodo());
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

		Nodo nodo = NodoMapper.getInstance().getMappedNodos().get(tramaDto.getModulo() + tramaDto.getNumero());
		if (nodo == null) {
			return new TramaDto();
		}
		trama.setNodo(nodo);
		tramaDto.setNodo(nodo);
		trama.setCorrienteContinua(tramaDto.getCorrienteContinua());
		trama.setCorrienteInterna(tramaDto.getCorrienteInterna());
		trama.setCorrienteRed(tramaDto.getCorrienteRed());
		trama.setDesfasaje(tramaDto.getDesfasaje());
		trama.setEstado(tramaDto.getEstado());
		trama.setFecha(dateFormatter.parse(tramaDto.getFecha()));
		trama.setFrecuenciaCorriente(tramaDto.getFrecuenciaCorriente());
		trama.setFrecuenciaTension(tramaDto.getFrecuenciaTension());
		trama.setHora(Time.valueOf(tramaDto.getHora()));
		trama.setHumedad(tramaDto.getHumedad());
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
		
		// Controlar trama
		if (nodo.isActivo()) {
			this.tramaControl = new TramaControl();
			this.tramaControl.cargarValoresActuales(tramaDto);
			this.tramaControl.controlarTrama(tramaDto);
		}
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
		
		List<TramaPotencias> tramasPotencias = tramaDaoParticular.getPotenciasNodos();
		TramaDto tramaDto;
		List<TramaDto> tramasDto = new ArrayList<TramaDto>();
		
		for (TramaPotencias tramaPotencia : tramasPotencias) {
			tramaDto = new TramaDto();
			tramaDto.setPotenciaContinua(tramaPotencia.getPotenciaContinua());
			tramaDto.setPotenciaInterna(tramaPotencia.getPotenciaInterna());
			tramaDto.setPotenciaRed(tramaPotencia.getPotenciaRed());
                        tramaDto.setNodo(tramaPotencia.getNodo());
//                        tramaDto.setNumero(tramaPotencia.getNodo());
			tramaDto.setHora(timeFormatter.format(tramaPotencia.getHora()));
			
			tramasDto.add(tramaDto);
			
		}
						
		return tramasDto;
		
	}
        
        public List<TramaUltimasPotencias> getUltimasPotenciasPorNodos(Long idNodo) throws ParseException {
            return tramaDaoParticular.getUltimasPotenciasPorNodos(idNodo);
        }
        
        public List<Trama> getUltimasNTramasPorNodos(Long idNodo, Integer limit) throws ParseException {
            return tramaDaoParticular.getUltimasNTramasPorNodos(idNodo, limit);
        }
        
        public float getTemperaturaPromedioParque() throws ParseException {
            return tramaDaoParticular.getTemperaturaPromedioParque();
        }
        
        public float getTemperaturaAmbienteParque() throws ParseException {
            return tramaDaoParticular.getTemperaturaAmbienteParque();
        }
        
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List getTramasByTiempoAndNodo(
            String[] nombreVariable, Date fechaDesde, Date fechaHasta, String horaDesde, 
            String horaHasta, Long idNodo) throws ParseException {
        
        Time horaDesdeCasteada;
        Time horaHastaCasteada;
        
        if(horaDesde != null && !horaDesde.isEmpty() && horaHasta != null && !horaHasta.isEmpty()){
            horaDesdeCasteada = Time.valueOf(horaDesde);
            horaHastaCasteada = Time.valueOf(horaHasta);
        } else if(horaHasta != null && !horaHasta.isEmpty() && (horaDesde == null || horaDesde.isEmpty())){
            horaHastaCasteada = Time.valueOf(horaHasta);
                horaDesdeCasteada = Hora.restarMinutos(horaHastaCasteada, 20);
        } else{
            horaDesdeCasteada = Time.valueOf("00:00:00");
            horaHastaCasteada = Time.valueOf("23:59:59");
        }
                 
        
        List trama = tramaDaoParticular.getTramasByTiempoAndNodo(
                nombreVariable, fechaDesde, fechaHasta, horaDesdeCasteada, horaHastaCasteada, idNodo);
        
        return trama;
    }

}
