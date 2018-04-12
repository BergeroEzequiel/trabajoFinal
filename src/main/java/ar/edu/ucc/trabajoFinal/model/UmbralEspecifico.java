package ar.edu.ucc.trabajoFinal.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="umbrales_especificos")
@DiscriminatorValue("especifico")
public class UmbralEspecifico extends Umbral {
	
	@ManyToOne
	@JoinColumn(name="id_nodo")
	private Nodo nodo;

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}
	
	
	
}