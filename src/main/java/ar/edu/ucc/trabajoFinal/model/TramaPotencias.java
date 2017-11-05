package ar.edu.ucc.trabajoFinal.model;

import java.sql.Time;

public class TramaPotencias {
	
	private int ipNodo;
	private Float potenciaContinua;
	private Float potenciaRed;
	private Float potenciaInterna;
	private Time hora;
	public int getIpNodo() {
		return ipNodo;
	}
	public void setIpNodo(int ipNodo) {
		this.ipNodo = ipNodo;	
	}
	public Float getPotenciaContinua() {
		return potenciaContinua;
	}
	public void setPotenciaContinua(Float potenciaContinua) {
		this.potenciaContinua = potenciaContinua;
	}
	public Float getPotenciaRed() {
		return potenciaRed;
	}
	public void setPotenciaRed(Float potenciaRed) {
		this.potenciaRed = potenciaRed;
	}
	public Float getPotenciaInterna() {
		return potenciaInterna;
	}
	public void setPotenciaInterna(Float potenciaInterna) {
		this.potenciaInterna = potenciaInterna;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
		
	
}
