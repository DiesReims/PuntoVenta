package Vista.Producto;

import Abstract.ICatTipoProducto;
import Abstract.IProProducto;
import Control.Control.CtrlCatTipoProducto;
import Control.Control.CtrlProducto;
import Factory.FactoryCatTipoProducto;
import Factory.FactoryProProducto;
import Data.Entidad.CatTipoProducto;
import Data.Entidad.Producto;
import Model.Proproducto;
import Model.Cattipoproducto;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class IfrmProductoPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    CtrlProducto ctrlProducto = new CtrlProducto();
    DefaultTableModel t;
    DefaultTableModel tc;
    private int id;
    private int idcentral;
    private int fila;
    private int filac;
    private String consultaE;
    Producto baseEntity = new Producto();
    Proproducto baseEntityJPA = new Proproducto();
    
    //<editor-fold defaultstate="collapsed" desc="Variables JPA Migration">
    public IProProducto factory = FactoryProProducto.getInstance().getInstanceAbstract();
//</editor-fold>
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmProductoPrincipal() {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        jtFiltro.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtFiltro.getSelectedRow() != -1) {
                    fila = jtFiltro.getSelectedRow();
                    id = (int) jtFiltro.getValueAt(fila, 0);
                }
            }
        });
        String[] head = {"ID", "Categoria"};
        String[] headc = {"ID", "Producto"};
        Object[][] cuerpo = {};
        Object[][] cuerpoc = {};
        t = new DefaultTableModel(cuerpo, head);
        tc = new DefaultTableModel(cuerpoc, headc);
        this.loadInformation();
        jtFiltro.setRowSelectionInterval(0, 0);
        this.loadRegistros();
        jtCentral.setRowSelectionInterval(0, 0);
        this.jtCentralMouseClickedInitial();
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
            CtrlCatTipoProducto ctrlCatTipoProducto = new CtrlCatTipoProducto();
            ArrayList<Object> lista = ctrlCatTipoProducto.ConsultaGeneral(null);           
            //<editor-fold defaultstate="collapsed" desc="JPA CatTipoProducto Modificado">
            List<Cattipoproducto> listaTipoProducto = FactoryCatTipoProducto.getInstance().getInstanceAllTipoProducto();
