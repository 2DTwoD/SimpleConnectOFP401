package org.goznak.panels;

import javafx.fxml.Initializable;
import org.goznak.models.DataFromSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class ReadPanel implements Initializable {
    @Autowired
    DataFromSensor dataFromSensor;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(dataFromSensor);
    }
}
