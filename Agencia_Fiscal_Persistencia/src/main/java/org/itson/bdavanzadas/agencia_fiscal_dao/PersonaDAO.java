package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 *
 * @author victo
 */
public class PersonaDAO implements IPersonaDAO {

    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(PersonaDAO.class.getName());
    private Encriptar encriptar;

    /**
     * Contructor que nos permite obtener la conexión con la Entity Manager
     * Factory y a la base de datos
     *
     * @param conexion Conexión con la Entity Manager Factory
     */
    public PersonaDAO(IConexion conexion) {
        this.conexion = conexion;
        encriptar = new Encriptar();
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

        String t1 = null, t2 = null, t3 = null, t4 = null, t5 = null, t6 = null, t7 = null, t8 = null, t9 = null, t10 = null,
                t11 = null, t12 = null, t13 = null, t14 = null, t15 = null, t16 = null, t17 = null, t18 = null, t19 = null,
                t20 = null;

        try {
            t1 = encriptar.encriptar("6441239846");
            t2 = encriptar.encriptar("6444567890");
            t3 = encriptar.encriptar("6447654321");
            t4 = encriptar.encriptar("6446543210");
            t5 = encriptar.encriptar("6443456789");
            t6 = encriptar.encriptar("6442167890");
            t7 = encriptar.encriptar("6445678901");
            t8 = encriptar.encriptar("6444321098");
            t9 = encriptar.encriptar("6445432109");
            t10 = encriptar.encriptar("6446789012");
            t11 = encriptar.encriptar("6443210987");
            t12 = encriptar.encriptar("6445678901");
            t13 = encriptar.encriptar("6444321098");
            t14 = encriptar.encriptar("6442109876");
            t15 = encriptar.encriptar("6441098765");
            t16 = encriptar.encriptar("6449876543");
            t17 = encriptar.encriptar("6445432109");
            t18 = encriptar.encriptar("6440987654");
            t19 = encriptar.encriptar("6446543210");
            t20 = encriptar.encriptar("6443210987");
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            entityManager = conexion.crearConexion();

            entityManager.getTransaction().begin();
            entityManager.persist(new Persona("GUGR040316E27", "Ricardo Alán", "Gutiérrez", "Garcés", new GregorianCalendar(2004, 2, 21), t1.getBytes(), "GUGR040321HSRTRCA9", false));
            entityManager.persist(new Persona("ASDF123456A78", "Juan Carlos", "Gómez", "López", new GregorianCalendar(1995, 5, 15), t2.getBytes(), "ASDF123456BCDFGHA5", false));
            entityManager.persist(new Persona("ZXCV987654Z32", "María Fernanda", "Hernández", "Martínez", new GregorianCalendar(1988, 9, 3), t3.getBytes(), "ZXCV987654YUIOPLK4", true));
            entityManager.persist(new Persona("QWER456789Q01", "Luis Alberto", "Pérez", "Sánchez", new GregorianCalendar(1976, 11, 28), t4.getBytes(), "QWER456789ASDFGHJ3", false));
            entityManager.persist(new Persona("POIU987654P32", "Ana Gabriela", "Ramírez", "Gómez", new GregorianCalendar(2000, 3, 7), t5.getBytes(), "POIU987654LKJHGFD2", true));
            entityManager.persist(new Persona("MNBV456789M12", "Jorge Eduardo", "González", "Hernández", new GregorianCalendar(1983, 7, 19), t6.getBytes(), "MNBV456789RTYUIOP1", false));
            entityManager.persist(new Persona("LKJH654321L78", "Daniela Paola", "Martínez", "Rodríguez", new GregorianCalendar(1992, 1, 9), t7.getBytes(), "LKJH654321ZXCVBNM0", true));
            entityManager.persist(new Persona("YREW987654Y09", "Carlos Antonio", "Sánchez", "Pérez", new GregorianCalendar(1979, 10, 4), t8.getBytes(), "YREW987654POIUYTR9", false));
            entityManager.persist(new Persona("ZXCV123456Z45", "Verónica Alejandra", "López", "Hernández", new GregorianCalendar(1998, 8, 22), t9.getBytes(), "ZXCV123456UIOPKLM8", true));
            entityManager.persist(new Persona("POIU567890P09", "Roberto Carlos", "Gómez", "Martínez", new GregorianCalendar(1985, 6, 17), t10.getBytes(), "POIU567890ASDGHJK7", false));
            entityManager.persist(new Persona("ASDF456789A89", "Fernanda Sofía", "Hernández", "Gómez", new GregorianCalendar(1993, 4, 12), t11.getBytes(), "ASDF456789QWERYUI6", true));
            entityManager.persist(new Persona("MNBV123456M23", "Ricardo Alejandro", "Martínez", "López", new GregorianCalendar(1974, 2, 9), t12.getBytes(), "MNBV123456LKJGFDS5", false));
            entityManager.persist(new Persona("LKJH789012L67", "Valentina María", "Sánchez", "González", new GregorianCalendar(2001, 11, 30), t13.getBytes(), "LKJH789012ZXCVBNM4", true));
            entityManager.persist(new Persona("QWER654321Q56", "Miguel Ángel", "González", "Hernández", new GregorianCalendar(1987, 10, 5), t14.getBytes(), "QWER654321ASDFHJK3", false));
            entityManager.persist(new Persona("ZXCV234567Z90", "Paola Daniela", "Pérez", "Rodríguez", new GregorianCalendar(1996, 5, 18), t15.getBytes(), "ZXCV234567UIOPLKM2", true));
            entityManager.persist(new Persona("LKJH098765L45", "Alejandro José", "Gómez", "Sánchez", new GregorianCalendar(1981, 8, 12), t16.getBytes(), "LKJH098765NBVCXZM1", false));
            entityManager.persist(new Persona("POIU234567P78", "Isabella Sofía", "López", "Martínez", new GregorianCalendar(1999, 4, 25), t17.getBytes(), "POIU234567LKJHGDS0", true));
            entityManager.persist(new Persona("ASDF789012A34", "Andrés Felipe", "Ramírez", "González", new GregorianCalendar(1977, 7, 8), t18.getBytes(), "ASDF789012QWERYUI9", false));
            entityManager.persist(new Persona("MNBV789012M56", "Gabriela Fernanda", "García", "Hernández", new GregorianCalendar(1989, 3, 14), t19.getBytes(), "MNBV789012ASDFGHJ8", true));
            entityManager.persist(new Persona("QWER123456Q23", "José Manuel", "Hernández", "López", new GregorianCalendar(1980, 1, 29), t20.getBytes(), "QWER123456UIOPLKM7", false));
            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó la lista de personas correctamente");
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron regitrar las personas en la BD.");
        } finally {
            entityManager.close();
        }

    }

}
