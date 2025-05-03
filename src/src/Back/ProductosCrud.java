package Back;

import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.PreparedStatement;/*Es una interfaz utilizada para ejecutar consultas SQL precompiladas.*/
import java.sql.ResultSet;/*Representa un conjunto de resultados de una consulta SQL.*/
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/
import java.util.ArrayList;/* Implementa la interfaz List y proporciona una implementación de matriz*/
import java.util.List;/* define operaciones básicas para trabajar con listas.*/
/*----------------------------------------------------------------------------*/ 
/** 
 * <b>CLASE:</b> 			ProductosCrud.java 
 * <b>OBJETIVO:</b> 	proporciona métodos para realizar operaciones(Crear, Leer, Actualizar, Eliminar)
 * relacionadas con la entidad Productos en la base de datos.
 * Utiliza la clase Conexion para establecer la conexión con la base de datos MySQL.	
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador.
 * 
 * @version 1.1 07/10/2023 
 * @author Juan Diaz 
 */ 
public class ProductosCrud {

    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    /** 
     * <b>RegistrarProductos()</b>
     * <b>OBJETIVO:</b> Registra un nuevo producto en la base de datos.
     *
     * @param pro Objeto Productos que contiene la información del nuevo producto.
     * @return `true` si el registro es exitoso, `false` si ocurre algún error.
     */
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO productos (codigo, nombre, descripcion, proveedor, marca, stock, precio) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getProveedor());
            ps.setString(5, pro.getMarca());
            ps.setInt(6, pro.getStock());
            ps.setDouble(7, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }//Fin metodo RegistrarProductos

    /** 
     * <b>ListarProductos()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los productos registrados en la base de datos.
     *
     * @return Una lista de objetos Productos que representan a todos los productos registrados.
     */
    public List ListarProductos(){
       List<Productos> Listapro = new ArrayList();
       String sql = "SELECT * FROM productos";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Productos pro = new Productos();
               pro.setId(rs.getInt("id"));
               pro.setCodigo(rs.getString("codigo"));
               pro.setNombre(rs.getString("nombre"));
               pro.setDescripcion(rs.getString("descripcion"));
               pro.setProveedorPro(rs.getString("proveedor"));
               pro.setMarca(rs.getString("marca"));
               pro.setStock(rs.getInt("stock"));
               pro.setPrecio(rs.getDouble("precio"));
               Listapro.add(pro);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Listapro;
   }//Fin metodo ListarProductos

    /** 
     * <b>EliminarProductos()</b>
     * <b>OBJETIVO:</b>Elimina un producto de la base de datos.
     *
     * @param id Identificador del producto a eliminar.
     * @return `true` si la eliminación es exitosa, `false` si ocurre algún error.
     */
    public boolean EliminarProductos(int id){
       String sql = "DELETE FROM productos WHERE id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       } finally {
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
   }//Fin metodo EliminarProductos

    /** 
     * <b>ModificarProductos()</b>
     * <b>OBJETIVO:</b>Modifica la información de un producto en la base de datos.
     *
     * @param pro Objeto Productos que contiene la información actualizada del producto.
     * @return `true` si la modificación es exitosa, `false` si ocurre algún error.
     */
    public boolean ModificarProductos(Productos pro){
       String sql = "UPDATE `productos` SET `codigo` = ?, `nombre` = ? , `descripcion` = ?, `proveedor` = ? , `marca` = ?, `stock` = ? , `precio` = ? WHERE `productos`.`id` = ?";
       try {
            // con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getProveedor());
            ps.setString(5, pro.getMarca());
            ps.setInt(6, pro.getStock());
            ps.setDouble(7, pro.getPrecio());
            ps.setInt(8, pro.getId());
            ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       } finally {
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
    }//Fin metodo ModificarProductos

    /** 
     * <b>BuscarPro()</b>
     * <b>OBJETIVO:</b>Busca un producto por su código en la base de datos.
     *
     * @param cod Código del producto a buscar.
     * @return Un objeto Productos que representa la información del producto encontrado.
     */
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }//Fin metodo BuscarPro

    /** 
     * <b>BuscarId()</b>
     * <b>OBJETIVO:</b>Busca un producto por su identificador en la base de datos.
     *
     * @param id Identificador del producto a buscar.
     * @return Un objeto Productos que representa la información del producto encontrado.
     */
    public Productos BuscarId(int id){
        Productos pro = new Productos();
        String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN productos p ON p.proveedor = pr.id WHERE p.id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setProveedor(rs.getInt("id_proveedor"));
                pro.setProveedorPro(rs.getString("nombre_proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
       return pro;
    }//Fin metodo BuscarId

    /** 
     * <b>BuscarDatos()</b>
     * <b>OBJETIVO:</b> Busca la configuración de la aplicación en la base de datos.
     *
     * @return Un objeto Config que contiene la información de configuración.
     */
    public Config BuscarDatos(){
        Config conf = new Config();
        String sql = "SELECT * FROM config";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id"));
                conf.setNit(rs.getString("nit"));
                conf.setNombre(rs.getString("nombre"));
                conf.setTelefono(rs.getString("telefono"));
                conf.setDireccion(rs.getString("direccion"));
                conf.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conf;
    }//Fin metodo BuscarDatos

    /** 
     * <b>ModificarDatos()</b>
     * <b>OBJETIVO:</b>Modifica la información de configuración de la aplicación en la base de datos.
     *
     * @param conf Objeto Config que contiene la información actualizada de configuración.
     * @return `true` si la modificación es exitosa, `false` si ocurre algún error.
     */
    public boolean ModificarDatos(Config conf){
       String sql = "UPDATE config SET nit=?, nombre=?, telefono=?, direccion=?, mensaje=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, conf.getNit());
           ps.setString(2, conf.getNombre());
           ps.setString(3, conf.getTelefono());
           ps.setString(4, conf.getDireccion());
           ps.setString(5, conf.getMensaje());
           ps.setInt(6, conf.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }//Fin metodo ModificarDatos

    public void BuscarNombreProvedor(int idPro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//Fin clase ProductosCrud.java 