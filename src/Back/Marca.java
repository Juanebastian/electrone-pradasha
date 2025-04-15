package Back;
/**
 * <b>CLASE:</b>          Marca.java
 * <b>OBJETIVO:</b>       Representar una marca con información básica.
 * ASIGNATURA o PROYECTO: Proyecto integrador.
 *
 * @version 1.2 24/10/2023 
 * @author Juan Diaz 
 */

public class Marca {
   /*==========================================================================* 
    * Atributos Principales 
    *==========================================================================* 
    */ 

    /** Identificador de la marca. */ 
    private int id; // Este es el atributo id de tipo int.
    
    /** Nombre de la marca. */
    private String nombreMarca; // Este es el atributo nombreMarca de tipo String.
    
    /** Código de la marca. */
    private int codigo; // Este es el atributo codigo de tipo int.

   /*------------------------------------------------------------------------*/ 
    
   /*========================================================================== 
    * Método(s) Constructor(es) 
    ===========================================================================*/
    /** 
     * <b>Marca()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Marca. 
     */ 

    public Marca() { 
    } // Fin Método Constructor 

    /** 
     * <b>Marca(int id, int codigo, String nombreMarca)</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Marca con valores específicos. 
     *                    Asigna valores a los atributos id, codigo y nombreMarca. 
     * @param id
     * @param codigo
     * @param nombreMarca
     */ 
    public Marca(int id, int codigo, String nombreMarca) { 
        this.id = id; 
        this.codigo = codigo; 
        this.nombreMarca = nombreMarca; 
    }
    
 	/** 
 	 * <b>getId()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo id. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo id. 
  	 */ 
     
 	public int getId() { 
     	return id; 
 	}//Fin getId 

	
 	/** 
 	 * <b>setId()</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo id. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id == id 
  	 * @param id - Nuevo valor del atributo id. 
  	 */ 

 	public void setId(int id) { 
    	this.id = id; 
 	} // Fin setId

 	/** 
 	 * <b>getNombreMarca()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo nombreMarca. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo nombreMarca. 
  	 */ 
     
 	public String getNombreMarca() { 
     	return nombreMarca; 
 	}//Fin getNombreMarca 

 	/** 
 	 * <b>setNombreMarca()</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo nombreMarca. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.nombreMarca == nombreMarca 
  	 * @param nombreMarca - Nuevo valor del atributo nombreMarca. 
  	 */ 

 	public void setNombreMarca(String nombreMarca) { 
    	this.nombreMarca = nombreMarca; 
 	} // Fin setNombreMarca

 	/** 
 	 * <b>getCodigo()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo codigo. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo codigo. 
  	 */ 
     
 	public int getCodigo() { 
     	return codigo; 
 	}//Fin getCodigo 

 	/** 
 	 * <b>setCodigo()</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo codigo. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.codigo == codigo 
  	 * @param codigo - Nuevo valor del atributo codigo. 
  	 */ 

 	public void setCodigo(int codigo) { 
    	this.codigo = codigo; 
 	} // Fin setCodigo

}//Fin de la Clase
