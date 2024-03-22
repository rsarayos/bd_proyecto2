/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public class pruebasNegocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Calendar fechaTramite = Calendar.getInstance();
        fechaTramite.setTime(new Date());
        
        Calendar fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.add(Calendar.YEAR, 1);
        
        PersonaNuevaDTO personaNueva = new PersonaNuevaDTO("ASDF123456A78");
        
        LicenciaNuevaDTO licenciaNueva = new LicenciaNuevaDTO(fechaVencimiento, 
                fechaTramite, 
                800F, 
                personaNueva, 
                true);
        
        IRegistroLicenciaBO registro = new RegistroLicenciaBO();
        
        try {
            registro.tramitarLicencia(licenciaNueva);
        } catch (NegociosException ex) {
            Logger.getLogger(pruebasNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
