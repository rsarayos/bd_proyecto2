package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroPersonas;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroPersonasDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author victo
 */
public class RegistroPersonaBO implements IRegistroPersonasBO {

    static final Logger logger = Logger.getLogger(RegistroPersonaBO.class.getName());
    private IConexion conexion;
    private IPersonaDAO personaDAO;

    public RegistroPersonaBO() {
        conexion = new Conexion();
        personaDAO = new PersonaDAO(conexion);
    }

    /**
     * Constructor que permite crear un nuevo objeto de RegistroPersonaBO con la
     * conexión especificada.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * acceder a los datos de las personas.
     */
    public RegistroPersonaBO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Permite agregar personas utilizando un objeto de acceso a datos de
     * persona.
     *
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * agregar una persona.
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
     * Permite buscar una persona por su rfc utilizando un objeto de acceso a
     * datos de persona.
     *
     * @param rfc RFC de la persona a buscar
     * @return Objeto con la persona buscada con el RFC
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * buscar una persona.
     */
    @Override
    public PersonaNuevaDTO buscarPersona(String rfc) throws NegociosException{
        try {
            Persona persona = personaDAO.obtenerPersonaRFC(rfc);
            
            PersonaNuevaDTO personaNueva = new PersonaNuevaDTO(
                        persona.getRfc(),
                        persona.getNombres(),
                        persona.getApellidoPaterno(),
                        persona.getApellidoMaterno(),
                        persona.getFechaNacimiento(),
                        persona.getTelefono(),
                        persona.getIsDiscapacitado(),
                        persona.getTramites(),
                        persona.getVehiculos()
                );
            return personaNueva;
        } catch (PersistenciaException pex) {
            throw new NegociosException(pex.getMessage());
        }
    
    }
    
    /**
     * Método que nos permite consultar las personas según el filtro enviado.
     *
     * @param filtroPersonas Parámetros que ayudarán al filtrado de las
     * personas.
     * @return Una lista de personas con los filtros aplicados.
     * @throws NegociosException Es lanzanda en caso de que ocurra un error al
     * consultar a las personas.
     */
    @Override
    public List<PersonaNuevaDTO> consultarPersonas(FiltroPersonasDTO filtroPersonas) throws NegociosException {
        FiltroPersonas filtroConsulta = new FiltroPersonas();
        filtroConsulta.setRfc(filtroPersonas.getRfc());
        filtroConsulta.setNombre(filtroPersonas.getNombre());
        filtroConsulta.setFechaNacimiento(filtroPersonas.getFechaNacimiento());

        try {
            List<Persona> personasConsultadas = personaDAO.buscarPersona(filtroConsulta);
            List<PersonaNuevaDTO> personasRegreso = new LinkedList<>();
            for (Persona persona : personasConsultadas) {
                PersonaNuevaDTO personaNueva = new PersonaNuevaDTO(
                        persona.getRfc(),
                        persona.getNombres(),
                        persona.getApellidoPaterno(),
                        persona.getApellidoMaterno(),
                        persona.getFechaNacimiento(),
                        persona.getTelefono(),
                        persona.getIsDiscapacitado(),
                        persona.getTramites(),
                        persona.getVehiculos()
                );
                personasRegreso.add(personaNueva);
            }
            return personasRegreso;
        } catch (PersistenciaException ex) {
            throw new NegociosException(ex.getMessage());
        }
    }

}
