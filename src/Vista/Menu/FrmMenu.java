package Vista.Menu;

import Vista.GoogleMaps.frmGoogleMaps;
import Vista.Graficas.IfrmGraficasPrincipal;
import Vista.Pedido.IfrmPedidoPrincipal;
import Vista.Producto.IfrmProductoPrincipal;
import Vista.Proveedor.IfrmProveedorPrincipal;
import Vista.Venta.IfrmVentaPrincipal;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import nicon.notify.core.Notification;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class FrmMenu extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private int x;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public FrmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAcciones = new javax.swing.JMenu();
        miVenta = new javax.swing.JMenuItem();
        miProducto = new javax.swing.JMenuItem();
        miProveedor = new javax.swing.JMenuItem();
        jmPedido = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jmGraficas = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abarrotes y Productos \"Querencia\"");
        setMinimumSize(new java.awt.Dimension(700, 500));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1162, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setOpaque(false);

        jmAcciones.setForeground(new java.awt.Color(51, 51, 51));
        jmAcciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_25be(1)_32.png"))); // NOI18N
        jmAcciones.setText("Acciones");
        jmAcciones.setToolTipText("Acciones");
        jmAcciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        miVenta.setText("Venta");
        miVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVentaActionPerformed(evt);
            }
        });
        jmAcciones.add(miVenta);

        miProducto.setText("Producto");
        miProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProductoActionPerformed(evt);
            }
        });
        jmAcciones.add(miProducto);

        miProveedor.setText("Proveedor");
        miProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProveedorActionPerformed(evt);
            }
        });
        jmAcciones.add(miProveedor);

        jmPedido.setText("Pedido");
        jmPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPedidoActionPerformed(evt);
            }
        });
        jmAcciones.add(jmPedido);

        jMenuBar1.add(jmAcciones);

        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2699(0)_32.png"))); // NOI18N
        jMenu2.setText("Configuración");
        jMenu2.setToolTipText("Configuración");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu4.setForeground(new java.awt.Color(51, 51, 51));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_d83d(2)_32.png"))); // NOI18N
        jMenu4.setText("Análisis");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmGraficas.setText("Graficas");
        jmGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGraficasActionPerformed(evt);
            }
        });
        jMenu4.add(jmGraficas);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Módulo Producto">
    private void miProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProductoActionPerformed
        try {
            this.limpiarEscritorio();
            Vista.Producto.IfrmProductoPrincipal productoPrincipal = new IfrmProductoPrincipal();
            this.escritorio.add(productoPrincipal);
            Dimension EscritorioSize = this.escritorio.getSize();
            Dimension jInternalFrameSize = productoPrincipal.getSize();
            productoPrincipal.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                    (EscritorioSize.height - jInternalFrameSize.height) / 2);
            productoPrincipal.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar el módulo");
        }

    }//GEN-LAST:event_miProductoActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Módulo Proveedor">
    private void miProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProveedorActionPerformed
        try {
            this.limpiarEscritorio();
            Vista.Proveedor.IfrmProveedorPrincipal proveedorPrincipal = new IfrmProveedorPrincipal();
            this.escritorio.add(proveedorPrincipal);
            Dimension EscritorioSize = this.escritorio.getSize();
            Dimension jInternalFrameSize = proveedorPrincipal.getSize();
            proveedorPrincipal.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                    (EscritorioSize.height - jInternalFrameSize.height) / 2);
            proveedorPrincipal.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar el módulo");
        }
    }//GEN-LAST:event_miProveedorActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Módulo Venta">
    private void miVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVentaActionPerformed
        try {
            this.limpiarEscritorio();
             Vista.Venta.IfrmVentaPrincipal ventaPrincipal = new IfrmVentaPrincipal();
        this.escritorio.add(ventaPrincipal);
          Dimension EscritorioSize = this.escritorio.getSize();
            Dimension jInternalFrameSize = ventaPrincipal.getSize();
            ventaPrincipal.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                    (EscritorioSize.height - jInternalFrameSize.height) / 2);
            ventaPrincipal.show();
        } catch (Exception _e) {
        JOptionPane.showMessageDialog(null,"Ha ocurrido un error al cargar el módulo","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }     
    }//GEN-LAST:event_miVentaActionPerformed
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Módulo Pedido">
    private void jmPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPedidoActionPerformed
        try {
             this.limpiarEscritorio();
             Vista.Pedido.IfrmPedidoPrincipal pedidoPrincipal = new IfrmPedidoPrincipal();
             this.escritorio.add(pedidoPrincipal);
             Dimension EscritorioSize = this.escritorio.getSize();
            Dimension jInternalFrameSize = pedidoPrincipal.getSize();
            pedidoPrincipal.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                    (EscritorioSize.height - jInternalFrameSize.height) / 2);
            pedidoPrincipal.show();
        } catch (Exception _e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al cargar el módulo","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmPedidoActionPerformed

    private void jmGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGraficasActionPerformed
        try {
             this.limpiarEscritorio();
             Vista.Graficas.IfrmGraficasPrincipal graficasPrincipal = new IfrmGraficasPrincipal();
             this.escritorio.add(graficasPrincipal);
             Dimension EscritorioSize = this.escritorio.getSize();
            Dimension jInternalFrameSize = graficasPrincipal.getSize();
            graficasPrincipal.setLocation((EscritorioSize.width - jInternalFrameSize.width) / 2,
                    (EscritorioSize.height - jInternalFrameSize.height) / 2);
            graficasPrincipal.show();
        } catch (Exception _e) {
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error al cargar el módulo","Mensaje del sistema",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmGraficasActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Limpiar Escritorio">
    public void limpiarEscritorio() {
        this.escritorio.removeAll();
        this.escritorio.repaint();
    }
//</editor-fold>

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jmAcciones;
    private javax.swing.JMenuItem jmGraficas;
    private javax.swing.JMenuItem jmPedido;
    private javax.swing.JMenuItem miProducto;
    private javax.swing.JMenuItem miProveedor;
    private javax.swing.JMenuItem miVenta;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
