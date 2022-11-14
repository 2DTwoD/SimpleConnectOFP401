package org.goznak.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.goznak.tools.CommandList;
import org.goznak.tools.ConnectTool;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFromSensor {
    @Autowired
    ConnectTool connectTool;
    private Map<RequestCommand, String> sensorData = new HashMap<>();
    public static ObservableList<String> opModeList = FXCollections.observableArrayList("HSL", "assign", "RGB");
    public static ObservableList<String> filterList = FXCollections.observableArrayList("1", "2", "4", "8",
            "16", "32", "64", "128", "256", "512", "1024", "2048", "4096");
    public static ObservableList<String> lightList = FXCollections.observableArrayList("OFF", "normal", "bright", "dark");
    public static ObservableList<String> fpModeList = FXCollections.observableArrayList("OFP", "FP");
    public static ObservableList<String> menuList = FXCollections.observableArrayList("ON", "OFF");


    public DataFromSensor() {
        for(RequestCommand command: CommandList.getReadCommands()){
            sensorData.put(command, "NOK");
        }
    }
    public void setData(RequestCommand command, String data){
        if(data.contains("NOK") || !checkSumOK(data) || data.length() != command.getLength() || !sensorData.containsKey(command)){
            return;
        }
        sensorData.replace(command, data);
    }
    static boolean checkSumOK(String data){
        int lim = data.length() - 3;
        byte checkSum = '/';
        for(byte b: data.substring(1, lim).getBytes(StandardCharsets.US_ASCII)){
            checkSum ^= b;
        }
        return String.format("%02X", checkSum).equals(data.substring(lim, lim + 2));
    }
    private int[] hslToRGB(double hr, double hg, double hb, double s, double l){
        //get hue from hueRGB
        double h = 0.0;
        double max = Math.max(hr, Math.max(hg, hb));
        double min = Math.min(hr, Math.min(hg, hb));
        double delta = max - min;
        final double part1 = 1.0 / 6.0;
        final double part2 = 1.0 / 3.0;
        final double range = 511.0;
        if(max == hr && hg >= hb){
            h = part1 * (hg - hb) / delta;
        } else if(max == hr && hg < hb){
            h = part1 * (hg - hb) / delta + 1.0;
        } else if(max == hg){
            h = part1 * (hb - hr) / delta + part2;
        } else if(max == hb){
            h = part1 * (hr - hg) / delta + part1 * 4;
        }
        //get RGB from HSL
        double q;
        double p;
        double r;
        double g;
        double b;
        l /= range;
        s /= range;
        l = Math.min(l, 1.0);
        s = Math.min(s, 1.0);
        if(l < 0.5){
            q = l * (1.0 +s);
        } else {
            q = l + s - l * s;
        }
        p = 2.0 * l - q;
        r = getColorFromTPQ(h + part2, p, q);
        g = getColorFromTPQ(h, p, q);
        b = getColorFromTPQ(h - part2, p, q);
        return new int[]{(int) (r * 255.0), (int) (g * 255.0), (int) (b * 255.0)};
    }
    private double getColorFromTPQ(double t, double p, double q){
        double part1 = 1.0 / 6.0;
        double part2 = 2.0 / 3.0;
        if(t < 0.0){
            t += 1.0;
        } else if(t > 1.0){
            t -= 1.0;
        }
        if(t < part1) {
            return p + (q - p) * 6.0 * t;
        } else if(t >= part1 && t < 0.5){
            return q;
        } else if( t >= 0.5 && t < part2){
            return p +(q - p) * (part2 - t) * 6.0;
        } else {
            return p;
        }
    }
    public String[] getSensorType(){
        ///070Vaa:bbccqq.
        String data = sensorData.get(CommandList.READ_SENSOR_VERSION);
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.equals("NOK")){
            return result;
        }
        //Software version
        result[0] = data.substring(5, 7);
        //Sensor group
        result[1] = data.substring(8, 10);
        //Sensor select
        result[2] = data.substring(10, 12);
        return result;
    }
    public Paint getPaintFromHSL(){
        int[] rgb = getRGBFromHSL();
        return Color.rgb(rgb[0], rgb[1], rgb[2]);
    }
    public int[] getRGBFromHSL(){
        ///SS0M0D0pHHHhhhHHHSSSLLLqq.
        String data = sensorData.get(CommandList.READ_HSL);
        if(data.equals("NOK")){
            return new int[]{0, 0, 0};
        }
        int hred = Integer.decode(String.format("0x%s", data.substring(9, 12)));
        int hgreen = Integer.decode(String.format("0x%s", data.substring(12, 15)));
        int hblue = Integer.decode(String.format("0x%s", data.substring(15, 18)));
        int s = Integer.decode(String.format("0x%s", data.substring(18, 21)));
        int l = Integer.decode(String.format("0x%s", data.substring(21, 24)));
        return hslToRGB(hred, hgreen, hblue, s, l);
    }
    public Paint getPaintFromRGB(){
        String data = sensorData.get(CommandList.READ_RGB);
        if(data.equals("NOK")){
            return Color.BLACK;
        }
        return Paint.valueOf(data.substring(9, 15));
    }

    public String[] getRGB(){
        ///SS0M0D0srrggbbqq.
        String data = sensorData.get(CommandList.READ_RGB);
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.equals("NOK")){
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
        String data = sensorData.get(CommandList.READ_HSL);
        String[] result = {"NOK", "NOK", "NOK", "NOK", "NOK"};
        if(data.equals("NOK")){
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
        // /SS0M0D0rxxxyyyzzzqq.
        String data = sensorData.get(CommandList.READ_XYZ);
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.equals("NOK")){
            return result;
        }
        //red
        result[0] = data.substring(9, 12);
        //green
        result[1] = data.substring(12, 15);
        //blue
        result[2] = data.substring(15, 18);
        return result;
    }
    public QueryStatus getQueryStatus(){
        // /SS0M0Wppppeeedqq.
        String data = sensorData.get(CommandList.READ_QUERY_STATUS);
        return new QueryStatus(data);
    }
    private String getListParameter(ObservableList<String> list, String data){
        try {
            return list.get(Integer.parseInt(data.substring(8, 9)));
        }
        catch (Exception e){
            return "NOK";
        }
    }
    public String getOpMode(){
        // /SS0M0M0jqq.
        return getListParameter(opModeList, sensorData.get(CommandList.READ_OPERATING_MODE));
    }
    public String getFilterSize(){
        // /SS0M0F0sqq.
        return getListParameter(filterList, sensorData.get(CommandList.READ_FILTER_SIZE));
    }
    public String getLight(){
        // /SS0M0L0iqq.
        return getListParameter(lightList, sensorData.get(CommandList.READ_EMITTED_LIGHT));
    }
    public String getFpMode(){
        // /SS0M0J0iqq.
        return getListParameter(fpModeList, sensorData.get(CommandList.READ_SENSOR_SELECT));
    }
    public String getMenu(){
        // /SS0M0Ehhqq.
        return getListParameter(menuList, sensorData.get(CommandList.READ_EXPERT_MENU));
    }
    public void getImpulse(){
        System.out.println(sensorData.get(CommandList.READ_IMPULSE_PIN1));
    }

    private void setOneValue(Command command, List<String> list, String value){
        if(!list.contains(value)){
            return;
        }
        RequestCommand cmd = command.getCommand(new String[]{Integer.toString(list.indexOf(value))});
        CommandList.setWriteCommand(cmd);
    }
    public void setOpMode(String value){
        setOneValue(CommandList.WRITE_OPERATING_MODE, opModeList, value);
    }
    public void setFilter(String value){
        setOneValue(CommandList.WRITE_FILTER_SIZE, filterList, value);
    }
    public void setLight(String value){
        setOneValue(CommandList.WRITE_EMITTED_LIGHT, lightList, value);
    }
    public void setFpMode(String value){
        setOneValue(CommandList.WRITE_SENSOR_SELECT, fpModeList, value);
    }
    public void setMenu(String value){
        setOneValue(CommandList.WRITE_EXPERT_MENU, menuList, value);
    }
}
