package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * La interfaz IRegistroPlacaBO define los métodos necesarios para gestionar el registro de placas.
 * Permite tramitar, buscar y consultar placas.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public interface IRegistroPlacaBO {
    
    /**
     * Permite tramitar una placa nueva.
     *
     * @param placaNueva Datos de la placa nueva
     * @return Placa agregada.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * tramitar la placa.
     */
    public PlacaNuevaDTO tramitarPlaca(PlacaNuevaDTO placaNueva) throws NegociosException;
    
    /**
     * Permite buscar una placa según el número de placa proporcionado.
     *
     * @param numPlaca Número de placa que permite buscar la placa.
     * @return Placa buscada.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar la placa.
     */
    public PlacaNuevaDTO buscarPlaca(String numPlaca) throws NegociosException;
    
    /**
     * Permite buscar una lista de placas que tiene el vehículo proporcionado.
     *
     * @param vehiculoN Vehículo del cual se buscarán las placas.
     * @return Lista de placas del vehículo.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar la lista de placas.
     */
    public List<PlacaNuevaDTO> buscarPlacasVehiculo(VehiculoNuevoDTO vehiculoN) throws NegociosException;
    
}
