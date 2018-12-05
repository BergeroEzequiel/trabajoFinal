package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IUserProfileDao;
import ar.edu.ucc.trabajoFinal.model.UserProfile;
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
public class UserProfileService {
    
    @Autowired
    DaoGenerico<UserProfile, Long> userProfileDao;

    IUserProfileDao userProfileDaoParticular;

    @PostConstruct
    public void init() {
            userProfileDaoParticular = (IUserProfileDao) userProfileDao;
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<UserProfile> getRoles() throws ParseException {
        //El listado de userProfiles son todos los ROLES que aceptan los usuarios.
        List<UserProfile> userProfiles = this.userProfileDaoParticular.getAll();
        return userProfiles;
    }
    
}
