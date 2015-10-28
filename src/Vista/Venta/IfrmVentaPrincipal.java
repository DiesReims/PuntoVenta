package Vista.Venta;

import Control.Control.CtrlProducto;
import Control.Control.CtrlVenta;
import Control.Control.CtrlVentaProducto;
import Control.Validacion.CtrlValidacionInfo;
import Data.Entidad.Producto;
import Data.Entidad.Venta;
import Data.Entidad.VentaProducto;
import Vista.Devolucion.JdDevolucion;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class IfrmVentaPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    CtrlProducto ctrlProducto = new CtrlProducto();
    CtrlVenta ctrlVenta = new CtrlVenta();
    CtrlValidacionInfo ctrlValidacionInfo = new CtrlValidacionInfo();
    CtrlVentaProducto ctrlventaProducto = new CtrlVentaProducto();
    Venta venta = new Venta();
    VentaProducto ventaProducto = new VentaProducto();
    Producto producto = new Producto();
    DefaultTableModel tableModel;
    private int filaActual;
    private double dbltotal;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmVentaPrincipal() {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        String[] head = {"IdVenta", "IdProducto", "Producto", "Cantidad", "Subtotal"};
        Object[][] cuerpo = {};
        this.tableModel = new DefaultTableModel(cuerpo, head);
        this.jtVenta.setModel(tableModel);
        this.btnAgregar.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnAceptar.setEnabled(false);
        this.lblTotal.setText("$ 0 Pesos");
        this.lblEstadoVenta.setText("Espera...");
        this.lblIva.setText("$ 0 Pesos");
        this.lblCantidadArticulos.setText("0 Articulos");

        jtVenta.getColumn("IdVenta").setPreferredWidth(0);
        jtVenta.getColumn("IdVenta").setMinWidth(0);
        jtVenta.getColumn("IdVenta").setMaxWidth(0);
        jtVenta.getColumn("IdVenta").setWidth(0);

        jtVenta.getColumn("IdProducto").setPreferredWidth(0);
        jtVenta.getColumn("IdProducto").setMinWidth(0);
        jtVenta.getColumn("IdProducto").setMaxWidth(0);
        jtVenta.getColumn("IdProducto").setWidth(0);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    //<editor-fold defaultstate="collapsed" desc="Actualizar Cintillo Detalle">
    public void RefrescarInformación() {
        try {
            int cantidadProducto = 0;
            double total = 0;
            double iva = 0;
            for (int i = 0; i < this.jtVenta.getRowCount(); i++) {
                cantidadProducto += (int) this.jtVenta.getValueAt(i, 3);
                total += (double) this.jtVenta.getValueAt(i, 4);
            }
            this.dbltotal = total;
            this.lblTotal.setText("$" + total + " Pesos");
            this.lblCantidadArticulos.setText(cantidadProducto + " Articulos");
            this.lblIva.setText("$" + String.valueOf(total * 0.16) + " Pesos");
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Limpiar Tabla">
    public void limpiarTabla() {
        for (int i = 0; i < jtVenta.getRowCount(); i++) {
            tableModel.removeRow(i);
            i -= 1;
        }
    }
//</editor-fold>
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVenta = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblFormulario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        btnDevolucion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCantidadArticulos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEstadoVenta = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ventas");
        setToolTipText("Gestión de Ventas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Panel Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11)))); // NOI18N

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_270e(3)_32.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2d(5)_32.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2b(6)_32.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar)
                .addGap(44, 44, 44)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Detalle de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11)))); // NOI18N

        jtVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jtVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11)))); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_e70a(0)_24.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblFormulario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFormulario.setForeground(new java.awt.Color(51, 51, 51));
        lblFormulario.setText("Ventas");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Folio:");

        lblFolio.setText("0001");

        btnDevolucion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDevolucion.setForeground(new java.awt.Color(51, 51, 51));
        btnDevolucion.setText("Devolución");
        btnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblFormulario)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFolio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(137, 137, 137)
                .addComponent(btnDevolucion)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormulario)
                            .addComponent(jLabel7)
                            .addComponent(lblFolio))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnDevolucion))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Panel Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11)))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Total:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Articulos:");

        lblCantidadArticulos.setForeground(new java.awt.Color(51, 51, 51));
        lblCantidadArticulos.setText("Cant. Articulos");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Estado venta:");

        lblEstadoVenta.setForeground(new java.awt.Color(51, 51, 51));
        lblEstadoVenta.setText("Generando...");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2715(1)_24.png"))); // NOI18N
        btnCancelar.setText("Cancelar venta");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2713(2)_24.png"))); // NOI18N
        btnAceptar.setText("Confirmar venta");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblTotal.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal.setText("Resultado venta");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("IVA:");

        lblIva.setForeground(new java.awt.Color(51, 51, 51));
        lblIva.setText("Generando...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCantidadArticulos)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstadoVenta)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIva)
                    .addComponent(jLabel10)
                    .addComponent(lblEstadoVenta)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(jLabel8)
                    .addComponent(lblCantidadArticulos)
                    .addComponent(jLabel6)
                    .addComponent(lblTotal)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11)))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Producto:");

        txtProducto.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cantidad:");

        txtExistencia.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Existencia:");

        txtPrecioUnitario.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Precio Unitario:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProducto)
                    .addComponent(txtExistencia)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrecioUnitario))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="EVT Agregar">
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            if (this.txtCantidad.getText().trim().equals("")) {
                Notification.show("Mensaje del sistema", "Ingresa una cantidad", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                return;
            }
            if (!ctrlValidacionInfo.SoloNumeros(this.txtCantidad.getText().trim())) {
                Notification.show("Mensaje del sistema", "Solo numeros", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                return;
            }
            if (Integer.parseInt(this.txtCantidad.getText().trim()) > this.producto.getIntCantidad()) {
                Notification.show("Mensaje del sistema", "No existe stock suficiente", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                return;
            }
            Object[] filaTemp = new Object[5];
            filaTemp[0] = "0";
            filaTemp[1] = producto.getId();
            filaTemp[2] = producto.getStrValor();
            filaTemp[3] = Integer.parseInt(this.txtCantidad.getText());
            double tempCalculo = Integer.parseInt(this.txtCantidad.getText().trim()) * this.producto.getDblPrecioVenta();
            filaTemp[4] = tempCalculo;
            tableModel.addRow(filaTemp);
            jtVenta.setModel(tableModel);
            this.btnAceptar.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            this.RefrescarInformación();
            this.lblEstadoVenta.setText("Proceso...");
            this.txtBuscar.requestFocus();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        } finally {
            this.btnAgregar.setEnabled(false);
            this.txtCantidad.setText("");
            this.txtExistencia.setText("");
            this.txtPrecioUnitario.setText("");
            this.txtProducto.setText("");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Editar">
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            this.jtVenta.setValueAt(this.txtCantidad.getText().trim(), this.filaActual, 3);
            double tempCalculo = Integer.parseInt(this.txtCantidad.getText().trim()) * Double.parseDouble(this.txtPrecioUnitario.getText().trim());
            this.jtVenta.setValueAt(tempCalculo, this.filaActual, 4);
            this.btnEditar.setEnabled(false);
            this.btnEliminar.setEnabled(false);
            this.RefrescarInformación();
            this.txtBuscar.requestFocus();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Eliminar">  
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            this.tableModel.removeRow(this.filaActual);
            this.txtCantidad.setText("");
            this.txtExistencia.setText("");
            this.txtPrecioUnitario.setText("");
            this.txtProducto.setText("");
            this.btnEditar.setEnabled(false);
            this.btnEliminar.setEnabled(false);
            if (this.jtVenta.getRowCount() <= 0) {
                this.btnAceptar.setEnabled(false);
                this.btnCancelar.setEnabled(false);
                this.lblEstadoVenta.setText("Espera...");
            }
            this.RefrescarInformación();
            this.txtBuscar.requestFocus();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Aceptar">
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            double pago = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el pago"));
            double cambio = pago - this.dbltotal;
            if (cambio < 0) {
                JOptionPane.showMessageDialog(null, "Pago insuficiente", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "El cambio es de : $" + cambio + " Pesos.");
            }
            if (this.jtVenta.getRowCount() > 0) {

                String noFolio = "000";
                int ultimoFolio = ctrlVenta.ObtenerMaximoId();
                ultimoFolio += 1;
                noFolio += ultimoFolio;
                this.venta.setStrFolio(noFolio);
                this.lblFolio.setText(noFolio);
                if (ctrlVenta.Agregar(this.venta)) {
                    int idVenta = ctrlVenta.ObtenerMaximoId();
                    for (int i = 0; i < this.jtVenta.getRowCount(); i++) {
                        this.ventaProducto.setIdVenta(idVenta);
                        this.ventaProducto.setIdProducto((int) this.jtVenta.getValueAt(i, 1));
                        this.ventaProducto.setIntCantidad((int) this.jtVenta.getValueAt(i, 3));
                        this.ventaProducto.setSubtotal((double) this.jtVenta.getValueAt(i, 4));
                        Producto productoTemp = new Producto();
                        productoTemp.setId((int) this.jtVenta.getValueAt(i, 1));
                        productoTemp = (Producto) ctrlProducto.ConsultaEspecifica(productoTemp);
                        productoTemp.setIntCantidad(productoTemp.getIntCantidad() - (int) this.jtVenta.getValueAt(i, 3));
                        if (!ctrlProducto.ModifcarStock(productoTemp)) {
                            Notification.show("Mensaje del sistema", "Ocurrio un error en stock", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                            return;
                        }
                        if (!this.ctrlventaProducto.Agregar(this.ventaProducto)) {
                            Notification.show("Mensaje del sistema", "No se registro la venta", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                            return;
                        }
                    }
                    Notification.show("Mensaje del sistema", "Venta exitosa", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                }

            }
        } catch (Exception _e) {
            Notification.show("Mensaje del sistema", "Error al guardar la venta", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Cancelar">
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            this.limpiarTabla();
            this.producto = new Producto();
            this.btnCancelar.setEnabled(false);
            this.btnAceptar.setEnabled(false);
            this.btnAgregar.setEnabled(false);
            this.btnEditar.setEnabled(false);
            this.btnEliminar.setEnabled(false);
            this.RefrescarInformación();
            this.lblEstadoVenta.setText("Espera...");
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Venta Click">
    private void jtVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentaMouseClicked
        try {
            this.filaActual = this.jtVenta.getSelectedRow();
            this.producto.setId((int) this.jtVenta.getValueAt(filaActual, 1));
            this.producto = (Producto) this.ctrlProducto.ConsultaEspecifica(this.producto);
            this.txtProducto.setText(this.producto.getStrValor());
            this.txtExistencia.setText(String.valueOf(this.producto.getIntCantidad()));
            this.txtPrecioUnitario.setText(String.valueOf(this.producto.getDblPrecioVenta()));
            this.btnEditar.setEnabled(true);
            this.btnEliminar.setEnabled(true);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_jtVentaMouseClicked
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Buscar">
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            producto.setStrCodigo(this.txtBuscar.getText().trim());
            ArrayList<Object> listaResultado = ctrlProducto.ConsultaBuscarVenta(producto);
            if (listaResultado.size() > 1) {
                Notification.show("Mensaje del sistema", "Busqeuda ambigüa", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
            } else {
                for (int i = 0; i < listaResultado.size(); i++) {
                    this.producto = (Producto) listaResultado.get(i);
                }
                this.txtProducto.setText(this.producto.getStrValor());
                this.txtExistencia.setText(String.valueOf(this.producto.getIntCantidad()));
                this.txtPrecioUnitario.setText(String.valueOf(this.producto.getDblPrecioVenta()));
                this.btnAgregar.setEnabled(true);
                this.txtCantidad.requestFocus();
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        } finally {
            this.txtBuscar.setText("");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Devolucion">
    private void btnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionActionPerformed
        try {
            JdDevolucion jDevolucion = new JdDevolucion();
            jDevolucion.setVisible(true);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnDevolucionActionPerformed
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtVenta;
    private javax.swing.JLabel lblCantidadArticulos;
    private javax.swing.JLabel lblEstadoVenta;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblFormulario;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
