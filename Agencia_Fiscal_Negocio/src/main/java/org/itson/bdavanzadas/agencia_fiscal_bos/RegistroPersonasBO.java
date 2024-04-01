package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroPersonas;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroPersonasDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonasDAO;

/**
 * La clase RegistroPersonasBO implementa la interfaz IRegistroPersonasBO y define
 * la lógica de negocio para el registro, búsqueda y consulta de personas en el sistema.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class RegistroPersonasBO implements IRegistroPersonasBO {

    static final Logger logger = Logger.getLogger(RegistroPersonasBO.class.getName());
    private IConexion conexion;
    private IPersonasDAO personaDAO;
    private Encriptar encriptar;

    /**
     * Constructor por defecto que permite inicializar la conexión con la DAO
     * utilizada, además inicializa la clase para encriptar y desencriptar el 
     * teléfono de la persona.
     */
    public RegistroPersonasBO() {
        conexion = new Conexion();
        personaDAO = new PersonasDAO(conexion);
        encriptar = new Encriptar();
    }

    /**
     * Constructor que permite crear un nuevo objeto de RegistroPersonaBO con la
     * conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * acceder a los datos de las personas.
     */
    public RegistroPersonasBO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarPersonas() throws NegociosException {
        try {
            personaDAO.agregarPersonas();
        } catch (PersistenciaException pex) {
            throw new NegociosException(pex.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonaNuevaDTO buscarPersona(String rfc) throws NegociosException {
        try {
            Persona persona = this.personaDAO.obtenerPersonaRFC(rfc);

            if (persona != null) {

                String telefonoEnc = new String(persona.getTelefono());

                PersonaNuevaDTO personaNueva = new PersonaNuevaDTO(
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
                return personaNueva;
            }
        } catch (PersistenciaException pex) {
            throw new NegociosException(pex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(RegistroPersonasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PersonaNuevaDTO> consultarPersonas(FiltroPersonasDTO filtroPersonas) throws NegociosException {
        FiltroPersonas filtroConsulta = new FiltroPersonas();
        filtroConsulta.setRfc(filtroPersonas.getRfc());
        filtroConsulta.setNombre(filtroPersonas.getNombre());
        filtroConsulta.setFechaNacimiento(filtroPersonas.getFechaNacimiento());

        try {
            List<Persona> personasConsultadas = this.personaDAO.buscarPersona(filtroConsulta);
            List<PersonaNuevaDTO> personasRegreso = new LinkedList<>();
            for (Persona persona : personasConsultadas) {

                String telefonoEnc = new String(persona.getTelefono());

                PersonaNuevaDTO personaNueva = new PersonaNuevaDTO(
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
                personasRegreso.add(personaNueva);
            }
            return personasRegreso;
        } catch (PersistenciaException pex) {
            throw new NegociosException(pex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(RegistroPersonasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
