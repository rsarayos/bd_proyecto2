package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

public class TramiteReporteDTO {
    
    private Calendar fecha;
    private String tipo;
    private String nombre;
    private Float costo;

    public TramiteReporteDTO(Calendar fecha, String tipo, String nombre, Float costo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Calendar getFecha() {
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
