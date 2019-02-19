/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.model;

import java.sql.Time;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ezequiel
 */
@Entity
@Table(name="notificaciones")
public class Notificacion extends ObjetoGenerico{

    @Column(name = "variable_afectada", length = 50, nullable = false)
    private String variableAfectada;

    @ManyToOne
    @JoinColumn(name = "id_umbral", nullable = true)
    private Umbral umbralSuperado;

    @ManyToOne
    @JoinColumn(name = "id_nodo")
    private Nodo nodo;

    @ManyToOne
    @JoinColumn(name = "id_criticidad")
    private Criticidad criticidad;

    @Column(name = "fecha", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "hora", nullable = false)
    private Time hora;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "notificaciones_x_alertas")
    private Set<Alerta> alertas;


    public String getVariableAfectada() {
        return variableAfectada;
    }

    public void setVariableAfectada(String variableAfectada) {
        this.variableAfectada = variableAfectada;
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

    public Set<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(Set<Alerta> alertas) {
        this.alertas = alertas;
    }
    
    
    

}
