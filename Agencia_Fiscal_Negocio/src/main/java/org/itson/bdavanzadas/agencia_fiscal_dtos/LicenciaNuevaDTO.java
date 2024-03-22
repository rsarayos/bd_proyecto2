package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

/**
 * Clase que representa un objeto DTO (Data Transfer Object) para la creación de una nueva licencia.
 * Este objeto contiene los datos necesarios para crear una licencia nueva.
 */
public class LicenciaNuevaDTO {
    
    private Calendar fechaVencimiento;
    private Calendar fechaTramite;
    private Float costo;
    private PersonaNuevaDTO persona;
    private Boolean estado;

    /**
     * Constructor para inicializar un objeto LicenciaNuevaDTO con los datos requeridos.
     *
     * @param fechaVencimiento La fecha de vencimiento de la licencia.
     * @param fechaTramite La fecha en que se tramita la licencia.
     * @param costo El costo de la licencia.
     * @param persona La persona a la que se otorga la licencia.
     * @param estado El estado de la licencia.
     */
    public LicenciaNuevaDTO(Calendar fechaVencimiento, Calendar fechaTramite, Float costo, PersonaNuevaDTO persona, Boolean estado) {
        this.fechaVencimiento = fechaVencimiento;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.persona = persona;
        this.estado = estado;
    }

    /**
     * Método para obtener la fecha de vencimiento de la licencia.
     *
     * @return La fecha de vencimiento de la licencia.
     */
    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método para obtener la fecha de tramitación de la licencia.
     *
     * @return La fecha de tramitación de la licencia.
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * Método para obtener el costo de la licencia.
     *
     * @return El costo de la licencia.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Método para obtener la persona a la que se otorga la licencia.
     *
     * @return La persona a la que se otorga la licencia.
     */
    public PersonaNuevaDTO getPersona() {
        return persona;
    }

    /**
     * Método para obtener el estado de la licencia.
     *
     * @return El estado de la licencia.
     */
    public Boolean getEstado() {
        return estado;
    }
    
    /**
     * Método para validar si los datos del objeto LicenciaNuevaDTO son válidos.
     *
     * @return true si los datos son válidos, de lo contrario lanza una excepción.
     * @throws ValidacionDTOException Si alguno de los datos es inválido.
     */
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
