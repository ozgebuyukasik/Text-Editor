
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public interface UndoStrategy {
    
        public void doUndoOperation(JScrollPane scrollPane, JTextPane textPane, UndoHandler handler);

}
