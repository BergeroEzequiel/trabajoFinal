package ar.edu.ucc.trabajoFinal.dto;

import ar.edu.ucc.trabajoFinal.model.Nodo;

public class TramaProcesadaDto {
	
	private Long id;
	
	private Nodo nodo;
	
	private float tensionRedMax;

	private float tensionRedMin;

	private float tensionRedAvg;

	private float corrienteRedMax;

	private float corrienteRedMin;

	private float corrienteRedAvg;

	private float frecuenciaTensionMax;

	private float frecuenciaTensionMin;

	private float frecuenciaTensionAvg;

	private float frecuenciaCorrienteMax;

	private float frecuenciaCorrienteMin;

	private float frecuenciaCorrienteAvg;

	private float desfasajeMax;

	private float desfasajeMin;

	private float desfasajeAvg;

	private float tensionTierraMax;

	private float tensionTierraMin;

	private float tensionTierraAvg;

	private float tensionInternaMax;

	private float tensionInternaMin;

	private float tensionInternaAvg;

	private float corrienteInternaMax;

	private float corrienteInternaMin;

	private float corrienteInternaAvg;

	private float tensionContinuaMax;
	
	private float tensionContinuaMin;

	private float tensionContinuaAvg;

	private float corrienteContinuaMax;

	private float corrienteContinuaMin;

	private float corrienteContinuaAvg;

	private float temperatura1Max;

	private float temperatura1Min;

	private float temperatura1Avg;

	private float temperatura2Max;

	private float temperatura2Min;

	private float temperatura2Avg;

	private float temperatura3Max;

	private float temperatura3Min;

	private float temperatura3Avg;

	private float temperatura4Max;

	private float temperatura4Min;

	private float temperatura4Avg;

	private float temperatura5Max;

	private float temperatura5Min;

	private float temperatura5Avg;

	private float humedadMax;

	private float humedadMin;

	private float humedadAvg;

	private float pvmMax;

	private float pvmMin;

	private float pvmAvg;

	private float potenciaContinuaMax;

	private float potenciaContinuaMin;

	private float potenciaContinuaAvg;

	private float potenciaRedMax;

	private float potenciaRedMin;

	private float potenciaRedAvg;

	private float potenciaInternaMax;

	private float potenciaInternaMin;

	private float potenciaInternaAvg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

        public Nodo getNodo() {
            return nodo;
        }

        public void setNodo(Nodo nodo) {
            this.nodo = nodo;
        }

        

	public float getTensionRedMax() {
		return tensionRedMax;
	}

	public void setTensionRedMax(float tensionRedMax) {
		this.tensionRedMax = tensionRedMax;
	}

	public float getTensionRedMin() {
		return tensionRedMin;
	}

	public void setTensionRedMin(float tensionRedMin) {
		this.tensionRedMin = tensionRedMin;
	}

	public float getTensionRedAvg() {
		return tensionRedAvg;
	}

	public void setTensionRedAvg(float tensionRedAvg) {
		this.tensionRedAvg = tensionRedAvg;
	}

	public float getCorrienteRedMax() {
		return corrienteRedMax;
	}

	public void setCorrienteRedMax(float corrienteRedMax) {
		this.corrienteRedMax = corrienteRedMax;
	}

	public float getCorrienteRedMin() {
		return corrienteRedMin;
	}

	public void setCorrienteRedMin(float corrienteRedMin) {
		this.corrienteRedMin = corrienteRedMin;
	}

	public float getCorrienteRedAvg() {
		return corrienteRedAvg;
	}

	public void setCorrienteRedAvg(float corrienteRedAvg) {
		this.corrienteRedAvg = corrienteRedAvg;
	}

	public float getFrecuenciaTensionMax() {
		return frecuenciaTensionMax;
	}

	public void setFrecuenciaTensionMax(float frecuenciaTensionMax) {
		this.frecuenciaTensionMax = frecuenciaTensionMax;
	}

	public float getFrecuenciaTensionMin() {
		return frecuenciaTensionMin;
	}

	public void setFrecuenciaTensionMin(float frecuenciaTensionMin) {
		this.frecuenciaTensionMin = frecuenciaTensionMin;
	}

	public float getFrecuenciaTensionAvg() {
		return frecuenciaTensionAvg;
	}

	public void setFrecuenciaTensionAvg(float frecuenciaTensionAvg) {
		this.frecuenciaTensionAvg = frecuenciaTensionAvg;
	}

	public float getFrecuenciaCorrienteMax() {
		return frecuenciaCorrienteMax;
	}

	public void setFrecuenciaCorrienteMax(float frecuenciaCorrienteMax) {
		this.frecuenciaCorrienteMax = frecuenciaCorrienteMax;
	}

	public float getFrecuenciaCorrienteMin() {
		return frecuenciaCorrienteMin;
	}

	public void setFrecuenciaCorrienteMin(float frecuenciaCorrienteMin) {
		this.frecuenciaCorrienteMin = frecuenciaCorrienteMin;
	}

	public float getFrecuenciaCorrienteAvg() {
		return frecuenciaCorrienteAvg;
	}

