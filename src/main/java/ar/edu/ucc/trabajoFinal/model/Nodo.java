package ar.edu.ucc.trabajoFinal.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nodos")
public class Nodo extends ObjetoGenerico{
	
	@Column(name="moludo", length=50, nullable=false)
	private String modulo;
	
	@Column(name="numero", nullable=false)
	private int numero;
	
	@Column(name="activo", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean activo;
	
	@Column(name="descripcion", length=250, nullable=false)
	private String descripcion;

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj) return true;
//        if(!(obj instanceof Nodo)) return false;
//        Nodo nodo = (Nodo) obj;
//        return  Objects.equals(this.getId(), nodo.getId());
//    }
        
        

}
