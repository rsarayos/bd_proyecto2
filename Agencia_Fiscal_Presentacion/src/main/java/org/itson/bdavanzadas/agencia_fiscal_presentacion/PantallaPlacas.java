package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Frame;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroPlacaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPlacaBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_negocioAux.GenerarNumeroPlaca;
import org.itson.bdavanzadas.agencia_fiscal_negocioAux.PreciosTramites;

/**
 *
 * @author victo
 */
public class PantallaPlacas extends javax.swing.JDialog {

    private VehiculoNuevoDTO vehiculo;
    private IRegistroPlacaBO registroPlaca;
    private Float costo;
    private Frame parent;

    /**
     * Creates new form PantallaPlacas
     */
    public PantallaPlacas(java.awt.Frame parent, boolean modal, VehiculoNuevoDTO vehiculo) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.vehiculo = vehiculo;
        this.registroPlaca = new RegistroPlacaBO();
        llenarDatosPlaca();
    }

    private void llenarDatosPlaca() {

        List<PlacaNuevaDTO> placas = new LinkedList<>();
        try {
            placas = registroPlaca.buscarPlacasVehiculo(vehiculo);
        } catch (NegociosException ex) {
            Logger.getLogger(PantallaPlacas.class.getName()).log(Level.SEVERE, ex.getMessage());
        }

        if (placas != null && !placas.isEmpty()) {
            txtTipoVehiculo.setText("Usado");
        } else {
            txtTipoVehiculo.setText("Nuevo");
        }

        boolean placaNoReg = false;
        String numPlaca = "";
        // se verifica si la placa no se encuentra registrada
        while (!placaNoReg) {
            PlacaNuevaDTO placaNueva = null;
            GenerarNumeroPlaca genNumPlaca = new GenerarNumeroPlaca();
            numPlaca = genNumPlaca.generarNumeroDePlaca();
            try {
                placaNueva = this.registroPlaca.buscarPlaca(numPlaca);
            } catch (NegociosException ex) {
                Logger.getLogger(PantallaPlacas.class.getName()).log(Level.SEVERE, ex.getMessage());
            }
            if (placaNueva == null) {
                placaNoReg = true;
            }
        }

        txtNoPlaca.setText(numPlaca);

        Calendar fechaExpedicion = Calendar.getInstance();
        txtFechaExpedicion.setText(fechaExpedicion.get(Calendar.DAY_OF_MONTH) + "/" + (fechaExpedicion.get(Calendar.MONTH) + 1) + "/" + fechaExpedicion.get(Calendar.YEAR));
        txtContribuyente.setText(vehiculo.getPersona().getNombres() + " " + vehiculo.getPersona().getApellidoPaterno() + " " + vehiculo.getPersona().getApellidoMaterno());
        txtVehiculo.setText(vehiculo.getMarca() + " " + vehiculo.getLinea() + " " + vehiculo.getColor() + " " + vehiculo.getModelo());

        if (txtTipoVehiculo.getText().equals("Nuevo")) {
            costo = PreciosTramites.obtenerCostoPlaca(true);
            txtCosto.setText(Float.toString(costo));
        } else {
            costo = PreciosTramites.obtenerCostoPlaca(false);
            txtCosto.setText(Float.toString(costo));
        }
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
        lblRFC = new javax.swing.JLabel();
        txtTipoVehiculo = new javax.swing.JTextField();
        lblRFC1 = new javax.swing.JLabel();
        txtNoPlaca = new javax.swing.JTextField();
        lblRFC2 = new javax.swing.JLabel();
        txtFechaExpedicion = new javax.swing.JTextField();
        txtContribuyente = new javax.swing.JTextField();
        lblRFC4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblRFC5 = new javax.swing.JLabel();
        txtVehiculo = new javax.swing.JTextField();
        lblRFC6 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();

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
        lblInstrucciones.setText("DATOS DE LAS PLACAS");

        lblRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC.setText("Tipo de vehículo");

        txtTipoVehiculo.setEditable(false);
        txtTipoVehiculo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtTipoVehiculo.setForeground(new java.awt.Color(119, 119, 119));

        lblRFC1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC1.setText("Número de placas");

        txtNoPlaca.setEditable(false);
        txtNoPlaca.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNoPlaca.setForeground(new java.awt.Color(119, 119, 119));

        lblRFC2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC2.setText("Fecha de expedición");

        txtFechaExpedicion.setEditable(false);
        txtFechaExpedicion.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtFechaExpedicion.setForeground(new java.awt.Color(119, 119, 119));

        txtContribuyente.setEditable(false);
        txtContribuyente.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtContribuyente.setForeground(new java.awt.Color(119, 119, 119));

        lblRFC4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC4.setText("Costo");

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

        btnAgregar.setBackground(new java.awt.Color(159, 34, 65));
        btnAgregar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblRFC5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC5.setText("Contributente asociado");

        txtVehiculo.setEditable(false);
        txtVehiculo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtVehiculo.setForeground(new java.awt.Color(119, 119, 119));

        lblRFC6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC6.setText("Vehiculo asociado");

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(119, 119, 119));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblRFC)
                            .addComponent(lblRFC1)
                            .addComponent(lblRFC2)
                            .addComponent(txtNoPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                            .addComponent(txtFechaExpedicion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRFC4)
                    .addComponent(txtContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRFC5)
                    .addComponent(txtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRFC6)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblInstrucciones)
                .addGap(391, 391, 391))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblInstrucciones)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRFC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRFC1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRFC5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRFC6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRFC2)
                    .addComponent(lblRFC4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaExpedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        PlacaNuevaDTO placaNueva = new PlacaNuevaDTO(txtNoPlaca.getText(),null,true, vehiculo, Calendar.getInstance(), costo, vehiculo.getPersona());
        try {
            PlacaNuevaDTO placaCorrecta = registroPlaca.tramitarPlaca(placaNueva);
            if (placaCorrecta != null) {
                JOptionPane.showMessageDialog(this, "Trámite de placa exitoso",
                        "Trámite de placa", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                PantallaPlacasVehiculo pPlacasVehiculo = new PantallaPlacasVehiculo(parent, true, vehiculo);
                pPlacasVehiculo.setVisible(true);
            }
        } catch (NegociosException ex) {
            Logger.getLogger(PantallaPlacas.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInstrucciones;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblRFC1;
    private javax.swing.JLabel lblRFC2;
    private javax.swing.JLabel lblRFC4;
    private javax.swing.JLabel lblRFC5;
    private javax.swing.JLabel lblRFC6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtContribuyente;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFechaExpedicion;
    private javax.swing.JTextField txtNoPlaca;
    private javax.swing.JTextField txtTipoVehiculo;
    private javax.swing.JTextField txtVehiculo;
    // End of variables declaration//GEN-END:variables
}
