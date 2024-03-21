package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 *
 * @author victo
 */
public class PersonaDAO implements IPersonaDAO {

    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(PersonaDAO.class.getName());

    /**
     * Contructor que nos permite obtener la conexión con la Entity Manager
     * Factory y a la base de datos
     *
     * @param conexion Conexión con la Entity Manager Factory
     */
    public PersonaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que nos permite agregar un grupo de 20 personas nueva
     *
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    @Override
    public void agregarPersonas() throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.crearConexion();

            entityManager.getTransaction().begin();
            entityManager.persist(new Persona("GUGR040316E27", "Ricardo Alán", "Gutiérrez", "Garcés", new GregorianCalendar(2004, 2, 21), "6441239846", "GUGR040321HSRTRCA9", false));
            entityManager.persist(new Persona("ASDF123456A78", "Juan Carlos", "Gómez", "López", new GregorianCalendar(1995, 5, 15), "1234567890", "ASDF123456BCDFGH5", false));
            entityManager.persist(new Persona("ZXCV987654Z32", "María Fernanda", "Hernández", "Martínez", new GregorianCalendar(1988, 9, 3), "0987654321", "ZXCV987654YUIOPLK4", true));
            entityManager.persist(new Persona("QWER456789Q01", "Luis Alberto", "Pérez", "Sánchez", new GregorianCalendar(1976, 11, 28), "9876543210", "QWER456789ASDFGHJ3", false));
            entityManager.persist(new Persona("POIU987654P32", "Ana Gabriela", "Ramírez", "Gómez", new GregorianCalendar(2000, 3, 7), "0123456789", "POIU987654LKJHGFD2", true));
            entityManager.persist(new Persona("MNBV456789M12", "Jorge Eduardo", "González", "Hernández", new GregorianCalendar(1983, 7, 19), "5432167890", "MNBV456789RTYUIOP1", false));
            entityManager.persist(new Persona("LKJH654321L78", "Daniela Paola", "Martínez", "Rodríguez", new GregorianCalendar(1992, 1, 9), "2345678901", "LKJH654321ZXCVBNM0", true));
            entityManager.persist(new Persona("YTREW987654Y09", "Carlos Antonio", "Sánchez", "Pérez", new GregorianCalendar(1979, 10, 4), "7654321098", "YTREW987654POIUYTR9", false));
            entityManager.persist(new Persona("ZXCV123456Z45", "Verónica Alejandra", "López", "Hernández", new GregorianCalendar(1998, 8, 22), "8765432109", "ZXCV123456UIOPKLM8", true));
            entityManager.persist(new Persona("POIU567890P09", "Roberto Carlos", "Gómez", "Martínez", new GregorianCalendar(1985, 6, 17), "3456789012", "POIU567890ASDFGHJK7", false));
            entityManager.persist(new Persona("ASDF456789A89", "Fernanda Sofía", "Hernández", "Gómez", new GregorianCalendar(1993, 4, 12), "6543210987", "ASDF456789QWERTYUI6", true));
            entityManager.persist(new Persona("MNBV123456M23", "Ricardo Alejandro", "Martínez", "López", new GregorianCalendar(1974, 2, 9), "2345678901", "MNBV123456LKJHGFDS5", false));
            entityManager.persist(new Persona("LKJH789012L67", "Valentina María", "Sánchez", "González", new GregorianCalendar(2001, 11, 30), "7654321098", "LKJH789012ZXCVBNM4", true));
            entityManager.persist(new Persona("QWER654321Q56", "Miguel Ángel", "González", "Hernández", new GregorianCalendar(1987, 10, 5), "5432109876", "QWER654321ASDFGHJK3", false));
            entityManager.persist(new Persona("ZXCV234567Z90", "Paola Daniela", "Pérez", "Rodríguez", new GregorianCalendar(1996, 5, 18), "4321098765", "ZXCV234567UIOPLKM2", true));
            entityManager.persist(new Persona("LKJH098765L45", "Alejandro José", "Gómez", "Sánchez", new GregorianCalendar(1981, 8, 12), "2109876543", "LKJH098765NBVCXZM1", false));
            entityManager.persist(new Persona("POIU234567P78", "Isabella Sofía", "López", "Martínez", new GregorianCalendar(1999, 4, 25), "8765432109", "POIU234567LKJHGFDS0", true));
            entityManager.persist(new Persona("ASDF789012A34", "Andrés Felipe", "Ramírez", "González", new GregorianCalendar(1977, 7, 8), "3210987654", "ASDF789012QWERTYUI9", false));
            entityManager.persist(new Persona("MNBV789012M56", "Gabriela Fernanda", "García", "Hernández", new GregorianCalendar(1989, 3, 14), "9876543210", "MNBV789012ASDFGHJK8", true));
            entityManager.persist(new Persona("QWER123456Q23", "José Manuel", "Hernández", "López", new GregorianCalendar(1980, 1, 29), "6543210987", "QWER123456UIOPLKM7", false));
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó la lista de personas correctamente");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se puedo agregar la lista de personas", e);
        } finally {
            entityManager.close();
        }

    }

}
