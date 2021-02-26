
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
public class UndoHandler {
    
    ICommand command;
    
    public UndoHandler(ICommand command){
        this.command = command ;
    }
    
    
    public void execute(){
        command.Execute();
    }

}
