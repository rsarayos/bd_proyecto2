package pruebas;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroPersonas;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.ILicenciaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.LicenciaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 *
 * @author alex_
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("fiscalPU");
//        // solicitamos una entity manager (acceso a la bd)
        EntityManager entityManager = emFactory.createEntityManager();
//        
        entityManager.getTransaction().begin();
////        
//        
////        
////        entityManager.close();
//        
//        String jpqlUpdate = "UPDATE Licencia l SET l.estado = false WHERE l.id = :licenciaId";
//        Query queryUpdate = entityManager.createQuery(jpqlUpdate);
//        queryUpdate.setParameter("licenciaId", 1L);
//        int updatedCount = queryUpdate.executeUpdate();
//
//        if (updatedCount > 0) {
//            // Se actualizaron licencias, ahora recuperamos las licencias modificadas.
//            String jpqlSelect = "SELECT l FROM Licencia l WHERE l.id = :licenciaId";
//            Query querySelect = entityManager.createQuery(jpqlSelect);
//            querySelect.setParameter("licenciaId", 1L);
//            List<Licencia> licenciasModificadas = querySelect.getResultList();
//
//            // Aquí tienes la lista de licencias modificadas
//            for (Licencia licencia : licenciasModificadas) {
//                System.out.println(licencia.getEstado());
//            }
//        } else {
//            System.out.println("No se encontró ninguna licencia con el ID proporcionado.");
//        }
//        
//        entityManager.close();

//        Calendar fechaNacimiento = Calendar.getInstance();
//        fechaNacimiento.set(1990, Calendar.JANUARY, 1);
//        
//        Calendar fechaVencimiento = Calendar.getInstance();
//        fechaVencimiento.add(Calendar.YEAR, 1);
//        
//        Calendar fechaTramite = Calendar.getInstance();
//        fechaTramite.setTime(new Date());
//        
//        Calendar fechaRecepcion = Calendar.getInstance();
//        fechaRecepcion.setTime(new Date());
//        
//        Encriptar encriptar = new Encriptar();
//        
//        // encriptacion
//        String telefono = null;
//        try {
//            telefono = encriptar.encriptar("1234567");
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Persona persona = new Persona(
//            "RFC1234567890", // RFC
//            "Juan",          // Nombres
//            "Pérez",         // Apellido Paterno
//            "Gómez",         // Apellido Materno
//            fechaNacimiento, // Fecha de Nacimiento
//            // se pasan los bytes
//            telefono.getBytes(),    // Teléfono
//            "CURP12367890",// CURP
//            false            // isDiscapacitado
//        );
//        
//        Vehiculo vehiculo = new Automovil("12345678901234567", "Rojo", "Civic", "Sedán", "Honda", true, persona);
//        
//        Licencia tramite = new Licencia(fechaVencimiento, fechaTramite, 100.0f, persona, true);
//        Licencia tramite3 = new Licencia(fechaVencimiento, fechaTramite, 250.0f, persona, true);
//        Placa tramite2 = new Placa("ABC123", fechaRecepcion, true, fechaTramite, 100.0f, persona);
//        Placa tramite4 = new Placa("ABC123", fechaRecepcion, true, fechaTramite, 150.0f, persona);
//        
//        Licencia tramite6 = new Licencia(fechaVencimiento, fechaTramite, 45.0f, persona, true);
//        
//        
//        List<Vehiculo> vehiculos = new LinkedList<>();
//        List<Tramite> tramites = new LinkedList<>();
//        vehiculos.add(vehiculo);
//        tramites.add(tramite);
//        tramites.add(tramite2);
//        tramites.add(tramite3);
//        tramites.add(tramite4);
//        
//        persona.setVehiculos(vehiculos);
//        persona.setTramites(tramites);
//        
//        // para desencriptar
//        String telefonoEncriptado = new String(persona.getTelefono());
//        String telefonoDes = null;
//        try {
//            telefonoDes = encriptar.desencriptar(telefonoEncriptado);
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        System.out.println("El telefono es:" + telefonoDes);
//        
//        
//        entityManager.persist(persona);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        
//        // prueba para consultar tipo de tramite (por licencia)
//        
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
//        Root<Licencia> root = criteria.from(Licencia.class);
//        criteria.select(root).where(
//                builder.and(
//                        builder.equal(root.type(), Licencia.class),
//                        builder.like(root.get("persona").get("rfc"), persona.getRfc())
//                )
//        );
//        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
//        List<Licencia> licencias = query.getResultList();
//        
//        entityManager.close();
//        
//        for (Tramite mite : licencias) {
//            System.out.println(mite.toString());
//        }
        IConexion conexion = new Conexion();

        IPersonaDAO personaDAO = new PersonaDAO(conexion);
        ILicenciaDAO licenciaDAO = new LicenciaDAO(conexion);

        FiltroPersonas filtro = new FiltroPersonas();
        filtro.setNombre("Ricardo");
        filtro.setRfc("");
//        filtro.setFechaNacimiento(new GregorianCalendar(2004,02,21));
        filtro.setFechaNacimiento(null);
        
        List<Persona> listaPersonas = null;
        try {
            listaPersonas = personaDAO.buscarPersona(filtro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Persona listaPersona : listaPersonas) {
            System.out.println(listaPersona);
        }
//
//        Calendar fechaVencimiento = Calendar.getInstance();
//        fechaVencimiento.add(Calendar.YEAR, 1);
//        Calendar fechaTramite = Calendar.getInstance();
//        fechaTramite.setTime(new Date());
//
//        Persona persona = entityManager.find(Persona.class, new String("GUGR040316E27"));
//
//        Licencia licencia = new Licencia(fechaVencimiento, fechaTramite, 100.0f, persona, true);
//
//        try {
//            List<Licencia> licencias = licenciaDAO.obtenerLicencias(persona);
//            for (Licencia lic : licencias) {
//                System.out.println(lic.getEstado());
//            }
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    }
}
