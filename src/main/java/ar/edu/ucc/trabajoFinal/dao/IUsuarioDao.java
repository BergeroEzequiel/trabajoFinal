package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Rol;
import ar.edu.ucc.trabajoFinal.model.Usuario;

public interface IUsuarioDao extends DaoGenerico<Usuario, Long>{

	public List<Usuario> getUsuariosByRol(Rol rol);
	
	public Usuario updateRol(Usuario usuario);
}
