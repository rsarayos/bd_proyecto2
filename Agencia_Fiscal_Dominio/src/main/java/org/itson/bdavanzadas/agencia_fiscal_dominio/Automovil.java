/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alex_
 */
@Entity
@Table(name = "automovil")
public class Automovil extends Vehiculo {

    public Automovil() {
    }
    
    public Automovil(String numeroSerie, String color, String modelo, String linea, String marca, Boolean estado, Persona persona) {
        super(numeroSerie, color, modelo, linea, marca, estado, persona);
    }
    
}
