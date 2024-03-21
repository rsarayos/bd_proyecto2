package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion implements IConexion{

    @Override
    public EntityManager crearConexion() {
        //Obtenemos acceso a la fábrica de entityManager
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("fiscalPU");
        //Solicitamos una entityManager.
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
