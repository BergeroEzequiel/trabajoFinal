package ar.edu.ucc.trabajoFinal.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="alertas")
public class Alerta extends ObjetoGenerico{
		
	@Column(name="descripcion", length=50, nullable=false)
	private String descripcion;
	
	@Column(name="variable_afectada", length=50, nullable=false)
	private String variableAfectada;
	
	@Column(name="valor", length=50, nullable=false)
	private Float valor;

	@Column(name="umbral_superado", length=50, nullable=false)
	private float umbralSuperado;
	
	@Column(name="nodo_afectado", nullable=false)
	private int nodoAfectado;
	
	@Column(name="visualizar", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean visualizar;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column(name="hora", nullable=false)
	private Time hora;

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

	public float getUmbralSuperado() {
		return umbralSuperado;
	}

	public void setUmbralSuperado(float umbralSuperado) {
		this.umbralSuperado = umbralSuperado;
	}

	public int getNodoAfectado() {
		return nodoAfectado;
	}

	public void setNodoAfectado(int nodoAfectado) {
		this.nodoAfectado = nodoAfectado;
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
