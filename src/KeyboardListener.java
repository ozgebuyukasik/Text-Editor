
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ozgeb
 */
public class KeyboardListener implements KeyListener{
    
    private char readChar;
    private KeyboardOperations observer;
    
    public void setObs(KeyboardOperations observer){
        this.observer = observer;
    }
    
    public char getReadChar(){
        return readChar;
    }
    public void setReadChar(KeyEvent e) throws BadLocationException{
        this.readChar = e.getKeyChar();
        notifyObserver();
    }

    private void notifyObserver() throws BadLocationException {
        observer.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        try {
            setReadChar(e);
        } catch (BadLocationException ex) {
            Logger.getLogger(KeyboardListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(getReadChar());
    }
    @Override
    public void keyPressed(KeyEvent e) {
        this.readChar = e.getKeyChar();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.readChar = e.getKeyChar();
        
    }
}
