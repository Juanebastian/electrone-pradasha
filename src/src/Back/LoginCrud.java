package Back;
/*========================================================================== 
  Encabezado de los M�dulos (Bibliotecas) 
 =========================================================================== 
*/ 
import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.PreparedStatement;/*Es una interfaz utilizada para ejecutar consultas SQL precompiladas.*/
import java.sql.ResultSet;/*Representa un conjunto de resultados de una consulta SQL.*/
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/
import java.util.ArrayList;/* Implementa la interfaz List y proporciona una implementación de matriz*/
import java.util.List;/* define operaciones básicas para trabajar con listas.*/
/*----------------------------------------------------------------------------*/ 
/** 
 * <b>CLASE:</b> 		LoginCrud.java 
 * <b>OBJETIVO:</b> proporciona métodos para realizar operaciones (registrar, listar, Actualizar, Eliminar)
 * relacionadas con la entidad Usuario en la base de datos.
 * Utiliza la clase Conexion para establecer la conexión con la base de datos MySQL.
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador.
 *
 * @version 1.2 24/10/2023 
 * @author Juan Diaz 
 */ 
public class LoginCrud {

    // se crea una nueva instancia de la clase Conexion y se está asignando a la variable "cn". Conexion es una clase que maneja la conexión a la base de datos.
    Conexion cn = new Conexion();
    //Se está declarando una variable llamada con del tipo Connection. Esta variable  se utilizará para representar la conexión a la base de datos.
    Connection con;
    //Se está declarando una variable llamada ps del tipo PreparedStatement. Este tipo de objeto se utiliza para ejecutar consultas SQL precompiladas.
    PreparedStatement ps;
    //Se está declarando una variable llamada rs del tipo ResultSet. Esta variable se utilizará para almacenar los resultados de una consulta SQL y navegar a través de ellos.
    ResultSet rs;
    
    /** 
     * <b>Usuario log()</b>
     * <b>OBJETIVO:</b>Realiza el inicio de sesión verificando las credenciales del usuario en la base de datos.
     *
     * @param correo Correo electrónico del usuario.
     * @param pass Contraseña del usuario.
     * @return Un objeto Usuario que representa la información del usuario si las credenciales son válidas;
     *         de lo contrario, se devuelve un objeto Usuario con valores predeterminados.
     */
    public Usuario log(String correo, String pass){
        Usuario l = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombres(rs.getString("nombres"));
                l.setApellidos(rs.getString("apellidos"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }//Fin catch
        return l;
    }//Fin metodo Usuario log

    /** 
     * <b>Registrar()</b>
     * <b>OBJETIVO:</b>Registra un nuevo usuario en la base de datos.
     *
     * @param reg Objeto Usuario que contiene la información del nuevo usuario.
     * @return `true` si el registro es exitoso, `false` si ocurre algún error.
     */
    public boolean Registrar(Usuario reg){
        String sql = "INSERT INTO usuarios (nombres, apellidos, correo, pass, rol) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombres());
            ps.setString(2, reg.getApellidos());
            ps.setString(3, reg.getCorreo());
            ps.setString(4, reg.getPass());
            ps.setString(5, reg.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }//Fin catch
    }//Fin metodo Registrar

    /** 
     * <b>ListarUsuarios()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos los usuarios registrados en la base de datos.
     *
     * @return Una lista de objetos Usuario que representan a todos los usuarios registrados.
     */
    public List ListarUsuarios(){
       List<Usuario> Lista = new ArrayList();
       String sql = "SELECT * FROM usuarios";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Usuario lg = new Usuario();
               lg.setId(rs.getInt("id"));
               lg.setNombres(rs.getString("nombres"));
               lg.setApellidos(rs.getString("apellidos"));
               lg.setCorreo(rs.getString("correo"));
               lg.setPass(rs.getString("pass"));
               lg.setRol(rs.getString("rol"));
               Lista.add(lg);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }//Fin catch
       return Lista;
   }//Fin metodo ListarUsuarios
    
    
    /**
     * <b>EliminarUser()</b>
     * <b>OBJETIVO:</b>  Eliminar un  cliente en la base de datos.
     * @param id Objeto Cliente que contiene la información del id.
     * @return true si el cliente se registra con éxito, false si ocurre un error.
     */
    public boolean EliminarUser(int id){
       String sql = "DELETE FROM usuarios WHERE id = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }//Fin catch
       finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }//Fin catch
       }
   }//Fin metodo EliminarUser
    
    /**
     * <b>ModificarUser()</b>
     * <b>OBJETIVO:</b>  Modificar un  cliente en la base de datos.
     * @param lg Objeto Cliente que contiene la información del id.
     * @return true si el cliente se registra con éxito, false si ocurre un error.
     */
    public boolean ModificarUser(Usuario lg){
       String sql = "UPDATE usuarios SET  nombres=?,apellidos=?, correo=?, pass=? ,rol=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, lg.getNombres());
           ps.setString(2, lg.getApellidos());
           ps.setString(3, lg.getCorreo());
           ps.setString(4, lg.getPass());
           ps.setString(5, lg.getRol());
           ps.setInt(6, lg.getId());
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
           }//Fin catch
       }
   }//Fin metodo ModificarUser
    
}//Fin clase LoginCrud