	public void setFrecuenciaCorrienteAvg(float frecuenciaCorrienteAvg) {
		this.frecuenciaCorrienteAvg = frecuenciaCorrienteAvg;
	}

	public float getDesfasajeMax() {
		return desfasajeMax;
	}

	public void setDesfasajeMax(float desfasajeMax) {
		this.desfasajeMax = desfasajeMax;
	}

	public float getDesfasajeMin() {
		return desfasajeMin;
	}

	public void setDesfasajeMin(float desfasajeMin) {
		this.desfasajeMin = desfasajeMin;
	}

	public float getDesfasajeAvg() {
		return desfasajeAvg;
	}

	public void setDesfasajeAvg(float desfasajeAvg) {
		this.desfasajeAvg = desfasajeAvg;
	}

	public float getTensionTierraMax() {
		return tensionTierraMax;
	}

	public void setTensionTierraMax(float tensionTierraMax) {
		this.tensionTierraMax = tensionTierraMax;
	}

	public float getTensionTierraMin() {
		return tensionTierraMin;
	}

	public void setTensionTierraMin(float tensionTierraMin) {
		this.tensionTierraMin = tensionTierraMin;
	}

	public float getTensionTierraAvg() {
		return tensionTierraAvg;
	}

	public void setTensionTierraAvg(float tensionTierraAvg) {
		this.tensionTierraAvg = tensionTierraAvg;
	}

	public float getTensionInternaMax() {
		return tensionInternaMax;
	}

	public void setTensionInternaMax(float tensionInternaMax) {
		this.tensionInternaMax = tensionInternaMax;
	}

	public float getTensionInternaMin() {
		return tensionInternaMin;
	}

	public void setTensionInternaMin(float tensionInternaMin) {
		this.tensionInternaMin = tensionInternaMin;
	}

	public float getTensionInternaAvg() {
		return tensionInternaAvg;
	}

	public void setTensionInternaAvg(float tensionInternaAvg) {
		this.tensionInternaAvg = tensionInternaAvg;
	}

	public float getCorrienteInternaMax() {
		return corrienteInternaMax;
	}

	public void setCorrienteInternaMax(float corrienteInternaMax) {
		this.corrienteInternaMax = corrienteInternaMax;
	}

	public float getCorrienteInternaMin() {
		return corrienteInternaMin;
	}

	public void setCorrienteInternaMin(float corrienteInternaMin) {
		this.corrienteInternaMin = corrienteInternaMin;
	}

	public float getCorrienteInternaAvg() {
		return corrienteInternaAvg;
	}

	public void setCorrienteInternaAvg(float corrienteInternaAvg) {
		this.corrienteInternaAvg = corrienteInternaAvg;
	}

	public float getTensionContinuaMax() {
		return tensionContinuaMax;
	}

	public void setTensionContinuaMax(float tensionContinuaMax) {
		this.tensionContinuaMax = tensionContinuaMax;
	}

	public float getTensionContinuaMin() {
		return tensionContinuaMin;
	}

	public void setTensionContinuaMin(float tensionContinuaMin) {
		this.tensionContinuaMin = tensionContinuaMin;
	}

	public float getTensionContinuaAvg() {
		return tensionContinuaAvg;
	}

	public void setTensionContinuaAvg(float tensionContinuaAvg) {
		this.tensionContinuaAvg = tensionContinuaAvg;
	}

	public float getCorrienteContinuaMax() {
		return corrienteContinuaMax;
	}

	public void setCorrienteContinuaMax(float corrienteContinuaMax) {
		this.corrienteContinuaMax = corrienteContinuaMax;
	}

	public float getCorrienteContinuaMin() {
		return corrienteContinuaMin;
	}

	public void setCorrienteContinuaMin(float corrienteContinuaMin) {
		this.corrienteContinuaMin = corrienteContinuaMin;
	}

	public float getCorrienteContinuaAvg() {
		return corrienteContinuaAvg;
	}

	public void setCorrienteContinuaAvg(float corrienteContinuaAvg) {
		this.corrienteContinuaAvg = corrienteContinuaAvg;
	}

	public float getTemperatura1Max() {
		return temperatura1Max;
	}

	public void setTemperatura1Max(float temperatura1Max) {
		this.temperatura1Max = temperatura1Max;
	}

	public float getTemperatura1Min() {
		return temperatura1Min;
	}

	public void setTemperatura1Min(float temperatura1Min) {
		this.temperatura1Min = temperatura1Min;
	}

	public float getTemperatura1Avg() {
		return temperatura1Avg;
	}

	public void setTemperatura1Avg(float temperatura1Avg) {
		this.temperatura1Avg = temperatura1Avg;
	}

	public float getTemperatura2Max() {
		return temperatura2Max;
	}

	public void setTemperatura2Max(float temperatura2Max) {
		this.temperatura2Max = temperatura2Max;
	}

	public float getTemperatura2Min() {
		return temperatura2Min;
	}

	public void setTemperatura2Min(float temperatura2Min) {
		this.temperatura2Min = temperatura2Min;
	}

