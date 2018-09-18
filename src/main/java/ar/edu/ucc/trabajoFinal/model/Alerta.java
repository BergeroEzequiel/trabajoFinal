package ar.edu.ucc.trabajoFinal.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import ar.edu.ucc.trabajoFinal.trama.Variable;


@Entity
@Table(name="alertas")
public class Alerta extends ObjetoGenerico{
		
	@Column(name="descripcion", length=50, nullable=false)
	private String descripcion;
	
	@Column(name="variable_afectada", length=50, nullable=false)
	private String variableAfectada;
	
	@Column(name="valor", length=50)
	private Float valor;

	@ManyToOne
	@JoinColumn(name="id_umbral", nullable = true)
	private Umbral umbralSuperado;
	
	@ManyToOne
	@JoinColumn(name="id_nodo")
	private Nodo nodo;
	
	@ManyToOne
	@JoinColumn(name="id_criticidad")
	private Criticidad criticidad;
	
	@Column(name="visualizar", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private boolean visualizar;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column(name="hora", nullable=false)
	private Time hora;
	
	public Alerta() {
		super();
	}
	
	public Alerta(Variable v, Nodo nodo) {
		this.descripcion="variable fuera de umbral";
		this.variableAfectada = v.getNombre();
		this.valor = v.getValorActual();
		this.umbralSuperado = v.getUmbral();
		this.nodo = nodo;
		this.criticidad = v.getUmbral().getCriticidad();
		this.fecha = new Date();
		this.hora = new Time(System.currentTimeMillis());
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVariableAfectada() {
		return variableAfectada;
	}

	public void setVariableAfectada(String variableAfectada) {
		this.variableAfectada = variableAfectada;
	}
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Umbral getUmbralSuperado() {
		return umbralSuperado;
	}

	public void setUmbralSuperado(Umbral umbralSuperado) {
		this.umbralSuperado = umbralSuperado;
	}

        public Nodo getNodo() {
            return nodo;
        }

        public void setNodo(Nodo nodo) {
            this.nodo = nodo;
        }


	public Criticidad getCriticidad() {
		return criticidad;
	}

	public void setCriticidad(Criticidad criticidad) {
		this.criticidad = criticidad;
	}

	public boolean isVisualizar() {
		return visualizar;
	}

	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
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

}
