package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IVehiculosDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PlacasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.VehiculosDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPlacasDAO;

/**
 * La clase GestorVehiculosBO implementa la interfaz IGestorVehiculosBO y define
 * la lógica de negocio para la gestión de vehículos y placas asociadas a personas.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class GestorVehiculosBO implements IGestorVehiculosBO {

    private final IConexion conexion;
    private final IVehiculosDAO vehiculosDAO;
    private final IPersonasDAO personasDAO;
    private final IPlacasDAO placaDAO;
    private Encriptar encriptar;

    /**
     * Constructor por defecto que permite inicializar la conexión con las DAOs
     * utilizadas, además inicializa la clase para encriptar y desencriptar el
     * teléfono de la persona.
     */
    public GestorVehiculosBO() {
        conexion = new Conexion();
        vehiculosDAO = new VehiculosDAO(conexion);
        personasDAO = new PersonasDAO(conexion);
        placaDAO = new PlacasDAO(conexion);
        encriptar = new Encriptar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarVehiculo(VehiculoNuevoDTO vehiculoNuevo) throws NegociosException {
        try {
            Persona persona = personasDAO.obtenerPersonaRFC(vehiculoNuevo.getPersona().getRfc());
            Vehiculo vehiculo = new Vehiculo(vehiculoNuevo.getNumeroSerie(), vehiculoNuevo.getColor(), vehiculoNuevo.getModelo(),
                    vehiculoNuevo.getLinea(), vehiculoNuevo.getMarca(), persona);

            vehiculosDAO.agregarVehiculo(vehiculo);
        } catch (PersistenciaException ex) {
            throw new NegociosException("No se pudo agregar el vehículo al sistema.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VehiculoNuevoDTO buscarVehiculo(String numPlaca) throws NegociosException {
        Placa placa;
        try {
            placa = placaDAO.obtenerPlaca(numPlaca);
        } catch (PersistenciaException ex) {
            throw new NegociosException("No se pudo consultar la placa.");
        }

        Vehiculo vehiculo;
        try {
            vehiculo = vehiculosDAO.obtenerVehiculo(placa.getVehiculo().getNumeroSerie());
        } catch (PersistenciaException ex) {
            throw new NegociosException("No se pudo consultar el vehículo.");
        }

        String telefonoEnc = new String(vehiculo.getPersona().getTelefono());
        PersonaNuevaDTO persona = null;
        try {
            persona = new PersonaNuevaDTO(
                    vehiculo.getPersona().getRfc(),
                    vehiculo.getPersona().getNombres(),
                    vehiculo.getPersona().getApellidoPaterno(),
                    vehiculo.getPersona().getApellidoMaterno(),
                    vehiculo.getPersona().getFechaNacimiento(),
                    encriptar.desencriptar(telefonoEnc),
                    vehiculo.getPersona().getIsDiscapacitado(),
                    vehiculo.getPersona().getTramites(),
                    vehiculo.getPersona().getVehiculos()
            );
        } catch (Exception ex) {
            Logger.getLogger(RegistroPlacaBO.class.getName()).log(Level.SEVERE, "Error al desencriptar teléfono", ex);
        }

        VehiculoNuevoDTO vehiculoBuscado = new VehiculoNuevoDTO(
                vehiculo.getNumeroSerie(),
                vehiculo.getColor(),
                vehiculo.getModelo(),
                vehiculo.getLinea(),
                vehiculo.getMarca(),
                persona);

        return vehiculoBuscado;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public VehiculoNuevoDTO buscarVehiculoNS(String numSerie) throws NegociosException {
        VehiculoNuevoDTO vehiculoNuevo = null;
        try {
            Vehiculo vehiculoEncontrado = this.vehiculosDAO.obtenerVehiculo(numSerie);
            
            if (vehiculoEncontrado != null) {
                vehiculoNuevo = new VehiculoNuevoDTO(vehiculoEncontrado.getNumeroSerie());
            }
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(GestorVehiculosBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vehiculoNuevo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<VehiculoNuevoDTO> obtenerVehiculos(PersonaNuevaDTO persona) throws NegociosException {
        try {
            persona.esValido();

            Persona personaAuxiliar = new Persona(persona.getRfc());
            List<Vehiculo> vehiculosSistema = vehiculosDAO.consultarVehiculos(personaAuxiliar);

            List<VehiculoNuevoDTO> vehiculos = new LinkedList<>();
            for (Vehiculo vehiculo : vehiculosSistema) {
                vehiculos.add(new VehiculoNuevoDTO(vehiculo.getNumeroSerie(), vehiculo.getColor(), vehiculo.getModelo(),
                        vehiculo.getLinea(), vehiculo.getMarca(), persona, vehiculo.getPlacas()));
            }

            return vehiculos;
        } catch (ValidacionDTOException | PersistenciaException e) {
            throw new NegociosException("No se pudieron consultar los vehículos.");
        }
    }

}
