package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ezequiel
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TramaUltimasPotencias {
    
    @Id
    @JsonProperty("node")
    private Long nodo;
    @JsonProperty("continuousPower")
    private String potenciaContinua;
    @JsonProperty("networkPower")
    private String potenciaRed;
    @JsonProperty("internalPower")
    private String potenciaInterna;
    @JsonProperty("hour")
    private String hora;

    public TramaUltimasPotencias() {
    }

    public TramaUltimasPotencias(Long nodo, String potenciaContinua, String potenciaRed, String potenciaInterna, String hora) {
        this.nodo = nodo;
        this.potenciaContinua = potenciaContinua;
        this.potenciaRed = potenciaRed;
        this.potenciaInterna = potenciaInterna;
        this.hora = hora;
    }
    
    

    public Long getNodo() {
        return nodo;
    }

    public void setNodo(Long nodo) {
        this.nodo = nodo;
    }

    public String getPotenciaContinua() {
        return potenciaContinua;
    }

    public void setPotenciaContinua(String potenciaContinua) {
        this.potenciaContinua = potenciaContinua;
    }

    public String getPotenciaRed() {
        return potenciaRed;
    }

    public void setPotenciaRed(String potenciaRed) {
        this.potenciaRed = potenciaRed;
    }

    public String getPotenciaInterna() {
        return potenciaInterna;
    }

    public void setPotenciaInterna(String potenciaInterna) {
        this.potenciaInterna = potenciaInterna;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
}
