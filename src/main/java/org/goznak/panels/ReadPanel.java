package org.goznak.panels;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.goznak.models.DataFromSensor;
import org.goznak.models.QueryStatus;
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
public class ReadPanel extends Parent implements Initializable {
    @Autowired
    DataFromSensor dataFromSensor;
    @Autowired
    ConnectTool connectTool;
    ScheduledExecutorService executorService;
    @FXML
    private TextField rField;
    @FXML
    private TextField gField;
    @FXML
    private TextField bField;
    @FXML
    private TextField hrField;
    @FXML
    private TextField hgField;
    @FXML
    private TextField hbField;
    @FXML
    private TextField hueField;
    @FXML
    private TextField sField;
    @FXML
    private TextField lField;
    @FXML
    private TextField xrField;
    @FXML
    private TextField ygField;
    @FXML
    private TextField zbField;
    @FXML
    Label statusField;
    @FXML
    Label errorField;
    @FXML
    Label A1label;
    @FXML
    Label A2label;
    @FXML
    Label A3label;
    @FXML
    Label softwareLabel;
    @FXML
    Label groupLabel;
    @FXML
    Label selectLabel;
    @FXML
    ProgressBar redProgress;
    @FXML
    ProgressBar greenProgress;
    @FXML
    ProgressBar blueProgress;
    @FXML
    ProgressBar hueProgress;
    @FXML
    ProgressBar satProgress;
    @FXML
    ProgressBar lightProgress;
    @FXML
    ProgressBar redxProgress;
    @FXML
    ProgressBar greenyProgress;
    @FXML
    ProgressBar bluezProgress;
    @FXML
    ProgressBar redHueProgress;
    @FXML
    ProgressBar greenHueProgress;
    @FXML
    ProgressBar blueHueProgress;
    @FXML
    Label opModeLabel;
    @FXML
    ComboBox<String> opModeCombo;
    @FXML
    Button opModeButton;
    @FXML
    Label filterLabel;
    @FXML
    ComboBox<String> filterCombo;
    @FXML
    Button filterButton;
    @FXML
    Label lightLabel;
    @FXML
    ComboBox<String> lightCombo;
    @FXML
    Button lightButton;
    @FXML
    Label fpModeLabel;
    @FXML
    ComboBox<String> fpModeCombo;
    @FXML
    Button fpModeButton;
    @FXML
    Label menuLabel;
    @FXML
    ComboBox<String> menuCombo;
    @FXML
    Button menuButton;
    @FXML
    Button resetButton;
    @FXML
    Rectangle rgbRectangle;
    @FXML
    Rectangle hslRectangle;
    @FXML
    Rectangle xyzRectangle;
    @FXML
    Label rgbLabel;
    @FXML
    Label hslLabel;
    @FXML
    Label xyzLabel;
    @FXML
    Button helpButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        opModeCombo.setItems(DataFromSensor.getOpModeList());
        filterCombo.setItems(DataFromSensor.getFilterList());
        lightCombo.setItems(DataFromSensor.getLightList());
        fpModeCombo.setItems(DataFromSensor.getFpModeList());
        menuCombo.setItems(DataFromSensor.getMenuList());
        opModeCombo.setValue("?");
        filterCombo.setValue("?");
        lightCombo.setValue("?");
        fpModeCombo.setValue("?");
        menuCombo.setValue("?");
        executorService = Executors.newSingleThreadScheduledExecutor();
        helpButton.setOnAction(e -> Dialog.getHelp());
        executorService.scheduleAtFixedRate(() -> {
            try {
                Platform.runLater(this::runTime);
            }
            catch(Exception e){
                Platform.runLater(() -> Dialog.getError(e));
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }
    private void runTime(){
        QueryStatus sensorStatus = dataFromSensor.getQueryStatus();
        int[] rgbInt = dataFromSensor.getIntRGB();
        int[] hslInt = dataFromSensor.getIntHSL();
        int[] xyzInt = dataFromSensor.getIntXYZ();
        String[] sensorType = dataFromSensor.getSensorType();
        String opMode = dataFromSensor.getOpMode();
        String filterSize = dataFromSensor.getFilterSize();
        String emittedLight = dataFromSensor.getLight();
        String fpMode = dataFromSensor.getFpMode();
        String expertMenu = dataFromSensor.getMenu();
        dataFromSensor.getQueryStatus();
        statusField.setText(sensorStatus.getDirty());
        errorField.setText(sensorStatus.getError());
        String color = sensorStatus.isA1status()? "green": "lightgray";
        A1label.setStyle("-fx-background-color: " + color);
        color = sensorStatus.isA2status()? "green": "lightgray";
        A2label.setStyle("-fx-background-color: " + color);
        color = sensorStatus.isA3status()? "green": "lightgray";
        A3label.setStyle("-fx-background-color: " + color);
        rField.setText(String.valueOf(rgbInt[0]));
        gField.setText(String.valueOf(rgbInt[1]));
        bField.setText(String.valueOf(rgbInt[2]));
        hrField.setText(String.valueOf(hslInt[0]));
        hgField.setText(String.valueOf(hslInt[1]));
        hbField.setText(String.valueOf(hslInt[2]));
        hueField.setText(String.valueOf(hslInt[3]));
        sField.setText(String.valueOf(hslInt[4]));
        lField.setText(String.valueOf(hslInt[5]));
        xrField.setText(String.valueOf(xyzInt[0]));
        ygField.setText(String.valueOf(xyzInt[1]));
        zbField.setText(String.valueOf(xyzInt[2]));
        softwareLabel.setText(sensorType[0]);
        groupLabel.setText(sensorType[1]);
        selectLabel.setText(sensorType[2]);
        redProgress.setProgress(rgbInt[0] / 255.0);
        greenProgress.setProgress(rgbInt[1] / 255.0);
        blueProgress.setProgress(rgbInt[2] / 255.0);
        redxProgress.setProgress(xyzInt[0] / 511.0);
        greenyProgress.setProgress(xyzInt[1] / 511.0);
        bluezProgress.setProgress(xyzInt[2] / 511.0);
        redHueProgress.setProgress(hslInt[0] / 511.0);
        greenHueProgress.setProgress(hslInt[1] / 511.0);
        blueHueProgress.setProgress(hslInt[2] / 511.0);
        hueProgress.setProgress(hslInt[3] / 360.0);
        satProgress.setProgress(hslInt[4] / 100.0);
        lightProgress.setProgress(hslInt[5] / 100.0);
        opModeLabel.setText(opMode);
        filterLabel.setText(filterSize);
        lightLabel.setText(emittedLight);
        fpModeLabel.setText(fpMode);
        menuLabel.setText(expertMenu);
        rgbRectangle.setFill(dataFromSensor.getPaintFromRGB());
        hslRectangle.setFill(dataFromSensor.getPaintFromHSL());
        xyzRectangle.setFill(dataFromSensor.getPaintFromXYZ());
        Color clr = hslInt[5] > 50? Color.BLACK: Color.WHITE;
        rgbLabel.setTextFill(clr);
        hslLabel.setTextFill(clr);
        xyzLabel.setTextFill(clr);
    }
    @FXML
    public void setOpMode(){
        String value = opModeCombo.getValue();
        if(badFirstConditionDialog(value, "Изменить режим работы датчика на значение '"+ value + "'?")){
            return;
        }
        dataFromSensor.setOpMode(value);
    }
    @FXML
    public void setFilter(){
        String value = filterCombo.getValue();
        if(badFirstConditionDialog(value, "Изменить фильтрацию сигнала датчика на значение '"+ value + "'?")){
            return;
        }
        dataFromSensor.setFilter(value);
    }
    @FXML
    public void setLight(){
        String value = lightCombo.getValue();
        if(badFirstConditionDialog(value, "Изменить излучение датчика на значение '"+ value + "'?")){
            return;
        }
        dataFromSensor.setLight(value);
    }
    @FXML
    public void setFpMode(){
        String value = fpModeCombo.getValue();
        if(badFirstConditionDialog(value, "Изменить тип датчика на значение '"+ value + "'?")){
            return;
        }
        dataFromSensor.setFpMode(fpModeCombo.getValue());
    }
    @FXML
    public void setMenu(){
        String value = menuCombo.getValue();
        String experMenu = value.equals(DataFromSensor.getMenuList().get(0))?
                "Выключить экспертное меню датчика?":
                "Включить экспертное меню датчика?";
        if(badFirstConditionDialog(value, experMenu)){
            return;
        }
        dataFromSensor.setMenu(menuCombo.getValue());
    }
    @FXML
    public void resetSensor(){
        if(!connectTool.connected() || !Dialog.getConfirm("Произвести сброс настроек датчика?")){
            return;
        }
        dataFromSensor.reset();
    }
    private boolean badFirstConditionDialog(String value, String message){
        if(!connectTool.connected()){
            return true;
        }
        if(value.equals(DataFromSensor.UNKNOWN_SYMBOL)){
            Dialog.getInformation("Выберите значение прежде чем применять");
            return true;
        }
        if(!Dialog.getConfirm(message)){
            return true;
        }
        return false;
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
}
