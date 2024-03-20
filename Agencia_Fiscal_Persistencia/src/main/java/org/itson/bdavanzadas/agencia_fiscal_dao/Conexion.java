/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alex_
 */
public class Conexion implements IConexion{

    @Override
    public EntityManager crearConexion() {
        //Obtenemos acceso a la fábrica de entityManager
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("fiscalPU");
        //Solicitamos una entityManager
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
