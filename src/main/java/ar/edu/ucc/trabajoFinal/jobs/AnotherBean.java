package ar.edu.ucc.trabajoFinal.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;

@Component("anotherBean")
public class AnotherBean {
	
	@Autowired
	TramaDao tramaDao;
	
	public void printAnotherMessage(){
		TramaAuxiliar auxiliar = new TramaAuxiliar();
//		log.info(tramaDao.getTramaMaximos(new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 
//			new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 9));
//		auxiliar = tramaDao.getTramaMaximos(new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 9);
		System.out.println(auxiliar);
	}
	
}
