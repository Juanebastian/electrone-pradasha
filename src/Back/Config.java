package Back;
 /*
 * <b>CLASE:</b>          Config.java 
 * <b>OBJETIVO:</b>       Representar los datos básicos de la empresa ElePra. 
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 23 de abril de 2025 
 * @author Sebastian Diaz
 */
public class Config {
    

   /*==========================================================================* 
    * Atributos Principales 
    *==========================================================================* 
    */ 

    /** Identificador de la configuración. */ 
    private int id; // Este es el atributo id de tipo int.
    
    /** NIT de la empresa ElePra. */
    private String nit; // Este es el atributo nit de tipo String.
    
    /** Nombre de la empresa ElePra. */
    private String nombre; // Este es el atributo nombre de tipo String.
    
    /** Número de teléfono de la empresa ElePra. */
    private String telefono; // Este es el atributo telefono de tipo String.
    
    /** Dirección de la empresa ElePra. */
    private String direccion; // Este es el atributo direccion de tipo String.
    
    /** Mensaje de configuración para la empresa ElePra. */
    private String mensaje; // Este es el atributo mensaje de tipo String.
    
   /*========================================================================== 
    * Método(s) Constructor(es) 
    =========================================================================== 
  
    /** 
     * <b>Config()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Config. 
     */ 

    public Config() { 
    } // Fin Método Constructor 

    /** 
     * <b>Config(int id, String nit, String nombre, String telefono, String direccion, String mensaje)</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Config con valores específicos. 
     *                    Asigna valores a los atributos id, nit, nombre, telefono, direccion y mensaje. 
     * @param id
     * @param nit
     * @param nombre
     * @param telefono
     * @param direccion
     * @param mensaje
     */ 
    public Config(int id, String nit, String nombre, String telefono, String direccion, String mensaje) { 
        this.id = id; 
        this.nit = nit; 
        this.nombre = nombre; 
        this.telefono = telefono; 
        this.direccion = direccion; 
        this.mensaje = mensaje; 
    }
    
 	/** 
 	 * <b>getId()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo id. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo id. 
  	 */ 
     
 	public int getId() { 
     	return id; 
 	}//Fin getId 

 	/** 
 	 * <b>setId</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo id. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id == id 
  	 * @param id - Nuevo valor del atributo id. 
  	 */ 

 	public void setId(int id) { 
    	this.id = id; 
 	} // Fin setId

 	/** 
 	 * <b>getNit()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo nit. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo nit. 
  	 */ 
     
 	public String getNit() { 
     	return nit; 
 	}//Fin getNit 

 	/** 
 	 * <b>setNit</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo nit. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.nit == nit 
  	 * @param nit - Nuevo valor del atributo nit. 
  	 */ 

 	public void setNit(String nit) { 
    	this.nit = nit; 
 	} // Fin setNit

 	/** 
 	 * <b>OBJETIVO:</b> <b>getNombre()</b>
 	 * Retorna el valor del atributo nombre. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo nombre. 
  	 */ 
     
 	public String getNombre() { 
     	return nombre; 
 	}//Fin getNombre 

 	/** 
 	 * <b>setNombre</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo nombre. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.nombre == nombre 
  	 * @param nombre - Nuevo valor del atributo nombre. 
  	 */ 

 	public void setNombre(String nombre) { 
    	this.nombre = nombre; 
 	} // Fin setNombre

 	/** 
 	 * <b>getTelefono()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo telefono. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo telefono. 
  	 */ 
     
 	public String getTelefono() { 
     	return telefono; 
 	}//Fin getTelefono 


 	//  Ejemplo Modificador: 
 	/** 
 	 * <b>setTelefono</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo telefono. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.telefono == telefono 
  	 * @param telefono - Nuevo valor del atributo telefono. 
  	 */ 

 	public void setTelefono(String telefono) { 
    	this.telefono = telefono; 
 	} // Fin setTelefono
        
        
 	/** 
 	 * <b>getDireccion()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo direccion. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo direccion. 
  	 */ 
     
 	public String getDireccion() { 
     	return direccion; 
 	}//Fin getDireccion 

 	/** 
 	 * <b>setDireccion</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo direccion. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.direccion == direccion 
  	 * @param direccion - Nuevo valor del atributo direccion. 
  	 */ 

 	public void setDireccion(String direccion) { 
    	this.direccion = direccion; 
 	} // Fin setDireccion

 	/** 
 	 * <b>getMensaje()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo mensaje. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo mensaje. 
  	 */ 
     
 	public String getMensaje() { 
     	return mensaje; 
 	}//Fin getMensaje 

 	/** 
 	 * <b>setMensaje</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo mensaje. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.mensaje == mensaje 
  	 * @param mensaje - Nuevo valor del atributo mensaje. 
  	 */ 

 	public void setMensaje(String mensaje) { 
    	this.mensaje = mensaje; 
 	} // Fin setMensaje

}//Fin de la Clase Config
