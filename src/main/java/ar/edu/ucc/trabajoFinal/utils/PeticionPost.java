package ar.edu.ucc.trabajoFinal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class PeticionPost {
	private URL url;
	String data ;

	public PeticionPost (String url) throws MalformedURLException{
	this.url = new URL(url);
	data = "{'ipNodo': 1, 'corrienteContinua': 1, 'corrienteInterna': 1, 'corrienteRed': 1,"
			+ "'desfasaje': 1, 'estado': true, 'fecha': 1, 'hora': 1, 'frecuenciaCorriente': 1, 'frecuenciaTension': 1, 'humedad': 1"
			+ ",'potenciaContinua': 1, 'potenciaInterna': 1, 'potenciaRed': 1 ,'pvm': 1, 'temperatura1': 1, 'temperatura2': 1,"
			+ "'temperatura3': 1, 'temperatura4': 1, 'temperatura5': 1, 'tensionContinua': 1, 'tensionInterna': 1, 'tensionRed': 1,"
			+ "'tensionTierra': 1}";
	}

	public void add (String propiedad, String valor) throws UnsupportedEncodingException{
	//codificamos cada uno de los valores
	if (data.length()>0)
	data+= "&"+ URLEncoder.encode(propiedad, "UTF-8")+ ":" +URLEncoder.encode(valor, "UTF-8");
	else
	data+= URLEncoder.encode(propiedad, "UTF-8")+ ":" +URLEncoder.encode(valor, "UTF-8");
	}

	public String getRespueta() throws IOException {
	String respuesta = "";
	//abrimos la conexiÃ³n
	URLConnection conn = url.openConnection();
	//especificamos que vamos a escribir
	conn.setDoOutput(true);
	//obtenemos el flujo de escritura
	OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	//escribimos
	wr.write(data);
	//cerramos la conexiÃ³n
	  wr.close();

	  //obtenemos el flujo de lectura
	  BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	     String linea;
	     //procesamos al salida
	     while ((linea = rd.readLine()) != null) {
	        respuesta+= linea;
	     }
	return respuesta;
	}

}
