
import java.awt.Color;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
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
 * @author ozgeb
 */
public class KeyboardOperations extends Observable{
    Word word;
    String allText = "";
    int start_index ;
    int current_index = 0;
    ArrayList<Word> wordArray;
    WordDictionary dict;
    String wordValue;
    WordHandleLogic handle ;

    protected KeyboardListener listener;
    private JTextPane pane;
    
    public KeyboardOperations(KeyboardListener listener,WordHandleLogic handle){
        this.listener = listener;
        this.handle = handle;
        start_index = 0 ;
        this.pane = handle.pane;
        this.wordValue = "";
    }
 
    void  update() throws BadLocationException {
        char e = listener.getReadChar();
        
        if((e == ',' || e == ';'  || e  == '.' || e=='\n' ||e ==' ')&& Pattern.matches("[a-zA-Z0-9]+", wordValue)){
        // 32 is space in ascii,44 is (,) , 46 is (.) ,  keycode 44 is (;) enter key_code 10 
            handle.start_index = start_index;
           
            //Eğer bir kelimede, - _ veya rakam bulunuyorsa, kontrol edilmesine gerek yoktur.
            if (wordValue.matches(".*\\d.*")) {
                word = new Word(wordValue);
                word.setStart_index(start_index);
                wordArray.add(word);
            } else {
                //Kelimede yukarıda belirtilen istisnalardan biri yoksa, kelime verilen word.txt içerisinde olup olmadığına bakılır
                System.out.println("wordValue" + wordValue);
                   handle.isValidCheck(wordValue,start_index);
            }
            start_index = pane.getCaretPosition() + 1;
            //word value sıfırlanır kontrol edilebilmek adına yeniden yaratılır.
            wordValue = "";

        } else if (e == 8) {
            if (pane.getCaretPosition() != -1) {
                //Kelimenin içinde eğer, harfler var ise silmeye devam eder.
                if (Pattern.matches("[a-zA-Z]+", wordValue)) {
                    wordValue = wordValue.substring(0, wordValue.length() - 1);
                }
            }
            current_index = pane.getCaretPosition();           
            if(wordArray.size() > 0){
                Word lastWord = wordArray.get(wordArray.size()-1);
            
                if(lastWord.getStart_index() == current_index){
                    wordArray.remove(lastWord);
                    wordValue = "";
                    start_index = current_index;
                }
                if((lastWord.getStart_index() + lastWord.getValue().length()) > current_index){
                    lastWord.setValue(lastWord.getValue().substring(0, lastWord.getValue().length()-1));
                    wordValue = lastWord.getValue();
                    start_index = lastWord.getStart_index();
                }
            }else{
                wordValue = wordValue.substring(0,wordValue.length());
            }
        }  else {
            if (e == ' ' || e== '\n') {
                wordValue = "";
                start_index = pane.getCaretPosition() + 1;
            } else {
                wordValue += e;
            }
        }
    }
     
}

