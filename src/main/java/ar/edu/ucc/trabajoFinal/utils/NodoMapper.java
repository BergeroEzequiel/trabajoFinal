package ar.edu.ucc.trabajoFinal.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.service.NodoService;

public class NodoMapper {

	private static NodoMapper instance = null;
	private NodoService nodoService = SpringContextBridge.services().getNodoService();
	private Map<String, Nodo> mapNodos = new HashMap<String, Nodo>();
	
	private NodoMapper() {
		List<Nodo> nodos = this.nodoService.getNodos();
		for(Nodo nodo : nodos) {
//			NodoKey key = new NodoKey(nodo.getModulo(), nodo.getNumero());
			mapNodos.put(nodo.getModulo() + nodo.getNumero(), nodo);
		}
		
	}
	
	public static NodoMapper getInstance() {
		if (instance == null) {
			instance = new NodoMapper();
		}
		return instance;
	}
	
	public Map<String, Nodo> getMappedNodos() {
		return this.mapNodos;
	}
}
