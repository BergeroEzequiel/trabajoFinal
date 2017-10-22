package ar.edu.ucc.trabajoFinal.jobs;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.utils.Fecha;

public class JobSemanal extends QuartzJobBean{
	
	@Autowired
	private TramaDao tramaDao;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		List<TramaAuxiliar> tramasDtoMaximos = tramaDao.getTramaMaximos(
				new Date(), Fecha.addDaysToDate(new Date(), 7));
		System.out.println("ACA IMPRIMIR LA LISTA O ALGUN ELEMENTO (VIENEN TANTOS OBJETOS COMO NODOS EN LA SEMANA).");
		
	}
	
	public void setTramaDao(TramaDao tramaDao) {
		this.tramaDao = tramaDao;
	}

}
