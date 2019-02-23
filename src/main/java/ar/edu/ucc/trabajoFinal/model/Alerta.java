package ar.edu.ucc.trabajoFinal.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.edu.ucc.trabajoFinal.trama.Variable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Temporal;

@Entity
@Table(name = "alertas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alerta extends ObjetoGenerico {

    @JsonProperty("description")
    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;

    @JsonProperty("affectedVariable")
    @Column(name = "variable_afectada", length = 50, nullable = false)
    private String variableAfectada;

    @JsonProperty("value")
    @Column(name = "valor", length = 50)
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "id_umbral", nullable = true)
    @JsonProperty("thresholdExceeded")
    private Umbral umbralSuperado;

    @ManyToOne
    @JoinColumn(name = "id_nodo")
    @JsonProperty("node")
    private Nodo nodo;

    @ManyToOne
    @JoinColumn(name = "id_criticidad")
    @JsonProperty("severity")
    private Criticidad criticidad;

    @JsonProperty("visualize")
    @Column(name = "visualizar", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean visualizar;

    @JsonProperty("date")
    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @JsonProperty("hour")
    @Column(name = "hora", nullable = false)
    private Time hora;

    public Alerta() {
        super();
    }

    public Alerta(Variable v, Nodo nodo) {
        this.descripcion = "variable fuera de umbral";
        this.variableAfectada = v.getNombre();
        this.valor = v.getValorActual();
        this.umbralSuperado = v.getUmbral();
        this.nodo = nodo;
        this.criticidad = v.getUmbral().getCriticidad();
        this.fecha = new Date();
        this.hora = new Time(System.currentTimeMillis());
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVariableAfectada() {
        return variableAfectada;
    }

    public void setVariableAfectada(String variableAfectada) {
        this.variableAfectada = variableAfectada;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Umbral getUmbralSuperado() {
        return umbralSuperado;
    }

    public void setUmbralSuperado(Umbral umbralSuperado) {
        this.umbralSuperado = umbralSuperado;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Criticidad getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(Criticidad criticidad) {
        this.criticidad = criticidad;
    }

    public boolean isVisualizar() {
        return visualizar;
    }

    public void setVisualizar(boolean visualizar) {
        this.visualizar = visualizar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
