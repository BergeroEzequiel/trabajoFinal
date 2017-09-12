package ar.edu.ucc.trabajoFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario extends ObjetoGenerico{
	
	@Column(name="nombre", length=50, nullable=false)
	private String nombre;
	
	@Column(name="apellido", length=50, nullable=false)
	private String apellido;
	
	@Column(name="nombre_cuenta", length=50, nullable=false)
	private String nombreCuenta;
	
	@Column(name="password", length=16, nullable=false)
	private String password;
	
	@Column(name="email", length=200, nullable=false)
	private String email;
	
	@Column(name = "activo", nullable = false)	
	private boolean activo = false;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", nullable = false)
	private Roles rol;
	
//	@Column(name="ultima_coneccion", length=200, nullable=false)
//	private Date ultimaConeccion;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

//	public Date getUltimaConeccion() {
//		return ultimaConeccion;
//	}
//
//	public void setUltimaConeccion(Date ultimaConeccion) {
//		this.ultimaConeccion = ultimaConeccion;
//	}
	

}
