package ar.edu.ucc.trabajoFinal.rabbitMQ;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer extends MessageQueueEndPoint{
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);

	public Producer() {
		super();
	}

	public void publishMessage(String message) {
		try {
			channel.basicPublish(Configuracion.EXCHANGE_NAME, Configuracion.QUEUE_NAME, null, message.getBytes("UTF-8"));
		} catch (IOException e) {
			logger.error("Error connecting to Queue.", e);
		}
	}

}
