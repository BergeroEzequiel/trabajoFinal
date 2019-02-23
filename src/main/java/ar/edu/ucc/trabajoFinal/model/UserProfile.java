/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="rol")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile extends ObjetoGenerico{
    
    public static final Long ID_ADMINISTRADOR = 2L;
    public static final Long ID_BASICO = 1L;
    public static final Long ID_AVANZADO = 3L;
 
    @Column(name="tipo", length=15, unique=true, nullable=false)
    @JsonProperty("type")
    private String type ;
     
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
        return true;
    }
 
    @Override
    public String toString() {
        return "UserProfile [id=" + getId() + ",  type=" + type  + "]";
    }
     
 
}
