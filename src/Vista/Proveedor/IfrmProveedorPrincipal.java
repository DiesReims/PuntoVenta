package Vista.Proveedor;

import Control.Control.CtrlCatTipoProveedor;
import Control.Control.CtrlDireccion;
import Control.Control.CtrlProveedor;
import Control.Control.CtrlTelefono;
import Control.Validacion.CtrlCorreo;
import Data.Entidad.Direccion;
import Data.Entidad.Telefono;
import Data.Entidad.CatTipoProveedor;
import Data.Entidad.Proveedor;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import nicon.notify.core.Notification;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class IfrmProveedorPrincipal extends javax.swing.JInternalFrame {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    CtrlProveedor ctrlProveedor = new CtrlProveedor();
    CtrlTelefono ctrlTelefono = new CtrlTelefono();
    CtrlDireccion ctrlDireccion = new CtrlDireccion();
    DefaultTableModel t;
    DefaultTableModel tc;
    private int id;
    private int idcentral;
    private int fila;
    private int filac;
    private String consultaE;
    Proveedor baseEntity = new Proveedor();
    Direccion baseDir = new Direccion();
    Telefono baseTel = new Telefono();
    ArrayList<Object> telefonos = new ArrayList();
    ArrayList<Telefono> listaTelefonos = new ArrayList();
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public IfrmProveedorPrincipal() {
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
        String[] headc = {"ID", "Proveedor Contacto"};
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
            CtrlCatTipoProveedor ctrlCatTipoProveedor = new CtrlCatTipoProveedor();
            ArrayList<Object> lista = ctrlCatTipoProveedor.ConsultaGeneral(null);
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp = new Object[2];
                CatTipoProveedor objTemp = (CatTipoProveedor) lista.get(i);
                filaTemp[0] = objTemp.getId();
                filaTemp[1] = objTemp.getStrValor();
                t.addRow(filaTemp);
                jtFiltro.setModel(t);

                jtFiltro.getColumn("ID").setPreferredWidth(0);
                jtFiltro.getColumn("ID").setMinWidth(0);
                jtFiltro.getColumn("ID").setMaxWidth(0);
                jtFiltro.getColumn("ID").setWidth(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar los filtros");
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Load Registros">
    public void loadRegistros() {
        try {
            ArrayList<Object> lista = this.ctrlProveedor.ConsultaNoCatalogo(this.id);
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp1 = new Object[2];
                Proveedor tempObject = (Proveedor) lista.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrNombreContacto();
                tc.addRow(filaTemp1);
                jtCentral.setModel(tc);
                jtCentral.getColumn("ID").setPreferredWidth(0);
                jtCentral.getColumn("ID").setMinWidth(0);
                jtCentral.getColumn("ID").setMaxWidth(0);
                jtCentral.getColumn("ID").setWidth(0);
            }
        } catch (Exception e) {
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
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Proveedor) ctrlProveedor.ConsultaEspecifica(this.baseEntity);
                this.baseDir = new Direccion();
                this.baseDir.setId(this.baseEntity.getIdDireccion());
                this.baseDir = (Direccion) ctrlDireccion.ConsultaEspecifica(this.baseDir);
                this.telefonos = ctrlTelefono.ConsultaNoCatalogo(this.baseEntity.getId());
                this.baseEntity.setDireccion(baseDir);
                this.lblNombreContacto.setText(this.baseEntity.getStrNombreContacto());
                this.lblApellidoPaterno.setText(this.baseEntity.getStrApellidoPContacto());
                this.lblApellidoMaterno.setText(this.baseEntity.getStrApellidoMContacto());
                this.lblcategoria.setText(String.valueOf(this.jtFiltro.getValueAt(fila, 1)));
                this.lblDireccion.setText(this.baseDir.getStrCalle() + ". " + this.baseDir.getStrColonia());
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
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
        lblNombreContacto = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblcategoria = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCentral = new javax.swing.JTable();

        setClosable(true);
        setTitle("Proveedores");
        setToolTipText("Gestión de Proveedores");

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51)))); // NOI18N
        pnlDetalle.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2139(4)_24.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre Contacto:");

        lblNombreContacto.setText("Información");

        lblApellidoPaterno.setText("Información");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Apellido Paterno:");

        lblApellidoMaterno.setText("Información");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Apellido Materno:");

        lblcategoria.setText("Información");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Categoria:");

        lblDireccion.setText("Información");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Direccion:");

        lblTelefono.setText("Información");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Telefonos:");

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
                            .addComponent(lblNombreContacto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetalleLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING))))))
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
                    .addComponent(lblNombreContacto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblApellidoPaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblApellidoMaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblcategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblTelefono))
                .addContainerGap(68, Short.MAX_VALUE))
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
        lblFormulario.setText("Proveedores");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void jtFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFiltroMouseClicked
        try {
            this.limpiarTabla();
            this.loadRegistros();
            jtCentral.setRowSelectionInterval(0, 0);
            this.jtCentralMouseClickedInitial();
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_jtFiltroMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Boton para modificar
        if (tc.getRowCount() > 0) {
            try {
                JdProveedorManager manager = new JdProveedorManager();
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Proveedor) ctrlProveedor.ConsultaEspecifica(this.baseEntity);
                this.baseDir = new Direccion();
                this.baseDir.setId(this.baseEntity.getIdDireccion());
                this.baseDir = (Direccion) ctrlDireccion.ConsultaEspecifica(this.baseDir);
                this.baseEntity.setDireccion(baseDir);
                this.telefonos = ctrlTelefono.ConsultaNoCatalogo(this.baseEntity.getId());
                this.listaTelefonos = new ArrayList();
                for (int i = 0; i < this.telefonos.size(); i++) {
                    Telefono telefono = (Telefono) this.telefonos.get(i);
                    this.listaTelefonos.add(telefono);
                }
                this.baseEntity.setTelefonos(this.listaTelefonos);
//                this.baseEntity.setTelefonos();
                Object objTemp = manager.showDialog(this.baseEntity);
                Proveedor objResultado = (Proveedor) objTemp;
                //si el conf es diferente de null
                if (objResultado != null) {
                    //invocamos nuestra controladora para agregar
                    objResultado.getDireccion().setId(objResultado.getIdDireccion());
                    if (ctrlDireccion.Modificar(objResultado.getDireccion())) {
                        if (objResultado.getImaImagenLogo() != null) {
                            if (ctrlProveedor.ModificarImagenSincambios(objResultado)) {
                                for (int i = 0; i < objResultado.getTelefonos().size(); i++) {
                                    Telefono telefono = objResultado.getTelefonos().get(i);
                                    if (telefono.getId() == 0) {
                                        ctrlTelefono.Agregar(telefono);
                                    } else {
                                        ctrlTelefono.Modificar(telefono);
                                    }
                                }
                                Notification.show("Mensaje del sistema", "Registro actualizado", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                            } else {
                                //delo contrario = pero indicando
                                Notification.show("Mensaje del sistema", "Registro no actualizado", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                            }
                        } else {
                            if (ctrlProveedor.Modificar(objResultado)) {
                                //si el guardado fue correcto manda un mensaje
                                for (int i = 0; i < objResultado.getTelefonos().size(); i++) {
                                    Telefono telefono = objResultado.getTelefonos().get(i);
                                    if (telefono.getId() == 0) {
                                        ctrlTelefono.Agregar(telefono);
                                    } else {
                                        ctrlTelefono.Modificar(telefono);
                                    }
                                }
                                Notification.show("Mensaje del sistema", "Registro actualizado", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                            } else {
                                //delo contrario = pero indicando
                                Notification.show("Mensaje del sistema", "Registro no actualizado", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                            }
                        }
                    }
                }
                //actualiza los datos del jtable de resultado
                this.limpiarTabla();
                this.loadRegistros();
                jtCentral.setRowSelectionInterval(0, 0);
            } catch (Exception _e) {
                System.out.println(_e.getMessage());
            }
        } else {
            Notification.show("Mensaje del sistema", "No hay registros que editar", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (tc.getRowCount() > 0) {
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Proveedor) ctrlProveedor.ConsultaEspecifica(this.baseEntity);
                Direccion direccion = new Direccion();
                direccion.setId(this.baseEntity.getIdTipoProveedor());
                direccion = (Direccion) ctrlDireccion.ConsultaEspecifica(direccion);
                this.baseEntity.setDireccion(direccion);
                this.telefonos = this.ctrlTelefono.ConsultaNoCatalogo(this.baseEntity.getId());

                for (int i = 0; i < telefonos.size(); i++) {
                    this.baseTel = (Telefono) telefonos.get(i);
                    if (!this.ctrlTelefono.Delete(this.baseTel)) {
                        System.out.println("Error mientras se eliminaban los telefonos posición: " + i);
                        Notification.show("Mensaje del sistema", "Error mientras se eliminaban los telefonos", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                        return;
                    }
                }
                if (ctrlProveedor.Delete(this.baseEntity)) {
                    //si el guardado fue correcto manda un mensaje
                    if (ctrlDireccion.Delete(this.baseDir)) {
                        Notification.show("Mensaje del sistema", "Registro eliminado", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                    } else {
                        //delo contrario = pero indicando
                        Notification.show("Mensaje del sistema", "Registro no eliminado", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                    }
                }
                //actualiza los datos del jtable de resultado
                this.limpiarTabla();
                this.loadRegistros();
                jtCentral.setRowSelectionInterval(0, 0);
            } else {
                JOptionPane.showMessageDialog(null, "No hay registros que Eliminar");
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            this.baseEntity.setIdTipoProveedor(id);
            this.baseEntity.setStrNombreContacto(this.txtBuscar.getText().trim());
            ArrayList<Object> lista = ctrlProveedor.ConsultaBuscar(this.baseEntity);
            this.limpiarTabla();
            for (int i = 0; i < lista.size(); i++) {
                Object[] filaTemp1 = new Object[2];
                Proveedor tempObject = (Proveedor) lista.get(i);
                filaTemp1[0] = tempObject.getId();
                filaTemp1[1] = tempObject.getStrNombreContacto();
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

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        this.txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            JdProveedorManager manager = new JdProveedorManager();
            //manager.setVisible(true);
            Object objTemp = manager.showDialog(null);
            Proveedor conf = (Proveedor) objTemp;
            //si el conf es diferente de null
            if (objTemp != null) {
                //invocamos nuestra controladora para agregar
                if (ctrlDireccion.Agregar(conf.getDireccion())) {
                    conf.getDireccion().setId(ctrlDireccion.ObtenerMaximoId());
                    conf.setIdDireccion(conf.getDireccion().getId());
                    if (ctrlProveedor.Agregar(conf)) {
                        //si el guardado fue correcto manda un mensaje
                        CtrlCorreo ctrlCorreo = new CtrlCorreo();
                        ctrlCorreo.EnviarCorreo(conf.getStrCorreo());
                        int idProveedor = ctrlProveedor.ObtenerMaximoId();
                        for (int i = 0; i < conf.getTelefonos().size(); i++) {
                            Telefono telefono = (Telefono) conf.getTelefonos().get(i);
                            telefono.setIdProveedor(idProveedor);
                            if (ctrlTelefono.Agregar(telefono)) {
                                System.out.println("Se guardo con exito telefono no. " + i);
                            }
                        }
                        Notification.show("Mensaje del sistema", "Registro exitoso", Notification.NICON_LIGHT_THEME, true, Notification.OK_MESSAGE, 2000);
                    } else {
                        //delo contrario = pero indicando
                        Notification.show("Mensaje del sistema", "Registro falló", Notification.NICON_LIGHT_THEME, true, Notification.ERROR_MESSAGE, 2000);
                    }
                }
            }
            //actualiza los datos del jtable de resultado
            this.limpiarTabla();
            this.loadRegistros();
            this.jtCentral.setRowSelectionInterval(0, 0);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jtCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCentralMouseClicked
        try {
            filac = jtCentral.getSelectedRow();
            if (filac != -1) {
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Proveedor) ctrlProveedor.ConsultaEspecifica(this.baseEntity);
                this.baseDir = new Direccion();
                this.baseDir.setId(this.baseEntity.getIdDireccion());
                this.baseDir = (Direccion) ctrlDireccion.ConsultaEspecifica(this.baseDir);
                this.telefonos = ctrlTelefono.ConsultaNoCatalogo(this.baseEntity.getId());
                this.baseEntity.setDireccion(baseDir);
                this.lblNombreContacto.setText(this.baseEntity.getStrNombreContacto());
                this.lblApellidoPaterno.setText(this.baseEntity.getStrApellidoPContacto());
                this.lblApellidoMaterno.setText(this.baseEntity.getStrApellidoMContacto());
                this.lblcategoria.setText(String.valueOf(this.jtFiltro.getValueAt(fila, 1)));
                this.lblDireccion.setText(this.baseDir.getStrCalle() + ". " + this.baseDir.getStrColonia());
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_jtCentralMouseClicked

    private void jtCentralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCentralKeyPressed
        int c = evt.getKeyCode();

        if (c == KeyEvent.VK_UP) {
            filac = jtCentral.getSelectedRow() - 1;
            if (filac != -1) {
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Proveedor) ctrlProveedor.ConsultaEspecifica(this.baseEntity);
                this.baseDir = new Direccion();
                this.baseDir.setId(this.baseEntity.getIdDireccion());
                this.baseDir = (Direccion) ctrlDireccion.ConsultaEspecifica(this.baseDir);
                this.telefonos = ctrlTelefono.ConsultaNoCatalogo(this.baseEntity.getId());
                this.baseEntity.setDireccion(baseDir);
                this.lblNombreContacto.setText(this.baseEntity.getStrNombreContacto());
                this.lblApellidoPaterno.setText(this.baseEntity.getStrApellidoPContacto());
                this.lblApellidoMaterno.setText(this.baseEntity.getStrApellidoMContacto());
                this.lblcategoria.setText(String.valueOf(this.jtFiltro.getValueAt(fila, 1)));
                this.lblDireccion.setText(this.baseDir.getStrCalle() + ". " + this.baseDir.getStrColonia());
            }

            System.out.println("arriba");
        }
        if (c == KeyEvent.VK_DOWN) {
            filac = jtCentral.getSelectedRow() + 1;
            if (filac != -1) {
                this.idcentral = (int) jtCentral.getValueAt(filac, 0);
                this.baseEntity.setId(this.idcentral);
                this.baseEntity = (Proveedor) ctrlProveedor.ConsultaEspecifica(this.baseEntity);
                this.baseDir = new Direccion();
                this.baseDir.setId(this.baseEntity.getIdDireccion());
                this.baseDir = (Direccion) ctrlDireccion.ConsultaEspecifica(this.baseDir);
                this.telefonos = ctrlTelefono.ConsultaNoCatalogo(this.baseEntity.getId());
                this.baseEntity.setDireccion(baseDir);
                this.lblNombreContacto.setText(this.baseEntity.getStrNombreContacto());
                this.lblApellidoPaterno.setText(this.baseEntity.getStrApellidoPContacto());
                this.lblApellidoMaterno.setText(this.baseEntity.getStrApellidoMContacto());
                this.lblcategoria.setText(String.valueOf(this.jtFiltro.getValueAt(fila, 1)));
                this.lblDireccion.setText(this.baseDir.getStrCalle() + ". " + this.baseDir.getStrColonia());
            }

            System.out.println("abajo");
        }
    }//GEN-LAST:event_jtCentralKeyPressed

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
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFormulario;
    private javax.swing.JLabel lblNombreContacto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblcategoria;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
}
