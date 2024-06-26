package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Font;
import java.awt.Frame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.itson.bdavanzadas.agencia_fiscal_bos.GestorVehiculosBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IGestorVehiculosBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroPersonasBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroPlacaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPersonasBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPlacaBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_presentacion.validadores.Validadores;

/**
 * Clase que representa la pantalla de búsqueda de vehículos.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class PantallaBusquedaVehiculos extends javax.swing.JDialog {

    /**
     * Creates new form PantallaBusquedaVehiculos
     *
     * @param parent
     * @param modal
     */
    public PantallaBusquedaVehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.registroPersona = new RegistroPersonasBO();
        this.registroLicencia = new RegistroLicenciaBO();
        this.registroPlaca = new RegistroPlacaBO();
        this.gestorVehiculo = new GestorVehiculosBO();
        this.validador = new Validadores();
    }

    /**
     * Permite saber si el contribuyente cuenta con una licencia activa o no.
     *
     * @return true si el contribuyente tiene una licencia activa, false en caso
     * contrario
     */
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

    /**
     * Permite llenar la tabla con los vehículos consultados mediante el RFC de
     * la persona.
     *
     * @param vehiculos La lista de vehículos consultados
     */
    private void llenarTablaPersona(List<VehiculoNuevoDTO> vehiculos) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1; // Solo la última columna es editable
            }
        };
        modelo.addColumn("NO. SERIE");
        modelo.addColumn("MARCA");
        modelo.addColumn("LINEA");
        modelo.addColumn("COLOR");
        modelo.addColumn("MODELO");
        modelo.addColumn("");

        for (VehiculoNuevoDTO vehiculo : vehiculos) {

            Object[] fila = {vehiculo.getNumeroSerie(), vehiculo.getMarca(), vehiculo.getLinea(), vehiculo.getColor(), vehiculo.getModelo(), "SELECCIONAR"};
            modelo.addRow(fila);
        }
        tblVehiculos.setModel(modelo);
        ButtonColumn buttonColumn = new ButtonColumn("SELECCIONAR", (e) -> {
            int fila = tblVehiculos.convertRowIndexToModel(tblVehiculos.getSelectedRow());
            VehiculoNuevoDTO vehiculo = vehiculos.get(fila);

            if (isLicenciaActiva()) {
                PantallaPlacasVehiculo pPlacasVehiculo = new PantallaPlacasVehiculo(parent, true, vehiculo);
                pPlacasVehiculo.setVisible(true);

            }
        });
        tblVehiculos.getColumnModel().getColumn(tblVehiculos.getColumnCount() - 1).setCellRenderer(buttonColumn);
        tblVehiculos.getColumnModel().getColumn(tblVehiculos.getColumnCount() - 1).setCellEditor(buttonColumn);
    }

    /**
     * Permite llenar la tabla con el vehículo consultado mediante el número de
     * placa.
     *
     * @param vehiculos La lista de vehículos consultados
     */
    private void llenarTablaPlaca(VehiculoNuevoDTO vehiculo) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1; // Solo la última columna es editable
            }
        };
        modelo.addColumn("NO. SERIE");
        modelo.addColumn("MARCA");
        modelo.addColumn("LINEA");
        modelo.addColumn("COLOR");
        modelo.addColumn("MODELO");
        modelo.addColumn("");

        Object[] fila = {vehiculo.getNumeroSerie(), vehiculo.getMarca(), vehiculo.getLinea(), vehiculo.getColor(), vehiculo.getModelo(), "SELECCIONAR"};
        modelo.addRow(fila);

        tblVehiculos.setModel(modelo);
        ButtonColumn buttonColumn = new ButtonColumn("SELECCIONAR", (e) -> {
            if (isLicenciaActiva()) {
                PantallaPlacasVehiculo pPlacasVehiculo = new PantallaPlacasVehiculo(parent, true, vehiculo);
                pPlacasVehiculo.setVisible(true);

            }
        });
        tblVehiculos.getColumnModel().getColumn(tblVehiculos.getColumnCount() - 1).setCellRenderer(buttonColumn);
        tblVehiculos.getColumnModel().getColumn(tblVehiculos.getColumnCount() - 1).setCellEditor(buttonColumn);
        tblVehiculos.setDefaultEditor(Object.class, null);
        tblVehiculos.getTableHeader().setResizingAllowed(false);
        JTableHeader header = tblVehiculos.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
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
        tblVehiculos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnAgregarVehiculo = new javax.swing.JButton();
        lblInstrucciones1 = new javax.swing.JLabel();
        lblRFC1 = new javax.swing.JLabel();
        txtNoPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar vehiculo");

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

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
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblInstrucciones.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInstrucciones.setForeground(new java.awt.Color(119, 119, 119));
        lblInstrucciones.setText("<html><p>INGRESE EL NÚMERO DE PLACA PARA BUSCAR <br> EL VEHÍCULO DEL CONTRIBUYENTE<p></html>");

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

        tblVehiculos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVehiculos);

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

        lblInstrucciones1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInstrucciones1.setForeground(new java.awt.Color(119, 119, 119));
        lblInstrucciones1.setText("<html><p>INGRESE EL RFC PARA BUSCAR EL <br> VEHÍCULO DEL CONTRIBUYENTE<p></html>");

        lblRFC1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC1.setText("NO. PLACA:");

        txtNoPlaca.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNoPlaca.setForeground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(508, 508, 508)
                        .addComponent(btnAgregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstrucciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRFC)
                                .addGap(18, 18, 18)
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblRFC1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstrucciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblRFC))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRFC1))
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al presionar el botón de cancelar.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Acción realizada al presionar el botón de buscar.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String rfc = txtRFC.getText();
        String noPlaca = txtNoPlaca.getText();

        if (validador.validaRfc(rfc)) {
            try {
                persona = registroPersona.buscarPersona(rfc);
                if (persona != null) {
                    List<VehiculoNuevoDTO> vehiculos = gestorVehiculo.obtenerVehiculos(persona);
                    llenarTablaPersona(vehiculos);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontro ningun contribuyente con el RFC",
                            "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NegociosException ex) {
                JOptionPane.showMessageDialog(this, "El RFC no pertenece a ninguna persona",
                        "Error", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.SEVERE, ex.getMessage());
            }
        } else if (validador.validaNoPlaca(noPlaca)) {
            try {
                PlacaNuevaDTO placa = registroPlaca.buscarPlaca(noPlaca);
                if (placa != null) {
                    VehiculoNuevoDTO vehiculoBuscado = gestorVehiculo.buscarVehiculo(noPlaca);
                    persona = registroPersona.buscarPersona(vehiculoBuscado.getPersona().getRfc());
                    llenarTablaPlaca(vehiculoBuscado);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontro ninguna placa con el numero",
                            "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NegociosException ex) {
                logger.log(Level.SEVERE, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese el campo correctamente",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Acción realizada al presionar el botón de agregar vehículo.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculoActionPerformed
        PantallaAgregarVehiculo pAgregarVehiculo = new PantallaAgregarVehiculo(parent, true);
        pAgregarVehiculo.setVisible(true);
    }//GEN-LAST:event_btnAgregarVehiculoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarVehiculo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInstrucciones;
    private javax.swing.JLabel lblInstrucciones1;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblRFC1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtNoPlaca;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
    private IRegistroPersonasBO registroPersona;
    private IRegistroLicenciaBO registroLicencia;
    private IRegistroPlacaBO registroPlaca;
    private IGestorVehiculosBO gestorVehiculo;
    private PersonaNuevaDTO persona;
    private Validadores validador;
    private Frame parent;
    static final Logger logger = Logger.getLogger(PantallaBusquedaVehiculos.class.getName());
}
