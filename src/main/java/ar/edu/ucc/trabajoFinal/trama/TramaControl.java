package ar.edu.ucc.trabajoFinal.trama;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.dto.UmbralDto;
import ar.edu.ucc.trabajoFinal.service.UmbralService;

public class TramaControl {

	private static TramaControl instance = null;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	int nodo;
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
	@Autowired
	private UmbralService umbralService;
	@Autowired
	//private AlertaService alertaService;
	
	private TramaControl() {
		
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
		
		//CARGAR EN LA BASE DE DATOS PARA PROBAR
		//this.cargarUmbrales();
	}
	
	public static TramaControl getInstance() {
		if(instance == null) {
			instance = new TramaControl();
		}
		return instance;
	}
	
	public void cargarUmbrales() {
		UmbralDto umbralDto;
		for(Variable v : variablesAControlar) {
			umbralDto = new UmbralDto();
			umbralDto = umbralService.getUmbralByVariable(v.getNombre());
			v.getUmbral().setValorMax(umbralDto.getValorMax());
			v.getUmbral().setValorMin(umbralDto.getValorMin());
		}
	}
	
	public void cargarValoresActuales(TramaDto tramaDto) {
		this.nodo = tramaDto.getIpNodo();
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
	
	public void controlarTrama() {
		for(Variable v : variablesAControlar) {
			if(!v.controlarVariable(v.getValorActual())) {
				//alertaService.generarAlerta(v, this.nodo);
				log.info("Alerta generada por variable " + v.getNombre());
			};
		}
	}
}
