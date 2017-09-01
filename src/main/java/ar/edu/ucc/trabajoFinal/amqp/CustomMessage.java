package ar.edu.ucc.trabajoFinal.amqp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Trama;

public class CustomMessage {

	private TramaDto trama;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
	DateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");

	public CustomMessage(TramaDto trama) {
		this.trama = trama;
	}

//	public Trama getTrama() {
//		return this.trama;
//	}

	@Override
	public String toString() {
		return "{" + "ip_nodo=" + trama.getIpNodo() + ", estado='" + trama.getEstado() + '\'' + ", tension_red='"
				+ trama.getTensionRed() + '\'' + ", corriente_red='" + trama.getCorrienteRed() + '\''
				+ ", frecuencia_tension='" + trama.getFrecuenciaTension() + '\'' + ", frecuencia_corriente='"
				+ trama.getFrecuenciaCorriente() + '\'' + ", desfasaje='" + trama.getDesfasaje() + '\''
				+ ", tension_tierra='" + trama.getTensionInterna() + '\'' + ", tension_interna='"
				+ trama.getTensionInterna() + '\'' + ", corriente_interna='" + trama.getCorrienteInterna() + '\''
				+ ", tension_continua='" + trama.getTensionContinua() + '\'' + ", corriente_continua='"
				+ trama.getCorrienteContinua() + '\'' + ", temperatura1='" + trama.getTemperatura1() + '\''
				+ ", temperatura2='" + trama.getTemperatura2() + '\'' + ", temperatura3='" + trama.getTemperatura3()
				+ '\'' + ", temperatura4='" + trama.getTemperatura4() + '\'' + ", temperatura5='"
				+ trama.getTemperatura5() + '\'' + ", humedad='" + trama.getHumedad() + '\'' + ", pvm='"
				+ trama.getPvm() + '\'' + ", fecha='" + dateFormatter.format(trama.getFecha()) + '\'' + ", hora='"
				+ timeFormatter.format(trama.getHora()) + '\'' + ", potencia_continua='" + trama.getPotenciaContinua()
				+ '\'' + ", potencia_red='" + trama.getPotenciaRed() + '\'' + ", potencia_interna='"
				+ trama.getPotenciaInterna() + '\'' + '}';
	}
}
