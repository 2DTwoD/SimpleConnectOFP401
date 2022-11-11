package org.goznak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.goznak.config.AppConfig;
import org.goznak.models.DataFromSensor;
import org.goznak.panels.ConnectPanel;
import org.goznak.panels.ReadPanel;
import org.goznak.tools.ConnectTool;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.util.ArrayList;

public class Main extends Application {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    public VBox root = new VBox();
    public Scene scene = new Scene(root, 800, 600);
    private final ArrayList<Parent> panels = new ArrayList<>();
    public Parent connectPanel;
    public Parent readPanel;
    @Override
    public void start(Stage stage) throws Exception {
        connectPanel = getPanelForMainScreen("ConnectPanel.fxml");
        readPanel = getPanelForMainScreen("ReadPanel.fxml");
        //connectTool = new ConnectTool(this);
        //connectTool.connect();
        stage.setTitle("SimpleConnect for OFP401P0189!");
        stage.setScene(scene);
        root.getChildren().addAll(panels);
        stage.show();
    }

    private Parent getPanelForMainScreen(String name) throws Exception {
        URL url = getClass().getResource("fxml/" + name);
        if(url == null) {
            throw new Exception("bad URL for .fxml");
        }
        FXMLLoader loader = new FXMLLoader(url);
        loader.setControllerFactory(context::getBean);
        panels.add(loader.load());
        return loader.getController();
    }
//    public static Parent getPanel(String name) throws Exception {
//        URL url = Main.class.getResource("fxml/" + name);
//        if(url == null) {
//            throw new Exception("bad URL for .fxml");
//        }
//        FXMLLoader loader = new FXMLLoader(url);
//        return loader.getController();
//    }

    @Override
    public void stop() throws Exception {
        ((ReadPanel) readPanel).stopAllThreads();
        ((ConnectPanel) connectPanel).disconnect();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}