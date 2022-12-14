package org.goznak.model_dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.goznak.tools.ConnectTool;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFromSensor {
    @Autowired
    ConnectTool connectTool;
    private final Map<RequestCommand, String> sensorData = new HashMap<>();
    private final static ObservableList<String> opModeList = FXCollections.observableArrayList("HSL", "По назначению", "RGB");
    private final static ObservableList<String> filterList = FXCollections.observableArrayList("1", "2", "4", "8",
            "16", "32", "64", "128", "256", "512", "1024", "2048", "4096");
    private final static ObservableList<String> lightList = FXCollections.observableArrayList("Выкл.", "Норма", "Ярко", "Тускло");
    private final static ObservableList<String> fpModeList = FXCollections.observableArrayList("OFP", "FP");
    private final static ObservableList<String> menuList = FXCollections.observableArrayList("Выкл.", "Вкл.");
    private final static ObservableList<String> channelFunctionList = FXCollections.observableArrayList("Не задействован",
            "Выход, NPN и NO", "Выход, PNP и NO", "Выход, PP и NO", "Выход, NPN и NC", "Выход, PNP и NC",
            "Выход, PP и NC", "Ошибка, NPN и NO", "Ошибка, PNP и NO", "Ошибка, PP и NO", "Ошибка, NPN и NC",
            "Ошибка, PNP и NC", "Ошибка, PP и NC",  "Загрязнение, NPN и NO", "Загрязнение, PNP и NO",
            "Загрязнение, PP и NO", "Загрязнение, NPN и NC", "Загрязнение, PNP и NC", "Загрязнение, PP и NC",
            "Излучаемый свет, Ub активно", "Излучаемый свет, Ub не активно",
            "Внешнее обучение, Ub активно", "Внешнее обучение, Ub не активно",
            "Вход триггера, Ub активно", "Вход триггера, Ub не активно");
    private final static ObservableList<String> testOutputList = FXCollections.observableArrayList("0",
            "1", "Симул. выкл.");
    public static final String UNKNOWN_SYMBOL = "?";
    public DataFromSensor() {
        for(RequestCommand command: CommandList.getReadCommands()){
            sensorData.put(command, UNKNOWN_SYMBOL);
        }
    }
    public static ObservableList<String> getOpModeList(){
        return opModeList;
    }
    public static ObservableList<String> getFilterList(){
        return filterList;
    }
    public static ObservableList<String> getLightList(){
        return lightList;
    }

    public static ObservableList<String> getFpModeList(){
        return fpModeList;
    }
    public static ObservableList<String> getMenuList(){
        return menuList;
    }
    public static ObservableList<String> getChannelFunctionList(int channel){
        if(channel == 3) {
            return channelFunctionList;
        }
        return FXCollections.observableArrayList(channelFunctionList.subList(0, 19));
    }
    public static ObservableList<String> getTestOutputListCut(){
        return FXCollections.observableArrayList(testOutputList.subList(0, 2));
    }
    public void setData(RequestCommand command, String data){
        if(data.contains("NOK") || data.contains("NOk") ||!checkSumOK(data) || data.length() != command.getLength()){
            //System.out.println(String.format("command: %s, data: %s", command.getCommand(), data));
            return;
        }
        if(!sensorData.containsKey(command)){
            //System.out.println(String.format("command: %s, data: %s", command.getCommand(), data));
            if(command.getReferenceCommand() != null){
                command = command.getReferenceCommand();
            } else {
                return;
            }
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
    public String[] getRGB(){
        ///SS0M0D0srrggbbqq.
        String data = sensorData.get(CommandList.READ_RGB);
        String[] result = {UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL};
        if(data.equals(UNKNOWN_SYMBOL)){
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
    public int[] getIntRGB(){
        String[] rgb = getRGB();
        int[] result = new int[3];
        try {
            result[0] = Math.min(Integer.decode("0x" + rgb[0]), 255);
            result[1] = Math.min(Integer.decode("0x" + rgb[1]), 255);
            result[2] = Math.min(Integer.decode("0x" + rgb[2]), 255);
        }
        catch (Exception ignored){
        }
        return result;
    }
    public String[] getHSL(){
        ///SS0M0D0pHHHhhhHHHSSSLLLqq.
        String data = sensorData.get(CommandList.READ_HSL);
        String[] result = {UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL};
        if(data.equals(UNKNOWN_SYMBOL)){
            return result;
        }
        //hueRed
        result[0] = data.substring(9, 12);
        //hueGreen
        result[1] = data.substring(12, 15);
        //hueBlue
        result[2] = data.substring(15, 18);
        int[] rgb = getIntRGB();//getIntXYZ()
        double h = getHueFromRGB(rgb[0], rgb[1], rgb[2]);//Integer.decode("0x" + result[0]), Integer.decode("0x" + result[1]),Integer.decode("0x" + result[2])
        result[3] = String.format("%d", (int) (h * 360));
        //saturation
        int s = (int)(Integer.decode("0x" + data.substring(18, 21)) / 511.0 * 100.0);
        result[4] = String.format("%d", s);
        //lightness
        int l = (int)(Integer.decode("0x" + data.substring(21, 24)) / 511.0 * 100.0);
        result[5] = String.format("%d", l);
        return result;
    }
    public int[] getIntHSL(){
        String[] hsl = getHSL();
        int[] result = new int[6];
        try {
            result[0] = Math.min(Integer.decode("0x" + hsl[0]), 512);
            result[1] = Math.min(Integer.decode("0x" + hsl[1]), 512);
            result[2] = Math.min(Integer.decode("0x" + hsl[2]), 512);
            result[3] = Integer.parseInt(hsl[3]);
            result[4] = Integer.parseInt(hsl[4]);
            result[5] = Integer.parseInt(hsl[5]);
        }
        catch (Exception ignored) {
        }
        return result;
    }
    public String[] getXYZ(){
        // /SS0M0D0rxxxyyyzzzqq.
        String data = sensorData.get(CommandList.READ_XYZ);
        String[] result = {UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL};
        if(data.equals(UNKNOWN_SYMBOL)){
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
    public int[] getIntXYZ(){
        String[] xyz = getXYZ();
        int[] result = new int[3];
        try {
            result[0] = Math.min(Integer.decode("0x" + xyz[0]), 512);
            result[1] = Math.min(Integer.decode("0x" + xyz[1]), 512);
            result[2] = Math.min(Integer.decode("0x" + xyz[2]), 512);
        }
        catch (Exception ignored){
        }
        return result;
    }
    private double getHueFromRGB(double red, double green, double blue){
        double max = Math.max(Math.max(red, green), blue);
        double min = Math.min(Math.min(red, green), blue);
        if (max == min) {
            return 0.0;
        }
        double hue;
        double delta = max - min;
        if (max == red) {
            hue = (green - blue) / delta;
        } else if (max == green) {
            hue = 2.0 + (blue - red) / delta;
        } else {
            hue = 4.0 + (red - green) / delta;
        }
        hue *= 1 / 6.0;
        if (hue < 0) {
            hue += 1.0;
        }
        return hue;
    }
    private int[] hslToRGB(double red, double green, double blue, double s, double l){
        //get hue from hueRGB
        double h = getHueFromRGB(red, green, blue);
        //get RGB from HSL
        final double range = 512.0;
        final double part = 1.0 / 3.0;
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
        r = getColorFromTPQ(h + part, p, q);
        g = getColorFromTPQ(h, p, q);
        b = getColorFromTPQ(h - part, p, q);
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
    public int[] getRGBFromHSL(){
        ///SS0M0D0pHHHhhhHHHSSSLLLqq.
        String data = sensorData.get(CommandList.READ_HSL);
        if(data.equals(UNKNOWN_SYMBOL)){
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
        if(data.equals(UNKNOWN_SYMBOL)){
            return Color.BLACK;
        }
        return Paint.valueOf(data.substring(9, 15));
    }
    public Paint getPaintFromHSL(){
        int[] rgb = getRGBFromHSL();
        return Color.rgb(rgb[0], rgb[1], rgb[2]);
    }
    public Paint getPaintFromXYZ(){
        int[] rgb = getIntXYZ();
        return Color.rgb(rgb[0] / 2, rgb[1] / 2, rgb[2] / 2);
    }
    public String[] getSensorType(){
        ///070Vaa:bbccqq.
        String data = sensorData.get(CommandList.READ_SENSOR_VERSION);
        String[] result = {UNKNOWN_SYMBOL, UNKNOWN_SYMBOL, UNKNOWN_SYMBOL};
        if(data.equals(UNKNOWN_SYMBOL)){
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
    public QueryStatus getQueryStatus(){
        // /SS0M0Wppppeeedqq.
        String data = sensorData.get(CommandList.READ_QUERY_STATUS);
        int[] channelFunctions = new int[3];
        for(int i = 0; i < channelFunctions.length; i++){
            channelFunctions[i] = channelFunctionList.indexOf(getChannelFunction(i + 1));
        }
        return new QueryStatus(data, channelFunctions);
    }
    private String getListParameter(ObservableList<String> list, String data){
        try {
            return list.get(Integer.decode("0x" + data.charAt(8)));
        }
        catch (Exception e){
            return UNKNOWN_SYMBOL;
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
    public String getChannelFunction(int channel){
        // /SS0M0P0ifqq.
        String data = sensorData.get(CommandList.readPinFunction(channel));
        if(data.equals(UNKNOWN_SYMBOL)){
            return UNKNOWN_SYMBOL;
        }
        char c = data.charAt(9);
        int shift;
        if(c < 58){
            shift = 48;
        } else {
            shift = 87;
        }
        return channelFunctionList.get(c - shift);
    }
    private int getAssignedTeach(String data){
        if(data.equals(UNKNOWN_SYMBOL)){
            return 0;
        }
        return Integer.decode("0x" + data.substring(11, 15));
    }
    public int getAssignedTeachRed(int channel){
        // /SS0M0O0AiRrrrrqq.
        String data = sensorData.get(CommandList.readAssignedTeachRed(channel));
        return getAssignedTeach(data);
    }
    public int getAssignedTeachGreen(int channel){
        // /SS0M0O0AiGggggqq.
        String data = sensorData.get(CommandList.readAssignedTeachGreen(channel));
        return getAssignedTeach(data);
    }
    public int getAssignedTeachBlue(int channel){
        // /SS0M0O0AiBbbbbqq.
        String data = sensorData.get(CommandList.readAssignedTeachBlue(channel));
        return getAssignedTeach(data);
    }
    private int[] getSwitchingPoints(String  data){
        int[] switchingPoints = new int[4];
        if(data.equals(UNKNOWN_SYMBOL)){
            return switchingPoints;
        }
        //Hoff
        switchingPoints[0] = Integer.decode("0x" + data.substring(11, 15));
        //Hon
        switchingPoints[1] = Integer.decode("0x" + data.substring(15, 19));
        //Lon
        switchingPoints[2] = Integer.decode("0x" + data.substring(19, 23));
        //Loff
        switchingPoints[3] = Integer.decode("0x" + data.substring(23, 27));
        return switchingPoints;
    }
    public int[] getSwitchingPointsRed(int channel){
        // /SS0M0O0aiRHoffHon_Lon_Loffqq.
        String data = sensorData.get(CommandList.readSwitchingPointsRed(channel));
        return getSwitchingPoints(data);
    }
    public int[] getSwitchingPointsGreen(int channel){
        // /SS0M0O0aiGHoffHon_Lon_Loffqq.
        String data = sensorData.get(CommandList.readSwitchingPointsGreen(channel));
        return getSwitchingPoints(data);
    }
    public int[] getSwitchingPointsBlue(int channel){
        // /SS0M0O0aiBHoffHon_Lon_Loffqq.
        String data = sensorData.get(CommandList.readSwitchingPointsBlue(channel));
        return getSwitchingPoints(data);
    }
    public int[] getSwitchingPointsSat(int channel){
        // /SS0M0O0aiLHoffHon_Lon_Loffqq.
        String data = sensorData.get(CommandList.readSwitchingPointsSat(channel));
        return getSwitchingPoints(data);
    }
    public int[] getSwitchingPointsLight(int channel){
        // /SS0M0O0aiLHoffHon_Lon_Loffqq.
        String data = sensorData.get(CommandList.readSwitchingPointsLight(channel));
        return getSwitchingPoints(data);
    }
    private int getWindowSize(String data, boolean aux){
        if(data.equals(UNKNOWN_SYMBOL)){
            return 0;
        }
        if(aux) {
            return Integer.decode("0x" + data.substring(11, 15));
        } else {
            return Integer.decode("0x" + data.substring(10, 14));
        }
    }
    public int getWinSizeComm(int channel){
        // /SS0M0O0bihhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeComm(channel));
        return getWindowSize(data, false);
    }
    public int getWinSizeHue(int channel){
        // /SS0M0O0bihhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeHue(channel));
        return getWindowSize(data, false);
    }
    public int getWinSizeSat(int channel){
        // /SS0M0O0bihhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeSat(channel));
        return getWindowSize(data, false);
    }
    public int getWinSizeLight(int channel){
        // /SS0M0O0bihhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeLight(channel));
        return getWindowSize(data, false);
    }
    public int getWinSizeRed(int channel){
        // /SS0M0O0biRhhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeRed(channel));
        return getWindowSize(data, true);
    }
    public int getWinSizeGreen(int channel){
        // /SS0M0O0biGhhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeGreen(channel));
        return getWindowSize(data, true);
    }
    public int getWinSizeBlue(int channel){
        // /SS0M0O0biBhhhhqq.
        String data = sensorData.get(CommandList.readWindowSizeBlue(channel));
        return getWindowSize(data, true);
    }
    private int getTimeParam(String data){
        if(data.equals(UNKNOWN_SYMBOL)){
            return 0;
        }
        return Integer.decode("0x" + data.substring(10, 14));
    }
    public int getOnDelay(int channel){
        // /SS0M0O0jihhhhqq.
        String data = sensorData.get(CommandList.readOnDelay(channel));
        return getTimeParam(data);
    }
    public int getOffDelay(int channel){
        // /SS0M0O0kihhhhqq.
        String data = sensorData.get(CommandList.readOffDelay(channel));
        return getTimeParam(data);
    }
    public int getImpulse(int channel){
        // /SS0M0O0lihhhhqq.
        String data = sensorData.get(CommandList.readImpulse(channel));
        return getTimeParam(data);
    }
    public String getTestOutput(int channel){
        // /SS0M0t0isqq.
        String data = sensorData.get(CommandList.readTestOutput(channel));
        if(data.equals(UNKNOWN_SYMBOL)){
            return UNKNOWN_SYMBOL;
        }
        return testOutputList.get(Integer.parseInt(data.substring(9, 10)));
    }
    private void setOneValue(Command command, List<String> list, String value, RequestCommand referenceCommand){
        if(!list.contains(value)){
            return;
        }
        RequestCommand cmd = command.getCommand(new String[]{Integer.toHexString(list.indexOf(value)).toUpperCase()}, referenceCommand);
        CommandList.setWriteCommand(cmd);
    }
    public void setOpMode(String value){
        setOneValue(CommandList.WRITE_OPERATING_MODE, opModeList, value, CommandList.READ_OPERATING_MODE);
    }
    public void setFilter(String value){
        setOneValue(CommandList.WRITE_FILTER_SIZE, filterList, value, CommandList.READ_FILTER_SIZE);
    }
    public void setLight(String value){
        setOneValue(CommandList.WRITE_EMITTED_LIGHT, lightList, value, CommandList.READ_EMITTED_LIGHT);
    }
    public void setFpMode(String value){
        setOneValue(CommandList.WRITE_SENSOR_SELECT, fpModeList, value, CommandList.READ_SENSOR_SELECT);
    }
    public void setMenu(String value){
        setOneValue(CommandList.WRITE_EXPERT_MENU, menuList, value, CommandList.READ_EXPERT_MENU);
    }
    public void reset(){
        CommandList.setWriteCommand(CommandList.RESET_SENSOR.getCommand());
    }
    public void setPinFunction(int channel, String value){
        int index  = channelFunctionList.indexOf(value);
        if(index == -1){
            return;
        }
        if(index < 10){
            index += 48;
        } else {
            index += 87;
        }
        RequestCommand referenceCommand = CommandList.readPinFunction(channel);
        CommandList.setWriteCommand(CommandList.WRITE_PIN_FUNCTION.getCommand(new String[]{
                String.valueOf(channel),
                String.valueOf((char) index)
        }, referenceCommand));
    }
    public void makeAssignTeach(int channel){
        CommandList.setWriteCommand(CommandList.MAKE_ASSIGNED_TEACH.getCommand(new String[]{String.valueOf(channel), "0"}));
    }
    private String getLimitedHex(String value, int limit){
        int numericValue;
        try{
            numericValue = Integer.parseInt(value);
            numericValue = Math.min(numericValue, limit);
        }
        catch (Exception e){
            return null;
        }
        return String.format("%04X", numericValue);
    }
    public void setAssignedTeach(int channel, String value, String color){
        String hexValue = getLimitedHex(value, 511);
        if(hexValue == null){
            return;
        }
        RequestCommand referenceCommand = switch (color){
            case "R" -> CommandList.readAssignedTeachRed(channel);
            case "G" -> CommandList.readAssignedTeachGreen(channel);
            default -> CommandList.readAssignedTeachBlue(channel);
        };
        CommandList.setWriteCommand(CommandList.WRITE_ASSIGNED_TEACH.getCommand(new String[]{String.valueOf(channel), color,
        hexValue}, referenceCommand));
    }
    public void makeWindowTeach(int channel, String function){
        CommandList.setWriteCommand(CommandList.MAKE_WINDOW_TEACH.getCommand(new String[]{String.valueOf(channel), function}));
    }
    public void setSwitchingPoints(int channel, String value, String function, String target){
        int decimalValue;
        try {
            decimalValue = Integer.parseInt(value);
            decimalValue = Math.min(decimalValue, 65535);
        }
        catch (Exception e){
            return;
        }
        int[] sp = switch(function){
            case "R" -> getSwitchingPointsRed(channel);
            case "G" -> getSwitchingPointsGreen(channel);
            case "B" -> getSwitchingPointsBlue(channel);
            case "S" -> getSwitchingPointsSat(channel);
            default -> getSwitchingPointsLight(channel);
        };
        RequestCommand referenceCommand = switch(function){
            case "R" -> CommandList.readSwitchingPointsRed(channel);
            case "G" -> CommandList.readSwitchingPointsGreen(channel);
            case "B" -> CommandList.readSwitchingPointsBlue(channel);
            case "S" -> CommandList.readSwitchingPointsSat(channel);
            default -> CommandList.readSwitchingPointsLight(channel);
        };
        int index = switch(target){
            case "Hoff" -> 0;
            case "Hon" -> 1;
            case "Lon" -> 2;
            default -> 3;
        };
        sp[index] = decimalValue;
        String result = "";
        for(int i: sp){
            result += String.format("%04X", i);
        }
        CommandList.setWriteCommand(CommandList.WRITE_SWITCHING_POINTS.getCommand(new String[]{String.valueOf(channel),
                function, result}, referenceCommand));
    }
    public void setWindowSize(int channel, String value, String function){
        String hexValue = getLimitedHex(value, 255);
        if(hexValue == null){
            return;
        }
        RequestCommand referenceCommand = switch(function){
            case "b" -> CommandList.readWindowSizeComm(channel);
            case "c" -> CommandList.readWindowSizeHue(channel);
            case "d" -> CommandList.readWindowSizeSat(channel);
            case "e" -> CommandList.readWindowSizeLight(channel);
            case "R" -> CommandList.readWindowSizeRed(channel);
            case "G" -> CommandList.readWindowSizeGreen(channel);
            default -> CommandList.readWindowSizeBlue(channel);
        };
        if("RGB".contains(function)){
            CommandList.setWriteCommand(CommandList.WRITE_WINDOW_SIZE_AUX.getCommand(new String[]{String.valueOf(channel),
                    function, hexValue}, referenceCommand));
            return;
        }
        CommandList.setWriteCommand(CommandList.WRITE_WINDOW_SIZE.getCommand(new String[]{function,
                String.valueOf(channel), hexValue}, referenceCommand));
    }
    public void setDelayImpulse(int channel, String value, String function){
        String hexValue = getLimitedHex(value, 10000);
        if(hexValue == null){
            return;
        }
        RequestCommand referenceCommand = switch(function){
            case "j" -> CommandList.readOnDelay(channel);
            case "k" -> CommandList.readOffDelay(channel);
            default -> CommandList.readImpulse(channel);
        };
        CommandList.setWriteCommand(CommandList.WRITE_DELAY_IMPULSE.getCommand(new String[]{function,
                String.valueOf(channel), hexValue}, referenceCommand));
    }
    public void setTestOutput(int channel, boolean onOff, String value){
        RequestCommand referenceCommand = CommandList.readTestOutput(channel);
        if(!onOff){
            CommandList.setWriteCommand(CommandList.WRITE_TEST_OUTPUT.getCommand(new String[]{String.valueOf(channel),
                    "2"}, referenceCommand));
        } else {
            int index = testOutputList.indexOf(value);
            CommandList.setWriteCommand(CommandList.WRITE_TEST_OUTPUT.getCommand(new String[]{String.valueOf(channel),
                    String.valueOf(index)}, referenceCommand));
        }
    }
}
