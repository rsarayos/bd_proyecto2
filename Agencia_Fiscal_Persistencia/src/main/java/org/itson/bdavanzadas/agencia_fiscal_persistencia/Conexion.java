
package org.itson.bdavanzadas.agencia_fiscal_persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victo
 */
public class Conexion implements IConexion{
    
    /**
     * Permite crear la conexión con FactoryEntityManager.
     *
     * @return EntityManager con la conexión.
     */
    @Override
    public EntityManager crearConexion() {
        //Obtenemos acceso a la fábrica de entityManager
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("fiscalPU");
        //Solicitamos una entityManager
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
