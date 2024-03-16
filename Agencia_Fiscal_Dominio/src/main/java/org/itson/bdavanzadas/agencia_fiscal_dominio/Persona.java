package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex_
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @Column(name = "rfc")
    private String rfc;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", length = 50)
    private String apellidoMaterno;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "curp", nullable = false, length = 18, unique = true)
    private String curp;

    @Column(name = "isDiscapacitado")
    private Boolean isDiscapacitado;

    /**
     * Constructor por defecto.
     */
    public Persona() {
    }

    /**
     * Constructor que nos permite crear una persona con los atributos
     * necesarios (atributos que no permiten un campo null).
     *
     * @param rfc RFC de la persona.
     * @param nombres Nombres de la persona.
     * @param apellidoPaterno Apellido Paterno de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param telefono Telefono de la persona
     * @param curp CURP de la persona
     */
    public Persona(String rfc, String nombres, String apellidoPaterno, Calendar fechaNacimiento, String telefono, String curp) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.curp = curp;
    }

    /**
     * Constructor que nos permite crear una persona con todos los atributos.
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
    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, String curp, Boolean isDiscapacitado) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.curp = curp;
        this.isDiscapacitado = isDiscapacitado;
    }

    /**
     * Permite obtener el RFC (Registro Federal de Contribuyentes) de la
     * persona.
     *
     * @return rfc de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Permite establecer el RFC (Registro Federal de Contribuyentes) de la
     * persona.
     *
     * @param rfc RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Permite obtener los nombres de la persona.
     *
     * @return nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Permite establecer los nombres de la persona.
     *
     * @param nombres Nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Permite obtener el apellido paterno de la persona.
     *
     * @return Apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Permite establecer el apellido paterno de la persona.
     *
     * @param apellidoPaterno Apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Permite obtener el apellido materno de la persona.
     *
     * @return Apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Permite establecer el apellido materno de la persona.
     *
     * @param apellidoMaterno Apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Permite obtener la fecha de nacimiento de la persona.
     *
     * @return Fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Permite establecer la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento Fecha de nacimineto de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Permite obtener el teléfono de la persona.
     *
     * @return Teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permite establecer el teléfono de la persona.
     *
     * @param telefono Teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Permite obtener la CURP (Clave Única de Registro de Población) de la
     * persona.
     *
     * @return CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Permite establecer la CURP (Clave Única de Registro de Población) de la
     * persona.
     *
     * @param curp CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Permite obtener si una persona es discapacitada o no.
     *
     * @return true si es discapacitada, false en caso contrario.
     */
    public Boolean getIsDiscapacitado() {
        return isDiscapacitado;
    }

    /**
     * Permite establecer si una persona es discapacitada o no.
     *
     * @param isDiscapacitado true si es discapacitada, false en caso contrario.
     */
    public void setIsDiscapacitado(Boolean isDiscapacitado) {
        this.isDiscapacitado = isDiscapacitado;
    }

    /**
     * Calcula y devuelve el valor hash de esta instancia de Persona.
     *
     * @return El valor hash de esta instancia de Persona.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfc != null ? rfc.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Persona con el objeto especificado.
     *
     * @param object El objeto con el que se debe comparar Persona.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.rfc == null && other.rfc != null) || (this.rfc != null && !this.rfc.equals(other.rfc))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena de esta instancia de Persona, mostrando solo el RFC.
     *
     * @return Una cadena de esta instancia de Persona.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.fiscalbddominio.Persona[ rfc=" + rfc + " ]";
    }

}
