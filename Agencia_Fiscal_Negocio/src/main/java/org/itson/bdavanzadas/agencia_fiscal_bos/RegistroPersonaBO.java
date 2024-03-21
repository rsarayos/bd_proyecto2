package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
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

    @Override
    public void agregarPersonas() throws NegociosException{
        try {
            personaDAO.agregarPersonas();
        } catch (PersistenciaException ex) {
            throw new NegociosException("Ya se registraron las personas en el sistema.");
        }
    }

}
