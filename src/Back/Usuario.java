package Back;

/*========================================================================== 
  Encabezado de los Módulos (Bibliotecas) 
 =========================================================================== 
 */ 
import java.io.Serializable;
/** 
 * <b>CLASE:</b>          Usuario.java 
 * <b>OBJETIVO:</b>       Representar un Usuario con su información básica. 
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 02 de mayo del 2025 
 * @author Sebastian Diaz
 */
public class Usuario implements Serializable{
    /*==========================================================================* 
    * Atributos Principales 
    *==========================================================================* 
    */ 

    /** Identificador del usuario. */ 
    private int id;
    
    /** Nombres del usuario. */
    private String nombres;
    
    /** Apellido del usuario. */
    private String apellido;
    
    /** Correo electrónico del usuario. */
    private String correo;
    
    /** Contraseña del usuario. */
    private String pass;
    
    /** Rol del usuario. */
    private String rol;

   /*------------------------------------------------------------------------*/ 
    
   /*========================================================================== 
    * Método(s) Constructor(es) 
    ==========================================================================*/ 

    /** 
     * <b>Usuario()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Usuario. 
     */ 

    public Usuario() {
    } // Fin Método Constructor 

    /** 
     * <b>Usuario(int id, String nombres, String apellido, String correo, String pass, String rol)</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Usuario con valores específicos. 
     *                    Asigna valores a los atributos id, nombres, apellido, correo, pass y rol. 
     * @param id
     * @param nombres
     * @param apellido
     * @param correo
     * @param pass
     * @param rol
     */ 
    public Usuario(int id, String nombres, String apellido, String correo, String pass, String rol) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
        this.rol = rol;
    }

 	/** 
 	 * <b>getId()</b>
 	 * Retorna el valor del atributo id. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo id. 
  	 */ 
     
 	public int getId() { 
     	return id; 
 	}//Fin getId 

	
 	/** 
 	 * <b>setId(int id)</b>
  	 * Asigna el valor del parámetro dado al atributo id. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id == id 
  	 * @param id - Nuevo valor del atributo id. 
  	 */ 

 	public void setId(int id) { 
    	this.id = id; 
 	} // Fin setId

 	/** 
 	 * <b>getNombres()</b>
 	 * Retorna el valor del atributo nombres. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo nombres. 
  	 */ 
     
 	public String getNombres() { 
     	return nombres; 
 	}//Fin getNombres 

 	/** 
 	 * <b>setNombres(String nombres)</b>
  	 * Asigna el valor del parámetro dado al atributo nombres. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.nombres == nombres 
  	 * @param nombres - Nuevo valor del atributo nombres. 
  	 */ 

 	public void setNombres(String nombres) { 
    	this.nombres = nombres; 
 	} // Fin setNombres

    /** 
     * <b>getApellidos()</b>
     * Retorna el valor del atributo apellido. 
     * El valor es retornado como un objeto String. 
     * Precondición: TRUE 
     * @return El valor del atributo apellido. 
     */ 
    
    public String getApellidos() { 
        return apellido; 
    }//Fin getApellidos 

    /** 
     * <b>setApellidos(String apellido)</b>
     * Asigna el valor del parámetro dado al atributo apellido. 
     * Precondición: TRUE 
     * Postcondicion: this.apellido == apellido 
     * @param apellido - Nuevo valor del atributo apellido. 
     */ 

    public void setApellidos(String apellido) { 
        this.apellido = apellido; 
    } // Fin setApellidos

 	/** 
 	 * <b>getCorreo()</b>
 	 * Retorna el valor del atributo correo. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo correo. 
  	 */ 
     
 	public String getCorreo() { 
     	return correo; 
 	}//Fin getCorreo 

 	/** 
 	 * <b>setCorreo(String correo)</b>
  	 * Asigna el valor del parámetro dado al atributo correo. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.correo == correo 
  	 * @param correo - Nuevo valor del atributo correo. 
  	 */ 

 	public void setCorreo(String correo) { 
    	this.correo = correo; 
 	} // Fin setCorreo

 	/** 
 	 * <b>getPass()</b>
 	 * Retorna el valor del atributo pass. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo pass. 
  	 */ 
     
 	public String getPass() { 
     	return pass; 
 	}//Fin getPass 

 	/** 
 	 * <b>setPass(String pass)</b>
  	 * Asigna el valor del parámetro dado al atributo pass. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.pass == pass 
  	 * @param pass - Nuevo valor del atributo pass. 
  	 */ 

 	public void setPass(String pass) { 
    	this.pass = pass; 
 	} // Fin setPass

 	/** 
 	 * <b>getRol()</b>
 	 * Retorna el valor del atributo rol. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo rol. 
  	 */ 
     
 	public String getRol() { 
     	return rol; 
 	}//Fin getRol 

 	/** 
 	 * <b>setRol(String rol)</b>
  	 * Asigna el valor del parámetro dado al atributo rol. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.rol == rol 
  	 * @param rol - Nuevo valor del atributo rol. 
  	 */ 

 	public void setRol(String rol) { 
    	this.rol = rol; 
 	} // Fin setRol

}//Fin de la Clase
