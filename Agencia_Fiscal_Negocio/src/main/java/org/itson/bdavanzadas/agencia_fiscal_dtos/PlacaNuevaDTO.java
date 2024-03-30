package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

/**
 * La clase PlacaNuevaDTO es un DTO (Data Transfer Object) que representa una nueva placa con todos sus atributos.
 * Esta clase es utilizada para transferir datos entre el frontend y el backend de la aplicación.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class PlacaNuevaDTO {
    
    private String numeroPlaca;
    private Calendar fechaRecepcion;
    private Boolean estado;
    private VehiculoNuevoDTO vehiculo;
    private Calendar fechaTramite;
    private Float costo;
    private PersonaNuevaDTO persona;

    /**
     * Constructor que inicializa el número de placa.
     *
     * @param numeroPlaca Número de la placa.
     */
    public PlacaNuevaDTO(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Constructor que permite crear un objeto DTO de placa con todos los atributos.
     *
     * @param numeroPlaca Número de la placa.
     * @param fechaRecepcion Fecha de recepción de la placa.
     * @param estado Estado de la placa (activo/inactivo).
     * @param vehiculo Objeto DTO del vehículo asociado a la placa.
     * @param fechaTramite Fecha del trámite relacionado con la placa.
     * @param costo Costo del trámite de la placa.
     * @param persona Objeto DTO de la persona propietaria de la placa.
     */
    public PlacaNuevaDTO(String numeroPlaca, Calendar fechaRecepcion, Boolean estado, VehiculoNuevoDTO vehiculo, Calendar fechaTramite, Float costo, PersonaNuevaDTO persona) {
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     * Establece el número de placa.
     *
     * @param numeroPlaca Número de la placa.
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Obtiene el número de placa.
     *
     * @return Número de la placa.
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     *
     * @return Fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Obtiene el estado de la placa.
     *
     * @return Estado de la placa (activo/inactivo).
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Obtiene el objeto DTO del vehículo asociado a la placa.
     *
     * @return Objeto DTO del vehículo asociado a la placa.
     */
    public VehiculoNuevoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     * Obtiene la fecha del trámite relacionado con la placa.
     *
     * @return Fecha del trámite relacionado con la placa.
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * Obtiene el costo del trámite de la placa.
     *
     * @return Costo del trámite de la placa.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Obtiene el objeto DTO de la persona propietaria de la placa.
     *
     * @return Objeto DTO de la persona propietaria de la placa.
     */
    public PersonaNuevaDTO getPersona() {
        return persona;
    } 
    
}
