package ar.edu.ucc.trabajoFinal.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ar.edu.ucc.trabajoFinal.dto.AlertaDto;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.service.AlertaService;
import ar.edu.ucc.trabajoFinal.trama.CorrienteContinua;
import ar.edu.ucc.trabajoFinal.trama.CorrienteInterna;
import ar.edu.ucc.trabajoFinal.trama.CorrienteRed;
import ar.edu.ucc.trabajoFinal.trama.Desfasaje;
import ar.edu.ucc.trabajoFinal.trama.FrecuenciaCorriente;
import ar.edu.ucc.trabajoFinal.trama.FrecuenciaTension;
import ar.edu.ucc.trabajoFinal.trama.Humedad;
import ar.edu.ucc.trabajoFinal.trama.PotenciaContinua;
import ar.edu.ucc.trabajoFinal.trama.PotenciaInterna;
import ar.edu.ucc.trabajoFinal.trama.PotenciaRed;
import ar.edu.ucc.trabajoFinal.trama.Pvm;
import ar.edu.ucc.trabajoFinal.trama.Temperatura1;
import ar.edu.ucc.trabajoFinal.trama.Temperatura2;
import ar.edu.ucc.trabajoFinal.trama.Temperatura3;
import ar.edu.ucc.trabajoFinal.trama.Temperatura4;
import ar.edu.ucc.trabajoFinal.trama.Temperatura5;
import ar.edu.ucc.trabajoFinal.trama.TensionContinua;
import ar.edu.ucc.trabajoFinal.trama.TensionInterna;
import ar.edu.ucc.trabajoFinal.trama.TensionRed;
import ar.edu.ucc.trabajoFinal.trama.TensionTierra;
import ar.edu.ucc.trabajoFinal.trama.Variable;
import okhttp3.Response;

public class TramaControl {
	private Logger log = Logger.getLogger(this.getClass());
	private PeticionPost peticionPost = new PeticionPost();
	private Response response;

	String modulo;
	int numero;
	Variable tensionRed;
	Variable corrienteRed;
	Variable frecuenciaTension;
	Variable frecuenciaCorriente;
	Variable desfasaje;
	Variable tensionTierra;
	Variable tensionInterna;
	Variable corrienteInterna;
	Variable tensionContinua;
	Variable corrienteContinua;
	Variable temperatura1;
	Variable temperatura2;
	Variable temperatura3;
	Variable temperatura4;
	Variable temperatura5;
	Variable humedad;
	Variable pvm;
	Variable potenciaContinua;
	Variable potenciaInterna;
	Variable potenciaRed;
	List<Variable> variablesAControlar;
	
	AlertaService alertaService = SpringContextBridge.services().getAlertaService();

	public TramaControl() {

		this.tensionRed = new TensionRed();
		this.corrienteRed = new CorrienteRed();
		this.frecuenciaTension = new FrecuenciaTension();
		this.frecuenciaCorriente = new FrecuenciaCorriente();
		this.desfasaje = new Desfasaje();
		this.tensionTierra = new TensionTierra();
		this.tensionInterna = new TensionInterna();
		this.corrienteInterna = new CorrienteInterna();
		this.tensionContinua = new TensionContinua();
		this.corrienteContinua = new CorrienteContinua();
		this.temperatura1 = new Temperatura1();
		this.temperatura2 = new Temperatura2();
		this.temperatura3 = new Temperatura3();
		this.temperatura4 = new Temperatura4();
		this.temperatura5 = new Temperatura5();
		this.humedad = new Humedad();
		this.pvm = new Pvm();
		this.potenciaContinua = new PotenciaContinua();
		this.potenciaInterna = new PotenciaInterna();
		this.potenciaRed = new PotenciaRed();

		this.variablesAControlar = new ArrayList<Variable>();
		variablesAControlar.add(corrienteContinua);
		variablesAControlar.add(corrienteInterna);
		variablesAControlar.add(corrienteRed);
		variablesAControlar.add(desfasaje);
		variablesAControlar.add(frecuenciaCorriente);
		variablesAControlar.add(frecuenciaTension);
		variablesAControlar.add(humedad);
		variablesAControlar.add(potenciaContinua);
		variablesAControlar.add(potenciaInterna);
		variablesAControlar.add(potenciaRed);
		variablesAControlar.add(temperatura1);
		variablesAControlar.add(temperatura2);
		variablesAControlar.add(temperatura3);
		variablesAControlar.add(temperatura4);
		variablesAControlar.add(temperatura4);
		variablesAControlar.add(temperatura5);
		variablesAControlar.add(tensionContinua);
		variablesAControlar.add(tensionInterna);
		variablesAControlar.add(tensionRed);
		variablesAControlar.add(pvm);

		this.cargarUmbrales();
	}

