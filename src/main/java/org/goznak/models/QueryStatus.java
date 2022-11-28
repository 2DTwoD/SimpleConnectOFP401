package org.goznak.models;

public class QueryStatus {
    boolean A1status;
    boolean A2status;
    boolean A3status;
    String data;
    String error;
    String dirty;
    private static final int[] outNO = {1, 2, 3};
    private static final int[] outNC = {4, 5, 6};
    private static final int[] erNO = {7, 8, 9};
    private static final int[] erNC = {10, 11, 12};
    private static final int[] dirtNO = {13, 14, 15};
    private static final int[] dirtNC = {16, 17, 18};

    public QueryStatus(String data, int[] channelFunctions) {
        ///SS0M0Wppppeeedqq.
        this.data = data;
        if(data.equals(DataFromSensor.UNKNOWN_SYMBOL)){
            error = DataFromSensor.UNKNOWN_SYMBOL;
            dirty = DataFromSensor.UNKNOWN_SYMBOL;
        } else {
            error = getTrueError(data.substring(11, 14));
            dirty = !error.equals("OK") ? getTrueStatus("error") : getTrueStatus(data.substring(14, 15));
            try {
                int Astatus = Integer.decode("0x" + data.substring(7, 11));
                A1status = getStatusInternal(Astatus, 0, channelFunctions[0]);
                A2status = getStatusInternal(Astatus, 1, channelFunctions[1]);
                A3status = getStatusInternal(Astatus, 2, channelFunctions[2]);
            }
            catch(Exception ignored){
            }
        }
    }
    private boolean getStatusInternal(int status, int shift, int channelFunction){
        boolean result = false;
        if(contains(outNO, channelFunction)){
            result = (status & 1<<shift) > 0;
        } else if(contains(outNC, channelFunction)){
            result = (status & 1<<shift) > 0;
            result = !result;
        } else if(contains(erNO, channelFunction)){
            result = !error.equals("OK");
        } else if(contains(erNC, channelFunction)){
            result = !error.equals("OK");
            result = !result;
        } else if(contains(dirtNO, channelFunction)){
            result = "1".equals(String.valueOf(data.charAt(14)));
        } else if(contains(dirtNC, channelFunction)){
            result = "1".equals(String.valueOf(data.charAt(14)));
            result = !result;
        }
        return result;
    }
    private boolean contains(int[] ar, int value){
        boolean result = false;
        for (int i: ar){
            result = result || i == value;
        }
        return result;
    }
    private String getTrueError(String error){
        int errorValue = Integer.decode("0x" + error);
        if((errorValue & 1) > 0){
            return "LEDTempTooHigh";
        } else if((errorValue & 1<<1) > 0){
            return "LEDTempTooLow";
        } else if((errorValue & 1<<2) > 0){
            return "LEDCurrentMismatch";
        } else if((errorValue & 1<<3) > 0){
            return "TriggerTooFast";
        } else if((errorValue & 1<<4) > 0){
            return "UnableToAssignColor";
        } else if((errorValue & 1<<6) > 0){
            return "Black";
        } else {
            return "OK";
        }
    }
    private String getTrueStatus (String status){
        switch (status){
            case "1" -> {
                return "( - )";
            }
            case "2" -> {
                return "( + )";
            }
            case "error" -> {
                return "( ! )";
            }
            default -> {
                return "( v )";
            }
        }
    }
    public boolean isA1status() {
        return A1status;
    }

    public boolean isA2status() {
        return A2status;
    }

    public boolean isA3status() {
        return A3status;
    }

    public String getError() {
        return error;
    }

    public String getDirty() {
        return dirty;
    }
}
