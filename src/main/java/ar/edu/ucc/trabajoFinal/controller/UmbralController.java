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

import ar.edu.ucc.trabajoFinal.dto.UmbralDto;
import ar.edu.ucc.trabajoFinal.service.UmbralService;

@Controller
public class UmbralController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UmbralService umbralService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbrales", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbrales()
			throws Exception {
		
		log.info("Buscando todos los umbrales. ");
		List<UmbralDto> umbrales = umbralService.getUmbrales();
		return new ResponseEntity(umbrales, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbral/{tramaId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbral(@PathVariable("tramaId") Long tramaId)
			throws Exception {
		
		log.info("Buscando el umbral: " + tramaId);
		UmbralDto umbral = umbralService.getUmbral(tramaId);
		return new ResponseEntity(umbral, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/umbral/{nombreVariable}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbralByVariable(@PathVariable("nombreVariable") String nombreVariable) throws Exception{
		
		UmbralDto umbralDto = umbralService.getUmbralByVariable(nombreVariable);
		return new ResponseEntity(umbralDto, HttpStatus.OK);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbral", 
			method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> crearUmbral(@RequestBody UmbralDto umbralDto)
			throws Exception {
		
		log.info("Grabando: " + umbralDto.toString());
		
		umbralService.grabarUmbral(umbralDto);
		return new ResponseEntity(umbralDto, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbral", 
			method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> actualizarUmbral(@RequestBody UmbralDto umbralDto)
			throws Exception {
		
		UmbralDto umbralDtoRespuesta = umbralService.actualizarUmbral(umbralDto);		
		return new ResponseEntity(umbralDtoRespuesta,HttpStatus.OK);
	}
	
	

}
