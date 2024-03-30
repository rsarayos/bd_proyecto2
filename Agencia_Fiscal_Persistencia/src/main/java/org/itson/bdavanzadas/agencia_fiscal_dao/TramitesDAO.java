package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.exceptions.QueryException;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroReportes;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 * La clase TramitesDAO implementa la interfaz ITramitesDAO para proporcionar operaciones de consulta relacionadas con los trámites.
 * Esta clase se encarga de consultar trámites realizados por una persona y trámites filtrados.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
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
     * {@inheritDoc}
     */
    @Override
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Tramite> consultarTramites(FiltroReportes filtro) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        String jpqlQuery = """
                  SELECT t
                  FROM Tramite t
                  INNER JOIN t.persona p
                  WHERE (:nombre IS NULL OR CONCAT(p.nombres , ' ', p.apellidoPaterno, ' ', p.apellidoMaterno) LIKE :nombre)
                  AND (:fecha_inicial IS NULL AND :fecha_final IS NULL OR t.fechaTramite BETWEEN :fecha_inicial AND :fecha_final)
                  """;
        try {
            TypedQuery<Tramite> query = entityManager.createQuery(jpqlQuery, Tramite.class);

            if (filtro.getNombreContribuyente()!= null) {
                query.setParameter("nombre", "%" + filtro.getNombreContribuyente() + "%");
            } else {
                query.setParameter("nombre", null);
            }
            
            if (filtro.getFechaInicial() != null && filtro.getFechaFinal() != null) {
                query.setParameter("fecha_inicial", filtro.getFechaInicial());
                query.setParameter("fecha_final", filtro.getFechaFinal());
            } else {
                query.setParameter("fecha_inicial", null);
                query.setParameter("fecha_final", null);
            }

            List<Tramite> tramites = query.getResultList();

            return tramites;
        } catch (QueryException e) {
            Logger.getLogger(TramitesDAO.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar los trámites.", e);
            throw new PersistenciaException("No se pudieron consultar los trámites.", e);
        } finally {
            entityManager.close();
        }
    }

}
