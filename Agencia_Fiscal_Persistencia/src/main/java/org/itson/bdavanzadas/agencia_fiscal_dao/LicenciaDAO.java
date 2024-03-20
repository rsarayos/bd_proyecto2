/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;

/**
 *
 * @author alex_
 */
public class LicenciaDAO implements ILicenciaDAO{

    private final IConexion conexion;

    public LicenciaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Licencia agregarLicencia(LicenciaNuevaDTO licenciaNueva) {
        EntityManager entityManager = conexion.crearConexion();
        //Iniciamos la transaccion nueva
        entityManager.getTransaction().begin();

        Licencia licencia = new Licencia(
                licenciaNueva.getFechaVencimiento(), 
                licenciaNueva.getFechaTramite(), 
                licenciaNueva.getCosto(), 
                licenciaNueva.getPersona());
        
        entityManager.persist(licencia);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return licencia;
    }
    
}
