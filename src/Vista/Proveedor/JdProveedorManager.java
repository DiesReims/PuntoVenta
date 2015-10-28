package Vista.Proveedor;

import Control.Control.CtrlCatEstadoProveedor;
import Control.Control.CtrlCatTipoProveedor;
import Control.Control.CtrlDireccion;
import Control.Control.CtrlEstado;
import Control.Control.CtrlTelefono;
import Control.Interface.IManager;
import Control.Validacion.CtrlValidacionInfo;
import Data.Entidad.CatEstado;
import Data.Entidad.CatEstadoProveedor;
import Data.Entidad.CatTipoProveedor;
import Data.Entidad.Direccion;
import Data.Entidad.Proveedor;
import Data.Entidad.Telefono;
import Vista.Telefono.JdTelefonoManager;
import java.awt.Dialog;
import java.awt.Image;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class JdProveedorManager extends javax.swing.JDialog implements IManager {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private Proveedor baseEntity;
    private Direccion direccion;
    private Telefono telefono = new Telefono();
    private CatEstado estado = new CatEstado();
    private CtrlDireccion ctrlDireccion = new CtrlDireccion();
    private CtrlTelefono ctrlTelefono = new CtrlTelefono();
    private CtrlEstado ctrlEstado = new CtrlEstado();
    private CtrlValidacionInfo ctrlValidacionInfo = new CtrlValidacionInfo();
    private int idEstado;
    private int idCategoria;
    private int idTelefono;
    private int idEstatus;
    private int idAccion = 0;
    private int filac;
    boolean conCambios = false;
    private boolean camTxt = false;
    private boolean camCombo = false;
    private boolean camJTable = false;
    private boolean imageLoaded = false;
    String prueba = "Hola";
    DefaultTableModel tableMod;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public JdProveedorManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JdProveedorManager() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        String[] head = {"ID", "Numero Telefonico", "idProveedor"};
        Object[][] cuerpo = {};
        tableMod = new DefaultTableModel(cuerpo, head);
        this.jtTelefono.setModel(tableMod);
        jtTelefono.getColumn("ID").setPreferredWidth(0);
        jtTelefono.getColumn("ID").setMinWidth(0);
        jtTelefono.getColumn("ID").setMaxWidth(0);
        jtTelefono.getColumn("ID").setWidth(0);
        jtTelefono.getColumn("idProveedor").setPreferredWidth(0);
        jtTelefono.getColumn("idProveedor").setMinWidth(0);
        jtTelefono.getColumn("idProveedor").setMaxWidth(0);
        jtTelefono.getColumn("idProveedor").setWidth(0);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    private String GenerarFechaActual() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
            Date date = new Date();
            return sdf.format(date);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return "";
        }
    }

