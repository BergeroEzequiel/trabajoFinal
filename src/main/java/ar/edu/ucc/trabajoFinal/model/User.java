/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="usuario")
public class User  extends ObjetoGenerico{
 
    @Column(name="sso_id", unique=true, nullable=false)
    private String ssoId;
    
    @Column(name="password", nullable=false)
    private String password;
         
    @Column(name="nombre", nullable=false)
    private String firstName;
 
    @Column(name="apellido", nullable=false)
    private String lastName;
 
    @Column(name="email", nullable=false)
    private String email;
    
    @ManyToOne
    @JoinColumn(name="id_rol")
    private UserProfile userProfile;
    
    @ManyToOne
    @JoinColumn(name="id_estado")
    private Estado estado;
 
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + getId());
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }
 
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (!(obj instanceof User))
//            return false;
//        User other = (User) obj;
//        if (getId() != other.getId())
//            return false;
//        if (ssoId == null) {
//            if (other.ssoId != null)
//                return false;
//        } else if (!ssoId.equals(other.ssoId))
//            return false;
//        return true;
//    }
 
    @Override
    public String toString() {
        return "User [id=" + getId() + ", ssoId=" + ssoId + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + "]";
    }
    
}
