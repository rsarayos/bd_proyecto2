/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;

/**
 *
 * @author alex_
 */
public class LicenciaNuevaDTO {
    
    private Calendar fechaVencimiento;
    private Calendar fechaTramite;
    private Float costo;
    private Persona persona;

    public LicenciaNuevaDTO(Calendar fechaVencimiento, Calendar fechaTramite, Float costo, Persona persona) {
        this.fechaVencimiento = fechaVencimiento;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.persona = persona;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public Float getCosto() {
        return costo;
    }

    public Persona getPersona() {
        return persona;
    }
    
}
