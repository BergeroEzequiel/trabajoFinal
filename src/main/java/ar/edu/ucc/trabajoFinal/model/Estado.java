package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ezequiel
 */
@Entity
@Table(name="estado")
public class Estado extends ObjetoGenerico{
    
    //Estas constantes deberian tener el mismo valor que en la BD.
    public static final long ACTIVO = 1;
    public static final long PENDIENTE = 2;
    public static final long INACTIVO = 3;
    
    @Column(name = "descripcion")
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
