
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
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
public class SaveFileOperation implements FileStrategy{

    @Override
    public void doFileOperation(JScrollPane scrollPane, JTextPane textPane) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a directory to save file");
        
        int userSelection = fileChooser.showSaveDialog(scrollPane);
        String path = "";
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            path += fileToSave.getAbsolutePath();
            try {
                File writtenFile = new File(fileToSave.getParentFile().getAbsolutePath(), fileToSave.getName());
                FileWriter fileWriter = new FileWriter(fileToSave);
                fileWriter.write(textPane.getText());
                fileWriter.flush();
            } catch (IOException ex) {
                Logger.getLogger(TextEditorFrontend.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("Save as file: " + fileToSave.getAbsolutePath() + "name : " + fileToSave.getName() + "Path: " + fileToSave.getParentFile().getAbsolutePath());
        }
        
    }
    
}
