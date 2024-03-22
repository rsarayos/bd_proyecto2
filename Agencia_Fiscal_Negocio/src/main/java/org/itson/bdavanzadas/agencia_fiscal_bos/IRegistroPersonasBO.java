

package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroPersonasDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author victo
 */
public interface IRegistroPersonasBO {
    
    /**
     * Permite agregar personas utilizando un objeto de acceso a datos de
     * persona.
     *
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * agregar una persona.
     */
    public void agregarPersonas() throws NegociosException;
    
    /**
     * Método que nos permite consultar las personas según el filtro enviado.
     *
     * @param filtroPersonas Parámetros que ayudarán al filtrado de las
     * personas.
     * @return Una lista de personas con los filtros aplicados.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * consultar a las personas.
     */
    public List<PersonaNuevaDTO> consultarPersonas(FiltroPersonasDTO filtroPersonas) throws NegociosException; 
}
