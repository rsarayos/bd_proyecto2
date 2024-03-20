/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa una licencia en el sistema.
 * Una licencia es un tipo específico de trámite con una fecha de vencimiento adicional.
 */
@Entity
@Table(name = "licencia")
public class Licencia extends Tramite implements Serializable {
    
    // Fecha de vencimiento de la licencia.
    @Column(name="fecha_vencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaVencimiento;

    /**
     * Constructor por defecto.
     */
    public Licencia() {
    }

    /**
     * Constructor que nos permite crear una licencia con los atributos necesarios.
     *
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     * @param fechaTramite Fecha en la que se realizó el trámite.
     * @param costo Costo del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Licencia(Calendar fechaVencimiento, Calendar fechaTramite, Float costo, Persona persona) {
        super(fechaTramite, costo, persona);
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene la fecha de vencimiento de la licencia.
     *
     * @return Fecha de vencimiento de la licencia.
     */
    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento de la licencia.
     *
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     */
    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Calcula y devuelve el valor hash de esta instancia de Licencia.
     *
     * @return El valor hash de esta instancia de Licencia.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaVencimiento != null ? fechaVencimiento.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Licencia con el objeto especificado.
     *
     * @param object El objeto con el que se debe comparar Licencia.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.fechaVencimiento == null && other.fechaVencimiento != null) || (this.fechaVencimiento != null && !this.fechaVencimiento.equals(other.fechaVencimiento))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una cadena que representa a esta instancia de Licencia, mostrando solo el ID.
     *
     * @return Una cadena que representa a esta instancia de Licencia.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Licencia[ id=" + this.getId() + " ]";
    }
    
}
