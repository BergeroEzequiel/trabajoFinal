package ar.edu.ucc.trabajoFinal.rabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.LoggerFactory;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public abstract class MessageQueueEndPoint {

	protected Connection connection;
	protected static Channel channel;
	protected String queueName;
	

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageQueueEndPoint.class);

	public MessageQueueEndPoint() {
		//this.queueName = queueName;
		//String queueName

		// Create a connection factory
		ConnectionFactory factory = new ConnectionFactory();

		try {
			factory.setUsername(Configuracion.USERNAME);
			factory.setPassword(Configuracion.PASSWORD);
			factory.setHost(Configuracion.HOSTNAME);
			factory.setPort(Configuracion.PORT);

			// getting a connection
			connection = factory.newConnection();

			// creating a channel
			channel = connection.createChannel();

			// declaring a queue for this channel. If queue does not exist, it will be
			// created on the server.
			// durability (second param) is also set as TRUE (the queue will survive a
			// server restart).
			channel.queueDeclare(Configuracion.QUEUE_NAME, true, false, false, null);
			channel.exchangeDeclare(Configuracion.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
		} catch (Exception e) {
			logger.error("Error connecting to MQ Server.", e);
		}
	}


	/**
	 * Closes the Queue Connection. This is not needed to be called explicitly as
	 * connection closure happens implicitly anyways.
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {

		try {
			MessageQueueEndPoint.channel.close();
			this.connection.close();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
