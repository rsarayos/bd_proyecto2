
package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PlacasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPlacasDAO;

public class RegistroPlacaBO implements IRegistroPlacaBO {

    private final IConexion conexion;
    private final IPlacasDAO placaDAO;
    private final IPersonasDAO personasDAO;
    private Encriptar encriptar;
    static final Logger logger = Logger.getLogger(RegistroPlacaBO.class.getName());

    /**
     * Constructor por defecto que permite inicializar la conexión con las DAOs
     * utilizadas, además inicializa la clase para encriptar y desencriptar el 
     * teléfono de la persona.
     */
    public RegistroPlacaBO() {
        this.conexion = new Conexion();
        this.placaDAO = new PlacasDAO(conexion);
        this.personasDAO = new PersonasDAO(conexion);
        encriptar = new Encriptar();
        
    }

    /**
     * Permite tramitar una placa nueva.
     *
     * @param placaNueva Datos de la placa nueva
     * @return Placa agregada.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * tramitar la placa.
     */
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

    /**
     * Permite buscar una placa según el número de placa proporcionado.
     *
     * @param numPlaca Número de placa que permite buscar la placa.
     * @return Placa buscada.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar la placa.
     */
    @Override
    public PlacaNuevaDTO buscarPlaca(String numPlaca) throws NegociosException {
        Placa placa=null;
        try {
            placa = this.placaDAO.obtenerPlaca(numPlaca);
        } catch (PersistenciaException pe) {
            logger.log(Level.SEVERE, "No se pudo consultar la placa", pe);
            throw new NegociosException("Error al buscar la placa");
        }
        if(placa == null){
            return null;
        } else {
        PlacaNuevaDTO placaNueva = new PlacaNuevaDTO(numPlaca);
        return placaNueva;
        }
    }
    
    /**
     * Permite buscar una lista de placas que tiene el vehículo proporcionado.
     *
     * @param vehiculoN Vehículo del cual se buscarán las placas.
     * @return Lista de placas del vehículo.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar la lista de placas.
     */
    @Override
    public List<PlacaNuevaDTO> buscarPlacasVehiculo(VehiculoNuevoDTO vehiculoN) throws NegociosException {
        
        Persona persona = null;
        
        try {
            persona = this.personasDAO.obtenerPersonaRFC(vehiculoN.getPersona().getRfc());
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, "Error al buscar persona", ex);
        }
        
        Vehiculo vehiculo = new Vehiculo(
                vehiculoN.getNumeroSerie(), 
                vehiculoN.getColor(), 
                vehiculoN.getModelo(), 
                vehiculoN.getLinea(), 
                vehiculoN.getModelo(), 
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
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, "Error al desencriptar teléfono", ex);
        }
        
        List<Placa> listaPlacas = new LinkedList<>();
        try {
            listaPlacas = this.placaDAO.obtenerPlacasVehiculo(vehiculo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, "Error al buscar la placa", ex);
            throw new NegociosException("Error al obtener lista de placas");
        }
        
        List<PlacaNuevaDTO> placas = new LinkedList<>();
        for (Placa placa : listaPlacas) {
            placas.add(new PlacaNuevaDTO(placa.getNumeroPlaca(),placa.getFechaRecepcion(), placa.getEstado(), vehiculoN, placa.getFechaTramite(),placa.getCosto(), personaNueva));
        }
        return placas;
    }


}
