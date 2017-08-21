package ar.edu.ucc.trabajoFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	//--------------------------- VER ------------------------------
	@Enumerated(EnumType.STRING)
	@Column(name="rol", length=200, nullable=false)
	private Rol rol;
	
	//---------------------------- VER -----------------------------
	//private EstadoCuenta estadoCuenta;
	
	@Column(name="estado_sistema", nullable=false)
	private boolean estadoSistema;
	
	@Column(name="ultima_coneccion", length=200, nullable=false)
	private Date ultimaConeccion;

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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public boolean getEstadoSistema() {
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
