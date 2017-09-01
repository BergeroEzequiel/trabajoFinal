package ar.edu.ucc.trabajoFinal.rabbitMQ;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.ITramaDao;
import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Trama;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class TramaUtils {
	private Logger log = Logger.getLogger(this.getClass());
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
	DateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");
	
	@Autowired
	DaoGenerico<Trama, Long> tramaDao;
	ITramaDao tramaDaoParticular;

	public TramaDto parsearTrama(String message) {
		//log.info("Parseando trama... " + tramaJson.toString() );
		JSONObject tramaJson = (JSONObject) JSONSerializer.toJSON(message);
		TramaDto trama = new TramaDto();
		trama.setCorrienteContinua((float) tramaJson.getDouble("corrienteContinua"));
		trama.setCorrienteInterna((float) tramaJson.getDouble("corrienteInterna"));
		trama.setCorrienteRed((float) tramaJson.getDouble("corrienteRed"));
		trama.setDesfasaje((float) tramaJson.getDouble("desfasaje"));
		trama.setEstado(tramaJson.getBoolean("estado"));
		try {
			trama.setFecha(dateFormatter.parse(tramaJson.getString("fecha")));
			trama.setHora(new Time(timeFormatter.parse(tramaJson.getString("hora")).getTime()));//verificar si anda
		} catch (ParseException e) {
			e.printStackTrace();
		}
		trama.setFrecuenciaCorriente((float) tramaJson.getDouble("frecuenciaCorriente"));
		trama.setFrecuenciaTension((float) tramaJson.getDouble("frecuenciaTension"));
		trama.setHumedad((float) tramaJson.getDouble("humedad"));
		trama.setIpNodo(tramaJson.getInt("ipNodo"));
		trama.setPotenciaContinua((float) tramaJson.getDouble("potenciaContinua"));
		trama.setPotenciaInterna((float) tramaJson.getDouble("potenciaInterna"));
		trama.setPotenciaRed((float) tramaJson.getDouble("potenciaRed"));
		trama.setPvm((float) tramaJson.getDouble("pvm"));
		trama.setTemperatura1((float) tramaJson.getDouble("temperatura1"));
		trama.setTemperatura2((float) tramaJson.getDouble("temperatura2"));
		trama.setTemperatura3((float) tramaJson.getDouble("temperatura3"));
		trama.setTemperatura4((float) tramaJson.getDouble("temperatura4"));
		trama.setTemperatura5((float) tramaJson.getDouble("temperatura5"));
		trama.setTensionContinua((float) tramaJson.getDouble("tensionContinua"));
		trama.setTensionInterna((float) tramaJson.getDouble("tensionInterna"));
		trama.setTensionRed((float) tramaJson.getDouble("tensionRed"));
		trama.setTensionTierra((float) tramaJson.getDouble("tensionTierra"));
		
		return trama;
		
	}
	
	public void guardarTrama(Trama trama) {
		tramaDaoParticular = (TramaDao) tramaDao;
		tramaDaoParticular.saveOrUpdate(trama);
	}
}
