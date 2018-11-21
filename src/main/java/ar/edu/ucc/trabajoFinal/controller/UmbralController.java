package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;
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
import ar.edu.ucc.trabajoFinal.model.Umbral;
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
		List<Umbral> umbrales = umbralService.getUmbralesGenericos();
		return new ResponseEntity(umbrales, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbrales/{idNodo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbralesNodo(@PathVariable("idNodo") Long idNodo)
			throws Exception {
		
		log.info("Buscando todos los umbrales especiales del nodo " + idNodo);
		List<Umbral> umbrales = umbralService.getUmbralesNodo(idNodo);
		return new ResponseEntity(umbrales, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/umbral/{nombreVariable}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbralGenericoByVariable(@PathVariable("nombreVariable") String nombreVariable) throws Exception{
		
		Umbral umbral = umbralService.getUmbralGenericoByVariable(nombreVariable);
		return new ResponseEntity(umbral, HttpStatus.OK);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbral", 
			method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> crearUmbral(@RequestBody UmbralEspecifico umbralEsp)
			throws Exception {
		
		log.info("Grabando: " + umbralEsp.toString());
		
		umbralService.grabarUmbral(umbralEsp);
		return new ResponseEntity(umbralEsp, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/umbral", 
			method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> actualizarUmbral(@RequestBody UmbralEspecifico umbralEsp)
			throws Exception {
		
		Umbral umbralRespuesta = umbralService.grabarUmbral(umbralEsp);
		return new ResponseEntity(umbralRespuesta,HttpStatus.OK);
	}

    @RequestMapping(value = "/deleteUmbralEspecifico/{idUmbral}",
            method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteUmbralEspecifico(@PathVariable("idUmbral") Long idUmbral) {
	    this.umbralService.deleteUmbralEspecifico(idUmbral);
	    return new ResponseEntity(null, HttpStatus.OK);
    }

}
