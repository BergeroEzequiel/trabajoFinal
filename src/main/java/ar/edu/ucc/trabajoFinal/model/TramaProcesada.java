package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitoreo_procesado")
<<<<<<< HEAD
public class TramaProcesada extends ObjetoGenerico {

	@Column(name = "ip_nodo")
	private int ipNodo;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "tension_red_max", nullable = false)
	private float tensionRedMax;

	@Column(name = "tension_red_min", nullable = false)
	private float tensionRedMin;
<<<<<<< HEAD

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "tension_red_avg", nullable = false)
	private float tensionRedAvg;

	@Column(name = "corriente_red_max", nullable = false)
	private float corrienteRedMax;

	@Column(name = "corriente_red_min", nullable = false)
	private float corrienteRedMin;
<<<<<<< HEAD

	@Column(name = "corriente_red_avg", nullable = false)
	private float corrienteRedAvg;

	@Column(name = "frecuencia_tension_max", nullable = false)
	private float frecuenciaTensionMax;

	@Column(name = "frecuencia_tension_min", nullable = false)
	private float frecuenciaTensionMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "frecuencia_tension_avg", nullable = false)
	private float frecuenciaTensionAvg;

	@Column(name = "frecuencia_corriente_max", nullable = false)
	private float frecuenciaCorrienteMax;
<<<<<<< HEAD

	@Column(name = "frecuencia_corriente_min", nullable = false)
	private float frecuenciaCorrienteMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "frecuencia_corriente_avg", nullable = false)
	private float frecuenciaCorrienteAvg;

	@Column(name = "desfasaje_max", nullable = false)
	private float desfasajeMax;
<<<<<<< HEAD

	@Column(name = "desfasaje_min", nullable = false)
	private float desfasajeMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "desfasaje_avg", nullable = false)
	private float desfasajeAvg;

	@Column(name = "tension_tierra_max", nullable = false)
	private float tensionTierraMax;
<<<<<<< HEAD

	@Column(name = "tension_tierra_min", nullable = false)
	private float tensionTierraMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "tension_tierra_avg", nullable = false)
	private float tensionTierraAvg;

	@Column(name = "tension_interna_max", nullable = false)
	private float tensionInternaMax;
<<<<<<< HEAD

	@Column(name = "tension_interna_min", nullable = false)
	private float tensionInternaMin;

=======
	
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "tension_interna_avg", nullable = false)
	private float tensionInternaAvg;

	@Column(name = "corriente_interna_max", nullable = false)
	private float corrienteInternaMax;
<<<<<<< HEAD

	@Column(name = "corriente_interna_min", nullable = false)
	private float corrienteInternaMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "corriente_interna_avg", nullable = false)
	private float corrienteInternaAvg;

	@Column(name = "tension_continua_max", nullable = false)
	private float tensionContinuaMax;
<<<<<<< HEAD

	@Column(name = "tension_continua_min", nullable = false)
	private float tensionContinuaMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "tension_continua_avg", nullable = false)
	private float tensionContinuaAvg;

	@Column(name = "corriente_continua_max", nullable = false)
	private float corrienteContinuaMax;
<<<<<<< HEAD

	@Column(name = "corriente_continua_min", nullable = false)
	private float corrienteContinuaMin;

	@Column(name = "corriente_continua_avg", nullable = false)
	private float corrienteContinuaAvg;

	@Column(name = "temperatura1_max", nullable = false)
	private float temperatura1Max;

	@Column(name = "temperatura1_min", nullable = false)
	private float temperatura1Min;

=======
	
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "temperatura1_avg", nullable = false)
	private float temperatura1Avg;

	@Column(name = "temperatura2_max", nullable = false)
	private float temperatura2Max;
<<<<<<< HEAD

	@Column(name = "temperatura2_min", nullable = false)
	private float temperatura2Min;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "temperatura2_avg", nullable = false)
	private float temperatura2Avg;

	@Column(name = "temperatura3_max", nullable = false)
	private float temperatura3Max;
<<<<<<< HEAD

	@Column(name = "temperatura3_min", nullable = false)
	private float temperatura3Min;

	@Column(name = "temperatura3_avg", nullable = false)
	private float temperatura3Avg;

	@Column(name = "temperatura4_max", nullable = false)
	private float temperatura4Max;

	@Column(name = "temperatura4_min", nullable = false)
	private float temperatura4Min;

	@Column(name = "temperatura4_avg", nullable = false)
	private float temperatura4Avg;

	@Column(name = "temperatura5_max", nullable = false)
	private float temperatura5Max;

	@Column(name = "temperatura5_min", nullable = false)
	private float temperatura5Min;

	@Column(name = "temperatura5_avg", nullable = false)
	private float temperatura5Avg;

	@Column(name = "humedad_max", nullable = false)
	private float humedadMax;

	@Column(name = "humedad_min", nullable = false)
	private float humedadMin;

=======
	
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "humedad_avg", nullable = false)
	private float humedadAvg;

	@Column(name = "pvm_max", nullable = false)
	private float pvmMax;
<<<<<<< HEAD

	@Column(name = "pvm_min", nullable = false)
	private float pvmMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "pvm_avg", nullable = false)
	private float pvmAvg;

	@Column(name = "potencia_continua_max", nullable = false)
	private float potenciaContinuaMax;
<<<<<<< HEAD

	@Column(name = "potencia_continua_min", nullable = false)
	private float potenciaContinuaMin;

=======
	
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "potencia_continua_avg", nullable = false)
	private float potenciaContinuaAvg;

	@Column(name = "potencia_red_max", nullable = false)
	private float potenciaRedMax;
<<<<<<< HEAD

	@Column(name = "potencia_red_min", nullable = false)
	private float potenciaRedMin;

=======
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "potencia_red_avg", nullable = false)
	private float potenciaRedAvg;

	@Column(name = "potencia_interna_max", nullable = false)
	private float potenciaInternaMax;
<<<<<<< HEAD

	@Column(name = "potencia_interna_min", nullable = false)
	private float potenciaInternaMin;

=======
	
	
>>>>>>> 05e9f1ef8022c58a2a753bfe54a210ebb902a23f
	@Column(name = "potencia_interna_avg", nullable = false)
	private float potenciaInternaAvg;

}
