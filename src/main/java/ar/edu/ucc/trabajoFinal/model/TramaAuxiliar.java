package ar.edu.ucc.trabajoFinal.model;

public class TramaAuxiliar {
	
	private Integer numero;
	private Float tensionRed;
	private Float corrienteRed;
	private Float frecuenciaTension;
	private Float frecuenciaCorriente;
	private Float desfasaje;
	private Float tensionTierra;
	private Float tensionInterna;
	private Float corrienteInterna;
	private Float tensionContinua;
	private Float corrienteContinua;
	private Float temperatura1;
	private Float temperatura2;
	private Float temperatura3;
	private Float temperatura4;
	private Float temperatura5;
	private Float humedad;
	private Float pvm;
	private Float potenciaContinua;
	private Float potenciaRed;
	private Float potenciaInterna;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Float getTensionRed() {
		return tensionRed;
	}
	public void setTensionRed(Float tensionRed) {
		this.tensionRed = (Float) tensionRed;
	}
	public Float getCorrienteRed() {
		return corrienteRed;
	}
	public void setCorrienteRed(Float corrienteRed) {
		this.corrienteRed = (Float) corrienteRed;
	}
	public Float getFrecuenciaTension() {
		return frecuenciaTension;
	}
	public void setFrecuenciaTension(Float frecuenciaTension) {
		this.frecuenciaTension = (Float) frecuenciaTension;
	}
	public Float getFrecuenciaCorriente() {
		return frecuenciaCorriente;
	}
	public void setFrecuenciaCorriente(Float frecuenciaCorriente) {
		this.frecuenciaCorriente = (Float) frecuenciaCorriente;
	}
	public Float getDesfasaje() {
		return desfasaje;
	}
	public void setDesfasaje(Float desfasaje) {
		this.desfasaje = (Float) desfasaje;
	}
	public Float getTensionTierra() {
		return tensionTierra;
	}
	public void setTensionTierra(Float tensionTierra) {
		this.tensionTierra = (Float) tensionTierra;
	}
	public Float getTensionInterna() {
		return tensionInterna;
	}
	public void setTensionInterna(Float tensionInterna) {
		this.tensionInterna = (Float) tensionInterna;
	}
	public Float getCorrienteInterna() {
		return corrienteInterna;
	}
	public void setCorrienteInterna(Float corrienteInterna) {
		this.corrienteInterna = (Float) corrienteInterna;
	}
	public Float getTensionContinua() {
		return tensionContinua;
	}
	public void setTensionContinua(Float tensionContinua) {
		this.tensionContinua = (Float) tensionContinua;
	}
	public Float getCorrienteContinua() {
		return corrienteContinua;
	}
	public void setCorrienteContinua(Float corrienteContinua) {
		this.corrienteContinua = (Float) corrienteContinua;
	}
	public Float getTemperatura1() {
		return temperatura1;
	}
	public void setTemperatura1(Float temperatura1) {
		this.temperatura1 = (Float) temperatura1;
	}
	public Float getTemperatura2() {
		return temperatura2;
	}
	public void setTemperatura2(Float temperatura2) {
		this.temperatura2 = (Float) temperatura2;
	}
	public Float getTemperatura3() {
		return temperatura3;
	}
	public void setTemperatura3(Float temperatura3) {
		this.temperatura3 = (Float) temperatura3;
	}
	public Float getTemperatura4() {
		return temperatura4;
	}
	public void setTemperatura4(Float temperatura4) {
		this.temperatura4 = (Float) temperatura4;
	}
	public Float getTemperatura5() {
		return temperatura5;
	}
	public void setTemperatura5(Float temperatura5) {
		this.temperatura5 = (Float) temperatura5;
	}
	public Float getHumedad() {
		return humedad;
	}
	public void setHumedad(Float humedad) {
		this.humedad = (Float) humedad;
	}
	public Float getPvm() {
		return pvm;
	}
	public void setPvm(Float pvm) {
		this.pvm = (Float) pvm;
	}
	public Float getPotenciaContinua() {
		return potenciaContinua;
	}
	public void setPotenciaContinua(Float potenciaContinua) {
		this.potenciaContinua = (Float) potenciaContinua;
	}
	public Float getPotenciaRed() {
		return potenciaRed;
	}
	public void setPotenciaRed(Float potenciaRed) {
		this.potenciaRed = (Float) potenciaRed;
	}
	public Float getPotenciaInterna() {
		return potenciaInterna;
	}
	public void setPotenciaInterna(Float potenciaInterna) {
		this.potenciaInterna = (Float) potenciaInterna;
	}
	
	public void setTensionRed(Double tensionRed) {
		this.tensionRed = (Float) tensionRed.floatValue();
	}

	public void setCorrienteRed(Double corrienteRed) {
		this.corrienteRed = (Float) corrienteRed.floatValue();
	}
	
	public void setFrecuenciaTension(Double frecuenciaTension) {
		this.frecuenciaTension = (Float) frecuenciaTension.floatValue();
	}

	public void setFrecuenciaCorriente(Double frecuenciaCorriente) {
		this.frecuenciaCorriente = (Float) frecuenciaCorriente.floatValue();
	}

	public void setDesfasaje(Double desfasaje) {
		this.desfasaje = (Float) desfasaje.floatValue();
	}

	public void setTensionTierra(Double tensionTierra) {
		this.tensionTierra = (Float) tensionTierra.floatValue();
	}

	public void setTensionInterna(Double tensionInterna) {
		this.tensionInterna = (Float) tensionInterna.floatValue();
	}

	public void setCorrienteInterna(Double corrienteInterna) {
		this.corrienteInterna = (Float) corrienteInterna.floatValue();
	}

	public void setTensionContinua(Double tensionContinua) {
		this.tensionContinua = (Float) tensionContinua.floatValue();
	}

	public void setCorrienteContinua(Double corrienteContinua) {
		this.corrienteContinua = (Float) corrienteContinua.floatValue();
	}

	public void setTemperatura1(Double temperatura1) {
		this.temperatura1 = (Float) temperatura1.floatValue();
	}

	public void setTemperatura2(Double temperatura2) {
		this.temperatura2 = (Float) temperatura2.floatValue();
	}

	public void setTemperatura3(Double temperatura3) {
		this.temperatura3 = (Float) temperatura3.floatValue();
	}

	public void setTemperatura4(Double temperatura4) {
		this.temperatura4 = (Float) temperatura4.floatValue();
	}

	public void setTemperatura5(Double temperatura5) {
		this.temperatura5 = (Float) temperatura5.floatValue();
	}

	public void setHumedad(Double humedad) {
		this.humedad = (Float) humedad.floatValue();
	}

	public void setPvm(Double pvm) {
		this.pvm = (Float) pvm.floatValue();
	}

	public void setPotenciaContinua(Double potenciaContinua) {
		this.potenciaContinua = (Float) potenciaContinua.floatValue();
	}

	public void setPotenciaRed(Double potenciaRed) {
		this.potenciaRed = (Float) potenciaRed.floatValue();
	}

	public void setPotenciaInterna(Double potenciaInterna) {
		this.potenciaInterna = (Float) potenciaInterna.floatValue();
	}
	
}
