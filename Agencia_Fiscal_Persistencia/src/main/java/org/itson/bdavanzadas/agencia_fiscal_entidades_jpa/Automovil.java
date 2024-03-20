package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase que representa un automóvil en el sistema.
 * Un automóvil es un tipo específico de vehículo.
 */
@Entity
@Table(name = "automoviles")
public class Automovil extends Vehiculo implements Serializable{

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
