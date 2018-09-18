package ar.edu.ucc.trabajoFinal.model;

import java.sql.Time;

public class TramaPotencias {
	
	private Nodo nodo;
	private Float potenciaContinua;
	private Float potenciaRed;
	private Float potenciaInterna;
	private Time hora;

        public Nodo getNodo() {
            return nodo;
        }

        public void setNodo(Nodo nodo) {
            this.nodo = nodo;
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
