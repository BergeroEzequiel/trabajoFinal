package ar.edu.ucc.trabajoFinal.amqp;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


import ar.edu.ucc.trabajoFinal.utils.PeticionPost;

public class Consumer implements MessageListener {
	
	private Logger log = Logger.getLogger(this.getClass());
	private PeticionPost peticionPost = new PeticionPost();
	
    @Override
    public void onMessage(Message message) {
        String data = new String(message.getBody());
        try {
        	log.info(data);
        	this.peticionPost.post("http://localhost:8080/trabajoFinal/trama", data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
   
}