package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public interface IVehiculosDAO {

    /**
     * Permite agregar un vehiculo nuevo al sistema.
     *
     * @param vehiculoNuevo El vehiculo a agregar
     * @throws PersistenciaException Si no se puede agregar el vehículo
     */
    public void agregarVehiculo(Vehiculo vehiculoNuevo) throws PersistenciaException;

    /**
     * Permite buscar un vehículo por su número de serie.
     * 
     * @param numSerie Número de serie del vehículo a buscar
     * @return Vehículo buscado
     * @throws PersistenciaException Si no se puede consultar el vehículo
     */
    public Vehiculo obtenerVehiculo(String numSerie)throws PersistenciaException;
    
    /**
     * Permite consultar los vehículos de una persona.
     *
     * @param persona La persona de la que se desean consultar los vehículos
     * @return Una lista con los vehículos de la persona
     * @throws PersistenciaException Si no se pueden consultar los vehículos
     */
    public List<Vehiculo> consultarVehiculos(Persona persona) throws PersistenciaException;

}
