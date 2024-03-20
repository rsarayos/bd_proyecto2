package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;

public interface IConexion {
    
    /**
     * Permite crear la conexión con FactoryEntityManager.
     *
     * @return EntityManager con la conexión.
     */
    public EntityManager crearConexion();
    
}
