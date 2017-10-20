package ar.edu.ucc.trabajoFinal.amqp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;


public class Producer {
	


	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMqConfig.class);
		RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
		
		TramaDto tramaAuxiliar = new TramaDto();
		tramaAuxiliar.setCorrienteContinua((float)Math.random()*100);
		tramaAuxiliar.setCorrienteInterna((float)Math.random()*100);
		tramaAuxiliar.setCorrienteRed((float)Math.random()*100);
		tramaAuxiliar.setDesfasaje((float)Math.random()*100);
		tramaAuxiliar.setEstado("OK");
		tramaAuxiliar.setFecha(dateFormatter.format(new Date()));
		tramaAuxiliar.setFrecuenciaCorriente((float)Math.random()*100);
		tramaAuxiliar.setFrecuenciaTension((float)Math.random()*100);
		tramaAuxiliar.setHora(timeFormatter.format((new Date())));
		tramaAuxiliar.setHumedad((float)Math.random()*100);
		tramaAuxiliar.setNumero((int)(Math.random()*10));
		tramaAuxiliar.setPvm((float)Math.random()*100);
		tramaAuxiliar.setTemperatura1((float)Math.random()*100);
		tramaAuxiliar.setTemperatura2((float)Math.random()*100);
		tramaAuxiliar.setTemperatura3((float)Math.random()*100);
		tramaAuxiliar.setTemperatura4((float)Math.random()*100);
		tramaAuxiliar.setTemperatura5((float)Math.random()*100);
		tramaAuxiliar.setTensionContinua((float)Math.random()*100);
		tramaAuxiliar.setTensionInterna((float)Math.random()*100);
		tramaAuxiliar.setTensionRed((float)Math.random()*100);
		tramaAuxiliar.setTensionTierra((float)Math.random()*100);
		tramaAuxiliar.setModulo("Solar");
		
		CustomMessage cm = new CustomMessage(tramaAuxiliar);
		
		System.out.println("sending new custom message.. " + cm.toString());
		rabbitTemplate.convertAndSend(cm.toString());

	}

}