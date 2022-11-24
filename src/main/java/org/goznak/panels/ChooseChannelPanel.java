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
    Stage channel1Stage;
    Stage channel2Stage;
    Stage channel3Stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            channel1Stage = new Stage();
            channel2Stage = new Stage();
            channel3Stage = new Stage();
            channel1Panel = newChannelPanel(1, channel1Button, channel1Stage);
            channel2Panel = newChannelPanel(2, channel2Button, channel2Stage);
            channel3Panel = newChannelPanel(3, channel3Button, channel3Stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private ChannelPanel newChannelPanel(int channel, Button channelButton, Stage stage) throws Exception {
        FXMLLoader loader = Main.getPanelLoader("ChannelPanel.fxml");
        Scene scene = new Scene(loader.load());
        ChannelPanel controller = loader.getController();
        controller.setChannel(channel);
        stage.setTitle("Канал A" + channel);
        stage.setScene(scene);
        stage.setResizable(false);
        channelButton.setOnAction(event ->{
            stage.show();
            stage.toFront();
        }
        );
        return controller;
    }
    public void stopAllThreads(){
        channel1Panel.stopAllThreads();
        channel2Panel.stopAllThreads();
        channel3Panel.stopAllThreads();
    }
    public void closeAllWindows(){
        channel1Stage.close();
        channel2Stage.close();
        channel3Stage.close();
    }
}
