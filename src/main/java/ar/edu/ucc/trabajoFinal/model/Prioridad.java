/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.model;

/**
 *
 * @author ezequiel
 */
public enum Prioridad {
    TIPO_0("Critica"), TIPO_1("Alta"), TIPO_2("Media"), TIPO_3("Baja");
    
    private final String descripcion;
    
    public String getDescripcion(){
        return this.descripcion;
    }

    private Prioridad(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
