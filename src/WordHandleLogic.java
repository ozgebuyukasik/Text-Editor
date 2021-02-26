
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
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
public class WordHandleLogic {
    
    
    int start_index;
    Word word ;
    WordDictionary dict;
    String allText ;
    ArrayList<Word> wordArray;
    JTextPane pane;

    public WordHandleLogic(int start_index, JTextPane pane) {
        this.start_index = start_index;
        this.word = new Word("");
        this.dict = new WordDictionary();
        this.wordArray = new ArrayList<>();
        this.pane = pane;
        this.allText = "";
    }
 

    
    
    
    public void isValidCheck(String wordValue,int start_index) throws BadLocationException {
       
        Word word = new Word(wordValue.toLowerCase());
        word.setStart_index(start_index);

        //System.out.println("Word is : " + word.getValue() + " start index is : " + word.getStart_index());

        word.setIsValid(dict.isValid(word));

        if (!word.getIsValid()) {
            replace(word);
        } else {
            allText += word.getValue();
            wordArray.add(word);
            wordValue = "";
        }
        wordValue = "";
    }
    /**
     * 
     * @param word
     * @return
     * @throws BadLocationException 
     */
    public String replace(Word word) throws BadLocationException {

        StyledDocument doc = pane.getStyledDocument();

        word = dict.singleTransposition(word.getValue());
        word.setStart_index(start_index);
        if (!word.getIsValid()) {
            // UNDERLINE YAP
            SimpleAttributeSet underline = new SimpleAttributeSet();
            StyleConstants.setUnderline(underline, Boolean.TRUE);
            StyleConstants.setForeground(underline, Color.red);
            doc.setCharacterAttributes(start_index, word.getValue().length(), underline, false);

        } else {
            //SINGLE TRANSPOSITION FIX
            doc.remove(word.getStart_index(), word.getValue().length());
            doc.insertString(word.getStart_index(), word.getValue(), null);
        }
        allText += word.getValue();
        wordArray.add(word);
        return word.getValue();
    }

    /**
     * 
     * @param text
     * @throws BadLocationException 
     */
    public void correct_all(JTextPane pane) throws BadLocationException {
        char [] char_array = pane.getText().toCharArray();
        String target = "";
        for(char c : char_array){
            if(Character.isLetterOrDigit(c)){
                target += c;
            }else{
                if(target.length()!=0){
                   // System.out.println("NOWWWWWWW Start: " + target + "   " + start_index);
                    this.isValidCheck(target,start_index);
                    start_index += target.length()+ 1;
                    //System.out.println("target:" + target);
                    target = "";   
                }else {
                    start_index++ ;
                }
                
            }
    }
    }
}
