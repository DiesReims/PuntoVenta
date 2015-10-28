package Vista.Producto;

import Control.Control.CtrlCatTipoProducto;
import Control.Interface.IManager;
import Control.Validacion.CtrlValidacionInfo;
import Data.Entidad.CatTipoProducto;
import Data.Entidad.Producto;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class JdProductoManager extends javax.swing.JDialog implements IManager {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private CtrlValidacionInfo ctrlValidacionInfo = new CtrlValidacionInfo();
    private Producto baseEntity;
    private int idEstado;
    private int idAccion = 0;
    boolean conCambios = false;
    private boolean camTxt = false;
    private boolean camCombo = false;
    private boolean camJTable = false;
    String prueba = "Hola";
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public JdProductoManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JdProductoManager() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAccion = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAccion.setForeground(new java.awt.Color(51, 51, 51));
        lblAccion.setText("Acción");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2715(1)_24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Producto");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2713(2)_24.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Precio Compra:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Precio Venta:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Cantidad:");

        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });

        txtCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantidadMouseClicked(evt);
            }
        });

        txtPrecioCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioCompraMouseClicked(evt);
            }
        });

        txtPrecioVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Código:");

        txtIdentificador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentificadorMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecioVenta)
                    .addComponent(txtPrecioCompra)
                    .addComponent(txtCantidad)
                    .addComponent(txtNombre)
                    .addComponent(txtIdentificador)
                    .addComponent(cmbCategoria, 0, 268, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(156, 156, 156)
                        .addComponent(lblAccion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblAccion))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
