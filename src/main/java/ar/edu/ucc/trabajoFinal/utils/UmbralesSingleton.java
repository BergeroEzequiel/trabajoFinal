package ar.edu.ucc.trabajoFinal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.ucc.trabajoFinal.model.Umbral;
import ar.edu.ucc.trabajoFinal.service.UmbralService;
import ar.edu.ucc.trabajoFinal.trama.Variable;

public class UmbralesSingleton {
	private static UmbralesSingleton instance = null;
	private Variable tensionRed;
	private Variable corrienteRed;
	private Variable frecuenciaTension;
	private Variable frecuenciaCorriente;
	private Variable desfasaje;
	private Variable tensionTierra;
	private Variable tensionInterna;
	private Variable corrienteInterna;
	private Variable tensionContinua;
	private Variable corrienteContinua;
	private Variable temperatura1;
	private Variable temperatura2;
	private Variable temperatura3;
	private Variable temperatura4;
	private Variable temperatura5;
	private Variable humedad;
	private Variable pvm;
	private Variable potenciaContinua;
	private Variable potenciaInterna;
	private Variable potenciaRed;
	private List<Variable> variablesAControlar;
	
	UmbralService umbralService = SpringContextBridge.services().getUmbralService();
	private Map<String, Umbral> mapUmbrales = new HashMap<String, Umbral>();

	private UmbralesSingleton() {

		this.tensionRed = new Variable("tension_red");
		this.corrienteRed = new Variable("corriente_red");
		this.frecuenciaTension = new Variable("frecuencia_tension");
		this.frecuenciaCorriente = new Variable("frecuencia_corriente");
		this.desfasaje = new Variable("desfasaje");
		this.tensionTierra = new Variable("tension_tierra");
		this.tensionInterna = new Variable("tension_interna");
		this.corrienteInterna = new Variable("corriente_interna");
		this.tensionContinua = new Variable("tension_continua");
		this.corrienteContinua = new Variable("corriente_continua");
		this.temperatura1 = new Variable("temperatura1");
		this.temperatura2 = new Variable("temperatura2");
		this.temperatura3 = new Variable("temperatura3");
		this.temperatura4 = new Variable("temperatura4");
		this.temperatura5 = new Variable("temperatura5");
		this.humedad = new Variable("humedad");
		this.pvm = new Variable("pvm");
		this.potenciaContinua = new Variable("potencia_continua");
		this.potenciaInterna = new Variable("potencia_interna");
		this.potenciaRed = new Variable("potencia_red");

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
		variablesAControlar.add(tensionTierra);
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
		Umbral umbral;
		for (Variable v : variablesAControlar) {
			umbral = new Umbral();
			umbral = umbralService.getUmbralByVariable(v.getNombre());
			v.setUmbral(umbral);
			this.mapUmbrales.put(umbral.getNombreVariable(), umbral);
		}
	}
	
	public Map<String, Umbral> getMapper() {
		return this.mapUmbrales;
	}
	
	public List<Variable> getListaVariables() {
		return this.variablesAControlar;
	}

}
