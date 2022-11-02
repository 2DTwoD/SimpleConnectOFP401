package org.goznak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.goznak.models.DataFromSensor;
import org.goznak.panels.ConnectSettingsPanel;
import org.goznak.panels.ReadParametersPanel;
import org.goznak.tools.CommandList;
import org.goznak.tools.ConnectTool;

import java.io.IOException;

public class Main extends Application {
    public VBox root = new VBox();
    public Scene scene = new Scene(root, 800, 600);

    public CommandList commandList = new CommandList();
    public ConnectTool connectTool;
    public ConnectSettingsPanel connectSettingsPanel;
    public ReadParametersPanel readParametersPanel;
    public DataFromSensor dataFromSensor;

    @Override
    public void start(Stage stage) throws IOException {
        dataFromSensor = new DataFromSensor();
        connectSettingsPanel = new ConnectSettingsPanel(this);
        readParametersPanel = new ReadParametersPanel(this);
        connectTool = new ConnectTool(this);
        connectTool.connect();
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