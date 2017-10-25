package ar.edu.ucc.trabajoFinal.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.ucc.trabajoFinal.dto.UmbralDto;
import ar.edu.ucc.trabajoFinal.service.UmbralService;
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

public class UmbralesSingleton {
	private static UmbralesSingleton instance = null;
//	String modulo;
//	int numero;
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
	
	UmbralService umbralService = SpringContextBridge.services().getUmbralService();

	private UmbralesSingleton() {

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

	public static UmbralesSingleton getInstance() {
		if (instance == null) {
			instance = new UmbralesSingleton();
		}
		return instance;
	}

	public void cargarUmbrales() {
		UmbralDto umbralDto;
		for (Variable v : variablesAControlar) {
			umbralDto = new UmbralDto();
			umbralDto = umbralService.getUmbralByVariable(v.getNombre());
			v.getUmbral().setActivo(umbralDto.isActivo());
			v.getUmbral().setValorMax(umbralDto.getValorMax());
			v.getUmbral().setValorMin(umbralDto.getValorMin());
		}
	}

}
