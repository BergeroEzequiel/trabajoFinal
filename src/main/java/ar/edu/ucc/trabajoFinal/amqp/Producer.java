package ar.edu.ucc.trabajoFinal.amqp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import java.util.Random;


public class Producer {
	


	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMqConfig.class);
		RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
		int[] array = {1,2,3};
                Random r = new Random();
		
		for (int i = 0; i < 2000; i++) {
			
			
			for (int j = 0; j < array.length; j++) {
				TramaDto tramaAuxiliar = new TramaDto();
				tramaAuxiliar.setCorrienteContinua(r.nextInt(11));
				tramaAuxiliar.setCorrienteInterna(r.nextInt(11));
				tramaAuxiliar.setCorrienteRed(r.nextInt(11));
				tramaAuxiliar.setDesfasaje(r.nextInt(11));
				tramaAuxiliar.setEstado("OK");
				tramaAuxiliar.setFecha(dateFormatter.format(new Date()));
				tramaAuxiliar.setFrecuenciaCorriente(r.nextInt(11));
				tramaAuxiliar.setFrecuenciaTension(r.nextInt(11));
				tramaAuxiliar.setHora(timeFormatter.format((new Date())));
				tramaAuxiliar.setHumedad(r.nextInt(11));
				tramaAuxiliar.setNumero(array[j]);
				tramaAuxiliar.setPvm(r.nextInt(11));
				tramaAuxiliar.setTemperatura1(r.nextInt(11));
				tramaAuxiliar.setTemperatura2(r.nextInt(11));
				tramaAuxiliar.setTemperatura3(r.nextInt(11));
				tramaAuxiliar.setTemperatura4(r.nextInt(11));
				tramaAuxiliar.setTemperatura5(r.nextInt(11));
				tramaAuxiliar.setTensionContinua(r.nextInt(11));
				tramaAuxiliar.setTensionInterna(r.nextInt(11));
				tramaAuxiliar.setTensionRed(r.nextInt(11));
				tramaAuxiliar.setTensionTierra(r.nextInt(11));
				tramaAuxiliar.setModulo("Solar");
				
				CustomMessage cm = new CustomMessage(tramaAuxiliar);
				
				System.out.println("sending new custom message.. " + cm.toString());
				rabbitTemplate.convertAndSend(cm.toString());
				Thread.sleep(500);
			}
			Thread.sleep(25000);
		}
		

	}

}