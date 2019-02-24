package ar.edu.ucc.trabajoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;

@Repository
public class UmbralEspecificoDao extends DaoGenericoImp<UmbralEspecifico, Long> implements IUmbralEspecificoDao{

	@Override
	public List<UmbralEspecifico> getUmbralesEspByNodo(Long idNodo) {
		List<UmbralEspecifico> umbralesEsp = this.getByCriteria(Restrictions.like("nodo.id", idNodo), 
                        Restrictions.eq("enUso", true));
		System.out.println(umbralesEsp.size());
		return umbralesEsp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UmbralEspecifico> getUmbralesEspByNodo(String modulo, int numero) {
		List<UmbralEspecifico> list =  this.currentSession()
				.createQuery(
					"from UmbralEspecifico where idNodo ="
					+ "(select id from Nodo where modulo = :modulo and numero = :numero)"
				).setParameter("modulo", modulo)
				.setParameter("numero", numero).list();
		return list;
	}

}
