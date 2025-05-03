package Back;

/*========================================================================== 
  Encabezado de los Módulos (Bibliotecas) 
 =========================================================================== 
 */ 
/** 
 * <b>CLASE:</b>          Mesa.java 
 * <b>OBJETIVO:</b>       Representar una mesa de ayuda con su información básica. 
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 02 de mayo del 2025 
 * @author Sebastian Diaz
 */
public class Mesa {
    
    private int id; // Este es el atributo id de tipo int.
    private int id_cliente; 
    private String problema ; // Este es el atributo nombreMrca de tipo String.
    private String descripcion ;
    private int estado ;
    private String respuesta ;

   /*========================================================================== 
   * Método(s) Constructor(es) 
   ===========================================================================*/ 
 
    /** 
     * <b>Mesa()</b>
     * Objetivo:   Inicializa una instancia vacía de un nuevo objeto Mesa. 
    */ 
    public Mesa(){
    } // Fin Método Constructor 
    
    /** 
     * <b>Mesa()</b>
     * <b>Objetivo:</b>   Inicializa una instancia de un nuevo objeto Mesa con valores específicos. 
     *                     
     * @param id
     * @param id_cliente
     * @param problema
     * @param descripcion
     * @param estado
     * @param respuesta
     */
    public Mesa(int id ,int id_cliente,String problema,String  descripcion,int estado,String respuesta){
       this.id = id ;
       this.id_cliente = id_cliente;
       this.problema = problema;
       this.descripcion = descripcion ;
       this.estado = estado;
       this.respuesta = respuesta;
    } // Fin Método Constructor 
 
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
    * <b>setId(int id)</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo id. 
    * Precondición: TRUE 
    * Postcondicion: this.id == id 
    * @param id - Nuevo valor del atributo id. 
    */
    public void setId(int id) {
        this.id = id;
    }//Fin de metodo setId

    /** 
    * <b>getId()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo id. 
    * El valor es retornado como un entero. 
    * Precondición: TRUE 
    * @return El valor del atributo id. 
    */
     public int getIdCliente() {
        return id_cliente;
    }//Fin de metodo getId
     
    /** 
    * <b>setIdCliente()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo id_cliente. 
    * Precondición: TRUE 
    * Postcondicion: this.id_cliente == id_cliente 
    * @param id_cliente - Nuevo valor del atributo id. 
    */
    public void setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }//Fin de metodo setIdCliente
    
    /** 
    * <b>getProblema()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo problema. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo problema. 
    */
    public String getProblema() {
        return problema;
    }//Fin de metodo getProblema
    
    /** 
    * <b>setProblema()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo problema. 
    * Precondición: TRUE 
    * Postcondicion: this.problema == problema 
    * @param problema - Nuevo valor del atributo problema. 
    */
    public void setProblema(String problema) {
        this.problema = problema;
    }//Fin de metodo setProblema
   
    
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
    }//Fin de metodo setDescripcion
   
    /** 
    * <b>getEstado()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo estado. 
    * El valor es retornado como un entero. 
    * Precondición: TRUE 
    * @return El valor del atributo estado. 
    */
    public int getEstado() {
        return estado;
    }//Fin de metodo getEstado
    
    /** 
    * <b>setEstado()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo estado. 
    * Precondición: TRUE 
    * Postcondicion: this.estado == estado 
    * @param estado - Nuevo valor del atributo estado. 
    */
    public void setEstado(int estado) {
        this.estado = estado;
    }//Fin de metodo setEstado
    
    /** 
    * <b>getRespuesta()</b>
    * <b>OBJETIVO:</b> Retorna el valor del atributo respuesta. 
    * El valor es retornado como un String. 
    * Precondición: TRUE 
    * @return El valor del atributo respuesta. 
    */
    public String getRespuesta() {
        return respuesta;
    }//Fin de metodo getRespuesta
    
    /** 
    * <b>setRespuesta()</b>
    * <b>OBJETIVO:</b> Asigna el valor del parámetro dado al atributo respuesta. 
    * Precondición: TRUE 
    * Postcondicion: this.respuesta == respuesta 
    * @param respuesta - Nuevo valor del atributo respuesta. 
    */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }//Fin de metodo setRespuesta
   
    
}//Fin de la Clase Mesa
