package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ezequiel
 */
@Entity
@Table(name="estado")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estado extends ObjetoGenerico{
    
    //Estas constantes deberian tener el mismo valor que en la BD.
    public static final long ACTIVO = 1;
    public static final long PENDIENTE = 2;
    public static final long INACTIVO = 3;
    
    @JsonProperty("description")
    @Column(name = "descripcion")
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
