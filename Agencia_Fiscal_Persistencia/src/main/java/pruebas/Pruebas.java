package pruebas;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.Encriptar;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Automovil;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;

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
        // solicitamos una entity manager (acceso a la bd)
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(1990, Calendar.JANUARY, 1);
        
        Calendar fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.add(Calendar.YEAR, 1);
        
        Calendar fechaTramite = Calendar.getInstance();
        fechaTramite.setTime(new Date());
        
        Calendar fechaRecepcion = Calendar.getInstance();
        fechaRecepcion.setTime(new Date());
        
        Encriptar encriptar = new Encriptar();
        
        // encriptacion
        String telefono = null;
        try {
            telefono = encriptar.encriptar("1234567");
        } catch (Exception ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }

        Persona persona = new Persona(
            "RFC1234567890", // RFC
            "Juan",          // Nombres
            "Pérez",         // Apellido Paterno
            "Gómez",         // Apellido Materno
            fechaNacimiento, // Fecha de Nacimiento
            // se pasan los bytes
            telefono.getBytes(),    // Teléfono
            "CURP12367890",// CURP
            false            // isDiscapacitado
        );
        
        Vehiculo vehiculo = new Automovil("12345678901234567", "Rojo", "Civic", "Sedán", "Honda", true, persona);
        
        Licencia tramite = new Licencia(fechaVencimiento, fechaTramite, 100.0f, persona, true);
        Licencia tramite3 = new Licencia(fechaVencimiento, fechaTramite, 250.0f, persona, true);
        Placa tramite2 = new Placa("ABC123", fechaRecepcion, true, fechaTramite, 100.0f, persona);
        Placa tramite4 = new Placa("ABC123", fechaRecepcion, true, fechaTramite, 150.0f, persona);
        
        Licencia tramite6 = new Licencia(fechaVencimiento, fechaTramite, 45.0f, persona, true);
        
        
        List<Vehiculo> vehiculos = new LinkedList<>();
        List<Tramite> tramites = new LinkedList<>();
        vehiculos.add(vehiculo);
        tramites.add(tramite);
        tramites.add(tramite2);
        tramites.add(tramite3);
        tramites.add(tramite4);
        
        persona.setVehiculos(vehiculos);
        persona.setTramites(tramites);
        
        // para desencriptar
        String telefonoEncriptado = new String(persona.getTelefono());
        String telefonoDes = null;
        try {
            telefonoDes = encriptar.desencriptar(telefonoEncriptado);
        } catch (Exception ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("El telefono es:" + telefonoDes);
        
        
        entityManager.persist(persona);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        // prueba para consultar tipo de tramite (por licencia)
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
        Root<Licencia> root = criteria.from(Licencia.class);
        criteria.select(root).where(
                builder.and(
                        builder.equal(root.type(), Licencia.class),
                        builder.like(root.get("persona").get("rfc"), persona.getRfc())
                )
        );
        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
        List<Licencia> licencias = query.getResultList();
        
        entityManager.close();
//        
//        for (Tramite mite : licencias) {
//            System.out.println(mite.toString());
//        }
        
    }
    
}
