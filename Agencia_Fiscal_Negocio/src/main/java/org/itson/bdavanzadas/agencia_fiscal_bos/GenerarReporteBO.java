package org.itson.bdavanzadas.agencia_fiscal_bos;

import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.ITramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PersonaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.TramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.ReporteTramiteDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
/**
 *
 * @author alex_
 */
public class GenerarReporteBO implements IGenerarReporteBO{
    
    private IConexion conexion;
    private ITramitesDAO tramitesDAO;
    static final Logger logger = Logger.getLogger(GenerarReporteBO.class.getName());

    public GenerarReporteBO() {
        this.conexion = new Conexion();
        tramitesDAO = new TramitesDAO(conexion);    
    }

    @Override
    public List<ReporteTramiteDTO> generarListaReporte() throws NegociosException {
        
        String outputFile = "Tramites.pdf";
        List<ReporteTramiteDTO> listTramites = new ArrayList<ReporteTramiteDTO>();
        
        try {
            List<Tramite> tramitesBase = this.tramitesDAO.consultarTodosLosTramites();
            for (Tramite tm : tramitesBase) {
                StringBuilder nombreCompleto = new StringBuilder();

                nombreCompleto.append(tm.getPersona().getNombres())
                        .append(" ")
                        .append(tm.getPersona().getApellidoPaterno())
                        .append(" ")
                        .append(tm.getPersona().getApellidoMaterno());

                String nombreCompletoStr = nombreCompleto.toString();
                
                String tipoTramite = null;
                if (tm instanceof Licencia) {
                    tipoTramite = "Licencia";
                } else if (tm instanceof Placa) {
                    tipoTramite = "Placa";
                }
                
                Date fecha = tm.getFechaTramite().getTime();

                ReporteTramiteDTO tramiteReporte = new ReporteTramiteDTO(
                        fecha, 
                        tipoTramite, 
                        nombreCompletoStr, 
                        tm.getCosto());
                
                listTramites.add(tramiteReporte);          
            }
            logger.log(Level.INFO, "Se genero la lista de tramites");
            return listTramites;
            
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al generar la lista de tramites para reporte");
            throw new NegociosException("No se pudo obtener la lista de tramites");
        }
        
    }

    @Override
    public void generarReporte(List<ReporteTramiteDTO> listaTramites) throws NegociosException {
        
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaTramites);
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("CollectionBeanParam", itemsJRBean);
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
        
        int userSelection = fileChooser.showSaveDialog(null);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            /* read jrxml file and creating jasperdesign object */
            try (InputStream input = new FileInputStream(new File("Tramites.jrxml"))) {
                JasperDesign jasperDesign = JRXmlLoader.load(input);
                
                /* compiling jrxml with help of JasperReport class */
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

                /* Using jasperReport object to generate PDF */
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
                
                try (OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                }
                
                /* call jasper engine to display report in jasperviewer window */
//                JasperViewer.viewReport(jasperPrint);
                
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Error al generar el reporte");
                JOptionPane.showMessageDialog(null, "Error al generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            System.out.println("File Generated");
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            System.out.println("Save command cancelled by user.");
        }
        
    }
    
}
