package org.goznak.models;


import javafx.scene.paint.Color;
import org.goznak.tools.CommandList;

import java.util.HashMap;
import java.util.Map;

public class DataFromSensor {
    private Map<String, String> sensorData = new HashMap<>();

    public DataFromSensor() {
        for(String command: CommandList.getCommands()){
            sensorData.put(command, "NOK");
        }
    }
    public void setData(String command, String data){
        sensorData.replace(command, data);
    }
    private Color getColorFromHex(String hex){
        //System.out.println(hex);
        return Color.rgb(Integer.valueOf(hex.substring(0, 2), 16),
                Integer.valueOf(hex.substring(2, 4), 16),
                Integer.valueOf(hex.substring(4, 6), 16));
    }
    public Color getRGB(){
        ///SS0M0D0srrggbbqq.
        String data = sensorData.get("020D0s1A");
        System.out.println(data);
        if(data.contains("NOK") || data.length() != 18){

            return Color.BLACK;
        }
        return getColorFromHex(data.substring(9, 15));
    }
}
