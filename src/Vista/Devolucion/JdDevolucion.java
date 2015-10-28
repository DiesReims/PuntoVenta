package Vista.Devolucion;

import Control.Control.CtrlProducto;
import Control.Control.CtrlVenta;
import Control.Control.CtrlVentaProducto;
import Data.Entidad.Producto;
import Data.Entidad.Venta;
import Data.Entidad.VentaProducto;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import nicon.notify.core.Notification;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class JdDevolucion extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    boolean noActionCombo = false;
    CtrlVenta ctrlVenta = new CtrlVenta();
    Venta baseEntity = new Venta();
    Producto producto = new Producto();
    CtrlVentaProducto ctrlVentaProducto = new CtrlVentaProducto();
    VentaProducto ventaProducto = new VentaProducto();
    CtrlProducto ctrlProducto = new CtrlProducto();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public JdDevolucion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JdDevolucion() {
        this.initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
    }
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        btnBuscarFolio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        txtCantidadVendida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCantidadDevolver = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Venta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("Devolucion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda Venta"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Folio:");

        btnBuscarFolio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarFolio.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscarFolio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_e70a(0)_24.png"))); // NOI18N
        btnBuscarFolio.setText("Buscar");
        btnBuscarFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFolioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(84, 84, 84)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarFolio)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFolio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Venta"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Producto:");

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });

        txtCantidadVendida.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Cantidad Vendida:");

        btnDevolver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDevolver.setForeground(new java.awt.Color(51, 51, 51));
        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Cantidad Devuelta:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txtCantidadDevolver)
                    .addComponent(cmbProducto, 0, 186, Short.MAX_VALUE)
                    .addComponent(txtCantidadVendida))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadVendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addComponent(btnDevolver)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            this.dispose();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.dispose();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        try {
            //Aqui se agregará el código para la devolución de los productos
            /*
             Se obtiene el id del combo box y el valor agregado a la cantidad de devolución se comprobará que no supere la cantidad vendida
             posteriormente se llamará al método de actualizar stock cambiando el valor a positivo
             */
            Producto productoDevolucion = (Producto) this.cmbProducto.getSelectedItem();
            if (Integer.parseInt(this.txtCantidadDevolver.getText()) > Integer.parseInt(this.txtCantidadVendida.getText())) {
                Notification.show("Mensaje del sistema", "No se puede devolver una suma mayor a la vendida", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
            }
            productoDevolucion.setIntCantidad(Integer.parseInt(this.txtCantidadVendida.getText()) + Integer.parseInt(this.txtCantidadDevolver.getText()));
            boolean result = ctrlProducto.ModifcarStock(productoDevolucion);
            if (result == false) {
                Notification.show("Mensaje del sistema", "Ocurrio un error al aplicar la devolución", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
                System.out.println("Ocurrio un error al tratar de cambiar el stock");
            }
            Notification.show("Mensaje del sistema", "Ok, devolución completada", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE);
            this.cmbProducto.setSelectedIndex(0);
        } catch (Exception _e) {
            Notification.show("Mensaje del sistema", "Ocurrio un error al aplicar la devolución", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnBuscarFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFolioActionPerformed
        try {
            this.noActionCombo = true;
            DefaultComboBoxModel x = new DefaultComboBoxModel();
            this.baseEntity.setStrFolio(this.txtFolio.getText().trim());
            ArrayList<Object> listaVenta = ctrlVenta.ConsultaBuscar(this.baseEntity);
            if (listaVenta.size() > 1) {
                Notification.show("Mensaje del sistema", "Busqueda ambigüa", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < listaVenta.size(); i++) {
                this.baseEntity = (Venta) listaVenta.get(i);
            }
            ventaProducto.setIdVenta(this.baseEntity.getId());
            ArrayList<Object> listaProducto = ctrlVentaProducto.ConsultaNoCatalogo(this.ventaProducto);
            if (listaProducto.size() <= 0) {
                Notification.show("Mensaje del sistema", "La venta no contiene productos", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < listaProducto.size(); i++) {
                    ventaProducto = (VentaProducto) listaProducto.get(i);
                    Producto productoTemp = new Producto();
                    productoTemp.setId(ventaProducto.getIdProducto());
                    Producto productoConsulta = (Producto) ctrlProducto.ConsultaEspecifica(productoTemp);
                    x.addElement(productoConsulta);
                }
            }
            this.cmbProducto.setModel(x);
            this.noActionCombo = false;
            this.cmbProductoItemStateChangeInitial();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarFolioActionPerformed

    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged
        {
            try {
                if (this.noActionCombo == false) {
                    this.producto = (Producto) this.cmbProducto.getSelectedItem();
                    this.producto = (Producto) ctrlProducto.ConsultaEspecifica(this.producto);
                    this.txtFolio.setText(this.baseEntity.getStrFolio());
                    this.txtCantidadVendida.setText(String.valueOf(this.producto.getIntCantidad()));
                }
            } catch (Exception _e) {
                Notification.show("Mensaje del sistema", "Ocurrio un problema la cargar el producto", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
                System.out.println(_e.getMessage());
                System.out.println(_e.getStackTrace());
            }
        }
    }//GEN-LAST:event_cmbProductoItemStateChanged

    private void cmbProductoItemStateChangeInitial() {
        try {
            if (this.noActionCombo == false) {
                this.producto = (Producto) this.cmbProducto.getSelectedItem();
                this.producto = (Producto) ctrlProducto.ConsultaEspecifica(this.producto);
                this.txtFolio.setText(this.baseEntity.getStrFolio());
                this.txtCantidadVendida.setText(String.valueOf(this.producto.getIntCantidad()));
            }
        } catch (Exception _e) {
            Notification.show("Mensaje del sistema", "Ocurrio un problema la cargar el producto", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE);
            System.out.println(_e.getMessage());
            System.out.println(_e.getStackTrace());
        }
    }

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
            java.util.logging.Logger.getLogger(JdDevolucion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdDevolucion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdDevolucion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdDevolucion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdDevolucion dialog = new JdDevolucion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscarFolio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCantidadDevolver;
    private javax.swing.JTextField txtCantidadVendida;
    private javax.swing.JTextField txtFolio;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
