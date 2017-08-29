package ar.edu.ucc.trabajoFinal.amqp;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ar.edu.ucc.trabajoFinal.model.Trama;

public class CustomMessage {

    private Trama trama;
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
	DateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");

    public CustomMessage() {
        trama.setCorrienteContinua((float)Math.random()*100);
        trama.setCorrienteInterna((float)Math.random()*100);
        trama.setCorrienteRed((float)Math.random()*100);
        trama.setDesfasaje((float)Math.random()*100);
        trama.setEstado(true);
        trama.setFecha(new Date(1,1,1));
        trama.setFrecuenciaCorriente((float)Math.random()*100);
        trama.setFrecuenciaTension((float)Math.random()*100);
        trama.setHora(new Time(1,1,1));
        trama.setHumedad((float)Math.random()*100);
        trama.setIpNodo(666);
        trama.setPotenciaContinua((float)Math.random()*100);
        trama.setPotenciaInterna((float)Math.random()*100);
        trama.setPotenciaRed((float)Math.random()*100);
        trama.setPvm((float)Math.random()*100);
        trama.setTemperatura1((float)Math.random()*100);
        trama.setTemperatura2((float)Math.random()*100);
        trama.setTemperatura3((float)Math.random()*100);
        trama.setTemperatura4((float)Math.random()*100);
        trama.setTemperatura5((float)Math.random()*100);
        trama.setTensionContinua((float)Math.random()*100);
        trama.setTensionInterna((float)Math.random()*100);
        trama.setTensionRed((float)Math.random()*100);
        trama.setTensionTierra((float)Math.random()*100);
    }

    public Trama getTrama() {
        return trama;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "trama=" + trama +
                '}';
    }
}
