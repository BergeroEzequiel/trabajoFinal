package ar.edu.ucc.trabajoFinal.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="umbrales")
public class Umbral extends ObjetoGenerico{
	
	@Column(name="valor_max", length=50, nullable=false)
	private float valorMax;
	
	@Column(name="valor_min", length=50, nullable=false)
	private float valorMin;
	
	@Column(name="ultima_modificacion", length=50, nullable=false)
	private Date ultimaModificacion;
	
	@Column(name= "nombre_variable", length = 50, nullable = false)
	private String nombreVariable;

	public String getNombreVariable() {
		return nombreVariable;
	}

	public void setNombreVariable(String nombraVariable) {
		this.nombreVariable = nombraVariable;
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

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

}