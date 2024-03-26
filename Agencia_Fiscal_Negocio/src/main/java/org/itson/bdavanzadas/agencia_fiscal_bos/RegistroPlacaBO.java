/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPlacaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PlacaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_negocioAux.GenerarNumeroPlaca;

/**
 *
 * @author alex_
 */
public class RegistroPlacaBO implements IRegistroPlacaBO {

    private final IConexion conexion;
    private final IPlacaDAO placaDAO;
    private final IPersonaDAO personasDAO;
    private Encriptar encriptar;
    static final Logger logger = Logger.getLogger(RegistroPlacaBO.class.getName());

    public RegistroPlacaBO() {
        this.conexion = new Conexion();
        this.placaDAO = new PlacaDAO(conexion);
        this.personasDAO = new PersonaDAO(conexion);
        encriptar = new Encriptar();
        
    }

    @Override
    public PlacaNuevaDTO tramitarPlaca(PlacaNuevaDTO placaNueva) throws NegociosException {
        // se verifica si el vehiculo ya tenia una placa previamente
        Vehiculo vehiculo = new Vehiculo(placaNueva.getVehiculo().getNumeroSerie());
        Persona persona = new Persona(placaNueva.getPersona().getRfc());
       
        try {
            // Una ves se determina el numero de placa se crea la nueva placa
            Placa placa = new Placa(placaNueva.getNumeroPlaca(),
                    null,
                    placaNueva.getEstado(),
                    vehiculo,
                    placaNueva.getFechaTramite(),
                    placaNueva.getCosto(),
                    persona);
            List<Placa> placas;

            placas = this.placaDAO.obtenerPlacasVehiculo(vehiculo);
            // si el vehiculo no tenia una placa previa se realiza el registro sin modificar vigencias
            if (placas.isEmpty()) {
                this.placaDAO.agregarPlaca(placa);
                logger.log(Level.INFO, "Se registro la placa exitosamente");
                return placaNueva;
            } else {
                // se obtiene la ultima placa activa del vehiculo y se modifica su estado y fecha de recepcion
                Placa placaAnterior = this.placaDAO.obtenerPlacaActiva(vehiculo);
                this.placaDAO.modificarVigencia(placaAnterior);
                // posteriormente se registra la nueva placa
                this.placaDAO.agregarPlaca(placa);
                logger.log(Level.INFO, "Se registro la placa exitosamente");
                return placaNueva;
            }
        } catch (PersistenciaException pe) {
            logger.log(Level.SEVERE, "No se pudo consultar las placas del vehiculo", pe);
            throw new NegociosException("Error al tramitar Placa");
        }

    }

    @Override
    public PlacaNuevaDTO buscarPlaca(String numPlaca) throws NegociosException {
        Placa placa=null;
        try {
            placa = this.placaDAO.obtenerPlaca(numPlaca);
        } catch (PersistenciaException pe) {
            logger.log(Level.SEVERE, "No se pudo consultar la placa", pe);
            throw new NegociosException("Error al buscar la placa");
        }
        
        PlacaNuevaDTO placaNueva = new PlacaNuevaDTO(numPlaca);
        return placaNueva;
    }
    
    @Override
    public List<PlacaNuevaDTO> buscarPlacasVehiculo(VehiculoNuevoDTO vehiculoNuevo) throws NegociosException {
        
        Persona persona = null;
        
        try {
            persona = this.personasDAO.obtenerPersonaRFC(vehiculoNuevo.getPersona().getRfc());
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Vehiculo vehiculo = new Vehiculo(
                vehiculoNuevo.getNumeroSerie(), 
                vehiculoNuevo.getColor(), 
                vehiculoNuevo.getModelo(), 
                vehiculoNuevo.getLinea(), 
                vehiculoNuevo.getModelo(), 
                persona);
        
        String telefonoEnc = new String(persona.getTelefono());
        PersonaNuevaDTO personaNueva = null;
        try {
            personaNueva = new PersonaNuevaDTO(
                    persona.getRfc(),
                    persona.getNombres(),
                    persona.getApellidoPaterno(),
                    persona.getApellidoMaterno(),
                    persona.getFechaNacimiento(),
                    encriptar.desencriptar(telefonoEnc),
                    persona.getIsDiscapacitado(),
                    persona.getTramites(),
                    persona.getVehiculos()
            );
        } catch (Exception ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Placa> listaPlacas = new LinkedList<>();
        try {
            listaPlacas = this.placaDAO.obtenerPlacasVehiculo(vehiculo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegociosException("Error al obtener lista de placas");
        }
        
        List<PlacaNuevaDTO> placas = new LinkedList<>();
        for (Placa placa : listaPlacas) {
            placas.add(new PlacaNuevaDTO(placa.getEstado(), vehiculoNuevo, placa.getFechaTramite(),placa.getCosto(), personaNueva));
        }
        return placas;
    }


}
