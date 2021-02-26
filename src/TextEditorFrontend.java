
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puv0
 */
public class TextEditorFrontend extends javax.swing.JFrame{
    
    
    public JScrollPane ScrollPane;
    public JMenu FileMenu;
    public JMenu EditMenu;
    public JMenu UndoMenu;
    public JMenu CorrectMenu;
    public JMenuBar MenuBar;
    public JMenuItem NewFileMenuItem;
    public JMenuItem OpenFileMenuItem;
    public JMenuItem SaveFileMenuItem;
    public JMenuItem FindWordMenuItem;
    public JMenuItem ReplaceWordMenuItem;
    public JMenuItem UndoMenuItem;
    public JMenuItem RedoMenuItem;
    public JMenuItem CorrectAllMenuItem;
    public JTextPane pane;
    WordDictionary dictionary;
    ArrayList<Word> wordArray;
    UndoManager undo ;
    
    
    public TextEditorFrontend(){
        this.ScrollPane = new JScrollPane();
        this.pane = new JTextPane();
           
        this.FileMenu = new JMenu();
        this.EditMenu = new JMenu();
        this.UndoMenu = new JMenu();
        this.CorrectMenu = new JMenu();
        this.MenuBar = new JMenuBar();
        this.NewFileMenuItem = new JMenuItem();
        this.OpenFileMenuItem = new JMenuItem();
        this.SaveFileMenuItem = new JMenuItem();
        this.ReplaceWordMenuItem = new JMenuItem();
        this.FindWordMenuItem = new JMenuItem();
        this.UndoMenuItem = new JMenuItem();
        this.RedoMenuItem = new JMenuItem();

        this.CorrectAllMenuItem = new JMenuItem();
        this.pane = new JTextPane();
        
        
        this.FileMenu.setText("File");
        this.EditMenu.setText("Edit");
        this.UndoMenu.setText("Undo");
        this.CorrectMenu.setText("Correct");
        
        this.NewFileMenuItem.setText("New");
        
        // STRATEGY PATTERN KULLANILARAK, file operationlar gerçekleştirilmiştir.
        this.NewFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecuteFileStrategy strategy = new ExecuteFileStrategy(new CreateNewFileOperation());
                strategy.executeFileOperation(ScrollPane, pane);
            }
        });
        this.OpenFileMenuItem.setText("Open");
        this.OpenFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecuteFileStrategy strategy = new ExecuteFileStrategy(new OpenExistFileOperation());
                strategy.executeFileOperation(ScrollPane, pane);
            }
        });
        this.SaveFileMenuItem.setText("Save");
        this.SaveFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecuteFileStrategy strategy = new ExecuteFileStrategy(new SaveFileOperation());
                strategy.executeFileOperation(ScrollPane, pane);
            }
        });
        
        
        // STRATEGY PATTERN KULLANILARAK, Editleme operasyonları(find,replace) gerçekleştirilmiştir.
                
        this.ReplaceWordMenuItem.setText("Replace");
        this.ReplaceWordMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               ExecuteEditStrategy strategy = new ExecuteEditStrategy(new ReplaceWordOperation());
               strategy.executeEditOperation(ScrollPane, pane, wordArray);
            }
        });
        
        this.FindWordMenuItem.setText("Find");
        this.FindWordMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               ExecuteEditStrategy strategy = new ExecuteEditStrategy(new FindWordOperation());
               strategy.executeEditOperation(ScrollPane, pane, wordArray);
            }
        });

            undo = new UndoManager();
            pane.getDocument().addUndoableEditListener(undo);
        
            this.UndoMenuItem.setText("Undo");
        this.UndoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UndoCommand undoCommand = new UndoCommand(undo);
                UndoHandler undoHandler = new UndoHandler(undoCommand);
                ExecuteUndoStrategy strategy = new ExecuteUndoStrategy(new UndoOperation());
                strategy.executeUndoOperation(ScrollPane, pane, undoHandler);
            }
        });
        
        this.RedoMenuItem.setText("Redo");
        this.RedoMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RedoCommand redoCommand = new RedoCommand(undo);
                UndoHandler redoHandler = new UndoHandler(redoCommand);
                ExecuteUndoStrategy strategy = new ExecuteUndoStrategy(new RedoOperation());
                strategy.executeUndoOperation(ScrollPane, pane, redoHandler);
            }
        });
        
        
        this.CorrectAllMenuItem.setText("Correct All");
        this.CorrectAllMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WordHandleLogic handle = new WordHandleLogic(0, pane);
                try {
                    handle.correct_all(pane);
                } catch (BadLocationException ex) {
                    Logger.getLogger(TextEditorFrontend.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        this.FileMenu.add(this.NewFileMenuItem);
        this.FileMenu.add(this.OpenFileMenuItem);
        this.FileMenu.add(this.SaveFileMenuItem);
        this.EditMenu.add(this.ReplaceWordMenuItem);
        this.EditMenu.add(this.FindWordMenuItem);
        this.UndoMenu.add(this.UndoMenuItem);
        this.UndoMenu.add(this.RedoMenuItem);
        this.CorrectMenu.add(this.CorrectAllMenuItem);
        
        
        this.MenuBar.add(this.FileMenu);
        this.MenuBar.add(this.EditMenu);
        this.MenuBar.add(this.UndoMenu);
        this.MenuBar.add(this.CorrectMenu);
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Text Editor");
        setVisible( true );
        this.ScrollPane.setViewportView(this.pane);
        setJMenuBar(this.MenuBar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(ScrollPane,GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(ScrollPane, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        
        pack();
        add(this.ScrollPane);
    
    
        KeyboardListener listener = new KeyboardListener();
        this.dictionary = new WordDictionary();
        this.wordArray = new ArrayList<>();
        WordHandleLogic handle = new WordHandleLogic(0,pane);
       // KeyboardOperations k = new KeyboardOperations(listener,this.pane,this.dictionary,this.wordArray);
        KeyboardOperations k = new KeyboardOperations(listener,handle);
        listener.setObs(k);
        this.pane.addKeyListener(listener);
        
    }


    
}
