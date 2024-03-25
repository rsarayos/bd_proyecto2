package pruebas;

import java.util.Calendar;
import java.util.Date;

public class pruebasNegocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Calendar fechaTramite = Calendar.getInstance();
        fechaTramite.setTime(new Date());
        
//        Calendar fechaVencimiento = Calendar.getInstance();
//        fechaVencimiento.add(Calendar.YEAR, 1);
//        
//        PersonaNuevaDTO personaNueva = new PersonaNuevaDTO("ASDF123456A78");
//        
//        LicenciaNuevaDTO licenciaNueva = new LicenciaNuevaDTO(fechaVencimiento, 
//                fechaTramite, 
//                800F, 
//                personaNueva, 
//                true);
//        
//        
//        IRegistroLicenciaBO registro = new RegistroLicenciaBO();
//        
//        try {
//            registro.tramitarLicencia(licenciaNueva);
////            System.out.println(licN.toString());
//        } catch (NegociosException ex) {
//            Logger.getLogger(pruebasNegocio.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        IRegistroPlacaBO registro = new RegistroPlacaBO();
//        
//        PlacaNuevaDTO placaNueva = new PlacaNuevaDTO(true, 
//                new VehiculoNuevoDTO("abc"),
//                fechaTramite,
//                1000f, 
//                new PersonaNuevaDTO("ASDF123456A78")
//        );
//        
//        try {
//            registro.tramitarPlaca(placaNueva);
//        } catch (NegociosException ex) {
//            Logger.getLogger(pruebasNegocio.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
