package ar.edu.ucc.trabajoFinal.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.INodoDao;
import ar.edu.ucc.trabajoFinal.dao.NodoDao;
import ar.edu.ucc.trabajoFinal.dto.NodoDto;
import ar.edu.ucc.trabajoFinal.model.Nodo;

@Service
@Transactional
public class NodoService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Nodo, Long> nodoDao;

	INodoDao nodoDaoParticular;
	
	@PostConstruct
	public void init() {
		nodoDaoParticular = (NodoDao) nodoDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Nodo getNodo(Long id) {

		Nodo nodo = nodoDaoParticular.load(id);
//		NodoDto nodoDto = new NodoDto();
//		nodoDto.setId(nodo.getId());
//		nodoDto.setModulo(nodo.getModulo());
//		nodoDto.setNumero(nodo.getNumero());
//		nodoDto.setActivo(nodo.isActivo());
//		nodoDto.setDescripcion(nodo.getDescripcion());
		
		return nodo;
	}
	
//	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
//	public NodoDto getNodoByModuloAndNumero(String modulo, int numero) {
//
//		Nodo nodo = nodoDaoParticular.getNodoByNumeroYModulo(modulo, numero);
//		NodoDto nodoDto = new NodoDto();
//		nodoDto.setId(nodo.getId());
//		nodoDto.setModulo(nodo.getModulo());
//		nodoDto.setNumero(nodo.getNumero());
//		nodoDto.setActivo(nodo.isActivo());
//		nodoDto.setDescripcion(nodo.getDescripcion());
//		
//		return nodoDto;
//	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Nodo> getNodos() {

		List<Nodo> nodos = nodoDaoParticular.getAll();
		
//		List<NodoDto> nodosDto = new ArrayList<NodoDto>();
//
//		NodoDto nodoDto;
//		for (Nodo nodo : nodos) {
//			nodoDto = new NodoDto();
//			nodoDto.setId(nodo.getId());
//			nodoDto.setModulo(nodo.getModulo());
//			nodoDto.setNumero(nodo.getNumero());
//			nodoDto.setActivo(nodo.isActivo());
//			nodoDto.setDescripcion(nodo.getDescripcion());
//			
//			nodosDto.add(nodoDto);
//		}

		return nodos;
	}
	
//	/*Este metodo es exclusivamente para obtener la lista de Nodo 
//	 * que se utiliza para el NodoMapper. Para exponer la info de los nodos
//	 * se debe usar el metodo getNodos().
//	 */
//	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
//	public List<Nodo> getNodosForMapper() {
//		return nodoDaoParticular.getAll();
//	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Nodo> getNodosActivos() {

		List<Nodo> nodos = nodoDaoParticular.getNodosActivos();
		
//		List<NodoDto> nodosDto = new ArrayList<NodoDto>();
//
//		NodoDto nodoDto;
//		for (Nodo nodo : nodos) {
//			nodoDto = new NodoDto();
//			nodoDto.setId(nodo.getId());
//			nodoDto.setModulo(nodo.getModulo());
//			nodoDto.setNumero(nodo.getNumero());
//			nodoDto.setActivo(nodo.isActivo());
//			nodoDto.setDescripcion(nodo.getDescripcion());
//			
//			nodosDto.add(nodoDto);
//		}

		return nodos;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Nodo grabarNodo(Nodo nodo) throws ParseException {

		log.info("Guardando: " + nodo.toString());

//		Nodo nodo = new Nodo();
//		nodo.setModulo(nodoDto.getModulo());
//		nodo.setNumero(nodoDto.getNumero());
//		nodo.setActivo(nodoDto.isActivo());
//		nodo.setDescripcion(nodoDto.getDescripcion());
		
		nodoDaoParticular.saveOrUpdate(nodo);
		return nodo;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Nodo actualizarNodo(Nodo nodo) throws ParseException {

		log.info("Actualizando: " + nodo.toString());

//		Nodo nodoActualizar = nodoDaoParticular.load(nodo.getId());
		
//		nodo.setModulo(nodoDto.getModulo());
//		nodo.setNumero(nodoDto.getNumero());
//		nodo.setActivo(nodoDto.isActivo());
//		nodo.setDescripcion(nodoDto.getDescripcion());
//		
		nodoDaoParticular.saveOrUpdate(nodo);
		return nodo;
	}
	
}
