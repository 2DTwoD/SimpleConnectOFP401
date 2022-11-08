package org.goznak.panels;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.goznak.Main;
import org.goznak.inputs.ShowValuePanel;
import org.goznak.models.DataFromSensor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReadParametersPanel extends GridPane {
    ShowValuePanel softwareVersion = new ShowValuePanel("Software version", 50);
    ShowValuePanel sensorGroup = new ShowValuePanel("Sensor group", 50);
    ShowValuePanel sensorSelect = new ShowValuePanel("Sensor select", 50);
    ShowValuePanel rValue = new ShowValuePanel("Red:", 50);
    ShowValuePanel gValue = new ShowValuePanel("Green:", 50);
    ShowValuePanel bValue = new ShowValuePanel("Blue:", 50);
    ShowValuePanel hrValue = new ShowValuePanel("Hue red:", 50);
    ShowValuePanel hgValue = new ShowValuePanel("Hue green:", 50);
    ShowValuePanel hbValue = new ShowValuePanel("Hue blue:", 50);
    ShowValuePanel sValue = new ShowValuePanel("Saturation:", 50);
    ShowValuePanel lValue = new ShowValuePanel("Lightness:", 50);
    ShowValuePanel xValue = new ShowValuePanel("Compensated red (x):", 50);
    ShowValuePanel yValue = new ShowValuePanel("Compensated green (y):", 50);
    ShowValuePanel zValue = new ShowValuePanel("Compensated blue (z):", 50);
    Rectangle colorRectangle = new Rectangle(50, 50, Paint.valueOf("Black"));
    ScheduledExecutorService executorService;
    DataFromSensor dataFromSensor;
    public ReadParametersPanel(Main main) {
        super();
        dataFromSensor = main.dataFromSensor;
        setMinWidth(main.scene.getWidth());
        add(rValue, 0, 0);
        add(gValue, 0, 1);
        add(bValue, 0, 2);
        add(hrValue, 1, 0);
        add(hgValue, 1, 1);
        add(hbValue, 1, 2);
        add(sValue, 1, 3);
        add(lValue, 1, 4);
        add(xValue, 2, 0);
        add(yValue, 2, 1);
        add(zValue, 2, 2);
        add(colorRectangle, 0, 5);
        add(softwareVersion, 0, 6);
        add(sensorGroup, 0, 7);
        add(sensorSelect, 0, 8);
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                colorRectangle.setFill(dataFromSensor.getPaint());
                rValue.setText(dataFromSensor.getRGB()[0]);
                gValue.setText(dataFromSensor.getRGB()[1]);
                bValue.setText(dataFromSensor.getRGB()[2]);
                hrValue.setText(dataFromSensor.getHSL()[0]);
                hgValue.setText(dataFromSensor.getHSL()[1]);
                hbValue.setText(dataFromSensor.getHSL()[2]);
                sValue.setText(dataFromSensor.getHSL()[3]);
                lValue.setText(dataFromSensor.getHSL()[4]);
                xValue.setText(dataFromSensor.getXYZ()[0]);
                yValue.setText(dataFromSensor.getXYZ()[1]);
                zValue.setText(dataFromSensor.getXYZ()[2]);
                softwareVersion.setText(dataFromSensor.getSensorType()[0]);
                sensorGroup.setText(dataFromSensor.getSensorType()[1]);
                sensorSelect.setText(dataFromSensor.getSensorType()[2]);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
    public void stopAllThreads(){
        executorService.shutdownNow();
    }
}
