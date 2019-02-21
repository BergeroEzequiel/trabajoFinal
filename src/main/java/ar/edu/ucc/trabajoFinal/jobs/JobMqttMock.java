/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.jobs;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Esta clase hace las veces de mock. De momento genera problemas de memory
 * leak, y para el tomcat puede fallar. No es tan importante porque esta clase
 * se usa solo para desarrollar.
 *
 * @author ezequiel
 */
public class JobMqttMock extends QuartzJobBean {

    String topic;
    String trama = null;
    String broker;
    String clientId = "mockTrabajoFinal2";
    int qos = 0;
    int cantidadNodos = 3;
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
    MqttConnectOptions connOptions;
    MqttMessage message;

    MqttClient client = null;

    @Override
    protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
        try {
            if (client == null || !client.isConnected()) {
                client = new MqttClient(broker, clientId);
                connOptions = new MqttConnectOptions();
                connOptions.setCleanSession(true);
                connOptions.setAutomaticReconnect(true);
                connOptions.setConnectionTimeout(6000000);
                connOptions.setKeepAliveInterval(45);
                connect();
            }
            for (int i = 1; i <= cantidadNodos; i++) {
                trama = generarNuevaTrama(i);
                message = new MqttMessage(trama.getBytes());
                message.setQos(qos);
                this.publishMessage(topic, message);
            }
            
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JobMqttMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String generarNuevaTrama(int idNodo) throws JsonProcessingException {

//        int[] array = {1, 2, 3};
        Random r = new Random();

        TramaDto tramaAuxiliar = new TramaDto();
        //r.nextInt(high-low) + low;
        tramaAuxiliar.setCorrienteContinua(r.nextInt(50 - 00) + 0); //umbral 30-00
        tramaAuxiliar.setCorrienteInterna((float) 50.1); //umbral 50.1 - 49.9
        tramaAuxiliar.setCorrienteRed(r.nextInt(8 - 0) + 0); //umbral 4 - 0
        tramaAuxiliar.setDesfasaje(r.nextInt(1 - 0) + 0);
        tramaAuxiliar.setEstado("OK");
        tramaAuxiliar.setFecha(dateFormatter.format(new Date()));
        tramaAuxiliar.setFrecuenciaCorriente(50); //umbral 50.1 - 49.9
        tramaAuxiliar.setFrecuenciaTension((float) 49.9); //umbral 50.1 - 49.9
        tramaAuxiliar.setHora(timeFormatter.format((new Date())));
        tramaAuxiliar.setHumedad(r.nextInt(90 - 85) + 85); //umbral NO TIENE
        tramaAuxiliar.setNumero(idNodo);
        tramaAuxiliar.setPvm(r.nextInt(10 - 5) + 5); //umbral NO TIENE
        tramaAuxiliar.setTemperatura1(r.nextInt(120 - 40) + 40);//umbral 100 - xx
        tramaAuxiliar.setTemperatura2(r.nextInt(70 - 50) + 50); //umbral 70 - xx 
        tramaAuxiliar.setTemperatura3(r.nextInt(110 - 90) + 90); //umbral 100 - xx
        tramaAuxiliar.setTemperatura4(r.nextInt(60 - 0) + (-5)); //umbral 60 - (-10)
        tramaAuxiliar.setTemperatura5(r.nextInt(40 - 25) + 25); //umbral 70 - xx
        tramaAuxiliar.setTensionContinua(r.nextInt(100 - 10) + 10); //umbral 100 - 40
        tramaAuxiliar.setTensionInterna(r.nextInt(60 - 50 ) +50); //umbral NO TIENE
        tramaAuxiliar.setTensionRed(r.nextInt(260-160) + 160); //umbral 240-180
        tramaAuxiliar.setTensionTierra(r.nextInt(5 - 1) + 5); //umbral 4 - xx
        tramaAuxiliar.setModulo("Solar");
        return new ObjectMapper().writeValueAsString(tramaAuxiliar);

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    private void publishMessage(String topic, MqttMessage message) throws MqttException {
        if (client.isConnected()) {
            client.publish(topic, message);
        } else {
            connect();
            client.publish(topic, message);
        }

    }

    private void connect() {
        // Tying a cycle of reconnects.
        boolean tryConnecting = true;
        while (tryConnecting) {
            try {
                client.connect(connOptions);
            } catch (Exception e1) {
                Logger.getLogger(JobMqttMock.class.getName()).info(
                        "Connection attempt failed with '" + e1.getCause() + "'. Retrying.");
            }
            if (client.isConnected()) {
                Logger.getLogger(JobMqttMock.class.getName()).info("Connected to " + broker);
                tryConnecting = false;
            }
        }
    }

}
