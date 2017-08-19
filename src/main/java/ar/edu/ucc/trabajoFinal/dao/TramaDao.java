package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Trama;

@Repository
public class TramaDao extends DaoGenericoImp<Trama, Long> implements ITramaDao{

	public List<Trama> getTramaByNodo(int ipNodo) {
		return this.getByCriteria(Restrictions.like("ip_nodo", ipNodo));
	}

}
