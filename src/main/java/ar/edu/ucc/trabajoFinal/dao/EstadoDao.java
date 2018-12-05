package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.Estado;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel
 */
@Repository
public class EstadoDao extends DaoGenericoImp<Estado, Long> implements IEstadoDao{

    @Override
    public Estado getEstadoById(Long id) {
        return this.getByCriteria(Restrictions.eq("id", id)).get(0);
    }
    
}
