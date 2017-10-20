package ar.edu.ucc.trabajoFinal.dto;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.edu.ucc.trabajoFinal.trama.Variable;

public class AlertaDto {

	public AlertaDto() {
		super();
	}

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

	public AlertaDto(Variable v, int nodo) {
		this.variableAfectada = v.getNombre();
		this.valor = v.getValorActual();
		if (this.valor > v.getUmbral().getValorMax()) {
			this.umbralSuperado = v.getUmbral().getValorMax();
		} else {
			this.umbralSuperado = v.getUmbral().getValorMin();
		}
		this.nodoAfectado = nodo;
		this.fecha = dateFormatter.format(new Date());
		this.hora = timeFormatter.format(new Date());
	}

	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String codigo;
	private String descripcion;
	private String variableAfectada;
	private float valor;
	private float umbralSuperado;
	private int nodoAfectado;
	private String fecha;
	private String hora;

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public float getUmbralSuperado() {
		return umbralSuperado;
	}

	public void setUmbralSuperado(float umbralSuperado) {
		this.umbralSuperado = umbralSuperado;
	}

	public int getNodoAfectado() {
		return nodoAfectado;
	}

	public void setNodoAfectado(int nodoAfectado) {
		this.nodoAfectado = nodoAfectado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "{" + "codigo:" + getCodigo() + "descripcion:" + getDescripcion()
		+ "variable_afectada:" + getVariableAfectada() + "valor:" + getValor() 
		+ "umbral_superado:" + getUmbralSuperado() 
		+ "nodo_afectado:" + getNodoAfectado() + "fecha:" + getFecha()
		+ "hora:" + getHora() + "}";
		
	}

}
