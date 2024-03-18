/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alex_
 */
@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    @Id
    @Column(name = "numero_serie", length = 17)
    private String numeroSerie;
    
    @Column(name = "color", nullable = false, length = 30)
    private String color;
    
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
    
    @Column(name = "linea", nullable = false, length = 50)
    private String linea;
    
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;
    
    @Column(name = "estado", nullable = false)
    private Boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "rfc_persona", nullable = false)
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie, String color, String modelo, String linea, String marca, Boolean estado, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.estado = estado;
        this.persona = persona;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        hash += (numeroSerie != null ? numeroSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.numeroSerie == null && other.numeroSerie != null) || (this.numeroSerie != null && !this.numeroSerie.equals(other.numeroSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itson.bdavanzadas.agencia_fiscal_dominio.Vehiculo[ id=" + numeroSerie + " ]";
    }
    
}
