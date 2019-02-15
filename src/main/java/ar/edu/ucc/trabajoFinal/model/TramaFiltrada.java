package ar.edu.ucc.trabajoFinal.model;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ezequiel
 */
@Entity
public class TramaFiltrada {

    public TramaFiltrada() {
    }

    public TramaFiltrada( float valor, String hora, String fecha) {
        this.valor = valor;
        this.hora = hora;
        this.fecha = fecha;
    }
 
    
    @Id
    private float valor;
    private String hora;
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
