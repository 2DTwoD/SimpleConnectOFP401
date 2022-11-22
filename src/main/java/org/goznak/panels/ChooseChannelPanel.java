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
    ChannelPanel channel1Panel;
    ChannelPanel channel2Panel;
    ChannelPanel channel3Panel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            channel1Panel = newChannelPanel(1, channel1Button);
            channel2Panel = newChannelPanel(2, channel2Button);
            channel3Panel = newChannelPanel(3, channel3Button);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private ChannelPanel newChannelPanel(int channel, Button channelButton) throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = Main.getPanelLoader("ChannelPanel.fxml");
        Scene scene = new Scene(loader.load());
        ChannelPanel controller = loader.getController();
        controller.setChannel(channel);
        stage.setTitle("Канал " + channel);
        stage.setScene(scene);
        stage.setResizable(false);
        channelButton.setOnAction(event ->stage.show());
        return controller;
    }
    public void stopAllThreads(){
        channel1Panel.stopAllThreads();
        channel2Panel.stopAllThreads();
        channel3Panel.stopAllThreads();
    }
}
