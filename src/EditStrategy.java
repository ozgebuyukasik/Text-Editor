
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
public interface EditStrategy {
    public void doEditOperation(JScrollPane scrollPane, JTextPane textPane, ArrayList<Word> wordArray);

}
