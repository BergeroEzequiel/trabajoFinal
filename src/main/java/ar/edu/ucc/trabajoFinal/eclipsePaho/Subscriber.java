/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.eclipsePaho;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author ezequiel
 */
public class Subscriber {

    public static void main(String[] args) throws MqttException {
        System.out.println("== START SUBSCRIBER ==");

        MqttClient client = new MqttClient("tcp://localhost:1883", "testMonitoreoTramas1"); // el segundo parametro es un ID  del subsc
        client.setCallback(new MqttCallBack());
        client.connect();

        client.subscribe("pahodemo/test");
    }
}
