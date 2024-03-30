package org.itson.bdavanzadas.agencia_fiscal_auxiliar;

import java.util.Calendar;

/**
 * La clase FiltroReportes representa un filtro para realizar consultas al generar reportes.
 * Permite filtrar reportes por nombre del contribuyente, fechas inicial y final, y tipo de trámites.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class FiltroReportes {

    private String nombreContribuyente;
    private Calendar fechaInicial;
    private Calendar fechaFinal;
    private String tipoTramites;

    /**
     * Obtiene el nombre del contribuyente utilizado para filtrar reportes.
     *
     * @return El nombre del contribuyente utilizado para filtrar reportes.
     */
    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    /**
     * Establece el nombre del contribuyente para filtrar reportes.
     *
     * @param nombreContribuyente El nombre del contribuyente para filtrar reportes.
     */
    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }

    /**
     * Obtiene la fecha inicial utilizada para filtrar reportes.
     *
     * @return La fecha inicial utilizada para filtrar reportes.
     */
    public Calendar getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Establece la fecha inicial para filtrar reportes.
     *
     * @param fechaInicial La fecha inicial para filtrar reportes.
     */
    public void setFechaInicial(Calendar fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * Obtiene la fecha final utilizada para filtrar reportes.
     *
     * @return La fecha final utilizada para filtrar reportes.
     */
    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Establece la fecha final para filtrar reportes.
     *
     * @param fechaFinal La fecha final para filtrar reportes.
     */
    public void setFechaFinal(Calendar fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Obtiene el tipo de trámites utilizado para filtrar reportes.
     *
     * @return El tipo de trámites utilizado para filtrar reportes.
     */
    public String getTipoTramites() {
        return tipoTramites;
    }

    /**
     * Establece el tipo de trámites para filtrar reportes.
     *
     * @param tipoTramites El tipo de trámites para filtrar reportes.
     */
    public void setTipoTramites(String tipoTramites) {
        this.tipoTramites = tipoTramites;
    }
    
}
