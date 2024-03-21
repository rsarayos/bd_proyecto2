package org.itson.bdavanzadas.agencia_fiscal_dao;

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
}
