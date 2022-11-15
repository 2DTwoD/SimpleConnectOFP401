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
    private Rectangle colorRectangle;
    @FXML
    Label colorTitle;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        opModeCombo.setItems(DataFromSensor.opModeList);
        filterCombo.setItems(DataFromSensor.filterList);
        lightCombo.setItems(DataFromSensor.lightList);
        fpModeCombo.setItems(DataFromSensor.fpModeList);
        menuCombo.setItems(DataFromSensor.menuList);
        opModeCombo.setValue("?");
        filterCombo.setValue("?");
        lightCombo.setValue("?");
        fpModeCombo.setValue("?");
        menuCombo.setValue("?");
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                Platform.runLater(this::runTime);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }
    private void runTime(){
        QueryStatus sensorStatus = dataFromSensor.getQueryStatus();
        String[] rgb = dataFromSensor.getRGB();
        String[] hsl = dataFromSensor.getHSL();
        String[] xyz = dataFromSensor.getXYZ();
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
        colorRectangle.setFill(dataFromSensor.getPaintFromXYZ());
        Color clr = hslInt[5] > 50? Color.BLACK: Color.WHITE;
        colorTitle.setTextFill(clr);
        statusField.setText(sensorStatus.getDirty());
        errorField.setText(sensorStatus.getError());
        String color = sensorStatus.isA1status()? "green": "lightgray";
        A1label.setStyle("-fx-background-color: " + color);
        color = sensorStatus.isA2status()? "green": "lightgray";
        A2label.setStyle("-fx-background-color: " + color);
        color = sensorStatus.isA3status()? "green": "lightgray";
        A3label.setStyle("-fx-background-color: " + color);
        rField.setText(rgb[0]);
        gField.setText(rgb[1]);
        bField.setText(rgb[2]);
        hrField.setText(hsl[0]);
        hgField.setText(hsl[1]);
        hbField.setText(hsl[2]);
        hueField.setText(hsl[3]);
        sField.setText(hsl[4]);
        lField.setText(hsl[5]);
        xrField.setText(xyz[0]);
        ygField.setText(xyz[1]);
        zbField.setText(xyz[2]);
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
        //dataFromSensor.getImpulse();
    }
    @FXML
    public void setOpMode(){
        dataFromSensor.setOpMode(opModeCombo.getValue());
    }
    @FXML
    public void setFilter(){
        dataFromSensor.setFilter(filterCombo.getValue());
    }
    @FXML
    public void setLight(){
        dataFromSensor.setLight(lightCombo.getValue());
    }
    @FXML
    public void setFpMode(){
        dataFromSensor.setFpMode(fpModeCombo.getValue());
    }
    @FXML
    public void setMenu(){
        dataFromSensor.setMenu(menuCombo.getValue());
    }
    @FXML
    public void resetSensor(){
        dataFromSensor.reset();
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
}
