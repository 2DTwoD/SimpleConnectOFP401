package org.goznak.models;

public class QueryStatus {
    boolean A1status;
    boolean A2status;
    boolean A3status;
    String error;
    String dirty;

    public QueryStatus(String data) {
        ///SS0M0Wppppeeedqq.
        if(data.equals("NOK")){
            error = "?";
            dirty = "?";
        } else {
            A3status = Integer.parseInt(data.substring(8, 9)) == 1;
            A2status = Integer.parseInt(data.substring(9, 10)) == 1;
            A1status = Integer.parseInt(data.substring(10, 11)) == 1;
            error = getTrueError(data.substring(11, 14));
            dirty = !error.equals("OK") ? getTrueStatus("error") : getTrueStatus(data.substring(14, 15));
        }
    }
    private String getTrueError(String error){
        switch(error){
            case "001" -> {
                return "LEDTempTooHigh";
            }
            case "002" -> {
                return "LEDTempTooLow";
            }
            case "004" -> {
                return "LEDCurrentMismatch";
            }
            case "008" -> {
                return "TriggerTooFast";
            }
            case "010" -> {
                return "UnableToAssignColor";
            }
            case "040" -> {
                return "Black";
            }
            default -> {
                return "OK";
            }
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
