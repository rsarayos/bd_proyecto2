package org.itson.bdavanzadas.agencia_fiscal_bos;

import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public interface IRegistroPlacaBO {
    
    public PlacaNuevaDTO tramitarPlaca(PlacaNuevaDTO placaNueva) throws NegociosException;
    
}
