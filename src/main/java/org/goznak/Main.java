package org.goznak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.goznak.models.DataFromSensor;
import org.goznak.panels.ConnectSettingsPanel;
import org.goznak.panels.ReadParametersPanel;
import org.goznak.tools.CommandList;
import org.goznak.tools.ConnectTool;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    public VBox root = new VBox();
    public Scene scene = new Scene(root, 800, 600);

    public ConnectTool connectTool;
    public ConnectSettingsPanel connectSettingsPanel;
    public ReadParametersPanel readParametersPanel;
    public DataFromSensor dataFromSensor;
    @Override
    public void start(Stage stage) throws IOException {
        dataFromSensor = new DataFromSensor();
        readParametersPanel = new ReadParametersPanel(this);
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ConnectSettingsPanel.fxml"));*/
        URL url = getClass().getResource("ConnectSettingsPanel.fxml");
        if(url != null) {
            connectSettingsPanel = FXMLLoader.load(url);
        }
        connectTool = new ConnectTool(this);
        //connectTool.connect();
        stage.setTitle("SimpleConnect for OFP401P0189!");
        stage.setScene(scene);
        root.getChildren().addAll(connectSettingsPanel, readParametersPanel);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        connectTool.disconnect();
        readParametersPanel.stopAllThreads();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}