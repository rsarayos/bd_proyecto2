package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import java.util.Date;

public class TramiteReporteDTO {
    
    private Date fecha;
    private String tipo;
    private String nombre;
    private Float costo;

    public TramiteReporteDTO(Date fecha, String tipo, String nombre, Float costo) {
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
