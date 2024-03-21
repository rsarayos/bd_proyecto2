package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
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

}
