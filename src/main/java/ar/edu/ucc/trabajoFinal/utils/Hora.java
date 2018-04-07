/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.utils;

import java.sql.Time;
import java.util.Calendar;

/**
 *
 * @author ezequiel
 */
public class Hora {

    public static Time restarMinutos(Time hora, int cantidad) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(hora);
        cal.add(Calendar.MINUTE, ((-1)*cantidad));
        Time horaMenos20Minutos = new Time(cal.getTimeInMillis());
        return horaMenos20Minutos;
    }

}
