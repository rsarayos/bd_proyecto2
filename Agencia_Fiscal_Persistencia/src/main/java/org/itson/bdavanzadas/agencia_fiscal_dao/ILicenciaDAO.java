
package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public interface ILicenciaDAO {
    
    /**
     * Método que permite agregar una licencia
     *
     * @param licenciaNueva Objeto licencia a agregar
     * @return Objeto licencia agregado
     */
    public Licencia agregarLicencia(Licencia licenciaNueva) throws PersistenciaException;
    
    public List<Licencia> obtenerLicencias(Persona persona) throws PersistenciaException;
    
    public Licencia obtenerLicencia(Long id) throws PersistenciaException;
    
    public Licencia modificarVigencia(Licencia licencia) throws PersistenciaException;
    
}
