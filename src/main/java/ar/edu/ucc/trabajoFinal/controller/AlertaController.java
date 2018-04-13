package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.service.AlertaService;

@Controller
public class AlertaController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private AlertaService alertaService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/alertas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAlertasByNodo() throws Exception{
		List<Alerta> alertas = alertaService.getAlertas();
		return new ResponseEntity(alertas, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/alertas/{idNodo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAlertasByNodo(@PathVariable("nodo") Long idNodo) throws Exception{
		List<Alerta> alertasDto = alertaService.getAlertasByNodo(idNodo);
		return new ResponseEntity(alertasDto, HttpStatus.OK);
	}
	
}
