package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

public class FiltroReportesDTO {
    
    private String nombreContribuyente;
    private Calendar fechaInicial;
    private Calendar fechaFinal;
    private String tipoTramites;

    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }

    public Calendar getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Calendar fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Calendar fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipoTramites() {
        return tipoTramites;
    }

    public void setTipoTramites(String tipoTramites) {
        this.tipoTramites = tipoTramites;
    }
    
}
