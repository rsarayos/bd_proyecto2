package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.IVehiculosDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.VehiculosDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

public class GestorVehiculosBO implements IGestorVehiculosBO {

    private final IConexion conexion;
    private final IVehiculosDAO vehiculosDAO;
    private final IPersonaDAO personasDAO;

    public GestorVehiculosBO() {
        conexion = new Conexion();
        vehiculosDAO = new VehiculosDAO(conexion);
        personasDAO = new PersonaDAO(conexion);
    }

    @Override
    public void agregarVehiculo(VehiculoNuevoDTO vehiculoNuevo) throws NegociosException {
        try {
            vehiculoNuevo.isValid();
            
            Persona persona = personasDAO.obtenerPersonaRFC(vehiculoNuevo.getPersona().getRfc());
            Vehiculo vehiculo = new Vehiculo(vehiculoNuevo.getNumeroSerie(), vehiculoNuevo.getColor(), vehiculoNuevo.getModelo(),
                    vehiculoNuevo.getLinea(), vehiculoNuevo.getMarca(), vehiculoNuevo.getPersona());
            
            vehiculosDAO.agregarVehiculo(vehiculo);
        } catch (ValidacionDTOException | PersistenciaException ex) {
            throw new NegociosException("No se pudo agregar el vehículo al sistema.");
        }
    }

    @Override
    public List<VehiculoNuevoDTO> obtenerVehiculos(PersonaNuevaDTO persona) throws NegociosException {
        try {
            persona.esValido();
            
            Persona personaAuxiliar = new Persona(persona.getRfc());
            List<Vehiculo> vehiculosSistema = vehiculosDAO.consultarVehiculos(personaAuxiliar);
            
            List<VehiculoNuevoDTO> vehiculos = new LinkedList<>();
            for (Vehiculo vehiculo : vehiculosSistema) {
                vehiculos.add(new VehiculoNuevoDTO(vehiculo.getNumeroSerie(), vehiculo.getColor(), vehiculo.getModelo(), 
                        vehiculo.getLinea(), vehiculo.getMarca(), vehiculo.getPersona(), vehiculo.getPlacas()));
            }
            
            return vehiculos;
        } catch (ValidacionDTOException | PersistenciaException e) {
            throw new NegociosException("No se pudieron consultar los vehículos.");
        }
    }

}
