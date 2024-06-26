package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa una placa en el sistema. Una placa es un tipo específico
 * de trámite con un número de placa y estado asociados.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
@Entity
@Table(name = "placas")
public class Placa extends Tramite implements Serializable {

    // Número de placa asociado a la placa.
    @Column(name = "numero_placa", length = 7)
    private String numeroPlaca;

    // Fecha en la que se recibió la placa.
    @Column(name = "fecha_recepcion", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    // Vigencia de la placa
    @Column(name = "estado")
    private Boolean estado;
    
    // Persona asociada al vehículo
    @ManyToOne
    @JoinColumn(name = "numero_serie", nullable = false)
    private Vehiculo vehiculo;

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
     * @param vehiculo vehiculo asociado a la placa
     * @param fechaTramite Fecha en la que se realizó el trámite.
     * @param costo Costo del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Placa(String numeroPlaca, Calendar fechaRecepcion, Boolean estado, Vehiculo vehiculo, Calendar fechaTramite, Float costo, Persona persona) {
        super(fechaTramite, costo, persona);
        this.numeroPlaca = numeroPlaca;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.vehiculo = vehiculo;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
     * Devuelve una cadena que representa a esta instancia de Placa, mostrando
     * solo el número de placa.
     *
     * @return Una cadena que representa a esta instancia de Placa.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa{");
        sb.append("numeroPlaca=").append(numeroPlaca);
        sb.append(", fechaRecepcion=").append(fechaRecepcion);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

}
