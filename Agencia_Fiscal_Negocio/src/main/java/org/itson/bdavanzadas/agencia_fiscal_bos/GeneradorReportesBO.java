package org.itson.bdavanzadas.agencia_fiscal_bos;

import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import java.io.File;
import java.io.FileInputStream;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroReportes;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.ITramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.TramitesDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroReportesDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.TramiteReporteDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 * La clase GeneradorReportesBO implementa la interfaz IGeneradorReportesBO y define
 * la lógica de negocio para la generación de reportes de trámites.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class GeneradorReportesBO implements IGeneradorReportesBO {

    private IConexion conexion;
    private ITramitesDAO tramitesDAO;
    static final Logger logger = Logger.getLogger(GeneradorReportesBO.class.getName());

    /**
     * Constructor que permite establecer conexión al mecanismo de persistencia.
     */
    public GeneradorReportesBO() {
        this.conexion = new Conexion();
        tramitesDAO = new TramitesDAO(conexion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TramiteReporteDTO> obtenerTramites(FiltroReportesDTO filtro) throws NegociosException {
        List<TramiteReporteDTO> listTramites = new ArrayList<>();
        FiltroReportes filtroReportes = new FiltroReportes();
        filtroReportes.setNombreContribuyente(filtro.getNombreContribuyente());
        filtroReportes.setFechaInicial(filtro.getFechaInicial());
        filtroReportes.setFechaFinal(filtro.getFechaFinal());
        filtroReportes.setTipoTramites(filtro.getTipoTramites());

        try {
            List<Tramite> tramitesBase = this.tramitesDAO.consultarTramites(filtroReportes);
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

                TramiteReporteDTO tramiteReporte = new TramiteReporteDTO(
                        fecha,
                        tipoTramite,
                        nombreCompletoStr,
                        tm.getCosto());

                if (filtro.getTipoTramites() != null) {
                    if (tramiteReporte.getTipo().equalsIgnoreCase(filtro.getTipoTramites())) {
                        listTramites.add(tramiteReporte);
                    }
                } else {
                    listTramites.add(tramiteReporte);
                }
            }
            logger.log(Level.INFO, "Se genero la lista de tramites");
            return listTramites;
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al generar la lista de tramites para reporte");
            throw new NegociosException("No se pudo obtener la lista de tramites");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void generarReporte(List<TramiteReporteDTO> listaTramites) throws NegociosException {
        // Crear un JRBeanCollectionDataSource con la lista de TramiteReporteDTO
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaTramites);
        // Parámetros para el reporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CollectionBeanParam", itemsJRBean);

        // Configuración del JFileChooser para seleccionar la ubicación y nombre del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        // Mostrar el diálogo para guardar el archivo
        int userSelection = fileChooser.showSaveDialog(null);

        // Si el usuario selecciona guardar
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Asegurar que la extensión del archivo sea .pdf
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Cargar el diseño del reporte desde el archivo "Tramites.jrxml"
            try (InputStream input = new FileInputStream(new File("Tramites.jrxml"))) {
                JasperDesign jasperDesign = JRXmlLoader.load(input);
                // Compilar el reporte
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                // Llenar el reporte con los datos y parámetros proporcionados
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                // Exportar el reporte a un archivo PDF
                try (
                        OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                }

            } catch (Exception ex) {
                // Log y excepción en caso de error
                logger.log(Level.SEVERE, "Error al generar el reporte");
                throw new NegociosException("No se pudo generar el archivo PDF.");
            }
            // Log y mensaje de éxito
            logger.log(Level.INFO, "Archivo generado");
            JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            // Si el usuario cancela la operación
            logger.log(Level.INFO, "Usuario cancelo la operacion");
        }
    }

}
