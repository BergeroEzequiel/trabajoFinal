/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="rol")
public class UserProfile extends ObjetoGenerico{
 
//    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private int id; 
 
    @Column(name="tipo", length=15, unique=true, nullable=false)
    private String type = UserProfileType.USER.getUserProfileType();
     
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + getId());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserProfile))
            return false;
        UserProfile other = (UserProfile) obj;
        if (getId() != other.getId())
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "UserProfile [id=" + getId() + ",  type=" + type  + "]";
    }
     
 
}