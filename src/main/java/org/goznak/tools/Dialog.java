package org.goznak.tools;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.goznak.App;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Dialog {
    private static Alert alert;
    public static void getInformation(String text){
        App.LOGGER.info("Вызвано окно информации: " + text);
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    public static void getHelp(){
        App.LOGGER.info("Вызвано окно помощь");
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Спасибо, что используете наше программное обеспечение");
        alert.setContentText("""
                Данная программа используется для подключению к датчику Wenglor OFP401P0189 по интерфейсу RS232
                Распиновка:
                Датчик ---- Dsub DB9
                3 ------------- 5 (0V)
                4 ------------- 2
                5 ------------- 3
                1 ------------- 24VDC
                Автор: Демьяненко Дмитрий Сергеевич""");
        alert.showAndWait();
    }
    public static void getWarning(String text){
        App.LOGGER.warn("Вызвано окно 'внимание': " + text);
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    public static boolean getConfirm(String text){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтвердите действие");
        alert.setHeaderText(null);
        alert.setContentText(text);
        boolean result = alert.showAndWait().get() == ButtonType.OK;
        String agree = result? "Подтверждено": "Отклонено";
        App.LOGGER.info("Вызвано окно подтверждения: " + text + ". Результат: " + agree);
        return result;
    }
    public static void getError(Exception e){
        App.LOGGER.error("Ошибка с уведомлением в окне:" + e.getMessage());
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
