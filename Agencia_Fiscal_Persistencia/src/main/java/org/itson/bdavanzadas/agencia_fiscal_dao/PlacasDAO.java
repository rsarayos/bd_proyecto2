package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public class PlacasDAO implements IPlacasDAO {
    
    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(PlacasDAO.class.getName());

    public PlacasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Placa agregarPlaca(Placa placa) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            //Iniciamos la transaccion nueva.
            entityManager.getTransaction().begin();
            entityManager.persist(placa);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó la placa correctamente");
            return placa;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se puedo agregar la placa", e);
            throw new PersistenciaException("Error al agregar la placa", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Placa> obtenerPlacasVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);
            Join<Placa, Vehiculo> vehiculoJoin = root.join("vehiculo");

            criteria.select(root).where(
                    builder.and(
                            builder.equal(vehiculoJoin.get("numeroSerie"), vehiculo.getNumeroSerie())
                    )
            );

            TypedQuery<Placa> query = entityManager.createQuery(criteria);
            List<Placa> placas = query.getResultList();
            return placas;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo consultar las placas", e);
            throw new PersistenciaException("Error al consultar las placas", e);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public Placa obtenerPlaca(String numPlaca) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);

            criteria.select(root).where(
                    builder.equal(root.get("numeroPlaca"), numPlaca)
            );

            TypedQuery<Placa> query = entityManager.createQuery(criteria);
            Placa placa = query.getSingleResult();
            return placa;
        } catch (NoResultException e) {
            logger.log(Level.INFO, "No se encontró la placa con el número");
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo consultar la placa", e);
            throw new PersistenciaException("Error al consultar la placa", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Placa obtenerPlacaActiva(Vehiculo vehiculo) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Placa> cq = cb.createQuery(Placa.class);

            Root<Placa> placaRoot = cq.from(Placa.class);
            Join<Placa, Vehiculo> vehiculoJoin = placaRoot.join("vehiculo");

            cq.select(placaRoot).where(
                            cb.and(
                                    cb.equal(vehiculoJoin.get("numeroSerie"), vehiculo.getNumeroSerie()),
                                    cb.isTrue(placaRoot.get("estado"))
                            )
                    );

            Placa placa = entityManager.createQuery(cq).getSingleResult();

            return placa;
        } catch (NoResultException e) {
            logger.log(Level.INFO, "No se encontró ninguna placa activa para el vehículo");
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener la placa activa", e);
            throw new PersistenciaException("Error al obtener la placa activa", e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Placa modificarVigencia(Placa placa) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            entityManager.getTransaction().begin();

            // Obtener la fecha actual
            Calendar fechaActual = Calendar.getInstance();

            String jpqlUpdate = "UPDATE Placa p SET p.estado = :estado, p.fechaRecepcion = :fecha WHERE p.numeroPlaca = :numPlaca";
            Query queryUpdate = entityManager.createQuery(jpqlUpdate);
            queryUpdate.setParameter("estado", false);
            queryUpdate.setParameter("fecha", fechaActual);
            queryUpdate.setParameter("numPlaca", placa.getNumeroPlaca());

            int updatedCount = queryUpdate.executeUpdate();
            if (updatedCount > 0) {
                String jpqlSelect = "SELECT p FROM Placa p WHERE p.numeroPlaca = :numPlaca";
                Query querySelect = entityManager.createQuery(jpqlSelect);
                querySelect.setParameter("numPlaca", placa.getNumeroPlaca());
                List<Placa> placasModificadas = querySelect.getResultList();
                entityManager.getTransaction().commit();
                logger.log(Level.INFO, "Se modificó el estado y la fecha de recepción de la Placa");
                return placasModificadas.get(0);
            } else {
                logger.log(Level.INFO, "No se modificó ninguna placa");
                return null;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudo modificar las placas", e);
            throw new PersistenciaException("Error al modificar las placas", e);
        } finally {
            entityManager.close();
        }
    }

}
