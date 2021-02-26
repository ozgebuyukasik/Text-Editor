/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class Word {
    
    private String value;
   private boolean isValid;
   private boolean isUnderLine;
   private int start_index ;
    
    public Word(String value){
        this.value = value;
        this.isValid = false;
        this.isUnderLine = false;
        
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    
    public boolean getIsUnderLine() {
        return isUnderLine;
    }

    public void setIsUnderLine(boolean isUnderLine) {
        this.isUnderLine = isUnderLine;
    }

    public int getStart_index() {
        return start_index;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }
     
}
