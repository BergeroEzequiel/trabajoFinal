package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="unidades_medida")
public class UnidadMedida extends ObjetoGenerico {

	@Column(name = "nombre", nullable = false)
	private String estado;
	
	
	@Column(name = "factor_conversion", nullable = false)
	private float factorConversion;


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public float getFactorConversion() {
		return factorConversion;
	}


	public void setFactorConversion(float factorConversion) {
		this.factorConversion = factorConversion;
	}
	
}
