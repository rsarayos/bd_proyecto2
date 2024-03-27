package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

/**
 *
 * @author alex_
 */
public class PlacaNuevaDTO {
    
    private String numeroPlaca;
    private Calendar fechaRecepcion;
    private Boolean estado;
    private VehiculoNuevoDTO vehiculo;
    private Calendar fechaTramite;
    private Float costo;
    private PersonaNuevaDTO persona;

    public PlacaNuevaDTO(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
    
    public PlacaNuevaDTO(String numeroPlaca, Boolean estado, VehiculoNuevoDTO vehiculo, Calendar fechaTramite, Float costo, PersonaNuevaDTO persona) {
        this.numeroPlaca = numeroPlaca;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.persona = persona;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public VehiculoNuevoDTO getVehiculo() {
        return vehiculo;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public Float getCosto() {
        return costo;
    }

    public PersonaNuevaDTO getPersona() {
        return persona;
    }
    
    
    
    
    
}
