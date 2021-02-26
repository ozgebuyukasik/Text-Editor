
import java.util.ArrayList;
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
public class ExecuteEditStrategy {
    private EditStrategy editStrategy;
    
    public ExecuteEditStrategy(EditStrategy editStrategy){
        this.editStrategy = editStrategy;
    }
    
    public void executeEditOperation(JScrollPane scrollPane, JTextPane textPane,ArrayList<Word> wordArray){
        editStrategy.doEditOperation(scrollPane, textPane,wordArray);
    }
}
