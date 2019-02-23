package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ezequiel
 */
@Entity
@Table(name = "historial_nodos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistorialNodo extends ObjetoGenerico{

    public HistorialNodo() {
    }

    public HistorialNodo(Nodo nodo, Date control, Calendar ultimaTrama, String descripcion) {
        this.nodo = nodo;
        this.control = control;
        this.ultimaTrama = ultimaTrama;
        this.descripcion = descripcion;
    }
    
    
    @ManyToOne
    @JoinColumn(name="id_nodo")
    @JsonProperty("node")
    private Nodo nodo;
    
    @Column(name="control", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date control;
    
    @Column(name="ultimaTrama", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonProperty("lastFrame")
    private Calendar ultimaTrama;
    
    @Column(name="descripcion", nullable=false)
    @JsonProperty("description")
    private String descripcion;

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Date getControl() {
        return control;
    }

    public void setControl(Date control) {
        this.control = control;
    }

    public Calendar getUltimaTrama() {
        return ultimaTrama;
    }

    public void setUltimaTrama(Calendar ultimaTrama) {
        this.ultimaTrama = ultimaTrama;
    }
    
    
    
}
