package ar.edu.ucc.trabajoFinal.jobs;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.dao.TramaProcesadaDao;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.TramaProcesada;

public class ScheduledJob extends QuartzJobBean {

	@Autowired
	private TramaDao tramaDao;
	
	@Autowired
	private TramaProcesadaDao tramaProcesadaDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		List<TramaAuxiliar> tramasDtoMaximos = tramaDao.getTramaMaximos(
				new Date(new GregorianCalendar(2017, 8, 5, 0, 0, 0).getTimeInMillis()),
				new Date(new GregorianCalendar(2017, 8, 5, 0, 0, 0).getTimeInMillis()));
		List<TramaAuxiliar> tramasDtoMinimos = tramaDao.getTramaMinimos(
				new Date(new GregorianCalendar(2017, 8, 5, 0, 0, 0).getTimeInMillis()),
				new Date(new GregorianCalendar(2017, 8, 5, 0, 0, 0).getTimeInMillis()));
		List<TramaAuxiliar> tramaDtoPromedios = tramaDao.getTramaPromedio(
				new Date(new GregorianCalendar(2017, 8, 5, 0, 0, 0).getTimeInMillis()),
				new Date(new GregorianCalendar(2017, 8, 5, 0, 0, 0).getTimeInMillis()));
		
		for (int i = 0; i < tramasDtoMaximos.size(); i++) {
			TramaAuxiliar tramaMaximos = tramasDtoMaximos.get(i);
			TramaAuxiliar tramaMinimos = tramasDtoMinimos.get(i);
			TramaAuxiliar tramaPromedios = tramaDtoPromedios.get(i);
			TramaProcesada tramaProcesada = new TramaProcesada();
			if (tramaPromedios.getNumero() == tramaMaximos.getNumero()
					&& tramaPromedios.getNumero() == tramaMinimos.getNumero()) {
				tramaProcesada.setIpNodo(tramaPromedios.getNumero());
				tramaProcesada.setCorrienteContinuaAvg(tramaPromedios.getCorrienteContinua());
				tramaProcesada.setCorrienteContinuaMax(tramaMaximos.getCorrienteContinua());
				tramaProcesada.setCorrienteContinuaMin(tramaMinimos.getCorrienteContinua());
				tramaProcesada.setCorrienteInternaAvg(tramaPromedios.getCorrienteInterna());
				tramaProcesada.setCorrienteInternaMax(tramaMaximos.getCorrienteInterna());
				tramaProcesada.setCorrienteInternaMin(tramaMinimos.getCorrienteInterna());
				tramaProcesada.setCorrienteRedAvg(tramaPromedios.getCorrienteRed());
				tramaProcesada.setCorrienteRedMax(tramaMaximos.getCorrienteRed());
				tramaProcesada.setCorrienteRedMin(tramaMinimos.getCorrienteRed());
				tramaProcesada.setDesfasajeAvg(tramaPromedios.getDesfasaje());
				tramaProcesada.setDesfasajeMax(tramaMaximos.getDesfasaje());
				tramaProcesada.setDesfasajeMin(tramaMinimos.getDesfasaje());
				tramaProcesada.setFrecuenciaCorrienteAvg(tramaPromedios.getFrecuenciaCorriente());
				tramaProcesada.setFrecuenciaCorrienteMax(tramaMaximos.getFrecuenciaCorriente());
				tramaProcesada.setFrecuenciaCorrienteMin(tramaMinimos.getFrecuenciaCorriente());
				tramaProcesada.setFrecuenciaTensionAvg(tramaPromedios.getFrecuenciaTension());
				tramaProcesada.setFrecuenciaTensionMax(tramaMaximos.getFrecuenciaTension());
				tramaProcesada.setFrecuenciaTensionMin(tramaMinimos.getFrecuenciaTension());
				tramaProcesada.setHumedadAvg(tramaPromedios.getHumedad());
				tramaProcesada.setHumedadMax(tramaMaximos.getHumedad());
				tramaProcesada.setHumedadMin(tramaMinimos.getHumedad());
				tramaProcesada.setPotenciaContinuaAvg(tramaPromedios.getPotenciaContinua());
				tramaProcesada.setPotenciaContinuaMax(tramaMaximos.getPotenciaContinua());
				tramaProcesada.setPotenciaContinuaMin(tramaMinimos.getPotenciaContinua());
				tramaProcesada.setPotenciaRedAvg(tramaPromedios.getPotenciaRed());
				tramaProcesada.setPotenciaRedMax(tramaMaximos.getPotenciaRed());
				tramaProcesada.setPotenciaRedMin(tramaMinimos.getPotenciaRed());
				tramaProcesada.setPotenciaInternaAvg(tramaPromedios.getPotenciaInterna());
				tramaProcesada.setPotenciaInternaMax(tramaMaximos.getPotenciaInterna());
				tramaProcesada.setPotenciaInternaMin(tramaMinimos.getPotenciaInterna());
				tramaProcesada.setPvmAvg(tramaPromedios.getPvm());
				tramaProcesada.setPvmMax(tramaMaximos.getPvm());
				tramaProcesada.setPvmMin(tramaMinimos.getPvm());
				tramaProcesada.setTemperatura1Avg(tramaPromedios.getTemperatura1());
				tramaProcesada.setTemperatura1Max(tramaMaximos.getTemperatura1());
				tramaProcesada.setTemperatura1Min(tramaMinimos.getTemperatura1());
				tramaProcesada.setTemperatura2Avg(tramaPromedios.getTemperatura2());
				tramaProcesada.setTemperatura2Max(tramaMaximos.getTemperatura2());
				tramaProcesada.setTemperatura2Min(tramaMinimos.getTemperatura2());
				tramaProcesada.setTemperatura3Avg(tramaPromedios.getTemperatura3());
				tramaProcesada.setTemperatura3Max(tramaMaximos.getTemperatura3());
				tramaProcesada.setTemperatura3Min(tramaMinimos.getTemperatura3());
				tramaProcesada.setTemperatura4Avg(tramaPromedios.getTemperatura4());
				tramaProcesada.setTemperatura4Max(tramaMaximos.getTemperatura4());
				tramaProcesada.setTemperatura4Min(tramaMinimos.getTemperatura4());
				tramaProcesada.setTemperatura5Avg(tramaPromedios.getTemperatura5());
				tramaProcesada.setTemperatura5Max(tramaMaximos.getTemperatura5());
				tramaProcesada.setTemperatura5Min(tramaMinimos.getTemperatura5());
				tramaProcesada.setTensionContinuaAvg(tramaPromedios.getTensionContinua());
				tramaProcesada.setTensionContinuaMax(tramaMaximos.getTensionContinua());
				tramaProcesada.setTensionContinuaMin(tramaMinimos.getTensionContinua());
				tramaProcesada.setTensionInternaAvg(tramaPromedios.getTensionInterna());
				tramaProcesada.setTensionInternaMax(tramaMaximos.getTensionInterna());
				tramaProcesada.setTensionInternaMin(tramaMinimos.getTensionInterna());
				tramaProcesada.setTensionRedAvg(tramaPromedios.getTensionRed());
				tramaProcesada.setTensionRedMax(tramaMaximos.getTensionRed());
				tramaProcesada.setTensionRedMin(tramaMinimos.getTensionRed());
				tramaProcesada.setTensionTierraAvg(tramaPromedios.getTensionTierra());
				tramaProcesada.setTensionTierraMax(tramaMaximos.getTensionTierra());
				tramaProcesada.setTensionTierraMin(tramaMinimos.getTensionTierra());

				tramaProcesadaDao.add(tramaProcesada);
			}
		}
		
	}

	public void setTramaDao(TramaDao tramaDao) {
		this.tramaDao = tramaDao;
	}
	
	public void setTramaProcesadaDao(TramaProcesadaDao tramaProcesadaDao) {
		this.tramaProcesadaDao = tramaProcesadaDao;
	}

}