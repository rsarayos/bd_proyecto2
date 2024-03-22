package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroPersonas;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 *
 * @author victo
 */
public interface IPersonaDAO {

    /**
     * Método que nos permite agregar un grupo de 20 personas nueva
     *
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    public void agregarPersonas() throws PersistenciaException;
    
    public Persona obtenerPersonaRFC(String rfc) throws PersistenciaException;
    
    public List<Persona> buscarPersona(FiltroPersonas filtroPersonas) throws PersistenciaException;

}
