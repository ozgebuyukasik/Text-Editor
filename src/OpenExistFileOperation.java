
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ozgeb
 */
public class OpenExistFileOperation implements FileStrategy {

    @Override
    public void doFileOperation(JScrollPane scrollPane, JTextPane textPane) {

        String textOfPane = textPane.getText();
        if (textOfPane.length() > 0) {
            int a = JOptionPane.showConfirmDialog(null,
                    "Do you want to save your file?", "Save File", JOptionPane.YES_NO_CANCEL_OPTION);
            if (a == JOptionPane.NO_OPTION) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a directory to open file");
                int userSelection = fileChooser.showOpenDialog(scrollPane);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooser.getSelectedFile();
                    try {
                        FileReader fileReader = new FileReader(fileToOpen.getAbsolutePath());
                        String text = "";
                        int i = fileReader.read();
                        while (i != -1) {

                            text += (char) i;
                            i = fileReader.read();

                        }
                        textPane.setText(text);
                        fileReader.close();

                    } catch (IOException ex) {
                        Logger.getLogger(TextEditorFrontend.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                WordHandleLogic handle = new WordHandleLogic(0, textPane);
                try {
                    handle.correct_all(textPane);
                } catch (BadLocationException ex) {
                    Logger.getLogger(OpenExistFileOperation.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (a == JOptionPane.CANCEL_OPTION) {
                textPane.setText(textOfPane);
            } else {
                SaveFileOperation save = new SaveFileOperation();
                save.doFileOperation(scrollPane, textPane);
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a directory to open file");
                int userSelection = fileChooser.showOpenDialog(scrollPane);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooser.getSelectedFile();
                    try {
                        FileReader fileReader = new FileReader(fileToOpen.getAbsolutePath());
                        String text = "";
                        int i = fileReader.read();
                        while (i != -1) {

                            text += (char) i;
                            i = fileReader.read();

                        }
                        textPane.setText(text);
                        fileReader.close();

                    } catch (IOException ex) {
                        Logger.getLogger(TextEditorFrontend.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                WordHandleLogic handle = new WordHandleLogic(0, textPane);
                try {
                    handle.correct_all(textPane);
                } catch (BadLocationException ex) {
                    Logger.getLogger(OpenExistFileOperation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

       
    }

}
