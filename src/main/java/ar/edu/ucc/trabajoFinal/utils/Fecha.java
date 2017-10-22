package ar.edu.ucc.trabajoFinal.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	
	public static Date addDaysToDate(final Date date, int noOfDays) {
	    Date newDate = new Date(date.getTime());

	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(newDate);
	    calendar.add(Calendar.DATE, noOfDays);
	    newDate.setTime(calendar.getTime().getTime());

	    return newDate;
	}

}
