package ar.edu.ucc.trabajoFinal.utils;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;

public class TramaControlHandler implements Runnable {

	private TramaDto tramaDto;

	public TramaControlHandler(TramaDto trama) {
		this.tramaDto = trama;
	}

	public void run() {
		TramaControl tramaControl = new TramaControl();
		tramaControl.cargarValoresActuales(this.tramaDto);
		tramaControl.controlarTrama(this.tramaDto);

	}
}