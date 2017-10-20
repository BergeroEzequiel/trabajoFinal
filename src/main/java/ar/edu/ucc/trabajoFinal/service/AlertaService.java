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

import ar.edu.ucc.trabajoFinal.dao.AlertaDao;
import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IAlertaDao;
import ar.edu.ucc.trabajoFinal.dto.AlertaDto;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.Trama;

@Service
@Transactional
public class AlertaService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Alerta, Long> alertaDao;

	IAlertaDao alertaDaoParticular;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	@PostConstruct
	public void init() {
		alertaDaoParticular = (AlertaDao) alertaDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<AlertaDto> getAlertasByNodo(int ipNodo){
		log.info("Filtrando alertas con el ipNodo: " + ipNodo);
		
		List<Alerta> alertas = alertaDaoParticular.getAlertasByNodo(ipNodo);
		
		List<AlertaDto> alertasDto = new ArrayList<AlertaDto>();
		
		AlertaDto alertaDto;
		for (Alerta alerta : alertas) {
			alertaDto = new AlertaDto();
			alertaDto.setCodigo(alerta.getCodigo());
			alertaDto.setDescripcion(alerta.getDescripcion());
			alertaDto.setVariableAfectada(alerta.getVariableAfectada());
			alertaDto.setUmbralSuperado(alerta.getUmbralSuperado());
			alertaDto.setNodoAfectado(alerta.getNodoAfectado());
			alertaDto.setFecha(dateFormatter.format(alerta.getFecha()));
			alertaDto.setHora(timeFormatter.format(alerta.getHora()));
			
			alertasDto.add(alertaDto);
		}
		return alertasDto;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public AlertaDto grabarAlerta(AlertaDto alertaDto) throws ParseException {

		log.info("Guardando: " + alertaDto.toString());
		
		Alerta alerta = new Alerta();
		alerta.setCodigo(alertaDto.getCodigo());
		alerta.setDescripcion(alertaDto.getDescripcion());
		alerta.setVariableAfectada(alertaDto.getVariableAfectada());
		alerta.setValor(alertaDto.getValor());
		alerta.setUmbralSuperado(alertaDto.getUmbralSuperado());
		alerta.setNodoAfectado(alertaDto.getNodoAfectado());
		alerta.setFecha(dateFormatter.parse(alertaDto.getFecha()));
		alerta.setHora(new Time(timeFormatter.parse(alertaDto.getHora()).getTime()));
		
		alertaDaoParticular.saveOrUpdate(alerta);
		alertaDto.setId(alerta.getId());
		
		return alertaDto;
	}
}
