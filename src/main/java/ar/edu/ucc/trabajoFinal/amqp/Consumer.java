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
					log.info("TODO OK ninja");
//					log.info(tramaDao.getTramaMaximos(new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 
//							new Date(new GregorianCalendar(2017,9, 05).getTimeInMillis()), 9));
					
				}else {
					log.info(response.code() + "TODO MAL ninja");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    }
   
}