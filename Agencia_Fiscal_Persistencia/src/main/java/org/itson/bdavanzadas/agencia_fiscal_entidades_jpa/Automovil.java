package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clase que representa un automóvil en el sistema.
 * Un automóvil es un tipo específico de vehículo.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
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
     * @param numeroSerie Número de serie del automóvil
     * @param color Color del automóvil.
     * @param modelo Modelo del automóvil.
     * @param linea Línea del automóvil.
     * @param marca Marca del automóvil.
     * @param persona Persona asociada al automóvil.
     */
    public Automovil(String numeroSerie, String color, String modelo, String linea, String marca, Persona persona) {
        super(numeroSerie, color, modelo, linea, marca, persona);
    }

    /**
     * Devuelve una cadena que representa a esta instancia de Automovil,
     * mostrando sus atributos
     *
     * @return Una cadena que representa a esta instancia de Licencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Automovil{");
        sb.append("numeroSerie=").append(numeroSerie);
        sb.append(", color=").append(color);
        sb.append(", modelo=").append(modelo);
        sb.append(", linea=").append(linea);
        sb.append(", marca=").append(marca);
        sb.append(", persona=").append(persona);
        sb.append('}');
        return sb.toString();
    }
    
}
