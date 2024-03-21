package org.itson.bdavanzadas.agencia_fiscal_dao;

import javax.persistence.EntityManager;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;

public class LicenciaDAO implements ILicenciaDAO{

    private final IConexion conexion;
    
    public LicenciaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que permite agregar una licencia
     *
     * @param licenciaNueva Objeto licencia a agregar
     * @return Objeto licencia agregado
     */
    @Override
    public Licencia agregarLicencia(Licencia licenciaNueva) {
        EntityManager entityManager = conexion.crearConexion();
        //Iniciamos la transaccion nueva.
        entityManager.getTransaction().begin();

        entityManager.persist(licenciaNueva);
        entityManager.getTransaction().commit();
        entityManager.close();

        return licenciaNueva;
    }

}
