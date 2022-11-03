package org.goznak.inputs;

import javafx.scene.control.TextField;

public class ViewTextField extends TextField {
    public ViewTextField() {
        super();
        setEditable(false);
        setMouseTransparent(true);
        setFocusTraversable(false);
    }
}
