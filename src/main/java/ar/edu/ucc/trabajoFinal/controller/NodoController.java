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
import ar.edu.ucc.trabajoFinal.model.Nodo;
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
		List<Nodo> nodos = nodoService.getNodos();
		return new ResponseEntity(nodos, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodo/{idNodo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getNodo(@PathVariable("idNodo") Long idNodo)
			throws Exception {
		
		log.info("Buscando el nodo: " + idNodo);
		Nodo nodo = nodoService.getNodo(idNodo);
		return new ResponseEntity(nodo, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodo", 
			method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> crearNodo(@RequestBody Nodo nodo)
			throws Exception {
		
		log.info("Grabando: " + nodo.toString());
		
		nodoService.grabarNodo(nodo);
		return new ResponseEntity(nodo, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/nodo", 
			method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> actualizarNodo(@RequestBody Nodo nodo)
			throws Exception {
		
		Nodo nodoRespuesta = nodoService.grabarNodo(nodo);		
		return new ResponseEntity(nodoRespuesta, HttpStatus.OK);
	}
	
	

}
