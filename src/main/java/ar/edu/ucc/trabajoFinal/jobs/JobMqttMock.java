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
    String clientId = "mockTrabajoFinal";
    int qos = 2;
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
                connOptions.setAutomaticReconnect(true);
                connOptions.setConnectionTimeout(6000000);
                connOptions.setKeepAliveInterval(45);
                connect();
            }
            trama = generarNuevaTrama();
            message = new MqttMessage(trama.getBytes());
            message.setQos(qos);
            this.publishMessage(topic, message);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JobMqttMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String generarNuevaTrama() throws JsonProcessingException {

//        int[] array = {1, 2, 3};
        Random r = new Random();

        TramaDto tramaAuxiliar = new TramaDto();
        tramaAuxiliar.setCorrienteContinua(r.nextInt(11));
        tramaAuxiliar.setCorrienteInterna(r.nextInt(11));
        tramaAuxiliar.setCorrienteRed(r.nextInt(11));
        tramaAuxiliar.setDesfasaje(r.nextInt(11));
        tramaAuxiliar.setEstado("OK");
        tramaAuxiliar.setFecha(dateFormatter.format(new Date()));
        tramaAuxiliar.setFrecuenciaCorriente(r.nextInt(11));
        tramaAuxiliar.setFrecuenciaTension(r.nextInt(11));
        tramaAuxiliar.setHora(timeFormatter.format((new Date())));
        tramaAuxiliar.setHumedad(r.nextInt(11));
        tramaAuxiliar.setNumero(1);
        tramaAuxiliar.setPvm(r.nextInt(11));
        tramaAuxiliar.setTemperatura1(r.nextInt(11));
        tramaAuxiliar.setTemperatura2(r.nextInt(11));
        tramaAuxiliar.setTemperatura3(r.nextInt(11));
        tramaAuxiliar.setTemperatura4(r.nextInt(11));
        tramaAuxiliar.setTemperatura5(r.nextInt(11));
        tramaAuxiliar.setTensionContinua(r.nextInt(11));
        tramaAuxiliar.setTensionInterna(r.nextInt(11));
        tramaAuxiliar.setTensionRed(r.nextInt(11));
        tramaAuxiliar.setTensionTierra(r.nextInt(11));
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
