package ar.edu.ucc.trabajoFinal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.ucc.trabajoFinal.dto.TramaDto;
import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaUltimasPotencias;
import ar.edu.ucc.trabajoFinal.service.TramaService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TramaController {

    private Logger log = Logger.getLogger(this.getClass());
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private TramaService tramaService;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Secured("ROLE_ADMINISTRADOR")
    @RequestMapping(value = "/tramas", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTramas()
            throws Exception {

        List<Trama> tramas = tramaService.getTramas();
        return new ResponseEntity(tramas, HttpStatus.OK);
    }

//	//-----------ESTE METODO NO SE VA A USAR CREO -------------------------------
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping(value = "/trama/{tramaId}", method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<?> getTrama(@PathVariable("tramaId") Long tramaId)
//			throws Exception {
//		
//		TramaDto tramaDto = tramaService.getTrama(tramaId);
//		
//		return new ResponseEntity(tramaDto, HttpStatus.OK);
//	}
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/tramaByNodo/{idNodo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTramasByNodo(@PathVariable("idNodo") Long idNodo) throws Exception {

        List<TramaDto> tramaDto = tramaService.getTramasByNodo(idNodo);
        return new ResponseEntity(tramaDto, HttpStatus.OK);

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/trama",
            method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> crearTrama(@RequestBody TramaDto tramaDto)
            throws Exception {

        log.info("Grabando: " + tramaDto.toString());

        tramaService.grabarTrama(tramaDto);

        if (tramaDto.getEstadoControl()) {
            this.actualizarTrama(tramaDto);
        }
        return new ResponseEntity(tramaDto, HttpStatus.CREATED);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/trama",
            method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> actualizarTrama(@RequestBody TramaDto tramaDto)
            throws Exception {

        TramaDto tramaDtoRespuesta = tramaService.actualizarEstadoControlTrama(tramaDto);

        return new ResponseEntity(tramaDtoRespuesta, HttpStatus.OK);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Secured("ROLE_BASICO")
    @RequestMapping(value = "/potenciasNodos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getPotenciasNodos() throws Exception {

        List<TramaDto> tramaDto = tramaService.getPotenciasNodos();
        return new ResponseEntity(tramaDto, HttpStatus.OK);

    }

    /**
     * Devuelve las últimas 10 potencias de cada nodd si no se le pasa valores.
     * Si se le pasa un nodo, solo devuelve las últimas 10 de ese nodo. ejemplo
     * http://localhost:8080/trabajoFinal/ultimasPotenciasPorNodos?idNodo=1
     *
     * @param idNodo
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/ultimasPotenciasPorNodos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUltimasPotenciasPorNodos(
            @RequestParam(value = "idNodo", required = false) Long idNodo) throws Exception {

        List<TramaUltimasPotencias> tramaUltimasPotencias = tramaService.getUltimasPotenciasPorNodos(idNodo);
        return new ResponseEntity(tramaUltimasPotencias, HttpStatus.OK);

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/ultimasNTramasPorNodos/{idNodo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUltimasNTramasPorNodos(
            @PathVariable(value = "idNodo") Long idNodo,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) throws Exception {

        List<Trama> tramas = tramaService.getUltimasNTramasPorNodos(idNodo, limit);
        return new ResponseEntity(tramas, HttpStatus.OK);

    }

    /**
     * Devuelve el promedio de todas las temperaturas 2, 3, 4 y 5 medidas por
     * todos los nodos activos.
     *
     * @return float temperatura
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/trama/temperaturaPromedioParque", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTemperaturaPromedioParque() throws Exception {

        float temperatura = tramaService.getTemperaturaPromedioParque();
        return new ResponseEntity(temperatura, HttpStatus.OK);

    }

    /**
     * Debuelve el promedio de la última temperatura ambiente (temperatura1)
     * medida por todos los nodos activos. La temperatura ambiente deberia ser
     * la misma en todos los nodos.
     *
     * @return float temperatura
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/trama/temperaturaAmbienteParque", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTemperaturaAmbienteParque() throws Exception {

        float temperatura = tramaService.getTemperaturaAmbienteParque();
        return new ResponseEntity(temperatura, HttpStatus.OK);

    }

    /**
     * Devuelve un listado de un solo valor, fecha y hora, que corresponde a la variable con todos los filtros.
     * Endpoint creado para el detalle, generalmente de una ventana de 20 minutos.
     * Ejemplo:
     *  http://localhost:8080/trabajoFinal/getTramaFiltrada?fechaDesde=2019-02-11&fechaHasta=2019-02-14&horaDesde=18:00:00&horaHasta=18:20:00&nombreVariable=corriente_continua_avg&idNodo=1
     * 
     * @param nombreVariable
     * @param fechaDesde
     * @param fechaHasta
     * @param horaDesde
     * @param horaHasta
     * @param idNodo
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/getTramaFiltrada", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getTramasByTiempoAndNodo(
            @RequestParam(value = "nombreVariable") String nombreVariable,
            @RequestParam(value = "fechaDesde") String fechaDesde,
            @RequestParam(value = "fechaHasta") String fechaHasta,
            @RequestParam(value = "horaDesde", required = false) String horaDesde,
            @RequestParam(value = "horaHasta", required = false) String horaHasta,
            @RequestParam(value = "idNodo") Long idNodo) throws Exception {

        List trama = tramaService.getTramasByTiempoAndNodo(nombreVariable, dateFormatter.parse(fechaDesde), dateFormatter.parse(fechaHasta), horaDesde, horaHasta, idNodo);

        return new ResponseEntity(trama, HttpStatus.OK);
    }

}
