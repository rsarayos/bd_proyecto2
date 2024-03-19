/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un trámite en el sistema.
 * Los trámites pueden estar asociados a una persona y tienen atributos como fecha de trámite y costo.
 */
@Entity
@Table(name = "tramite")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class Tramite implements Serializable {

    // Identificador único del trámite.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    private Long id;
    
    // Fecha en la que se realizó el trámite.
    @Column(name="fecha_tramite", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaTramite;
    
    // Costo del trámite.
    @Column(name = "costo", nullable = false)
    private Float costo;
    
    // Persona asociada al trámite.
    @ManyToOne
    @JoinColumn(name = "rfc_persona", nullable = false)
    private Persona persona;

    /**
     * Constructor por defecto.
     */
    public Tramite() {
    }

    /**
     * Constructor que nos permite crear un trámite con los atributos necesarios.
     *
     * @param fechaTramite Fecha en la que se realizó el trámite.
     * @param costo Costo del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Tramite(Calendar fechaTramite, Float costo, Persona persona) {
        this.fechaTramite = fechaTramite;
        this.costo = costo;
        this.persona = persona;
    }
    
    /**
     * Obtiene el identificador único del trámite.
     *
     * @return Identificador único del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del trámite.
     *
     * @param id Identificador único del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha en la que se realizó el trámite.
     *
     * @return Fecha de trámite.
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * Establece la fecha en la que se realizó el trámite.
     *
     * @param fechaTramite Fecha de trámite.
     */
    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
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
     * Establece el costo del trámite.
     *
     * @param costo Costo del trámite.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la persona asociada al trámite.
     *
     * @return Persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     *
     * @param persona Persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Calcula y devuelve el valor hash de esta instancia de Tramite.
     *
     * @return El valor hash de esta instancia de Tramite.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Tramite con el objeto especificado.
     *
     * @param object El objeto con el que se debe comparar Tramite.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena que representa a esta instancia de Tramite, mostrando solo el ID.
     *
     * @return Una cadena que representa a esta instancia de Tramite.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Tramite[ id=" + id + " ]";
    }
    
}
