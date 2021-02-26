
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class WordDictionary {
        public Scanner file = null ;    
        public HashMap wordDictionary;
        
        public WordDictionary(){
          this.wordDictionary = this.createDictionary();

        }
         
     public Scanner readFromFile(){
        try{
            file = new Scanner(new FileInputStream("word.txt"));

                    
        }catch(FileNotFoundException e) {
                System.out.println("File error!");
                e.printStackTrace();
            }        
        return file;
    }
     
     public boolean  isValid(Word tempword){
         ArrayList<String> arr = new ArrayList<>();
         String word = tempword.getValue();
         String key = Character.toString(word.charAt(0));
         arr = (ArrayList) wordDictionary.get(key) ;    
         if(arr.contains(word)){
             return true;
         }
         return false;
     }

     public HashMap createDictionary(){
            Scanner file = readFromFile();  
            ArrayList<String> wordList = null;
            HashMap<String, ArrayList<String>> wordDictionary = new HashMap<String,ArrayList<String>>();
           
            while(file.hasNextLine()){
                        String word = file.nextLine(); // WORD OBJE
                        String key = word.split("")[0];
                        if(!wordDictionary.containsKey(key)){
                            wordList = new ArrayList<String>();
                            wordList.clear();
                            wordList.add(word);
                            wordDictionary.put(key, wordList);
                        }else{
                            
                            wordList.add(word);
                            wordDictionary.replace(key, wordList);
                        }
                       
                    }
                
                 return wordDictionary;
     }

     public Word singleTransposition(String word){
        
        Word newWord ;
        Word oldWord = new Word(word);
        String[] temp = word.split("");
        String[] another = word.split("");
        
        
        for(int i = 0 ; i<temp.length ; i++){

            for(int j =i+1 ; j<temp.length; j++){  
                
                String tempetemp = temp[i];
                temp[i] = temp[j];
                temp[j] = tempetemp;
                String jos = String.join("", temp);
                
                // return Single Transpose to wordArrayFind, if found return else continue
                 newWord = new Word(jos);
                 if(isValid(newWord)){
                     newWord.setIsValid(true);
                     //System.out.println("new word : " + newWord.getValue());
                     return newWord;
                 }
                  temp = another.clone();
            }
        }
           // System.out.println("old word : " + oldWord.getValue());
            oldWord.setIsValid(false);
            //UNDERLINE
            oldWord.setIsUnderLine(true);
            return oldWord;
    }

    


}
