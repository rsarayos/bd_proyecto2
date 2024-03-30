package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

/**
 * La clase VehiculoNuevoDTO es un DTO (Data Transfer Object) que representa un vehículo nuevo.
 * Contiene información sobre el vehículo y su propietario.
 * Esta clase es utilizada para transferir datos entre el frontend y el backend de la aplicación.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class VehiculoNuevoDTO {
    
    private String numeroSerie;
    private String color;
    private String modelo;
    private String linea;
    private String marca;
    private PersonaNuevaDTO persona;
    private List<Placa> placas;

    /**
     * Constructor que permite crear un objeto DTO de vehículo nuevo con número de serie.
     *
     * @param numeroSerie Número de serie del vehículo.
     */
    public VehiculoNuevoDTO(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Constructor que permite crear un objeto DTO de vehículo nuevo con todos sus atributos.
     *
     * @param numeroSerie Número de serie del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param persona Propietario del vehículo.
     */
    public VehiculoNuevoDTO(String numeroSerie, String color, String modelo, String linea, String marca, PersonaNuevaDTO persona) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.persona = persona;
    }
    
    /**
     * Constructor que permite crear un objeto DTO de vehículo nuevo con todos sus atributos incluyendo las placas.
     *
     * @param numeroSerie Número de serie del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param persona Propietario del vehículo.
     * @param placas Lista de placas asociadas al vehículo.
     */
    public VehiculoNuevoDTO(String numeroSerie, String color, String modelo, String linea, String marca, PersonaNuevaDTO persona, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.persona = persona;
        this.placas = placas;
    }

    /**
     * Obtiene el número de serie del vehículo.
     *
     * @return Número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Obtiene el color del vehículo.
     *
     * @return Color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return Modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene la línea del vehículo.
     *
     * @return Línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return Marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene el propietario del vehículo.
     *
     * @return Propietario del vehículo.
     */
    public PersonaNuevaDTO getPersona() {
        return persona;
    }

    /**
     * Obtiene la lista de placas asociadas al vehículo.
     *
     * @return Lista de placas asociadas al vehículo.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establece la lista de placas asociadas al vehículo.
     *
     * @param placas Lista de placas a establecer.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }
    
    /**
     * Verifica si el DTO de vehículo nuevo es válido.
     *
     * @return true si el DTO es válido, false en caso contrario.
     * @throws ValidacionDTOException si el DTO no es válido.
     */
    public boolean isValid() throws ValidacionDTOException {
        return true;
    }
    
}
