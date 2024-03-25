package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroPersonas;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 * Clase que implementa las operaciones para acceder a los datos de personas en
 * la base de datos.
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
        EntityManager entityManager = conexion.crearConexion();

        String t1 = null, t2 = null, t3 = null, t4 = null, t5 = null, t6 = null, t7 = null, t8 = null, t9 = null, t10 = null,
                t11 = null, t12 = null, t13 = null, t14 = null, t15 = null, t16 = null, t17 = null, t18 = null, t19 = null,
                t20 = null;

        String n1 = null, n2 = null, n3 = null, n4 = null, n5 = null, n6 = null, n7 = null, n8 = null, n9 = null, n10 = null,
                n11 = null, n12 = null, n13 = null, n14 = null, n15 = null, n16 = null, n17 = null, n18 = null, n19 = null,
                n20 = null;

        String ap1 = null, ap2 = null, ap3 = null, ap4 = null, ap5 = null, ap6 = null, ap7 = null, ap8 = null, ap9 = null, ap10 = null,
                ap11 = null, ap12 = null, ap13 = null, ap14 = null, ap15 = null, ap16 = null, ap17 = null, ap18 = null, ap19 = null,
                ap20 = null;

        String am1 = null, am2 = null, am3 = null, am4 = null, am5 = null, am6 = null, am7 = null, am8 = null, am9 = null, am10 = null,
                am11 = null, am12 = null, am13 = null, am14 = null, am15 = null, am16 = null, am17 = null, am18 = null, am19 = null,
                am20 = null;

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
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, "Error al encriptar los teléfonos", ex);
        }

        try {
            n1 = encriptar.encriptar("Ricardo Alán");
            n2 = encriptar.encriptar("Juan Carlos");
            n3 = encriptar.encriptar("María Fernanda");
            n4 = encriptar.encriptar("Luis Alberto");
            n5 = encriptar.encriptar("Ana Gabriela");
            n6 = encriptar.encriptar("Jorge Eduardo");
            n7 = encriptar.encriptar("Daniela Paola");
            n8 = encriptar.encriptar("Carlos Antonio");
            n9 = encriptar.encriptar("Verónica Alejandra");
            n10 = encriptar.encriptar("Roberto Carlos");
            n11 = encriptar.encriptar("Fernanda Sofía");
            n12 = encriptar.encriptar("Ricardo Alejandro");
            n13 = encriptar.encriptar("Valentina María");
            n14 = encriptar.encriptar("Miguel Ángel");
            n15 = encriptar.encriptar("Paola Daniela");
            n16 = encriptar.encriptar("Alejandro José");
            n17 = encriptar.encriptar("Isabella Sofía");
            n18 = encriptar.encriptar("Andrés Felipe");
            n19 = encriptar.encriptar("Gabriela Fernanda");
            n20 = encriptar.encriptar("José Manuel");
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, "Error al encriptar los nombres", ex);
        }

        try {
            ap1 = encriptar.encriptar("Gutiérrez");
            ap2 = encriptar.encriptar("Gómez");
            ap3 = encriptar.encriptar("Hernández");
            ap4 = encriptar.encriptar("Pérez");
            ap5 = encriptar.encriptar("Ramírez");
            ap6 = encriptar.encriptar("González");
            ap7 = encriptar.encriptar("Martínez");
            ap8 = encriptar.encriptar("Sánchez");
            ap9 = encriptar.encriptar("López");
            ap10 = encriptar.encriptar("Hernández");
            ap11 = encriptar.encriptar("Martínez");
            ap12 = encriptar.encriptar("Hernández");
            ap13 = encriptar.encriptar("Sánchez");
            ap14 = encriptar.encriptar("Gómez");
            ap15 = encriptar.encriptar("Pérez");
            ap16 = encriptar.encriptar("Gómez");
            ap17 = encriptar.encriptar("López");
            ap18 = encriptar.encriptar("Ramírez");
            ap19 = encriptar.encriptar("García");
            ap20 = encriptar.encriptar("Hernández");
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, "Error al encriptar los apellidos paternos", ex);
        }

        try {
            am1 = encriptar.encriptar("Garcés");
            am2 = encriptar.encriptar("López");
            am3 = encriptar.encriptar("Martínez");
            am4 = encriptar.encriptar("Sánchez");
            am5 = encriptar.encriptar("Gómez");
            am6 = encriptar.encriptar("Hernández");
            am7 = encriptar.encriptar("Rodríguez");
            am8 = encriptar.encriptar("Pérez");
            am9 = encriptar.encriptar("Hernández");
            am10 = encriptar.encriptar("Martínez");
            am11 = encriptar.encriptar("Hernández");
            am12 = encriptar.encriptar("Sánchez");
            am13 = encriptar.encriptar("Gómez");
            am14 = encriptar.encriptar("Hernández");
            am15 = encriptar.encriptar("López");
            am16 = encriptar.encriptar("Martínez");
            am17 = encriptar.encriptar("González");
            am18 = encriptar.encriptar("Hernández");
            am19 = encriptar.encriptar("Gómez");
            am20 = encriptar.encriptar("López");
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, "Error al encriptar los apellidos maternos", ex);

        }

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(new Persona("GUGR040316E27", n1.getBytes(), ap1.getBytes(), am1.getBytes(), new GregorianCalendar(2004, 2, 21), t1.getBytes(), false));
            entityManager.persist(new Persona("ASDF123456A78", n2.getBytes(), ap2.getBytes(), am2.getBytes(), new GregorianCalendar(1995, 5, 15), t2.getBytes(), false));
            entityManager.persist(new Persona("ZXCV987654Z32", n3.getBytes(), ap3.getBytes(), am3.getBytes(), new GregorianCalendar(1988, 9, 3), t3.getBytes(), true));
            entityManager.persist(new Persona("QWER456789Q01", n4.getBytes(), ap4.getBytes(), am4.getBytes(), new GregorianCalendar(1976, 11, 28), t4.getBytes(), false));
            entityManager.persist(new Persona("POIU987654P32", n5.getBytes(), ap5.getBytes(), am5.getBytes(), new GregorianCalendar(2000, 3, 7), t5.getBytes(), true));
            entityManager.persist(new Persona("MNBV456789M12", n6.getBytes(), ap6.getBytes(), am6.getBytes(), new GregorianCalendar(1983, 7, 19), t6.getBytes(), false));
            entityManager.persist(new Persona("LKJH654321L78", n7.getBytes(), ap7.getBytes(), am7.getBytes(), new GregorianCalendar(1992, 1, 9), t7.getBytes(), true));
            entityManager.persist(new Persona("YREW987654Y09", n8.getBytes(), ap8.getBytes(), am8.getBytes(), new GregorianCalendar(1979, 10, 4), t8.getBytes(), false));
            entityManager.persist(new Persona("ZXCV123456Z45", n9.getBytes(), ap9.getBytes(), am9.getBytes(), new GregorianCalendar(1998, 8, 22), t9.getBytes(), true));
            entityManager.persist(new Persona("POIU567890P09", n10.getBytes(), ap10.getBytes(), am10.getBytes(), new GregorianCalendar(1985, 6, 17), t10.getBytes(), false));
            entityManager.persist(new Persona("ASDF456789A89", n11.getBytes(), ap11.getBytes(), am11.getBytes(), new GregorianCalendar(1993, 4, 12), t11.getBytes(), true));
            entityManager.persist(new Persona("MNBV123456M23", n12.getBytes(), ap12.getBytes(), am12.getBytes(), new GregorianCalendar(1974, 2, 9), t12.getBytes(), false));
            entityManager.persist(new Persona("LKJH789012L67", n13.getBytes(), ap13.getBytes(), am13.getBytes(), new GregorianCalendar(2001, 11, 30), t13.getBytes(), true));
            entityManager.persist(new Persona("QWER654321Q56", n14.getBytes(), ap14.getBytes(), am14.getBytes(), new GregorianCalendar(1987, 10, 5), t14.getBytes(), false));
            entityManager.persist(new Persona("ZXCV234567Z90", n15.getBytes(), ap15.getBytes(), am15.getBytes(), new GregorianCalendar(1996, 5, 18), t15.getBytes(), true));
            entityManager.persist(new Persona("LKJH098765L45", n16.getBytes(), ap16.getBytes(), am16.getBytes(), new GregorianCalendar(1981, 8, 12), t16.getBytes(), false));
            entityManager.persist(new Persona("POIU234567P78", n17.getBytes(), ap17.getBytes(), am17.getBytes(), new GregorianCalendar(1999, 4, 25), t17.getBytes(), true));
            entityManager.persist(new Persona("ASDF789012A34", n18.getBytes(), ap18.getBytes(), am18.getBytes(), new GregorianCalendar(1977, 7, 8), t18.getBytes(), false));
            entityManager.persist(new Persona("MNBV789012M56", n19.getBytes(), ap19.getBytes(), am19.getBytes(), new GregorianCalendar(1989, 3, 14), t19.getBytes(), true));
            entityManager.persist(new Persona("QWER123456Q23", n20.getBytes(), ap20.getBytes(), am20.getBytes(), new GregorianCalendar(1980, 1, 29), t20.getBytes(), false));

            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó la lista de personas correctamente");
        } catch (Exception e) {
            throw new PersistenciaException("No se pudieron registrar las personas en la BD.");
        } finally {
            entityManager.close();
        }
    }

    /**
     * Método que permite buscar un persona según su RFC.
     *
     * @param rfc RFC de la persona a buscar.
     * @return Objeto persona con todos sus atributos.
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    @Override
    public Persona obtenerPersonaRFC(String rfc) throws PersistenciaException {
        try {
            EntityManager entityManager = conexion.crearConexion();
            entityManager.getTransaction().begin();

            Persona personaObtenida = entityManager.find(Persona.class, rfc);

            entityManager.close();
            return personaObtenida;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener la persona");
            throw new PersistenciaException("No se pudo obtener a la persona.");
        }
    }

    /**
     * Método que nos permite buscar un lista de personas que cumplan con el
     * filtro dato en el parámetro.
     *
     * @param filtroPersonas Filtro con los atributos por los que será buscado.
     * @return Una lista de persona que cumplan con los parámetros del filtro.
     * @throws PersistenciaException Si ocurre un error al intentar agregar a la
     * persona.
     */
    @Override
    public List<Persona> buscarPersona(FiltroPersonas filtroPersonas) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        String jpqlQuery = """
                  SELECT p
                  FROM Persona p
                  WHERE (:nombre IS NULL OR CONCAT(p.nombres , ' ', p.apellidoPaterno, ' ', p.apellidoMaterno) LIKE :nombre)
                  AND (:rfc IS NULL OR p.rfc LIKE :rfc)
                  AND (:fechaNacimiento IS NULL OR p.fechaNacimiento = :fechaNacimiento)
                  """;

        TypedQuery<Persona> query = entityManager.createQuery(jpqlQuery, Persona.class);

        if (filtroPersonas.getNombre() != null) {
            query.setParameter("nombre", "%" + filtroPersonas.getNombre() + "%");
        } else {
            query.setParameter("nombre", null);
        }

        if (filtroPersonas.getRfc() != null) {
            query.setParameter("rfc", "%" + filtroPersonas.getRfc() + "%");
        } else {
            query.setParameter("rfc", null);
        }

        if (filtroPersonas.getFechaNacimiento() != null) {
            query.setParameter("fechaNacimiento", filtroPersonas.getFechaNacimiento());
        } else {
            query.setParameter("fechaNacimiento", null);
        }

        List<Persona> personas = query.getResultList();
        logger.log(Level.INFO, "Se consultó la lista de personas correctamente");
        return personas;
    }
}
