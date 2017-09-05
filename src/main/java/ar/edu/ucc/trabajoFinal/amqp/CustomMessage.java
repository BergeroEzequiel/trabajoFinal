package ar.edu.ucc.trabajoFinal.amqp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;

public class CustomMessage {

	private TramaDto tramaDto;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

	public CustomMessage(TramaDto trama) {
		this.tramaDto = trama;
	}

	@Override
	public String toString() {
		return "{" + "'ip_nodo':" + tramaDto.getIpNodo() + ", 'estado':" + tramaDto.getEstado() + ", 'tension_red':"
				+ tramaDto.getTensionRed() + ", 'corriente_red':" + tramaDto.getCorrienteRed() 
				+ ", 'frecuencia_tension':" + tramaDto.getFrecuenciaTension() + ", 'frecuencia_corriente':"
				+ tramaDto.getFrecuenciaCorriente() + ", 'desfasaje':" + tramaDto.getDesfasaje() 
				+ ", 'tension_tierra':" + tramaDto.getTensionInterna() + ", 'tension_interna':"
				+ tramaDto.getTensionInterna() + ", 'corriente_interna':" + tramaDto.getCorrienteInterna() 
				+ ", 'tension_continua':" + tramaDto.getTensionContinua() + ", 'corriente_continua':"
				+ tramaDto.getCorrienteContinua() + ", 'temperatura1':" + tramaDto.getTemperatura1()
				+ ", 'temperatura2':" + tramaDto.getTemperatura2() + ", 'temperatura3':" + tramaDto.getTemperatura3()
				+ ", 'temperatura4':" + tramaDto.getTemperatura4() + ", 'temperatura5':"
				+ tramaDto.getTemperatura5() + ", 'humedad':" + tramaDto.getHumedad() + ", 'pvm':"
				+ tramaDto.getPvm() + ", 'fecha':" + tramaDto.getFecha() + ", 'hora':'"
				+ tramaDto.getHora() + "', 'potencia_continua':" + tramaDto.getPotenciaContinua()
				+ ", 'potencia_red':" + tramaDto.getPotenciaRed() + ", 'potencia_interna':"
				+ tramaDto.getPotenciaInterna() + '}';
	}
}
