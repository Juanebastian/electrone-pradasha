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
import javax.swing.JOptionPane;/*se utiliza para mostrar cuadros de diálogo*/


/** 
 * <b>CLASE:</b> 		ClienteCrud.java 
 * <b>OBJETIVO:</b> 	proporciona métodos para realizar operaciones (registrar, listar, Actualizar, Eliminar)
 * relacionadas con la entidad Cliente en la base de datos.
 * Utiliza la clase Conexion para establecer la conexión con la base de datos MySQL.	
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador.
 *
 * @version 1.2 24/10/2023 
 * @author Juan Diaz 
 */ 
public class ClienteCrud {
    // se crea una nueva instancia de la clase Conexion y se está asignando a la variable "cn". Conexion es una clase que maneja la conexión a la base de datos.
    Conexion cn = new Conexion();
    //Se está declarando una variable llamada con del tipo Connection. Esta variable  se utilizará para representar la conexión a la base de datos.
    Connection con;
    //Se está declarando una variable llamada ps del tipo PreparedStatement. Este tipo de objeto se utiliza para ejecutar consultas SQL precompiladas.
    PreparedStatement ps;
    //Se está declarando una variable llamada rs del tipo ResultSet. Esta variable se utilizará para almacenar los resultados de una consulta SQL y navegar a través de ellos.
    ResultSet rs;
     
    /*=========================================================================*
     * Metodos
     *=========================================================================*/
    
    /**
     * <b>RegistrarCliente()</b>
     * <b>OBJETIVO:</b>  Registra un nuevo cliente en la base de datos.
     * @param cl Objeto Cliente que contiene la información del cliente a registrar.
     * @return true si el cliente se registra con éxito, false si ocurre un error.
     */
    public boolean RegistrarCliente(Cliente cl){
        //Se define una cadena sqlque representa una consulta SQL de inserción para agregar un nuevo cliente a la tabla "clientes".
        String sql = "INSERT INTO clientes (tipo_doc ,doc, nombres,apellidos, telefono, direccion) VALUES (?,?,?,?,?,?)";
        try {
            //Se establece una conexión a la base de datos utilizando un objeto llamado cn.
            //La conexión se almacena en un objeto con.
            con = cn.getConnection();
            //Se prepara una declaración SQL utilizando la conexión establecida y la cadena SQL definida anteriormente.
            ps = con.prepareStatement(sql);
            //Se ejecuta la consulta y se obtiene un conjunto de resultados ( ResultSet) llamado rs.
            ps.setString(1,cl.getTipo_Doc());
            ps.setString(2,cl.getDoc());
            ps.setString(3, cl.getNombre());
            ps.setString(4, cl.getApellido());
            ps.setString(5, cl.getTelefono());
            ps.setString(6, cl.getDireccion());
            //Se ejecuta la consulta de inserción.
            ps.execute();
            return true;
        } //Fin try
        catch (SQLException e) {//En caso de que ocurra una excepción de tipo SQLException
            //se muestra un mensaje de diálogo con el mensaje de error 
            JOptionPane.showMessageDialog(null, e.toString());
            //y se devuelve false
            return false;
        }//Fin catch
        finally{
            try {
                con.close();
            } //Fin try
            catch (SQLException e) {
                System.out.println(e.toString());
            }//Fin catch
        }//Fin finally
    }//Fin metodo RegistrarCliente
    
    /**
     *<b>ListarCliente()</b>
     * <b>OBJETIVO:</b> Obtiene una lista de todos los clientes almacenados en la base de datos.
     *
     * @return Lista de objetos Cliente que representan a los clientes almacenados.
     */
   public List ListarCliente(){
       //Se crea una nueva lista de llamadas ListaCl que almacenará objetos de tipo Cliente.
       //Se utiliza la implementación específica ArrayListde la interfaz List.
       List<Cliente> ListaCl = new ArrayList();
       //Se define una cadena sql que representa una consulta SQL para seleccionar todos los registros de la tabla "clientes".
       String sql = "SELECT * FROM clientes";
       try {
           //Se establece una conexión a la base de datos utilizando un objeto llamado cn.
           //La conexión se almacena en un objeto con.
           con = cn.getConnection();
           //Se prepara una declaración SQL utilizando la conexión establecida y la cadena SQL definida anteriormente.
           ps = con.prepareStatement(sql);
           //Se ejecuta la consulta y se obtiene un conjunto de resultados ( ResultSet) llamado rs.
           rs = ps.executeQuery();
           while (rs.next()) {  
               //Se crea un nuevo objeto Cliente para almacenar la información de un cliente.
               Cliente cl = new Cliente();
               cl.setId(rs.getInt("id"));
               cl.setTipo_Doc(rs.getString("tipo_doc"));
               cl.setDoc(rs.getString("doc"));
               cl.setNombre(rs.getString("nombres"));
               cl.setApellido(rs.getString("apellidos"));
               cl.setTelefono(rs.getString("telefono"));
               cl.setDireccion(rs.getString("direccion"));
               //Se agrega el objeto Clienterecién creado a la lista ListaCl.
               ListaCl.add(cl);
           }
       }//Fin try 
       catch (SQLException e) {
           System.out.println(e.toString());
       }//Fin catch
       
       //Se retorna la lista completa de objetos Clienteque se extrajeron de la base de datos.
       return ListaCl;
   }//Fin metodo ListarCliente
   
