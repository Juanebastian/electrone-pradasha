
package Back;

import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.PreparedStatement;/*Es una interfaz utilizada para ejecutar consultas SQL precompiladas.*/
import java.sql.ResultSet;/*Representa un conjunto de resultados de una consulta SQL.*/
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/
import java.util.ArrayList;/* Implementa la interfaz List y proporciona una implementación de matriz*/
import java.util.List;/* define operaciones básicas para trabajar con listas.*/

/**
 * <b>CLASE:</b>          MarcaCrud.java
 * <b>OBJETIVO:</b>       proporciona métodos para realizar operaciones (registrar, listar, Actualizar, Eliminar)
 * relacionadas con la entidad Marca en la base de datos.
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 02 de mayo del 2025 
 * @author Sebastian Diaz
 */

public class MarcaCrud {
    
     // se crea una nueva instancia de la clase Conexion y se está asignando a la variable "cn". Conexion es una clase que maneja la conexión a la base de datos.
    Conexion cn = new Conexion();
    //Se está declarando una variable llamada con del tipo Connection. Esta variable  se utilizará para representar la conexión a la base de datos.
    Connection con;
    //Se está declarando una variable llamada ps del tipo PreparedStatement. Este tipo de objeto se utiliza para ejecutar consultas SQL precompiladas.
    PreparedStatement ps;
    //Se está declarando una variable llamada rs del tipo ResultSet. Esta variable se utilizará para almacenar los resultados de una consulta SQL y navegar a través de ellos.
    ResultSet rs;
    
    
    /** 
     * <b>RegistrarMarca()</b>
     * <b>OBJETIVO:</b>Registra una nueva marca en la base de datos.
     *
     * @param mr Objeto Marca que contiene la información del nueva marca.
     * @return `true` si el registro es exitoso, `false` si ocurre algún error.
     */
    public boolean RegistrarMarca(Marca mr){
        String sql = "INSERT INTO marca ( codigo ,nombre) VALUES (?,?)";
        try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
     
           ps.setInt(1, mr.getCodigo());
           ps.setString(2, mr.getNombreMarca());
        
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
    }//Fin metodo RegistrarMarca
    
    /** 
     * <b>ListarMarca()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos las marcas registradas en la base de datos.
     *
     * @return Una lista de objetos Usuario que representan a todos los usuarios registrados.
     */
    public List ListarMarca(){
        List<Marca> Listarmr = new ArrayList();
        String sql = "SELECT * FROM marca";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Marca mr = new Marca();
                mr.setId(rs.getInt("id"));
                mr.setCodigo(rs.getInt("codigo")); 
                mr.setNombreMarca(rs.getString("nombre"));
                Listarmr.add(mr);         
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listarmr;
    }//Fin metodo ListarMarca
    
    /**
     * <b>EliminarMarca()</b>
     * <b>OBJETIVO:</b>  Eliminar una  marca en la base de datos.
     * @param id Objeto Marca que contiene la información del id.
     * @return true si el cliente se registra con éxito, false si ocurre un error.
     */
    public boolean EliminarMarca(int id){
       String sql = "DELETE FROM marca WHERE id = ?";
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
   }//Fin metodo EliminarMarca
    
    /**
     * <b>ModificarMarca()</b>
     * <b>OBJETIVO:</b>  Modificar una  marca en la base de datos.
     * @param mr Objeto Marca que contiene la información del id.
     * @return true si el marca se registra con éxito, false si ocurre un error.
     */
    public boolean ModificarMarca(Marca mr){
       String sql = "UPDATE `marca` SET `codigo` = ?, `nombre` = ?  WHERE `marca`.`id` = ?";
       try {
            // con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mr.getCodigo());
            ps.setString(2, mr.getNombreMarca());
            ps.setInt(3, mr.getId());
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
    }//Fin metodo ModificarMarca
    
    
    /** 
     * <b>ListarNombreMarca()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos las nombres de marcas registradas en la base de datos.
     *
     * @return Una lista de objetos Usuario que representan a todos los usuarios registrados.
     */
    public List<String> ListarNombreMarca() {
    List<String> listarmr = new ArrayList<>();
    String sql = "SELECT nombre FROM marca";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {                
            String nombreMarca = rs.getString("nombre");
            listarmr.add(nombreMarca);         
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    return listarmr;
    }//Fin metodo ModificarUser
    /**
     * <b>BuscarNombreMarca()</b>
     * <b>OBJETIVO:</b>  Buscar un nombre en la base de datos.
     * @param id Objeto Marca que contiene la información del id.
     * @return true si el marca se encuentra con éxito, false si ocurre un error.
     */
    public Marca BuscarNombreMarca(int id){
        Marca mr = new Marca();
        String sql = "SELECT nombre FROM marca WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                mr.setNombreMarca(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return mr;
    }//Fin metodo ModificarUser
    /**
     * <b>BuscarIdMarca()</b>
     * <b>OBJETIVO:</b>  Buscar un nombre en la base de datos.
     * @param nombre Objeto Marca que contiene la información del nombre.
     * @return true si el id marca se encuentra con éxito, false si ocurre un error.
     */
    public Marca BuscarIdMarca(String nombre){
        Marca mr = new Marca();
        String sql = "SELECT id FROM marca WHERE nombre = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                mr.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return mr;
    }//Fin metodo ModificarUser
    
}//Fin clase MarcaCrud
