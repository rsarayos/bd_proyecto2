package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * Interfaz que define las operaciones de negocio para el registro y gestión de licencias.
 */
public interface IRegistroLicenciaBO {
    
    /**
     * Método para registrar una nueva licencia.
     *
     * @param licenciaNueva Objeto de tipo LicenciaNuevaDTO que contiene los datos de la nueva licencia.
     * @return El objeto de tipo LicenciaNuevaDTO que ha sido registrado.
     * @throws NegociosException Si ocurre un error durante el proceso de registro de la licencia.
     */
    public LicenciaNuevaDTO registrarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException;
    
    /**
     * Método para obtener todas las licencias asociadas a una persona.
     *
     * @param personaNueva Objeto de tipo PersonaNuevaDTO para el cual se desean obtener las licencias.
     * @return Una lista de objetos de tipo LicenciaNuevaDTO asociados a la persona.
     * @throws NegociosException Si ocurre un error durante la obtención de las licencias.
     */
    public List<LicenciaNuevaDTO> obtenerLicencias(PersonaNuevaDTO personaNueva) throws NegociosException;
    
    /**
     * Método para obtener una licencia por su identificador único.
     *
     * @param licenciaNueva Identificador único de la licencia.
     * @return El objeto de tipo LicenciaNuevaDTO correspondiente al identificador proporcionado.
     * @throws NegociosException Si ocurre un error durante la obtención de la licencia.
     */
    public LicenciaNuevaDTO obtenerLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException;
    
    public LicenciaNuevaDTO tramitarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException;
    
}
