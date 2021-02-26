
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class FindWordOperation implements EditStrategy {

    @Override
    public void doEditOperation(JScrollPane scrollPane, JTextPane textPane,ArrayList<Word> wordArray) {
         
        SimpleAttributeSet highlight = new SimpleAttributeSet();
        StyleConstants.setBackground(highlight, Color.gray);
        StyledDocument doc = textPane.getStyledDocument();
     
        boolean cant_find = false;
        String find_text = JOptionPane.showInputDialog("Find");
        
        Iterator<Word> iterator = wordArray.iterator();
        
        while(iterator.hasNext()){
            Word word = iterator.next();
            if(word.getValue().equals(find_text)){
                System.out.println(word.getValue());
                doc.setCharacterAttributes(word.getStart_index(), word.getValue().length(), highlight, false);
                    textPane.setCaretPosition(word.getStart_index());
                    cant_find = true;
            }
        }
        if (!cant_find) {
            JOptionPane.showMessageDialog(textPane, "CAN'T FIND THE WORD");
        }
    }
 }
    

