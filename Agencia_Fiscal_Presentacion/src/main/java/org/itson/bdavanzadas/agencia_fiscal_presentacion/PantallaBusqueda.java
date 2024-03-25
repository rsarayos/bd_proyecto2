package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Frame;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.bdavanzadas.agencia_fiscal_bos.IRegistroPersonasBO;
import org.itson.bdavanzadas.agencia_fiscal_bos.RegistroPersonaBO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroPersonasDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

public class PantallaBusqueda extends javax.swing.JDialog {

    /**
     * Creates new form PantallaModuloLicencias
     *
     * @param parent
     * @param modal
     */
    public PantallaBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.registroPersonas = new RegistroPersonaBO();
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
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblRFC = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        dpFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContribuyentes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));

        jPanel2.setBackground(new java.awt.Color(119, 119, 119));

        lblTitulo.setText("MÓDULO DE LICENCIAS");
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 43)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lblInstrucciones.setText("INGRESE AL MENOS UN CAMPO PARA BUSCAR AL CONTRIBUYENTE");
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

        lblNombre.setText("NOMBRE:");
        lblNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(119, 119, 119));

        lblRFC.setText("RFC:");
        lblRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        txtRFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtRFC.setForeground(new java.awt.Color(119, 119, 119));

        lblFechaNacimiento.setText("FECHA DE NACIMIENTO:");
        lblFechaNacimiento.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        dpFechaNacimiento.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        tblContribuyentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "FECHA DE NACIMIENTO", "RFC", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContribuyentes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tblContribuyentes);

        btnBuscar.setText("BUSCAR");
        btnBuscar.setBackground(new java.awt.Color(159, 34, 65));
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setFocusable(false);
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblInstrucciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRFC)
                        .addGap(18, 18, 18)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(lblFechaNacimiento)
                        .addGap(18, 18, 18)
                        .addComponent(dpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblInstrucciones)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRFC)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaNacimiento)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
        // Se crea el filtro para la consulta de personas
        FiltroPersonasDTO filtroPersonas = new FiltroPersonasDTO();
        filtroPersonas.setRfc(txtRFC.getText());
        filtroPersonas.setNombre(txtNombre.getText());

        if (dpFechaNacimiento.getDate() != null) {
            LocalDate fechaIngresada = dpFechaNacimiento.getDate();
            Calendar fechaNacimiento = new GregorianCalendar(fechaIngresada.getYear(), fechaIngresada.getMonthValue() - 1, fechaIngresada.getDayOfMonth());
            filtroPersonas.setFechaNacimiento(fechaNacimiento);
        }

        try {
            List<PersonaNuevaDTO> personas = registroPersonas.consultarPersonas(filtroPersonas);
            llenarTabla(personas);
        } catch (NegociosException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron consultar los contribuyentes",
                    "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void llenarTabla(List<PersonaNuevaDTO> personas) {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1; // Solo la última columna es editable
            }
        };
        modelo.addColumn("NOMBRE");
        modelo.addColumn("FECHA DE NACIMIENTO");
        modelo.addColumn("RFC");
        modelo.addColumn("");
        modelo.addColumn("");

        // Agregar los socios al modelo de la tabla
        for (PersonaNuevaDTO persona : personas) {

            String fechaNacimiento = persona.getFechaNacimiento().get(Calendar.DAY_OF_MONTH) + "/" + (persona.getFechaNacimiento().get(Calendar.MONTH) + 1) + "/" + persona.getFechaNacimiento().get(Calendar.YEAR);

            Object[] fila = {persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno(), fechaNacimiento, persona.getRfc(), persona.isDiscapacitado()? "Discapacitado":"No discapacitado", "SELECCIONAR"};
            modelo.addRow(fila);
        }
        tblContribuyentes.setModel(modelo);
        ButtonColumn buttonColumn = new ButtonColumn("SELECCIONAR", (e) -> {
            int fila = tblContribuyentes.convertRowIndexToModel(tblContribuyentes.getSelectedRow());
            PersonaNuevaDTO persona = personas.get(fila);

            PantallaTiposLicencias pTiposLicencias = new PantallaTiposLicencias(parent, true, persona);
            pTiposLicencias.setVisible(true);
        });
        tblContribuyentes.getColumnModel().getColumn(tblContribuyentes.getColumnCount() - 1).setCellRenderer(buttonColumn);
        tblContribuyentes.getColumnModel().getColumn(tblContribuyentes.getColumnCount() - 1).setCellEditor(buttonColumn);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private com.github.lgooddatepicker.components.DatePicker dpFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblInstrucciones;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblContribuyentes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
    private Frame parent;
    private IRegistroPersonasBO registroPersonas;
    static final Logger logger = Logger.getLogger(PantallaBusqueda.class.getName());
}
