
package Front;

import javax.swing.JOptionPane;
import Back.Cliente;
import Back.ClienteCrud;
import Back.Mesa;
import Back.MesaCrud;
import Back.Config;
import Back.Venta;
import Back.Detalle;
import Back.Eventos;
import Back.LoginCrud;
import Back.Marca;
import Back.MarcaCrud;
import Back.VentaCrud;
import Back.Proveedor;
import Back.Productos;
import Back.ProductosCrud;
import Back.ProveedorCrud;
import Back.Usuario;
import Reportes.Excel;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/** 
 * <b>CLASE:</b> Sistema.java 
 * <b>OBJETIVO:</b> Proporcional al usuario una interfaz para el aplicativo.
 * 
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador.
 *
 * 
 * @version 1.1 30/11/2023 
 * @author Juan Diaz 
 */
public class Sistema extends javax.swing.JFrame {


    Date fechaVenta = new Date();
    String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    Cliente cl = new Cliente();
    ClienteCrud client = new ClienteCrud();
    Proveedor pr = new Proveedor();
    ProveedorCrud PrDao = new ProveedorCrud();
    MarcaCrud mar = new MarcaCrud();
    Marca mr = new Marca();
    MesaCrud mes = new MesaCrud();
    Mesa ms = new Mesa();
    Productos pro = new Productos();
    ProductosCrud proDao = new ProductosCrud();
    Venta v = new Venta();
    VentaCrud Vdao = new VentaCrud();
    Detalle Dv = new Detalle();
    Config conf = new Config();
    Eventos event = new Eventos();
    Usuario lg = new Usuario();
    LoginCrud login = new LoginCrud();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    int item;
    double Totalpagar = 0.00;

    public Sistema() {
        initComponents();
        ListarConfig();
        this.setLocationRelativeTo(null);
        // Set the title and icon for the JFrame.
        setTitle("--ELECTRONE PRADASHA--");
        setIconImage(new ImageIcon(getClass().getResource("/Img/boss.png")).getImage());
        txtIdUser.setVisible(false);
        txtIdCliente.setVisible(false);
        txtIdVenta.setVisible(false);
        txtIdPro.setVisible(false);
        txtIdpro.setVisible(false);
        txtIdProveedor.setVisible(false);
        txtIdConfig.setVisible(false);
        txtIdCV.setVisible(false);
        txtIdMarca.setVisible(false);
        txtIdMarcaProducto.setVisible(false);
        cbxIdProveedorProducto.setVisible(false);
    }
    /** 
     * <b>Sistema()</b>
     * 
     * @param priv
     * 
     */
    public Sistema(Usuario priv) {
        
        // Set the title and icon for the JFrame.
        setTitle("--ELECTRONE PRADASHA--");
        setIconImage(new ImageIcon(getClass().getResource("/Img/boss.png")).getImage());
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdUser.setVisible(false);
        txtIdCliente.setVisible(false);
        txtIdVenta.setVisible(false);
        txtIdPro.setVisible(false);
        txtIdpro.setVisible(false);
        txtIdProveedor.setVisible(false);
        txtIdConfig.setVisible(false);
        txtIdCV.setVisible(false);
        txtIdMarca.setVisible(false);
        txtIdMarcaProducto.setVisible(false);
        cbxIdProveedorProducto.setVisible(false);
        ListarConfig();
        if (priv.getRol().equals("WAREHOUSE ASSISTANT")) {
            btnVentas1.setEnabled(false);
            btnProveedor.setEnabled(false);
            btnBrands.setEnabled(false);
            btnEliminarProducto.setEnabled(false);
            btnNuevaVenta.setEnabled(false);
            
            btnClientes.setEnabled(false);
            LavelVendedor.setText(priv.getNombres());
            btnUsers.setEnabled(false);
        } 
        if (priv.getRol().equals("SALES ASSISTANT")) {
            btnEliminarProducto.setEnabled(false);
            btnProveedor.setEnabled(false);
            btnBrands.setEnabled(false);
            
            btnEliminarCliente.setEnabled(false);
            
            btnHelpDesk.setEnabled(false);
            LavelVendedor.setText(priv.getNombres());
            btnUsers.setEnabled(false);
        } 
        
         if (priv.getRol().equals("WAREHOUSE MANAGER")) {
            btnVentas1.setEnabled(false);
            //btnProveedor.setEnabled(false);
            //btnBrands.setEnabled(false);
            btnEliminarProducto.setEnabled(false);
            btnNuevaVenta.setEnabled(false);
            
            btnClientes.setEnabled(false);
            LavelVendedor.setText(priv.getNombres());
            btnUsers.setEnabled(false);
        } 
        if (priv.getRol().equals("SALES MANAGER")) {
            btnEliminarProducto.setEnabled(false);
            btnProveedor.setEnabled(false);
            btnBrands.setEnabled(false);
            btnProductos.setEnabled(false);
            btnEliminarCliente.setEnabled(false);
            btnNuevaVenta.setEnabled(false);
            btnHelpDesk.setEnabled(false);
            LavelVendedor.setText(priv.getNombres());
            btnUsers.setEnabled(false);
        } 
        
        else {
            LavelVendedor.setText(priv.getNombres());
        }
    }
    
    
    /** 
     * <b>ListarConfig()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los datos de la empresa electronepradasha.
     *
     * 
     */
    public void ListarConfig() {
        conf = proDao.BuscarDatos();
        txtIdConfig.setText("" + conf.getId());
        txtNitConfig.setText("" + conf.getNit());
        txtNombreConfig.setText("" + conf.getNombre());
        txtTelefonoConfig.setText("" + conf.getTelefono());
        txtDireccionConfig.setText("" + conf.getDireccion());
        txtMensaje.setText("" + conf.getMensaje());
       
      
    }
    
