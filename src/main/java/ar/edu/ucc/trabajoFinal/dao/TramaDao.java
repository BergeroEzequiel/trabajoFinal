package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.dto.TramaFiltradaDto;
import ar.edu.ucc.trabajoFinal.model.TramaFiltrada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.TramaPotencias;
import ar.edu.ucc.trabajoFinal.model.TramaUltimasPotencias;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

@Repository
public class TramaDao extends DaoGenericoImp<Trama, Long> implements ITramaDao {

    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Override
    public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta) throws ParseException {
        List list = ((Query) this.currentSession()
                .createQuery("select MAX(tensionRed) AS tensionRed, "
                        + "MAX(corrienteRed) AS corrienteRed, MAX(frecuenciaTension) AS frecuenciaTension, MAX(frecuenciaCorriente) AS frecuenciaCorriente, "
                        + "MAX(desfasaje) AS desfasaje, MAX(tensionTierra) AS tensionTierra, MAX(tensionInterna) AS tensionInterna, MAX(corrienteInterna) AS corrienteInterna, "
                        + "MAX(tensionContinua) AS tensionContinua, MAX(corrienteContinua) AS corrienteContinua, MAX(temperatura1) AS temperatura1, MAX(temperatura2) AS temperatura2, MAX(temperatura3) AS temperatura3,"
                        + "MAX(temperatura4) AS temperatura4, MAX(temperatura5) AS temperatura5, MAX(humedad) AS humedad, MIN(pvm) AS pvm, MAX(potenciaContinua) AS potenciaContinua,"
                        + "MAX(potenciaRed) AS potenciaRed, MAX(potenciaInterna) AS potenciaInterna, nodo.id AS nodo "
                        + "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
                        + "group by nodo "
                        + "order by nodo"))
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta))).list();
        return list;

    }

    @Override
    public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta) throws ParseException {
        List list;
        list = ((Query) this.currentSession()
                .createQuery("select MIN(tensionRed) AS tensionRed, "
                        + "MIN(corrienteRed) AS corrienteRed, MIN(frecuenciaTension) AS frecuenciaTension, MIN(frecuenciaCorriente) AS frecuenciaCorriente, MIN(desfasaje) AS desfasaje, "
                        + "MIN(tensionTierra) AS tensionTierra, MIN(tensionInterna) AS tensionInterna, MIN(corrienteInterna) AS corrienteInterna, MIN(tensionContinua) AS tensionContinua, "
                        + "MIN(corrienteContinua) AS corrienteContinua, MIN(temperatura1) AS temperatura1, MIN(temperatura2) AS temperatura2, MIN(temperatura3) AS temperatura3, "
                        + "MIN(temperatura4) AS temperatura4, MIN(temperatura5) AS temperatura5, MIN(humedad) AS humedad, MIN(pvm) AS pvm, MIN(potenciaContinua) AS potenciaContinua, "
                        + "MIN(potenciaRed) AS potenciaRed, MIN(potenciaInterna) AS potenciaInterna, nodo.id AS nodo "
                        + "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
                        + "group by nodo "
                        + "order by nodo"))
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta))).list();
        return list;
    }

    @Override
    public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta) throws ParseException {
        List list = ((Query) this.currentSession()
                .createQuery("select CAST(AVG(tensionRed) AS float) AS tensionRed, "
                        + "CAST(AVG(corrienteRed) AS float) AS corrienteRed, CAST(AVG(frecuenciaTension) AS float) AS frecuenciaTension, CAST(AVG(frecuenciaCorriente) AS float) AS frecuenciaCorriente, CAST(AVG(desfasaje) AS float) AS desfasaje, "
                        + "CAST(AVG(tensionTierra) AS float) AS tensionTierra, CAST(AVG(tensionInterna) AS float) AS tensionInterna, CAST(AVG(corrienteInterna) AS float) AS corrienteInterna, CAST(AVG(tensionContinua) AS float) AS tensionContinua, "
                        + "CAST(AVG(corrienteContinua) AS float) AS corrienteContinua, CAST(AVG(temperatura1) AS float) AS temperatura1, CAST(AVG(temperatura2) AS float) AS temperatura2, CAST(AVG(temperatura3) AS float) AS temperatura3, "
                        + "CAST(AVG(temperatura4) AS float) AS temperatura4, CAST(AVG(temperatura5) AS float) AS temperatura5, CAST(AVG(humedad) AS float) AS humedad, CAST(AVG(pvm) AS float) AS pvm, CAST(AVG(potenciaContinua) AS float) AS potenciaContinua, "
                        + "CAST(AVG(potenciaRed) AS float) AS potenciaRed, CAST(AVG(potenciaInterna) AS float) AS potenciaInterna, nodo.id AS nodo "
                        + "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta "
                        + "group by nodo "
                        + "order by nodo"))
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta))).list();
        return list;
    }

    /**
     * Devuelve una lista de tramasPotencias. Una trama por cada nodo en la base
     * de datos. Cada trama potencia es la que tenga el MAX(hora) es decir la
     * mas actual por cada nodo.
     *
     * @throws ParseException
     */
    @Override
    public List<TramaPotencias> getPotenciasNodos() throws ParseException {
        List list = ((Query) this.currentSession()
                .createQuery(
                        "select potenciaContinua as potenciaContinua, "
                        + "potenciaInterna as potenciaInterna, "
                        + "potenciaRed as potenciaRed, "
                        + "hora as hora,"
                        + "nodo as nodo "
                        + "from Trama "
                        + "where fecha = CURRENT_DATE() AND hora in "
                        + "(SELECT MAX(hora) as hora"
                        + " from Trama "
                        + "where fecha = CURRENT_DATE() "
                        + "GROUP BY nodo) "
                        + "ORDER BY nodo"
                ))
                .setResultTransformer(Transformers.aliasToBean(TramaPotencias.class)).list();
        return list;
    }

    public List<Trama> getTramaByNodo(Long idNodo) {
        return this.getByCriteria(Restrictions.eq("nodo.id", idNodo));
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

    @Override
    public List<TramaAuxiliar> getTramaMaximos(Date fechaDesde, Date fechaHasta, Time horaDesde, Time horaHasta) throws ParseException {
        List list = ((Query) this.currentSession()
                .createQuery("select MAX(tensionRed) AS tensionRed, "
                        + "MAX(corrienteRed) AS corrienteRed, MAX(frecuenciaTension) AS frecuenciaTension, MAX(frecuenciaCorriente) AS frecuenciaCorriente, "
                        + "MAX(desfasaje) AS desfasaje, MAX(tensionTierra) AS tensionTierra, MAX(tensionInterna) AS tensionInterna, MAX(corrienteInterna) AS corrienteInterna, "
                        + "MAX(tensionContinua) AS tensionContinua, MAX(corrienteContinua) AS corrienteContinua, MAX(temperatura1) AS temperatura1, MAX(temperatura2) AS temperatura2, MAX(temperatura3) AS temperatura3,"
                        + "MAX(temperatura4) AS temperatura4, MAX(temperatura5) AS temperatura5, MAX(humedad) AS humedad, MIN(pvm) AS pvm, MAX(potenciaContinua) AS potenciaContinua,"
                        + "MAX(potenciaRed) AS potenciaRed, MAX(potenciaInterna) AS potenciaInterna, nodo.id AS nodo "
                        + "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta and hora >= :horaDesde and hora <= :horaHasta "
                        + "GROUP BY nodo "
                        + "ORDER BY nodo"))
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta)))
                .setParameter("horaDesde", horaDesde)
                .setParameter("horaHasta", horaHasta)
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class)).list();

        return list;

    }

    @Override
    public List<TramaAuxiliar> getTramaMinimos(Date fechaDesde, Date fechaHasta, Time horaDesde, Time horaHasta) throws ParseException {
        List list;
        list = ((Query) this.currentSession()
                .createQuery("select MIN(tensionRed) AS tensionRed, "
                        + "MIN(corrienteRed) AS corrienteRed, MIN(frecuenciaTension) AS frecuenciaTension, MIN(frecuenciaCorriente) AS frecuenciaCorriente, MIN(desfasaje) AS desfasaje, "
                        + "MIN(tensionTierra) AS tensionTierra, MIN(tensionInterna) AS tensionInterna, MIN(corrienteInterna) AS corrienteInterna, MIN(tensionContinua) AS tensionContinua, "
                        + "MIN(corrienteContinua) AS corrienteContinua, MIN(temperatura1) AS temperatura1, MIN(temperatura2) AS temperatura2, MIN(temperatura3) AS temperatura3, "
                        + "MIN(temperatura4) AS temperatura4, MIN(temperatura5) AS temperatura5, MIN(humedad) AS humedad, MIN(pvm) AS pvm, MIN(potenciaContinua) AS potenciaContinua, "
                        + "MIN(potenciaRed) AS potenciaRed, MIN(potenciaInterna) AS potenciaInterna, nodo.id AS nodo "
                        + "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta and hora >= :horaDesde and hora <= :horaHasta "
                        + "group by nodo "
                        + "order by nodo"))
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta)))
                .setParameter("horaDesde", horaDesde)
                .setParameter("horaHasta", horaHasta).list();
        return list;
    }

    @Override
    public List<TramaAuxiliar> getTramaPromedio(Date fechaDesde, Date fechaHasta, Time horaDesde, Time horaHasta) throws ParseException {
//        System.out.println("IMPRIMIENDO HORA HASTA--->" + horaHasta);
//        System.out.println("IMPRIMIENDO HORA  ---> " + (horaDesde));
        List list = ((Query) this.currentSession()
                .createQuery("select CAST(AVG(tensionRed) AS float) AS tensionRed, "
                        + "CAST(AVG(corrienteRed) AS float) AS corrienteRed, CAST(AVG(frecuenciaTension) AS float) AS frecuenciaTension, CAST(AVG(frecuenciaCorriente) AS float) AS frecuenciaCorriente, CAST(AVG(desfasaje) AS float) AS desfasaje, "
                        + "CAST(AVG(tensionTierra) AS float) AS tensionTierra, CAST(AVG(tensionInterna) AS float) AS tensionInterna, CAST(AVG(corrienteInterna) AS float) AS corrienteInterna, CAST(AVG(tensionContinua) AS float) AS tensionContinua, "
                        + "CAST(AVG(corrienteContinua) AS float) AS corrienteContinua, CAST(AVG(temperatura1) AS float) AS temperatura1, CAST(AVG(temperatura2) AS float) AS temperatura2, CAST(AVG(temperatura3) AS float) AS temperatura3, "
                        + "CAST(AVG(temperatura4) AS float) AS temperatura4, CAST(AVG(temperatura5) AS float) AS temperatura5, CAST(AVG(humedad) AS float) AS humedad, CAST(AVG(pvm) AS float) AS pvm, CAST(AVG(potenciaContinua) AS float) AS potenciaContinua, "
                        + "CAST(AVG(potenciaRed) AS float) AS potenciaRed, CAST(AVG(potenciaInterna) AS float) AS potenciaInterna, nodo.id AS nodo "
                        + "from Trama where fecha >= :fechaDesde and fecha <= :fechaHasta and hora >= :horaDesde and hora <= :horaHasta "
                        + "group by nodo "
                        + "order by nodo"
                ))
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
                .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta)))
                .setParameter("horaDesde", horaDesde)
                .setParameter("horaHasta", horaHasta).list();
        return list;
    }

    @Override
    public List<TramaUltimasPotencias> getUltimasPotenciasPorNodos(Long idNodo) throws ParseException {
        String whereNodo = idNodo != null ? "AND id_nodo = " + idNodo + " " : "";

        String query = "SELECT id_nodo as nodo, "
                + "SUBSTRING_INDEX(GROUP_CONCAT(potencia_continua ORDER BY fecha, hora DESC), ',', 10) as potenciaContinua, "
                + "SUBSTRING_INDEX(GROUP_CONCAT(potencia_interna ORDER BY fecha, hora DESC), ',', 10) as potenciaInterna, "
                + "SUBSTRING_INDEX(GROUP_CONCAT(potencia_red ORDER BY fecha, hora DESC), ',', 10) as potenciaRed, "
                + "SUBSTRING_INDEX(GROUP_CONCAT(hora ORDER BY fecha, hora DESC), ',', 10) as hora "
                + "FROM monitoreo_detalle "
                + "INNER JOIN nodos N on monitoreo_detalle.id_nodo = N.ID "
                + "WHERE N.activo = 1 AND fecha = CURRENT_DATE AND hora >= NOW() - INTERVAL 10 MINUTE "
                + whereNodo
                + "GROUP BY id_nodo";

        List list = this.currentSession().createSQLQuery(query)
                .addEntity(TramaUltimasPotencias.class).list();

        return list;
    }

    @Override
    public List<Trama> getUltimasNTramasPorNodos(Long idNodo, Integer limit) {
        String query = "SELECT * "
                + "FROM monitoreo_detalle "
                + "INNER JOIN nodos N on monitoreo_detalle.id_nodo = N.ID "
                + "WHERE N.activo = 1 AND fecha = CURRENT_DATE AND hora >= NOW() - INTERVAL 10 MINUTE "
                + "AND id_nodo = " + idNodo
                + " ORDER BY hora DESC "
                + "LIMIT " + limit;
        List list = this.currentSession().createSQLQuery(query)
                .addEntity(Trama.class).list();

        return list;
    }

    @Override
    public float getTemperaturaPromedioParque() {
        float temperaturaPromedio = 0;
        String query = "select temperatura1 AS  temperatura1, temperatura2 AS  temperatura2, "
                + "temperatura3 AS  temperatura3, temperatura4 AS  temperatura4, temperatura5 AS  temperatura5 "
                + "from Trama "
                + "where fecha = CURRENT_DATE() AND hora in "
                + "(SELECT MAX(hora) as hora"
                + " from Trama "
                + "where fecha = CURRENT_DATE() "
                + "GROUP BY nodo) "
                + "ORDER BY nodo";
        List<Trama> list = this.currentSession().createQuery(query)
                .setResultTransformer(Transformers.aliasToBean(Trama.class)).list();

        if (list != null && !list.isEmpty()) {
            for (Trama trama : list) {
                temperaturaPromedio += trama.getTemperatura2();
                temperaturaPromedio += trama.getTemperatura3();
                temperaturaPromedio += trama.getTemperatura4();
                temperaturaPromedio += trama.getTemperatura5();
            }
            temperaturaPromedio = temperaturaPromedio / (list.size() * 4);
        }

        return temperaturaPromedio;
    }

    @Override
    public float getTemperaturaAmbienteParque() {
        float temperaturaAmbientePromedio = 0;
        String query = "select temperatura1 AS temperatura1 "
                + "from Trama "
                + "where fecha = CURRENT_DATE() AND hora in "
                + "(SELECT MAX(hora) as hora"
                + " from Trama "
                + "where fecha = CURRENT_DATE() "
                + "GROUP BY nodo) "
                + "ORDER BY nodo";
        List<Trama> list = this.currentSession().createQuery(query)
                .setResultTransformer(Transformers.aliasToBean(Trama.class)).list();

        if (list != null && !list.isEmpty()) {
            for (Trama trama : list) {
                temperaturaAmbientePromedio += trama.getTemperatura1();
            }
            temperaturaAmbientePromedio = temperaturaAmbientePromedio / list.size();
        }

        return temperaturaAmbientePromedio;
    }

    @Override
    public List<TramaFiltradaDto> getTramasByTiempoAndNodo(
            String[] nombreVariable, Date fechaDesde, Date fechaHasta, Time horaDesde,
            Time horaHasta, Long idNodo) throws ParseException {

        ArrayList<TramaFiltrada> listadoTramas = new ArrayList<>();
        List<TramaFiltradaDto> listadoFinal = new LinkedList<>();

        for (String variable : nombreVariable) {

            String query = "SELECT " + variable + " AS valor, hora AS hora, fecha as fecha "
                    + "FROM monitoreo_detalle "
                    + "WHERE id_nodo = :idNodo "
                    + "and fecha >= :fechaDesde and fecha <= :fechaHasta "
                    + "and hora >= TIME(:horaDesde) and hora <= TIME(:horaHasta) "
                    + "ORDER BY hora";

            List<Object[]> listadoTramasProcesadas = this.currentSession().createSQLQuery(query)
                    .setParameter("idNodo", idNodo)
                    .setParameter("fechaDesde", dateFormatter.parse(dateFormatter.format(fechaDesde)))
                    .setParameter("fechaHasta", dateFormatter.parse(dateFormatter.format(fechaHasta)))
                    .setParameter("horaDesde", horaDesde)
                    .setParameter("horaHasta", horaHasta).list();

            for (Object[] t : listadoTramasProcesadas) {
                TramaFiltrada trama = new TramaFiltrada();
                trama.setValor((float) t[0]);
                trama.setFecha(dateFormatter.format(t[2]));
                trama.setHora(timeFormatter.format(t[1]));
                listadoTramas.add(trama);

            }

            listadoFinal.add(new TramaFiltradaDto(variable, (List<TramaFiltrada>) listadoTramas.clone()));
            listadoTramas.clear();

        }

        return listadoFinal;
    }

    @Override
    public List<TramaAuxiliar> getUltimaTramaPorNodo() {

        List list;
        list = ((Query) this.currentSession()
                .createQuery("select MAX(hora) as hora, nodo.id as nodo"
                        + "from Trama "
                        + "where fecha >= :fechaActual "
                        + "group by nodo"))
                .setResultTransformer(Transformers.aliasToBean(TramaAuxiliar.class))
                .setParameter("fechaActual", dateFormatter.format(new Date())).list();

        return null;

    }

}
