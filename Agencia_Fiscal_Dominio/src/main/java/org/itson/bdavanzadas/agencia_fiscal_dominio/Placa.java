/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa una placa en el sistema.
 * Una placa es un tipo específico de trámite con un número de placa y estado asociados.
 */
@Entity
@Table(name = "placa")
public class Placa extends Tramite {

    // Número de placa asociado a la placa.
    @Column(name = "numero_placa")
    private String numeroPlaca;
    
    // Fecha en la que se recibió la placa.
    @Column(name="fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;
    
    // Vigencia de la placa.
    @Column(name = "estado")
    private Boolean estado;

    /**
     * Constructor por defecto.
     */
    public Placa() {
    }

    /**
     * Constructor que nos permite crear una placa con los atributos necesarios.
     *
     * @param numeroPlaca Número de placa asociado a la placa.
     * @param fechaRecepcion Fecha en la que se recibió la placa.
     * @param estado Estado de la placa.
     * @param fechaTramite Fecha en la que se realizó el trámite.
     * @param costo Costo del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Placa(String numeroPlaca, Calendar fechaRecepcion, Boolean estado, Calendar fechaTramite, Float costo, Persona persona) {
        super(fechaTramite, costo, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
    }
    
    /**
     * Obtiene el número de placa asociado a la placa.
     *
     * @return Número de placa asociado a la placa.
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Establece el número de placa asociado a la placa.
     *
     * @param numeroPlaca Número de placa asociado a la placa.
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Obtiene la fecha en la que se recibió la placa.
     *
     * @return Fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha en la que se recibió la placa.
     *
     * @param fechaRecepcion Fecha de recepción de la placa.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Obtiene el estado de la placa.
     *
     * @return Estado de la placa.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     *
     * @param estado Estado de la placa.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Calcula y devuelve el valor hash de esta instancia de Placa.
     *
     * @return El valor hash de esta instancia de Placa.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPlaca != null ? numeroPlaca.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Placa con el objeto especificado.
     *
     * @param object El objeto con el que se debe comparar Placa.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.numeroPlaca == null && other.numeroPlaca != null) || (this.numeroPlaca != null && !this.numeroPlaca.equals(other.numeroPlaca))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena que representa a esta instancia de Placa, mostrando solo el número de placa.
     *
     * @return Una cadena que representa a esta instancia de Placa.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Placa[ id=" + numeroPlaca + " ]";
    }
    
}
