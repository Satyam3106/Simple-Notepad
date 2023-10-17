import java.awt.Color;

public class Function_Color {

    TextEditor textEditor;

    public Function_Color(TextEditor textEditor)
    {
        this.textEditor = textEditor;
    }
    public void changeColor(String color)
    {
          switch (color)
          {
              case "White":
                  textEditor.window.getContentPane().setBackground(Color.white);
                  textEditor.textArea.setBackground(Color.white);
                  textEditor.textArea.setForeground(Color.black);
                  break;

              case "Black":
                  textEditor.window.getContentPane().setBackground(Color.black);
                  textEditor.textArea.setBackground(Color.black);
                  textEditor.textArea.setForeground(Color.white);
                  break;

              case "Blue":
                  textEditor.window.getContentPane().setBackground(Color.blue);
                  textEditor.textArea.setBackground(Color.blue);
                  textEditor.textArea.setForeground(Color.white);
                  break;
          }
    }
}
