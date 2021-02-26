
import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class TextEditor {
    
    JFrame textEditor ;
   
    
    public TextEditor(){
        textEditor = new TextEditorFrontend();
       
    }
    
    public static void main(String[] args) {
        new TextEditor();
           
    }
}
