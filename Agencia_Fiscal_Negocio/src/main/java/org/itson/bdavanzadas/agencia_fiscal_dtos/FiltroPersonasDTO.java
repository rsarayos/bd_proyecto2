package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

public class FiltroPersonasDTO {
    
    private String nombre;
    private String rfc;
    private Calendar fechaNacimiento;

    public FiltroPersonasDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
