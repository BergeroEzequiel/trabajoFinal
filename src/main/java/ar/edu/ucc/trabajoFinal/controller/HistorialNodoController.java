package ar.edu.ucc.trabajoFinal.controller;

import ar.edu.ucc.trabajoFinal.model.HistorialNodo;
import ar.edu.ucc.trabajoFinal.service.HistorialNodoService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ezequiel
 */
@Controller
public class HistorialNodoController {

    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private HistorialNodoService historialNodoService;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/historialNodos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getHistorialNodos() throws Exception {

        List<HistorialNodo> historialNodos = historialNodoService.getHistorialNodo();
        return new ResponseEntity(historialNodos, HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/historialNodosHoy", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getHistorialNodoFechaActuaL() throws Exception {

        List<HistorialNodo> historialNodos = historialNodoService.getHistorialNodoFechaActuaL();
        return new ResponseEntity(historialNodos, HttpStatus.OK);
    }

}
