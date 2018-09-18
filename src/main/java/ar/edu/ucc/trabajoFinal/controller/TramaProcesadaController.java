package ar.edu.ucc.trabajoFinal.controller;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.TramaProcesada;
import ar.edu.ucc.trabajoFinal.service.TramaProcesadaService;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ezequiel
 */
@Controller
public class TramaProcesadaController {
    
    //Se puede ver que algunos métodos reciben STRING y despues se castean.
    //Se hace de esa manera porque de la forma "correcta" genera problemas y NO HAY GANAS de renegar.

    private Logger log = Logger.getLogger(this.getClass());
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private TramaProcesadaService tramaProcesadaService;

    /**
     * Recibe un rango horario (horaDesde y horaHasta).
     * Busca todas las alertas a visualizar de el DIA ACTUAL en ese rango horario. 
     * Además puede recibir o no, un id de Tipo Procesamiento (1 para cada 20 minutos, 2 para Diario y 3 para semanal)
     * La hora se debe pasar como HH:MM:SS Ejemplo de uso:
     * http://localhost:8080/trabajoFinal/getTramasProcesadasByHora?horaDesde=01:01:01&horaHasta=02:02:02&idTipoProcesamiento=1
     *
     * @param horaDesde
     * @param horaHasta
     * @param idTipoProcesamiento
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/getTramasProcesadasByHora", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAlertas(
            @RequestParam(value = "horaDesde") String horaDesde,
            @RequestParam(value = "horaHasta") String horaHasta,
            @RequestParam(value = "idTipoProcesamiento", required = false) Long idTipoProcesamiento) throws Exception {
        List<TramaProcesada> tramasProcesadas = tramaProcesadaService.getTramasProcesadasByHora(
                Time.valueOf(horaDesde), 
                Time.valueOf(horaHasta),
                idTipoProcesamiento);
        return new ResponseEntity(tramasProcesadas, HttpStatus.OK);
    }

    /**
     * Busca todas las tramas procesadas que se encuentren en un determinado rango de fechas.
     * Además puede recibir o no, un id de Tipo Procesamiento (1 para cada 20 minutos, 2 para Diario y 3 para semanal)
     * Pasar las fechas de la forma YYYY-mm-dd. Ejemplo:
     * http://localhost:8080/trabajoFinal/getTramasProcesadasByFecha?fechaDesde=2018-06-01&fechaHasta=2018-06-31&idTipoProcesamiento=1
     *
     * @param fechaDesde
     * @param fechaHasta
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/getTramasProcesadasByFecha", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTramasProcesadasByFecha(
            @RequestParam(value = "fechaDesde") String fechaDesde,
            @RequestParam(value = "fechaHasta") String fechaHasta,
            @RequestParam(value = "idTipoProcesamiento", required = false) Long idTipoProcesamiento) throws Exception {
        List<TramaProcesada> tramasProcesadas = tramaProcesadaService.getTramasProcesadasByFecha(
                dateFormatter.parse(fechaDesde), 
                dateFormatter.parse(fechaHasta),
                idTipoProcesamiento);
        return new ResponseEntity(tramasProcesadas, HttpStatus.OK);
    }
}
