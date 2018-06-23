package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.service.AlertaService;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlertaController {
        //Se puede ver que algunos métodos reciben STRING y despues se castean.
        //Se hace de esa manera porque de la forma "correcta" genera problemas y NO HAY GANAS de renegar.

	private Logger log = Logger.getLogger(this.getClass());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private AlertaService alertaService;
	
        /**
         * Recibe un rango horario (horaDesde y horaHasta) y busca todas las alertas
         * a visualizar de el DIA ACTUAL en ese rango horario.
         * La hora se debe pasar como HH:MM:SS
         * Ejemplo de uso:
         *      http://localhost:8080/trabajoFinal/alertas?horaDesde=01:01:01&horaHasta=02:02:02
         * 
         * @param horaDesde
         * @param horaHasta
         * @return
         * @throws Exception 
         */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/alertas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAlertasByNodo(
                @RequestParam("horaDesde") String horaDesde, 
                @RequestParam("horaHasta") String horaHasta) throws Exception{
		List<Alerta> alertas = alertaService.getAlertas(Time.valueOf(horaDesde), Time.valueOf(horaHasta));
		return new ResponseEntity(alertas, HttpStatus.OK);
	}
	
        /**
         * Busca todas las alertas a visualizar de un determinado nodo y 
         * en un rango de fechas determinado.
         * De ser posible enviar la fecha de la forma: YYYY-MM-DD
         * Ejemplo para consumir la API:
         *      http://localhost:8080/trabajoFinal/alertasPorNodo?idNodo=1&fechaDesde=2018-06-01&fechaHasta=2018-06-31
         * 
         * @param idNodo
         * @param fechaDesde
         * @param fechaHasta
         * @return
         * @throws Exception 
         */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/alertasPorNodo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAlertasByNodo(@RequestParam("idNodo") Long idNodo, 
                @RequestParam("fechaDesde") String fechaDesde, 
                @RequestParam("fechaHasta") String fechaHasta) throws Exception{
		List<Alerta> alertasDto = alertaService.getAlertasByNodo(
                        idNodo, dateFormatter.parse(fechaDesde), dateFormatter.parse(fechaHasta));
		return new ResponseEntity(alertasDto, HttpStatus.OK);
	}
	
}
