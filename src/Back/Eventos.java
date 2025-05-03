package Back;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
/** 
 * <b>CLASE:</b>          Eventos.java 
 * <b>OBJETIVO:</b>       Representar metodos de texto para los textfield. 
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 02 de mayo del 2025 
 * @author Sebastian Diaz
 */

public class Eventos {
    /** 
     * <b>textKeyPress()</b>
     * <b>Objetivo:</b>   Metodo que permite escribir unicamente texto. 
     *                    
     * @param evt
     * 
     */ 
    public void textKeyPress(KeyEvent evt) {
// declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//Fin textKeyPress 

    
    /** 
     * <b>numberKeyPress()</b>
     * <b>Objetivo:</b>   Metodo que permite escribir unicamente numeros. 
     *                    
     * @param evt
     * 
     */ 
    public void numberKeyPress(KeyEvent evt) {
// declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//Fin numberKeyPress v
    /** 
     * <b>numberDecimalKeyPress()</b>
     * <b>Objetivo:</b>   Metodo que permite escribir unicamente numeros y numero decimales. 
     *                    
     * @param evt
     * @param textField
     * 
     */ 
    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {
// declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//Fin numberDecimalKeyPress 
}//Fin de la Clase Eventos