    /** 
     * <b>ListarCliente()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los clientes registrados en la base de datos.
     *
     * 
     */
    public void ListarCliente() {
        List<Cliente> ListarCl = client.ListarCliente();
        modelo = (DefaultTableModel) TableCliente.getModel();
        Object[] ob = new Object[7];
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getId();
            ob[1] = ListarCl.get(i).getTipo_Doc();
            ob[2] = ListarCl.get(i).getDoc();
            ob[3] = ListarCl.get(i).getNombre();
            ob[4] = ListarCl.get(i).getApellido();
            ob[5] = ListarCl.get(i).getTelefono();
            ob[6] = ListarCl.get(i).getDireccion();
            modelo.addRow(ob);
        }
        TableCliente.setModel(modelo);

    }
    
    /** 
     * <b>ListarUsuarios()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los usuarios registrados en la base de datos.
     *
     * 
     */
    public void ListarUsuarios() {
        List<Usuario> Listar = login.ListarUsuarios();
        modelo = (DefaultTableModel) TableUsuarios.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();
            ob[1] = Listar.get(i).getNombres();
            ob[2] = Listar.get(i).getApellidos();
            ob[3] = Listar.get(i).getCorreo();
            ob[4] = Listar.get(i).getPass();
            ob[5] = Listar.get(i).getRol();
            modelo.addRow(ob);
        }
        TableUsuarios.setModel(modelo);

    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    /** 
     * <b>ListarProveedor()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los proveedores registrados en la base de datos.
     *
     * 
     */
    public void ListarProveedor() {
        List<Proveedor> ListarPr = PrDao.ListarProveedor();
        modelo = (DefaultTableModel) TableProveedor.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListarPr.size(); i++) {
            ob[0] = ListarPr.get(i).getId();
            ob[1] = ListarPr.get(i).getNit();
            ob[2] = ListarPr.get(i).getNombre();
            ob[3] = ListarPr.get(i).getTelefono();
            ob[4] = ListarPr.get(i).getDireccion();
            modelo.addRow(ob);
        }
        TableProveedor.setModel(modelo);

    }
    /** 
     * <b>ListarMarca()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todas las marcas registradas en la base de datos.
     */
    public void ListarMarca() {
        List<Marca> Listarmr = mar.ListarMarca();
        modelo = (DefaultTableModel) TableMarca.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < Listarmr.size(); i++) {
            ob[0] = Listarmr.get(i).getId();
            ob[1] = Listarmr.get(i).getCodigo();
            ob[2] = Listarmr.get(i).getNombreMarca();

            modelo.addRow(ob);
        }
        TableMarca.setModel(modelo);

    }
    /** 
     * <b>ListarProductos()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los productos registrados en la base de datos.
     *
     * 
     */
    public void ListarProductos() {
        List<Productos> ListarPro = proDao.ListarProductos();
        modelo = (DefaultTableModel) TableProducto.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getId();
            ob[1] = ListarPro.get(i).getCodigo();
            ob[2] = ListarPro.get(i).getNombre();
            ob[3] = ListarPro.get(i).getDescripcion();
            ob[4] = ListarPro.get(i).getProveedorPro();
            ob[5] = ListarPro.get(i).getMarca();
            ob[6] = ListarPro.get(i).getStock();
            ob[7] = ListarPro.get(i).getPrecio();
            modelo.addRow(ob);
        }
        TableProducto.setModel(modelo);

    }
    /** 
     * <b>ListarVentas()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todas las ventas registradas en la base de datos.
     *
     * 
     */
    public void ListarVentas() {
        List<Venta> ListarVenta = Vdao.Listarventas();
        modelo = (DefaultTableModel) TableVentas.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < ListarVenta.size(); i++) {
            ob[0] = ListarVenta.get(i).getId();
            ob[1] = ListarVenta.get(i).getNombre_cli();
            ob[2] = ListarVenta.get(i).getVendedor();
            ob[3] = ListarVenta.get(i).getTotal();
            modelo.addRow(ob);
        }
        TableVentas.setModel(modelo);

    }
    /** 
     * <b>ListarMesa()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todas las mesas de ayuda registradas en la base de datos.
     *
     *
     */
    public void ListarMesa() {
        List<Mesa> Listarms = mes.ListarMesa();
        modelo = (DefaultTableModel) TablaMesa.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < Listarms.size(); i++) {
            ob[0] = Listarms.get(i).getId();
            ob[1] = Listarms.get(i).getIdCliente();
            ob[2] = Listarms.get(i).getProblema();
            ob[3] = Listarms.get(i).getDescripcion();
            ob[4] = Listarms.get(i).getEstado();
            ob[5] = Listarms.get(i).getRespuesta();
            modelo.addRow(ob);
        }
        TablaMesa.setModel(modelo);

    }
    /** 
     * <b>ListarNombreMarca()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todas los nombres de las marcas registradas en la base de datos.
     *
     * 
     */
   private void ListarNombreMarca(){
    List<String> listarmr = mar.ListarNombreMarca();
    for (int i = 0; i < listarmr.size(); i++) {
        String nombre = listarmr.get(i);
        txtNombreMarcaProducto.addItem(nombre);
    }
     
    }       
   /** 
     * <b>ListarNombreProvedor()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todas los nombres de las proveedores registrados en la base de datos.
     *
     * 
     */
     private void ListarNombreProvedor(){
    List<String> Listapr = PrDao.ListarNombreProvedor();
    for (int i = 0; i < Listapr.size(); i++) {
        String nombre = Listapr.get(i);
        txtNombreProvedorProducto.addItem(nombre);
    }
    }
    /** 
     * <b>hashPassword()</b>
     * <b>OBJETIVO:</b>Encritrtar con un hash la contraseña del usuario.
     *
     * @param password Objeto Proveedor que contiene la información del nuevo proveedor.
     * @return password contraseña encryptada.
     */
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }//Fin metodo hashPassword 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        btnBrands = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnVentas1 = new javax.swing.JButton();
        btnHelpDesk = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        LavelVendedor = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Ventana1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        txtNitConfig = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTelefonoConfig = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtNombreConfig = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtDireccionConfig = new javax.swing.JTextField();
        fff = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JTextField();
        txtIdConfig = new javax.swing.JTextField();
        btnActualizarConfig = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        btnActualizarConfig1 = new javax.swing.JButton();
        VentanaClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCliente = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNuevoCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDocCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidoCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        btnGuardarCliente = new javax.swing.JButton();
        txtTipo_DocCliente = new javax.swing.JComboBox<>();
        VentanaProvedores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNitProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        btnGuardarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        txtNuevoProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        VentanaProductos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProducto = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnNuevoProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnGuardarProducto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxIdProveedorProducto = new javax.swing.JTextField();
        btnExcel = new javax.swing.JButton();
        txtIdpro = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtDescripcionProducto = new javax.swing.JTextArea();
        txtNombreMarcaProducto = new javax.swing.JComboBox<>();
        txtIdMarcaProducto = new javax.swing.JTextField();
        txtNombreProvedorProducto = new javax.swing.JComboBox<>();
        VentanaRegistroVentas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        btnPdfVentas = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        VentanaVenta = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStokDisponible = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        btnEliminarVenta = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDocVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNombreClienteVenta = new javax.swing.JTextField();
        etiquetaPay = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        txtIdPro = new javax.swing.JTextField();
        txtIdCV = new javax.swing.JTextField();
        LabelTotal1 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        txtDescripcionVenta = new javax.swing.JTextField();
        VentanaUsuario = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtNombreUser = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtApellidoUser = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtCorreoUser = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnEliminarUser = new javax.swing.JButton();
        btnmodificarUser = new javax.swing.JButton();
        txtIdUser = new javax.swing.JTextField();
        btnmodificarUser1 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtPassUser = new javax.swing.JTextArea();
        txtRolUser = new javax.swing.JComboBox<>();
        txtNewPassUser = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        VentanaMarca = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtNombreMarca = new javax.swing.JTextField();
        btnSaveMarca = new javax.swing.JButton();
        btnDeleteMarca = new javax.swing.JButton();
        btnUpdateMarca = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtCodigoMarca = new javax.swing.JTextField();
        txtIdMarca = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableMarca = new javax.swing.JTable();
        VentanaMesa = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txtIdMesa = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtIdClienteMesa = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtProblemaMesa = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRespuestaMesa = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtDescripcionMesa = new javax.swing.JTextArea();
        txtEstadoMesa = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        TablaMesa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btnClientes.setBackground(new java.awt.Color(204, 204, 204));
        btnClientes.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 102, 102));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/clients.png"))); // NOI18N
        btnClientes.setText("CLIENTS");
        btnClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedor.setBackground(new java.awt.Color(204, 204, 204));
        btnProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(0, 102, 102));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/supplier3.png"))); // NOI18N
        btnProveedor.setText("SUPPLIERS");
        btnProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(204, 204, 204));
        btnProductos.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(0, 102, 102));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnProductos.setText("PRODUCTS");
        btnProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnConfig.setBackground(new java.awt.Color(204, 204, 204));
        btnConfig.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(0, 102, 102));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/seeting.png"))); // NOI18N
        btnConfig.setText("INFORMATION");
        btnConfig.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnNuevaVenta.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevaVenta.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(0, 102, 102));
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sale.png"))); // NOI18N
        btnNuevaVenta.setText("NEW SALE");
        btnNuevaVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnBrands.setBackground(new java.awt.Color(204, 204, 204));
        btnBrands.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnBrands.setForeground(new java.awt.Color(0, 102, 102));
        btnBrands.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/diamond-jewel-brand-precious-stone_icon-icons.com_59122.png"))); // NOI18N
        btnBrands.setText("BRANDS");
        btnBrands.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBrands.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrandsActionPerformed(evt);
            }
        });

        btnUsers.setBackground(new java.awt.Color(204, 204, 204));
        btnUsers.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(0, 102, 102));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/username.png"))); // NOI18N
        btnUsers.setText("USERS");
        btnUsers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnVentas1.setBackground(new java.awt.Color(204, 204, 204));
        btnVentas1.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnVentas1.setForeground(new java.awt.Color(0, 102, 102));
        btnVentas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/business_salesreport_salesreport_negocio_2353.png"))); // NOI18N
        btnVentas1.setText("SALES");
        btnVentas1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVentas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentas1ActionPerformed(evt);
            }
        });

        btnHelpDesk.setBackground(new java.awt.Color(204, 204, 204));
        btnHelpDesk.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnHelpDesk.setForeground(new java.awt.Color(0, 102, 102));
        btnHelpDesk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/male-user-help_25349.png"))); // NOI18N
        btnHelpDesk.setText("HELPDESK");
        btnHelpDesk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHelpDesk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelpDesk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpDeskActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Utopia", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/stop_close_off_14465.png"))); // NOI18N
        jButton1.setText("CLOSE SESION");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoep2.jpeg"))); // NOI18N
        jLabel38.setText("jLabel38");

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        LavelVendedor.setFont(new java.awt.Font("Utopia", 1, 18)); // NOI18N
        LavelVendedor.setForeground(new java.awt.Color(255, 255, 255));
        LavelVendedor.setText("EP");

        jLabel31.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/username.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(LavelVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(148, 148, 148))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(LavelVendedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnBrands, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHelpDesk, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnVentas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHelpDesk)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnProveedor)
                                .addComponent(btnConfig))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBrands, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUsers)
                                .addComponent(btnNuevaVenta)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 170));

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        Ventana1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel19.setBackground(new java.awt.Color(0, 102, 102));
        jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtNitConfig.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNitConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitConfigKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("NIT");

        txtTelefonoConfig.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtTelefonoConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoConfigKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("COMPANY NAME");

        txtNombreConfig.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("PHONE");

        txtDireccionConfig.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        fff.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        fff.setForeground(new java.awt.Color(255, 255, 255));
        fff.setText("ADDRESS");

        txtMensaje.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        btnActualizarConfig.setFont(new java.awt.Font("Utopia", 1, 18)); // NOI18N
        btnActualizarConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/update2.png"))); // NOI18N
        btnActualizarConfig.setText("UPDATE");
        btnActualizarConfig.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarConfigActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Utopia", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/boss.png"))); // NOI18N
        jLabel32.setText("COMPANY DETAILS");

        btnActualizarConfig1.setFont(new java.awt.Font("Utopia", 1, 18)); // NOI18N
        btnActualizarConfig1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Firefox_icon-icons.com_67181.png"))); // NOI18N
        btnActualizarConfig1.setText("WEB PAGE");
        btnActualizarConfig1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarConfig1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnActualizarConfig1)
                            .addComponent(btnActualizarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(txtIdConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMensaje)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(fff, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDireccionConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNitConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTelefonoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(45, 45, 45)
                        .addComponent(txtNombreConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNitConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtNombreConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(31, 31, 31)
                        .addComponent(txtDireccionConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fff))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(txtIdConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarConfig1)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Ventana1Layout = new javax.swing.GroupLayout(Ventana1);
        Ventana1.setLayout(Ventana1Layout);
        Ventana1Layout.setHorizontalGroup(
            Ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ventana1Layout.createSequentialGroup()
                .addGap(461, 461, 461)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(473, Short.MAX_VALUE))
        );
        Ventana1Layout.setVerticalGroup(
            Ventana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Ventana1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("tab6", Ventana1);

        VentanaClientes.setBackground(new java.awt.Color(153, 153, 153));

        TableCliente.setBackground(new java.awt.Color(0, 102, 102));
        TableCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        TableCliente.setForeground(new java.awt.Color(255, 255, 255));
        TableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID CLIENTS", "DOC TYPE", "N° DOC", "NAMES", "LAST NAMES", "N° PHONE", "ADDRESS"
            }
        ));
        TableCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableCliente);
        if (TableCliente.getColumnModel().getColumnCount() > 0) {
            TableCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableCliente.getColumnModel().getColumn(1).setPreferredWidth(10);
            TableCliente.getColumnModel().getColumn(2).setPreferredWidth(60);
            TableCliente.getColumnModel().getColumn(3).setPreferredWidth(60);
            TableCliente.getColumnModel().getColumn(4).setPreferredWidth(60);
            TableCliente.getColumnModel().getColumn(5).setPreferredWidth(40);
            TableCliente.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));

        jLabel12.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Doc");

        jLabel13.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name");

        jLabel16.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Last name");

        jLabel14.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phone");

        jLabel15.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Adress");

        txtNuevoCliente.setBackground(new java.awt.Color(0, 102, 102));
        txtNuevoCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user2.png"))); // NOI18N
        txtNuevoCliente.setText("NEW CLIENT");
        txtNuevoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setBackground(new java.awt.Color(0, 102, 102));
        btnEditarCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user5.png"))); // NOI18N
        btnEditarCliente.setText("UPDATE CLIENT");
        btnEditarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user3.png"))); // NOI18N
        btnEliminarCliente.setText("DELETE CLIENT");
        btnEliminarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doc Type");

        txtDocCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtDocCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocClienteKeyTyped(evt);
            }
        });

        txtNombreCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });

        txtApellidoCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoClienteKeyTyped(evt);
            }
        });

        txtTelefonoCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });
        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });

        txtDireccionCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteActionPerformed(evt);
            }
        });

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        btnGuardarCliente.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardarCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnGuardarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save.png"))); // NOI18N
        btnGuardarCliente.setText("SAVE CLIENT");
        btnGuardarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        txtTipo_DocCliente.setEditable(true);
        txtTipo_DocCliente.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtTipo_DocCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C", "C.E" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTipo_DocCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnGuardarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo_DocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(txtDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnGuardarCliente)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminarCliente)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNuevoCliente)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(2, 2, 2)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnEditarCliente)
                                .addGap(18, 18, 18)))
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout VentanaClientesLayout = new javax.swing.GroupLayout(VentanaClientes);
        VentanaClientes.setLayout(VentanaClientesLayout);
        VentanaClientesLayout.setHorizontalGroup(
            VentanaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaClientesLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        VentanaClientesLayout.setVerticalGroup(
            VentanaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaClientesLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(VentanaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", VentanaClientes);

        VentanaProvedores.setBackground(new java.awt.Color(153, 153, 153));

        TableProveedor.setBackground(new java.awt.Color(0, 102, 102));
        TableProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        TableProveedor.setForeground(new java.awt.Color(255, 255, 255));
        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NIT", "NAME", "N° PHONE", "ADDRESS"
            }
        ));
        TableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableProveedor);
        if (TableProveedor.getColumnModel().getColumnCount() > 0) {
            TableProveedor.getColumnModel().getColumn(0).setPreferredWidth(10);
            TableProveedor.getColumnModel().getColumn(1).setPreferredWidth(40);
            TableProveedor.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableProveedor.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableProveedor.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nit");

        jLabel18.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("NAME");

        jLabel19.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("PHONE");

        jLabel21.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ADDRESS");

        txtNitProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNitProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitProveedorKeyTyped(evt);
            }
        });

        txtNombreProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        txtTelefonoProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });

        txtDireccionProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        btnGuardarProveedor.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardarProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnGuardarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/supplier1.png"))); // NOI18N
        btnGuardarProveedor.setText("SAVE SUPPLIER");
        btnGuardarProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sipplier2.png"))); // NOI18N
        btnEliminarProveedor.setText("DELETE SUPPLIER");
        btnEliminarProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setBackground(new java.awt.Color(0, 102, 102));
        btnEditarProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnEditarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/supplier2.png"))); // NOI18N
        btnEditarProveedor.setText("UPDATE SUPPLIER");
        btnEditarProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        txtNuevoProveedor.setBackground(new java.awt.Color(0, 102, 102));
        txtNuevoProveedor.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNuevoProveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtNuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sipplier1.png"))); // NOI18N
        txtNuevoProveedor.setText("NEW SUPPLIER");
        txtNuevoProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNitProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuardarProveedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarProveedor))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNuevoProveedor))
                .addGap(35, 35, 35)
                .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout VentanaProvedoresLayout = new javax.swing.GroupLayout(VentanaProvedores);
        VentanaProvedores.setLayout(VentanaProvedoresLayout);
        VentanaProvedoresLayout.setHorizontalGroup(
            VentanaProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProvedoresLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        VentanaProvedoresLayout.setVerticalGroup(
            VentanaProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProvedoresLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(VentanaProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", VentanaProvedores);

        VentanaProductos.setBackground(new java.awt.Color(153, 153, 153));

        TableProducto.setBackground(new java.awt.Color(0, 102, 102));
        TableProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        TableProducto.setForeground(new java.awt.Color(255, 255, 255));
        TableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE", "NAME", "DESCRIPTION", "SUPPLIER", "BRANDS", "QUANTITY", "PRICE"
            }
        ));
        TableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableProducto);
        if (TableProducto.getColumnModel().getColumnCount() > 0) {
            TableProducto.getColumnModel().getColumn(0).setPreferredWidth(10);
            TableProducto.getColumnModel().getColumn(1).setPreferredWidth(40);
            TableProducto.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableProducto.getColumnModel().getColumn(3).setPreferredWidth(150);
            TableProducto.getColumnModel().getColumn(4).setPreferredWidth(50);
            TableProducto.getColumnModel().getColumn(5).setPreferredWidth(40);
            TableProducto.getColumnModel().getColumn(6).setPreferredWidth(40);
            TableProducto.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));

        jLabel22.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CODE");

        txtCodigoProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("NAME-PRODUCT");

        txtNombreProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("SUPPLIER");

        jLabel26.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("PRICE");

        jLabel24.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("BRAND");

        txtPrecioProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("QUANTITY");

        txtCantidadProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        btnNuevoProducto.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevoProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnNuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save3.png"))); // NOI18N
        btnNuevoProducto.setText("NEW PRODUCT");
        btnNuevoProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(0, 102, 102));
        btnEditarProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnEditarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/set.png"))); // NOI18N
        btnEditarProducto.setText("UPDATE PRODUCT");
        btnEditarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete22.png"))); // NOI18N
        btnEliminarProducto.setText("DELET PRODUCT");
        btnEliminarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnGuardarProducto.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardarProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnGuardarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SAVE2.png"))); // NOI18N
        btnGuardarProducto.setText("SAVE PRODUCT");
        btnGuardarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DESCRIPTION");

        cbxIdProveedorProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        cbxIdProveedorProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxIdProveedorProductoKeyTyped(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(0, 102, 102));
        btnExcel.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        btnExcel.setText("GENERATE  EXCEL");
        btnExcel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        txtIdpro.setForeground(new java.awt.Color(0, 102, 102));

        txtDescripcionProducto.setColumns(20);
        txtDescripcionProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtDescripcionProducto.setRows(5);
        jScrollPane11.setViewportView(txtDescripcionProducto);

        txtNombreMarcaProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        txtIdMarcaProducto.setText("0");

        txtNombreProvedorProducto.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(328, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioProducto)
                            .addComponent(jLabel25)
                            .addComponent(txtNombreProducto)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCantidadProducto)))
                            .addComponent(jLabel26)
                            .addComponent(txtNombreMarcaProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreProvedorProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(txtIdpro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtIdMarcaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(cbxIdProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(btnGuardarProducto)
                        .addGap(4, 4, 4)))
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto))
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25))
                            .addComponent(btnEditarProducto))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreProvedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreMarcaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdMarcaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxIdProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128))))
        );

        javax.swing.GroupLayout VentanaProductosLayout = new javax.swing.GroupLayout(VentanaProductos);
        VentanaProductos.setLayout(VentanaProductosLayout);
        VentanaProductosLayout.setHorizontalGroup(
            VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaProductosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        VentanaProductosLayout.setVerticalGroup(
            VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaProductosLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(VentanaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("tab4", VentanaProductos);

        VentanaRegistroVentas.setBackground(new java.awt.Color(153, 153, 153));

        TableVentas.setBackground(new java.awt.Color(0, 102, 102));
        TableVentas.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        TableVentas.setForeground(new java.awt.Color(255, 255, 255));
        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "CLIENT", "SELLER", "TOTAL"
            }
        ));
        TableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableVentasMouseClicked(evt);
            }
        });
        TableVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableVentasKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(TableVentas);
        if (TableVentas.getColumnModel().getColumnCount() > 0) {
            TableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPdfVentas.setBackground(new java.awt.Color(0, 102, 102));
        btnPdfVentas.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnPdfVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnPdfVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnPdfVentas.setText("GENERATE INVOICE");
        btnPdfVentas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPdfVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VentanaRegistroVentasLayout = new javax.swing.GroupLayout(VentanaRegistroVentas);
        VentanaRegistroVentas.setLayout(VentanaRegistroVentasLayout);
        VentanaRegistroVentasLayout.setHorizontalGroup(
            VentanaRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaRegistroVentasLayout.createSequentialGroup()
                .addGap(0, 179, Short.MAX_VALUE)
                .addGroup(VentanaRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaRegistroVentasLayout.createSequentialGroup()
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(btnPdfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(557, 557, 557))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaRegistroVentasLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))))
        );
        VentanaRegistroVentasLayout.setVerticalGroup(
            VentanaRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaRegistroVentasLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VentanaRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPdfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", VentanaRegistroVentas);

        VentanaVenta.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("CODE");

        jLabel4.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("DESCRIPTION");

        jLabel5.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("QUANTITY");

        jLabel6.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("PRICE USD");

        jLabel7.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("AVAILABILITY");

        txtCodigoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCodigoVentaMouseEntered(evt);
            }
        });
        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        txtCodigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyTyped(evt);
            }
        });

        txtCantidadVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadVentaActionPerformed(evt);
            }
        });
        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setEnabled(false);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        txtStokDisponible.setEnabled(false);
        txtStokDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokDisponibleActionPerformed(evt);
            }
        });
        txtStokDisponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStokDisponibleKeyTyped(evt);
            }
        });

        TableVenta.setBackground(new java.awt.Color(0, 102, 102));
        TableVenta.setBorder(new javax.swing.border.MatteBorder(null));
        TableVenta.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        TableVenta.setForeground(new java.awt.Color(255, 255, 255));
        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE ", "DESCRIPTION", "QUANTITY", "PRICE", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TableVenta);
        if (TableVenta.getColumnModel().getColumnCount() > 0) {
            TableVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        btnEliminarVenta.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarVenta.setFont(new java.awt.Font("Utopia", 1, 18)); // NOI18N
        btnEliminarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete22.png"))); // NOI18N
        btnEliminarVenta.setText("REMOVE PRODUCT");
        btnEliminarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DOCUMENT");

        txtDocVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocVentaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NAME");

        txtNombreClienteVenta.setEnabled(false);

        etiquetaPay.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        etiquetaPay.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        etiquetaPay.setText("TOTAL TO PAY");

        LabelTotal.setBackground(new java.awt.Color(0, 102, 102));
        LabelTotal.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        LabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal.setText("--------");

        LabelTotal1.setBackground(new java.awt.Color(0, 102, 102));
        LabelTotal1.setFont(new java.awt.Font("Utopia", 1, 12)); // NOI18N
        LabelTotal1.setForeground(new java.awt.Color(255, 255, 255));
        LabelTotal1.setText("$USD");

        btnGenerarVenta.setBackground(new java.awt.Color(0, 102, 102));
        btnGenerarVenta.setFont(new java.awt.Font("Utopia", 1, 18)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnGenerarVenta.setText("GENERATE SALES");
        btnGenerarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtDocVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txtIdCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(LabelTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(etiquetaPay, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(etiquetaPay)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarVenta)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        txtDescripcionVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescripcionVentaMouseEntered(evt);
            }
        });
        txtDescripcionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionVentaActionPerformed(evt);
            }
        });
        txtDescripcionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionVentaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout VentanaVentaLayout = new javax.swing.GroupLayout(VentanaVenta);
        VentanaVenta.setLayout(VentanaVentaLayout);
        VentanaVentaLayout.setHorizontalGroup(
            VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaVentaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentanaVentaLayout.createSequentialGroup()
                        .addGap(39, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(VentanaVentaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VentanaVentaLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE))
                            .addGroup(VentanaVentaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(69, 69, 69)))
                        .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(60, 60, 60)
                        .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtStokDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(VentanaVentaLayout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(btnEliminarVenta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        VentanaVentaLayout.setVerticalGroup(
            VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaVentaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStokDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(VentanaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VentanaVentaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("tab1", VentanaVenta);

        VentanaUsuario.setBackground(new java.awt.Color(153, 153, 153));

        TableUsuarios.setBackground(new java.awt.Color(0, 102, 102));
        TableUsuarios.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        TableUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRES", "APELLIDOS", "CORREO", "PASS", "ROL"
            }
        ));
        TableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TableUsuarios);
        if (TableUsuarios.getColumnModel().getColumnCount() > 0) {
            TableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(80);
            TableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(80);
            TableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
            TableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(80);
            TableUsuarios.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));

        jLabel20.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("NOMBRES");

        txtNombreUser.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtNombreUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUserActionPerformed(evt);
            }
        });
        txtNombreUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUserKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("APELLIDOS");

        txtApellidoUser.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtApellidoUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoUserKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("CORREO");

        txtCorreoUser.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("PASS");

        jLabel36.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("ROL");

        btnEliminarUser.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminarUser.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        btnEliminarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user3.png"))); // NOI18N
        btnEliminarUser.setText("DELETE USER");
        btnEliminarUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUserActionPerformed(evt);
            }
        });

        btnmodificarUser.setBackground(new java.awt.Color(0, 102, 102));
        btnmodificarUser.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        btnmodificarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user5.png"))); // NOI18N
        btnmodificarUser.setText("UPDATE USER");
        btnmodificarUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnmodificarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarUserActionPerformed(evt);
            }
        });

        btnmodificarUser1.setBackground(new java.awt.Color(0, 102, 102));
        btnmodificarUser1.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        btnmodificarUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user2.png"))); // NOI18N
        btnmodificarUser1.setText("NEW USER");
        btnmodificarUser1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnmodificarUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarUser1ActionPerformed(evt);
            }
        });

        txtPassUser.setEditable(false);
        txtPassUser.setColumns(20);
        txtPassUser.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtPassUser.setRows(5);
        jScrollPane12.setViewportView(txtPassUser);

        txtRolUser.setEditable(true);
        txtRolUser.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtRolUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRATOR", "ASSISTANT", " " }));

        txtNewPassUser.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("NEW PASS");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(txtNewPassUser, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRolUser, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(txtCorreoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarUser)
                            .addComponent(btnmodificarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnmodificarUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarUser))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnmodificarUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarUser1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRolUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPassUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout VentanaUsuarioLayout = new javax.swing.GroupLayout(VentanaUsuario);
        VentanaUsuario.setLayout(VentanaUsuarioLayout);
        VentanaUsuarioLayout.setHorizontalGroup(
            VentanaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaUsuarioLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        VentanaUsuarioLayout.setVerticalGroup(
            VentanaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaUsuarioLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(VentanaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab10", VentanaUsuario);

        VentanaMarca.setBackground(new java.awt.Color(153, 153, 153));

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));

        jLabel37.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("CODE BRAND");

        jLabel40.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("NAME BRAND");

        txtNombreMarca.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N

        btnSaveMarca.setBackground(new java.awt.Color(0, 102, 102));
        btnSaveMarca.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        btnSaveMarca.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SAVE2.png"))); // NOI18N
        btnSaveMarca.setText("SAVE BRANDS");
        btnSaveMarca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSaveMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMarcaActionPerformed(evt);
            }
        });

        btnDeleteMarca.setBackground(new java.awt.Color(0, 102, 102));
        btnDeleteMarca.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        btnDeleteMarca.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete22.png"))); // NOI18N
        btnDeleteMarca.setText("DELETE BRANDS");
        btnDeleteMarca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMarcaActionPerformed(evt);
            }
        });

        btnUpdateMarca.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdateMarca.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        btnUpdateMarca.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/set.png"))); // NOI18N
        btnUpdateMarca.setText("UPDATE BRANDS");
        btnUpdateMarca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMarcaActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save3.png"))); // NOI18N
        jButton4.setText("NEW BRANDS");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtCodigoMarca.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        txtCodigoMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoMarcaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel40)
                        .addComponent(jLabel37)
                        .addComponent(txtNombreMarca)
                        .addComponent(txtCodigoMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addComponent(txtIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnSaveMarca))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel37)))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteMarca)
                    .addComponent(txtCodigoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnUpdateMarca))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(txtIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TableMarca.setBackground(new java.awt.Color(0, 102, 102));
        TableMarca.setFont(new java.awt.Font("Utopia", 1, 13)); // NOI18N
        TableMarca.setForeground(new java.awt.Color(255, 255, 255));
        TableMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID BRAND", "CODE", "NAME BRAND"
            }
        ));
        TableMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMarcaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableMarca);

        javax.swing.GroupLayout VentanaMarcaLayout = new javax.swing.GroupLayout(VentanaMarca);
        VentanaMarca.setLayout(VentanaMarcaLayout);
        VentanaMarcaLayout.setHorizontalGroup(
            VentanaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaMarcaLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        VentanaMarcaLayout.setVerticalGroup(
            VentanaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaMarcaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(VentanaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab8", VentanaMarca);

        VentanaMesa.setBackground(new java.awt.Color(153, 153, 153));

        jPanel18.setBackground(new java.awt.Color(0, 102, 102));

        jLabel41.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("DESK");

        txtIdMesa.setEditable(false);
        txtIdMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtIdMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMesaActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("CLIENT");

        txtIdClienteMesa.setEditable(false);
        txtIdClienteMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("PROBLEM");

        txtProblemaMesa.setEditable(false);
        txtProblemaMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtProblemaMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProblemaMesaActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("DESCRIPTION");

        jLabel45.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("STATE");

        jLabel46.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ANSWER");

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1486485553-ago-arrow-arrow-left-back-previous-direction-left_81160.png"))); // NOI18N
        jButton2.setText("RESPOND HELPDESK");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtRespuestaMesa.setColumns(20);
        txtRespuestaMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtRespuestaMesa.setRows(5);
        jScrollPane9.setViewportView(txtRespuestaMesa);

        txtDescripcionMesa.setEditable(false);
        txtDescripcionMesa.setColumns(20);
        txtDescripcionMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtDescripcionMesa.setRows(5);
        jScrollPane10.setViewportView(txtDescripcionMesa);

        txtEstadoMesa.setEditable(true);
        txtEstadoMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        txtEstadoMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPEN", "CLOSE", " " }));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane10)
                            .addComponent(txtProblemaMesa)
                            .addComponent(jScrollPane9)
                            .addComponent(jLabel44)
                            .addComponent(jLabel46)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel43)
                                    .addComponent(txtIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                        .addComponent(txtIdClienteMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addGap(51, 51, 51)))
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(txtEstadoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton2)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdClienteMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProblemaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        TablaMesa.setBackground(new java.awt.Color(0, 102, 102));
        TablaMesa.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        TablaMesa.setForeground(new java.awt.Color(255, 255, 255));
        TablaMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° DESK", "CLIENT", "PROBLEM", "DESCRIPTION", "STATE", "ANSWER"
            }
        ));
        TablaMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMesaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TablaMesa);
        if (TablaMesa.getColumnModel().getColumnCount() > 0) {
            TablaMesa.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablaMesa.getColumnModel().getColumn(3).setPreferredWidth(200);
            TablaMesa.getColumnModel().getColumn(4).setPreferredWidth(2);
            TablaMesa.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        javax.swing.GroupLayout VentanaMesaLayout = new javax.swing.GroupLayout(VentanaMesa);
        VentanaMesa.setLayout(VentanaMesaLayout);
        VentanaMesaLayout.setHorizontalGroup(
            VentanaMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaMesaLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        VentanaMesaLayout.setVerticalGroup(
            VentanaMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaMesaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(VentanaMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", VentanaMesa);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1360, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        ListarCliente();
        LimpiarTable();
        ListarCliente();
        btnEditarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
        btnGuardarCliente.setEnabled(false);
        LimpiarCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void txtStokDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokDisponibleActionPerformed

    private void txtCantidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadVentaActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void TableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClienteMouseClicked
        // TODO add your handling code here:
        btnEditarCliente.setEnabled(true);
        btnEliminarCliente.setEnabled(true);
        btnGuardarCliente.setEnabled(false);
        int fila = TableCliente.rowAtPoint(evt.getPoint());
        txtIdCliente.setText(TableCliente.getValueAt(fila, 0).toString());
        txtTipo_DocCliente.setSelectedItem(TableCliente.getValueAt(fila, 1).toString());
        txtDocCliente.setText(TableCliente.getValueAt(fila, 2).toString());
        txtNombreCliente.setText(TableCliente.getValueAt(fila, 3).toString());
        txtApellidoCliente.setText(TableCliente.getValueAt(fila, 4).toString());
        txtTelefonoCliente.setText(TableCliente.getValueAt(fila, 5).toString());
        txtDireccionCliente.setText(TableCliente.getValueAt(fila, 6).toString());

    }//GEN-LAST:event_TableClienteMouseClicked

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtNitProveedor.getText()) || !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText())) {
            pr.setNit(txtNitProveedor.getText());
            pr.setNombre(txtNombreProveedor.getText());
            pr.setTelefono(txtTelefonoProveedor.getText());
            pr.setDireccion(txtDireccionProveedor.getText());
            PrDao.RegistrarProveedor(pr);
            JOptionPane.showMessageDialog(null, "Registered Provider");
            LimpiarTable();
            ListarProveedor();
            LimpiarProveedor();
            btnEditarProveedor.setEnabled(false);
            btnEliminarProveedor.setEnabled(false);
            btnGuardarProveedor.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "The fields are empty");
        }
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdProveedor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "You are sure to delete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdProveedor.getText());
                PrDao.EliminarProveedor(id);
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row");
        }

    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdProveedor.getText())) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {
            if (!"".equals(txtNitProveedor.getText()) || !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText())) {
                pr.setNit(txtNitProveedor.getText());
                pr.setNombre(txtNombreProveedor.getText());
                pr.setTelefono(txtTelefonoProveedor.getText());
                pr.setDireccion(txtDireccionProveedor.getText());
                pr.setId(Integer.parseInt(txtIdProveedor.getText()));
                PrDao.ModificarProveedor(pr);
                JOptionPane.showMessageDialog(null, "Modified Provider");
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();
                btnEditarProveedor.setEnabled(false);
                btnEliminarProveedor.setEnabled(false);
                btnGuardarProveedor.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void txtNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoProveedorActionPerformed
        // TODO add your handling code here:
        LimpiarProveedor();
        btnEditarProveedor.setEnabled(false);
        btnEliminarProveedor.setEnabled(false);
        btnGuardarProveedor.setEnabled(true);
    }//GEN-LAST:event_txtNuevoProveedorActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:

        ListarProveedor();
        LimpiarTable();
        ListarProveedor();
        jTabbedPane1.setSelectedIndex(2);
        btnEditarProveedor.setEnabled(false);
        btnEliminarProveedor.setEnabled(false);
        btnGuardarProveedor.setEnabled(false);
        LimpiarProveedor();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void TableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProveedorMouseClicked
        // TODO add your handling code here:
        btnEditarProveedor.setEnabled(true);
        btnEliminarProveedor.setEnabled(true);
        btnGuardarProveedor.setEnabled(false);
        int fila = TableProveedor.rowAtPoint(evt.getPoint());
        txtIdProveedor.setText(TableProveedor.getValueAt(fila, 0).toString());
        txtNitProveedor.setText(TableProveedor.getValueAt(fila, 1).toString());
        txtNombreProveedor.setText(TableProveedor.getValueAt(fila, 2).toString());
        txtTelefonoProveedor.setText(TableProveedor.getValueAt(fila, 3).toString());
        txtDireccionProveedor.setText(TableProveedor.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_TableProveedorMouseClicked

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtDocCliente.getText()) || !"".equals(txtTipo_DocCliente.getSelectedItem()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtApellidoCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())) {
            cl.setDoc(txtDocCliente.getText());
            cl.setTipo_Doc(txtTipo_DocCliente.getSelectedItem().toString());
            cl.setNombre(txtNombreCliente.getText());
            cl.setApellido(txtApellidoCliente.getText());
            cl.setTelefono(txtTelefonoCliente.getText());
            cl.setDireccion(txtDireccionCliente.getText());
            client.RegistrarCliente(cl);
        
            JOptionPane.showMessageDialog(null, "Registered Customer");
            LimpiarTable();
            LimpiarCliente();
            ListarCliente();
            btnEditarCliente.setEnabled(false);
            btnEliminarCliente.setEnabled(false);
            btnGuardarCliente.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "The fields are empty");
        }
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:

        if (!"".equals(txtIdCliente.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdCliente.getText());
                client.EliminarCliente(id);
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // TODO add your handling code here:

        if ("".equals(txtIdCliente.getText())) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {

            if (!"".equals(txtDocCliente.getText()) || !"".equals(txtTipo_DocCliente.getSelectedItem()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtApellidoCliente.getText()) || !"".equals(txtTelefonoCliente.getText())) {
                cl.setDoc(txtDocCliente.getText());
                cl.setTipo_Doc(txtTipo_DocCliente.getSelectedItem().toString());
                cl.setNombre(txtNombreCliente.getText());
                cl.setApellido(txtApellidoCliente.getText());
                cl.setTelefono(txtTelefonoCliente.getText());
                cl.setDireccion(txtDireccionCliente.getText());
                cl.setId(Integer.parseInt(txtIdCliente.getText()));
                client.ModificarCliente(cl);
                JOptionPane.showMessageDialog(null, "Modified Client");
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "The fields are empty");
            }
        }

    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void txtNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoClienteActionPerformed
        // TODO add your handling code here:
        LimpiarCliente();
        btnEditarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
        btnGuardarCliente.setEnabled(true);
    }//GEN-LAST:event_txtNuevoClienteActionPerformed

    private void txtDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteActionPerformed

    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        ListarProductos();
        ListarNombreMarca();
        ListarNombreProvedor();
        LimpiarTable();
        ListarProductos();
        jTabbedPane1.setSelectedIndex(3);
        btnEditarProducto.setEnabled(false);
        btnEliminarProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(false);
        LimpiarProductos();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        // TODO add your handling code here:
        String nombre = txtNombreMarcaProducto.getSelectedItem().toString();
        Marca marcaEncontrada = mar.BuscarIdMarca(nombre);
        
        int idMarca = marcaEncontrada.getId();
        System.out.print(idMarca);  
        txtIdMarcaProducto.setText(String.valueOf(idMarca));
        
        
        String nombrePr = txtNombreProvedorProducto.getSelectedItem().toString();
         Proveedor pronNom =  PrDao.BuscarIdProvedor(nombrePr);
        
        int idPro= pronNom.getId();
       // System.out.print(idPro);  
        cbxIdProveedorProducto.setText(String.valueOf(idPro));
        
        
        
        
        
        
        if (!"".equals(txtCodigoProducto.getText()) || !"".equals(txtDescripcionProducto.getText()) || !"".equals(cbxIdProveedorProducto.getText()) || !"".equals(txtCantidadProducto.getText()) || !"".equals(txtPrecioProducto.getText())) {
            pro.setCodigo(txtCodigoProducto.getText());
            pro.setNombre(txtNombreProducto.getText());
            pro.setDescripcion(txtDescripcionProducto.getText());
            pro.setProveedor(Integer.parseInt(cbxIdProveedorProducto.getText()));
            

            pro.setMarca(txtIdMarcaProducto.getText());
             
            pro.setStock(Integer.parseInt(txtCantidadProducto.getText()));
            pro.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
            proDao.RegistrarProductos(pro);
            JOptionPane.showMessageDialog(null, "Registered Products");
            LimpiarTable();
            ListarProductos();
            LimpiarProductos();
            btnEditarProducto.setEnabled(false);
            btnEliminarProducto.setEnabled(false);
            btnGuardarProducto.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "The fields are empty");
        }
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void TableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductoMouseClicked
        //TODO add your handling code here:
        
        btnEditarProducto.setEnabled(true);
        btnEliminarProducto.setEnabled(true);
        btnGuardarProducto.setEnabled(false);
        int fila = TableProducto.rowAtPoint(evt.getPoint());
        txtIdpro.setText(TableProducto.getValueAt(fila, 0).toString());
        txtCodigoProducto.setText(TableProducto.getValueAt(fila, 1).toString());
        txtNombreProducto.setText(TableProducto.getValueAt(fila, 2).toString());
        txtDescripcionProducto.setText(TableProducto.getValueAt(fila, 3).toString());
        
      
        int id = Integer.parseInt(TableProducto.getValueAt(fila, 5).toString());
        txtIdMarcaProducto.setText(TableProducto.getValueAt(fila, 5).toString());
       // System.out.print(id);
         mar.BuscarNombreMarca(id);
        Marca marcaEncontrada = mar.BuscarNombreMarca(id);
        // Ahora, puedes usar la marcaEncontrada según sea necesario
        String nombreMarca = marcaEncontrada.getNombreMarca();
        //System.out.print(nombreMarca);   
        txtNombreMarcaProducto.setSelectedItem(nombreMarca);
      
        
        
        
        int idPro = Integer.parseInt(TableProducto.getValueAt(fila, 4).toString());
         cbxIdProveedorProducto.setText(TableProducto.getValueAt(fila, 4).toString());
        
        PrDao.BuscarNombreProvedor(idPro);
        
        Proveedor pronNom =  PrDao.BuscarNombreProvedor(idPro);
         String nombreProvedor = pronNom.getNombre();
        //System.out.print(nombreMarca);   
        txtNombreProvedorProducto.setSelectedItem(nombreProvedor);
        
        
        
        
         
        
        txtCantidadProducto.setText(TableProducto.getValueAt(fila, 6).toString());
        txtPrecioProducto.setText(TableProducto.getValueAt(fila, 7).toString());


    }//GEN-LAST:event_TableProductoMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdpro.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdpro.getText());
                proDao.EliminarProductos(id);
                LimpiarTable();
                LimpiarProductos();
                ListarProductos();
                btnEditarProducto.setEnabled(false);
                btnEliminarProducto.setEnabled(false);
                btnGuardarProducto.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        // TODO add your handling code here:
      
        String nombre = txtNombreMarcaProducto.getSelectedItem().toString();
        Marca marcaEncontrada = mar.BuscarIdMarca(nombre);
        
        int idMarca = marcaEncontrada.getId();
        //System.out.print(idMarca);  
        txtIdMarcaProducto.setText(String.valueOf(idMarca));
        
        
        
        String nombrePr = txtNombreProvedorProducto.getSelectedItem().toString();
         Proveedor pronNom =  PrDao.BuscarIdProvedor(nombrePr);
        
        int idPro= pronNom.getId();
       // System.out.print(idPro);  
        cbxIdProveedorProducto.setText(String.valueOf(idPro));
        
        
        
        if ("".equals(txtIdpro.getText())) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {
            if (!"".equals(txtCodigoProducto.getText()) || !"".equals(txtNombreProducto.getText()) || !"".equals(txtDescripcionProducto.getText()) || !"".equals(txtNombreMarcaProducto.getSelectedItem()) || !"".equals(cbxIdProveedorProducto.getText()) || !"".equals(txtCantidadProducto.getText()) || !"".equals(txtPrecioProducto.getText())) {
                pro.setId(Integer.parseInt(txtIdpro.getText()));
                pro.setCodigo(txtCodigoProducto.getText());
                pro.setNombre(txtNombreProducto.getText());
                pro.setDescripcion(txtDescripcionProducto.getText());
                pro.setProveedor(Integer.parseInt(cbxIdProveedorProducto.getText()));
                pro.setMarca(txtIdMarcaProducto.getText());
                pro.setStock(Integer.parseInt(txtCantidadProducto.getText()));
                pro.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
                proDao.ModificarProductos(pro);
                JOptionPane.showMessageDialog(null, "Modified products");
                LimpiarTable();
                ListarProductos();
                LimpiarProductos();
                btnEditarProducto.setEnabled(false);
                btnEliminarProducto.setEnabled(false);
                btnGuardarProducto.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "The fields are empty");
            }
        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        // TODO add your handling code here:
        LimpiarProductos();
        btnEditarProducto.setEnabled(false);
        btnEliminarProducto.setEnabled(false);
        btnGuardarProducto.setEnabled(true);
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your handling code here:
        Excel.reporte();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtCodigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodigoVenta.getText())) {
                String cod = txtCodigoVenta.getText();
                pro = proDao.BuscarPro(cod);
                if (pro.getNombre() != null) {
                    txtIdPro.setText("" + pro.getId());
                    txtDescripcionVenta.setText("" + pro.getNombre());
                    txtPrecioVenta.setText("" + pro.getPrecio());
                    txtStokDisponible.setText("" + pro.getStock());
                    txtCantidadVenta.requestFocus();
                } else {
                    LimparVenta();
                    txtCodigoVenta.requestFocus();
                    txtDescripcionVenta.setText("");
                    txtPrecioVenta.setText("");
                    txtStokDisponible.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter the product code");
                txtCodigoVenta.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoVentaKeyPressed

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCantidadVenta.getText())) {
                
                int id = Integer.parseInt(txtIdPro.getText());
                String descripcion = txtDescripcionVenta.getText();
                int cant = Integer.parseInt(txtCantidadVenta.getText());
                double precio = Double.parseDouble(txtPrecioVenta.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtStokDisponible.getText());
                
                if (stock >= cant) {
                    item = item + 1;
                    tmp = (DefaultTableModel) TableVenta.getModel();
                    for (int i = 0; i < TableVenta.getRowCount(); i++) {
                        if (TableVenta.getValueAt(i, 1).equals(txtDescripcionVenta.getText())) {
                            //mensaje si el producto es registrado do veces :)
                            JOptionPane.showMessageDialog(null, "The product is already registered");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(id);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] O = new Object[5];
                    O[0] = lista.get(1);
                    O[1] = lista.get(2);
                    O[2] = lista.get(3);
                    O[3] = lista.get(4);
                    O[4] = lista.get(5);
                    tmp.addRow(O);
                    TableVenta.setModel(tmp);
                    TotalPagar();
                    LimparVenta();
                    txtCodigoVenta.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Stock not available");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter Amount");
            }
        }
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        // TODO add your handling code here:
        modelo = (DefaultTableModel) TableVenta.getModel();
        modelo.removeRow(TableVenta.getSelectedRow());
        TotalPagar();
        txtCodigoVenta.requestFocus();
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void txtDocVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocVentaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtDocVenta.getText())) {
                int dni = Integer.parseInt(txtDocVenta.getText());
                cl = client.Buscarcliente(dni);
                if (cl.getNombre() != null) {
                    txtNombreClienteVenta.setText("" + cl.getNombre());
                    txtIdCV.setText("" + cl.getId());
                } else {
                    txtDocVenta.setText("");
                    JOptionPane.showMessageDialog(null, "The client does not exist");
                }
            }
        }
    }//GEN-LAST:event_txtDocVentaKeyPressed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
        if (TableVenta.getRowCount() > 0) {
            if (!"".equals(txtNombreClienteVenta.getText())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                LimpiarTableVenta();
                LimpiarClienteventa();
                
                LabelTotal.setText("--------");
            } else {
                JOptionPane.showMessageDialog(null, "You must find a client");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Noy products on sale");
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void TableVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableVentasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TableVentasKeyPressed

    private void TableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVentasMouseClicked
        // TODO add your handling code here:
        int fila = TableVentas.rowAtPoint(evt.getPoint());
        txtIdVenta.setText(TableVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_TableVentasMouseClicked

    private void btnBrandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrandsActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(7);
        LimpiarTable();
        ListarMarca();
        LimpiarTable();
        ListarMarca();
        
        btnSaveMarca.setEnabled(false);
        btnDeleteMarca.setEnabled(false);
        btnUpdateMarca.setEnabled(false);
        LimpiarMarca();
    }//GEN-LAST:event_btnBrandsActionPerformed

    private void txtCodigoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoVentaKeyTyped

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        // TODO add your handling code here:
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnActualizarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarConfigActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtNitConfig.getText()) || !"".equals(txtNombreConfig.getText()) || !"".equals(txtTelefonoConfig.getText()) || !"".equals(txtDireccionConfig.getText())) {
            conf.setNit(txtNitConfig.getText());
            conf.setNombre(txtNombreConfig.getText());
            conf.setTelefono(txtTelefonoConfig.getText());
            conf.setDireccion(txtDireccionConfig.getText());
            conf.setMensaje(txtMensaje.getText());
            conf.setId(Integer.parseInt(txtIdConfig.getText()));
            proDao.ModificarDatos(conf);
            JOptionPane.showMessageDialog(null, "Company data modified");
            ListarConfig();
        } else {
            JOptionPane.showMessageDialog(null, "The fields are empty");
        }
    }//GEN-LAST:event_btnActualizarConfigActionPerformed

    private void btnPdfVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfVentasActionPerformed
        // TODO add your handling code here:
        if (txtIdVenta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {
            v = Vdao.BuscarVenta(Integer.parseInt(txtIdVenta.getText()));
            Vdao.pdfV(v.getId(), v.getCliente(), v.getTotal(), v.getVendedor());
        }
    }//GEN-LAST:event_btnPdfVentasActionPerformed

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        // TODO add your handling code here:
        ListarUsuarios();
        LimpiarTable();
        ListarUsuarios();
        jTabbedPane1.setSelectedIndex(6);
        
        
        btnEliminarUser.setEnabled(false);
        btnmodificarUser.setEnabled(false);
        LimpiarUser();
        
    }//GEN-LAST:event_btnUsersActionPerformed

    private void TableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuariosMouseClicked
        // TODO add your handling code here:

        int fila = TableUsuarios.rowAtPoint(evt.getPoint());
        txtIdUser.setText(TableUsuarios.getValueAt(fila, 0).toString());
        txtNombreUser.setText(TableUsuarios.getValueAt(fila, 1).toString());
        txtApellidoUser.setText(TableUsuarios.getValueAt(fila, 2).toString());
        txtCorreoUser.setText(TableUsuarios.getValueAt(fila, 3).toString());
        txtPassUser.setText(TableUsuarios.getValueAt(fila, 4).toString());
        txtRolUser.setSelectedItem(TableUsuarios.getValueAt(fila, 5).toString());
        
        btnEliminarUser.setEnabled(true);
        btnmodificarUser.setEnabled(true);
    }//GEN-LAST:event_TableUsuariosMouseClicked

    private void btnEliminarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUserActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdUser.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdUser.getText());
                login.EliminarUser(id);
                LimpiarTable();
                LimpiarUser();
                ListarUsuarios();
            }
        }
    }//GEN-LAST:event_btnEliminarUserActionPerformed

    private void txtNombreUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUserActionPerformed

    private void btnmodificarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarUserActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdUser.getText())) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {

            if (!"".equals(txtNombreUser.getText()) || !"".equals(txtApellidoUser.getText()) || !"".equals(txtCorreoUser.getText()) || !"".equals(txtPassUser.getText()) || !"".equals(txtRolUser.getSelectedItem())) {
                lg.setNombres(txtNombreUser.getText());
                lg.setApellidos(txtApellidoUser.getText());
                lg.setCorreo(txtCorreoUser.getText());
                
                
                String newClave = txtNewPassUser.getText().toString();
                String hashedPassword = hashPassword(newClave);
                
                lg.setPass(hashedPassword);
                
                lg.setRol(txtRolUser.getSelectedItem().toString());
                lg.setId(Integer.parseInt(txtIdUser.getText()));
                login.ModificarUser(lg);
                JOptionPane.showMessageDialog(null, "Modified Client");
                LimpiarTable();
                LimpiarUser();
                ListarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "The fields are empty");
            }
        }
    }//GEN-LAST:event_btnmodificarUserActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void btnVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentas1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
        ListarVentas();
        LimpiarTable();
        ListarVentas();
    }//GEN-LAST:event_btnVentas1ActionPerformed

    private void TableMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMarcaMouseClicked
        // TODO add your handling code here:

        int fila = TableMarca.rowAtPoint(evt.getPoint());
        txtIdMarca.setText(TableMarca.getValueAt(fila, 0).toString());
        txtCodigoMarca.setText(TableMarca.getValueAt(fila, 1).toString());
        txtNombreMarca.setText(TableMarca.getValueAt(fila, 2).toString());
        btnUpdateMarca.setEnabled(true);
        btnDeleteMarca.setEnabled(true);
        btnSaveMarca.setEnabled(false);
    }//GEN-LAST:event_TableMarcaMouseClicked

    private void btnSaveMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMarcaActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdMarca.getText()) || !"".equals(txtCodigoMarca.getText()) || !"".equals(txtNombreMarca.getText())) {
            mr.setCodigo(Integer.parseInt(txtCodigoMarca.getText()));
            mr.setNombreMarca(txtNombreMarca.getText());
            mar.RegistrarMarca(mr);
            JOptionPane.showMessageDialog(null, "Registered Trademark");
            LimpiarTable();
            ListarMarca();
            LimpiarMarca();

        }
    }//GEN-LAST:event_btnSaveMarcaActionPerformed


    private void btnDeleteMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMarcaActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtIdMarca.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdMarca.getText());
                mar.EliminarMarca(id);
                LimpiarTable();
                LimpiarMarca();
                ListarMarca();
                btnEditarProducto.setEnabled(false);
                btnEliminarProducto.setEnabled(false);
                btnGuardarProducto.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row");
        }

    }//GEN-LAST:event_btnDeleteMarcaActionPerformed

    private void btnUpdateMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMarcaActionPerformed
        // TODO add your handling code here:

        if ("".equals(txtIdMarca.getText())) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {
            if (!"".equals(txtIdMarca.getText()) || !"".equals(txtCodigoMarca.getText()) || !"".equals(txtNombreMarca.getText())) {

                mr.setId(Integer.parseInt(txtIdMarca.getText()));
                mr.setCodigo(Integer.parseInt(txtCodigoMarca.getText()));
                mr.setNombreMarca(txtNombreMarca.getText());

                mar.ModificarMarca(mr);
                JOptionPane.showMessageDialog(null, "Modified Brand");
                LimpiarTable();
                ListarMarca();
                LimpiarMarca();
            }

        }
    }//GEN-LAST:event_btnUpdateMarcaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        LimpiarMarca();
        btnUpdateMarca.setEnabled(false);
        btnDeleteMarca.setEnabled(false);
        btnSaveMarca.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // login.Registrar(lg);

        Login iniciar = new Login();
        iniciar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHelpDeskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpDeskActionPerformed
        // TODO add your handling code here:
        ListarMesa();
        LimpiarTable();
        ListarMesa();
        jTabbedPane1.setSelectedIndex(8);
        
        LimpiarMesa() ;
    }//GEN-LAST:event_btnHelpDeskActionPerformed

    private void TablaMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMesaMouseClicked
        // TODO add your handling code here:
         
        int fila = TablaMesa.rowAtPoint(evt.getPoint());
        
     
        
        txtIdMesa.setText(TablaMesa.getValueAt(fila, 0).toString());
        txtIdClienteMesa.setText(TablaMesa.getValueAt(fila, 1).toString());
        txtProblemaMesa.setText(TablaMesa.getValueAt(fila, 2).toString());
        txtDescripcionMesa.setText(TablaMesa.getValueAt(fila, 3).toString());
      //  txtEstadoMesa.setSelectedItem(TablaMesa.getValueAt(fila, 4).toString());
      
      
       if (TablaMesa.getValueAt(fila, 4).equals(1)) {
            
            txtEstadoMesa.setSelectedItem("OPEN");
        }
        if (TablaMesa.getValueAt(fila, 4).equals(2)) {
            txtEstadoMesa.setSelectedItem("CLOSE");
        }
      
      
        txtRespuestaMesa.setText(TablaMesa.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_TablaMesaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if ("".equals(txtRespuestaMesa.getText())) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {
            if (!"".equals(txtRespuestaMesa.getText())) {

                 if ("OPEN".equals(txtEstadoMesa.getSelectedItem())) {
                    txtEstadoMesa.setSelectedItem("1");
                }
                 if ("CLOSE".equals(txtEstadoMesa.getSelectedItem())) {
                    txtEstadoMesa.setSelectedItem("2");
                }
                ms.setId(Integer.parseInt(txtIdMesa.getText()));
                 ms.setEstado(Integer.parseInt(txtEstadoMesa.getSelectedItem().toString()));
                ms.setRespuesta(txtRespuestaMesa.getText());

                mes.ModificarMesa(ms);
                JOptionPane.showMessageDialog(null, "Answered Helpdesk");
                LimpiarTable();
                ListarMesa();

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnmodificarUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarUser1ActionPerformed
        // TODO add your handling code here:

        Registro regis = new Registro();
        regis.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnmodificarUser1ActionPerformed

    private void btnActualizarConfig1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarConfig1ActionPerformed
        // TODO add your handling code here:
         try {
            // Especifica la URL que deseas abrir
            URI uri = new URI("http://localhost/APP/login.php");

            // Abre la URL en el navegador predeterminado
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActualizarConfig1ActionPerformed

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void txtCodigoVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoVentaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaMouseEntered

    private void txtDocVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocVentaKeyTyped
        // TODO add your handling code here:
          event.numberKeyPress(evt);
    }//GEN-LAST:event_txtDocVentaKeyTyped

    private void txtNitConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitConfigKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtNitConfigKeyTyped

    private void txtTelefonoConfigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoConfigKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtTelefonoConfigKeyTyped

    private void txtDocClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocClienteKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtDocClienteKeyTyped

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void txtNitProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitProveedorKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtNitProveedorKeyTyped

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtStokDisponibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStokDisponibleKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtStokDisponibleKeyTyped

    private void txtCodigoMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoMarcaKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoMarcaKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        // TODO add your handling code here:
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoClienteKeyTyped
        // TODO add your handling code here:
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtApellidoClienteKeyTyped

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        // TODO add your handling code here:
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void txtNombreUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUserKeyTyped
        // TODO add your handling code here:
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreUserKeyTyped

    private void txtApellidoUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoUserKeyTyped
        // TODO add your handling code here:
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtApellidoUserKeyTyped

    private void txtDescripcionVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescripcionVentaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionVentaMouseEntered

    private void txtDescripcionVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionVentaActionPerformed

    private void txtDescripcionVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionVentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionVentaKeyPressed

    private void txtDescripcionVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionVentaKeyTyped

    private void cbxIdProveedorProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxIdProveedorProductoKeyTyped
        // TODO add your handling code here:
         event.numberKeyPress(evt);
    }//GEN-LAST:event_cbxIdProveedorProductoKeyTyped

    private void txtIdMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMesaActionPerformed

    private void txtProblemaMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProblemaMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProblemaMesaActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelTotal1;
    private javax.swing.JLabel LavelVendedor;
    private javax.swing.JTable TablaMesa;
    private javax.swing.JTable TableCliente;
    private javax.swing.JTable TableMarca;
    private javax.swing.JTable TableProducto;
    private javax.swing.JTable TableProveedor;
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTable TableVentas;
    private javax.swing.JPanel Ventana1;
    private javax.swing.JPanel VentanaClientes;
    private javax.swing.JPanel VentanaMarca;
    private javax.swing.JPanel VentanaMesa;
    private javax.swing.JPanel VentanaProductos;
    private javax.swing.JPanel VentanaProvedores;
    private javax.swing.JPanel VentanaRegistroVentas;
    private javax.swing.JPanel VentanaUsuario;
    private javax.swing.JPanel VentanaVenta;
    private javax.swing.JButton btnActualizarConfig;
    private javax.swing.JButton btnActualizarConfig1;
    private javax.swing.JButton btnBrands;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnDeleteMarca;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarUser;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnHelpDesk;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnPdfVentas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSaveMarca;
    private javax.swing.JButton btnUpdateMarca;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnVentas1;
    private javax.swing.JButton btnmodificarUser;
    private javax.swing.JButton btnmodificarUser1;
    private javax.swing.JTextField cbxIdProveedorProducto;
    private javax.swing.JLabel etiquetaPay;
    private javax.swing.JLabel fff;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtApellidoUser;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoMarca;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtCorreoUser;
    private javax.swing.JTextArea txtDescripcionMesa;
    private javax.swing.JTextArea txtDescripcionProducto;
    private javax.swing.JTextField txtDescripcionVenta;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionConfig;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtDocCliente;
    private javax.swing.JTextField txtDocVenta;
    private javax.swing.JComboBox<String> txtEstadoMesa;
    private javax.swing.JTextField txtIdCV;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdClienteMesa;
    private javax.swing.JTextField txtIdConfig;
    private javax.swing.JTextField txtIdMarca;
    private javax.swing.JTextField txtIdMarcaProducto;
    private javax.swing.JTextField txtIdMesa;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtIdpro;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextField txtNewPassUser;
    private javax.swing.JTextField txtNitConfig;
    private javax.swing.JTextField txtNitProveedor;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreClienteVenta;
    private javax.swing.JTextField txtNombreConfig;
    private javax.swing.JTextField txtNombreMarca;
    private javax.swing.JComboBox<String> txtNombreMarcaProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JComboBox<String> txtNombreProvedorProducto;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreUser;
    private javax.swing.JButton txtNuevoCliente;
    private javax.swing.JButton txtNuevoProveedor;
    private javax.swing.JTextArea txtPassUser;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtProblemaMesa;
    private javax.swing.JTextArea txtRespuestaMesa;
    private javax.swing.JComboBox<String> txtRolUser;
    private javax.swing.JTextField txtStokDisponible;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoConfig;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JComboBox<String> txtTipo_DocCliente;
    // End of variables declaration//GEN-END:variables
    /** 
     * <b>LimpiarCliente()</b>
     * <b>OBJETIVO:</b>LImpiar los datos del cliente.
     *
     * 
     */
    private void LimpiarCliente() {
        txtIdCliente.setText("");
        txtDocCliente.setText("");   
        txtTipo_DocCliente.setSelectedItem("");
        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
    }
    /** 
     * <b>LimpiarProveedor()</b>
     * <b>OBJETIVO:</b>LImpiar los datos del proveedor.
     *
     * 
     */
    private void LimpiarProveedor() {
        txtIdProveedor.setText("");
        txtNitProveedor.setText("");
        txtNombreProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
    }
    /** 
     * <b>LimpiarProductos()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de los  productos.
     *
     * 
     */
    private void LimpiarProductos() {
        txtIdpro.setText("");
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        cbxIdProveedorProducto.setText("");
        txtNombreMarcaProducto.setSelectedItem("");
        txtNombreProvedorProducto.setSelectedItem("");
        
        txtDescripcionProducto.setText("");
        txtCantidadProducto.setText("");
        txtPrecioProducto.setText("");
    }
    /** 
     * <b>TotalPagar()</b>
     * <b>OBJETIVO:</b>Obtiene el total a pagar en la ventaal cliente.
     *
     * 
     */
    private void TotalPagar() {
        Totalpagar = 0.00;
        int numFila = TableVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(TableVenta.getModel().getValueAt(i, 4)));
            Totalpagar = Totalpagar + cal;
        }
        LabelTotal.setText(String.format("%.2f", Totalpagar));
    }
    /** 
     * <b>LimparVenta()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de la venta.
     *
     * 
     */
    private void LimparVenta() {
        txtCodigoVenta.setText("");
        txtDescripcionVenta.setText("");
        txtCantidadVenta.setText("");
        txtStokDisponible.setText("");
        txtPrecioVenta.setText("");
        txtIdVenta.setText("");
    }
    /** 
     * <b>LimpiarMarca()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de la marca.
     *
     * 
     */
    private void LimpiarMarca() {
        txtCodigoMarca.setText("");
        txtIdMarca.setText("");
        txtNombreMarca.setText("");

    }
    /** 
     * <b>RegistrarVenta()</b>
     * <b>OBJETIVO:</b>Registra  la venta.
     *
     * 
     */
    private void RegistrarVenta() {
        int cliente = Integer.parseInt(txtIdCV.getText());
        String vendedor = LavelVendedor.getText();
        double monto = Totalpagar;
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(monto);
        v.setFecha(fechaActual);
        Vdao.RegistrarVenta(v);
    }
    /** 
     * <b>RegistrarDetalle()</b>
     * <b>OBJETIVO:</b>Registra los detalles de la venta.
     *
     * 
     */
    private void RegistrarDetalle() {
        int id = Vdao.IdVenta();
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            int id_pro = Integer.parseInt(TableVenta.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(TableVenta.getValueAt(i, 3).toString());
            Dv.setId_pro(id_pro);
            Dv.setCantidad(cant);
            Dv.setPrecio(precio);
            Dv.setId(id);
            Vdao.RegistrarDetalle(Dv);

        }
        int cliente = Integer.parseInt(txtIdCV.getText());
        Vdao.pdfV(id, cliente, Totalpagar, LavelVendedor.getText());
    }
    /** 
     * <b>ActualizarStock()</b>
     * <b>OBJETIVO:</b>Actualizar el stock del producto.
     *
     * 
     */
    private void ActualizarStock() {
        for (int i = 0; i < TableVenta.getRowCount(); i++) {
            int id = Integer.parseInt(TableVenta.getValueAt(i, 0).toString());
            int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
            pro = proDao.BuscarId(id);
            int StockActual = pro.getStock() - cant;
            Vdao.ActualizarStock(StockActual, id);

        }
    }
    /** 
     * <b>LimpiarTableVenta()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de la venta.
     *
     * 
     */
    private void LimpiarTableVenta() {
        tmp = (DefaultTableModel) TableVenta.getModel();
        int fila = TableVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }
    /** 
     * <b>LimpiarClienteventa()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de la venta cliente.
     *
     * 
     */
    private void LimpiarClienteventa() {
        txtDocVenta.setText("");
        txtNombreClienteVenta.setText("");
        txtIdCV.setText("");
        
    }
    /** 
     * <b>LimpiarUser()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de usuario.
     *
     * 
     */
    private void LimpiarUser() {
        txtNombreUser.setText("");
        txtApellidoUser.setText("");
        txtCorreoUser.setText("");
        txtPassUser.setText("");
        txtRolUser.setSelectedItem("");
        txtNewPassUser.setText("");

    }
    /** 
     * <b>LimpiarMesa()</b>
     * <b>OBJETIVO:</b>LImpiar los datos de la mesa de ayuda.
     *
     * 
     */
    private void LimpiarMesa() {
        txtIdMesa.setText("");
        txtIdClienteMesa.setText("");
          txtEstadoMesa.setSelectedItem("");
        txtProblemaMesa.setText("");
        txtDescripcionMesa.setText("");
        txtRespuestaMesa.setText("");
    }

 


}//fin clase Sistema
