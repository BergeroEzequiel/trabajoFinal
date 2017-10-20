package ar.edu.ucc.trabajoFinal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;

@Repository
public class TramaDao extends DaoGenericoImp<Trama, Long> implements ITramaDao {

	public List<Trama> getTramaByNumero(int numero) {
		return this.getByCriteria(Restrictions.eq("numero", numero));
	}

	@Override
	public TramaAuxiliar getTramaMaximos(Date fechaDesde, Date fechaHasta, int nodo) {
		List list =  ((Query) this.currentSession()
				.createQuery("select MAX(tensionRed) AS tensionRed,"
						+ "MAX(corrienteRed) AS corrienteRed, MAX(frecuenciaTension) AS frecuenciaTension, MAX(frecuenciaCorriente) AS frecuenciaCorriente, "
						+ "MAX(desfasaje) AS desfasaje, MAX(tensionTierra) AS tensionTierra, MAX(tensionInterna) AS tensionInterna, MAX(corrienteInterna) AS corrienteInterna, "
						+ "MAX(tensionContinua) AS tensionContinua, MAX(corrienteContinua) AS corrienteContinua, MAX(temperatura1) AS temperatura1, MAX(temperatura2) AS temperatura2, MAX(temperatura3) AS temperatura3,"
						+ "MAX(temperatura4) AS temperatura4, MAX(temperatura5) AS temperatura5, MAX(humedad) AS humedad, MIN(pvm) AS pvm, MAX(potenciaContinua) AS potenciaContinua,"
						+ "MAX(potenciaRed) AS potenciaRed, MAX(potenciaInterna) AS potenciaInterna"
						+ " from Trama where ipNodo = :nodo "))//and fecha >= :fechaDesde and fecha <= :fechaHasta"
				.setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
//				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta)
				.setParameter("nodo", nodo).list();
		return (TramaAuxiliar) list.get(0);

	}

	@Override
	public TramaAuxiliar getTramaMinimos(Date fechaDesde, Date fechaHasta, int nodo) {
		List list =  this.currentSession()
				.createQuery("select MIN(tensionRed),"
						+ "MIN(corrienteRed), MIN(frecuenciaTension), MIN(frecuenciaCorriente), MIN(desfasaje),"
						+ "MIN(tensionTierra), MIN(tensionInterna), MIN(corrienteInterna), MIN(tensionContinua),"
						+ "MIN(corrienteContinua), MIN(temperatura1), MIN(temperatura2), MIN(temperatura3),"
						+ "MIN(temperatura4), MIN(temperatura5), MIN(humedad), MIN(pvm), MIN(potenciaContinua),"
						+ "MIN(potenciaRed), MIN(potenciaInterna)"
						+ " from Trama where ipNodo = :nodo and fecha >= :fechaDesde and fecha <= :fechaHasta")
				.setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta)
				.setParameter("nodo", nodo).list();
		return (TramaAuxiliar) list.get(0);
	}

	@Override
	public TramaAuxiliar getTramaPromedio(Date fechaDesde, Date fechaHasta, int nodo) {
		System.out.println("Estoy en TramaPromedio.");
		return null;
	}

}
