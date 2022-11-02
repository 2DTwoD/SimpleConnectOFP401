package org.goznak.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import jssc.SerialPort;
import jssc.SerialPortList;
import org.goznak.Main;

public class ConnectSettingsPanel extends GridPane {
    Main main;
    ObservableList<String> comList = FXCollections.observableArrayList(SerialPortList.getPortNames());
    ObservableList<Integer> baudRateList = FXCollections.observableArrayList(4800, 9600, 19200, 38400, 57600, 115200);
    Label comLabel = new Label("COM порт для подключения:");
    Label baudRateLabel = new Label("Baud rate:");
    ComboBox<String> comCombo = new ComboBox<>(comList);
    ComboBox<Integer> baudRateCombo = new ComboBox<>(baudRateList);
    Button connectButton = new Button("Подключиться");
    Button disconnectButton = new Button("Отключиться");
    public ConnectSettingsPanel(Main main) {
        super();
        this.main = main;
        if(comList.isEmpty()){
            comList.add("no available ports");
        }
        comCombo.setPrefWidth(200);
        baudRateCombo.setPrefWidth(200);
        comCombo.setValue(comList.get(0));
        baudRateCombo.setValue(baudRateList.get(3));
        add(comLabel, 0, 0);
        add(comCombo, 1, 0);
        add(baudRateLabel, 0, 1);
        add(baudRateCombo, 1, 1);
        add(connectButton, 0, 2);
        add(disconnectButton, 1, 2);
        setMinWidth(main.scene.getWidth());
        setAlignment(Pos.TOP_LEFT);
    }
    public String getPort(){
        return comCombo.getValue();
    }
    public Integer getBaudRate(){
        return baudRateCombo.getValue();
    }
}
