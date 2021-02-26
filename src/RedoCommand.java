
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
public class RedoCommand implements ICommand{

    private UndoManager undo;
    
    public RedoCommand(UndoManager undo){
        this.undo = undo ;
    }
    @Override
    public void Execute() {
        if(undo.canRedo()){
            undo.redo();
        }
    }
    
}
