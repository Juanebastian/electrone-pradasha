package Back;
/*========================================================================== 
  Encabezado de los Modulos (Bibliotecas) 
 =========================================================================== 
*/ 
import java.sql.Connection;/*Proporciona interfaces para la conexión con bases de datos*/
import java.sql.DriverManager;
import java.sql.SQLException;/*Es una excepción que indica errores relacionados con operaciones de bases de datos*/

/*----------------------------------------------------------------------------*/ 
/** 
 * <b>CLASE:</b>          Conexion.java 
 * <b>OBJETIVO:</b>       Representar la conexion ala base de datos. 
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 23 de abril de 2025 
 * @author Sebastian Diaz
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