//</editor-fold>         
            for (int i = 0; i < listaTipoProducto.size(); i++) {
                Object[] filaTemp = new Object[2];
//                CatTipoProducto objTemp = (CatTipoProducto) lista.get(i);
                 Cattipoproducto objTemp =  listaTipoProducto.get(i);
                filaTemp[0] = objTemp.getId();
                filaTemp[1] = objTemp.getStrvalor();
                t.addRow(filaTemp);
                jtFiltro.setModel(t);
                jtFiltro.getColumn("ID").setPreferredWidth(0);
                jtFiltro.getColumn("ID").setMinWidth(0);
                jtFiltro.getColumn("ID").setMaxWidth(0);
                jtFiltro.getColumn("ID").setWidth(0);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar los filtros");
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Load Registros">
    public void loadRegistros() {
        try {
//            ArrayList<Object> lista = this.ctrlProducto.ConsultaNoCatalogo(this.id);
            //<editor-fold defaultstate="collapsed" desc="JPA ProProducto Código Modificado">
            List<Proproducto> productos = FactoryProProducto.getInstance().getInstanceCatalogo(this.id);
//</editor-fold>         
//            for (int i = 0; i < lista.size(); i++) {
             for (int i = 0; i < productos.size(); i++) {
                Object[] filaTemp1 = new Object[2];
//                Producto tempObject = (Producto) lista.get(i);
                Proproducto tempObject = (Proproducto) productos.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrnombre();
                tc.addRow(filaTemp1);
                jtCentral.setModel(tc);
                jtCentral.getColumn("ID").setPreferredWidth(0);
                jtCentral.getColumn("ID").setMinWidth(0);
                jtCentral.getColumn("ID").setMaxWidth(0);
                jtCentral.getColumn("ID").setWidth(0);
             }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar la información");
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Limpiar Tabla">
    public void limpiarTabla() {
        for (int i = 0; i < jtCentral.getRowCount(); i++) {
            tc.removeRow(i);
            i -= 1;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Load Detalle">
    public void jtCentralMouseClickedInitial() {
        try {
            filac = jtCentral.getSelectedRow();
            if (filac != -1) {
//                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
//                this.baseEntity.setId(this.idcentral);
//                this.baseEntity = (Producto) ctrlProducto.ConsultaEspecifica(this.baseEntity);
//                this.lblCategoria.setText(String.valueOf(jtFiltro.getValueAt(fila, 1)));
//                this.lblCodigo.setText(this.baseEntity.getStrCodigo());
//                this.lblProducto.setText(this.baseEntity.getStrValor());
//                this.lblCantidad.setText(String.valueOf(this.baseEntity.getIntCantidad()));
//                this.lblPrecioCompra.setText(String.valueOf(this.baseEntity.getDblPrecioCompra()));
//                this.lblPrecioVenta.setText(String.valueOf(this.baseEntity.getDblPrecioVenta()));
                
                //<editor-fold defaultstate="collapsed" desc="JPA Código Modificado">
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntityJPA.setId(this.idcentral);
                this.baseEntityJPA = FactoryProProducto.getInstance().getInstanceSpecificById(baseEntityJPA);
                this.lblCategoria.setText(String.valueOf(jtFiltro.getValueAt(fila, 1)));
                this.lblCodigo.setText(this.baseEntityJPA.getStridentificador());
                this.lblProducto.setText(this.baseEntityJPA.getStrnombre());
                this.lblCantidad.setText(String.valueOf(this.baseEntityJPA.getIntcantidad()));
                this.lblPrecioCompra.setText(String.valueOf(this.baseEntityJPA.getDecpreciocompra()));
                this.lblPrecioVenta.setText(String.valueOf(this.baseEntityJPA.getDecprecioventa()));
//</editor-fold>
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }

    //</editor-fold>
//</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetalle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPrecioCompra = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblPrecioVenta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCentral = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFiltro = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblFormulario = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Productos");
        setToolTipText("Gestión de Productos");

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51)))); // NOI18N
        pnlDetalle.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2139(4)_24.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Código:");

        lblCodigo.setText("Información");

        lblProducto.setText("Información");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Producto:");

        lblCantidad.setText("Información");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cantidad:");

        lblCategoria.setText("Información");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Categoria:");

        lblPrecioCompra.setText("Información");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Precio Compra:");

        lblPrecioVenta.setText("Información");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Precio Venta:");

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetalleLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPrecioVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProducto, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblPrecioCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblPrecioVenta))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Registros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51)))); // NOI18N

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
        jtCentral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCentralKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtCentral);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51)))); // NOI18N

        jtFiltro.setModel(new javax.swing.table.DefaultTableModel(
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
        jtFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFiltroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFiltro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(1200, 700));

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_270e(3)_24.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2d(5)_24.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_e70a(0)_24.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setText("Buscar...");
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2b(6)_24.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblFormulario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFormulario.setForeground(new java.awt.Color(51, 51, 51));
        lblFormulario.setText("Productos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(118, 118, 118)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFormulario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormulario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnBuscar)
                        .addComponent(btnEditar)
                        .addComponent(btnEliminar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="EVT Agregar">
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            JdProductoManager manager = new JdProductoManager();
            //manager.setVisible(true);
            Object objTemp = manager.showDialog(null);
//            Producto conf = (Producto) objTemp;
            Proproducto confJPA = (Proproducto) objTemp;
            //si el conf es diferente de null
            if (objTemp != null) {
                //Invocamos nuestra controladora para agregar
//                if (ctrlProducto.Agregar(objTemp)) {
                    this.factory.create(confJPA);
                    //si el guardado fue correcto manda un mensaje
                     Notification.show("Mensaje del sistema","Registro exitoso",Notification.NICON_LIGHT_THEME,true,Notification.OK_MESSAGE,2000);             
            }
            //Actualiza los datos del jtable de resultado
            this.limpiarTabla();
            this.loadRegistros();
            this.jtCentral.setRowSelectionInterval(0, 0);
        } catch (Exception _e) {
             Notification.show("Mensaje del sistema","Registro falló",Notification.NICON_LIGHT_THEME,true,Notification.ERROR_MESSAGE,2000);
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Buscar">
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
//            this.baseEntity.setIdTipoProducto(id);
//            this.baseEntity.setStrCodigo(this.txtBuscar.getText().trim());
            this.baseEntityJPA.getIdcattipoproducto().setId(id);
            this.baseEntityJPA.setStrnombre(this.txtBuscar.getText().trim());
//            ArrayList<Object> lista = ctrlProducto.ConsultaBuscar(this.baseEntity);
            List<Proproducto> productos = FactoryProProducto.getInstance().getInstanceBusquedaProductoNombre(baseEntityJPA);
            this.limpiarTabla();
            for (int i = 0; i < productos.size(); i++) {
                Object[] filaTemp1 = new Object[2];
//                Producto tempObject = (Producto) lista.get(i);
                Proproducto tempObject = productos.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrnombre();
                tc.addRow(filaTemp1);
                jtCentral.setModel(tc);
                jtCentral.getColumn("ID").setPreferredWidth(0);
                jtCentral.getColumn("ID").setMinWidth(0);
                jtCentral.getColumn("ID").setMaxWidth(0);
                jtCentral.getColumn("ID").setWidth(0);
                if (jtCentral.getRowCount() > -1) {
                    jtCentral.setRowSelectionInterval(0, 0);
                    this.jtCentralMouseClickedInitial();
                }
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Editar">
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Boton para modificar
        if (tc.getRowCount() > 0) {
            try {
                JdProductoManager manager = new JdProductoManager();
                this.baseEntity.setId(this.idcentral);
                this.baseEntityJPA.setId(this.idcentral);
                this.baseEntity = (Producto) ctrlProducto.ConsultaEspecifica(this.baseEntity);
                this.baseEntityJPA = FactoryProProducto.getInstance().getInstanceSpecificById(baseEntityJPA);              
                Object objTemp = manager.showDialog(this.baseEntity);
//                Producto objResultado = (Producto) objTemp;
                Proproducto objResultado = (Proproducto) objTemp;
                //si el conf es diferente de null
                if (objTemp != null) {
                    //invocamos nuestra controladora para agregar
                        factory.edit(objResultado);
                        //si el guardado fue correcto manda un mensaje
                        Notification.show("Mensaje del sistema","Registro actualizado",Notification.NICON_LIGHT_THEME,true,Notification.OK_MESSAGE,2000);                           
                        }
                //actualiza los datos del jtable de resultado
                this.limpiarTabla();
                this.loadRegistros();
                jtCentral.setRowSelectionInterval(0, 0);
            } catch (Exception _e) {
                 Notification.show("Mensaje del sistema","Registro falló",Notification.NICON_LIGHT_THEME,true,Notification.ERROR_MESSAGE,2000);
                System.out.println(_e.getMessage());
            }
        } else {
           Notification.show("Mensaje del sistema","No hay registros que editar",Notification.NICON_LIGHT_THEME,true,Notification.ERROR_MESSAGE,2000);
        }
    }//GEN-LAST:event_btnEditarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Eliminar">
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (tc.getRowCount() > 0) {
                this.baseEntity.setId(this.idcentral);
                if (ctrlProducto.Delete(this.baseEntity)) {
                    //si el guardado fue correcto manda un mensaje
                    Notification.show("Mensaje del sistema","Registro borrado",Notification.NICON_LIGHT_THEME,true,Notification.OK_MESSAGE,2000);
                } else {
                    //delo contrario = pero indicando
                    Notification.show("Mensaje del sistema","Registro no eliminado",Notification.NICON_LIGHT_THEME,true,Notification.ERROR_MESSAGE,2000);
                }
                //actualiza los datos del jtable de resultado
                this.limpiarTabla();
                this.loadRegistros();
                jtCentral.setRowSelectionInterval(0, 0);
            } else {
                Notification.show("Mensaje del sistema","No hay registros que eliminar",Notification.NICON_LIGHT_THEME,true,Notification.ERROR_MESSAGE,2000);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Filtro Click">
    private void jtFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFiltroMouseClicked
        try {
            this.limpiarTabla();
            this.loadRegistros();
            jtCentral.setRowSelectionInterval(0, 0);
//            this.jtCentralMouseClickedinitial();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_jtFiltroMouseClicked
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Central Click">
    private void jtCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCentralMouseClicked
        try {
            filac = jtCentral.getSelectedRow();
            if (filac != -1) {
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Producto) ctrlProducto.ConsultaEspecifica(this.baseEntity);
                this.lblCategoria.setText(String.valueOf(jtFiltro.getValueAt(fila, 1)));
                this.lblCodigo.setText(this.baseEntity.getStrCodigo());
                this.lblProducto.setText(this.baseEntity.getStrValor());
                this.lblCantidad.setText(String.valueOf(this.baseEntity.getIntCantidad()));
                this.lblPrecioCompra.setText(String.valueOf(this.baseEntity.getDblPrecioCompra()));
                this.lblPrecioVenta.setText(String.valueOf(this.baseEntity.getDblPrecioVenta()));
                
                //<editor-fold defaultstate="collapsed" desc="JPA Código Modificado">
                    this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntityJPA.setId(this.idcentral);
                this.baseEntityJPA = FactoryProProducto.getInstance().getInstanceSpecificById(baseEntityJPA);
                this.lblCategoria.setText(String.valueOf(jtFiltro.getValueAt(fila, 1)));
                this.lblCodigo.setText(this.baseEntityJPA.getStridentificador());
                this.lblProducto.setText(this.baseEntityJPA.getStrnombre());
                this.lblCantidad.setText(String.valueOf(this.baseEntityJPA.getIntcantidad()));
                this.lblPrecioCompra.setText(String.valueOf(this.baseEntityJPA.getDecpreciocompra()));
                this.lblPrecioVenta.setText(String.valueOf(this.baseEntityJPA.getDecprecioventa()));
//</editor-fold>
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_jtCentralMouseClicked
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Central Key Pressed">
    private void jtCentralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCentralKeyPressed
        int c = evt.getKeyCode();

        if (c == KeyEvent.VK_UP) {
            filac = jtCentral.getSelectedRow() - 1;
            if (filac != -1) {

//                lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
//                lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
//                lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
            }
            System.out.println("arriba");
        }
        if (c == KeyEvent.VK_DOWN) {
            filac = jtCentral.getSelectedRow() + 1;
            if (filac != -1) {

//                lblid.setText(String.valueOf(jtCentral.getValueAt(filac, 0)));
//                lblvalor.setText(String.valueOf(jtCentral.getValueAt(filac, 1)));
//                lbldescripcion.setText(String.valueOf(jtEstado.getValueAt(fila, 1)));
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
            }
            System.out.println("abajo");
        }
    }//GEN-LAST:event_jtCentralKeyPressed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EVT Buscar Focus Gained"> 
    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        this.txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtCentral;
    private javax.swing.JTable jtFiltro;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFormulario;
    private javax.swing.JLabel lblPrecioCompra;
    private javax.swing.JLabel lblPrecioVenta;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
