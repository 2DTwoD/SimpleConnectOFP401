package org.goznak.panels;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.goznak.Main;
import org.goznak.inputs.ShowValuePanel;
import org.goznak.models.DataFromSensor;

import java.util.concurrent.ScheduledExecutorService;

public class ReadParametersPanel extends GridPane {
    ScheduledExecutorService executorService;
    DataFromSensor dataFromSensor;
    Rectangle colorRectangle = new Rectangle(50, 50, Paint.valueOf("Black"));
    String[] rgb;
    String[] hsl;
    String[] xyz;
    String[] sensorType;
    public ReadParametersPanel(Main main) {
        super();
        rgb = dataFromSensor.getRGB();
        hsl = dataFromSensor.getHSL();
        xyz = dataFromSensor.getXYZ();
        sensorType = dataFromSensor.getSensorType();
        ShowValuePanel softwareVersion = new ShowValuePanel("Software version", 50, () -> sensorType[0]);
        ShowValuePanel sensorGroup = new ShowValuePanel("Sensor group", 50, () -> sensorType[1]);
        ShowValuePanel sensorSelect = new ShowValuePanel("Sensor select", 50, () -> sensorType[2]);
        ShowValuePanel rValue = new ShowValuePanel("Red:", 50,30, Color.RED, Color.RED, () -> rgb[0]);
        ShowValuePanel gValue = new ShowValuePanel("Green:", 50, () -> rgb[1]);
        ShowValuePanel bValue = new ShowValuePanel("Blue:", 50, () -> rgb[2]);
        ShowValuePanel hrValue = new ShowValuePanel("Hue red:", 50, () -> hsl[0]);
        ShowValuePanel hgValue = new ShowValuePanel("Hue green:", 50, () -> hsl[1]);
        ShowValuePanel hbValue = new ShowValuePanel("Hue blue:", 50, () -> hsl[2]);
        ShowValuePanel sValue = new ShowValuePanel("Saturation:", 50, () -> hsl[3]);
        ShowValuePanel lValue = new ShowValuePanel("Lightness:", 50, () -> hsl[4]);
        ShowValuePanel xValue = new ShowValuePanel("Comp. red (x):", 50, () -> xyz[0]);
        ShowValuePanel yValue = new ShowValuePanel("Comp. green (y):", 50, () -> xyz[1]);
        ShowValuePanel zValue = new ShowValuePanel("Comp. blue (z):", 50, () -> xyz[2]);
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
//        executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(() -> {
//            try {
//                runTime();
//            }
//            catch(Exception e){
//                System.out.println(e.getMessage());
//            }
//        }, 0, 50, TimeUnit.MILLISECONDS);
    }
    private void runTime() throws InterruptedException {
        colorRectangle.setFill(dataFromSensor.getPaintFromHSL());
        rgb = dataFromSensor.getRGB();
        hsl = dataFromSensor.getHSL();
        xyz = dataFromSensor.getXYZ();
        sensorType = dataFromSensor.getSensorType();
        for(Node node: getChildren()){
            if(node instanceof ShowValuePanel) {
                ((ShowValuePanel) node).update();
            }
        }
        Thread.sleep(50);
        runTime();
    }
    public void stopAllThreads(){
        executorService.shutdownNow();
    }
}
