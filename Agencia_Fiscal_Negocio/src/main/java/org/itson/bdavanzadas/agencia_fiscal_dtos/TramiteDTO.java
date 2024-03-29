package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

public class TramiteDTO {
    
    private Calendar fechaTramite;
    private Float costo;
    private String tipo;
    private PersonaNuevaDTO persona;
    
    public TramiteDTO(Calendar fechaTramite, Float costo, String tipo, PersonaNuevaDTO persona){
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public Float getCosto() {
        return costo;
    }
    
    public String getTipo(){
        return tipo;
    }

    public PersonaNuevaDTO getPersona() {
        return persona;
    }

}
