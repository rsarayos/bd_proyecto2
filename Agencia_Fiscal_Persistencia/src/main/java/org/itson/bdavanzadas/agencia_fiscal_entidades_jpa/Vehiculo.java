package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa un vehículo en el sistema. Un vehículo puede ser
 * asociado a una persona y tiene atributos como número de serie, color, modelo,
 * línea y marca.
 */
@Entity
@Table(name = "vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_vehiculo", discriminatorType = DiscriminatorType.STRING)
public class Vehiculo implements Serializable {

    // Número de serie del vehículo.
    @Id
    @Column(name = "numero_serie", length = 17)
    protected String numeroSerie;

    // Color del vehículo.
    @Column(name = "color", nullable = false, length = 30)
    protected String color;

    // Modelo del vehículo.
    @Column(name = "modelo", nullable = false, length = 50)
    protected String modelo;

    // Línea del vehículo.
    @Column(name = "linea", nullable = false, length = 50)
    protected String linea;

    // Marca del vehículo.
    @Column(name = "marca", nullable = false, length = 50)
    protected String marca;

    // Persona asociada al vehículo
    @ManyToOne
    @JoinColumn(name = "rfc_persona", nullable = false)
    protected Persona persona;

    // Lista de tramites relacionados a la persona
    @OneToMany(mappedBy = "vehiculo")
    protected List<Placa> placas;

    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Constructor que nos permite crear un vehículo con los atributos
     * necesarios.
     *
     * @param numeroSerie Número de serie del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param linea Línea del vehículo.
     * @param marca Marca del vehículo.
     * @param persona Persona asociada al vehículo.
     */
    public Vehiculo(String numeroSerie, String color, String modelo, String linea, String marca, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
        this.persona = persona;
    }

    /**
     * Obtiene el número de serie del vehículo.
     *
     * @return Número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param numeroSerie Número de serie del vehículo.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene el color del vehículo.
     *
     * @return Color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color Color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return Modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param modelo Modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la línea del vehículo.
     *
     * @return Línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     *
     * @param linea Línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene la marca del vehículo.
     *
     * @return Marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca Marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Permite obtener la persona a la que pertenece el vehículo.
     *
     * @return La persona a la que pertenece el vehículo
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Permite establecer la persona a la que pertenece el vehículo.
     *
     * @param persona La persona a la que pertenece el vehículo
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Permite obtener la lista de placas del vehículo.
     *
     * @return La lista de placas del vehículo
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Permite establecer la lista de placas del vehículo.
     *
     * @param placas La lista de placas del vehículo
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Calcula y devuelve el valor hash de esta instancia de Vehiculo.
     *
     * @return El valor hash de esta instancia de Vehiculo.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSerie != null ? numeroSerie.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Vehiculo con el objeto especificado.
     *
     * @param object El objeto con el que se debe comparar Vehiculo.
     * @return true si los objetos son iguales, false en caso contrario.
     */
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

    /**
     * Devuelve una cadena que representa a esta instancia de Vehiculo,
     * mostrando solo el número de serie.
     *
     * @return Una cadena que representa a esta instancia de Vehiculo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{");
        sb.append("numeroSerie=").append(numeroSerie);
        sb.append(", color=").append(color);
        sb.append(", modelo=").append(modelo);
        sb.append(", linea=").append(linea);
        sb.append(", marca=").append(marca);
        sb.append(", persona=").append(persona);
        sb.append('}');
        return sb.toString();
    }

}
