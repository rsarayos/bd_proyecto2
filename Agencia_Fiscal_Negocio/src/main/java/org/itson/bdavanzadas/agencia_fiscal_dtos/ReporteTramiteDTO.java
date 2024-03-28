package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alex_
 */
public class ReporteTramiteDTO {
    
    private Date fecha;
    private String tipo;
    private String nombre;
    private Float costo;

    public ReporteTramiteDTO(Date fecha, String tipo, String nombre, Float costo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getCosto() {
        return costo;
    }
    
}
