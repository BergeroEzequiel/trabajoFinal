package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Rol;
import ar.edu.ucc.trabajoFinal.model.Usuario;

@Repository
public class UsuarioDao extends DaoGenericoImp<Usuario, Long> implements IUsuarioDao {

	@Override
	public List<Usuario> getUsuariosByRol(Rol rol) {
		return this.getByCriteria(Restrictions.eq("rol", rol.getDescripcion()));
	}

	@Override
	public Usuario updateRol(Usuario usuario) {
		this.update(usuario);
		return this.getByCriteria(Restrictions.idEq(usuario.getId())).get(0);
	}

}
