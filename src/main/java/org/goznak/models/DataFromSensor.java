package org.goznak.models;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.goznak.tools.CommandList;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DataFromSensor {
    private Map<RequestCommand, String> sensorData = new HashMap<>();


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
        if(max == hr && hg >= hb){
            h = part1 * (hg - hb) / delta;
        } else if(max == hr && hg < hb){
            h = part1 * (hg - hb) / delta + 1.0;
        } else if(max == hg){
            h = part1 * (hb - hr) / delta + part2;
        } else if(max == hb){
            h = part1 * (hr - hg) / delta + part1 * 4;
        }
        //get  RGB from HSL
        double q;
        double p;
        double r;
        double g;
        double b;
        l /= 511.0;
        s /= 511.0;
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
    public Paint getPaint(){
        ///SS0M0D0pHHHhhhHHHSSSLLLqq.
        String data = sensorData.get(CommandList.READ_HSL);
        if(data.equals("NOK")){
            return Color.BLACK;
        }
        int hred = Integer.decode(String.format("0x%s", data.substring(9, 12)));
        int hgreen = Integer.decode(String.format("0x%s", data.substring(12, 15)));
        int hblue = Integer.decode(String.format("0x%s", data.substring(15, 18)));
        int s = Integer.decode(String.format("0x%s", data.substring(18, 21)));
        int l = Integer.decode(String.format("0x%s", data.substring(21, 24)));
        int[] rgb = hslToRGB(hred, hgreen, hblue, s, l);
        return Color.rgb(rgb[0], rgb[1], rgb[2]);
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
        ///SS0M0D0rxxxyyyzzzqq.
        String data = sensorData.get(CommandList.READ_XYZ);
        String[] result = {"NOK", "NOK", "NOK"};
        if(data.equals("NOK")){
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