	public float getTemperatura2Avg() {
		return temperatura2Avg;
	}

	public void setTemperatura2Avg(float temperatura2Avg) {
		this.temperatura2Avg = temperatura2Avg;
	}

	public float getTemperatura3Max() {
		return temperatura3Max;
	}

	public void setTemperatura3Max(float temperatura3Max) {
		this.temperatura3Max = temperatura3Max;
	}

	public float getTemperatura3Min() {
		return temperatura3Min;
	}

	public void setTemperatura3Min(float temperatura3Min) {
		this.temperatura3Min = temperatura3Min;
	}

	public float getTemperatura3Avg() {
		return temperatura3Avg;
	}

	public void setTemperatura3Avg(float temperatura3Avg) {
		this.temperatura3Avg = temperatura3Avg;
	}

	public float getTemperatura4Max() {
		return temperatura4Max;
	}

	public void setTemperatura4Max(float temperatura4Max) {
		this.temperatura4Max = temperatura4Max;
	}

	public float getTemperatura4Min() {
		return temperatura4Min;
	}

	public void setTemperatura4Min(float temperatura4Min) {
		this.temperatura4Min = temperatura4Min;
	}

	public float getTemperatura4Avg() {
		return temperatura4Avg;
	}

	public void setTemperatura4Avg(float temperatura4Avg) {
		this.temperatura4Avg = temperatura4Avg;
	}

	public float getTemperatura5Max() {
		return temperatura5Max;
	}

	public void setTemperatura5Max(float temperatura5Max) {
		this.temperatura5Max = temperatura5Max;
	}

	public float getTemperatura5Min() {
		return temperatura5Min;
	}

	public void setTemperatura5Min(float temperatura5Min) {
		this.temperatura5Min = temperatura5Min;
	}

	public float getTemperatura5Avg() {
		return temperatura5Avg;
	}

	public void setTemperatura5Avg(float temperatura5Avg) {
		this.temperatura5Avg = temperatura5Avg;
	}

	public float getHumedadMax() {
		return humedadMax;
	}

	public void setHumedadMax(float humedadMax) {
		this.humedadMax = humedadMax;
	}

	public float getHumedadMin() {
		return humedadMin;
	}

	public void setHumedadMin(float humedadMin) {
		this.humedadMin = humedadMin;
	}

	public float getHumedadAvg() {
		return humedadAvg;
	}

	public void setHumedadAvg(float humedadAvg) {
		this.humedadAvg = humedadAvg;
	}

	public float getPvmMax() {
		return pvmMax;
	}

	public void setPvmMax(float pvmMax) {
		this.pvmMax = pvmMax;
	}

	public float getPvmMin() {
		return pvmMin;
	}

	public void setPvmMin(float pvmMin) {
		this.pvmMin = pvmMin;
	}

	public float getPvmAvg() {
		return pvmAvg;
	}

	public void setPvmAvg(float pvmAvg) {
		this.pvmAvg = pvmAvg;
	}

	public float getPotenciaContinuaMax() {
		return potenciaContinuaMax;
	}

	public void setPotenciaContinuaMax(float potenciaContinuaMax) {
		this.potenciaContinuaMax = potenciaContinuaMax;
	}

	public float getPotenciaContinuaMin() {
		return potenciaContinuaMin;
	}

	public void setPotenciaContinuaMin(float potenciaContinuaMin) {
		this.potenciaContinuaMin = potenciaContinuaMin;
	}

	public float getPotenciaContinuaAvg() {
		return potenciaContinuaAvg;
	}

	public void setPotenciaContinuaAvg(float potenciaContinuaAvg) {
		this.potenciaContinuaAvg = potenciaContinuaAvg;
	}

	public float getPotenciaRedMax() {
		return potenciaRedMax;
	}

	public void setPotenciaRedMax(float potenciaRedMax) {
		this.potenciaRedMax = potenciaRedMax;
	}

	public float getPotenciaRedMin() {
		return potenciaRedMin;
	}

	public void setPotenciaRedMin(float potenciaRedMin) {
		this.potenciaRedMin = potenciaRedMin;
	}

	public float getPotenciaRedAvg() {
		return potenciaRedAvg;
	}

	public void setPotenciaRedAvg(float potenciaRedAvg) {
		this.potenciaRedAvg = potenciaRedAvg;
	}

	public float getPotenciaInternaMax() {
		return potenciaInternaMax;
	}

	public void setPotenciaInternaMax(float potenciaInternaMax) {
		this.potenciaInternaMax = potenciaInternaMax;
	}

	public float getPotenciaInternaMin() {
		return potenciaInternaMin;
	}

	public void setPotenciaInternaMin(float potenciaInternaMin) {
		this.potenciaInternaMin = potenciaInternaMin;
	}

	public float getPotenciaInternaAvg() {
		return potenciaInternaAvg;
	}

	public void setPotenciaInternaAvg(float potenciaInternaAvg) {
		this.potenciaInternaAvg = potenciaInternaAvg;
	}

	
}
