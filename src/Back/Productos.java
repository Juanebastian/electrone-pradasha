package Back;

/*========================================================================== 
  Encabezado de los Módulos (Bibliotecas) 
 =========================================================================== 
 */ 
/** 
 * <b>CLASE:</b>          Productos.java 
 * <b>OBJETIVO:</b>       Representar un Producto con su información básica. 
 * ASIGNATURA o PROYECTO: Proyecto integrador.
 *
 * @version 1.0 29/11/2023 
 * @author Juan diaz 
 */
public class Productos {
    private int id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int proveedor;
    private String proveedorPro;
    private String marca;
    private int stock;
    private double precio;
    
   /*========================================================================== 
   * Método(s) Constructor(es) 
   ===========================================================================*/ 
 
    /** 
     * <b>Productos()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Productos. 
    */ 
    public Productos(){
        
    }// Fin Método Constructor 
    
    /** 
     * <b>Productos()</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Cliente con valores específicos. 
     *                    
     * @param id
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param proveedor
     * @param proveedorPro
     * @param marca
     * @param stock
     * @param precio
     */
    public Productos(int id, String codigo, String nombre,String descripcion, int proveedor, String proveedorPro, String marca, int stock, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.proveedorPro = proveedorPro;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
    }// Fin Método Constructor 
  
    /** 
    * <b>getId()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo id. 
    * El valor es retornado como un entero. 
    * Precondición: TRUE 
    * @return El valor del atributo id. 
    */
    public int getId() {
        return id;
    }//Fin de metodo getId
    
    /** 
    * <b>setId()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo id. 
    * Precondición: TRUE 
    * Postcondicion: this.id == id 
    * @param id - Nuevo valor del atributo id. 
    */
    public void setId(int id) {
        this.id = id;
    }//Fin de metodo setId
    
    /** 
    * <b>getCodigo()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo codigo. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo codigo. 
    */
    public String getCodigo() {
        return codigo;
    }//Fin de metodo getCodigo
    
    /** 
    * <b>setCodigo()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo codigo. 
    * Precondición: TRUE 
    * Postcondicion: this.codigo == codigo 
    * @param codigo - Nuevo valor del atributo codigo. 
    */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }//Fin de metodo setCodigo
    
    /** 
    * <b>getNombre()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo nombre. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo nombre. 
    */
    public String getNombre() {
        return nombre;
    }//Fin de metodo getNombre
    
    /** 
    * <b>setNombre()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo nombre. 
    * Precondición: TRUE 
    * Postcondicion: this.nombred == nombre 
    * @param nombre - Nuevo valor del atributo nombre. 
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//Fin de metodo setNombre
    
    /** 
    * <b>getDescripcion()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo descripcion. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo descripcion. 
    */
    public String getDescripcion() {
        return descripcion;
    }//Fin de metodo getDescripcion
    
    /** 
    * <b>setDescripcion()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo descripcion. 
    * Precondición: TRUE 
    * Postcondicion: this.descripcion == descripcion 
    * @param descripcion - Nuevo valor del atributo descripcion. 
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }//Fin de metodo getId
    
    /** 
    * <b>getProveedor()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo proveedor. 
    * El valor es retornado como un entero. 
    * Precondición: TRUE 
    * @return El valor del atributo proveedor. 
    */
    public int getProveedor() {
        return proveedor;
    }//Fin de metodo getProveedor
    
    /** 
    * <b>setProveedor()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo proveedor. 
    * Precondición: TRUE 
    * Postcondicion: this.proveedor == proveedor 
    * @param proveedor - Nuevo valor del atributo proveedor. 
    */
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }//Fin de metodo setProveedor
    
    /** 
    * <b>getProveedorPro()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo proveedorPro. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo proveedorPro. 
    */
    public String getProveedorPro() {
        return proveedorPro;
    }//Fin de metodo getProveedorPro
    
    /** 
    * <b>setProveedorPro()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo proveedorPro. 
    * Precondición: TRUE 
    * Postcondicion: this.proveedorPro == proveedorPro 
    * @param proveedorPro - Nuevo valor del atributo proveedorPro. 
    */
    public void setProveedorPro(String proveedorPro) {
        this.proveedorPro = proveedorPro;
    }//Fin de metodo setProveedorPro
    
    /** 
    * <b>getMarca()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo marca. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo marca. 
    */
     public String getMarca() {
        return marca;
    }//Fin de metodo getMarca
     
    /** 
    * <b>setMarca()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo marca. 
    * Precondición: TRUE 
    * Postcondicion: this.marca == marca 
    * @param marca - Nuevo valor del atributo marca. 
    */
    public void setMarca(String marca) {
        this.marca = marca;
    }//Fin de metodo setMarca
    
    /** 
    * <b>getStock()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo stock. 
    * El valor es retornado como un entero. 
    * Precondición: TRUE 
    * @return El valor del atributo stock. 
    */
    public int getStock() {
        return stock;
    }//Fin de metodo getStock
    
    /** 
    * <b>setStock()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo stock. 
    * Precondición: TRUE 
    * Postcondicion: this.stock == stock 
    * @param stock - Nuevo valor del atributo stock. 
    */
    public void setStock(int stock) {
        this.stock = stock;
    }//Fin de metodo setStock
    
    /** 
    * <b>getPrecio()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo precio. 
    * El valor es retornado como un double. 
    * Precondición: TRUE 
    * @return El valor del atributo precio. 
    */
    public double getPrecio() {
        return precio;
    }//Fin de metodo getPrecio
    
    /** 
    * <b>setPrecio()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo precio. 
    * Precondición: TRUE 
    * Postcondicion: this.precio == precio 
    * @param precio - Nuevo valor del atributo precio. 
    */
    public void setPrecio(double precio) {
        this.precio = precio;
    }//Fin de metodo setPrecio

   
}//Fin de clase Productos
