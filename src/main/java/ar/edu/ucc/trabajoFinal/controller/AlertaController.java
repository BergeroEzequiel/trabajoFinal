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
         * Recibe un rango horario (horaDesde y horaHasta) y una prioridad de criticidad. Busca todas las alertas
         * a visualizar de el DIA ACTUAL en ese rango horario y con esa criticidad(Critica, Alta, etc).
         * La hora se debe pasar como HH:MM:SS
         * Ejemplo de uso:
         *      http://localhost:8080/trabajoFinal/alertas?horaDesde=01:01:01&horaHasta=02:02:02&prioridadCriticidad=Critica
         * 
         * @param horaDesde
         * @param horaHasta
         * @return
         * @throws Exception 
         */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/alertas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAlertas(
                @RequestParam(value = "horaDesde") String horaDesde, 
                @RequestParam(value = "horaHasta") String horaHasta,
                @RequestParam(value = "prioridadCriticidad", required = false) String prioridadCriticidad) throws Exception{
		List<Alerta> alertas = alertaService.getAlertas(Time.valueOf(horaDesde), Time.valueOf(horaHasta), prioridadCriticidad);
		return new ResponseEntity(alertas, HttpStatus.OK);
	}
	
        /**
         * Busca todas las alertas a visualizar de un determinado nodo, una determinada Criticidad (Critica, Alta, Media o Baja) y 
         * en un rango de fechas determinado.
         * De ser posible enviar la fecha de la forma: YYYY-MM-DD.
         * idNodo y prioridadCriticidad son parámetros no requeridos, las fechas SI.
         * Ejemplo para consumir la API:
         *      http://localhost:8080/trabajoFinal/alertasPorNodo?idNodo=1&fechaDesde=2018-06-01&fechaHasta=2018-06-31
         * @param fechaDesde
         * @param fechaHasta
         * @param idNodo
         * @param criticidad
         * @return
         * @throws Exception 
         */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/alertasPorFecha", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAlertasByFecha(
                @RequestParam(value = "fechaDesde") String fechaDesde, 
                @RequestParam(value = "fechaHasta") String fechaHasta,
                @RequestParam(value = "idNodo", required = false) Long idNodo,
                @RequestParam(value = "criticidad", required = false) String criticidad) throws Exception{
		List<Alerta> alertasDto = alertaService.getAlertasByFecha(
                        fechaDesde, fechaHasta, idNodo, criticidad);
		return new ResponseEntity(alertasDto, HttpStatus.OK);
	}
	
}