	public void cargarUmbrales() {
		UmbralesSingleton umbral = UmbralesSingleton.getInstance();
		this.tensionRed.getUmbral().setValorMax(umbral.tensionRed.getUmbral().getValorMax());
		this.tensionRed.getUmbral().setValorMin(umbral.tensionRed.getUmbral().getValorMin());
		this.tensionRed.getUmbral().setActivo(umbral.tensionRed.getUmbral().isActivo());
		this.corrienteRed.getUmbral().setValorMax(umbral.corrienteRed.getUmbral().getValorMax());
		this.corrienteRed.getUmbral().setValorMin(umbral.corrienteRed.getUmbral().getValorMin());
		this.corrienteRed.getUmbral().setActivo(umbral.corrienteRed.getUmbral().isActivo());
		this.frecuenciaTension.getUmbral().setValorMax(umbral.frecuenciaTension.getUmbral().getValorMax());
		this.frecuenciaTension.getUmbral().setValorMin(umbral.frecuenciaTension.getUmbral().getValorMin());
		this.frecuenciaTension.getUmbral().setActivo(umbral.frecuenciaTension.getUmbral().isActivo());
		this.frecuenciaCorriente.getUmbral().setValorMax(umbral.frecuenciaCorriente.getUmbral().getValorMax());
		this.frecuenciaCorriente.getUmbral().setValorMin(umbral.frecuenciaCorriente.getUmbral().getValorMin());
		this.frecuenciaCorriente.getUmbral().setActivo(umbral.frecuenciaCorriente.getUmbral().isActivo());
		this.desfasaje.getUmbral().setValorMax(umbral.desfasaje.getUmbral().getValorMax());
		this.desfasaje.getUmbral().setValorMin(umbral.desfasaje.getUmbral().getValorMin());
		this.desfasaje.getUmbral().setActivo(umbral.desfasaje.getUmbral().isActivo());
		this.tensionTierra.getUmbral().setValorMax(umbral.tensionTierra.getUmbral().getValorMax());
		this.tensionTierra.getUmbral().setValorMin(umbral.tensionTierra.getUmbral().getValorMin());
		this.tensionTierra.getUmbral().setActivo(umbral.tensionTierra.getUmbral().isActivo());
		this.tensionInterna.getUmbral().setValorMax(umbral.tensionInterna.getUmbral().getValorMax());
		this.tensionInterna.getUmbral().setValorMin(umbral.tensionInterna.getUmbral().getValorMin());
		this.tensionInterna.getUmbral().setActivo(umbral.tensionInterna.getUmbral().isActivo());
		this.corrienteInterna.getUmbral().setValorMax(umbral.corrienteInterna.getUmbral().getValorMax());
		this.corrienteInterna.getUmbral().setValorMin(umbral.corrienteInterna.getUmbral().getValorMin());
		this.corrienteInterna.getUmbral().setActivo(umbral.corrienteInterna.getUmbral().isActivo());
		this.tensionContinua.getUmbral().setValorMax(umbral.tensionContinua.getUmbral().getValorMax());
		this.tensionContinua.getUmbral().setValorMin(umbral.tensionContinua.getUmbral().getValorMin());
		this.tensionContinua.getUmbral().setActivo(umbral.tensionContinua.getUmbral().isActivo());
		this.corrienteContinua.getUmbral().setValorMax(umbral.corrienteContinua.getUmbral().getValorMax());
		this.corrienteContinua.getUmbral().setValorMin(umbral.corrienteContinua.getUmbral().getValorMin());
		this.corrienteContinua.getUmbral().setActivo(umbral.corrienteContinua.getUmbral().isActivo());
		this.temperatura1.getUmbral().setValorMax(umbral.temperatura1.getUmbral().getValorMax());
		this.temperatura1.getUmbral().setValorMin(umbral.temperatura1.getUmbral().getValorMin());
		this.temperatura1.getUmbral().setActivo(umbral.temperatura1.getUmbral().isActivo());
		this.temperatura2.getUmbral().setValorMax(umbral.temperatura2.getUmbral().getValorMax());
		this.temperatura2.getUmbral().setValorMin(umbral.temperatura2.getUmbral().getValorMin());
		this.temperatura2.getUmbral().setActivo(umbral.temperatura2.getUmbral().isActivo());
		this.temperatura3.getUmbral().setValorMax(umbral.temperatura3.getUmbral().getValorMax());
		this.temperatura3.getUmbral().setValorMin(umbral.temperatura3.getUmbral().getValorMin());
		this.temperatura3.getUmbral().setActivo(umbral.temperatura3.getUmbral().isActivo());
		this.temperatura4.getUmbral().setValorMax(umbral.temperatura4.getUmbral().getValorMax());
		this.temperatura4.getUmbral().setValorMin(umbral.temperatura4.getUmbral().getValorMin());
		this.temperatura4.getUmbral().setActivo(umbral.temperatura4.getUmbral().isActivo());
		this.temperatura5.getUmbral().setValorMax(umbral.temperatura5.getUmbral().getValorMax());
		this.temperatura5.getUmbral().setValorMin(umbral.temperatura5.getUmbral().getValorMin());
		this.temperatura5.getUmbral().setActivo(umbral.temperatura5.getUmbral().isActivo());
		this.humedad.getUmbral().setValorMax(umbral.humedad.getUmbral().getValorMax());
		this.humedad.getUmbral().setValorMin(umbral.humedad.getUmbral().getValorMin());
		this.humedad.getUmbral().setActivo(umbral.humedad.getUmbral().isActivo());
		this.pvm.getUmbral().setValorMax(umbral.pvm.getUmbral().getValorMax());
		this.pvm.getUmbral().setValorMin(umbral.pvm.getUmbral().getValorMin());
		this.pvm.getUmbral().setActivo(umbral.pvm.getUmbral().isActivo());
		this.potenciaContinua.getUmbral().setValorMax(umbral.potenciaContinua.getUmbral().getValorMax());
		this.potenciaContinua.getUmbral().setValorMin(umbral.potenciaContinua.getUmbral().getValorMin());
		this.potenciaContinua.getUmbral().setActivo(umbral.potenciaContinua.getUmbral().isActivo());
		this.potenciaInterna.getUmbral().setValorMax(umbral.potenciaInterna.getUmbral().getValorMax());
		this.potenciaInterna.getUmbral().setValorMin(umbral.potenciaInterna.getUmbral().getValorMin());
		this.potenciaInterna.getUmbral().setActivo(umbral.potenciaInterna.getUmbral().isActivo());
		this.potenciaRed.getUmbral().setValorMax(umbral.potenciaRed.getUmbral().getValorMax());
		this.potenciaRed.getUmbral().setValorMin(umbral.potenciaRed.getUmbral().getValorMin());
		this.potenciaRed.getUmbral().setActivo(umbral.potenciaRed.getUmbral().isActivo());
	}

