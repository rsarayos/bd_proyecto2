package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public interface IRegistroPlacaBO {
    
    public PlacaNuevaDTO tramitarPlaca(PlacaNuevaDTO placaNueva) throws NegociosException;
    public PlacaNuevaDTO buscarPlaca(String numPlaca) throws NegociosException;
    public List<PlacaNuevaDTO> buscarPlacasVehiculo(VehiculoNuevoDTO vehiculo) throws NegociosException;
    
}
