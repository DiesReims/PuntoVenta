package Vista.Pedido;

import Control.Control.CtrlCatTipoPago;
import Control.Control.CtrlProducto;
import Control.Control.CtrlProveedor;
import Control.Interface.IManager;
import Control.Validacion.CtrlValidacionInfo;
import Data.Entidad.CatTipoPago;
import Data.Entidad.Pedido;
import Data.Entidad.Producto;
import Data.Entidad.Proveedor;
import java.awt.Dialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Alberto Zárate lara
 */
public class JdPedidoManager extends javax.swing.JDialog implements IManager {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private Pedido baseEntity = new Pedido();
    CtrlValidacionInfo ctrlValidacionInfo = new CtrlValidacionInfo();
    private int idProducto;
    private int idTipoPago;
    private int idProveedor;
    private int idAccion;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public JdPedidoManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JdPedidoManager() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

//</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblAccion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Pedido");

        lblAccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAccion.setForeground(new java.awt.Color(51, 51, 51));
        lblAccion.setText("Accion");

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("General")));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Proveedor:");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Producto:");

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Total");

        txtTotal.setEditable(false);

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Cantidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(43, 43, 43)
                        .addComponent(txtTotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(19, 19, 19)
                                .addComponent(txtCantidad)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(133, 133, 133)
                        .addComponent(lblAccion))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblAccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.baseEntity = null;
            this.dispose();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {

            if (this.validaDatos() == true) {
//                this.baseEntity.setTotal(Double.parseDouble(this.txtTotal.getText().trim()));
                //aqui falta la linea para obtener el combo seleccionado
                if (this.idAccion == 0) {
                    this.baseEntity.setIntCantidad(Integer.parseInt(this.txtCantidad.getText().trim()));
                    Proveedor proveedor = (Proveedor) this.cmbProveedor.getSelectedItem();
                    Producto producto = (Producto) this.cmbProducto.getSelectedItem();
                    this.baseEntity.setTotal(Integer.parseInt(this.txtCantidad.getText().trim()) * producto.getDblPrecioCompra());
                    this.baseEntity.setIdProveedor(proveedor.getId());
                    this.baseEntity.setIdProducto(producto.getId());
                    this.baseEntity.setDteFechaPedido(new Date());
                } else {
                    Proveedor proveedor = (Proveedor) this.cmbProveedor.getSelectedItem();
                    Producto producto = (Producto) this.cmbProducto.getSelectedItem();
                    this.baseEntity.setIdProveedor(proveedor.getId());
                    this.baseEntity.setIdProducto(producto.getId());
                }
                //se cierra la pantalla
                this.dispose();
            }
//                }
//            } 
//        else {
//                this.dispose();
//            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        try {
            Producto producto = (Producto) this.cmbProducto.getSelectedItem();
            this.txtTotal.setText(String.valueOf(Integer.parseInt(this.txtCantidad.getText().trim()) * producto.getDblPrecioCompra()));
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            this.txtCantidad.setText("1");
        }
    }//GEN-LAST:event_txtCantidadFocusLost

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
            java.util.logging.Logger.getLogger(JdPedidoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdPedidoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdPedidoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdPedidoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdPedidoManager dialog = new JdPedidoManager(new javax.swing.JFrame(), true);
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

    //<editor-fold defaultstate="collapsed" desc="Componentres">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    @Override
    public Object showDialog(Object _obj) {
        try {
            this.baseEntity = (Pedido) _obj;
            this.idAccion = (this.baseEntity != null) ? this.baseEntity.getId() : 0;
            if (this.idAccion == 0) {
                this.baseEntity = new Pedido();
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
            if (!ctrlValidacionInfo.validacionGeneral(this.txtCantidad.getText(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de cantidad no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.SoloNumeros(this.txtCantidad.getText().trim())) {
                JOptionPane.showMessageDialog(null, "El campo de cantidad no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtTotal.getText(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de producto no es valido");
                return false;
            }
            if (this.idAccion == 0) {
                if (this.cmbProveedor.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una opción valida de Estado");
                    return false;
                }
                if (this.cmbProducto.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una opción valida de Estado");
                    return false;
                }
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
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
        try {
            DefaultComboBoxModel x = new DefaultComboBoxModel();
            DefaultComboBoxModel y = new DefaultComboBoxModel();
            DefaultComboBoxModel z = new DefaultComboBoxModel();
            CtrlProveedor ctrlProveedor = new CtrlProveedor();
            CtrlProducto ctrlProducto = new CtrlProducto();
            CtrlCatTipoPago ctrlCatTipoPago = new CtrlCatTipoPago();
            ArrayList<Object> listaTipoPago = ctrlCatTipoPago.ConsultaGeneral(null);
            ArrayList<Object> listaProveedor = ctrlProveedor.ConsultaGeneral(null);
            ArrayList<Object> listaProducto = ctrlProducto.ConsultaGeneral(null);
            if (this.idAccion == 0) {
                //leyenda seleccionar
                x.addElement("Selecciona");
                y.addElement("Selecciona");
                z.addElement("Selecciona");
                for (int i = 0; i < listaProveedor.size(); i++) {
                    Proveedor tempObject = (Proveedor) listaProveedor.get(i);
                    x.addElement(tempObject);
                }
                for (int i = 0; i < listaProducto.size(); i++) {
                    Producto tempObject = (Producto) listaProducto.get(i);
                    y.addElement(tempObject);
                }
                for (int i = 0; i < listaTipoPago.size(); i++) {
                    CatTipoPago tempObject = (CatTipoPago) listaTipoPago.get(i);
                    z.addElement(tempObject);
                }
                cmbProveedor.setModel(x);
                cmbProducto.setModel(y);
            } else {
                for (int i = 0; i < listaProveedor.size(); i++) {
                    Proveedor tempObject = (Proveedor) listaProveedor.get(i);
                    x.addElement(tempObject);
                }
                for (int i = 0; i < listaProducto.size(); i++) {
                    Producto tempObject = (Producto) listaProducto.get(i);
                    y.addElement(tempObject);
                }
                for (int i = 0; i < listaTipoPago.size(); i++) {
                    CatTipoPago tempObject = (CatTipoPago) listaTipoPago.get(i);
                    z.addElement(tempObject);
                }
                cmbProveedor.setModel(x);
                cmbProducto.setModel(y);
                this.setComboBox();
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }

    @Override
    public boolean setLoadInformation() {
        try {
            this.setInformacion(this.idAccion);
            if (this.setComboBoxInitial() == false) {
                this.dispose();
            }
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
        try {
            if (this.idAccion > 0) {
                for (int i = 0; i < this.cmbProveedor.getItemCount(); i++) {
                    Proveedor objTemp = (Proveedor) this.cmbProveedor.getItemAt(i);
                    if (objTemp.getId() == this.baseEntity.getIdProveedor()) {
                        this.cmbProveedor.setSelectedIndex(i);
                        this.cmbProveedor.setEnabled(false);
                    }
                }
                for (int i = 0; i < this.cmbProducto.getItemCount(); i++) {
                    Producto objTemp = (Producto) this.cmbProducto.getItemAt(i);
                    if (objTemp.getId() == this.baseEntity.getIdProducto()) {
                        this.cmbProducto.setSelectedIndex(i);
                        this.cmbProducto.setEnabled(false);
                    }
                }
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }

    @Override
    public void setTextField() {
        try {
            this.txtTotal.setText(((this.baseEntity != null) ? String.valueOf(this.baseEntity.getTotal()) : ""));
            if (this.baseEntity != null) {
                this.txtTotal.setEnabled(false);
            }
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
