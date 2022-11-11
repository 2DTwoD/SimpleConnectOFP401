package org.goznak.panels;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
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
    private Rectangle rect;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        int[] rgbFromHsl = dataFromSensor.getRGBFromHSL();
        QueryStatus sensorStatus = dataFromSensor.getQueryStatus();
        String[] rgb = dataFromSensor.getRGB();
        String[] hsl = dataFromSensor.getHSL();
        String[] xyz = dataFromSensor.getXYZ();
        String[] sensorType = dataFromSensor.getSensorType();
        dataFromSensor.getQueryStatus();
        colorRectangle.setFill(dataFromSensor.getPaintFromHSL());
        rect.setFill(dataFromSensor.getPaintFromRGB());
        if(!hsl[3].equals("NOK")){
            Color color = Integer.decode("0x" + hsl[4]) > 256? Color.BLACK: Color.WHITE;
            colorTitle.setTextFill(color);
        }
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
        sField.setText(hsl[3]);
        lField.setText(hsl[4]);
        xrField.setText(xyz[0]);
        ygField.setText(xyz[1]);
        zbField.setText(xyz[2]);
        softwareLabel.setText(sensorType[0]);
        groupLabel.setText(sensorType[1]);
        selectLabel.setText(sensorType[2]);
        redProgress.setProgress(rgbFromHsl[0] / 255.0);
        greenProgress.setProgress(rgbFromHsl[1] / 255.0);
        blueProgress.setProgress(rgbFromHsl[2] / 255.0);
        //dataFromSensor.getImpulse();
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
}
