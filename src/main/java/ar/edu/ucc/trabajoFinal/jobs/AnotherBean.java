package ar.edu.ucc.trabajoFinal.jobs;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.ucc.trabajoFinal.dao.TramaDao;

@Component("anotherBean")
public class AnotherBean {
	
	@Autowired
	TramaDao tramaDao;
	
	public void printAnotherMessage(){
		Query q;
//		log.info(tramaDao.getTramaMaximos(new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 
//			new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 9));
		q = tramaDao.getTramaMaximos(new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 9);
		System.out.println(q.toString());
	}
	
}
