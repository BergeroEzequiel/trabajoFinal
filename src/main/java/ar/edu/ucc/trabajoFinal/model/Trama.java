package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "monitoreo_detalle")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trama extends ObjetoGenerico {
	
	@ManyToOne
	@JoinColumn(name="id_nodo")
        @JsonProperty("node")
	private Nodo nodo;

        @JsonProperty("state")
	@Column(name = "estado", nullable = false)
	private String estado;
	
        @JsonProperty("networkVoltage")
	@Column(name = "tension_red", nullable = false)
	private float tensionRed;

        @JsonProperty("networkCurrent")
	@Column(name = "corriente_red", nullable = false)
	private float corrienteRed;

        @JsonProperty("voltageFrequency")
	@Column(name = "frecuencia_tension", nullable = false)
	private float frecuenciaTension;

        @JsonProperty("currentFrequency")
	@Column(name = "frecuencia_corriente", nullable = false)
	private float frecuenciaCorriente;

        @JsonProperty("phaseShift")
	@Column(name = "desfasaje", nullable = false)
	private float desfasaje;

        @JsonProperty("groundVoltage")
	@Column(name = "tension_tierra", nullable = false)
	private float tensionTierra;

        @JsonProperty("internalVoltage")
	@Column(name = "tension_interna", nullable = false)
	private float tensionInterna;

        @JsonProperty("internalCurrent")
	@Column(name = "corriente_interna", nullable = false)
	private float corrienteInterna;

        @JsonProperty("continuousVoltage")
	@Column(name = "tension_continua", nullable = false)
	private float tensionContinua;

        @JsonProperty("continuousCurrent")
	@Column(name = "corriente_continua", nullable = false)
	private float corrienteContinua;

        @JsonProperty("temperature1")
	@Column(name = "temperatura1", nullable = false)
	private float temperatura1;

        @JsonProperty("temperature2")
	@Column(name = "temperatura2", nullable = false)
	private float temperatura2;

        @JsonProperty("temperature3")
	@Column(name = "temperatura3", nullable = false)
	private float temperatura3;

        @JsonProperty("temperature4")
	@Column(name = "temperatura4", nullable = false)
	private float temperatura4;

        @JsonProperty("temperature5")
	@Column(name = "temperatura5", nullable = false)
	private float temperatura5;

        @JsonProperty("humidity")
	@Column(name = "humedad", nullable = false)
	private float humedad;

        @JsonProperty("pwm")
	@Column(name = "pvm", nullable = false)
	private float pvm;

        @JsonProperty("date")
	@Column(name = "fecha", nullable = true)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date fecha;

        @JsonProperty("hour")
	@Column(name = "hora", nullable = true)
	private Time hora;

        @JsonProperty("continuousPower")
	@Column(name = "potencia_continua", nullable = false, scale = 2)
	private float potenciaContinua;

        @JsonProperty("networkPower")
	@Column(name = "potencia_red", nullable = false, scale = 2)
	private float potenciaRed;

        @JsonProperty("internalPower")
	@Column(name = "potencia_interna", nullable = false, scale = 2)
	private float potenciaInterna;
	
        @JsonProperty("controlState")
	@Column(name = "estado_control", nullable = false)
	private boolean estadoControl = false;

	
	public float calcularPotenciaContinua() {
		return this.corrienteContinua * this.tensionContinua;
	}
	
	public float calcularPotenciaInterna() {
//		return (float) (Math.cos((double) Math.toRadians(this.desfasaje)) * this.corrienteInterna * this.tensionInterna);
            return this.corrienteInterna * this.tensionInterna;
	}
	
	public float calcularPotenciaRed() {
//		return (float) (Math.cos((double) Math.toRadians(this.desfasaje)) * this.corrienteRed * this.tensionRed);
            return this.corrienteInterna * this.tensionInterna;
	}

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getTensionRed() {
		return tensionRed;
	}

	public void setTensionRed(float tensionRed) {
		this.tensionRed = tensionRed;
	}

	public float getCorrienteRed() {
		return corrienteRed;
	}

	public void setCorrienteRed(float corrienteRed) {
		this.corrienteRed = corrienteRed;
	}

	public float getFrecuenciaTension() {
		return frecuenciaTension;
	}

	public void setFrecuenciaTension(float frecuenciaTension) {
		this.frecuenciaTension = frecuenciaTension;
	}

	public float getFrecuenciaCorriente() {
		return frecuenciaCorriente;
	}

	public void setFrecuenciaCorriente(float frecuenciaCorriente) {
		this.frecuenciaCorriente = frecuenciaCorriente;
	}

	public float getDesfasaje() {
		return desfasaje;
	}

	public void setDesfasaje(float desfasaje) {
		this.desfasaje = desfasaje;
	}

	public float getTensionTierra() {
		return tensionTierra;
	}

	public void setTensionTierra(float tensionTierra) {
		this.tensionTierra = tensionTierra;
	}

	public float getTensionInterna() {
		return tensionInterna;
	}

	public void setTensionInterna(float tensionInterna) {
		this.tensionInterna = tensionInterna;
	}

	public float getCorrienteInterna() {
		return corrienteInterna;
	}

	public void setCorrienteInterna(float corrienteInterna) {
		this.corrienteInterna = corrienteInterna;
	}

	public float getTensionContinua() {
		return tensionContinua;
	}

	public void setTensionContinua(float tensionContinua) {
		this.tensionContinua = tensionContinua;
	}

	public float getCorrienteContinua() {
		return corrienteContinua;
	}

	public void setCorrienteContinua(float corrienteContinua) {
		this.corrienteContinua = corrienteContinua;
	}

	public float getTemperatura1() {
		return temperatura1;
	}

	public void setTemperatura1(float temperatura1) {
		this.temperatura1 = temperatura1;
	}

	public float getTemperatura2() {
		return temperatura2;
	}

	public void setTemperatura2(float temperatura2) {
		this.temperatura2 = temperatura2;
	}

	public float getTemperatura3() {
		return temperatura3;
	}

	public void setTemperatura3(float temperatura3) {
		this.temperatura3 = temperatura3;
	}

	public float getTemperatura4() {
		return temperatura4;
	}

	public void setTemperatura4(float temperatura4) {
		this.temperatura4 = temperatura4;
	}

	public float getTemperatura5() {
		return temperatura5;
	}

	public void setTemperatura5(float temperatura5) {
		this.temperatura5 = temperatura5;
	}

	public float getHumedad() {
		return humedad;
	}

	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}

	public float getPvm() {
		return pvm;
	}

	public void setPvm(float pvm) {
		this.pvm = pvm;
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

	public float getPotenciaContinua() {
		return potenciaContinua;
	}

	public void setPotenciaContinua(float potenciaContinua) {
		this.potenciaContinua = potenciaContinua;
	}

	public float getPotenciaRed() {
		return potenciaRed;
	}

	public void setPotenciaRed(float potenciaRed) {
		this.potenciaRed = potenciaRed;
	}

	public float getPotenciaInterna() {
		return potenciaInterna;
	}

	public void setPotenciaInterna(float potenciaInterna) {
		this.potenciaInterna = potenciaInterna;
	}

	public boolean isEstadoControl() {
		return estadoControl;
	}

	public void setEstadoControl(boolean estadoControl) {
		this.estadoControl = estadoControl;
	}

}
