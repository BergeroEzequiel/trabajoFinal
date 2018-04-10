package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.trabajoFinal.dto.AlertaDto;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.service.AlertaService;

@Controller
public class AlertaController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private AlertaService alertaService;
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@RequestMapping(value = "/alertas/{nodo}", method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<?> getAlertasByNodo(@PathVariable("nodo") int nodo) throws Exception{
//		List<Alerta> alertasDto = alertaService.getAlertasByNodo(nodo.getId());
//		return new ResponseEntity(alertasDto, HttpStatus.OK);
//	}
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping(value = "/alerta", 
//			method = RequestMethod.POST, produces = "application/json")
//	public ResponseEntity<?> crearAlerta(@RequestBody AlertaDto alertaDto)
//			throws Exception {
//		
//		log.info("Grabando: " + alertaDto.toString());
//		
//		alertaService.grabarAlerta(alertaDto);
//		
//		
//		return new ResponseEntity(alertaDto,HttpStatus.CREATED);
//	}
	
}
