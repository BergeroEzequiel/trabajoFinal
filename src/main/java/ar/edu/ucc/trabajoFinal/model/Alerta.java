package ar.edu.ucc.trabajoFinal.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="alertas")
public class Alerta extends ObjetoGenerico{
	
	@Column(name="codigo", length=50, nullable=false)
	private String codigo;
	
	@Column(name="descripcion", length=50, nullable=false)
	private String descripcion;
	
	@Column(name="variable_afectada", length=50, nullable=false)
	private String variableAfectada;
	
	@Column(name="umbral_superado", length=50, nullable=false)
	private float umbralSuperado;
	
	@Column(name="nodo_afectado", nullable=false)
	private int nodoAfectado;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column(name="hora", nullable=false)
	private Time hora;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
