
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.HistorialNodo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ezequiel
 */
public interface IHistorialNodoDao extends DaoGenerico<HistorialNodo, Long>{
    
    public List<HistorialNodo> getHistorialNodoByFecha(Date fecha);
    
}
