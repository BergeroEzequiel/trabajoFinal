package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IEstadoDao;
import ar.edu.ucc.trabajoFinal.model.Estado;
import java.text.ParseException;
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
public class EstadoService {
    
    @Autowired
    DaoGenerico<Estado, Long> estadoDao;

    IEstadoDao estadoDaoParticular;

    @PostConstruct
    public void init() {
            estadoDaoParticular = (IEstadoDao) estadoDao;
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<Estado> getEstados() throws ParseException {
        
        List<Estado> estados = this.estadoDaoParticular.getAll();
        return estados;
    }
    
}
