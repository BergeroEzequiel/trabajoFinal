package ar.edu.ucc.trabajoFinal.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.ucc.trabajoFinal.service.TramaService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Consumer implements MessageListener {

	@Autowired
	private static TramaService tramaService;
	
    @Override
    public void onMessage(Message message) {
//		JSONObject json = (JSONObject) JSONSerializer.toJSON(message);
//		tramaService.parsearTrama(json);
        System.out.println(new String(message.getBody()));
    }
}