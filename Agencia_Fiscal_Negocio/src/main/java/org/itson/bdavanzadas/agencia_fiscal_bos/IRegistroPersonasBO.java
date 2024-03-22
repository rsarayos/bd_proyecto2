

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
    
    public void agregarPersonas() throws NegociosException;
    
    public List<PersonaNuevaDTO> consultarPersonas(FiltroPersonasDTO filtroPersonas) throws NegociosException; 
}
