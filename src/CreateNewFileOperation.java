
import javax.swing.JOptionPane;
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
public class CreateNewFileOperation implements FileStrategy{

    @Override
    public void doFileOperation(JScrollPane scrollPane, JTextPane textPane) {
        String text = textPane.getText();

        if (text.length() > 0) {
            int a = JOptionPane.showConfirmDialog(null,
                    "Do you want to save your file?", "Save File", JOptionPane.YES_NO_CANCEL_OPTION);
            if (a == JOptionPane.NO_OPTION) {
                textPane.setText("");
            } else if (a == JOptionPane.CANCEL_OPTION) {
                textPane.setText(text);
            } else {
                SaveFileOperation save = new SaveFileOperation();
                save.doFileOperation(scrollPane, textPane);
                textPane.setText("");
            }
        }
    }
}
