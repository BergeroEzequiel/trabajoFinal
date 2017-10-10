package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;

@Repository
public class TramaDao extends DaoGenericoImp<Trama, Long> implements ITramaDao{

	public List<Trama> getTramaByNodo(int ipNodo) {
		return this.getByCriteria(Restrictions.eq("ipNodo", ipNodo));
	}

	@Override
	public Query getTramaMaximos(Date fechaDesde, Date fechaHasta, int nodo) {
		return (Query) this.currentSession().createQuery("select MAX(tensionRed),"
				+ "MAX(corrienteRed), MAX(frecuenciaTension), MAX(frecuenciaCorriente), MAX(desfasaje),"
				+ "MAX(tensionTierra), MAX(tensionInterna), MAX(corrienteInterna), MAX(tensionContinua),"
				+ "MAX(corrienteContinua), MAX(temperatura1), MAX(temperatura2), MAX(temperatura3),"
				+ "MAX(temperatura4), MAX(temperatura5), MAX(humedad), MIN(pvm), MAX(potenciaContinua),"
				+ "MAX(potenciaRed), MAX(potenciaInterna)"
				+ " from Trama where ipNodo = :nodo and fecha >= :fechaDesde and fecha <= :fechaHasta")
				.setParameter("fechaDesde", fechaDesde)
				.setParameter("fechaHasta", fechaHasta)
				.setParameter("nodo", nodo).list();
		
	}

	@Override
	public Query getTramaMinimos(Date fechaDesde, Date fechaHasta, int nodo) {
		return this.currentSession().createQuery("select MIN(tensionRed),"
				+ "MIN(corrienteRed), MIN(frecuenciaTension), MIN(frecuenciaCorriente), MIN(desfasaje),"
				+ "MIN(tensionTierra), MIN(tensionInterna), MIN(corrienteInterna), MIN(tensionContinua),"
				+ "MIN(corrienteContinua), MIN(temperatura1), MIN(temperatura2), MIN(temperatura3),"
				+ "MIN(temperatura4), MIN(temperatura5), MIN(humedad), MIN(pvm), MIN(potenciaContinua),"
				+ "MIN(potenciaRed), MIN(potenciaInterna)"
				+ " from Trama where ipNodo = :nodo and fecha >= :fechaDesde and fecha <= :fechaHasta")
				.setParameter("fechaDesde", fechaDesde)
				.setParameter("fechaHasta", fechaHasta)
				.setParameter("nodo", nodo);
	}

	@Override
	public Query getTramaPromedio(Date fechaDesde, Date fechaHasta, int nodo) {
		return null;
	}

}
