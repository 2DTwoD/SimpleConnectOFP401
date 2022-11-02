package org.goznak.panels;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import org.goznak.Main;

import java.net.CookieHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReadParametersPanel extends GridPane {
    Label rgbLabel = new Label("RGB:");
    TextField rgbValueField = new TextField("0-0-0");
    Rectangle colorRectangle = new Rectangle(50, 50, Paint.valueOf("Black"));
    ScheduledExecutorService executorService;
    public ReadParametersPanel(Main main) {
        super();
        setMinWidth(main.scene.getWidth());
        add(rgbLabel, 0, 0);
        add(rgbValueField, 1, 0);
        add(colorRectangle, 2, 0);
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            Color color = main.dataFromSensor.getRGB();
            colorRectangle.setFill(color);
            //rgbValueField.setText(String.format("%d-%d-%d", (int) color.getRed(), (int) color.getGreen(), (int) color.getBlue()));
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
    public void stopAllThreads(){
        executorService.shutdownNow();
    }
}
