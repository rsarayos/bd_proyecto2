/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.bdavanzadas.agencia_fiscal_dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alex_
 */
public class Agencia_Fiscal_Dominio {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("fiscalPU");
        // solicitamos una entity manager (acceso a la bd)
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Persona persona = new Persona("Alex");
        entityManager.persist(persona);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
}
