package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ezequiel
 */
@Entity
public class TramaFiltrada implements Serializable{

    public TramaFiltrada() {
    }

    public TramaFiltrada( float valor, String hora, String fecha) {
        this.valor = valor;
        this.hora = hora;
        this.fecha = fecha;
    }
 
    
    @Id
    @JsonProperty("value")
    private float valor;
    @JsonProperty("hour")
    private String hora;
    @JsonProperty("date")
    private String fecha;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
    
    
    
}
