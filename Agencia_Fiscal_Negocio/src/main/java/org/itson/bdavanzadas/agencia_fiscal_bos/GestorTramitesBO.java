package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.ITramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.TramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.TramiteDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

public class GestorTramitesBO implements IGestorTramitesBO {

    private IConexion conexion;
    private IPersonaDAO personasDAO;
    private ITramitesDAO tramitesDAO;

    public GestorTramitesBO(IConexion conexion) {
        this.conexion = conexion;
        personasDAO = new PersonaDAO(conexion);
        tramitesDAO = new TramitesDAO(conexion);
    }

    @Override
    public List<TramiteDTO> consultarTramites(PersonaNuevaDTO persona) throws NegociosException {

        try {
            persona.esValido();

            Persona personaAuxiliar = new Persona(persona.getRfc());
            List<Tramite> tramitesConsultados = tramitesDAO.consultarTramites(personaAuxiliar);

            List<TramiteDTO> tramites = new LinkedList<>();
            for (Tramite tramite : tramitesConsultados) {
                tramites.add(new TramiteDTO(tramite.getFechaTramite(), tramite.getCosto(), persona));
            }
            
            return tramites;
        } catch (ValidacionDTOException ex) {
            throw new NegociosException("No se pudieron consultar los trámites.");
        }
    }

}
