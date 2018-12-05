package ar.edu.ucc.trabajoFinal.dto;

import ar.edu.ucc.trabajoFinal.model.Estado;
import ar.edu.ucc.trabajoFinal.model.UserProfile;

/**
 *
 * @author ezequiel
 */
public class UserDto {
    
    private Long id;
    
    private String ssoId;
    
    private String password;
    
    private String passwordNuevo;
         
    private String firstName;
    
    private String lastName;
 
    private String email;
    
    private UserProfile userProfile;
    
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getPasswordNuevo() {
        return passwordNuevo;
    }

    public void setPasswordNuevo(String passwordNuevo) {
        this.passwordNuevo = passwordNuevo;
    }
    
     
    
}
