package Back;

/*========================================================================== 
  Encabezado de los Módulos (Bibliotecas) 
 =========================================================================== 
 */ 
/** 
 * <b>CLASE:</b>          Proveedor.java 
 * <b>OBJETIVO:</b>       Representar un Proveedor con su información básica. 
 * ASIGNATURA o PROYECTO: Proyecto integrador.
 *
 * @version 1.0 29/11/2023 
 * @author Juan diaz 
 */public class Proveedor {
    private int id;
    private String nit;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    
    /*========================================================================== 
   * Método(s) Constructor(es) 
   ===========================================================================*/ 
 
    /** 
     * <b>Proveedor()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Proveedor. 
    */
    public Proveedor(){
        
    }// Fin Método Constructor 
    
    /** 
     * <b>Productos()</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Cliente con valores específicos. 
     *                    
     * @param id
     * @param nit
     * @param nombre
     * @param telefono
     * @param correo
     * @param direccion
     */
    public Proveedor(int id, String nit, String nombre, String telefono,String correo, String direccion) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
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
    * <b>getNit()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo nit. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo nit. 
    */
    public String getNit() {
        return nit;
    }//Fin de metodo getNit
    
    /** 
    * <b>setNit()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo nit. 
    * Precondición: TRUE 
    * Postcondicion: this.nit == nit 
    * @param nit - Nuevo valor del atributo nit. 
    */
    public void setNit(String nit) {
        this.nit = nit;
    }//Fin de metodo setNit
    
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
    * Postcondicion: this.nombre == nombre 
    * @param nombre - Nuevo valor del atributo nombre. 
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }//Fin de metodo setNombre
    
    /** 
    * <b>getTelefono()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo telefono. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo telefono. 
    */
    public String getTelefono() {
        return telefono;
    }//Fin de metodo getTelefono
    
    /** 
    * <b>setTelefono()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo telefono. 
    * Precondición: TRUE 
    * Postcondicion: this.id == id 
    * @param telefono - Nuevo valor del atributo telefono. 
    */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }//Fin de metodo setTelefono

   /** 
    * <b>getCorreo()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo correo. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo correo. 
    */
    public String getCorreo() {
        return correo;
    }//Fin de metodo getCorreo
    
    /** 
    * <b>setCorreo()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo correo. 
    * Precondición: TRUE 
    * Postcondicion: this.correo == correo 
    * @param correo - Nuevo valor del atributo correo. 
    */
    public void setCorreo(String correo) {
        this.correo = correo;
    }//Fin de metodo setCorreo
    
    /** 
    * <b>getDireccion()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo direccion. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo direccion. 
    */
    public String getDireccion() {
        return direccion;
    }//Fin de metodo getDireccion
    
    /** 
    * <b>setDireccion()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo direccion. 
    * Precondición: TRUE 
    * Postcondicion: this.direccion == direccion 
    * @param direccion - Nuevo valor del atributo direccion. 
    */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }//Fin de metodo setDireccion
    
    
    void setCodigo(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}//Fin de clase Productos
