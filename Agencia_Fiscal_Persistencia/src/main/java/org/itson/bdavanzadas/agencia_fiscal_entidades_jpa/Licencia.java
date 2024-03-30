package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa una licencia en el sistema. Una licencia es un tipo
 * específico de trámite con una fecha de vencimiento adicional.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
@Entity
@Table(name = "licencias")
public class Licencia extends Tramite implements Serializable {

    // Fecha de vencimiento de la licencia
    @Column(name = "fecha_vencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaVencimiento;
    
    // Vigencia de la licencia
    @Column(name = "estado")
    private Boolean estado;

    /**
     * Constructor por defecto.
     */
    public Licencia() {
    }

    /**
     * Constructor que nos permite crear una licencia con los atributos
     * necesarios.
     *
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     * @param fechaTramite Fecha en la que se realizó el trámite.
     * @param costo Costo del trámite.
     * @param persona Persona asociada al trámite.
     * @param estado vigencia de la licencia
     */
    public Licencia(Calendar fechaVencimiento, Calendar fechaTramite, Float costo, Persona persona, Boolean estado) {
        super(fechaTramite, costo, persona);
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
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
     * Obtiene el estado de la licencia.
     *
     * @return estado de la licencia.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la licencia.
     *
     * @param estado Estado de la licencia.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
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
     * Devuelve una cadena que representa a esta instancia de Licencia,
     * mostrando solo el ID.
     *
     * @return Una cadena que representa a esta instancia de Licencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Licencia{");
        sb.append("fechaVencimiento=").append(fechaVencimiento);
        sb.append('}');
        return sb.toString();
    }

}
