package Back;

import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.PreparedStatement;/*Es una interfaz utilizada para ejecutar consultas SQL precompiladas.*/
import java.sql.ResultSet;/*Representa un conjunto de resultados de una consulta SQL.*/
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/
import java.util.ArrayList;/* Implementa la interfaz List y proporciona una implementación de matriz*/
import java.util.List;/* define operaciones básicas para trabajar con listas.*/

/** 
 * <b>CLASE:</b> 		MesaCrud.java 
 * <b>OBJETIVO:</b> proporciona métodos para realizar operaciones (registrar, listar, Actualizar, Eliminar)
 * relacionadas con la entidad mesa de ayuda en la base de datos.
 * Utiliza la clase Conexion para establecer la conexión con la base de datos MySQL.
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador.
 *
 * @version 1.2 24/10/2023 
 * @author Juan Diaz 
 */
public class MesaCrud {
    
    // se crea una nueva instancia de la clase Conexion y se está asignando a la variable "cn". Conexion es una clase que maneja la conexión a la base de datos.
    Conexion cn = new Conexion();
    //Se está declarando una variable llamada con del tipo Connection. Esta variable  se utilizará para representar la conexión a la base de datos.
    Connection con;
    //Se está declarando una variable llamada ps del tipo PreparedStatement. Este tipo de objeto se utiliza para ejecutar consultas SQL precompiladas.
    PreparedStatement ps;
    //Se está declarando una variable llamada rs del tipo ResultSet. Esta variable se utilizará para almacenar los resultados de una consulta SQL y navegar a través de ellos.
    ResultSet rs;
    
    /** 
     * <b>ListarMesa()</b>
     * <b>OBJETIVO:</b>Obtiene la lista de todos las mesa de ayuda registradas en la base de datos.
     *
     * @return Una lista de objetos Usuario que representan a todos los usuarios registrados.
     */
    public List ListarMesa(){
        List<Mesa> Listarms = new ArrayList();
        String sql = "SELECT * FROM mesa ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Mesa ms = new Mesa();
                ms.setId(rs.getInt("id_mesa"));
                ms.setIdCliente(rs.getInt("id_cliente"));
                ms.setProblema(rs.getString("problema"));
                ms.setDescripcion(rs.getString("descripcion"));
                ms.setEstado(rs.getInt("estado")); 
                ms.setRespuesta(rs.getString("respuesta"));
                
                Listarms.add(ms);         
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listarms;
    }//Fin metodo ListarMesa
    
     /**
     * <b>ModificarMesa()</b>
     * <b>OBJETIVO:</b>  Modificar un  cliente en la base de datos.
     * @param ms Objeto Mesa que contiene la información del id_mesa.
     * @return true si el cliente se registra con éxito, false si ocurre un error.
     */
    public boolean ModificarMesa(Mesa ms){
       String sql = "UPDATE `mesa` SET `respuesta` = ?,`estado` = ?  WHERE  `id_mesa` = ?";
       try {
            // con = cn.getConnection();
            ps = con.prepareStatement(sql);
        
            ps.setString(1, ms.getRespuesta());
            ps.setInt(2, ms.getEstado());
            ps.setInt(3, ms.getId());
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
    }//Fin metodo ModificarMesa
    
}//Fin de la Clase
