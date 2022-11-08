package org.goznak.models;

import java.nio.charset.StandardCharsets;

public class Command {
    private String body;
    private String[] params;

    public Command(String body) {
        this.body = body;
    }
    public String getCommand(){
        return String.format("/%s.", body);
    }
    public String getCommand(String[] params){
        String fullBody = body;
        for(String param: params){
            fullBody = fullBody.concat(param);
        }
        byte checkSum = '/';
        for(byte b: fullBody.getBytes(StandardCharsets.US_ASCII)){
            checkSum ^= b;
        }
        return String.format("/%s%02X.", fullBody, checkSum);
    }
}
