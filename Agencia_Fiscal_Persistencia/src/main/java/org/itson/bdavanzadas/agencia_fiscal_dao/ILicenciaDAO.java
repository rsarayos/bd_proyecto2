
package org.itson.bdavanzadas.agencia_fiscal_dao;

import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;

public interface ILicenciaDAO {
    
    /**
     * Método que permite agregar una licencia
     *
     * @param licenciaNueva Objeto licencia a agregar
     * @return Objeto licencia agregado
     */
    public Licencia agregarLicencia(Licencia licenciaNueva);
    
}
