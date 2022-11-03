package org.goznak.models;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
    public String[] getSensorType(){
        ///070Vaa:bbccqq.
        String data = sensorData.get("000V49");
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.contains("NOK") || data.length() != 15){
            return result;
        }
        //Software version
        result[0] = data.substring(5, 6);
        //Sensor group
        result[1] = data.substring(7, 8);
        //Sensor select
        result[2] = data.substring(8, 9);
        return result;
    }
    public Paint getPaint(){
        ///SS0M0D0srrggbbqq.
        String data = sensorData.get("020D0s1A");
        if(data.contains("NOK") || data.length() != 18){
            return Paint.valueOf("Black");
        }
        //Paint p = new Color();
        return Paint.valueOf(data.substring(9, 15));
    }

    public String[] getRGB(){
        ///SS0M0D0srrggbbqq.
        String data = sensorData.get("020D0s1A");
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.contains("NOK") || data.length() != 18){
            System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111");
            return result;
        }
        //red
        result[0] = data.substring(9, 11);
        //green
        result[1] = data.substring(11, 13);
        //blue
        result[2] = data.substring(13, 15);
        return result;
    }
    public String[] getHSL(){
        ///SS0M0D0pHHHhhhHHHSSSLLLqq.
        String data = sensorData.get("020D0p19");
        String[] result = {"NOK", "NOK", "NOK", "NOK", "NOK"};
        if(data.contains("NOK") || data.length() != 27){
            return result;
        }
        //hueRed
        result[0] = data.substring(9, 12);
        //hueGreen
        result[1] = data.substring(12, 15);
        //hueBlue
        result[2] = data.substring(15, 18);
        //saturation
        result[3] = data.substring(18, 21);
        //lightness
        result[4] = data.substring(21, 24);
        return result;
    }
    public String[] getXYZ(){
        ///SS0M0D0rxxxyyyzzzqq.
        String data = sensorData.get("020D0r1B");
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.contains("NOK") || data.length() != 21){
            return result;
        }
        //red
        result[0] = data.substring(9, 12);
        //green
        result[1] = data.substring(15, 18);
        //blue
        result[2] = data.substring(13, 15);
        return result;
    }
}
