
package Back;


import javax.swing.JProgressBar;

/** 
 * <b>CLASE:</b>          Cargar.java 
 * <b>OBJETIVO:</b>       Representar la carga de la barra de progreso. 
 * ASIGNATURA o PROYECTO: Insertar asignatura o proyecto correspondiente.
 *
 * @version 1.0 17/11/2023 
 * @author Juan diaz 
 */
public class Cargar extends Thread{
    JProgressBar progreso;
    public Cargar(JProgressBar progreso){
        super();
        this.progreso=progreso;
    }
    
    
    /**
     * <b>run()</b>
     * <b>OBJETIVO:</b>  Contar de 1 a 100 en  la barra de progreso.
     *
     */
    @Override
    public void run(){
        for(int i=1;i<=100;i++){
            
            if(i >75){
            i++;
            }
            progreso.setValue(i);
            pausa(30);
        }
    }
    public void pausa(int mlSeg){
        try{
            Thread.sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }
}//fin clase Cargar
