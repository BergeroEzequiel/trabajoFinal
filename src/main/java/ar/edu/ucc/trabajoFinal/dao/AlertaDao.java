package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.Nodo;

@Repository
public class AlertaDao extends DaoGenericoImp<Alerta, Long> implements IAlertaDao{

	@Override
	public List<Alerta> getAlertasByNodo(Nodo nodo) {
		return this.getByCriteria(Restrictions.eq("nodoAfectado", nodo),
				Restrictions.eq("visualizar", true));
	}

	@Override
	public List<Alerta> getAlertas() {
		return this.getByCriteria(Restrictions.eq("visualizar", true));
	}

}
