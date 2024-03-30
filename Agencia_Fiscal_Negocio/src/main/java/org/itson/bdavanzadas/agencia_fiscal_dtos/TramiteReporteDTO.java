package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import java.util.Date;

/**
 * La clase TramiteReporteDTO es un DTO (Data Transfer Object) que representa un trámite simplificado 
 * para su uso en reportes. Contiene información básica de un trámite.
 * Esta clase es utilizada para transferir datos entre el frontend y el backend de la aplicación.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class TramiteReporteDTO {
    
    private Date fecha;
    private String tipo;
    private String nombre;
    private Float costo;

    /**
     * Constructor que permite crear un objeto DTO de trámite simplificado para reportes.
     *
     * @param fecha Fecha del trámite.
     * @param tipo Tipo de trámite.
     * @param nombre Nombre del contribuyente asociado al trámite.
     * @param costo Costo del trámite.
     */
    public TramiteReporteDTO(Date fecha, String tipo, String nombre, Float costo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.costo = costo;
    }

    /**
     * Obtiene la fecha del trámite.
     *
     * @return Fecha del trámite.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Obtiene el tipo de trámite.
     *
     * @return Tipo de trámite.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nombre del contribuyente asociado al trámite.
     *
     * @return Nombre del contribuyente asociado al trámite.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return Costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }
    
}
