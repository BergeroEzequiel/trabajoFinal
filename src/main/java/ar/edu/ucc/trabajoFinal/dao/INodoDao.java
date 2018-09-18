package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Nodo;

public interface INodoDao extends DaoGenerico<Nodo, Long>{
	
	public List<Nodo> getNodosActivos();
	
	public Nodo getNodoByNumeroYModulo(String modulo, int numero);
        
        public Nodo getNodoById(Long id);
}
