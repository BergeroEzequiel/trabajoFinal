package ar.edu.ucc.trabajoFinal.model;

public enum Rol {
	ADMIN("Administrador"), UB("Usuario Basico"), UA("Usuario Avanzado"), UNR("Usuario no registrado");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	private Rol(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
