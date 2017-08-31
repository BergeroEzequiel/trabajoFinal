package ar.edu.ucc.trabajoFinal.amqp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.ucc.trabajoFinal.service.TramaService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class Consumer implements MessageListener {
	
	private Logger log = Logger.getLogger(this.getClass());
	
    @Override
    public void onMessage(Message message) {
        String data = new String(message.getBody());
        try {
			this.sendPostRequest("parsear_trama", data);
			log.info("Mensaje consumido" + data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // HTTP Post request
    private void sendPostRequest(String uri, String data) throws Exception {
    
     String url = "http://localhost:8080/trabajoFinal/" + uri;
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    
           // Setting basic post request
     con.setRequestMethod("POST");
     //con.setRequestProperty("User-Agent", USER_AGENT);
     con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
     con.setRequestProperty("Content-Type","application/json");
    
     //String postJsonData = "{"id":5,"countryName":"USA","population":8000}";
     
     // Send post request
     con.setDoOutput(true);
     DataOutputStream wr = new DataOutputStream(con.getOutputStream());
     wr.writeBytes(data);
     wr.flush();
     wr.close();
    
     int responseCode = con.getResponseCode();
     System.out.println("Sending 'POST' request to URL : " + url);
     System.out.println("Post Data : " + data);
     System.out.println("Response Code : " + responseCode);
    
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String output;
     StringBuffer response = new StringBuffer();
    
     while ((output = in.readLine()) != null) {
      response.append(output);
     }
     in.close();
     
     //printing result from response
     System.out.println(response.toString());
    }
   
}