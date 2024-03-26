package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.ILicenciaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.LicenciaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

/**
 * La clase RegistroLicenciaBO implementa la interfaz IRegistroLicenciaBO y
 * proporciona métodos para realizar operaciones con Licencia.
 *
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    private final IConexion conexion;
    private final ILicenciaDAO licenciaDAO;
    private final IPersonaDAO personaDAO;
    static final Logger logger = Logger.getLogger(RegistroLicenciaBO.class.getName());

    /**
     * Constructor de la clase RegistroLicenciaBO que recibe un objeto IConexion
     * e inicializa la conexion con IlicenciaDAO
     *
     */
    public RegistroLicenciaBO() {
        conexion = new Conexion();
        licenciaDAO = new LicenciaDAO(conexion);
        personaDAO = new PersonaDAO(conexion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LicenciaNuevaDTO registrarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException {
        try {
            try {
                if (licenciaNueva.esValido()) {
                    Persona persona = personaDAO.obtenerPersonaRFC(licenciaNueva.getPersona().getRfc());
                    Licencia licencia = new Licencia(licenciaNueva.getFechaVencimiento(),
                            licenciaNueva.getFechaTramite(),
                            licenciaNueva.getCosto(), 
                            persona,
                            licenciaNueva.getEstado());
                    try {
                        Licencia licenciaPer = licenciaDAO.agregarLicencia(licencia);
                        licenciaNueva.setId(licenciaPer.getId());
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionDTOException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            return licenciaNueva;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "No se puedo agregar la licencia", ex);
            throw new NegociosException("Error al agregar la licencia", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LicenciaNuevaDTO> obtenerLicencias(PersonaNuevaDTO personaNueva) throws NegociosException {
        List<LicenciaNuevaDTO> licenciasDT = new LinkedList<>();
        try {
            try {
                if (personaNueva.esValido()) {
                    try {
                        Persona persona = new Persona(personaNueva.getRfc());
                        List<Licencia> licencias = licenciaDAO.obtenerLicencias(persona);
                        for (Licencia lic : licencias) {
                            licenciasDT.add(new LicenciaNuevaDTO(
                                    lic.getId(),
                                    lic.getFechaVencimiento(),
                                    lic.getFechaTramite(),
                                    lic.getCosto(),
                                    personaNueva,
                                    lic.getEstado()));
                        }

                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionDTOException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            return licenciasDT;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se pudo obtener las licencias", ex);
            throw new NegociosException("Error al obtener licencia", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LicenciaNuevaDTO obtenerLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException {
        LicenciaNuevaDTO licObt = null;
        try {

            Persona persona = personaDAO.obtenerPersonaRFC(licenciaNueva.getPersona().getRfc());

            Licencia licencia = new Licencia(licenciaNueva.getFechaVencimiento(),
                    licenciaNueva.getFechaTramite(),
                    licenciaNueva.getCosto(),
                    persona,
                    licenciaNueva.getEstado());
            licencia.setId(licenciaNueva.getId());
            Licencia licObtenida = licenciaDAO.obtenerLicencia(licencia);
            if (licObtenida != null) {
                PersonaNuevaDTO personaDTO = new PersonaNuevaDTO(licObtenida.getPersona().getRfc());
                licObt = new LicenciaNuevaDTO(licObtenida.getFechaVencimiento(),
                        licObtenida.getFechaTramite(),
                        licObtenida.getCosto(),
                        personaDTO,
                        licObtenida.getEstado());
                logger.log(Level.INFO, "se obtuvo licencia");
                return licObt;
            } else {
                logger.log(Level.INFO, "No se encontro licencia");
                return null;
            }

        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Excepcion en persistencia");
            throw new NegociosException("Error al registrar el tramite en persistencia", ex);
        }
    }

    @Override
    public LicenciaNuevaDTO tramitarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException {
        try {
            // se obtiene a la persona que obtendra la licencia
            Persona persona = personaDAO.obtenerPersonaRFC(licenciaNueva.getPersona().getRfc());
            try {
                // se obtiene la lista de licencias de la persona.
                List<Licencia> licencias = licenciaDAO.obtenerLicencias(persona);
                if (licencias.isEmpty()) {
                    // se registra la nueva licencia a la persona
                    logger.log(Level.INFO, "no se cambia vigencias");
                    return this.registrarLicencia(licenciaNueva);
                } else {
                    // se obtiene la ultima licencia

                    Licencia licAnterior = licencias.get(licencias.size() - 1);
                    licenciaDAO.modificarVigencia(licAnterior);
                    // se registra la nueva licencia
                    logger.log(Level.INFO, "Se cambia vigencias");
                    return this.registrarLicencia(licenciaNueva);
                }
            } catch (PersistenciaException ex) {
                logger.log(Level.SEVERE, "No se pudo registrar el tramite de licencia", ex);
                throw new PersistenciaException("Error al registrar el tramite en persistencia", ex);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se pudo registrar el tramite de licencia", ex);
            throw new NegociosException("Error al registrar el tramite en negocio", ex);
        }
    }

}
