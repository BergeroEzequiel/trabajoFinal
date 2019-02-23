package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ID   Repe    Tiempo          Prioridad
 * 1 	2 	2 minutos 	Critica
 * 2 	5 	10 minutos 	Alta
 * 3 	10 	30 minutos 	Media
 * 4 	20 	60 Minutos 	Baja
 * @author ezequiel
 */
@Entity
@Table(name = "criticidades")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Criticidad extends ObjetoGenerico{
    
    @JsonProperty("priority")
    @Column(name="prioridad", nullable=false)
    private String prioridad;
    
    @JsonProperty("reps")
    @Column(name = "cantidad_repeticiones")
    private int cantidadRepeticiones;
    
    @JsonProperty("period")
    @Column(name = "periodo_tiempo")
    private String periodoTiempo;

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getCantidadRepeticiones() {
        return cantidadRepeticiones;
    }

    public void setCantidadRepeticiones(int cantidadRepeticiones) {
        this.cantidadRepeticiones = cantidadRepeticiones;
    }

    public String getPeriodoTiempo() {
        return periodoTiempo;
    }

    public void setPeriodoTiempo(String periodoTiempo) {
        this.periodoTiempo = periodoTiempo;
    }
    
    
    
}
