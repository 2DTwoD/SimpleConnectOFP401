package org.goznak.inputs;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.function.Supplier;

public class ShowValuePanel extends HBox {
    Label label;
    ViewTextField field;
    Supplier<String> parameter;
    public ShowValuePanel(String name, int width, Supplier<String> parameter) {
        super();
        label = new Label(name);
        field = new ViewTextField();
        field.setPrefWidth(width);
        getChildren().addAll(label, field);
        this.parameter = parameter;
    }
    public ShowValuePanel(String name, int width1, int width2, Supplier<String> parameter) {
        super();
        label = new Label(name);
        field = new ViewTextField();
        field.setPrefWidth(width1);
        label.setPrefWidth(width2);
        getChildren().addAll(label, field);
        this.parameter = parameter;
    }
    public ShowValuePanel(String name, int width1, int width2, Color lColor, Color tColor, Supplier<String> parameter) {
        super();
        label = new Label(name);
        field = new ViewTextField();
        field.setPrefWidth(width1);
        field.setStyle("-fx-text-inner-color: red;");
        label.setPrefWidth(width2);
        label.setTextFill(lColor);
        getChildren().addAll(label, field);
        this.parameter = parameter;
    }
    public void update(){
        field.setText(parameter.get());
    }
}
