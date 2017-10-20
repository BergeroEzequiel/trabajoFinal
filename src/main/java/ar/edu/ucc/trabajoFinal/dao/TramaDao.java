package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Trama;

@Repository
public class TramaDao extends DaoGenericoImp<Trama, Long> implements ITramaDao{

	public List<Trama> getTramaByNumero(int numero) {
		return this.getByCriteria(Restrictions.eq("numero", numero));
	}
}
