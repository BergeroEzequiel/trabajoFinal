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

import ar.edu.ucc.trabajoFinal.dto.UmbralEspecificoDto;
import ar.edu.ucc.trabajoFinal.service.UmbralEspecificoService;

@Controller
public class UmbralEspecificoController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UmbralEspecificoService umbralEspService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/umbralEspecifico/{idNodo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbralEspecificoByNodo(@PathVariable("idNodo") Long idNodo) throws Exception{
		
		log.info("Buscando todos los umbrales especificos para el nodo seleccionado.");
		List<UmbralEspecificoDto> umbralesEsp = umbralEspService.getUmbrales(idNodo);
		return new ResponseEntity(umbralesEsp, HttpStatus.OK);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbralEspecifico", 
			method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> crearUmbralEspecifico(@RequestBody UmbralEspecificoDto umbralEspDto)
			throws Exception {
		
		umbralEspService.grabarUmbralEspecifico(umbralEspDto);
		return new ResponseEntity(umbralEspDto, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbralEspecifico", 
			method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> actualizarUmbralEspecifico(@RequestBody UmbralEspecificoDto umbralEspDto)
			throws Exception {
		
		UmbralEspecificoDto umbralEspDtoRespuesta = umbralEspService.actualizarUmbralEspecifico(umbralEspDto);		
		return new ResponseEntity(umbralEspDtoRespuesta,HttpStatus.OK);
	}

}
