package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Nodo;

@Repository
public class NodoDao  extends DaoGenericoImp<Nodo, Long> implements INodoDao{

	@Override
	public List<Nodo> getNodosActivos() {
		return this.getByCriteria(Restrictions.eq("activo", true));
	}

	@Override
	public Nodo getNodoByNumeroYModulo(String modulo, int numero) {
		return this.getByCriteria(Restrictions.eqOrIsNull("modulo", modulo),
				Restrictions.eqOrIsNull("numero", numero)).get(0);
	}

    @Override
    public Nodo getNodoById(Long id) {
        return this.getByCriteria(Restrictions.eq("id", id)).get(0);
    }

}
