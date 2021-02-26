
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class ReplaceWordOperation implements EditStrategy{

    @Override
    public void doEditOperation(JScrollPane scrollPane, JTextPane textPane, ArrayList<Word> wordArray) {
        
         JTextField findText = new JTextField();
        JTextField replaceText = new JTextField();
        Object[] message = {
            "Find:", findText,
            "Replace:", replaceText
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Replace", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            textPane.setText(textPane.getText().replace(findText.getText(), replaceText.getText()));
            
        }
    
        WordHandleLogic handle = new WordHandleLogic(0,textPane);
        try {
            handle.correct_all(textPane);
        } catch (BadLocationException ex) {
            Logger.getLogger(ReplaceWordOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
