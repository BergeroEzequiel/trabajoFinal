package ar.edu.ucc.trabajoFinal.amqp;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import ar.edu.ucc.trabajoFinal.utils.PeticionPost;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;

public class Consumer implements MessageListener {
	
	private Logger log = Logger.getLogger(this.getClass());
	private PeticionPost peticionPost = new PeticionPost();
	private Response response;
        
//        @Value("${config.contextPath}")
//        private String contextPath;
	
	
    @Override
    public void onMessage(Message message) {
        String data = new String(message.getBody());
//        	log.info(data);
        	try {
				response = this.peticionPost.post("http://localhost:8080/trabajoFinal/trama", data);
				if(response.code() == 201) {
					log.info("---> ok: " + response.toString());	
				}else {
					log.info("--> error: " + response.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    }
   
}