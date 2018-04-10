package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Umbral;
import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;

@Repository
public class UmbralDao extends DaoGenericoImp<Umbral, Long> implements IUmbralDao{

	@Override
	public Umbral getUmbralGenericoByVariable(String nombreVariable) {
		Umbral umbral = (Umbral) this.getByCriteria(
				Restrictions.eq("nombreVariable", nombreVariable),
				Restrictions.eq("nodo", null));
		return umbral;
	}
	
	@Override
	public List<Umbral> getUmbralesEspByNodo(Nodo nodo) {
		List<Umbral> umbralesEsp = this.getByCriteria(
				Restrictions.eq("nodo", nodo));
		return umbralesEsp;
	}

	@Override
	public List<Umbral> getUmbralesGenericos() {
		return this.getByCriteria(Restrictions.eq("nodo", null));		
	}
}
