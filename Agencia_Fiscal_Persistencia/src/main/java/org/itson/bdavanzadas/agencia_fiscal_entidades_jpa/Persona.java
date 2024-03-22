
package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa a una persona en el sistema. Una persona tiene atributos
 * como RFC, nombres, apellidos, fecha de nacimiento, teléfono, CURP, entre
 * otros. Además, puede estar asociada a trámites y vehículos.
 *
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    // RFC (Registro Federal de Contribuyentes) de la persona.
    @Id
    @Column(name = "rfc", length = 13)
    private String rfc;

    // Nombres de la persona.
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    // Apellido paterno de la persona.
    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    // Apellido materno de la persona.
    @Column(name = "apellidoMaterno", length = 50)
    private String apellidoMaterno;

    // Fecha de nacimiento de la persona
    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    // Telefono de la persona
    @Column(name = "telefono", nullable = false, columnDefinition = "VARBINARY(32)")
    @Lob
    private byte[] telefono;

    // Indica si la persona es discapacitada o no
    @Column(name = "isDiscapacitado")
    private Boolean isDiscapacitado;

    // Lista de tramites relacionados a la persona
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<Tramite> tramites;

    // Lista de vehiculos relacionados a la persona
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<Vehiculo> vehiculos;

    /**
     * Constructor por defecto.
     */
    public Persona() {
    }

    public Persona(String rfc) {
        this.rfc = rfc;
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
    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, byte[] telefono, Boolean isDiscapacitado) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.isDiscapacitado = isDiscapacitado;
    }

    /**
     * Constructor que nos permite crear una persona con todos los atributos,
     * incluyendo las listas de trámites y vehículos.
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
     * @param tramites Lista de trámites asociados a la persona.
     * @param vehiculos Lista de vehículos asociados a la persona.
     */
    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, byte[] telefono, Boolean isDiscapacitado, List<Tramite> tramites, List<Vehiculo> vehiculos) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.isDiscapacitado = isDiscapacitado;
        this.tramites = tramites;
        this.vehiculos = vehiculos;
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
    public byte[] getTelefono() {
        return telefono;
    }

    /**
     * Permite establecer el teléfono de la persona.
     *
     * @param telefono Teléfono de la persona.
     */
    public void setTelefono(byte[] telefono) {
        this.telefono = telefono;
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
     * Permite obtener la lista de tramites relacionados a la persona.
     *
     * @return tramites de la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Permite establecer la lista de tramites de la persona.
     *
     * @param tramites lista de tramites relacionados a la persona.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Permite obtener la lista de vehiculos relacionados a la persona.
     *
     * @return vehiculos de la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Permite establecer la lista de vehiculos de la persona.
     *
     * @param vehiculos lista de vehiculos relacionados a la persona.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("rfc=").append(rfc);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", telefono=").append(telefono);
        sb.append(", isDiscapacitado=").append(isDiscapacitado);
        sb.append(", tramites=").append(tramites);
        sb.append(", vehiculos=").append(vehiculos);
        sb.append('}');
        return sb.toString();
    }

}
