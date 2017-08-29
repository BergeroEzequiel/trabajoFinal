package ar.edu.ucc.trabajoFinal.rabbitMQ;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Recv {
	private final static String QUEUE_NAME = "trama";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	          throws IOException {
	        String message = new String(body, "UTF-8");
	        JSONObject json = (JSONObject) JSONSerializer.toJSON(message);
	        double tension = json.getDouble("tension");
	        double corriente = json.getDouble("corriente");
	        double potencia = tension*corriente;
	        System.out.println(" [x] Received '" + potencia + "'");
	      }
	    };
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}