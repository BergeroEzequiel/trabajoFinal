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

	public List<Trama> getTramaByNumero(int numero) {
		return this.getByCriteria(Restrictions.eq("numero", numero));
	}

	@Override
	public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta) {
		List list =  ((Query) this.currentSession()
				.createQuery("select MAX(tensionRed) AS tensionRed, "
						+ "MAX(corrienteRed) AS corrienteRed, MAX(frecuenciaTension) AS frecuenciaTension, MAX(frecuenciaCorriente) AS frecuenciaCorriente, "
						+ "MAX(desfasaje) AS desfasaje, MAX(tensionTierra) AS tensionTierra, MAX(tensionInterna) AS tensionInterna, MAX(corrienteInterna) AS corrienteInterna, "
						+ "MAX(tensionContinua) AS tensionContinua, MAX(corrienteContinua) AS corrienteContinua, MAX(temperatura1) AS temperatura1, MAX(temperatura2) AS temperatura2, MAX(temperatura3) AS temperatura3,"
						+ "MAX(temperatura4) AS temperatura4, MAX(temperatura5) AS temperatura5, MAX(humedad) AS humedad, MIN(pvm) AS pvm, MAX(potenciaContinua) AS potenciaContinua,"
						+ "MAX(potenciaRed) AS potenciaRed, MAX(potenciaInterna) AS potenciaInterna, numero AS numero "
						+ "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
						+ "group by numero "
						+ "order by numero"))
				.setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		return list;

	}

	@Override
	public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta) {
		List list =  ((Query) this.currentSession()
				.createQuery("select MIN(tensionRed) AS tensionRed, "
						+ "MIN(corrienteRed) AS corrienteRed, MIN(frecuenciaTension) AS frecuenciaTension, MIN(frecuenciaCorriente) AS frecuenciaCorriente, MIN(desfasaje) AS desfasaje, "
						+ "MIN(tensionTierra) AS tensionTierra, MIN(tensionInterna) AS tensionInterna, MIN(corrienteInterna) AS corrienteInterna, MIN(tensionContinua) AS tensionContinua, "
						+ "MIN(corrienteContinua) AS corrienteContinua, MIN(temperatura1) AS temperatura1, MIN(temperatura2) AS temperatura2, MIN(temperatura3) AS temperatura3, "
						+ "MIN(temperatura4) AS temperatura4, MIN(temperatura5) AS temperatura5, MIN(humedad) AS humedad, MIN(pvm) AS pvm, MIN(potenciaContinua) AS potenciaContinua, "
						+ "MIN(potenciaRed) AS potenciaRed, MIN(potenciaInterna) AS potenciaInterna, numero AS numero "
						+ "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
						+ "group by numero "
						+ "order by numero"))
				.setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).list();
		return list;
	}

	@Override
	public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta) {
		List list =  ((Query) this.currentSession()
				.createQuery("select CAST(AVG(tensionRed) AS float) AS tensionRed, "
						+ "CAST(AVG(corrienteRed) AS float) AS corrienteRed, CAST(AVG(frecuenciaTension) AS float) AS frecuenciaTension, CAST(AVG(frecuenciaCorriente) AS float) AS frecuenciaCorriente, CAST(AVG(desfasaje) AS float) AS desfasaje, "
						+ "CAST(AVG(tensionTierra) AS float) AS tensionTierra, CAST(AVG(tensionInterna) AS float) AS tensionInterna, CAST(AVG(corrienteInterna) AS float) AS corrienteInterna, CAST(AVG(tensionContinua) AS float) AS tensionContinua, "
						+ "CAST(AVG(corrienteContinua) AS float) AS corrienteContinua, CAST(AVG(temperatura1) AS float) AS temperatura1, CAST(AVG(temperatura2) AS float) AS temperatura2, CAST(AVG(temperatura3) AS float) AS temperatura3, "
						+ "CAST(AVG(temperatura4) AS float) AS temperatura4, CAST(AVG(temperatura5) AS float) AS temperatura5, CAST(AVG(humedad) AS float) AS humedad, CAST(AVG(pvm) AS float) AS pvm, CAST(AVG(potenciaContinua) AS float) AS potenciaContinua, "
						+ "CAST(AVG(potenciaRed) AS float) AS potenciaRed, CAST(AVG(potenciaInterna) AS float) AS potenciaInterna, numero AS numero "
						+ "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
						+ "group by numero "
						+ "order by numero"))
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
				.createQuery("potenciaContinua AS potenciaContinua, "
						+ "potenciaRed AS potenciaRed, potenciaInterna AS potenciaInterna, numero AS numero, hora AS hora"
						+ " from Trama where fecha = :fechaActual order by numero, hora asc"))
				.setResultTransformer(Transformers.aliasToBean(TramaPotencias.class))
				.setParameter("fechaActual", new Date()).list();;
		return list;
	}

	@Override
	public TramaPotencias getPotenciasAcumuladasParque() {
//		List list =  ((Query) this.currentSession()
//				.createQuery("potenciaContinua AS potenciaContinua, "
//						+ "potenciaRed AS potenciaRed, potenciaInterna AS potenciaInterna, ipNodo AS ipNodo"
//						+ " from Trama where fecha = :fechaDesde order by ipNodo"))
//				.setResultTransformer(Transformers.aliasToBean(TramaPotencias.class))
//				.setParameter("fechaDesde", new Date()).list();
//		return (TramaPotencias) list.get(0);
		return null;
	}

	

}
