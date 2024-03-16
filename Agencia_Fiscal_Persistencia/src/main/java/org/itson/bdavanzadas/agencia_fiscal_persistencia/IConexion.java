
package org.itson.bdavanzadas.agencia_fiscal_persistencia;

import javax.persistence.EntityManager;

/**
 *
 * @author victo
 */
public interface IConexion {
    
    /**
     * Permite crear la conexión con FactoryEntityManager.
     *
     * @return EntityManager con la conexión.
     */
    public EntityManager crearConexion();
}
