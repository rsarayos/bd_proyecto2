package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Frame;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.agencia_fiscal_bos.GeneradorReportesBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IGeneradorReportesBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroReportesDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.TramiteReporteDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * Clase que representa la ventana para generar reportes de búsqueda de trámites.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class PantallaReporteBusqueda extends javax.swing.JDialog {

    /**
     * Creates new form PantallaReporteBusqueda
     *
     * @param parent Componente padre de la ventana.
     * @param modal Indicador de modalidad de la ventana.
     */
    public PantallaReporteBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.generadorReportes = new GeneradorReportesBO();
        dtpFechaInicial.setEnabled(false);
        dtpFechaFinal.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblInstrucciones = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblFechaFinal = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblFiltrar = new javax.swing.JLabel();
        lblFechaInicial = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cbxLicencias = new javax.swing.JCheckBox();
        cbxPlacas = new javax.swing.JCheckBox();
        cbxPeriodo = new javax.swing.JCheckBox();
        dtpFechaInicial = new com.github.lgooddatepicker.components.DateTimePicker();
        dtpFechaFinal = new com.github.lgooddatepicker.components.DateTimePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));

        jPanel2.setBackground(new java.awt.Color(119, 119, 119));

        lblTitulo.setText("MÓDULO DE REPORTES");
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 43)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(17, 17, 17))
        );

        lblInstrucciones.setText("INGRESE ALGÚN CAMPO SI DESEA FILTRAR LOS TRÁMITES");
        lblInstrucciones.setFont(new java.awt.Font("Arial", 1, 27)); // NOI18N
        lblInstrucciones.setForeground(new java.awt.Color(119, 119, 119));

        btnCancelar.setText("CANCELAR");
        btnCancelar.setBackground(new java.awt.Color(159, 34, 65));
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblFechaFinal.setText("FECHA FINAL DEL PERIODO");
        lblFechaFinal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFechaFinal.setForeground(new java.awt.Color(119, 119, 119));

        txtNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(119, 119, 119));

        lblNombre1.setText("CONTRIBUYENTE:");
        lblNombre1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        lblFiltrar.setText("FILTRAR TRÁMITES POR:");
        lblFiltrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        lblFechaInicial.setText("FECHA INICIAL DEL PERIODO");
        lblFechaInicial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFechaInicial.setForeground(new java.awt.Color(119, 119, 119));

        btnBuscar.setText("BUSCAR");
        btnBuscar.setBackground(new java.awt.Color(159, 34, 65));
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxLicencias.setText("LICENCIAS");
        cbxLicencias.setBackground(new java.awt.Color(223, 223, 223));
        cbxLicencias.setFocusPainted(false);
        cbxLicencias.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        cbxPlacas.setText("PLACAS");
        cbxPlacas.setBackground(new java.awt.Color(223, 223, 223));
        cbxPlacas.setFocusPainted(false);
        cbxPlacas.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        cbxPeriodo.setText("PERIODO");
        cbxPeriodo.setBackground(new java.awt.Color(223, 223, 223));
        cbxPeriodo.setFocusPainted(false);
        cbxPeriodo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        cbxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPeriodoActionPerformed(evt);
            }
        });

        dtpFechaInicial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        dtpFechaFinal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblInstrucciones)
                .addGap(153, 153, 153))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(92, 127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxLicencias)
                        .addGap(50, 50, 50)
                        .addComponent(cbxPlacas)
                        .addGap(50, 50, 50)
                        .addComponent(cbxPeriodo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblFechaInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFechaFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lblInstrucciones)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltrar)
                    .addComponent(cbxLicencias)
                    .addComponent(cbxPlacas)
                    .addComponent(cbxPeriodo))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaInicial)
                    .addComponent(lblFechaFinal)
                    .addComponent(dtpFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana actual.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Realiza la búsqueda de trámites según el filtro seleccionado y muestra los resultados en una nueva ventana.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        FiltroReportesDTO filtro = crearFiltro();
        List<TramiteReporteDTO> listaReporte;
        if (filtro != null) {
            try {
                listaReporte = generadorReportes.obtenerTramites(filtro);
                PantallaReporteResultado pReporteResultado = new PantallaReporteResultado(parent, true, listaReporte);
                pReporteResultado.setVisible(true);
            } catch (NegociosException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo generar el reporte.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Habilita o deshabilita los campos de selección de fecha dependiendo del estado del checkbox de periodo.
     *
     * @param evt Evento de cambio de estado del checkbox.
     */
    private void cbxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPeriodoActionPerformed
        if (cbxPeriodo.isSelected()) {
            dtpFechaInicial.setEnabled(true);
            dtpFechaFinal.setEnabled(true);
        } else if (!cbxPeriodo.isSelected()) {
            dtpFechaInicial.setEnabled(false);
            dtpFechaFinal.setEnabled(false);
        }
    }//GEN-LAST:event_cbxPeriodoActionPerformed

    /**
     * Crea un filtro basado en los campos de búsqueda proporcionados por el usuario.
     *
     * @return El filtro creado para la búsqueda de trámites.
     */
    private FiltroReportesDTO crearFiltro() {
        FiltroReportesDTO filtro = new FiltroReportesDTO();
        if (!txtNombre.getText().isBlank()) {
            filtro.setNombreContribuyente(txtNombre.getText());
        }
        if (cbxLicencias.isSelected() && !cbxPlacas.isSelected()) {
            filtro.setTipoTramites("Licencia");
        } else if (cbxPlacas.isSelected() && !cbxLicencias.isSelected()) {
            filtro.setTipoTramites("Placa");
        }
        if (cbxPeriodo.isSelected()) {
            if (dtpFechaInicial.getDateTimePermissive() != null && dtpFechaFinal.getDateTimePermissive()!= null) {
                GregorianCalendar fechaInicial = new GregorianCalendar(dtpFechaInicial.getDateTimePermissive().getYear(), dtpFechaInicial.getDateTimePermissive().getMonthValue() - 1, dtpFechaInicial.getDateTimePermissive().getDayOfMonth(), dtpFechaInicial.getDateTimePermissive().getHour(), dtpFechaInicial.getDateTimePermissive().getMinute());
                GregorianCalendar fechaFinal = new GregorianCalendar(dtpFechaFinal.getDateTimePermissive().getYear(), dtpFechaFinal.getDateTimePermissive().getMonthValue() - 1, dtpFechaFinal.getDateTimePermissive().getDayOfMonth(), dtpFechaFinal.getDateTimePermissive().getHour(), dtpFechaFinal.getDateTimePermissive().getMinute());
                if (fechaInicial.before(fechaFinal)) {
                    filtro.setFechaInicial(fechaInicial);
                    filtro.setFechaFinal(fechaFinal);
                } else {
                    JOptionPane.showMessageDialog(this, "Asegúrese de ingresar un periodo válido.");
                    filtro = null;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Asegúrese de ingresar ambas fechas para el periodo.");
                filtro = null;
            }
        }
        return filtro;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox cbxLicencias;
    private javax.swing.JCheckBox cbxPeriodo;
    private javax.swing.JCheckBox cbxPlacas;
    private com.github.lgooddatepicker.components.DateTimePicker dtpFechaFinal;
    private com.github.lgooddatepicker.components.DateTimePicker dtpFechaInicial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFechaFinal;
    private javax.swing.JLabel lblFechaInicial;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblInstrucciones;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private IGeneradorReportesBO generadorReportes;
    private Frame parent;
}
