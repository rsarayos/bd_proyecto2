/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alex_
 */
@Entity
@Table(name = "licencia")
public class Licencia extends Tramite {
    
    @Column(name="fecha_vencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaVencimiento;

    public Licencia() {
    }

    public Licencia(Calendar fechaVencimiento, Calendar fechaTramite, Float costo, Persona persona) {
        super(fechaTramite, costo, persona);
        this.fechaVencimiento = fechaVencimiento;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaVencimiento != null ? fechaVencimiento.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Licencia[ id=" + this.getId() + " ]";
    }
    
}
