package ar.edu.ucc.trabajoFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="umbrales")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="tipo_umbral", 
		discriminatorType=DiscriminatorType.STRING
		)
@DiscriminatorValue("generico")
public class Umbral extends ObjetoGenerico{
	
	@Column(name="valor_max", length=50, nullable=false)
	private float valorMax;
	
	@Column(name="valor_min", length=50, nullable=false)
	private float valorMin;
	
	@Column(name="ultima_modificacion", length=50, nullable=false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date ultimaModificacion;
	
	@Column(name= "nombre_variable", length = 50, nullable = false)
	private String nombreVariable;
	
	@Column(name="activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="id_criticidad")
	private Criticidad criticidad;
	
	@ManyToOne
	@JoinColumn(name="id_um")
	private UnidadMedida unidadMedida;
	
	public Criticidad getCriticidad() {
		return criticidad;
	}

	public void setCriticidad(Criticidad criticidad) {
		this.criticidad = criticidad;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

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