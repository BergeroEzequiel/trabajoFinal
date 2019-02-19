package ar.edu.ucc.trabajoFinal.model;

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
public class HistorialNodo extends ObjetoGenerico{
    
    @ManyToOne
    @JoinColumn(name="id_nodo")
    private Nodo nodo;
    
    @Column(name="control", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date control;
    
    @Column(name="ultimaTrama", nullable=false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultimaTrama;

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

    public Date getUltimaTrama() {
        return ultimaTrama;
    }

    public void setUltimaTrama(Date ultimaTrama) {
        this.ultimaTrama = ultimaTrama;
    }
    
    
    
}
