/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.bdavanzadas.agencia_fiscal_dominio.Automovil;
import org.itson.bdavanzadas.agencia_fiscal_dominio.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_dominio.Persona;
import org.itson.bdavanzadas.agencia_fiscal_dominio.Placa;
import org.itson.bdavanzadas.agencia_fiscal_dominio.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_dominio.Vehiculo;

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

        Persona persona = new Persona(
            "RFC1234567890", // RFC
            "Juan",          // Nombres
            "Pérez",         // Apellido Paterno
            "Gómez",         // Apellido Materno
            fechaNacimiento, // Fecha de Nacimiento
            "1234567",    // Teléfono
            "CURP12367890",// CURP
            false            // isDiscapacitado
        );
        
        Vehiculo vehiculo = new Automovil("12345678901234567", "Rojo", "Civic", "Sedán", "Honda", true, persona);
        
        Tramite tramite = new Licencia(fechaVencimiento, fechaTramite, 100.0f, persona);
        Tramite tramite2 = new Placa("ABC123", fechaRecepcion, true, fechaTramite, 100.0f, persona);
        
        List<Vehiculo> vehiculos = new LinkedList<>();
        List<Tramite> tramites = new LinkedList<>();
        vehiculos.add(vehiculo);
        tramites.add(tramite);
        tramites.add(tramite2);
        
        persona.setVehiculos(vehiculos);
        persona.setTramites(tramites);
        
        entityManager.persist(persona);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
}
