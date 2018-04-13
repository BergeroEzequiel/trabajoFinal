package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.trabajoFinal.model.Criticidad;
import ar.edu.ucc.trabajoFinal.service.CriticidadService;

@Controller
public class CriticidadController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private CriticidadService criticidadService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/criticidades", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getCriticidades()
			throws Exception {
		
		log.info("Buscando todas las criticidades. ");
		List<Criticidad> criticidades = criticidadService.getCriticidades();
		return new ResponseEntity(criticidades, HttpStatus.OK);
	}

}
