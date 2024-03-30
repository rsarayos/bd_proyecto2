package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.TramiteDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * La interfaz IGestorTramitesBO define los métodos necesarios para gestionar los trámites realizados por una persona.
 * Permite consultar los trámites de una persona específica.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public interface IGestorTramitesBO {

    /**
     * Permite consultar los trámites realizados por una persona.
     * 
     * @param persona Persona de la cual se buscan los trámites
     * @return Lista de trámites de la persona
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar los trámites.
     */
    public List<TramiteDTO> consultarTramites(PersonaNuevaDTO persona) throws NegociosException; 
    
}
