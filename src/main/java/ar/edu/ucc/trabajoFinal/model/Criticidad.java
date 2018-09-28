package ar.edu.ucc.trabajoFinal.model;

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
public class Criticidad extends ObjetoGenerico{
    
    @Column(name="prioridad", nullable=false)
    private String prioridad;
    
    @Column(name = "cantidad_repeticiones")
    private int cantidadRepeticiones;
    
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
