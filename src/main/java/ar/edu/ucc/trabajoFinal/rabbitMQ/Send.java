package ar.edu.ucc.trabajoFinal.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private final static String QUEUE_NAME = "trama";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String data = "{'nodo':'1','tension':250, 'corriente':130, 'temperatura':26}";
	    channel.basicPublish("", QUEUE_NAME, null, data.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + data + "'");

	    channel.close();
	    connection.close();
	}

}