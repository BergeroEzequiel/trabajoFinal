package ar.edu.ucc.trabajoFinal.controller;

import ar.edu.ucc.trabajoFinal.model.Estado;
import ar.edu.ucc.trabajoFinal.service.EstadoService;
import java.util.List;
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
public class EstadoController {
    
    @Autowired
    EstadoService estadoService;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/estados", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEstados() throws Exception {

        List<Estado> estados = estadoService.getEstados();
        return new ResponseEntity(estados, HttpStatus.OK);
    }
    
}
