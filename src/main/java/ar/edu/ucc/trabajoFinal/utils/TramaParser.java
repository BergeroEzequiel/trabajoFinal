package ar.edu.ucc.trabajoFinal.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TramaParser {
	
	public JsonElement stringToJson(String stringAParsear) {
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(stringAParsear);
		return element;
		
	}
	
//	public TramaDto parsearTrama(JSONObject tramaJson) {
//		log.info("Parseando trama... " + tramaJson.toString() );
//		
//		TramaDto tramaDto = new TramaDto();
//		tramaDto.setCorrienteContinua((float) tramaJson.getDouble("corrienteContinua"));
//		tramaDto.setCorrienteInterna((float) tramaJson.getDouble("corrienteInterna"));
//		tramaDto.setCorrienteRed((float) tramaJson.getDouble("corrienteRed"));
//		tramaDto.setDesfasaje((float) tramaJson.getDouble("desfasaje"));
//		tramaDto.setEstado(tramaJson.getBoolean("estado"));
//		try {
//			tramaDto.setFecha(dateFormatter.parse(tramaJson.getString("fecha")));
//			tramaDto.setHora(new Time(timeFormatter.parse(tramaJson.getString("hora")).getTime()));//verificar si anda
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		tramaDto.setFrecuenciaCorriente((float) tramaJson.getDouble("frecuenciaCorriente"));
//		tramaDto.setFrecuenciaTension((float) tramaJson.getDouble("frecuenciaTension"));
//		tramaDto.setHumedad((float) tramaJson.getDouble("humedad"));
//		tramaDto.setIpNodo(tramaJson.getInt("ipNodo"));
//		tramaDto.setPotenciaContinua((float) tramaJson.getDouble("potenciaContinua"));
//		tramaDto.setPotenciaInterna((float) tramaJson.getDouble("potenciaInterna"));
//		tramaDto.setPotenciaRed((float) tramaJson.getDouble("potenciaRed"));
//		tramaDto.setPvm((float) tramaJson.getDouble("pvm"));
//		tramaDto.setTemperatura1((float) tramaJson.getDouble("temperatura1"));
//		tramaDto.setTemperatura2((float) tramaJson.getDouble("temperatura2"));
//		tramaDto.setTemperatura3((float) tramaJson.getDouble("temperatura3"));
//		tramaDto.setTemperatura4((float) tramaJson.getDouble("temperatura4"));
//		tramaDto.setTemperatura5((float) tramaJson.getDouble("temperatura5"));
//		tramaDto.setTensionContinua((float) tramaJson.getDouble("tensionContinua"));
//		tramaDto.setTensionInterna((float) tramaJson.getDouble("tensionInterna"));
//		tramaDto.setTensionRed((float) tramaJson.getDouble("tensionRed"));
//		tramaDto.setTensionTierra((float) tramaJson.getDouble("tensionTierra"));
//		
//		return tramaDto;
//		
//	}

}
