package ar.edu.ucc.trabajoFinal.jobs;

import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;

public class ScheduledJob extends QuartzJobBean {

	@Autowired
	private TramaDao tramaDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		tramaDao.getTramaPromedio(null, null, 1);
		TramaAuxiliar tramaDtoMaximos = tramaDao.getTramaMaximos(
				new Date(new GregorianCalendar(2017, 9, 4, 0, 0, 0).getTimeInMillis()),
				new Date(new GregorianCalendar(2017, 9, 4, 0, 0, 0).getTimeInMillis()), 8);
		System.out.println(tramaDtoMaximos.getHumedad());
	}

	public void setTramaDao(TramaDao tramaDao) {
		this.tramaDao = tramaDao;
	}

}