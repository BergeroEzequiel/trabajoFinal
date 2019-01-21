package ar.edu.ucc.trabajoFinal.utils;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * Clase encargada de levantar todas las variables definidas en app.properties.
 * @author ezequiel
 */
@Configurable
@Component
public class VariablesConfiguracion {

    public VariablesConfiguracion() {
    }
    
    @Value("${mqtt.client}")
    private String clientMqtt;
    
    @Value("${mqtt.topic}")
    private String topicMqtt;
    
    @Value("${config.contextPath}")
    private String contextPath;

    public String getClientMqtt() {
        return clientMqtt;
    }

    public String getTopicMqtt() {
        return topicMqtt;
    }

    public String getContextPath() {
        return contextPath;
    }
    
    
    
}
