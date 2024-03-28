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
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public class TramitesDAO implements ITramitesDAO {
    
    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(TramitesDAO.class.getName());
    
    /**
     * Constructor que recibe una conexión al sistema de persistencia.
     *
     * @param conexion La conexión al sistema de persistencia
     */
    public TramitesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Permite consultar todos los trámites realizados por una persona,
     *
     * @param persona La persona de la cual se desean consultar los trámites
     * @return Una lista con los trámites que ha realizado la persona
     * @throws PersistenciaException Si no se pueden consultar los trámites
     */
    @Override
    public List<Tramite> consultarTramites(Persona persona) throws PersistenciaException{
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            criteria.select(root).where(builder.equal(root.get("persona").get("rfc"), persona.getRfc()));
            TypedQuery<Tramite> query = entityManager.createQuery(criteria);
            
            List<Tramite> tramites = query.getResultList();

            return tramites;
        } catch (Exception e) {
            Logger.getLogger(TramitesDAO.class.getName()).log(Level.SEVERE, "Sabe qué pasó lol.");
            throw new PersistenciaException("No se pudieron consultar los trámites.");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Tramite> consultarTodosLosTramites() throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            criteria.select(root);

            TypedQuery<Tramite> query = entityManager.createQuery(criteria);

            List<Tramite> tramites = query.getResultList();

            return tramites;
        } catch (Exception e) {
            Logger.getLogger(TramitesDAO.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar los trámites.", e);
            throw new PersistenciaException("No se pudieron consultar los trámites.", e);
        } finally {
            entityManager.close();
        }
    }

}
