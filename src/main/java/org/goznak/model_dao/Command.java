package org.goznak.model_dao;

import java.nio.charset.StandardCharsets;

public class Command {
    private final String body;
    private final int responseLength;
    public Command(String body, int responseLength) {
        this.body = body;
        this.responseLength = responseLength;
    }
    public RequestCommand getCommand(){
        return new RequestCommand(String.format("/%s.", body), responseLength);
    }
    public RequestCommand getCommand(String[] params){
        return getCommand(params, null);
    }
    public RequestCommand getCommand(String[] params, RequestCommand referenceCommand){
        String fullBody = body;
        for(String param: params){
            fullBody = fullBody.concat(param);
        }
        byte checkSum = '/';
        for(byte b: fullBody.getBytes(StandardCharsets.US_ASCII)){
            checkSum ^= b;
        }
        return new RequestCommand(String.format("/%s%02X.", fullBody, checkSum), responseLength, referenceCommand);
    }
}
