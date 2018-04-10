package ar.edu.ucc.trabajoFinal.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.ucc.trabajoFinal.dto.AlertaDto;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.Umbral;
import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;
import ar.edu.ucc.trabajoFinal.service.AlertaService;
import ar.edu.ucc.trabajoFinal.service.UmbralEspecificoService;
import ar.edu.ucc.trabajoFinal.trama.Variable;

public class TramaControl {
	
	private String modulo;
	private int numero;
	private Nodo nodo;
	private Variable tensionRed = new Variable("tension_red");
	private Variable corrienteRed = new Variable("corriente_red");
	private Variable frecuenciaTension = new Variable("frecuencia_tension");
	private Variable frecuenciaCorriente = new Variable("frecuencia_corriente");
	private Variable desfasaje = new Variable("desfasaje");
	private Variable tensionTierra = new Variable("tension_tierra");
	private Variable tensionInterna = new Variable("tension_interna");
	private Variable corrienteInterna = new Variable("corriente_interna");
	private Variable tensionContinua = new Variable("tension_continua");
	private Variable corrienteContinua = new Variable("corriente_continua");
	private Variable temperatura1 = new Variable("temperatura1");
	private Variable temperatura2 = new Variable("temperatura2");
	private Variable temperatura3 = new Variable("temperatura3");
	private Variable temperatura4 = new Variable("temperatura4");
	private Variable temperatura5 = new Variable("temperatura5");
	private Variable humedad = new Variable("humedad");
	private Variable pvm = new Variable("pvm");
	private Variable potenciaContinua = new Variable("potencia_continua");
	private Variable potenciaInterna = new Variable("potencia_interna");
	private Variable potenciaRed = new Variable("potencia_red");
	private List<Variable> variablesAControlar;
	
	AlertaService alertaService = SpringContextBridge.services().getAlertaService();
	UmbralEspecificoService umbralEspService = SpringContextBridge.services().getUmbralEspecificoService();

	public TramaControl() {
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
	}

	public void cargarValoresActuales(TramaDto tramaDto) {
		this.modulo = tramaDto.getModulo();
		this.numero = tramaDto.getNumero();
		this.nodo = tramaDto.getNodo();
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
		
		this.cargarUmbrales();
	}
	
	public void cargarUmbrales() {
		List<UmbralEspecifico> umbralesEsp = this.umbralEspService.getUmbralesEspecificos(this.nodo.getId());
		Map<String, UmbralEspecifico> mapUmbralEsp = new HashMap<String, UmbralEspecifico>();
		for (UmbralEspecifico umbralEsp : umbralesEsp) {
			mapUmbralEsp.put(umbralEsp.getNombreVariable(), umbralEsp);
		}
		for (Variable v : variablesAControlar) {
			UmbralEspecifico esp = mapUmbralEsp.get(v.getNombre());
			if (esp != null) {
				Umbral umbral = new Umbral();
				umbral.setNombreVariable(esp.getNombreVariable());
				umbral.setValorMax(esp.getValorMax());
				umbral.setValorMin(esp.getValorMin());
				umbral.setActivo(esp.isActivo());
				umbral.setTipo(esp.getTipo());
				umbral.setUltimaModificacion(esp.getUltimaModificacion());
				umbral.setId(esp.getId());
				
				v.setUmbral(umbral);
			} else {
				v.setUmbral(UmbralesSingleton.getInstance().getMapper().get(v.getNombre()));
			}
		}
	}

	public void controlarTrama(TramaDto tramaDto) throws ParseException {
		if (!this.nodo.isActivo()) return;
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
