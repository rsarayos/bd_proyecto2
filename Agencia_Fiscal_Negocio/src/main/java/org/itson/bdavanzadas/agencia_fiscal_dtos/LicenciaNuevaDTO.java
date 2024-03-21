package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

public class LicenciaNuevaDTO {
    
    private Calendar fechaVencimiento;
    private Calendar fechaTramite;
    private Float costo;
    private Persona persona;

    public LicenciaNuevaDTO(Calendar fechaVencimiento, Calendar fechaTramite, Float costo, Persona persona) {
        this.fechaVencimiento = fechaVencimiento;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.persona = persona;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public Float getCosto() {
        return costo;
    }

    public Persona getPersona() {
        return persona;
    }
    
    public boolean esValido() throws ValidacionDTOException {
        if (this.fechaTramite == null) {
            throw new ValidacionDTOException("Fecha de tramite en licencia invalida");
        }
        if (this.fechaVencimiento == null) {
            throw new ValidacionDTOException("Fecha de vencimiento en licencia invalida");
        }
        if (this.costo == null 
              || this.costo < 0) {
            throw new ValidacionDTOException("Precio de licencia invalido");
        }
        if (this.persona == null) {
            throw new ValidacionDTOException("Persona relacionada a licencia null");
        }
        return true;
    }
    
}
