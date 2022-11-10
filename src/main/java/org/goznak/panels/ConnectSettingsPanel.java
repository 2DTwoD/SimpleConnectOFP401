package org.goznak.panels;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class ConnectSettingsPanel extends Parent implements Initializable {
    @Autowired
    ConnectTool connectTool;
    @Autowired
    DataFromSensor dataFromSensor;
    ObservableList<String> comList = FXCollections.observableArrayList(SerialPortList.getPortNames());
    ObservableList<Integer> baudRateList = FXCollections.observableArrayList(4800, 9600, 19200, 38400, 57600, 115200);
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
    public String getPort(){
        return comCombo.getValue();
    }
    public Integer getBaudRate(){
        return baudRateCombo.getValue();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comCombo.setItems(comList);
        comCombo.setValue(comList.get(0));
        baudRateCombo.setItems(baudRateList);
        baudRateCombo.setValue(baudRateList.get(3));
        System.out.println(dataFromSensor);
    }
}
