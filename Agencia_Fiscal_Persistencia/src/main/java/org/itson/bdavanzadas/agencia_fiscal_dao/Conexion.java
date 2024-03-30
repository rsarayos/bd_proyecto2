package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * La clase Conexion implementa la interfaz IConexion para proporcionar una conexión EntityManager.
 * Esta clase se utiliza para establecer una conexión con una base de datos utilizando JPA (Java Persistence API).
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class Conexion implements IConexion{

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityManager crearConexion() {
        //Obtenemos acceso a la fábrica de entityManager
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("fiscalPU");
        //Solicitamos una entityManager.
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
