package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Automovil;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public class AutomovilesDAO implements IAutomovilesDAO {
    
    private IConexion conexion;
    static final Logger logger = Logger.getLogger(AutomovilesDAO.class.getName());
    
    public AutomovilesDAO(IConexion conexion){
        this.conexion = conexion;
    }

    @Override
    public void agregarAutomovil(Automovil automovilNuevo) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(automovilNuevo);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó el vehiculo correctamente");
        } catch (Exception e){
            throw new PersistenciaException("No se pudo registrar el vehículo.");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Automovil> consultarAutomoviles(Persona persona) throws PersistenciaException{
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
            Root<Automovil> root = criteria.from(Automovil.class);
            criteria.select(root).where(
                    builder.and(
                            builder.equal(root.type(), Automovil.class),
                            builder.like(root.get("persona").get("rfc"), persona.getRfc())
                    )
            );
            TypedQuery<Automovil> query = entityManager.createQuery(criteria);
            List<Automovil> vehiculos = query.getResultList();
            return vehiculos;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudieron consultar los vehiculos", e);
            throw new PersistenciaException("No se pudieron consultar los vehículos");
        } finally {
            entityManager.close();
        }
    }

}
