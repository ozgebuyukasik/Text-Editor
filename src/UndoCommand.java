
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class UndoCommand implements ICommand{
    
    private UndoManager undo;

    
    public UndoCommand(UndoManager undo){
        this.undo = undo;
    }
    
    @Override
    public void Execute() {
        if (undo.canUndo()){
            undo.undo();
        }
    }
  
}
