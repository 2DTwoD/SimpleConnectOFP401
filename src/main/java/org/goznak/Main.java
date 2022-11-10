package org.goznak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.goznak.config.AppConfig;
import org.goznak.models.DataFromSensor;
import org.goznak.tools.ConnectTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.util.ArrayList;

public class Main extends Application {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    public VBox root = new VBox();
    public Scene scene = new Scene(root, 800, 600);

    private ArrayList<Parent> panels = new ArrayList<>();
    @Autowired
    public ConnectTool connectTool;
    public Parent connectSettingsPanel;
    public Parent readPanel;
    public DataFromSensor dataFromSensor;
    @Override
    public void start(Stage stage) throws Exception {
        dataFromSensor = new DataFromSensor();
        //readParametersPanel = new ReadParametersPanel(this);
        connectSettingsPanel = getPanel("ConnectSettingsPanel.fxml");
        readPanel = getPanel("ReadPanel.fxml");
        //connectTool = new ConnectTool(this);
        //connectTool.connect();
        stage.setTitle("SimpleConnect for OFP401P0189!");
        stage.setScene(scene);
        root.getChildren().addAll(panels);
        stage.show();
    }

    private Parent getPanel(String name) throws Exception {
        URL url = getClass().getResource("fxml/" + name);
        if(url == null) {
            throw new Exception("bad URL for .fxml");
        }
        FXMLLoader loader = new FXMLLoader(url);
        loader.setControllerFactory(ctx::getBean);
        Parent panel = loader.load();
        panels.add(panel);
        return panel;
    }

    @Override
    public void stop() throws Exception {
        //connectTool.disconnect();
        //readParametersPanel.stopAllThreads();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}