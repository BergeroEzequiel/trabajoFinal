package ar.edu.ucc.trabajoFinal.amqp;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import ar.edu.ucc.trabajoFinal.utils.PeticionPost;
import okhttp3.Response;

public class Consumer implements MessageListener {
	
	private Logger log = Logger.getLogger(this.getClass());
	private PeticionPost peticionPost = new PeticionPost();
	private Response response;
	
	
    @Override
    public void onMessage(Message message) {
        String data = new String(message.getBody());
        	log.info(data);
        	try {
				response = this.peticionPost.post("http://localhost:8080/trabajoFinal/trama", data);
				if(response.code() == 201) {
					log.info(response.toString());	
				}else {
					log.info(response.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    }
   
}