package Vista.Graficas;

import Control.Control.CtrlPedido;
import Control.Control.CtrlProducto;
import Control.Control.CtrlProveedor;
import Control.Control.CtrlVenta;
import Control.Control.CtrlVentaProducto;
import Data.Entidad.Pedido;
import Data.Entidad.Producto;
import Data.Entidad.Proveedor;
import Data.Entidad.Venta;
import Data.Entidad.VentaProducto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import net.sf.jasperreports.engine.type.ColorEnum;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class IfrmGraficasPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Variable">
    CtrlVenta ctrlVenta = new CtrlVenta();
    CtrlProveedor ctrlProveedor = new CtrlProveedor();
    CtrlPedido ctrlPedido = new CtrlPedido();
    CtrlVentaProducto ctrlVentaProducto = new CtrlVentaProducto();
    Venta venta = new Venta();
    CtrlProducto ctrlProducto = new CtrlProducto();
    Producto producto = new Producto();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmGraficasPrincipal() {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        Date date = new Date();
        this.jdcInicial.setDate(date);
        this.jdcFinal.setDate(date);
    }
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGenerarInformacion = new javax.swing.JButton();
        jdcInicial = new com.toedter.calendar.JDateChooser();
        jdcFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtpContenedor = new javax.swing.JTabbedPane();
        jtpVentas = new javax.swing.JTabbedPane();
        jtbProductos = new javax.swing.JTabbedPane();
        jtpProveedor = new javax.swing.JTabbedPane();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Graficos");

        btnGenerarInformacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerarInformacion.setForeground(new java.awt.Color(51, 51, 51));
        btnGenerarInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2139(4)_24.png"))); // NOI18N
        btnGenerarInformacion.setText("Generar Información");
        btnGenerarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarInformacionActionPerformed(evt);
            }
        });

        jdcInicial.setBackground(new java.awt.Color(255, 255, 255));

        jdcFinal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Desde:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Hasta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGenerarInformacion)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jdcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnGenerarInformacion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpContenedor.addTab("Venta", jtpVentas);
        jtpContenedor.addTab("Productos", jtbProductos);
        jtpContenedor.addTab("Proveedor", jtpProveedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpContenedor))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jtpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarInformacionActionPerformed
        try {
            int numeroDeProductosVendidos = 0;
            ArrayList<Object> listaProductos = ctrlProducto.ConsultaGeneral(null);
            ArrayList<Object> listaVentas = ctrlVenta.ConsultaGeneral(null);
            ArrayList<Object> listaProveedores = ctrlProveedor.ConsultaGeneral(null);
            ArrayList<Object> listaDetalleVenta = ctrlVentaProducto.ConsultaGeneral(null);
            DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
            DefaultCategoryDataset defaultCaategoryDatasetVentas = new DefaultCategoryDataset();
            DefaultCategoryDataset defaultCategoryDatasetProveedor = new DefaultCategoryDataset();
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto productoTemp = (Producto) listaProductos.get(i);
                defaultCategoryDataset.setValue(productoTemp.getIntCantidad(),"",productoTemp.getStrValor());
           }
            for (int i = 0; i < listaDetalleVenta.size(); i++) {
                VentaProducto detalleventa = (VentaProducto) listaDetalleVenta.get(i);
               numeroDeProductosVendidos += detalleventa.getIntCantidad();
            }
            for (int i = 0; i < listaProveedores.size(); i++) {
                Proveedor proveedorTemp = (Proveedor) listaProveedores.get(i);
                ArrayList<Object> listaPedidos = ctrlPedido.ConsultaNoCatalogo(proveedorTemp.getId());
                int numeroPedidosCondicionados = 0;
                for (int j = 0; j < listaPedidos.size(); j++) {
                    Pedido pedido = (Pedido) listaPedidos.get(j);
                    if ((pedido.getDteFechaPedido().after(this.jdcInicial.getDate()) &&(pedido.getDteFechaPedido().before(this.jdcFinal.getDate()))) ) {
                        numeroPedidosCondicionados += 1;
                    }
                }
                
                defaultCategoryDatasetProveedor.setValue(numeroPedidosCondicionados,"", proveedorTemp.getStrNombreContacto() + proveedorTemp.getStrApellidoPContacto());
            }
            defaultCaategoryDatasetVentas.setValue(listaVentas.size(),"","No. ventas");
            defaultCaategoryDatasetVentas.setValue(numeroDeProductosVendidos,"","No. Productos vendidos");
            JFreeChart chartVenta = ChartFactory.createBarChart3D("No. Ventas","","",defaultCaategoryDatasetVentas,PlotOrientation.HORIZONTAL,false,false,false);
            JFreeChart chartProducto = ChartFactory.createBarChart("Stock Productos","","", defaultCategoryDataset,PlotOrientation.VERTICAL,false,false,false);
            JFreeChart chartProveedor = ChartFactory.createBarChart("Compras Proveedor","","", defaultCategoryDatasetProveedor,PlotOrientation.HORIZONTAL,false,false,false);
            CategoryPlot categoryPlotProveedor = chartProveedor.getCategoryPlot();
            CategoryPlot categoryPlot = chartProducto.getCategoryPlot();
            CategoryPlot categoryPlotVentas = chartVenta.getCategoryPlot();
            categoryPlotVentas.setRangeGridlinePaint(Color.DARK_GRAY);
            categoryPlot.setRangeGridlinePaint(Color.DARK_GRAY);
            categoryPlotProveedor.setRangeGridlinePaint(Color.DARK_GRAY);
            ChartPanel chartPanelVenta = new ChartPanel(chartVenta);
            ChartPanel chartPanel = new ChartPanel(chartProducto);
            ChartPanel chartPanelProveedor = new ChartPanel(chartProveedor);
            this.jtpVentas.removeAll();
            this.jtpVentas.add(chartPanelVenta,BorderLayout.CENTER);
            this.jtpVentas.validate();
            this.jtbProductos.removeAll();
            this.jtbProductos.add(chartPanel,BorderLayout.CENTER);
            this.jtbProductos.validate();
            this.jtpProveedor.removeAll();
            this.jtpProveedor.add(chartPanelProveedor,BorderLayout.CENTER);
            this.jtpProveedor.validate();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerarInformacionActionPerformed

//<editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarInformacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcFinal;
    private com.toedter.calendar.JDateChooser jdcInicial;
    private javax.swing.JTabbedPane jtbProductos;
    private javax.swing.JTabbedPane jtpContenedor;
    private javax.swing.JTabbedPane jtpProveedor;
    private javax.swing.JTabbedPane jtpVentas;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
