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

import ar.edu.ucc.trabajoFinal.dto.NodoDto;
import ar.edu.ucc.trabajoFinal.service.NodoService;

@Controller
public class NodoController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private NodoService nodoService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbrales()
			throws Exception {
		
		log.info("Buscando todos los nodos. ");
		List<NodoDto> nodos = nodoService.getNodos();
		return new ResponseEntity(nodos, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodo/{idNodo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUmbral(@PathVariable("idNodo") Long idNodo)
			throws Exception {
		
		log.info("Buscando el nodo: " + idNodo);
		NodoDto nodo = nodoService.getNodo(idNodo);
		return new ResponseEntity(nodo, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodo", 
			method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> crearUmbral(@RequestBody NodoDto nodoDto)
			throws Exception {
		
		log.info("Grabando: " + nodoDto.toString());
		
		nodoService.grabarNodo(nodoDto);
		return new ResponseEntity(nodoDto, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodo", 
			method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> actualizarUmbral(@RequestBody NodoDto nodoDto)
			throws Exception {
		
		NodoDto nodoDtoRespuesta = nodoService.actualizarNodo(nodoDto);		
		return new ResponseEntity(nodoDtoRespuesta,HttpStatus.OK);
	}
	
	

}
