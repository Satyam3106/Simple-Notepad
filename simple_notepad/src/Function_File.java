import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
TextEditor textEditor;
String fileName;
String fileAddress;

public Function_File(TextEditor textEditor)
{
    this.textEditor = textEditor;
}
public void newFile()
{
    textEditor.textArea.setText("");
    textEditor.window.setTitle("New");
    fileName = null;
    fileAddress = null;
}
public void open()
{
    FileDialog fd = new FileDialog(textEditor.window,"Open",FileDialog.LOAD);
    fd.setVisible(true);

    if(fd.getFile()!=null)
    {
        fileName = fd.getFile();
        fileAddress = fd.getDirectory();
        textEditor.window.setTitle(fileName);
    }
    System.out.println("file Address and file name "+fileAddress +fileName);
    try
    {
        // you need address to read a file
        BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
        textEditor.textArea.setText("");
        String line = null;
        while((line=br.readLine())!=null)
            textEditor.textArea.append(line+"\n");
        br.close();
    }
    catch(Exception e)
    {
        System.out.println("File not opened");
    }
}

public void  save()
{
    if(fileName==null)
        saveAs();
    else
    {
        try
        {
        FileWriter fw = new FileWriter(fileAddress+fileName);
        fw.write(textEditor.textArea.getText());
        textEditor.window.setTitle(fileName);
        fw.close();
       }
        catch(Exception e)
        {
            System.out.println("SOMETHING WRONG");
        }
}}

public void saveAs()
{
    FileDialog fd = new FileDialog(textEditor.window,"Save",FileDialog.SAVE);
    fd.setVisible(true);
    if(fd.getFile()!=null)
    {
        fileName = fd.getFile();
        fileAddress = fd.getDirectory();
        textEditor.window.setTitle(fileName);
    }
    try
    {
        FileWriter fw = new FileWriter(fileAddress+fileName);
        fw.write(textEditor.textArea.getText());
        fw.close();

    }
    catch(Exception e)
    {
        System.out.println("SOMETHING WRONG");
    }
}

public void exit()
{
    System.exit(0);
}

}
