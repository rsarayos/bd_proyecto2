package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

public class VehiculoNuevoDTO {
    
    private String numeroSerie;
    private String color;
    private String modelo;
    private String linea;
    private String marca;
    private PersonaNuevaDTO persona;
    private List<Placa> placas;

    public VehiculoNuevoDTO(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public VehiculoNuevoDTO(String numeroSerie, String color, String modelo, String linea, String marca, PersonaNuevaDTO persona) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.persona = persona;
    }
    
    public VehiculoNuevoDTO(String numeroSerie, String color, String modelo, String linea, String marca, PersonaNuevaDTO persona, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.persona = persona;
        this.placas = placas;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public String getLinea() {
        return linea;
    }

    public String getMarca() {
        return marca;
    }

    public PersonaNuevaDTO getPersona() {
        return persona;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }
    
    public boolean isValid() throws ValidacionDTOException {
        return true;
    }
    
}
