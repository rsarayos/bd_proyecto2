package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.ILicenciaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.LicenciaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.ValidacionDTOException;

/**
 *
 * @author alex_
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO{

    private final IConexion conexion;
    private final ILicenciaDAO licenciaDAO;
    static final Logger logger = Logger.getLogger(RegistroLicenciaBO.class.getName());

    public RegistroLicenciaBO(IConexion conexion) {
        this.conexion = conexion;
        this.licenciaDAO = new LicenciaDAO(this.conexion);
    }
    
    @Override
    public Licencia registrarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException {
        Licencia licencia = null;
        try {
            try {
                if (licenciaNueva.esValido()) {
                    licencia = new Licencia(licenciaNueva.getFechaVencimiento(),
                            licenciaNueva.getFechaTramite(),
                            licenciaNueva.getCosto(),
                            licenciaNueva.getPersona(),
                            licenciaNueva.getEstado());
                    try {
                        licenciaDAO.agregarLicencia(licencia);
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionDTOException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            return licencia;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puedo agregar la licencia", ex);
            throw new NegociosException("Error al agregar la licencia", ex);
        }
    }

    @Override
    public List<Licencia> obtenerLicencias(PersonaNuevaDTO personaNueva) throws NegociosException {
        List<Licencia> licencias = null;
        try {
            try {
                if (personaNueva.esValido()) {
                    Persona persona = new Persona(personaNueva.getRfc());
                    try {
                        licencias = licenciaDAO.obtenerLicencia(persona);
                    } catch (PersistenciaException ex) {
                        logger.log(Level.SEVERE, "Excepcion en persistencia");
                    }
                }
            } catch (ValidacionDTOException ex) {
                logger.log(Level.SEVERE, "Excepcion en validacion");
            }
            return licencias;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se pudo obtener las licencias", ex);
            throw new NegociosException("Error al obtener licencia", ex);
        }
    }
    
}
