package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

/**
 * La clase TramiteDTO es un DTO (Data Transfer Object) que representa un trámite con todos sus atributos.
 * Esta clase es utilizada para transferir datos entre el frontend y el backend de la aplicación.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class TramiteDTO {
    
    private Calendar fechaTramite;
    private Float costo;
    private String tipo;
    private PersonaNuevaDTO persona;
    
    /**
     * Constructor que permite crear un objeto DTO de trámite con todos los atributos.
     *
     * @param fechaTramite Fecha del trámite.
     * @param costo Costo del trámite.
     * @param tipo Tipo de trámite.
     * @param persona Objeto DTO de la persona asociada al trámite.
     */
    public TramiteDTO(Calendar fechaTramite, Float costo, String tipo, PersonaNuevaDTO persona){
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.tipo = tipo;
        this.persona = persona;
    }

    /**
     * Obtiene la fecha del trámite.
     *
     * @return Fecha del trámite.
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return Costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }
    
    /**
     * Obtiene el tipo de trámite.
     *
     * @return Tipo de trámite.
     */
    public String getTipo(){
        return tipo;
    }

    /**
     * Obtiene el objeto DTO de la persona asociada al trámite.
     *
     * @return Objeto DTO de la persona asociada al trámite.
     */
    public PersonaNuevaDTO getPersona() {
        return persona;
    }

}