	public void cargarValoresActuales(TramaDto tramaDto) {
		this.modulo = tramaDto.getModulo();
		this.numero = tramaDto.getNumero();
		this.tensionRed.setValorActual(tramaDto.getTensionRed());
		this.corrienteRed.setValorActual(tramaDto.getCorrienteRed());
		this.frecuenciaTension.setValorActual(tramaDto.getFrecuenciaTension());
		this.frecuenciaCorriente.setValorActual(tramaDto.getFrecuenciaCorriente());
		this.desfasaje.setValorActual(tramaDto.getDesfasaje());
		this.tensionTierra.setValorActual(tramaDto.getTensionTierra());
		this.tensionInterna.setValorActual(tramaDto.getTensionInterna());
		this.corrienteInterna.setValorActual(tramaDto.getCorrienteInterna());
		this.tensionContinua.setValorActual(tramaDto.getTensionContinua());
		this.corrienteContinua.setValorActual(tramaDto.getCorrienteContinua());
		this.temperatura1.setValorActual(tramaDto.getTemperatura1());
		this.temperatura2.setValorActual(tramaDto.getTemperatura2());
		this.temperatura3.setValorActual(tramaDto.getTemperatura3());
		this.temperatura4.setValorActual(tramaDto.getTemperatura4());
		this.temperatura5.setValorActual(tramaDto.getTemperatura5());
		this.humedad.setValorActual(tramaDto.getHumedad());
		this.pvm.setValorActual(tramaDto.getPvm());
		this.potenciaContinua.setValorActual(tramaDto.getPotenciaContinua());
		this.potenciaInterna.setValorActual(tramaDto.getPotenciaInterna());
		this.potenciaRed.setValorActual(tramaDto.getPotenciaRed());
	}

	public void controlarTrama(TramaDto tramaDto) throws ParseException {
		for (Variable v : variablesAControlar) {
			if (v.controlarVariable(v.getValorActual()) == false) {
				AlertaDto alertaDto = new AlertaDto(v, this.numero);
				if(v.getUmbral().isActivo()) {
					alertaDto.setVisualizar(true);
				} else alertaDto.setVisualizar(false);
				alertaService.grabarAlerta(alertaDto);
			}
		}
		tramaDto.setEstadoControl(true);
	}
	
}
