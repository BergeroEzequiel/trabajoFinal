/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.eclipsePaho;

import ar.edu.ucc.trabajoFinal.utils.VariablesConfiguracion;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ezequiel
 */
@Component
public class Subscriber {
    

    public static void main(String[] args) throws MqttException {
        
        
//        String uriClient = System.getProperty("client");
        
        Logger.getLogger(Subscriber.class).info("== START SUBSCRIBER ==");

        MqttClient client = new MqttClient("tcp://iot.eclipse.org", MqttClient.generateClientId()); // el segundo parametro es un ID  del subsc
        client.setCallback(new MqttCallBack());
//        MqttConnectOptions options = new MqttConnectOptions();
//        options.set

        client.connect();
        client.subscribe("UCC");
    }
}
