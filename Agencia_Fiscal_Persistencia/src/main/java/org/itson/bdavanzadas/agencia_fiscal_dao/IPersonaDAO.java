package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroPersonas;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 * Interfaz que define las operaciones para acceder a los datos de
 * personas en la base de datos.
 */
public interface IPersonaDAO {

    /**
     * Método que nos permite agregar un grupo de 20 personas nueva
     *
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    public void agregarPersonas() throws PersistenciaException;

    /**
     * Método que permite buscar un persona según su RFC. 
     * 
     * @param rfc RFC de la persona a buscar.
     * @return Objeto persona con todos sus atributos.
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    public Persona obtenerPersonaRFC(String rfc) throws PersistenciaException;

    /**
     * Método que nos permite buscar un lista de personas que cumplan con el
     * filtro dato en el parámetro.
     *
     * @param filtroPersonas Filtro con los atributos por los que será buscado.
     * @return Una lista de persona que cumplan con los parámetros del filtro.
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    public List<Persona> buscarPersona(FiltroPersonas filtroPersonas) throws PersistenciaException;

}
