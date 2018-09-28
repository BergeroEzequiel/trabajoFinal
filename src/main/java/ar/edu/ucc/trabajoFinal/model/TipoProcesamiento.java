package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 1 	20 minutos
 * 2 	Diario 	
 * 3 	Semanal
 * Se usan para correr los jobs.
 * @author ezequiel
 */
@Entity
@Table(name = "tipo_procesamiento")
public class TipoProcesamiento extends ObjetoGenerico{

    public TipoProcesamiento() {
    }

    public TipoProcesamiento(Long id) {
        this.setId(id);
    }
    
    //NOTA: Estos IDs deben ser los mismos que los de la BD.
    
    public static final long MINUTOS20 = 1;
    public static final long DIARIO = 2;
    public static final long SEMANAL = 3;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
