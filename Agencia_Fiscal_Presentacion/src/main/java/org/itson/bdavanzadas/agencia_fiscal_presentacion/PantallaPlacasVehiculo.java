
package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Frame;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroPlacaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPlacaBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author victo
 */
public class PantallaPlacasVehiculo extends javax.swing.JDialog {

    private VehiculoNuevoDTO vehiculo;
    private IRegistroPlacaBO registroPlaca;
    private Frame parent;
    
    /**
     * Creates new form PantallaPlacasVehiculo
     */
    public PantallaPlacasVehiculo(java.awt.Frame parent, boolean modal, VehiculoNuevoDTO vehiculo) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.vehiculo = vehiculo;
        this.registroPlaca = new RegistroPlacaBO();
        llenarTablaPlacas();
    }

    private void llenarTablaPlacas(){
    DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1; // Solo la última columna es editable
            }
        };
        modelo.addColumn("NO. PLACA");
        modelo.addColumn("FECHA TRAMITE");
        modelo.addColumn("VEHÍCULO");
        modelo.addColumn("ESTADO");

        List<PlacaNuevaDTO> placas = new LinkedList<>();
        try {
            placas = registroPlaca.buscarPlacasVehiculo(vehiculo);
        } catch (NegociosException ne) {
            Logger.getLogger(PantallaPlacas.class.getName()).log(Level.SEVERE, ne.getMessage());
        }
        
        for (PlacaNuevaDTO placa : placas) {

            String fechaTramite = placa.getFechaTramite().get(Calendar.DAY_OF_MONTH) + "/" + (placa.getFechaTramite().get(Calendar.MONTH) + 1) + "/" + placa.getFechaTramite().get(Calendar.YEAR);
            String vehiculoBusqueda = placa.getVehiculo().getMarca()+" "+placa.getVehiculo().getLinea()+" "+placa.getVehiculo().getColor()+" "+placa.getVehiculo().getModelo();
            
            Object[] fila = {placa.getNumeroPlaca(), fechaTramite, vehiculoBusqueda, (placa.getEstado())? "Activa" : "Desactiva"};
            modelo.addRow(fila);
        }
        tblPlacas.setModel(modelo);
        
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
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlacas = new javax.swing.JTable();
        btnAgregarPlaca = new javax.swing.JButton();
        lblInstrucciones1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addContainerGap(17, Short.MAX_VALUE))
        );

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

        tblPlacas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblPlacas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPlacas);

        btnAgregarPlaca.setBackground(new java.awt.Color(159, 34, 65));
        btnAgregarPlaca.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnAgregarPlaca.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPlaca.setText("AGREGAR PLACA");
        btnAgregarPlaca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarPlaca.setFocusPainted(false);
        btnAgregarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPlacaActionPerformed(evt);
            }
        });

        lblInstrucciones1.setFont(new java.awt.Font("Arial", 1, 27)); // NOI18N
        lblInstrucciones1.setForeground(new java.awt.Color(119, 119, 119));
        lblInstrucciones1.setText("PLACAS ASOCIADAS AL VEHICULO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(551, 551, 551)
                                .addComponent(btnAgregarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(lblInstrucciones1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblInstrucciones1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
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

    private void btnAgregarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPlacaActionPerformed
        PantallaPlacas pPlacas = new PantallaPlacas(parent, true, vehiculo);
        pPlacas.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAgregarPlacaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPlaca;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInstrucciones1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblPlacas;
    // End of variables declaration//GEN-END:variables
}