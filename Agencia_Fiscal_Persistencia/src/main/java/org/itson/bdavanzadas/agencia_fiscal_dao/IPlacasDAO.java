package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 * La interfaz IPlacasDAO define el contrato para las operaciones CRUD relacionadas con las placas de vehículos.
 * Proporciona métodos para agregar, obtener y modificar placas en la base de datos.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public interface IPlacasDAO {
    
    /**
     * Agrega una nueva placa a la base de datos.
     *
     * @param placa la placa a agregar.
     * @return la placa agregada.
     * @throws PersistenciaException si ocurre un error al interactuar con la base de datos.
     */
    public Placa agregarPlaca(Placa placa) throws PersistenciaException;
    
    /**
     * Obtiene todas las placas asociadas a un vehículo específico.
     *
     * @param vehiculo el vehículo del cual se desean obtener las placas.
     * @return una lista de placas asociadas al vehículo.
     * @throws PersistenciaException si ocurre un error al interactuar con la base de datos.
     */
    public List<Placa> obtenerPlacasVehiculo(Vehiculo vehiculo) throws PersistenciaException;
    
    /**
     * Obtiene una placa específica por su número de placa.
     *
     * @param numPlaca el número de placa de la placa a buscar.
     * @return la placa encontrada.
     * @throws PersistenciaException si ocurre un error al interactuar con la base de datos.
     */
    public Placa obtenerPlaca(String numPlaca) throws PersistenciaException;
    
    /**
     * Obtiene la placa activa asociada a un vehículo específico.
     *
     * @param vehiculo el vehículo del cual se desea obtener la placa activa.
     * @return la placa activa del vehículo.
     * @throws PersistenciaException si ocurre un error al interactuar con la base de datos.
     */
    public Placa obtenerPlacaActiva(Vehiculo vehiculo) throws PersistenciaException;
    
    /**
     * Modifica la vigencia de una placa específica.
     *
     * @param placa la placa cuya vigencia se desea modificar.
     * @return la placa con la vigencia modificada.
     * @throws PersistenciaException si ocurre un error al interactuar con la base de datos.
     */
    public Placa modificarVigencia(Placa placa) throws PersistenciaException;
    
}
