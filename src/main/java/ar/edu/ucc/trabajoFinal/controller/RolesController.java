package ar.edu.ucc.trabajoFinal.controller;

import ar.edu.ucc.trabajoFinal.model.UserProfile;
import ar.edu.ucc.trabajoFinal.service.UserProfileService;
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
public class RolesController {
    
    @Autowired
    UserProfileService userProfileService;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = "/roles", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getRoles() throws Exception {

        List<UserProfile> roles = userProfileService.getRoles();
        return new ResponseEntity(roles, HttpStatus.OK);
    }
    
}
