package org.goznak.inputs;

import javafx.scene.control.TextField;

public class NumericTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
        lengthLimit();
    }
    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
        lengthLimit();
    }
    private boolean validate(String text)
    {
        return text.matches("\\d*");
    }
    private void lengthLimit() {
        if (getText().length() > 5) {
            int caretPosition  = getCaretPosition();
            setText(getText().substring(0, 5));
            positionCaret(caretPosition);
        }
    }
}
