package ar.edu.ucc.trabajoFinal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="umbrales_especificos")
public class UmbralEspecifico extends Umbral {
	
	@Column(name="id_nodo")
	private Nodo nodo;

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}
	
	
	
}