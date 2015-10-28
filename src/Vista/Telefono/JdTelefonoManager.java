package Vista.Telefono;

import Control.Control.CtrlTelefono;
import Control.Interface.IManager;
import Control.Validacion.CtrlValidacionInfo;
import Data.Entidad.Telefono;
import java.awt.Dialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class JdTelefonoManager extends javax.swing.JDialog implements IManager {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    Telefono baseEntity;
    CtrlTelefono ctrlTelefono = new CtrlTelefono();
    CtrlValidacionInfo ctrlValidacionInfo = new CtrlValidacionInfo();
    private int idAccion;
    boolean conCambios = false;
    private boolean camTxt = false;
    private boolean camCombo = false;
    private boolean camJTable = false;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form JdTelefonoManager
     */
    public JdTelefonoManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JdTelefonoManager() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

//</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblAccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel1.setText("No. Telefono:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2715(1)_24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2713(2)_24.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Telefono");

        lblAccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAccion.setForeground(new java.awt.Color(51, 51, 51));
        lblAccion.setText("Acción");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(65, 65, 65)
                            .addComponent(lblAccion))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            if (this.validaDatos() == true) {
                this.baseEntity.setStrValor(this.txtTelefono.getText().trim());
                //aqui falta la linea para obtener el combo seleccionado          
                //se cierra la pantalla
                this.conCambios = false;
                this.camCombo = false;
                this.camJTable = false;
                this.camTxt = false;
                this.dispose();
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.baseEntity = null;
            this.dispose();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    //<editor-fold defaultstate="collapsed" desc="MTD Main">
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdTelefonoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdTelefonoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdTelefonoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdTelefonoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdTelefonoManager dialog = new JdTelefonoManager(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    @Override
    public Object showDialog(Object _obj) {
        try {
            this.baseEntity = (Telefono) _obj;
//            this.idAccion = (this.baseEntity != null) ? this.baseEntity.getId() : 0;
            if (this.baseEntity == null) {
                this.idAccion = 0;
            }
            if (this.baseEntity != null && this.baseEntity.getId() == 0) {
                this.idAccion = 1;
            }
            if (this.baseEntity != null && this.baseEntity.getId() > 0) {
                this.idAccion = this.baseEntity.getId();
            }
            if (this.idAccion == 0) {
                this.baseEntity = new Telefono();
            }
            this.setLoadInformation();
            this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            this.setVisible(true);
            return (this.baseEntity != null) ? this.baseEntity : null;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return null;
        }
    }

    @Override
    public boolean validaDatos() {
        try {
            if (ctrlValidacionInfo.validacionGeneral(this.txtTelefono.getText(), 10, 13)) {
                JOptionPane.showMessageDialog(null, "El numero telefonico no es correcto");
                return false;
            }
            if (!ctrlValidacionInfo.SoloNumeros(this.txtTelefono.getText().trim())) {
                JOptionPane.showMessageDialog(null, "El numero telefonico no es valido");
                return false;
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return false;
        }
    }

    @Override
    public void setInformacion(int _id) {
        try {
            if (_id == 0) {
                this.lblAccion.setText("[Agregar]");
            } else {
                this.lblAccion.setText("[Editar]");
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }

    @Override
    public void setEstatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setComboBoxInitial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setLoadInformation() {
        try {
            this.setInformacion(this.idAccion);
//            if (this.setComboBoxInitial() == false) {
//                this.dispose();
//            }
            this.setTextField();
            this.setComboBox();
            this.setTabla();
            this.setFecha();
            this.setCheck();
            this.setExtra();
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }

    @Override
    public void setComboBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTextField() {
        try {
            this.txtTelefono.setText(((this.baseEntity != null) ? this.baseEntity.getStrValor() : ""));
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }

    @Override
    public void setFecha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRadio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setExtra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void huboCambio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
