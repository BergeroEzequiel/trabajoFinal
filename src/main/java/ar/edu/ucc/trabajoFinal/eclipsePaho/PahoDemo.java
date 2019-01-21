/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.eclipsePaho;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

/**
 *
 * @author ezequiel
 */
public class PahoDemo {

    MqttClient client;

    public PahoDemo() {
    }

    public static void main(String[] args) {
        new PahoDemo().doDemo();
    }

    public void doDemo() {
        try {
            client = new MqttClient("tcp://localhost:1883", "pahomqttpublish1");
            client.connect(); // ACA le puedo pasar opciones, que se setean en la clase MqttConnectOptions(); 
            MqttMessage message = new MqttMessage();
            message.setPayload("A single message!!!".getBytes());
            client.publish("pahodemo/test", message);
            client.disconnect();
            System.exit(0);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
