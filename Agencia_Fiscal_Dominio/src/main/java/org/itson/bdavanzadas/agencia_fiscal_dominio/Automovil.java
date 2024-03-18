/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase que representa un automóvil en el sistema.
 * Un automóvil es un tipo específico de vehículo.
 */
@Entity
@Table(name = "automovil")
public class Automovil extends Vehiculo {

    /**
     * Constructor por defecto.
     */
    public Automovil() {
    }
    
    /**
     * Constructor que nos permite crear un automóvil con los atributos necesarios.
     *
     * @param numeroSerie Número de serie del automóvil.
     * @param color Color del automóvil.
     * @param modelo Modelo del automóvil.
     * @param linea Línea del automóvil.
     * @param marca Marca del automóvil.
     * @param estado Estado del automóvil.
     * @param persona Persona asociada al automóvil.
     */
    public Automovil(String numeroSerie, String color, String modelo, String linea, String marca, Boolean estado, Persona persona) {
        super(numeroSerie, color, modelo, linea, marca, estado, persona);
    }
    
}
