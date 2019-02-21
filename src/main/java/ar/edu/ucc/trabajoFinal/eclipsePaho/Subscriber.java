/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.eclipsePaho;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Clase encargada de conectarse al canal MQTT al cual la UCC envie las tramas.
 * Implementado con Eclipse Paho. Para configurar la conexion leer:
 * https://www.eclipse.org/paho/files/javadoc/org/eclipse/paho/client/mqttv3/MqttConnectOptions.html
 *
 * @author ezequiel
 */
@Component
public class Subscriber implements MqttCallback {

    Logger logger = Logger.getLogger(Subscriber.class);

    private MqttClient client;
    private String broker;
    private String topic;
    private String clientId;
    private MqttConnectOptions connectionsOptions;
    private RestTemplate restTemplate = new RestTemplate();
    private TramaDto tramaDto = null;
    private URI uriPostTrama = null;
    private String baseUrl;
    private final int qos = 0;

    @PostConstruct
    private void start() throws MqttException {

        try {
            connectionsOptions = new MqttConnectOptions();
            connectionsOptions.setKeepAliveInterval(40);
            connectionsOptions.setConnectionTimeout(600000);
            connectionsOptions.setCleanSession(false);

            client = new MqttClient(broker, "juanSarlan420");
            client.setCallback(this);
            connect();

            client.subscribe(topic, qos);
        } catch (MqttException me) {
            logger.info("Connection to " + broker + " failed");
        }
    }

    @PreDestroy
    private void desconectarseAlCanal() throws MqttException {
        client.disconnect();
    }

    private void connect() {
        // Tying a cycle of reconnects.
        boolean tryConnecting = true;
        while (tryConnecting) {
            try {
                client.connect(connectionsOptions);
            } catch (Exception e1) {
                logger.error("Connection attempt failed with '" + e1 + "'. Retrying.");
            }
            if (client.isConnected()) {
                logger.info("Connected to " + broker);
                tryConnecting = false;
            }
        }
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        logger.error("Connection lost - attempting reconnect");
        if (thrwbl instanceof MqttException) {
            MqttException me = (MqttException) thrwbl;
            logger.info("---------------ERROR------------------------------");
            logger.error("| Reason: " + me.getReasonCode());
            logger.error("| Msg: " + me.getMessage());
            logger.error("| Loc: " + me.getLocalizedMessage());
            logger.error("| Cause: " + me.getCause());
            logger.info("---------------ERROR------------------------------");

        }
        // reconnect
        connect();
    }

    @Override
    public void messageArrived(String string, MqttMessage message) throws Exception {
        try {
            if (uriPostTrama == null) {
                uriPostTrama = new URI(baseUrl + "/trama");
            }
            tramaDto = new ObjectMapper().readValue(message.getPayload(), TramaDto.class);
            restTemplate.postForObject(uriPostTrama, tramaDto, TramaDto.class); //No necesitamos la TramaDto de respuesta x eso la descartamos
        } catch (IOException | URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    

}
