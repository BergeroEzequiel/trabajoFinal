package ar.edu.ucc.trabajoFinal.utils;

import java.util.concurrent.BlockingQueue;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;

public class TramaControlHandler implements Runnable {
	private BlockingQueue<TramaDto> queue;
	// private TramaControl tramaControl = TramaControl.getInstance();

	public void encolarTrama(TramaDto tramaAControlar) {
		queue.add(tramaAControlar);
	}

	public void run() {
		try {
			while (true) {
				TramaDto trama = queue.take();
				TramaControl tramaControl = new TramaControl();
				tramaControl.cargarValoresActuales(trama);
				tramaControl.controlarTrama();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}