package ar.edu.ucc.trabajoFinal.amqp;

import java.sql.Date;
import java.sql.Time;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.edu.ucc.trabajoFinal.model.Trama;


public class Producer {
	


	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMqConfig.class);
		RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);

		//String message = "{'nodo':'1','tension':250, 'corriente':130, 'temperatura':26}";
		Trama tramaAuxiliar = new Trama();
		tramaAuxiliar.setCorrienteContinua((float)Math.random()*100);
		tramaAuxiliar.setCorrienteInterna((float)Math.random()*100);
		tramaAuxiliar.setCorrienteRed((float)Math.random()*100);
		tramaAuxiliar.setDesfasaje((float)Math.random()*100);
		tramaAuxiliar.setEstado(true);;
		tramaAuxiliar.setFecha(new Date(2017, 8, 26));//dateFormatter.parse(Calendar.getInstance().toString())
		tramaAuxiliar.setFrecuenciaCorriente((float)Math.random()*100);
		tramaAuxiliar.setFrecuenciaTension((float)Math.random()*100);
		tramaAuxiliar.setHora(new Time(100));
		tramaAuxiliar.setHumedad((float)Math.random()*100);
		tramaAuxiliar.setIpNodo((int)Math.random()*10);
		tramaAuxiliar.setPotenciaContinua((float)Math.random()*100);
		tramaAuxiliar.setPotenciaInterna((float)Math.random()*100);
		tramaAuxiliar.setPotenciaRed((float)Math.random()*100);
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
		
		CustomMessage cm = new CustomMessage(tramaAuxiliar);
		
		System.out.println("sending new custom message..");
		rabbitTemplate.convertAndSend(cm.toString());

	}

}