package ar.edu.ucc.trabajoFinal.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private final static String QUEUE_NAME = "hello";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setUsername(Configuracion.USERNAME);
		factory.setPassword(Configuracion.PASSWORD);
		factory.setHost(Configuracion.HOSTNAME);
		factory.setPort(Configuracion.PORT);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String message = "{'ipNodo': 1, 'corrienteContinua': 1, 'corrienteInterna': 1, 'corrienteRed': 1,"
				+ "'desfasaje': 1, 'estado': true, 'fecha': 1, 'hora': 1, 'frecuenciaCorriente': 1, 'frecuenciaTension': 1, 'humedad': 1"
				+ ",'potenciaContinua': 1, 'potenciaInterna': 1, 'potenciaRed': 1 ,'pvm': 1, 'temperatura1': 1, 'temperatura2': 1,"
				+ "'temperatura3': 1, 'temperatura4': 1, 'temperatura5': 1, 'tensionContinua': 1, 'tensionInterna': 1, 'tensionRed': 1,"
				+ "'tensionTierra': 1}";
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + message + "'");

	    channel.close();
	    connection.close();
	}

}
