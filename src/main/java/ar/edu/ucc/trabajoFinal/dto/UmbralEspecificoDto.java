package ar.edu.ucc.trabajoFinal.dto;

public class UmbralEspecificoDto {
	
	private Long id;
	private boolean activo;
	private float valorMax;
	private float valorMin;
	private String nombreVariable;
	private String fechaUltimaModificacion;
	private int tipo;
	private Long idNodo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public float getValorMax() {
		return valorMax;
	}
	public void setValorMax(float valorMax) {
		this.valorMax = valorMax;
	}
	public float getValorMin() {
		return valorMin;
	}
	public void setValorMin(float valorMin) {
		this.valorMin = valorMin;
	}
	public String getNombreVariable() {
		return nombreVariable;
	}
	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}
	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(String date) {
		this.fechaUltimaModificacion = date;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Long getIdNodo() {
		return idNodo;
	}
	public void setIdNodo(Long idNodo) {
		this.idNodo = idNodo;
	}
	
}
