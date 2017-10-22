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

public class ScheduledJob extends QuartzJobBean {

	@Autowired
	private TramaDao tramaDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		tramaDao.getTramaPromedio(null, null);
		List<TramaAuxiliar> tramasDtoMaximos = tramaDao.getTramaMaximos(
				new Date(new GregorianCalendar(2017, 8, 4, 0, 0, 0).getTimeInMillis()),
				new Date(new GregorianCalendar(2017, 8, 4, 0, 0, 0).getTimeInMillis()));
		System.out.println(tramasDtoMaximos.get(0).getCorrienteContinua());
	}

	public void setTramaDao(TramaDao tramaDao) {
		this.tramaDao = tramaDao;
	}

}