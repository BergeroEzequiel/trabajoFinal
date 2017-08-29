package ar.edu.ucc.trabajoFinal.model;

public abstract class Variable extends ObjetoGenerico{
	
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