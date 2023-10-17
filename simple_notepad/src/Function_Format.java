import java.awt.Font;
public class Function_Format {

    TextEditor textEditor;
    Font arial,comicSansMS,timesNewRoman;

     String selectedFont;
   public Function_Format(TextEditor textEditor)
   {
       this.textEditor = textEditor;
   }
   public void wordWrap()
   {
       if(textEditor.wordWrapOn==false)
       {
          textEditor.wordWrapOn = true;
          textEditor.textArea.setLineWrap(true);
          textEditor.textArea.setWrapStyleWord(true);
          textEditor.iWrap.setText("Word Wrap: On");
       }
       else
       {
          textEditor.wordWrapOn = false;
          textEditor.textArea.setLineWrap(false);
          textEditor.textArea.setWrapStyleWord(false);
          textEditor.iWrap.setText("Word Wrap: Off");
       }
   }

   public void createFont(int fontSize)
    {
        arial = new Font("Arial",Font.PLAIN,fontSize);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN,fontSize);
        timesNewRoman = new Font("Times New Roman",Font.PLAIN,fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font)
    {
        selectedFont = font;

        switch(selectedFont)
        {
            case "Arial" :
                textEditor.textArea.setFont(arial);
                break;

            case "Comic Sans MS" :
                textEditor.textArea.setFont(comicSansMS);
                break;

            case "Times New Roman" :
                textEditor.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