//            if (camCombo == true || camTxt == true || camJTable == true) {
//                int res = JOptionPane.showConfirmDialog(null, "Has realizado Cambio, estas seguro de guardarlos");
//                if (res == 0) {
//                    JOptionPane.showMessageDialog(null, "Hubo un Cambio");
            if (this.validaDatos() == true) {
                this.baseEntity.setStrValor(this.txtNombre.getText().trim());
                this.baseEntity.setStrCodigo(this.txtIdentificador.getText().trim());
                this.baseEntity.setIntCantidad(Integer.parseInt(this.txtCantidad.getText().trim()));
                this.baseEntity.setDblPrecioCompra(Double.parseDouble(this.txtPrecioCompra.getText().trim()));
                this.baseEntity.setDblPrecioVenta(Double.parseDouble(this.txtPrecioVenta.getText().trim()));
                //aqui falta la linea para obtener el combo seleccionado
                if (this.idAccion == 0) {
                    this.baseEntity.setIdTipoProducto(this.cmbCategoria.getSelectedIndex());
                } else {
                    this.baseEntity.setIdTipoProducto(this.cmbCategoria.getSelectedIndex() + 1);
                }
                //se cierra la pantalla
                this.conCambios = false;
                this.camCombo = false;
                this.camJTable = false;
                this.camTxt = false;
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.baseEntity = null;
            this.dispose();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        this.DetectaCambio(this.txtNombre);
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtIdentificadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdentificadorMouseClicked
        this.DetectaCambio(this.txtIdentificador);
    }//GEN-LAST:event_txtIdentificadorMouseClicked

    private void txtCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseClicked
        this.DetectaCambio(this.txtCantidad);
    }//GEN-LAST:event_txtCantidadMouseClicked

    private void txtPrecioCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioCompraMouseClicked
        this.DetectaCambio(this.txtPrecioCompra);
    }//GEN-LAST:event_txtPrecioCompraMouseClicked

    private void txtPrecioVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMouseClicked
        this.DetectaCambio(this.txtPrecioVenta);
    }//GEN-LAST:event_txtPrecioVentaMouseClicked

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
            java.util.logging.Logger.getLogger(JdProductoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdProductoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdProductoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdProductoManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdProductoManager dialog = new JdProductoManager(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    @Override
    public Object showDialog(Object _obj) {
        try {
            this.baseEntity = (Producto) _obj;
            this.idAccion = (this.baseEntity != null) ? this.baseEntity.getId() : 0;
            if (this.idAccion == 0) {
                this.baseEntity = new Producto();
            }
            this.idEstado = this.baseEntity.getIdTipoProducto();//obtener el id de estado para el combo de editar
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
            if (!ctrlValidacionInfo.validacionGeneral(this.txtNombre.getText(),45,1)) {
                JOptionPane.showMessageDialog(null, "El campo de producto no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtIdentificador.getText(),13,1)) {
                JOptionPane.showMessageDialog(null, "El campo de código no es valido");
                return false;
            }
                if (!ctrlValidacionInfo.validacionNoCaracteres(this.txtIdentificador.getText())) {
                JOptionPane.showMessageDialog(null, "El campo de código no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtCantidad.getText(),10,1)) {
                JOptionPane.showMessageDialog(null, "El campo de cantidad no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.SoloNumeros(this.txtCantidad.getText().trim())) {
                JOptionPane.showMessageDialog(null,"Solo se permiten numeros en cantidad");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtPrecioCompra.getText(),10,1)) {
                JOptionPane.showMessageDialog(null, "El campo de precio compra no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.SoloNumerosConPunto(this.txtPrecioCompra.getText().trim())) {
                JOptionPane.showMessageDialog(null,"Solo se permiten numeros en precio compra");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtPrecioVenta.getText(),10,1)) {
                JOptionPane.showMessageDialog(null, "El campo de precio venta no es valido");
                return false;
            }
             if (!ctrlValidacionInfo.SoloNumerosConPunto(this.txtPrecioVenta.getText().trim())) {
                JOptionPane.showMessageDialog(null,"Solo se permiten numeros en precio venta");
                return false;
            }
            if (this.idAccion == 0) {
                if (this.cmbCategoria.getSelectedIndex() == 0) {
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
            CtrlCatTipoProducto ctrlCatTipoProducto = new CtrlCatTipoProducto();
            ArrayList<Object> lista = ctrlCatTipoProducto.ConsultaGeneral(null);
            
            if (this.idAccion == 0) {
                //leyenda seleccionar
                x.addElement("Selecciona");
                for (int i = 0; i < lista.size(); i++) {
                    CatTipoProducto tempObject = (CatTipoProducto) lista.get(i);
                    x.addElement(tempObject);
                }
                cmbCategoria.setModel(x);
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    CatTipoProducto tempObject = (CatTipoProducto) lista.get(i);
                    x.addElement(tempObject);
                }
                cmbCategoria.setModel(x);
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
            if (this.idEstado > 0) {
                this.cmbCategoria.setSelectedIndex(this.idEstado - 1);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }

    @Override
    public void setTextField() {
        try {
            this.txtNombre.setText(((this.baseEntity != null) ? this.baseEntity.getStrValor() : ""));
            this.txtIdentificador.setText(((this.baseEntity != null) ? this.baseEntity.getStrCodigo() : ""));
            this.txtCantidad.setText((this.baseEntity != null) ? String.valueOf(this.baseEntity.getIntCantidad()) : "");
            this.txtPrecioCompra.setText((this.baseEntity != null) ? String.valueOf(this.baseEntity.getDblPrecioCompra()) : "");
            this.txtPrecioVenta.setText((this.baseEntity != null) ? String.valueOf(this.baseEntity.getDblPrecioVenta()) : "");
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
        this.conCambios = true;
    }

    //<editor-fold defaultstate="collapsed" desc="Detecta cambio combo: Evento">
    private void DetectaCambioCombo() {
        if (this.idAccion == 0) {
            if (this.cmbCategoria.getSelectedIndex() >= 0) {
                this.camCombo = true;
            }

        } else if (this.idAccion > 0) {

            CatTipoProducto x = (CatTipoProducto) cmbCategoria.getSelectedItem();
            System.out.println(x.getId() + this.baseEntity.getIdTipoProducto());
            if (x.getId() != this.baseEntity.getIdTipoProducto()) {
                this.camCombo = true;
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Detecta cambio JTArea">
    private void DetectaCambioJTArea(JTextArea txt) {
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }
        };
        txt.getDocument().addDocumentListener(documentListener);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Detecta cambio JTField ">
    private void DetectaCambio(JTextField txt) {
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                camTxt = true;
            }
        };
        txt.getDocument().addDocumentListener(documentListener);

    }
    //</editor-fold>
}
