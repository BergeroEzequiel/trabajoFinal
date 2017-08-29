package ar.edu.ucc.trabajoFinal.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Producer {
	


	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitMqConfig.class);
		RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);

		String message = "{'nodo':'1','tension':250, 'corriente':130, 'temperatura':26}";
		
		
		System.out.println("sending new custom message..");
		rabbitTemplate.convertAndSend(message);

	}

}