package org.itson.bdavanzadas.agencia_fiscal_auxiliar;

import java.util.Calendar;

public class FiltroPersonas {
    
    private String nombre;
    private String rfc;
    private Calendar fechaNacimiento;

    public FiltroPersonas() {
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
