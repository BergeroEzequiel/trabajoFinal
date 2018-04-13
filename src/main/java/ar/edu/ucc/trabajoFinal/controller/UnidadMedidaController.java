package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.trabajoFinal.model.UnidadMedida;
import ar.edu.ucc.trabajoFinal.service.UnidadMedidaService;

@Controller
public class UnidadMedidaController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UnidadMedidaService umService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/unidades-medida", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUnidadesMedida()
			throws Exception {
		
		log.info("Buscando todos los nodos. ");
		List<UnidadMedida> unidades = umService.getUnidadesMedida();
		return new ResponseEntity(unidades, HttpStatus.OK);
	}

}