//</editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfcImagen = new javax.swing.JFileChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        lblAccion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        btnCargarImagen = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbEstatus = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTelefono = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlGoogleMaps = new javax.swing.JPanel();
        btnGoogleMaps = new javax.swing.JButton();
        pnlImageContainer = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Proveedor");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Calle:");

        txtCalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCalleMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Colonia:");

        txtColonia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtColoniaMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Municipio:");

        txtMunicipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMunicipioMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hola", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMunicipio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addComponent(txtColonia, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtCalle, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblAccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAccion.setForeground(new java.awt.Color(51, 51, 51));
        lblAccion.setText("Accion");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre Contacto:");

        txtNombreContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreContactoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Apellido Paterno:");

        txtApellidoPaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoPaternoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Apellido Materno:");

        txtApellidoMaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoMaternoMouseClicked(evt);
            }
        });

        btnCargarImagen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCargarImagen.setForeground(new java.awt.Color(51, 51, 51));
        btnCargarImagen.setText("Selecciona Imagen...");
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Logotipo:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hola", " " }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Correo:");

        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCorreoMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Estado:");

        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hola", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCargarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(txtApellidoMaterno)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbEstatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, 256, Short.MAX_VALUE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarImagen)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));

        jtTelefono.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTelefonoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtTelefono);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_2b(6)_24.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Entypo_270e(3)_24.png"))); // NOI18N
        btnEditar.setText("Editar");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGoogleMaps.setBorder(javax.swing.BorderFactory.createTitledBorder("Google Maps"));

        btnGoogleMaps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGoogleMaps.setForeground(new java.awt.Color(51, 51, 51));
        btnGoogleMaps.setText("Localizar");
        btnGoogleMaps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoogleMapsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGoogleMapsLayout = new javax.swing.GroupLayout(pnlGoogleMaps);
        pnlGoogleMaps.setLayout(pnlGoogleMapsLayout);
        pnlGoogleMapsLayout.setHorizontalGroup(
            pnlGoogleMapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGoogleMapsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoogleMaps, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGoogleMapsLayout.setVerticalGroup(
            pnlGoogleMapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGoogleMapsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoogleMaps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlImageContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Logo Empresa"));

        javax.swing.GroupLayout pnlImageContainerLayout = new javax.swing.GroupLayout(pnlImageContainer);
        pnlImageContainer.setLayout(pnlImageContainerLayout);
        pnlImageContainerLayout.setHorizontalGroup(
            pnlImageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImageContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlImageContainerLayout.setVerticalGroup(
            pnlImageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImageContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAccion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pnlImageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pnlGoogleMaps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(14, 14, 14)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblAccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlGoogleMaps, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlImageContainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnAceptar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                this.baseEntity.setStrNombreContacto(this.txtNombreContacto.getText().trim());
                this.baseEntity.setStrApellidoPContacto(this.txtApellidoPaterno.getText().trim());
                this.baseEntity.setStrApellidoMContacto(this.txtApellidoMaterno.getText().trim());
                this.baseEntity.setStrCorreo(this.txtCorreo.getText().trim());
                this.baseEntity.setIdAltaProveedor(1);
                this.direccion = new Direccion();
                this.direccion.setStrCalle(this.txtCalle.getText().trim());
                this.direccion.setStrColonia(this.txtColonia.getText().trim());
                this.direccion.setStrMunicipio(this.txtMunicipio.getText().trim());
                //aqui falta la linea para obtener el combo seleccionado
                if (this.idAccion == 0) {
                    this.baseEntity.setIdTipoProveedor(this.cmbCategoria.getSelectedIndex());
                    this.direccion.setIdEstado(this.cmbEstado.getSelectedIndex());
                    this.baseEntity.setIdEstadoProveedor(this.cmbEstatus.getSelectedIndex());
                } else {
                    this.baseEntity.setIdTipoProveedor(this.cmbCategoria.getSelectedIndex() + 1);
                    this.direccion.setIdEstado(this.cmbEstado.getSelectedIndex() + 1);
                    this.baseEntity.setIdEstadoProveedor(this.cmbEstatus.getSelectedIndex() + 1);
                }
                ArrayList<Telefono> telefonos = new ArrayList();
                for (int i = 0; i < this.jtTelefono.getRowCount(); i++) {
                    Telefono telefonoTemp = new Telefono();
                    telefonoTemp.setId((int) this.jtTelefono.getValueAt(i, 0));
                    telefonoTemp.setStrValor((String) this.jtTelefono.getValueAt(i, 1));
                    telefonoTemp.setIdProveedor((int) this.jtTelefono.getValueAt(i, 2));
                    telefonos.add(telefonoTemp);
                }
                this.baseEntity.setDireccion(direccion);
                this.baseEntity.setTelefonos(telefonos);
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            this.camJTable = true;
            JdTelefonoManager manager = new JdTelefonoManager();
            Object objTemp = manager.showDialog(null);
            Telefono conf = (Telefono) objTemp;
            
            if (objTemp != null) {
//                //Verificamos
                Object cuerpo[] = {0, conf.getStrValor(), this.baseEntity.getId()};
                this.tableMod.addRow(cuerpo);
//            }
                //actualiza los datos del jtable de resultado
                this.jtTelefono.setRowSelectionInterval(0, 0);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            this.camJTable = true;
            int numerofilas = this.jtTelefono.getRowCount();
            System.out.println("El numero de filas es: " + numerofilas);
            if (this.jtTelefono.getRowCount() > 0) {
                JdTelefonoManager mngrDir = new JdTelefonoManager();
                this.filac = this.jtTelefono.getSelectedRow();
                
                this.telefono.setId((int) this.jtTelefono.getValueAt(this.filac, 0));
                this.telefono.setStrValor((String) this.jtTelefono.getValueAt(this.filac, 1));
                this.telefono.setIdProveedor((int) this.jtTelefono.getValueAt(this.filac, 2));
                Object objTemp = mngrDir.showDialog(this.telefono);
                Telefono conf = (Telefono) objTemp;
                if (conf != null) {
//                    CtrlConfEstados estado = new CtrlConfEstados();
//                    ArrayList<Object> lista = estado.ConsultaEspecializada(conf.getIdConfEstado());
//                    ConfEstados tempObject = (ConfEstados) lista.get(0);
//
//                    CtrlConfMunicipios muni = new CtrlConfMunicipios();
//                    ArrayList<Object> lista2 = muni.ConsultaEspecializada(conf.getIdConfMunicipio());
//                    ConfMunicipios tempObject2 = (ConfMunicipios) lista2.get(0);
//
                    this.jtTelefono.setValueAt(conf.getId(), filac, 0);
                    this.jtTelefono.setValueAt(conf.getStrValor(), filac, 1);
                    this.jtTelefono.setValueAt(conf.getIdProveedor(), filac, 2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay direcciones que editar", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            // Elimina
            if (this.jtTelefono.getRowCount() > 0) {
                if (this.idTelefono > 0) {
                    int eliminar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el registro?", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    if (eliminar == 0) {
                        
                        this.camJTable = true;
                        this.telefono = new Telefono();
                        this.telefono.setId(this.idTelefono);
                        if (ctrlTelefono.Delete(this.telefono)) {
                            int elFila = this.jtTelefono.getSelectedRow();
                            this.tableMod.removeRow(elFila);
                            JOptionPane.showMessageDialog(null, "Registro borrado exitosamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    this.camJTable = true;
                    int elFila = this.jtTelefono.getSelectedRow();
                    this.tableMod.removeRow(elFila);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay registros que borrar", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
        try {
            jfcImagen.setFileFilter(new FileNameExtensionFilter("Archivo Imagen", "jpg"));
            int resultado = jfcImagen.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                this.imageLoaded = true;
                File file = jfcImagen.getSelectedFile();
                this.baseEntity.setRutaImagen(file.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Ha seleccionado" + file.getAbsolutePath());
                ImageIcon icon = new ImageIcon(this.baseEntity.getRutaImagen());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(this.lblImagen.getWidth(), this.lblImagen.getHeight(), Image.SCALE_DEFAULT));
                this.baseEntity.setImaImagenLogo(null);
                this.lblImagen.setIcon(icono);
//                String fecha = this.GenerarFechaActual();
//                JOptionPane.showMessageDialog(null,fecha);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void txtNombreContactoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreContactoMouseClicked
        this.DetectaCambio(this.txtNombreContacto);
    }//GEN-LAST:event_txtNombreContactoMouseClicked

    private void txtApellidoPaternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoPaternoMouseClicked
        this.DetectaCambio(this.txtApellidoPaterno);
    }//GEN-LAST:event_txtApellidoPaternoMouseClicked

    private void txtApellidoMaternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMaternoMouseClicked
        this.DetectaCambio(this.txtApellidoMaterno);
    }//GEN-LAST:event_txtApellidoMaternoMouseClicked

    private void txtCalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCalleMouseClicked
        this.DetectaCambio(this.txtCalle);
    }//GEN-LAST:event_txtCalleMouseClicked

    private void txtColoniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtColoniaMouseClicked
        this.DetectaCambio(this.txtColonia);
    }//GEN-LAST:event_txtColoniaMouseClicked

    private void txtMunicipioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMunicipioMouseClicked
        this.DetectaCambio(this.txtMunicipio);
    }//GEN-LAST:event_txtMunicipioMouseClicked

    private void jtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTelefonoMouseClicked
        try {
            // Asigna el id de la fila seleccionada
            if (this.jtTelefono.getRowCount() != -1) {
                int filadir = this.jtTelefono.getSelectedRow();
                this.idTelefono = (int) this.jtTelefono.getValueAt(filadir, 0);
//            this.idCliente = (int) this.jtDireccion.getValueAt(filadir, 1);
                System.out.println(this.idTelefono);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_jtTelefonoMouseClicked

    private void txtCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoMouseClicked

    private void btnGoogleMapsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoogleMapsActionPerformed
        try {
            Browser browser = new Browser();
            BrowserView browserView = new BrowserView(browser);         
            JFrame frame = new JFrame("Google Maps");
            frame.add(browserView, BorderLayout.CENTER);
            frame.setSize(700, 500);
            frame.setVisible(true);
            frame.setAlwaysOnTop(true);
            frame.setLocationRelativeTo(null);     
            String cadena = "https://www.google.com.mx/maps/place/" + this.txtMunicipio.getText() + "+"
                    + this.txtColonia.getText() + "+" + this.txtCalle.getText()+"/";
            String Url = cadena.replace(' ','+');
            System.out.println(Url);
            browser.loadURL(Url);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }//GEN-LAST:event_btnGoogleMapsActionPerformed

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
            java.util.logging.Logger.getLogger(JdProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdProveedorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdProveedorManager dialog = new JdProveedorManager(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGoogleMaps;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFileChooser jfcImagen;
    private javax.swing.JTable jtTelefono;
    private javax.swing.JLabel lblAccion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JPanel pnlGoogleMaps;
    private javax.swing.JPanel pnlImageContainer;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombreContacto;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    @Override
    public Object showDialog(Object _obj) {
        try {
            this.baseEntity = (Proveedor) _obj;
            this.idAccion = (this.baseEntity != null) ? this.baseEntity.getId() : 0;
            if (this.idAccion == 0) {
                this.baseEntity = new Proveedor();
            } else {
                this.direccion = this.baseEntity.getDireccion();
                this.idEstatus = this.baseEntity.getIdEstadoProveedor();
                this.estado.setId(this.direccion.getIdEstado());
                this.idEstado = this.estado.getId();//obtener el id de estado para el combo de editar
                this.idCategoria = this.baseEntity.getIdTipoProveedor();
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
            if (!ctrlValidacionInfo.ValidaRegistro()) {
                JOptionPane.showMessageDialog(null, "No se puede manipular proveedores en este momento");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtNombreContacto.getText().trim(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de nombre contacto no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtApellidoPaterno.getText().trim(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de apellido paterno no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtApellidoMaterno.getText().trim(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de apellido materno no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtCorreo.getText().trim(), 100, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de correo no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.ValidaCorreo(this.txtCorreo.getText().trim())) {
                JOptionPane.showMessageDialog(null, "El campo de correo no es valido");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtCalle.getText().trim(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de calle se encuentra vacio");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtColonia.getText().trim(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de colonia se encuentra vacio");
                return false;
            }
            if (!ctrlValidacionInfo.validacionGeneral(this.txtMunicipio.getText().trim(), 45, 1)) {
                JOptionPane.showMessageDialog(null, "El campo de municipio se encuentra vacio");
                return false;
            }
            if (!this.imageLoaded) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna imagen");
                return false;
            }
            if (this.idAccion == 0) {
                if (this.cmbCategoria.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una opción valida de categoria proveedor");
                    return false;
                }
                if (this.cmbEstado.getSelectedIndex() == 0) {
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
            CtrlCatTipoProveedor ctrlCatTipoProducto = new CtrlCatTipoProveedor();
            CtrlCatEstadoProveedor ctrlCatEstadoProveedor = new CtrlCatEstadoProveedor();
            ArrayList<Object> lista = ctrlCatTipoProducto.ConsultaGeneral(null);
            ArrayList<Object> listaEstados = ctrlEstado.ConsultaGeneral(null);
            ArrayList<Object> listaEstatus = ctrlCatEstadoProveedor.ConsultaGeneral(null);
            if (this.idAccion == 0) {
                //leyenda seleccionar
                x.addElement("Selecciona");
                y.addElement("Selecciona");
                z.addElement("Selecciona");
                for (int i = 0; i < lista.size(); i++) {
                    CatTipoProveedor tempObject = (CatTipoProveedor) lista.get(i);
                    x.addElement(tempObject);
                }
                for (int i = 0; i < listaEstados.size(); i++) {
                    CatEstado tempObjectE = (CatEstado) listaEstados.get(i);
                    y.addElement(tempObjectE);
                }
                for (int i = 0; i < listaEstatus.size(); i++) {
                    CatEstadoProveedor tempObjectSta = (CatEstadoProveedor) listaEstatus.get(i);
                    z.addElement(tempObjectSta);
                }
                cmbCategoria.setModel(x);
                cmbEstado.setModel(y);
                cmbEstatus.setModel(z);
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    CatTipoProveedor tempObject = (CatTipoProveedor) lista.get(i);
                    x.addElement(tempObject);
                }
                for (int i = 0; i < listaEstados.size(); i++) {
                    CatEstado tempObjectE = (CatEstado) listaEstados.get(i);
                    y.addElement(tempObjectE);
                }
                for (int i = 0; i < listaEstatus.size(); i++) {
                    CatEstadoProveedor tempObjectSta = (CatEstadoProveedor) listaEstatus.get(i);
                    z.addElement(tempObjectSta);
                }
                cmbCategoria.setModel(x);
                cmbEstado.setModel(y);
                cmbEstatus.setModel(z);
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
//            this.setFecha();
//            this.setCheck();
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
                this.cmbCategoria.setSelectedIndex(this.idCategoria - 1);
                this.cmbEstado.setSelectedIndex(this.idEstado - 1);
                this.cmbEstatus.setSelectedIndex(this.idEstatus - 1);
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
        }
    }
    
    @Override
    public void setTextField() {
        try {
            this.txtNombreContacto.setText(((this.baseEntity != null) ? this.baseEntity.getStrNombreContacto() : ""));
            this.txtApellidoPaterno.setText(((this.baseEntity != null) ? this.baseEntity.getStrApellidoPContacto() : ""));
            this.txtApellidoMaterno.setText((this.baseEntity != null) ? this.baseEntity.getStrApellidoMContacto() : "");
            this.txtCalle.setText((this.baseEntity != null) ? this.direccion.getStrCalle() : "");
            this.txtColonia.setText((this.baseEntity != null) ? this.direccion.getStrColonia() : "");
            this.txtMunicipio.setText((this.baseEntity != null) ? this.direccion.getStrMunicipio() : "");
            this.txtCorreo.setText((this.baseEntity != null) ? this.baseEntity.getStrCorreo() : "");
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
        try {
            ArrayList<Telefono> lista = this.baseEntity.getTelefonos();
            if (this.idAccion != 0) {
                
                for (int i = 0; i < lista.size(); i++) {
                    Object[] filaTemp = new Object[3];
//                    ConfDireccionProveedor tempObject = (ConfDireccionProveedor) lista.get(i);
//                    CtrlConfEstados estado = new CtrlConfEstados();
//                    ArrayList<Object> lista2 = estado.ConsultaEspecializada(tempObject.getIdConfEstado());
//                    ConfEstados tempObject2 = (ConfEstados) lista2.get(0);
//                    CtrlConfMunicipios muni = new CtrlConfMunicipios();
//                    ArrayList<Object> lista3 = muni.ConsultaEspecializada(tempObject.getIdConfMunicipio());
//                    ConfMunicipios tempObject3 = (ConfMunicipios) lista3.get(0);
                    filaTemp[0] = lista.get(i).getId();
                    filaTemp[1] = lista.get(i).getStrValor();
                    filaTemp[2] = lista.get(i).getIdProveedor();
                    tableMod.addRow(filaTemp);
                    this.jtTelefono.setModel(tableMod);
                }
            }
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
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
        try {
            if (this.idAccion == 0) {
//                this.browser.loadURL("http://maps.google.es/maps?f=q&hl=es&geocode=&q=Las animas, Tepeji del rio");
            } else {
                //Carga la imagen de logo de la empresa.
                ImageIcon icono = new ImageIcon(this.baseEntity.getImaImagenLogo().getScaledInstance(this.lblImagen.getWidth(), this.lblImagen.getHeight(), Image.SCALE_DEFAULT));
                this.lblImagen.setIcon(icono);
                this.imageLoaded = true;
//                this.browser.loadURL("http://maps.google.es/maps?f=q&hl=es&geocode=&q=" + this.direccion.getStrMunicipio() + ","
//                        + this.direccion.getStrColonia() + ". " + this.direccion.getStrCalle());
            }
            
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
        }
    }
    
    @Override
    public void huboCambio() {
        this.conCambios = true;
    }

    //<editor-fold defaultstate="collapsed" desc="Detecta cambio combo: Evento">
    private void DetectaCambioCombo() {
        if (this.idAccion == 0) {
            if (this.cmbEstado.getSelectedIndex() >= 0) {
                this.camCombo = true;
            }
            
        } else if (this.idAccion > 0) {
            
            CatTipoProveedor x = (CatTipoProveedor) cmbCategoria.getSelectedItem();
            System.out.println(x.getId() + this.baseEntity.getIdTipoProveedor());
            if (x.getId() != this.baseEntity.getIdTipoProveedor()) {
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
