package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nodos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nodo extends ObjetoGenerico {

    @JsonProperty("module")
    @Column(name = "moludo", length = 50, nullable = false)
    private String modulo;

    @JsonProperty("number")
    @Column(name = "numero", nullable = false)
    private int numero;

    @JsonProperty("isActive")
    @Column(name = "activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean activo;

    @JsonProperty("description")
    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;

    @JsonProperty("working")
    @Column(name = "funcionando", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean funcionando;

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }

}
