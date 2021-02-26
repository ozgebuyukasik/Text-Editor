
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ozgeb
 */
public class ExecuteFileStrategy {
    
    private FileStrategy fileStrategy;
    
    public ExecuteFileStrategy(FileStrategy strategy){
        this.fileStrategy = strategy;
    }
    
    public void executeFileOperation(JScrollPane scrollPane, JTextPane textPane){
        fileStrategy.doFileOperation(scrollPane, textPane);
    }
}
