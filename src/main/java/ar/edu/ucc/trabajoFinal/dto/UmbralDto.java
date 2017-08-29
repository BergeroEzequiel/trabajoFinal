package ar.edu.ucc.trabajoFinal.dto;

import java.sql.Date;

public class UmbralDto {
	
	private Long id;
	private float valorMax;
	private float valorMin;
	private String nombreVariable;
	private Date fechaUltimaModificacion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public float getValorMax() {
		return valorMax;
	}
	public void setValorMax(float valorMax) {
		this.valorMax = valorMax;
	}
	public float getValorMin() {
		return valorMin;
	}
	public void setValorMin(float valorMin) {
		this.valorMin = valorMin;
	}
	public String getNombreVariable() {
		return nombreVariable;
	}
	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(Date date) {
		this.fechaUltimaModificacion = date;
	}
}
