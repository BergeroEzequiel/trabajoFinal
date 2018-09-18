package ar.edu.ucc.trabajoFinal.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.Criticidad;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ezequiel
 */
@Repository
public class CriticidadDao  extends DaoGenericoImp<Criticidad, Long> implements ICriticidadDao{

    @Override
    public Criticidad getCriticidadByPrioridad(String prioridad) {
        return this.getByCriteria(Restrictions.eq("prioridad", prioridad)).get(0);
    }
    
}
