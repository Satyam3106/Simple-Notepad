import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.*;


public class TextEditor implements ActionListener {
    JFrame window;

    //Text Area
    JTextArea textArea;
    boolean wordWrapOn = false;
    // Top menu Bar
    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuFormat,menuColor;

    //File menu
    JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;

    //Edit menu
    JMenuItem iUndo,iRedo;

    //Format menu
    JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24;
    JMenu menuFont,menuFontSize;

    //ColorMenu items
    JMenuItem iColor1 , iColor2,iColor3;


    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);

    // for undo and re-do
    Function_Edit edit = new Function_Edit(this);
    UndoManager um = new UndoManager();



    public TextEditor()
    {
      createWindow();
      createTextArea();
      createMenuBar();
      createFileMenu();
      format.selectedFont="Arial";
      format.createFont(16);
      createFormatMenu();
      createColorMenu();
      createEditMenu();
      color.changeColor("Black");
      window.setVisible(true);

    }
    public void createWindow()
    {
        window = new JFrame("TextEditor");
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
        textArea = new JTextArea();

        //to implement undo
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                });

        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar()
    {
         menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

         menuFile = new JMenu("File");
        menuBar.add(menuFile);

         menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

         menuColor = new JMenu("Color");
        menuBar.add(menuColor);

         menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
    }

    public void createFileMenu()
    {
         iNew = new JMenuItem("New");
         iNew.addActionListener(this);
         iNew.setActionCommand("New");
         menuFile.add(iNew);

         iOpen = new JMenuItem("Open");
         iOpen.addActionListener(this);
         iOpen.setActionCommand("Open");
         menuFile.add(iOpen);

         iSave = new JMenuItem("Save");
         iSave.addActionListener(this);
         iSave.setActionCommand("Save");
         menuFile.add(iSave);

         iSaveAs = new JMenuItem("SaveAS");
         iSaveAs.addActionListener(this);
         iSaveAs.setActionCommand("SaveAs");
         menuFile.add(iSaveAs);

         iExit = new JMenuItem("Exit");
         iExit.addActionListener(this);
         iExit.setActionCommand("Exit");
         menuFile.add(iExit);
    }

    public void createFormatMenu()
    {
         iWrap = new JMenuItem("Word Wrap : Off");
         iWrap.addActionListener(this);
         iWrap.setActionCommand("Wrap");
         menuFormat.add(iWrap);

         menuFont = new JMenu("Font");
         menuFormat.add(menuFont);

         iFontArial = new JMenuItem("Arial");
         iFontArial.addActionListener(this);
         iFontArial.setActionCommand("Arial");
         menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);


         menuFontSize = new JMenu("Font Size");
         menuFormat.add(menuFontSize);

         iFontSize8 = new JMenuItem("8");
         iFontSize8.addActionListener(this);
         iFontSize8.setActionCommand("size8");
         menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20 .addActionListener(this);
        iFontSize20 .setActionCommand("size20 ");
        menuFontSize.add(iFontSize20 );

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);


    }

    public void createColorMenu()
    {
         iColor1 = new JMenuItem("White");
         iColor1.addActionListener(this);
         iColor1.setActionCommand("White");
         menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);


    }

    public void createEditMenu()
    {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);

    }

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch(command)
        {
            case "New" :
                TextEditor e1 = new TextEditor();
                //file.newFile();
                break;

            case "Open" :
                file.open();
                break;

            case "SaveAs" :
                file.saveAs();
                break;

            case "Save" :
                file.save();
                break;

            case "Exit" :
                file.exit();
                break;

            case "Wrap" :
                format.wordWrap();
                break;

            case "size8":
                format.createFont(8);
                break;

            case "size12":
                format.createFont(12);
                break;

            case "size16":
                format.createFont(16);
                break;

            case "size20":
                format.createFont(20);
                break;

            case "size24":
                format.createFont(24);
                break;

            case "Arial":
                format.setFont("Arial");
                break;

            case "Comic Sans MS":
                format.setFont("Comic Sans MS");
                break;

            case "Times New Roman":
                format.setFont("Times New Roman");
                break;

            case "White" :
                color.changeColor(command);
                break;

            case "Black" :
                color.changeColor(command);
                break;

            case "Blue" :
                color.changeColor(command);
                break;

            case "Undo" :
                edit.undo();
                break;

            case "Redo" :
                edit.redo();
                break;

        }
    }


    public static void main(String[] args) {

        new TextEditor();
    }
}