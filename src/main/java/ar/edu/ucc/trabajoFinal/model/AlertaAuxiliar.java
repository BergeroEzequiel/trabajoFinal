package ar.edu.ucc.trabajoFinal.model;

import static java.lang.Math.toIntExact;

/**
 *
 * @author ezequiel
 */
public class AlertaAuxiliar {
    
    private Nodo nodo;
    private String variableAfectada;
    private Long cantidadRepeticiones;

    public Nodo getNodo() {
        return nodo;
    }

    //    public void setNodo(Nodo nodo) {
//            this.nodo = nodo;
//    }
    
    public void setNodo(Long idNodo) {
        Nodo nodo = new Nodo();
        nodo.setId(idNodo);
        this.nodo = nodo;
    }

    public String getVariableAfectada() {
        return variableAfectada;
    }

    public void setVariableAfectada(String variableAfectada) {
        this.variableAfectada = variableAfectada;
    }

    public Long getCantidadRepeticiones() {
        return cantidadRepeticiones;
    }

    public void setCantidadRepeticiones(Long cantidadRepeticiones) {
        this.cantidadRepeticiones = cantidadRepeticiones;
    }

    
    
    
    
}
