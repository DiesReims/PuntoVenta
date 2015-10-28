package Vista.Pedido;

import Control.Control.CtrlPagoPedido;
import Control.Control.CtrlPedido;
import Control.Control.CtrlProducto;
import Control.Control.CtrlProveedor;
import Data.Entidad.PagoPedido;
import Data.Entidad.Pedido;
import Data.Entidad.Producto;
import Data.Entidad.Proveedor;
import java.awt.Color;
import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class IfrmPedidoPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    Proveedor proveedor = new Proveedor();
    Pedido pedido = new Pedido();
    Producto producto = new Producto();
    CtrlProducto ctrlProducto = new CtrlProducto();
    CtrlPedido ctrlPedido = new CtrlPedido();
    CtrlPagoPedido ctrlPagoPedido = new CtrlPagoPedido();
    CtrlProveedor ctrlProveedor = new CtrlProveedor();
    DefaultComboBoxModel defaultComboBoxModel;
    DefaultTableModel defaultTableModel;
    private int idFiltro;
    private int id;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmPedidoPrincipal() {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.loadInformation();
        String[] cabecera = {"Id", "IdProveedor", "IdProducto", "Cantidad", "Producto", "Total", "Pagado"};
        Object[][] cuerpo = {};
        defaultTableModel = new DefaultTableModel(cuerpo, cabecera);
        this.jtCentral.setModel(defaultTableModel);
        jtCentral.setModel(defaultTableModel);
        jtCentral.getColumn("Id").setPreferredWidth(0);
        jtCentral.getColumn("Id").setMinWidth(0);
        jtCentral.getColumn("Id").setMaxWidth(0);
        jtCentral.getColumn("Id").setWidth(0);

        jtCentral.setModel(defaultTableModel);
        jtCentral.getColumn("IdProveedor").setPreferredWidth(0);
        jtCentral.getColumn("IdProveedor").setMinWidth(0);
        jtCentral.getColumn("IdProveedor").setMaxWidth(0);
        jtCentral.getColumn("IdProveedor").setWidth(0);

        jtCentral.setModel(defaultTableModel);
        jtCentral.getColumn("IdProducto").setPreferredWidth(0);
        jtCentral.getColumn("IdProducto").setMinWidth(0);
        jtCentral.getColumn("IdProducto").setMaxWidth(0);
        jtCentral.getColumn("IdProducto").setWidth(0);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    //<editor-fold defaultstate="collapsed" desc="MTD Load Information">
    public void loadInformation() {
        try {
            this.loadFiltros();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar el módulo");
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Load Filtros">
    public void loadFiltros() {
        try {
            defaultComboBoxModel = new DefaultComboBoxModel();
            ArrayList<Object> lista = ctrlProveedor.ConsultaGeneral(null);
            for (int i = 0; i < lista.size(); i++) {
                Proveedor objTemp = (Proveedor) lista.get(i);
                defaultComboBoxModel.addElement(objTemp);
                cmbProveedor.setModel(defaultComboBoxModel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar los filtros");
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Load Registros">
    public void loadRegistros() {
        try {
            ArrayList<Object> lista = this.ctrlPedido.ConsultaNoCatalogo(this.idFiltro);
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp1 = new Object[7];
                Pedido tempObject = (Pedido) lista.get(i);
                ArrayList<Object> listaPagos = ctrlPagoPedido.ConsultaNoCatalogo(tempObject.getId());
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getIdProveedor();
                filaTemp1[2] = tempObject.getIdProducto();
                filaTemp1[3] = tempObject.getIntCantidad();
                this.producto.setId(tempObject.getIdProducto());
                this.producto = (Producto) ctrlProducto.ConsultaEspecifica(this.producto);
                filaTemp1[4] = this.producto.getStrValor();
                filaTemp1[5] = tempObject.getTotal();
                double montopagado = 0;
                for (int j = 0; j < listaPagos.size(); j++) {
                    PagoPedido objPagotemp = (PagoPedido) listaPagos.get(j);
                    montopagado += objPagotemp.getDblMontoPago();
                }
                filaTemp1[6] = montopagado;
                defaultTableModel.addRow(filaTemp1);
            }
        } catch (Exception _e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar la información");
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Limpiar Tabla">
    public void limpiarTabla() {
        for (int i = 0; i < jtCentral.getRowCount(); i++) {
            defaultTableModel.removeRow(i);
            i -= 1;
        }
    }
//</editor-fold>

//</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbProveedor = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnHistorialPagos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCentral = new javax.swing.JTable();

        setClosable(true);
        setTitle("Pedido");

        btnAgregar.setBackground(new java.awt.Color(51, 51, 51));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(51, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2b(6)_48.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("Panel Acciones")));

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Proveedor:");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_e70a(0)_24.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Pedido");

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_270e(3)_24.png"))); // NOI18N
        btnEditar.setText("Agregar Pago");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2d(5)_24.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnHistorialPagos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHistorialPagos.setForeground(new java.awt.Color(51, 51, 51));
        btnHistorialPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2139(4)_24.png"))); // NOI18N
        btnHistorialPagos.setText("Pagos Previos");
        btnHistorialPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialPagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistorialPagos)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnHistorialPagos)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("Registros de pedidos")));

        jtCentral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtCentral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCentralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCentral);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            JdPedidoManager manager = new JdPedidoManager();
            //manager.setVisible(true);
            Object objTemp = manager.showDialog(null);
            Pedido conf = (Pedido) objTemp;
            //si el conf es diferente de null
            if (objTemp != null) {
                //invocamos nuestra controladora para agregar
                if (ctrlPedido.Agregar(objTemp)) {
                    //si el guardado fue correcto manda un mensaje
                    Notification.show("Mensaje del sistema", "Registro exitoso", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                } else {
                    //delo contrario = pero indicando
                    Notification.show("Mensaje del sistema", "Registro falló", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                }
            }
            //actualiza los datos del jtable de resultado
            this.limpiarTabla();
            this.loadRegistros();
            this.jtCentral.setRowSelectionInterval(0, 0);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (this.jtCentral.getRowCount() > 0) {
            try {
                JdAgregarPago manager = new JdAgregarPago();
                this.pedido.setId(this.id);
                this.pedido = (Pedido) ctrlPedido.ConsultaEspecifica(this.pedido);
                Object objTemp = manager.showDialog(null);
                PagoPedido objResultado = (PagoPedido) objTemp;
                //si el conf es diferente de null
                if (objTemp != null) {
                    objResultado.setIdPedido(this.pedido.getId());
                    //invocamos nuestra controladora para agregar
                    if (ctrlPagoPedido.Agregar(objResultado)) {
                        //si el guardado fue correcto manda un mensaje
                        Notification.show("Mensaje del sistema", "Registro exitoso", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                    } else {
                        //delo contrario = pero indicando
                        Notification.show("Mensaje del sistema", "Registro falló", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                    }
                }
                //actualiza los datos del jtable de resultado
                this.limpiarTabla();
                this.loadRegistros();
                jtCentral.setRowSelectionInterval(0, 0);
            } catch (Exception _e) {
                System.out.println(_e.getMessage());
                _e.printStackTrace();
            }
        } else {
            Notification.show("Mensaje del sistema", "No hay registros que editar", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (this.jtCentral.getRowCount() > 0) {
                this.pedido.setId(this.id);
                if (ctrlPedido.Delete(this.pedido)) {
                    //si el guardado fue correcto manda un mensaje
                    Notification.show("Mensaje del sistema", "Registro borrado", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                } else {
                    //delo contrario = pero indicando
                    Notification.show("Mensaje del sistema", "Registro no eliminado", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                }
                //actualiza los datos del jtable de resultado
                this.limpiarTabla();
                this.loadRegistros();
                jtCentral.setRowSelectionInterval(0, 0);
            } else {
                Notification.show("Mensaje del sistema", "No hay registros que eliminar", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            this.limpiarTabla();
            this.proveedor = (Proveedor) this.cmbProveedor.getSelectedItem();
            this.idFiltro = this.proveedor.getId();
            this.loadRegistros();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCentralMouseClicked
        try {
            int filac = this.jtCentral.getSelectedRow();
            this.id = (int) this.jtCentral.getValueAt(filac, 0);
            this.pedido.setId(this.id);
            this.pedido = (Pedido) ctrlPedido.ConsultaEspecifica(this.pedido);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_jtCentralMouseClicked

    private void btnHistorialPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPagosActionPerformed
        try {
            if (this.jtCentral.getRowCount() < 0) {
                 JOptionPane.showMessageDialog(null,"No existen registros para consultar");
                return;          
            }
            Pedido pedidoTemp = new Pedido();
            pedido.setId(id);
            JdRegistroPagos registroPagos = new JdRegistroPagos(pedido);
            registroPagos.setVisible(true);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnHistorialPagosActionPerformed

//<editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistorialPagos;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtCentral;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
