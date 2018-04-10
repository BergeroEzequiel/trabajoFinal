package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author ezequiel
 */
@Entity
@Table(name = "criticidad")
public class Criticidad extends ObjetoGenerico{
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name="prioridad", nullable=false)
    private Prioridad prioridad;
    
    @Column(name = "cantidad_repeticiones")
    private int cantidadRepeticiones;
    
    @Column(name = "periodo_tiempo")
    private String periodoTiempo;

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
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
