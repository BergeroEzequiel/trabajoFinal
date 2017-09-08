package ar.edu.ucc.trabajoFinal.utils;
import java.util.concurrent.BlockingQueue;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.trama.TramaControl;

public class TramaControlHandler implements Runnable{
    private BlockingQueue<TramaDto> queue;
    TramaControl tramaControl = TramaControl.getInstance();

    public void encolarTrama(TramaDto tramaAControlar) {
        queue.add(tramaAControlar);
    }

    public void run() {
        try {
            while (true) {
                TramaDto trama = queue.take();
                tramaControl.cargarValoresActuales(trama);
                tramaControl.controlarTrama();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}