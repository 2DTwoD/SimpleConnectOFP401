package org.goznak.panels;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import jssc.SerialPortList;
import org.goznak.models.DataFromSensor;
import org.goznak.tools.ConnectTool;
import org.goznak.tools.Dialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ConnectPanel extends Parent implements Initializable {
    @Autowired
    ConnectTool connectTool;
    @Autowired
    DataFromSensor dataFromSensor;
    ScheduledExecutorService executorService;
    ObservableList<String> comList = FXCollections.observableArrayList(SerialPortList.getPortNames());
    ObservableList<Integer> baudRateList = FXCollections.observableArrayList(4800, 9600, 19200, 38400, 57600, 115200);
    boolean connectedAux = false;
    @FXML
    public Label comLabel;
    @FXML
    public Label baudRateLabel;
    @FXML
    public ComboBox<String> comCombo;
    @FXML
    public ComboBox<Integer> baudRateCombo;
    @FXML
    public Button connectButton;
    @FXML
    public Button disconnectButton;
    @FXML
    Label statusLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comCombo.setItems(comList);
        if(!comList.isEmpty()) {
            comCombo.setValue(comList.get(1));
        } else {
            comCombo.setValue("Нет портов для подключения");
        }
        baudRateCombo.setItems(baudRateList);
        baudRateCombo.setValue(baudRateList.get(3));
        setComPort();
        setBaudRate();
        comCombo.setOnAction(e -> setComPort());
        baudRateCombo.setOnAction(e -> setBaudRate());
        connectButton.setOnAction(e -> connect());
        disconnectButton.setOnAction(e -> disconnect());
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                Platform.runLater(this::runTime);
            }
            catch(Exception e){
                Platform.runLater(() -> Dialog.getFullError(e));
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }
    private void runTime(){
        boolean connected = connectTool.connected() || connectedAux;
        String status = connected? "Подключено": "Не подключено";
        statusLabel.setText(status);
        String color = connected? "green": "red";
        statusLabel.setStyle("-fx-background-color: " + color);
        connectButton.setDisable(connected);
        disconnectButton.setDisable(!connected);
        comCombo.setDisable(connected);
        baudRateCombo.setDisable(connected);
        connectedAux = connectTool.connected();
    }
    private void setComPort(){
        connectTool.setComPort(comCombo.getValue());
    }
    private void setBaudRate(){
        connectTool.setBaudRate(baudRateCombo.getValue());
    }
    public void connect(){
        if(!connectTool.connected()) {
            connectTool.connect();
        }
    }
    public void disconnect(){
        if(connectTool.connected()) {
            connectTool.disconnect();
        }
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
}
