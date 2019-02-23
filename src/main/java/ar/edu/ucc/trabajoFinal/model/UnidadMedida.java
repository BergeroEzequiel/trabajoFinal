package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="unidades_medida")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnidadMedida extends ObjetoGenerico {

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	
	@Column(name = "factor_conversion", nullable = false)
	private float factorConversion;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String estado) {
		this.nombre = nombre;
	}


	public float getFactorConversion() {
		return factorConversion;
	}


	public void setFactorConversion(float factorConversion) {
		this.factorConversion = factorConversion;
	}
	
}
