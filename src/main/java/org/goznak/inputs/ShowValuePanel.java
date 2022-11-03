package org.goznak.inputs;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ShowValuePanel extends HBox {
    Label label;
    ViewTextField field;
    public ShowValuePanel(String name, int width) {
        super();
        label = new Label(name);
        field = new ViewTextField();
        field.setPrefWidth(width);
        getChildren().addAll(label, field);
    }
    public void setText(String text){
        field.setText(text);
    }
}
