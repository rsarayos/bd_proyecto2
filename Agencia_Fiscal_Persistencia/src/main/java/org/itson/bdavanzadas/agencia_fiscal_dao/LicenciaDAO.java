package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public class LicenciaDAO implements ILicenciaDAO {

    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(LicenciaDAO.class.getName());

    public LicenciaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que permite agregar una licencia
     *
     * @param licenciaNueva Objeto licencia a agregar
     * @return Objeto licencia agregado
     * @throws PersistenciaException
     */
    @Override
    public Licencia agregarLicencia(Licencia licenciaNueva) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            //Iniciamos la transaccion nueva.
            entityManager.getTransaction().begin();
            entityManager.persist(licenciaNueva);
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó la licencia correctamente");
            return licenciaNueva;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se puedo agregar la licencia", e);
            throw new PersistenciaException("Error al agregar la licencia", e);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Licencia> obtenerLicencia(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
            Root<Licencia> root = criteria.from(Licencia.class);
            criteria.select(root).where(
                    builder.and(
                            builder.equal(root.type(), Licencia.class),
                            builder.like(root.get("persona").get("rfc"), persona.getRfc())
                    )
            );
            TypedQuery<Licencia> query = entityManager.createQuery(criteria);
            List<Licencia> licencias = query.getResultList();
            return licencias;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se puedo agregar la licencia", e);
            throw new PersistenciaException("Error al agregar la licencia", e);
        } finally {
            entityManager.close();
        }
    }

}
