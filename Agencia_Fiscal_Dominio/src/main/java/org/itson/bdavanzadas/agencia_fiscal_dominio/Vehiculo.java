/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa un vehículo en el sistema.
 * Un vehículo puede ser asociado a una persona y tiene atributos como número de serie, color, modelo, línea, marca y estado.
 */
@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    // Número de serie del vehículo.
    @Id
    @Column(name = "numero_serie", length = 17)
    private String numeroSerie;
    
    // Color del vehículo.
    @Column(name = "color", nullable = false, length = 30)
    private String color;
    
    // Modelo del vehículo.
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
    
    // Línea del vehículo.
    @Column(name = "linea", nullable = false, length = 50)
    private String linea;
    
    // Marca del vehículo.
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;
    
    // Estado del vehículo.
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    
    // Persona asociada al vehículo.
    @ManyToOne
    @JoinColumn(name = "rfc_persona", nullable = false)
    private Persona persona;

    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
    }

    /**
     * Constructor que nos permite crear un vehículo con los atributos necesarios.
     *
     * @param numeroSerie Número de serie del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param estado Estado del vehículo.
     * @param persona Persona asociada al vehículo.
     */
    public Vehiculo(String numeroSerie, String color, String modelo, String linea, String marca, Boolean estado, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.estado = estado;
        this.persona = persona;
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
     * Establece el número de serie del vehículo.
     *
     * @param numeroSerie Número de serie del vehículo.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
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
     * Establece el color del vehículo.
     *
     * @param color Color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
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
     * Establece el modelo del vehículo.
     *
     * @param modelo Modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
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
     * Establece la línea del vehículo.
     *
     * @param linea Línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
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
     * Establece la marca del vehículo.
     *
     * @param marca Marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene el estado del vehículo.
     *
     * @return Estado del vehículo.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado del vehículo.
     *
     * @param estado Estado del vehículo.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Calcula y devuelve el valor hash de esta instancia de Vehiculo.
     *
     * @return El valor hash de esta instancia de Vehiculo.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSerie != null ? numeroSerie.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Vehiculo con el objeto especificado.
     *
     * @param object El objeto con el que se debe comparar Vehiculo.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.numeroSerie == null && other.numeroSerie != null) || (this.numeroSerie != null && !this.numeroSerie.equals(other.numeroSerie))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena que representa a esta instancia de Vehiculo, mostrando solo el número de serie.
     *
     * @return Una cadena que representa a esta instancia de Vehiculo.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Vehiculo[ id=" + numeroSerie + " ]";
    }
    
}
