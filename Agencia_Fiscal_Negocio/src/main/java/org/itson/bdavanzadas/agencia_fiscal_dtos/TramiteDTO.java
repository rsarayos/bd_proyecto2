package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

public class TramiteDTO {
    
    private Long id;
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
    
    public TramiteDTO(Long id, Calendar fechaTramite, Float costo, String tipo, PersonaNuevaDTO persona){
        this.id = id;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Long getId() {
        return id;
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
    
    public boolean isValid() throws ValidacionDTOException {
        // ToDo: AGREGAR VALIDACIONES DE LOS ATRIBUTOS
        return true;
    }

}
