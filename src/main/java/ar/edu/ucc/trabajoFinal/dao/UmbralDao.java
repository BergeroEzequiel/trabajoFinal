package ar.edu.ucc.trabajoFinal.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Umbral;

@Repository
public class UmbralDao extends DaoGenericoImp<Umbral, Long> implements IUmbralDao{

	public Umbral getUmbralByVariable(String nombreVariable) {
		return this.getByCriteria(Restrictions.like("nombreVariable", nombreVariable)).get(0);
	}

}
