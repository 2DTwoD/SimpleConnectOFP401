package org.goznak.tools;

import javafx.scene.control.Alert;

public class Dialog {
    static Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public static void getInformation(String text){
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
