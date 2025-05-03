
package Back;

import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.PreparedStatement;/*Es una interfaz utilizada para ejecutar consultas SQL precompiladas.*/
import java.sql.ResultSet;/*Representa un conjunto de resultados de una consulta SQL.*/
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/
import java.util.ArrayList;/* Implementa la interfaz List y proporciona una implementación de matriz*/
import java.util.List;/* define operaciones básicas para trabajar con listas.*/
/** 
 * <b>CLASE:</b> ProveedorCrud.java 
 * <b>OBJETIVO:</b> proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * relacionadas con la entidad Proveedor en la base de datos.
 * Utiliza la clase Conexion para establecer la conexión con la base de datos MySQL.
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador.
 *
 * 
 * @version 1.1 30/11/2023 
 * @author Juan Diaz 
 */ 
public class ProveedorCrud {

    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    /** 
     * <b>RegistrarProveedor()</b>
     * <b>OBJETIVO:</b>Registra un nuevo proveedor en la base de datos.
     *
     * @param pr Objeto Proveedor que contiene la información del nuevo proveedor.
     * @return `true` si el registro es exitoso, `false` si ocurre algún error.
     */
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "INSERT INTO proveedor(nit, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, pr.getNit());
           ps.setString(2, pr.getNombre());
           ps.setString(3, pr.getTelefono());
           ps.setString(4, pr.getDireccion());
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
    }//Fin metodo RegistrarProveedor

    /** 
     * <b>ListarProveedor()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los proveedores registrados en la base de datos.
     *
     * @return Una lista de objetos Proveedor que representan a todos los proveedores registrados.
     */
    public List ListarProveedor(){
        List<Proveedor> Listapr = new ArrayList();
        String sql = "SELECT * FROM proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt("id"));
                pr.setNit(rs.getString("nit"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                Listapr.add(pr);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listapr;
    }//Fin metodo ListarProveedor

    /** 
     * <b>EliminarProveedor()</b>
     * <b>OBJETIVO:</b>Elimina un proveedor de la base de datos.
     *
     * @param id Identificador del proveedor a eliminar.
     * @return `true` si la eliminación es exitosa, `false` si ocurre algún error.
     */
    public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedor WHERE id = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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
    }//Fin metodo EliminarProveedor

    /** 
     * <b>ModificarProveedor()</b>
     * <b>OBJETIVO:</b> Modifica la información de un proveedor en la base de datos.
     *
     * @param pr Objeto Proveedor que contiene la información actualizada del proveedor.
     * @return `true` si la modificación es exitosa, `false` si ocurre algún error.
     */
    public boolean ModificarProveedor(Proveedor pr){
        String sql = "UPDATE proveedor SET nit=?, nombre=?, telefono=?, direccion=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNit());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setInt(5, pr.getId());
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
    }//Fin metodo ModificarProveedor
    
     /** 
     * <b>ListarNombreProvedor()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los proveedores registrados en la base de datos.
     *
     * @return Una lista de objetos Proveedor que representan a todos los proveedores registrados.
     */
     public List<String> ListarNombreProvedor() {
    List<String> Listapr = new ArrayList<>();
    String sql = "SELECT nombre FROM proveedor";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {                
            String nombreProvedor = rs.getString("nombre");
            Listapr.add(nombreProvedor);         
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return Listapr;
    }//Fin metodo ListarNombreProvedor
    /** 
     * <b>ListarNombreProvedor()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los proveedores registrados en la base de datos.
     * @param id
     * @return Una lista de objetos Proveedor que representan a todos los proveedores registrados.
     */
    public Proveedor BuscarNombreProvedor(int id){
        Proveedor pr = new Proveedor();
        String sql = "SELECT nombre FROM proveedor WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pr;
    }//Fin metodo BuscarNombreProvedor
    
    /** 
     * <b>BuscarIdProvedor()</b>
     * <b>OBJETIVO:</b>Busca el id de los provedores registrados en la base de datos.
     * @param nombre
     * 
     * @return Una lista de objetos Proveedor que representan a todos los id de proveedores registrados.
     */
    public Proveedor BuscarIdProvedor(String nombre){
        Proveedor pr = new Proveedor();
        String sql = "SELECT id FROM proveedor WHERE nombre = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pr;
    }//Fin metodo BuscarIdProvedor
    
    
}//Fin clase ProveedorCrud.java 