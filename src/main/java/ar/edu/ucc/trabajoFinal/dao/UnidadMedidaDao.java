package ar.edu.ucc.trabajoFinal.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.trabajoFinal.model.UnidadMedida;
import org.hibernate.criterion.Restrictions;

@Repository
public class UnidadMedidaDao extends DaoGenericoImp <UnidadMedida, Long> implements IUnidadMedidaDao {
    
    

    @Override
    public UnidadMedida getUMById(Long id) {
        return this.getByCriteria(Restrictions.eq("id", id)).get(0);
    }

}
