package org.goznak.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import jssc.SerialPortList;
import org.goznak.Main;

public class ConnectSettingsPanel{
    Main main;
    ObservableList<String> comList = FXCollections.observableArrayList(SerialPortList.getPortNames());
    ObservableList<Integer> baudRateList = FXCollections.observableArrayList(4800, 9600, 19200, 38400, 57600, 115200);
    @FXML
    Label comLabel = new Label("COM порт для подключения:");
    @FXML
    Label baudRateLabel = new Label("Baud rate:");
    @FXML
    ComboBox<String> comCombo = new ComboBox<>(comList);
    @FXML
    ComboBox<Integer> baudRateCombo = new ComboBox<>(baudRateList);
    @FXML
    Button connectButton = new Button("Подключиться");
    @FXML
    Button disconnectButton = new Button("Отключиться");
//    public ConnectSettingsPanel(Main main) {
//        //super();
//        this.main = main;
//        if(comList.isEmpty()){
//            comList.add("no available ports");
//        }
//        /*comCombo.setPrefWidth(200);
//        baudRateCombo.setPrefWidth(200);
//        comCombo.setValue(comList.get(0));
//        baudRateCombo.setValue(baudRateList.get(3));
//        add(comLabel, 0, 0);
//        add(comCombo, 1, 0);
//        add(baudRateLabel, 0, 1);
//        add(baudRateCombo, 1, 1);
//        add(connectButton, 0, 2);
//        add(disconnectButton, 1, 2);
//        setMinWidth(main.scene.getWidth());
//        setAlignment(Pos.TOP_LEFT);*/
//    }
    public String getPort(){
        return comCombo.getValue();
    }
    public Integer getBaudRate(){
        return baudRateCombo.getValue();
    }
}
