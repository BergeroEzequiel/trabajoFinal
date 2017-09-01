package ar.edu.ucc.trabajoFinal.rabbitMQ;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.service.TramaService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Cons extends MessageQueueEndPoint{
	
	@Autowired
	static TramaService tramaService;
	static TramaDto tramaDto;
	
	  public static void main(String[] argv) throws Exception {
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	          throws IOException {
	        String message = new String(body, "UTF-8");
	        JSONObject json = (JSONObject) JSONSerializer.toJSON(message);
	        tramaDto = new TramaDto();
	        //tramaDto = tramaService.parsearTrama(json);
	        tramaService.grabarTrama(tramaDto);
	        
	      }
	    };
	    channel.basicConsume(Configuracion.QUEUE_NAME, true, consumer);
	}

}