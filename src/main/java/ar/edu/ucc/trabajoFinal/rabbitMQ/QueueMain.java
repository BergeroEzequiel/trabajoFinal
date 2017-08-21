package ar.edu.ucc.trabajoFinal.rabbitMQ;



public class QueueMain {

	public static void main(String[] args) {

		// Publishes msg in the queue
		Producer producer = new Producer();

		// Produce 100 msgs
		String message = "{'ipNodo': 1, 'corrienteContinua': 1, 'corrienteInterna': 1, 'corrienteRed': 1,"
				+ "'desfasaje': 1, 'estado': true, 'fecha': 1, 'hora': 1, 'frecuenciaCorriente': 1, 'frecuenciaTension': 1, 'humedad': 1"
				+ ",'potenciaContinua': 1, 'potenciaInterna': 1, 'potenciaRed' :1 ,'pvm': 1, 'temperatura1': 1, 'temperatura2': 1,"
				+ "'temperatura3': 1, 'temperatura4' :1, 'temperatura5': 1, 'tensionContinua' : 1, 'tensionInterna' :1, 'tensionRed' :1,"
				+ "'tensionTierra': 1}";
		producer.publishMessage(message);

	}
}
