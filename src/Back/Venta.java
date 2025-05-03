
package Back;

/**
 * <b>CLASE:</b>          Venta.java
 * <b>OBJETIVO:</b>       Representar una venta con su información básica.
 * ASIGNATURA o PROYECTO: Insertar asignatura o proyecto correspondiente.
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 02 de mayo del 2025 
 * @author Sebastian Diaz
 */

public class Venta {

   /*==========================================================================* 
    * Atributos Principales 
    *==========================================================================* 
    */ 

    /** Identificador de la venta. */ 
    private int id;
    
    /** Identificador del cliente asociado a la venta. */
    private int cliente;
    
    /** Nombre del cliente asociado a la venta. */
    private String nombre_cli;
    
    /** Nombre del vendedor que realizó la venta. */
    private String vendedor;
    
    /** Total de la venta. */
    private double total;
    
    /** Fecha de la venta. */
    private String fecha;

   /*------------------------------------------------------------------------*/ 
    
   /*========================================================================== 
    * Método(s) Constructor(es) 
    =========================================================================== 
    * (Objetivo): Inicializar instancias de objetos Venta con o sin valores. 
    * Las especificaciones se realizan después del punto. 
    */ 

    /** 
     * <b>Venta()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Venta. 
     */ 

    public Venta(){
        
    } // Fin Método Constructor 

    /** 
     * <b>Venta(int id, int cliente, String nombre_cli, String vendedor, double total, String fecha)</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Venta con valores específicos. 
     *                    Asigna valores a los atributos id, cliente, nombre_cli, vendedor, total y fecha. 
     * @param id
     * @param cliente
     * @param nombre_cli
     * @param vendedor
     * @param total
     * @param fecha
     */ 
    public Venta(int id, int cliente, String nombre_cli, String vendedor, double total, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.nombre_cli = nombre_cli;
        this.vendedor = vendedor;
        this.total = total;
        this.fecha = fecha;
    }// Fin Método Constructor 

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
 	 * <b>setId()</b>
  	 * Asigna el valor del parámetro dado al atributo id. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.id == id 
  	 * @param id - Nuevo valor del atributo id. 
  	 */ 

 	public void setId(int id) { 
    	this.id = id; 
 	} // Fin setId

 	/** 
 	 * <b>getCliente()</b>
 	 * Retorna el valor del atributo cliente. 
 	 * El valor es retornado como un entero. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo cliente. 
  	 */ 
     
 	public int getCliente() { 
     	return cliente; 
 	}//Fin getCliente 

 	/** 
 	 * <b>setCliente(int cliente)</b>
  	 * Asigna el valor del parámetro dado al atributo cliente. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.cliente == cliente 
  	 * @param cliente - Nuevo valor del atributo cliente. 
  	 */ 

 	public void setCliente(int cliente) { 
    	this.cliente = cliente; 
 	} // Fin setCliente

 	/** 
 	 * <b>getNombre_cli()</b>
 	 * Retorna el valor del atributo nombre_cli. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo nombre_cli. 
  	 */

        public String getNombre_cli() {
            return nombre_cli;
        }
        
        /** 
 	 * <b>setNombre_cli()</b>
  	 * Asigna el valor del parámetro dado al atributo nombre_cli. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.nombre_cli == nombre_cli 
  	 * @param nombre_cli - Nuevo valor del atributo vendedor. 
  	 */
        public void setNombre_cli(String nombre_cli) {
            this.nombre_cli = nombre_cli;
        }

        /** 
 	 * <b>getVendedor()</b>
 	 * Retorna el valor del atributo vendedor. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo vendedor. 
  	 */ 
     
 	public String getVendedor() { 
     	return vendedor; 
 	}//Fin getVendedor 

 	/** 
 	 * <b>setVendedor()</b>
  	 * Asigna el valor del parámetro dado al atributo vendedor. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.vendedor == vendedor 
  	 * @param vendedor - Nuevo valor del atributo vendedor. 
  	 */ 

 	public void setVendedor(String vendedor) { 
    	this.vendedor = vendedor; 
 	} // Fin setVendedor

 	/** 
 	 * <b>getTotal()</b>
 	 * Retorna el valor del atributo total. 
 	 * El valor es retornado como un número decimal (double). 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo total. 
  	 */ 
     
 	public double getTotal() { 
     	return total; 
 	}//Fin getTotal 

 	/** 
 	 * <b>setTotal()</b>
  	 * Asigna el valor del parámetro dado al atributo total. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.total == total 
  	 * @param total - Nuevo valor del atributo total. 
  	 */ 

 	public void setTotal(double total) { 
    	this.total = total; 
 	} // Fin setTotal

 	/** 
 	 * <b>getFecha()</b>
 	 * Retorna el valor del atributo fecha. 
 	 * El valor es retornado como un objeto String. 
  	 * Precondición: TRUE 
  	 * @return El valor del atributo fecha. 
  	 */ 
     
 	public String getFecha() { 
     	return fecha; 
 	}//Fin getFecha 

 	/** 
 	 * <b>setFecha()</b>
  	 * Asigna el valor del parámetro dado al atributo fecha. 
  	 * Precondición: TRUE 
  	 * Postcondicion: this.fecha == fecha 
  	 * @param fecha - Nuevo valor del atributo fecha. 
  	 */ 

 	public void setFecha(String fecha) { 
    	this.fecha = fecha; 
 	} // Fin setFecha

}//Fin de la Clase
