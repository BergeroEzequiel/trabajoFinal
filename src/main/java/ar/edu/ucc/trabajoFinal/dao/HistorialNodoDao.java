
package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.HistorialNodo;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel
 */
@Repository
public class HistorialNodoDao extends DaoGenericoImp<HistorialNodo, Long> implements IHistorialNodoDao{
    
    @Override
    public List<HistorialNodo> getHistorialNodoByFecha(Date fecha){
        return this.getByCriteria(Restrictions.ge("control", fecha));
    }    

}
