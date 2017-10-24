package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;

@Repository
public class TramaDao extends DaoGenericoImp<Trama, Long> implements ITramaDao {

	public List<Trama> getTramaByNodo(int ipNodo) {
		return this.getByCriteria(Restrictions.eq("ipNodo", ipNodo));
	}

	@Override
	public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta) {
		List list =  ((Query) this.currentSession()
				.createQuery("select MAX(tensionRed) AS tensionRed,"
						+ "MAX(corrienteRed) AS corrienteRed, MAX(frecuenciaTension) AS frecuenciaTension, MAX(frecuenciaCorriente) AS frecuenciaCorriente, "
						+ "MAX(desfasaje) AS desfasaje, MAX(tensionTierra) AS tensionTierra, MAX(tensionInterna) AS tensionInterna, MAX(corrienteInterna) AS corrienteInterna, "
						+ "MAX(tensionContinua) AS tensionContinua, MAX(corrienteContinua) AS corrienteContinua, MAX(temperatura1) AS temperatura1, MAX(temperatura2) AS temperatura2, MAX(temperatura3) AS temperatura3,"
						+ "MAX(temperatura4) AS temperatura4, MAX(temperatura5) AS temperatura5, MAX(humedad) AS humedad, MIN(pvm) AS pvm, MAX(potenciaContinua) AS potenciaContinua,"
						+ "MAX(potenciaRed) AS potenciaRed, MAX(potenciaInterna) AS potenciaInterna, ipNodo AS ipNodo"
						+ " from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
						+ "group by ipNodo "
						+ "order by ipNodo"))
				.setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		return list;

	}

	@Override
	public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta) {
		List list =  ((Query) this.currentSession()
				.createQuery("select MIN(tensionRed) AS tensionRed,"
						+ "MIN(corrienteRed) AS corrienteRed, MIN(frecuenciaTension) AS , MIN(frecuenciaCorriente), MIN(desfasaje),"
						+ "MIN(tensionTierra), MIN(tensionInterna), MIN(corrienteInterna), MIN(tensionContinua),"
						+ "MIN(corrienteContinua), MIN(temperatura1), MIN(temperatura2), MIN(temperatura3),"
						+ "MIN(temperatura4), MIN(temperatura5), MIN(humedad), MIN(pvm), MIN(potenciaContinua),"
						+ "MIN(potenciaRed), MIN(potenciaInterna), ipNodo AS ipNodo"
						+ " from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
						+ "group by ipNodo "
						+ "order by ipNodo"))
				.setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		return list;
	}

	@Override
	public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta) {
		List list =  ((Query) this.currentSession()
				.createQuery("select AVG(tensionRed),"
						+ "AVG(corrienteRed), AVG(frecuenciaTension), AVG(frecuenciaCorriente), AVG(desfasaje),"
						+ "AVG(tensionTierra), AVG(tensionInterna), AVG(corrienteInterna), AVG(tensionContinua),"
						+ "AVG(corrienteContinua), AVG(temperatura1), AVG(temperatura2), AVG(temperatura3),"
						+ "AVG(temperatura4), AVG(temperatura5), AVG(humedad), MIN(pvm), AVG(potenciaContinua),"
						+ "AVG(potenciaRed), AVG(potenciaInterna), ipNodo AS ipNodo"
						+ " from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
						+ "group by ipNodo "
						+ "order by ipNodo"))
				.setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		return list;
	}

	/**
	 * Devuelve una lista de variables que contienen todas las potencias por nodo.
	 * PERO NO SE COMO CARAJO HACER LA QUERY PARA QUE ME DEVUELVA 
	 * LOS ULTIMOS VALORES DE POTENCIAS QUE TENGA.
	 */
	@Override
	public List<TramaPotencias> getPotenciasNodos() {
		List list =  ((Query) this.currentSession()
				.createQuery("SUM(potenciaContinua) AS potenciaContinua, "
						+ "SUM(potenciaRed) AS potenciaRed, SUM(potenciaInterna) AS potenciaInterna, ipNodo AS ipNodo"
						+ " from Trama group by ipNodo order by ipNodo"))
				.setResultTransformer(Transformers.aliasToBean(TramaPotencias.class)).list();
		return list;
	}

	@Override
	public TramaPotencias getPotenciasAcumuladasParque() {
		List list =  ((Query) this.currentSession()
				.createQuery("potenciaContinua AS potenciaContinua, "
						+ "potenciaRed AS potenciaRed, potenciaInterna AS potenciaInterna, ipNodo AS ipNodo"
						+ " from Trama where fecha = :fechaDesde order by ipNodo"))
				.setResultTransformer(Transformers.aliasToBean(TramaPotencias.class))
				.setParameter("fechaDesde", new Date()).list();
		return (TramaPotencias) list.get(0);
	}

	

}
