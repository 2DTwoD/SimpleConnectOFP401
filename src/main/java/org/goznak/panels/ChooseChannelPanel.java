package org.goznak.panels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.goznak.Main;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
@Component
public class ChooseChannelPanel extends Parent implements Initializable {
    @FXML
    Button channel1Button;
    @FXML
    Button channel2Button;
    @FXML
    Button channel3Button;
    private final Stage stage1 = new Stage();
    private final Stage stage2 = new Stage();
    private final Stage stage3 = new Stage();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader1 = Main.getPanel("ChannelPanel.fxml");
            FXMLLoader loader2 = Main.getPanel("ChannelPanel.fxml");
            FXMLLoader loader3 = Main.getPanel("ChannelPanel.fxml");
            newStage(stage1, loader1, 1);
            newStage(stage2, loader2, 2);
            newStage(stage3, loader3, 3);
            channel1Button.setOnAction(event -> {
                stage1.show();
            });
            channel2Button.setOnAction(event -> {
                stage2.show();
            });
            channel3Button.setOnAction(event -> {
                stage3.show();
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void newStage(Stage stage, FXMLLoader loader, int channel) throws IOException {
        Scene scene = new Scene(loader.load());
        ((ChannelPanel) loader.getController()).setChannel(channel);
        stage.setTitle("Канал " + channel);
        stage.setScene(scene);
    }
}
