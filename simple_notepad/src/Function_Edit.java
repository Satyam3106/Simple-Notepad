public class Function_Edit {
    TextEditor textEditor;
    public Function_Edit(TextEditor textEditor)
    {
        this.textEditor = textEditor;
    }
    public void undo()
    {
        textEditor.um.undo();
    }
    public void redo()
    {
        textEditor.um.redo();
    }
}
