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
		return this.getByCriteria(
				Restrictions.eq("nombreVariable", nombreVariable),
				Restrictions.eq("class", "generico")).get(0);
	}
	
	@Override
	public List<Umbral> getUmbralesEspByNodo(Long idNodo) {
		List<Umbral> umbralesEsp = this.getByCriteria(
				Restrictions.eq("nodo.id", idNodo));
		return umbralesEsp;
	}

	@Override
	public List<Umbral> getUmbralesGenericos() {
		return this.getByCriteria(Restrictions.eq("class", "generico"));		
	}
}
