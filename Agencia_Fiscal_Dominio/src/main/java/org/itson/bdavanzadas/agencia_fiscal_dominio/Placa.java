/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "placa")
public class Placa extends Tramite {

    @Column(name = "numero_placa")
    private String numeroPlaca;
    
    @Column(name="fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;
    
    @Column(name = "estado")
    private Boolean estado;

    public Placa() {
    }

    public Placa(String numeroPlaca, Calendar fechaRecepcion, Boolean estado, Calendar fechaTramite, Float costo, Persona persona) {
        super(fechaTramite, costo, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
    }
    
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPlaca != null ? numeroPlaca.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Placa[ id=" + numeroPlaca + " ]";
    }
    
}
