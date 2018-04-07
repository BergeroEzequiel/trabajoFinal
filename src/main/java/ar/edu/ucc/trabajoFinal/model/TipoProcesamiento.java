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
public enum TipoProcesamiento {
    TIPO_1("20 Minutos"), TIPO_2("Diario"), TIPO_3("Semanal");
    
    private final String descripcion;

    public String getDescripcion() {
        return descripcion;
    }
    
    private TipoProcesamiento(String descripcion){
        this.descripcion = descripcion;
    }
    
    
}
