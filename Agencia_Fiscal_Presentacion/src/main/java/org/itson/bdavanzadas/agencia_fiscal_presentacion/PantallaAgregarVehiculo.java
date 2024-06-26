package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.agencia_fiscal_bos.GestorVehiculosBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IGestorVehiculosBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroPersonasBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroLicenciaBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPersonasBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.VehiculoNuevoDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_presentacion.validadores.Validadores;

/**
 * Clase que representa la pantalla para agregar un vehículo al sistema.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class PantallaAgregarVehiculo extends javax.swing.JDialog {

    /**
     * Constructor de la clase PantallaAgregarVehiculo.
     *
     * @param parent Componente padre de la pantalla.
     * @param modal  Indica si la pantalla es modal o no.
     */
    public PantallaAgregarVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.validador = new Validadores();
        this.registroPersona = new RegistroPersonasBO();
        this.registroLicencia = new RegistroLicenciaBO();
        this.gestorVehiculo = new GestorVehiculosBO();
    }

    /**
     * Método para agregar un vehículo al sistema.
     */
    private void agregarVehiculo() {
        String noSerie = txtNoSerie.getText();
        String marca = txtMarca.getText();
        String linea = txtLinea.getText();
        String color = txtColor.getText();
        String modelo = txtModelo.getText();

        vehiculoNuevo = new VehiculoNuevoDTO(noSerie, color, modelo, linea, marca, persona);

        try {
            gestorVehiculo.agregarVehiculo(vehiculoNuevo);
        } catch (NegociosException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
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
        lblNumeroSerie = new javax.swing.JLabel();
        txtNoSerie = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblRFC = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblModelo = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtNombrePersona = new javax.swing.JTextField();
        lblNombreContribuyente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar vehiculo");

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
                .addGap(324, 324, 324)
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
        lblInstrucciones.setText("INGRESE LOS DATOS DEL VEHÍCULO");

        lblNumeroSerie.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNumeroSerie.setText("Número de serie");

        txtNoSerie.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNoSerie.setForeground(new java.awt.Color(119, 119, 119));

        lblMarca.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblMarca.setText("Marca");

        txtMarca.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(119, 119, 119));

        lblLinea.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblLinea.setText("Línea");

        txtLinea.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtLinea.setForeground(new java.awt.Color(119, 119, 119));

        txtColor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtColor.setForeground(new java.awt.Color(119, 119, 119));

        lblColor.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblColor.setText("Color");

        txtModelo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(119, 119, 119));

        lblRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRFC.setText("Buscar contribuyente (RFC):");

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

        lblModelo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblModelo.setText("Modelo");

        txtRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtRFC.setForeground(new java.awt.Color(119, 119, 119));

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

        txtNombrePersona.setEditable(false);
        txtNombrePersona.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNombrePersona.setForeground(new java.awt.Color(119, 119, 119));

        lblNombreContribuyente.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNombreContribuyente.setText("Nombre del contribuyente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRFC)
                                    .addComponent(lblNumeroSerie)
                                    .addComponent(lblMarca)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombreContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 88, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtRFC)
                                        .addGap(17, 17, 17)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombrePersona))
                                .addGap(88, 88, 88)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColor)
                            .addComponent(lblLinea)
                            .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModelo)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(lblInstrucciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRFC)
                    .addComponent(lblLinea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblColor)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblNombreContribuyente))
                            .addComponent(txtColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroSerie)
                    .addComponent(lblModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
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
     * Acción realizada al presionar el botón de cancelar.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "Está en medio de un proceso, ¿desea salir en este momento?",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Acción realizada al presionar el botón de agregar.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!txtNombrePersona.getText().isBlank()) {
            if (validador.validaNoSerie(txtNoSerie.getText()) && validador.validaMarca(txtMarca.getText()) && validador.validaLinea(txtLinea.getText())
                    && validador.validaMarca(txtMarca.getText()) && validador.validaLinea(txtLinea.getText()) && validador.validaColor(txtColor.getText())
                    && validador.validaModelo(txtModelo.getText())) {
                try {
                    if (gestorVehiculo.buscarVehiculoNS(txtNoSerie.getText()) == null) {
                        agregarVehiculo();
                        JOptionPane.showMessageDialog(this, "Se agregó el vehículo correctamente.",
                                "Información", JOptionPane.INFORMATION_MESSAGE);
                        PantallaPlacasVehiculo pPlacasVehiculo = new PantallaPlacasVehiculo(parent, true, vehiculoNuevo);
                        pPlacasVehiculo.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "El numero de serie ingresado ya se encuentra registrado",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NegociosException ex) {
                    Logger.getLogger(PantallaAgregarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Asegúrse de ingresar los datos del vehículo correctamente.",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Asegúrese de asociarle un contribuyente al vehículo.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * Acción realizada al presionar el botón de buscar.
     *
     * @param evt Evento de acción del botón.
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String rfc = txtRFC.getText();

        if (validador.validaRfc(rfc)) {
            try {
                persona = registroPersona.buscarPersona(rfc);
                if (persona != null) {
                    List<LicenciaNuevaDTO> licencias = new LinkedList<>();
                    try {
                        licencias = registroLicencia.obtenerLicencias(persona);
                    } catch (NegociosException ex) {
                        logger.log(Level.SEVERE, ex.getMessage());
                    }

                    if (licencias != null && !licencias.isEmpty()) {
                        LicenciaNuevaDTO ultimaLicencia = licencias.get(licencias.size() - 1);
                        if (ultimaLicencia.getEstado()) {
                            txtNombrePersona.setText(persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
                        } else {
                            JOptionPane.showMessageDialog(this, "El contribuyente no cuenta con una licencia activa",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El contribuyente no cuenta con una licencia",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NegociosException ex) {
                JOptionPane.showMessageDialog(this, "El RFC no pertenece a ninguna persona",
                        "Error", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.SEVERE, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un rfc correcto",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblInstrucciones;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombreContribuyente;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNoSerie;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
    private PersonaNuevaDTO persona;
    private VehiculoNuevoDTO vehiculoNuevo;
    private Validadores validador;
    private IRegistroPersonasBO registroPersona;
    private IRegistroLicenciaBO registroLicencia;
    private IGestorVehiculosBO gestorVehiculo;
    private Frame parent;
    static final Logger logger = Logger.getLogger(PantallaAgregarVehiculo.class.getName());
}
