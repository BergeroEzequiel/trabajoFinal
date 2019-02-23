package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.HistorialNodoDao;
import ar.edu.ucc.trabajoFinal.dao.IHistorialNodoDao;
import ar.edu.ucc.trabajoFinal.model.HistorialNodo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel
 */
@Service
@Transactional
public class HistorialNodoService {

    @Autowired
    DaoGenerico<HistorialNodo, Long> historialNodoDao;

    IHistorialNodoDao historialNodoDaoParticular;
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @PostConstruct
    public void init() {
        historialNodoDaoParticular = (HistorialNodoDao) historialNodoDao;
    }
    
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<HistorialNodo> getHistorialNodo() {
        
        List<HistorialNodo> historialNodos = this.historialNodoDaoParticular.getAll();
        return historialNodos;
    }
    
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<HistorialNodo> getHistorialNodoFechaActuaL() throws ParseException {
        
        
        List<HistorialNodo> historialNodos = this.historialNodoDaoParticular.getHistorialNodoByFecha(
                dateFormatter.parse(dateFormatter.format(new Date())));
        return historialNodos;
    }

}
