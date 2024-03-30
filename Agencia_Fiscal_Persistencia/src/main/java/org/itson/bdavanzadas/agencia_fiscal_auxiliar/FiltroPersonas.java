package org.itson.bdavanzadas.agencia_fiscal_auxiliar;

import java.util.Calendar;

/**
 * La clase FiltroPersonas representa un filtro para realizar consultas de personas.
 * Permite filtrar personas por nombre, RFC y fecha de nacimiento.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class FiltroPersonas {
    
    private String nombre;
    private String rfc;
    private Calendar fechaNacimiento;

    /**
     * Constructor por defecto de la clase FiltroPersonas.
     */
    public FiltroPersonas() {
    }

    /**
     * Obtiene el nombre utilizado para filtrar personas.
     *
     * @return El nombre utilizado para filtrar personas.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre para filtrar personas.
     *
     * @param nombre El nombre para filtrar personas.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el RFC utilizado para filtrar personas.
     *
     * @return El RFC utilizado para filtrar personas.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC para filtrar personas.
     *
     * @param rfc El RFC para filtrar personas.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene la fecha de nacimiento utilizada para filtrar personas.
     *
     * @return La fecha de nacimiento utilizada para filtrar personas.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento para filtrar personas.
     *
     * @param fechaNacimiento La fecha de nacimiento para filtrar personas.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
