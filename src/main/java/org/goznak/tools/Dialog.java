package org.goznak.tools;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Dialog {
    private static Alert alert;
    public static void getInformation(String text){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    public static void getWarning(String text){
        try {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Внимание");
            alert.setHeaderText(null);
            alert.setContentText(text);
            alert.showAndWait();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean getConfirm(String text){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтвердите действие");
        alert.setHeaderText(null);
        alert.setContentText(text);
        return alert.showAndWait().get() == ButtonType.OK;
    }
    public static void getError(String text){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    public static void getFullError(Exception e){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Произошло исключение");
        alert.setHeaderText(null);
        alert.setContentText("Ошибка при выполнении программы");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String exceptionText = stringWriter.toString();
        Label label = new Label("Содержание ошибки:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }
}
