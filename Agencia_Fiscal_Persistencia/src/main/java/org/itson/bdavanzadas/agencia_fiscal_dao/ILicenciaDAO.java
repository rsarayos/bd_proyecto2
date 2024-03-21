
package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones para acceder y manipular datos de licencias en la base de datos.
 */
public interface ILicenciaDAO {
    
    /**
     * Método que permite agregar una licencia a la base de datos.
     *
     * @param licenciaNueva Objeto de tipo Licencia a agregar.
     * @return El objeto de tipo Licencia que ha sido agregado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia de la licencia.
     */
    public Licencia agregarLicencia(Licencia licenciaNueva) throws PersistenciaException;
    
    /**
     * Método que obtiene todas las licencias asociadas a una persona.
     *
     * @param persona Objeto de tipo Persona para el cual se desean obtener las licencias.
     * @return Una lista de objetos de tipo Licencia asociados a la persona.
     * @throws PersistenciaException Si ocurre un error durante la obtención de las licencias.
     */
    public List<Licencia> obtenerLicencias(Persona persona) throws PersistenciaException;
    
    /**
     * Método que obtiene una licencia por su identificador único.
     *
     * @param id Identificador único de la licencia.
     * @return El objeto de tipo Licencia correspondiente al identificador proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la obtención de la licencia.
     */
    public Licencia obtenerLicencia(Long id) throws PersistenciaException;
    
    /**
     * Método que modifica la vigencia de una licencia.
     *
     * @param id Identificador único de la licencia cuya vigencia se desea modificar.
     * @return El objeto de tipo Licencia con su vigencia modificada.
     * @throws PersistenciaException Si ocurre un error durante la modificación de la vigencia de la licencia.
     */
    public Licencia modificarVigencia(Long id) throws PersistenciaException;
    
}
