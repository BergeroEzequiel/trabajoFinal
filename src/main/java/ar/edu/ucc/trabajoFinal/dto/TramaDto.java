package ar.edu.ucc.trabajoFinal.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ar.edu.ucc.trabajoFinal.model.Nodo;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class TramaDto {
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	public TramaDto() {
		super();
	}
	
	public TramaDto(String jsonTramaDto) {
		JSONObject tramaJson = (JSONObject) JSONSerializer.toJSON(jsonTramaDto);
		this.corrienteContinua = ((float) tramaJson.getDouble("corriente_continua"));
		this.corrienteInterna = ((float) tramaJson.getDouble("corriente_interna"));
		this.corrienteRed = ((float) tramaJson.getDouble("corriente_red"));
		this.desfasaje=((float) tramaJson.getDouble("desfasaje"));
		this.estado=(tramaJson.getString("estado"));
		this.fecha=tramaJson.getString("fecha");
		this.hora=tramaJson.getString("hora");
		this.frecuenciaCorriente=((float) tramaJson.getDouble("frecuencia_corriente"));
		this.frecuenciaTension=((float) tramaJson.getDouble("frecuencia_tension"));
		this.humedad=((float) tramaJson.getDouble("humedad"));
		this.modulo=(tramaJson.getString("modulo"));
		this.numero=(tramaJson.getInt("numero"));
		
		this.potenciaContinua=((float) tramaJson.getDouble("potencia_continua"));
		this.potenciaInterna=((float) tramaJson.getDouble("potencia_interna"));
		this.potenciaRed=((float) tramaJson.getDouble("potencia_red"));
		this.pvm=((float) tramaJson.getDouble("pvm"));
		this.temperatura1=((float) tramaJson.getDouble("temperatura1"));
		this.temperatura2=((float) tramaJson.getDouble("temperatura2"));
		this.temperatura3=((float) tramaJson.getDouble("temperatura3"));
		this.temperatura4=((float) tramaJson.getDouble("temperatura4"));
		this.temperatura5=((float) tramaJson.getDouble("temperatura5"));
		this.tensionContinua=((float) tramaJson.getDouble("tension_continua"));
		this.tensionInterna=((float) tramaJson.getDouble("tension_interna"));
		this.tensionRed=((float) tramaJson.getDouble("tension_red"));
		this.tensionTierra=((float) tramaJson.getDouble("tension_tierra"));
		this.estadoControl=(tramaJson.getBoolean("estado_control"));
	}
	
	private Long id;
	
	private String modulo;

	private int numero;
	
	private Nodo nodo;

	private String estado;

	private float tensionRed;

	private float corrienteRed;	

	private float frecuenciaTension;

	private float frecuenciaCorriente;

	private float desfasaje;

	private float tensionTierra;

	private float tensionInterna;

	private float corrienteInterna;

	private float tensionContinua;

	private float corrienteContinua;

	private float temperatura1;

	private float temperatura2;

	private float temperatura3;

	private float temperatura4;

	private float temperatura5;

	private float humedad;

	private float pvm;

	private String fecha;

	private String hora;

	private float potenciaContinua;

	private float potenciaRed;

	private float potenciaInterna;
	
	private boolean estadoControl = false;
	
	
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

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	public boolean getEstadoControl() {
		return estadoControl;
	}

	public void setEstadoControl(boolean estadoControl) {
		this.estadoControl = estadoControl;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getTensionRed() {
		return tensionRed;
	}

	public void setTensionRed(float tensionRed) {
		this.tensionRed = tensionRed;
	}

	public float getCorrienteRed() {
		return corrienteRed;
	}

	public void setCorrienteRed(float corrienteRed) {
		this.corrienteRed = corrienteRed;
	}

	public float getFrecuenciaTension() {
		return frecuenciaTension;
	}

	public void setFrecuenciaTension(float frecuenciaTension) {
		this.frecuenciaTension = frecuenciaTension;
	}

	public float getFrecuenciaCorriente() {
		return frecuenciaCorriente;
	}

	public void setFrecuenciaCorriente(float frecuenciaCorriente) {
		this.frecuenciaCorriente = frecuenciaCorriente;
	}

	public float getDesfasaje() {
		return desfasaje;
	}

	public void setDesfasaje(float desfasaje) {
		this.desfasaje = desfasaje;
	}

	public float getTensionTierra() {
		return tensionTierra;
	}

	public void setTensionTierra(float tensionTierra) {
		this.tensionTierra = tensionTierra;
	}

	public float getTensionInterna() {
		return tensionInterna;
	}

	public void setTensionInterna(float tensionInterna) {
		this.tensionInterna = tensionInterna;
	}

	public float getCorrienteInterna() {
		return corrienteInterna;
	}

	public void setCorrienteInterna(float corrienteInterna) {
		this.corrienteInterna = corrienteInterna;
	}

	public float getTensionContinua() {
		return tensionContinua;
	}

	public void setTensionContinua(float tensionContinua) {
		this.tensionContinua = tensionContinua;
	}

	public float getCorrienteContinua() {
		return corrienteContinua;
	}

	public void setCorrienteContinua(float corrienteContinua) {
		this.corrienteContinua = corrienteContinua;
	}

	public float getTemperatura1() {
		return temperatura1;
	}

	public void setTemperatura1(float temperatura1) {
		this.temperatura1 = temperatura1;
	}

	public float getTemperatura2() {
		return temperatura2;
	}

	public void setTemperatura2(float temperatura2) {
		this.temperatura2 = temperatura2;
	}

	public float getTemperatura3() {
		return temperatura3;
	}

	public void setTemperatura3(float temperatura3) {
		this.temperatura3 = temperatura3;
	}

	public float getTemperatura4() {
		return temperatura4;
	}

	public void setTemperatura4(float temperatura4) {
		this.temperatura4 = temperatura4;
	}

	public float getTemperatura5() {
		return temperatura5;
	}

	public void setTemperatura5(float temperatura5) {
		this.temperatura5 = temperatura5;
	}

	public float getHumedad() {
		return humedad;
	}

	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}

	public float getPvm() {
		return pvm;
	}

	public void setPvm(float pvm) {
		this.pvm = pvm;
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

	public float getPotenciaContinua() {
		return potenciaContinua;
	}

	public void setPotenciaContinua(float potenciaContinua) {
		this.potenciaContinua = potenciaContinua;
	}

	public float getPotenciaRed() {
		return potenciaRed;
	}

	public void setPotenciaRed(float potenciaRed) {
		this.potenciaRed = potenciaRed;
	}

	public float getPotenciaInterna() {
		return potenciaInterna;
	}

	public void setPotenciaInterna(float potenciaInterna) {
		this.potenciaInterna = potenciaInterna;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "{" + "nodo=" + getModulo() + ", numero='" + getNumero() + '\'' + ", estado='" + getEstado() + '\'' + ", tension_red='"
				+ getTensionRed() + '\'' + ", corriente_red='" + getCorrienteRed() + '\''
				+ ", frecuencia_tension='" + getFrecuenciaTension() + '\'' + ", frecuencia_corriente='"
				+ getFrecuenciaCorriente() + '\'' + ", desfasaje='" + getDesfasaje() + '\''
				+ ", tension_tierra='" + getTensionInterna() + '\'' + ", tension_interna='"
				+ getTensionInterna() + '\'' + ", corriente_interna='" + getCorrienteInterna() + '\''
				+ ", tension_continua='" + getTensionContinua() + '\'' + ", corriente_continua='"
				+ getCorrienteContinua() + '\'' + ", temperatura1='" + getTemperatura1() + '\''
				+ ", temperatura2='" + getTemperatura2() + '\'' + ", temperatura3='" + getTemperatura3()
				+ '\'' + ", temperatura4='" + getTemperatura4() + '\'' + ", temperatura5='"
				+ getTemperatura5() + '\'' + ", humedad='" + getHumedad() + '\'' + ", pvm='"
				+ getPvm() + '\'' + ", fecha='" + getFecha() + '\'' + ", hora='"
				+ getHora() + '\'' + ", potencia_continua='" + getPotenciaContinua()
				+ '\'' + ", potencia_red='" + getPotenciaRed() + '\'' + ", potencia_interna='"
				+ getPotenciaInterna() + '\'' + ", estado_control='" + getEstadoControl() + '}';
	}
	

}
