package org.goznak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.goznak.config.AppConfig;
import org.goznak.panels.ChooseChannelPanel;
import org.goznak.panels.ConnectPanel;
import org.goznak.panels.ReadPanel;
import org.goznak.tools.Dialog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.util.ArrayList;

public class Main extends Application {
    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    public VBox root = new VBox();
    public Scene scene = new Scene(root, 800, 440);
    private final ArrayList<Parent> panels = new ArrayList<>();
    public Parent connectPanel;
    public Parent readPanel;
    public Parent choosePanel;
    @Override
    public void start(Stage stage) throws Exception {
        connectPanel = getPanelForMainScreen("ConnectPanel.fxml");
        readPanel = getPanelForMainScreen("ReadPanel.fxml");
        choosePanel = getPanelForMainScreen("ChooseChannelPanel.fxml");
        stage.setTitle("SimpleConnect for OFP401P0189");
        stage.setScene(scene);
        stage.setResizable(false);
        root.getChildren().addAll(panels);
        stage.setOnCloseRequest(e -> {
            if(!Dialog.getConfirm("Вы действительно хотите закрыть программу?")){
                e.consume();
                return;
            }
            ((ChooseChannelPanel)choosePanel).closeAllWindows();
        });
        stage.show();
    }

    private Parent getPanelForMainScreen(String name) throws Exception {
        FXMLLoader loader = getPanelLoader(name);
        panels.add(loader.load());
        return loader.getController();
    }
    public static FXMLLoader getPanelLoader(String name) throws Exception {
        URL url = Main.class.getResource("fxml/" + name);
        if(url == null) {
            Exception e = new Exception("Неправильный путь до файла .fxml");
            Dialog.getError(e);
            throw e;
        }
        FXMLLoader loader = new FXMLLoader(url);
        loader.setControllerFactory(context::getBean);
        return loader;
    }

    @Override
    public void stop() throws Exception {
        ((ReadPanel) readPanel).stopAllThreads();
        ((ChooseChannelPanel) choosePanel).stopAllThreads();
        ((ConnectPanel) connectPanel).stopAllThreads();
        ((ConnectPanel) connectPanel).disconnect();
        super.stop();
    }

    public static AnnotationConfigApplicationContext getContext(){
        return context;
    }

    public static void main(String[] args) {
        launch();
    }
}