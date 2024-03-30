package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;

/**
 * La interfaz IConexion define el contrato para crear una conexión EntityManager.
 * Esta interfaz se utiliza para establecer una conexión con una base de datos utilizando JPA (Java Persistence API).
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public interface IConexion {
    
    /**
     * Permite crear la conexión con FactoryEntityManager.
     *
     * @return EntityManager con la conexión
     */
    public EntityManager crearConexion();
    
}
