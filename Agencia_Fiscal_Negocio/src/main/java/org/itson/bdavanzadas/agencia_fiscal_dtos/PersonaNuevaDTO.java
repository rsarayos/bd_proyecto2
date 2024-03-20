package org.itson.bdavanzadas.agencia_fiscal_dtos;

import java.util.Calendar;

/**
 *
 * @author victo
 */
public class PersonaNuevaDTO {

    private String rfc;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaNacimiento;
    private String telefono;
    private String curp;
    private boolean Discapacitado;

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
     * @param curp CURP de la persona
     * @param isDiscapacitado true si la persona es discapacitada, false en caso
     * contrario.
     */
    public PersonaNuevaDTO(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, String curp, boolean isDiscapacitado) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.curp = curp;
        this.Discapacitado = isDiscapacitado;
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
     * Permite obtener la CURP (Clave Única de Registro de Población) del objeto
     * persona.
     *
     * @return CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Permite obtener si una persona es discapacitada o no.
     *
     * @return true si es discapacitada, false en caso contrario.
     */
    public boolean isDiscapacitado() {
        return Discapacitado;
    }

}
