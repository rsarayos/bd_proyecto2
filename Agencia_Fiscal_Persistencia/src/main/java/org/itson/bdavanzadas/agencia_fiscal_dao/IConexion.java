/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dao;

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
