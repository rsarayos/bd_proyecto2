package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

public interface IGestorVehiculosBO {
    
    public void agregarVehiculo(VehiculoNuevoDTO vehiculoNuevo) throws NegociosException;
    
    public VehiculoNuevoDTO buscarVehiculo(String numPlaca) throws NegociosException;
    
    public List<VehiculoNuevoDTO> obtenerVehiculos(PersonaNuevaDTO persona) throws NegociosException;
    
}
