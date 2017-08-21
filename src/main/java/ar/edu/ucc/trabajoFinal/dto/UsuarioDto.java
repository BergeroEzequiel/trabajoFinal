package ar.edu.ucc.trabajoFinal.dto;

import java.util.Date;

public class UsuarioDto {
	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String nombreCuenta;
	
	private String rol;
	
	private String email;
	
	private boolean estadoSistema;
	
	private Date ultimaConeccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEstadoSistema() {
		return estadoSistema;
	}

	public void setEstadoSistema(boolean estadoSistema) {
		this.estadoSistema = estadoSistema;
	}

	public Date getUltimaConeccion() {
		return ultimaConeccion;
	}

	public void setUltimaConeccion(Date ultimaConeccion) {
		this.ultimaConeccion = ultimaConeccion;
	}

}
