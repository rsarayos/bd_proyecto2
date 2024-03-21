package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * Interfaz que define las operaciones de negocio para el registro y gestión de licencias.
 */
public interface IRegistroLicenciaBO {
    
    /**
     * Método para registrar una nueva licencia.
     *
     * @param licenciaNueva Objeto de tipo LicenciaNuevaDTO que contiene los datos de la nueva licencia.
     * @return El objeto de tipo Licencia que ha sido registrado.
     * @throws NegociosException Si ocurre un error durante el proceso de registro de la licencia.
     */
    public Licencia registrarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException;
    
    /**
     * Método para obtener todas las licencias asociadas a una persona.
     *
     * @param personaNueva Objeto de tipo PersonaNuevaDTO para el cual se desean obtener las licencias.
     * @return Una lista de objetos de tipo Licencia asociados a la persona.
     * @throws NegociosException Si ocurre un error durante la obtención de las licencias.
     */
    public List<Licencia> obtenerLicencias(PersonaNuevaDTO personaNueva) throws NegociosException;
    
    /**
     * Método para obtener una licencia por su identificador único.
     *
     * @param id Identificador único de la licencia.
     * @return El objeto de tipo Licencia correspondiente al identificador proporcionado.
     * @throws NegociosException Si ocurre un error durante la obtención de la licencia.
     */
    public Licencia obtenerLicencia(Long id) throws NegociosException;
    
    /**
     * Método para modificar la vigencia de una licencia.
     *
     * @param id Identificador único de la licencia cuya vigencia se desea modificar.
     * @return El objeto de tipo Licencia con su vigencia modificada.
     * @throws NegociosException Si ocurre un error durante la modificación de la vigencia de la licencia.
     */
    public Licencia modificarVigencia(Long id) throws NegociosException;
    
}
