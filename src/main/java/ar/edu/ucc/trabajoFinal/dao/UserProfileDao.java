package ar.edu.ucc.trabajoFinal.dao;

import ar.edu.ucc.trabajoFinal.model.UserProfile;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel
 */
@Repository
public class UserProfileDao extends DaoGenericoImp<UserProfile, Long> implements IUserProfileDao{
    
}
