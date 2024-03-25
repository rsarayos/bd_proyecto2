package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPersonaBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author victo
 */
public class PantallaBusquedaVehiculos extends javax.swing.JDialog {

    private RegistroPersonaBO registroPersona;
    private RegistroLicenciaBO registroLicencia;
    private PersonaNuevaDTO persona = null;
    static final Logger logger = Logger.getLogger(PantallaBusquedaVehiculos.class.getName());

    /**
     * Creates new form PantallaBusquedaVehiculos
     */
    public PantallaBusquedaVehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.registroPersona = new RegistroPersonaBO();
        this.registroLicencia = new RegistroLicenciaBO();
    }

    private Boolean isLicenciaActiva() {
        List<LicenciaNuevaDTO> licencias = null;
        try {
            licencias = registroLicencia.obtenerLicencias(persona);
        } catch (NegociosException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        if (licencias != null && !licencias.isEmpty()) {
            LicenciaNuevaDTO ultimaLicencia = licencias.get(licencias.size() - 1);
            return ultimaLicencia.getEstado();
        } else {
            JOptionPane.showMessageDialog(this, "El contribuyente no cuenta con una licencia activa",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void llenarTabla(List<PersonaNuevaDTO> personas) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1; // Solo la última columna es editable
            }
        };
        modelo.addColumn("NO. SERIE");
        modelo.addColumn("COLOR");
        modelo.addColumn("MODELO");
        modelo.addColumn("LINEA");
        modelo.addColumn("MARCA");
        modelo.addColumn("");

        // Agregar los socios al modelo de la tabla
        for (PersonaNuevaDTO persona : personas) {

            String fechaNacimiento = persona.getFechaNacimiento().get(Calendar.DAY_OF_MONTH) + "/" + (persona.getFechaNacimiento().get(Calendar.MONTH) + 1) + "/" + persona.getFechaNacimiento().get(Calendar.YEAR);

            Object[] fila = {persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(), fechaNacimiento, persona.getRfc(), persona.isDiscapacitado() ? "Discapacitado" : "No discapacitado", "SELECCIONAR"};
            modelo.addRow(fila);
        }
        tblContribuyentes.setModel(modelo);
        ButtonColumn buttonColumn = new ButtonColumn("SELECCIONAR", (e) -> {
            int fila = tblContribuyentes.convertRowIndexToModel(tblContribuyentes.getSelectedRow());
            PersonaNuevaDTO persona = personas.get(fila);

            if (isLicenciaActiva()) {
//                PantallaTiposLicencias pTiposLicencias = new PantallaTiposLicencias(parent, true, persona);
//                pTiposLicencias.setVisible(true);
            }
        });
        tblContribuyentes.getColumnModel().getColumn(tblContribuyentes.getColumnCount() - 1).setCellRenderer(buttonColumn);
        tblContribuyentes.getColumnModel().getColumn(tblContribuyentes.getColumnCount() - 1).setCellEditor(buttonColumn);
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
        lblRFC = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContribuyentes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnAgregarVehiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));

        jPanel2.setBackground(new java.awt.Color(119, 119, 119));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 43)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("MÓDULO DE PLACAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblInstrucciones.setFont(new java.awt.Font("Arial", 1, 27)); // NOI18N
        lblInstrucciones.setForeground(new java.awt.Color(119, 119, 119));
        lblInstrucciones.setText("INGRESE EL RFC PARA BUSCAR EL VEHÍCULO DEL CONTRIBUYENTE");

        btnCancelar.setBackground(new java.awt.Color(159, 34, 65));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC.setText("RFC:");

        txtRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtRFC.setForeground(new java.awt.Color(119, 119, 119));

        tblContribuyentes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblContribuyentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblContribuyentes);

        btnBuscar.setBackground(new java.awt.Color(159, 34, 65));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregarVehiculo.setBackground(new java.awt.Color(159, 34, 65));
        btnAgregarVehiculo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnAgregarVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarVehiculo.setText("AGREGAR VEHICULO");
        btnAgregarVehiculo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarVehiculo.setFocusPainted(false);
        btnAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRFC)
                .addGap(18, 18, 18)
                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInstrucciones)
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblInstrucciones)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRFC)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String rfc = txtRFC.getText();
        try {
            persona = registroPersona.buscarPersona(rfc);
        } catch (NegociosException ex) {
            JOptionPane.showMessageDialog(this, "El RFC no pertenece a ninguna persona",
                    "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, ex.getMessage());
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculoActionPerformed
        if (isLicenciaActiva()) {
            //Pantalla agregar vehículo
        }

    }//GEN-LAST:event_btnAgregarVehiculoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarVehiculo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInstrucciones;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblContribuyentes;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}