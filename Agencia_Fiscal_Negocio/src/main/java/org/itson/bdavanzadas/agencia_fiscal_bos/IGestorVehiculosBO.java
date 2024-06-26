package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * La interfaz IGestorVehiculosBO define los métodos necesarios para gestionar los vehículos.
 * Permite agregar, buscar y obtener vehículos.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public interface IGestorVehiculosBO {

    /**
     * Permite agregar un vehículo nuevo.
     *
     * @param vehiculoNuevo Vehículo a agregar.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * agregar el vehículo.
     */
    public void agregarVehiculo(VehiculoNuevoDTO vehiculoNuevo) throws NegociosException;

    /**
     * Permite obtener un vehículo según el número de placa proporcionado.
     *
     * @param numPlaca Número de placa que será buscado.
     * @return Vehículo buscado según el número de placa.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar el vehículo.
     */
    public VehiculoNuevoDTO buscarVehiculo(String numPlaca) throws NegociosException;
    
    /**
     * Permite obtener un vehículo según el número de serie proporcionado.
     *
     * @param numSerie Número de serie que será buscado.
     * @return Vehículo buscado según el número de placa o null si no se encuentra.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar el vehículo.
     */
    public VehiculoNuevoDTO buscarVehiculoNS(String numSerie) throws NegociosException;

    /**
     * Permite obtener una lista de vehículos según la persona proporcionada.
     *
     * @param persona Persona con la que se buscarán los vehículos.
     * @return Lista de vehículos buscados según la persona.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar la lista de vehículos.
     */
    public List<VehiculoNuevoDTO> obtenerVehiculos(PersonaNuevaDTO persona) throws NegociosException;

}
