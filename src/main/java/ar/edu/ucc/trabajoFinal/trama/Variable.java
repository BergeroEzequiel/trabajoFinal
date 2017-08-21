package ar.edu.ucc.trabajoFinal.trama;

import ar.edu.ucc.trabajoFinal.model.Umbral;

public abstract class Variable {
	
	private String nombre;
	private float valorActual;
	private Umbral umbral;
	
	
	public boolean controlarVariable(float valorActual){
		if(this.umbral.getValorMax() > valorActual && valorActual > this.umbral.getValorMin()) return true;
		return false;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Umbral getUmbral() {
		return umbral;
	}


	public void setUmbral(Umbral umbral) {
		this.umbral = umbral;
	}


	public float getValorActual() {
		return valorActual;
	}


	public void setValorActual(float valorActual) {
		this.valorActual = valorActual;
	}
	
}