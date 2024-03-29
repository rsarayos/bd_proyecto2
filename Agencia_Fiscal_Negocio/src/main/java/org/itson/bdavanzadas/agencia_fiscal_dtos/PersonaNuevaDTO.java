package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;
import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

public class PersonaNuevaDTO {

    private String rfc;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaNacimiento;
    private String telefono;
    private Boolean Discapacitado;
    private List<Tramite> tramites;
    private List<Vehiculo> vehiculos;

    public PersonaNuevaDTO(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Constructor que nos permite crear un objeto DTO de persona con todos los
     * atributos.
     *
     * @param rfc RFC de la persona.
     * @param nombres Nombres de la persona.
     * @param apellidoPaterno Apellido Paterno de la persona.
     * @param apellidoMaterno Apellido Materno de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param telefono Telefono de la persona
     * @param isDiscapacitado true si la persona es discapacitada, false en caso
     * contrario.
     * @param tramites lista de tramites de la persona
     * @param vehiculos lista de vehiculos de la persona
     */
    public PersonaNuevaDTO(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, Boolean isDiscapacitado, List<Tramite> tramites, List<Vehiculo> vehiculos) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.Discapacitado = isDiscapacitado;
        this.tramites = tramites;
        this.vehiculos = vehiculos;
    }

    /**
     * Permite obtener el RFC (Registro Federal de Contribuyentes) del objeto
     * persona.
     *
     * @return rfc de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Permite obtener los nombres del objeto persona.
     *
     * @return nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Permite obtener el apellido paterno del objeto persona.
     *
     * @return Apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Permite obtener el apellido materno del objeto persona.
     *
     * @return Apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Permite obtener la fecha de nacimiento del objeto persona.
     *
     * @return Fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Permite obtener el teléfono del objeto persona.
     *
     * @return Teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permite obtener si una persona es discapacitada o no.
     *
     * @return true si es discapacitada, false en caso contrario.
     */
    public Boolean isDiscapacitado() {
        return Discapacitado;
    }

    /**
     * Permite obtener una lista con los trámites que haya realizado la persona.
     *
     * @return Una lista con los trámites que haya realizado la persona
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Permite obtener una lista con todos los vehículos que tenga la persona.
     *
     * @return Una lista con todos los vehículos que tenga la persona
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public boolean esMayorDe18() {
        Calendar fechaActual = Calendar.getInstance();
        
        // Obtener la fecha de nacimiento de la persona
        Calendar fechaNacimiento = this.fechaNacimiento;
        
        // Calcular la edad
        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        
        // Verificar si la persona tiene menos de 18 años
        if (fechaActual.get(Calendar.MONTH) < fechaNacimiento.get(Calendar.MONTH)) {
            edad--;
        } else if (fechaActual.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)
                && fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH)) {
            edad--;
        }
        
        return edad >= 18;
    }

    public boolean esValido() throws ValidacionDTOException{
        // en este caso todos estan hardcoreados, por lo cual son validos
        return true;
    }

}
