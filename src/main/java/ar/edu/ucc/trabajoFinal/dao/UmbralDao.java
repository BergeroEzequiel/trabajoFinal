package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Umbral;

@Repository
public class UmbralDao extends DaoGenericoImp<Umbral, Long> implements IUmbralDao{

	public Umbral getUmbralByVariable(String nombreVariable) {
		List<Umbral> umbrales = this.getByCriteria(Restrictions.like("nombreVariable", nombreVariable));
		System.out.println(umbrales.size());
		return (Umbral) umbrales.get(0);
	}

}
