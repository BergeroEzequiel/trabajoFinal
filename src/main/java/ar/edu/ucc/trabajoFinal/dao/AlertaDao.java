package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Alerta;

@Repository
public class AlertaDao extends DaoGenericoImp<Alerta, Long> implements IAlertaDao{

	@Override
	public List<Alerta> getAlertasByNodo(int nodo) {
		return this.getByCriteria(Restrictions.eq("nodoAfectado", nodo));
	}

}
