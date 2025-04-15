package Back; 
/*========================================================================== 
  Encabezado de los Módulos (Bibliotecas) 
 =========================================================================== 
 */ 
/** 
 * <b>CLASE:</b>          Cliente.java 
 * <b>OBJETIVO:</b>       Representar un cliente con información básica. 
 * ASIGNATURA o PROYECTO: Proyecto integrador.
 *
 * @version 1.0 29/11/2023 
 * @author Juan diaz 
 */

public class Cliente { 

   /*==========================================================================* 
    * Atributos Principales 
    *==========================================================================* 
    */ 

    /** Identificador del cliente. */ 
    private int id; // Este es el atributo id de tipo int.
    
    /** Tipo de documento del cliente. */
    private String tipo_Doc; // Este es el atributo tipo_Doc de tipo String.
    
    /** Número de documento del cliente. */
    private String doc; // Este es el atributo doc de tipo String.
    
    /** Nombres del cliente. */
    private String nombres; // Este es el atributo nombres de tipo String.
    
    /** Apellidos del cliente. */
    private String apellidos; // Este es el atributo apellidos de tipo String.
    
    /** Número de teléfono del cliente. */
    private String telefono; // Este es el atributo telefono de tipo String.
    
    /** Dirección del cliente. */
    private String direccion; // Este es el atributo direccion de tipo String.


    
   /*========================================================================== 
    * Método(s) Constructor(es) 
    ===========================================================================*/ 
 
    /** 
     * <b>Cliente()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Cliente. 
     */ 

    public Cliente() { 
    } // Fin Método Constructor 

    /** 
     * <b>Cliente(int id, String doc, String tipo_Doc, String nombres, String apellidos, String telefono, String direccion)</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Cliente con valores específicos. 
     *                    Asigna valores a los atributos id, doc, tipo_Doc, nombres, apellidos, telefono y direccion. 
     * @param id
     * @param doc
     * @param tipo_Doc
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param direccion
     */ 
    public Cliente(int id, String doc, String tipo_Doc, String nombres, String apellidos, String telefono, String direccion) { 
        this.id = id; 
        this.tipo_Doc = tipo_Doc; 
        this.doc = doc; 
        this.nombres = nombres; 
        this.apellidos = apellidos; 
        this.telefono = telefono; 
        this.direccion = direccion; 
    }// Fin Método Constructor2
    
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
 	 * <b>setId()</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo id. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id == id 
  	 * @param id - Nuevo valor del atributo id. 
  	 */ 

 	public void setId(int id) { 
    	this.id = id; 
 	} // Fin setId

 	/** 
 	 * <b>getTipo_Doc()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo tipo_Doc. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo tipo_Doc. 
  	 */ 
     
 	public String getTipo_Doc() { 
     	return tipo_Doc; 
 	}//Fin getTipo_Doc 

 	/** 
 	 * <b>setTipo_Doc()</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo tipo_Doc. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.tipo_Doc == tipo_Doc 
  	 * @param tipo_Doc - Nuevo valor del atributo tipo_Doc. 
  	 */ 

 	public void setTipo_Doc(String tipo_Doc) { 
    	this.tipo_Doc = tipo_Doc; 
 	} // Fin setTipo_Doc

 	/** 
 	 * <b>getDoc()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo doc. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo doc. 
  	 */ 
     
 	public String getDoc() { 
     	return doc; 
 	}//Fin getDoc 


 	/** 
 	 * <b>setDoc()</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo doc. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.doc == doc 
  	 * @param doc - Nuevo valor del atributo doc. 
  	 */ 

 	public void setDoc(String doc) { 
    	this.doc = doc; 
 	} // Fin setDoc

 	/** 
 	 * <b>getNombre()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo nombres. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo nombres. 
  	 */ 
     
 	public String getNombre() { 
     	return nombres; 
 	}//Fin getNombre 

 	/** 
 	 * <b>setNombre()</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo nombres. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.nombres == nombres 
  	 * @param nombres - Nuevo valor del atributo nombres. 
  	 */ 

 	public void setNombre(String nombres) { 
    	this.nombres = nombres; 
 	} // Fin setNombre

 	/** 
 	 * <b>getApellido()</b>
 	 * <b>OBJETIVO:</b> Retorna el valor del atributo apellidos. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo apellidos. 
  	 */ 
     
 	public String getApellido() { 
     	return apellidos; 
 	}//Fin getApellido 

 	/** 
 	 * <b>setApellido()</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo apellidos. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.apellidos == apellidos 
  	 * @param apellidos - Nuevo valor del atributo apellidos. 
  	 */ 

 	public void setApellido(String apellidos) { 
    	this.apellidos = apellidos; 
 	} // Fin setApellido

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
 	 * <b>setTelefono()</b>
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
 	 * <b>setDireccion()</b>
  	 * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo direccion. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.direccion == direccion 
  	 * @param direccion - Nuevo valor del atributo direccion. 
  	 */ 

 	public void setDireccion(String direccion) { 
    	this.direccion = direccion; 
 	} // Fin setDireccion

}//Fin de la Clase
