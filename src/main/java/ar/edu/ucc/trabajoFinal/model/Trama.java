package ar.edu.ucc.trabajoFinal.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitoreo_detalle")
public class Trama extends ObjetoGenerico {

	@Column(name = "ip_nodo", nullable = false)
	private int ipNodo;

	@Column(name = "estado", nullable = false)
	private boolean estado;
	
	@Column(name = "tension_red", nullable = false)
	private float tensionRed;

	@Column(name = "corriente_red", nullable = false)
	private float corrienteRed;

	@Column(name = "frecuencia_tension", nullable = false)
	private float frecuenciaTension;

	@Column(name = "frecuencia_corriente", nullable = false)
	private float frecuenciaCorriente;

	@Column(name = "desfasaje", nullable = false)
	private float desfasaje;

	@Column(name = "tension_tierra", nullable = false)
	private float tensionTierra;

	@Column(name = "tension_interna", nullable = false)
	private float tensionInterna;

	@Column(name = "corriente_interna", nullable = false)
	private float corrienteInterna;

	@Column(name = "tension_continua", nullable = false)
	private float tensionContinua;

	@Column(name = "corriente_continua", nullable = false)
	private float corrienteContinua;

	@Column(name = "temperatura1", nullable = false)
	private float temperatura1;

	@Column(name = "temperatura2", nullable = false)
	private float temperatura2;

	@Column(name = "temperatura3", nullable = false)
	private float temperatura3;

	@Column(name = "temperatura4", nullable = false)
	private float temperatura4;

	@Column(name = "temperatura5", nullable = false)
	private float temperatura5;

	@Column(name = "humedad", nullable = false)
	private float humedad;

	@Column(name = "pvm", nullable = false)
	private float pvm;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "hora", nullable = false)
	private Time hora;

	@Column(name = "potencia_continua", nullable = false)
	private float potenciaContinua;

	@Column(name = "potencia_red", nullable = false)
	private float potenciaRed;

	@Column(name = "potencia_interna", nullable = false)
	private float potenciaInterna;

	public int getIpNodo() {
		return ipNodo;
	}

	public void setIpNodo(int ipNodo) {
		this.ipNodo = ipNodo;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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

	private float calcularPotencia(float tension, float corriente) {
		return tension * corriente;
	}

}
