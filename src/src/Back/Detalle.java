
package Back;
/** 
 * <b>CLASE:</b>          Detalle.java 
 * <b>OBJETIVO:</b>       Representar los detalles de venta y actualizar el stock. 
 * ASIGNATURA o PROYECTO: Proyecto integrador.
 *
 * @version 1.0 17/11/2023 
 * @author Juan Diaz 
 */

public class Detalle {
    
    /*==========================================================================* 
    * Atributos Principales 
    *==========================================================================*/ 
    

    /** Identificador del detalle. */ 
    private int id; // Este es el atributo id de tipo int.
    
    /** Identificador del producto asociado al detalle. */
    private int id_pro; // Este es el atributo id_pro de tipo int.
    
    /** Cantidad de productos en el detalle. */
    private int cantidad; // Este es el atributo cantidad de tipo int.
    
    /** Precio unitario del producto en el detalle. */
    private double precio; // Este es el atributo precio de tipo double.
    
    /** Identificador de la venta asociada al detalle. */
    private int id_venta; // Este es el atributo id_venta de tipo int.
 
    
   /*========================================================================== 
    * Método(s) Constructor(es) 
    ===========================================================================*/ 


    public Detalle() { 
    } // Fin Método Constructor 

    /** 
     * <b>Detalle(int id, int id_pro, int cantidad, double precio, int id_venta)</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Detalle con valores específicos. 
     *                    Asigna valores a los atributos id, id_pro, cantidad, precio y id_venta. 
     * @param id
     * @param id_pro
     * @param cantidad
     * @param precio
     * @param id_venta
     */ 
    public Detalle(int id, int id_pro, int cantidad, double precio, int id_venta) { 
        this.id = id; 
        this.id_pro = id_pro; 
        this.cantidad = cantidad; 
        this.precio = precio; 
        this.id_venta = id_venta; 
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
 	 * <b>setId(int id)</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo id. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id == id 
  	 * @param id - Nuevo valor del atributo id. 
  	 */ 

 	public void setId(int id) { 
    	this.id = id; 
 	} // Fin setId

 	/** 
 	 * <b>getId_pro()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo id_pro. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo id_pro. 
  	 */ 
     
 	public int getId_pro() { 
     	return id_pro; 
 	}//Fin getId_pro 

 	/** 
 	 * <b>setId_pro(int id_pro)</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo id_pro. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id_pro == id_pro 
  	 * @param id_pro - Nuevo valor del atributo id_pro. 
  	 */ 

 	public void setId_pro(int id_pro) { 
    	this.id_pro = id_pro; 
 	} // Fin setId_pro

 	/** 
 	 * <b>getCantidad()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo cantidad. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo cantidad. 
  	 */ 
     
 	public int getCantidad() { 
     	return cantidad; 
 	}//Fin getCantidad 

 	/** 
 	 * <b>setCantidad(int cantidad)</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo cantidad. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.cantidad == cantidad 
  	 * @param cantidad - Nuevo valor del atributo cantidad. 
  	 */ 

 	public void setCantidad(int cantidad) { 
    	this.cantidad = cantidad; 
 	} // Fin setCantidad

 	/** 
 	 * <b>getPrecio()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo precio. 
 	 * El valor es retornado como un double. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo precio. 
  	 */ 
     
 	public double getPrecio() { 
     	return precio; 
 	}//Fin getPrecio 

 	/** 
 	 * <b>setPrecio(double precio)</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo precio. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.precio == precio 
  	 * @param precio - Nuevo valor del atributo precio. 
  	 */ 

 	public void setPrecio(double precio) { 
    	this.precio = precio; 
 	} // Fin setPrecio

 	/** 
 	 * <b>getId_venta()</b>
 	 * <b>OBJETIVO:</b>Retorna el valor del atributo id_venta. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo id_venta. 
  	 */ 
     
 	public int getId_venta() { 
     	return id_venta; 
 	}//Fin getId_venta 

 	/** 
 	 * <b>setId_venta(int id_venta)</b>
  	 * <b>OBJETIVO:</b>Asigna el valor del parámetro dado al atributo id_venta. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id_venta == id_venta 
  	 * @param id_venta - Nuevo valor del atributo id_venta. 
  	 */ 

 	public void setId_venta(int id_venta) { 
    	this.id_venta = id_venta; 
 	} // Fin setId_venta

}//Fin de la Clase
