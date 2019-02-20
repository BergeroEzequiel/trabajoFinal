package ar.edu.ucc.trabajoFinal.dto;

import ar.edu.ucc.trabajoFinal.model.TramaFiltrada;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ezequiel
 */
public class TramaFiltradaDto implements Serializable{

    public TramaFiltradaDto() {
    }

    public TramaFiltradaDto(String variable, List<TramaFiltrada> valores) {
        this.variable = variable;
        this.valores = valores;
    }

    private String variable;
    private List<TramaFiltrada> valores;

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public List<TramaFiltrada> getValores() {
        return valores;
    }

    public void setValores(List<TramaFiltrada> valores) {
        this.valores = valores;
    }

}