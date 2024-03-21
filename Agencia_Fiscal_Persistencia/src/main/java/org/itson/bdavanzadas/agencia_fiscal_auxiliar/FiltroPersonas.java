
package org.itson.bdavanzadas.agencia_fiscal_auxiliar;

import java.util.GregorianCalendar;

/**
 *
 * @author victo
 */
public class FiltroPersonas {
    
    private String nombre;
    private String rfc;
    private GregorianCalendar fechaNacimiento;

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

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
