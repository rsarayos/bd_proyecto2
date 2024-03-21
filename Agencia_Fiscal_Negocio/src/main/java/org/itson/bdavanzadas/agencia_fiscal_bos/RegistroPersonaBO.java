
package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.logging.Level;
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
    
    public RegistroPersonaBO(Conexion conexion) {
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
     */
    @Override
    public void agregarPersonas() throws NegociosException{

        IPersonaDAO personaDAO = new PersonaDAO(conexion);

        try {
            personaDAO.agregarPersonas();
        } catch (PersistenciaException pex) {
            logger.log(Level.SEVERE, pex.getMessage());
        }
    }

}
