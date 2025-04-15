
package Back;
/*========================================================================== 
  Encabezado de los M�dulos (Bibliotecas) 
 =========================================================================== 
*/ 
import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.DriverManager;
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/

/*----------------------------------------------------------------------------*/ 
/** 
 * <b>CLASE:</b> 			Conexion.java 
 * <b>OBJETIVO:</b> esta clase proporciona un método para establecer la conexión con la base de datos MySQL.
 * Utiliza la clase DriverManager para gestionar la conexión con el controlador de MySQL.
 *
 *							
 * ASIGNATURA o PROYECTO: 	Proyecto integrador. 
 *
 * @version 1.1 24/10/2023 
 * @author Juan Diaz 
 */ 
public class Conexion {

    // Declaración de un objeto Connection para manejar la conexión a la base de datos
    Connection con;

    /**
     * <b>getConnection()</b>
     * <b>OBJETIVO:</b> Establece la conexión con la base de datos MySQL.
     * @return Una instancia de Connection que representa la conexión establecida con la base de datos.
     */
    public Connection getConnection() {
        try {
            // Cadena de conexión a la base de datos MySQL
            String myBD = "jdbc:mysql://localhost:3306/proyecto_integrador?serverTimezone=UTC";

            // Establecer la conexión utilizando el controlador de MySQL
            con = DriverManager.getConnection(myBD, "root", "juan11");

            // Devolver la conexión establecida
            return con;
        }//Fin try 
        catch (SQLException e) {
            // En caso de error, imprimir el mensaje de error
            System.out.println(e.toString());
        }//Fin catch
        
        // En caso de error, devolver null
        return null;
    }
}//Fin clase Conexion