    /**
     *<b>EliminarCliente()</b>
     * <b>OBJETIVO:</b>  Elimina un cliente de la base de datos por su ID.
     *
     * @param id El ID del cliente a eliminar.
     * @return true si la eliminación es exitosa, false si ocurre un error.
     */
    public boolean EliminarCliente(int id){
       //Se define una cadena sql que representa una consulta SQL de eliminación para eliminar un cliente de la tabla "clientes" según su id. 
       String sql = "DELETE FROM clientes WHERE id = ?";
       try {
           //Se prepara una declaración SQL utilizando la conexión establecida y la cadena SQL definida anteriormente.
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           //Se ejecuta la consulta de eliminación.
           ps.execute();
           return true;
       }//Fin try
       catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }//Fin catch
       finally{
           try {
               con.close();
           }//Fin try
           catch (SQLException ex) {
               System.out.println(ex.toString());
           }//Fin catch
       }
   }//Fin metodo EliminarCliente
    
    /**
     * <b>ModificarCliente()</b>
     * <b>OBJETIVO:</b>     Modifica la información de un cliente en la base de datos.
     *
     * @param cl Objeto Cliente que contiene la nueva información del cliente.
     * @return true si la modificación es exitosa, false si ocurre un error.
     */
    public boolean ModificarCliente(Cliente cl){
       //Se define una cadena sqlque representa una consulta SQL de actualización para modificar los datos de un cliente en la tabla "clientes" según su id.
       String sql = "UPDATE clientes SET tipo_doc=?, doc=?, nombres=?,apellidos=?, telefono=?, direccion=? WHERE id=?";
       try {
           //Se prepara una declaración SQL utilizando la conexión establecida y la cadena SQL definida anteriormente.
           ps = con.prepareStatement(sql);   
           ps.setString(1, cl.getTipo_Doc());
           ps.setString(2, cl.getDoc());
           ps.setString(3, cl.getNombre());
           ps.setString(4, cl.getApellido());
           ps.setString(5, cl.getTelefono());
           ps.setString(6, cl.getDireccion());
           ps.setInt(7, cl.getId());
           //Se ejecuta la consulta de modificacion.
           ps.execute();
           return true;
       }//Fin try 
       catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }//Fin catch
       finally{
           try {
               con.close();
           } //Fin try
           catch (SQLException e) {
               System.out.println(e.toString());
           }//Fin catch
       }
   }//Fin metodo ModificarCliente
    
    /**
     *<b>Buscarcliente()</b>
     * <b>OBJETIVO:</b> Busca un cliente en la base de datos por su número de documento.
     *
     * @param doc El número de documento del cliente a buscar.
     * @return Objeto Cliente que representa al cliente encontrado, o un objeto Cliente vacío si no se encuentra.
     */
    public Cliente Buscarcliente(int doc){
       //Se creará un nuevo objeto Clienteque se utilizará para almacenar la información del cliente encontrado.
       Cliente cl = new Cliente();
       //Se define una cadena sqlque representa una consulta SQL para seleccionar un cliente de la tabla "clientes" según su número de documento (doc).
       String sql = "SELECT * FROM clientes WHERE doc = ?";
       try {
           //Se establece una conexión a la base de datos utilizando un objeto llamado cn.
           //La conexión se almacena en un objeto con.
           con = cn.getConnection();
           //Se prepara una declaración SQL utilizando la conexión establecida y la cadena SQL definida anteriormente.
           ps = con.prepareStatement(sql);
           //Se establece el valor del parámetro en la consulta preparada utilizando el valor de doc proporcionado como parámetro.
           ps.setInt(1, doc);
           //Se ejecuta la consulta y se obtiene un conjunto de resultados ( ResultSet) llamado rs.
           rs = ps.executeQuery();
           if (rs.next()) {
               cl.setId(rs.getInt("id"));
               cl.setNombre(rs.getString("nombres"));
               cl.setApellido(rs.getString("apellidos"));
               cl.setTelefono(rs.getString("telefono"));
               cl.setDireccion(rs.getString("direccion"));
           }
       }//Fin try 
       catch (SQLException e) {
           System.out.println(e.toString());
       }//Fin catch
       return cl;
   }//Fin metodo Buscarcliente
   
}//Fin clase ClienteCrud
