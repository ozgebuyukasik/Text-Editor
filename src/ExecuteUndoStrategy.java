
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
public class ExecuteUndoStrategy {
    private UndoStrategy undoStrategy;
    
    public ExecuteUndoStrategy(UndoStrategy undoStrategy){
        this.undoStrategy = undoStrategy;
    }
    
    public void executeUndoOperation(JScrollPane scrollPane, JTextPane textPane,UndoHandler handler){
        undoStrategy.doUndoOperation(scrollPane, textPane,handler);
    }
}
