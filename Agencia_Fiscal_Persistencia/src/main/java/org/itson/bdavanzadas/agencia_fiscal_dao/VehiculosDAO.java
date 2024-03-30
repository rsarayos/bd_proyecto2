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

/**
 * La clase VehiculosDAO implementa la interfaz IVehiculosDAO para proporcionar operaciones CRUD relacionadas con los vehículos.
 * Esta clase se encarga de agregar, obtener y consultar vehículos en la base de datos.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
