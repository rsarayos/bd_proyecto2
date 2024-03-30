package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.ITramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonasDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.TramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.TramiteDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonasDAO;

/**
 * La clase GestorTramitesBO implementa la interfaz IGestorTramitesBO y define
 * la lógica de negocio para la gestión de trámites relacionados con personas.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class GestorTramitesBO implements IGestorTramitesBO {

    private IConexion conexion;
    private IPersonasDAO personasDAO;
    private ITramitesDAO tramitesDAO;

    /**
     * Constructor por defecto que permite inicializar la conexión de las DAOs
     * utilizadas.
     */
    public GestorTramitesBO() {
        this.conexion = new Conexion();
        personasDAO = new PersonasDAO(conexion);
        tramitesDAO = new TramitesDAO(conexion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TramiteDTO> consultarTramites(PersonaNuevaDTO persona) throws NegociosException {

        try {
            persona.esValido();

            Persona personaAuxiliar = new Persona(persona.getRfc());
            List<Tramite> tramitesConsultados = tramitesDAO.consultarTramitesPersona(personaAuxiliar);

            List<TramiteDTO> tramites = new LinkedList<>();
            for (Tramite tramite : tramitesConsultados) {
                String tipoTramite = null;
                if (tramite instanceof Licencia) {
                    tipoTramite = "Licencia";
                } else if (tramite instanceof Placa) {
                    tipoTramite = "Placa";
                }
                tramites.add(new TramiteDTO(tramite.getFechaTramite(), tramite.getCosto(), tipoTramite, persona));
            }
            
            return tramites;
        } catch (ValidacionDTOException | PersistenciaException ex) {
            throw new NegociosException("No se pudieron consultar los trámites.");
        }
    }

}
