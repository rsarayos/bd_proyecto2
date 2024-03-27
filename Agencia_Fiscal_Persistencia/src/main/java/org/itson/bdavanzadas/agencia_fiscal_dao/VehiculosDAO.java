package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public class VehiculosDAO implements IVehiculosDAO {

    private IConexion conexion;
    static final Logger logger = Logger.getLogger(VehiculosDAO.class.getName());

    /**
     * Constructor que recibe una conexión al sistema de persistencia.
     *
     * @param conexion La conexión al sistema de persistencia
     */
    public VehiculosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Permite agregar un vehiculo nuevo al sistema.
     *
     * @param vehiculoNuevo El vehiculo a agregar
     * @throws PersistenciaException Si no se puede agregar el vehículo
     */
    @Override
    public void agregarVehiculo(Vehiculo vehiculoNuevo) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vehiculoNuevo);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó el vehiculo correctamente");
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo registrar el vehículo.");
        } finally {
            entityManager.close();
        }
    }

    /**
     * Permite buscar un vehículo por su número de serie.
     * 
     * @param numSerie Número de serie del vehículo a buscar
     * @return Vehículo buscado
     * @throws PersistenciaException Si no se puede consultar el vehículo
     */
    @Override
    public Vehiculo obtenerVehiculo(String numSerie) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        try {
            entityManager.getTransaction().begin();
            Vehiculo vehiculo = entityManager.find(Vehiculo.class, numSerie);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se buscó el vehiculo correctamente");
            return vehiculo;
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No se pudo buscar el vehículo.");
        } finally {
            entityManager.close();
        }
        
    }

    /**
     * Permite consultar los vehículos de una persona.
     *
     * @param persona La persona de la que se desean consultar los vehículos
     * @return Una lista con los vehículos de la persona
     * @throws PersistenciaException Si no se pueden consultar los vehículos
     */
    @Override
    public List<Vehiculo> consultarVehiculos(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
            Root<Vehiculo> root = criteria.from(Vehiculo.class);
            criteria.select(root).where(builder.and(builder.like(root.get("persona").get("rfc"), persona.getRfc())));
            TypedQuery<Vehiculo> query = entityManager.createQuery(criteria);
            List<Vehiculo> vehiculos = query.getResultList();
            return vehiculos;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudieron consultar los vehiculos", e);
            throw new PersistenciaException("No se pudieron consultar los vehículos");
        } finally {
            entityManager.close();
        }
    }

}
