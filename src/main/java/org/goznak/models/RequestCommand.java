package org.goznak.models;

public class RequestCommand {
    String command;
    RequestCommand referenceCommand;
    int length;

    public RequestCommand(String command, int length) {
        this.command = command;
        this.length = length;
    }
    public RequestCommand(String command, int length, RequestCommand readReference) {
        this.command = command;
        this.length = length;
        this.referenceCommand = readReference;
    }
    public String getCommand() {
        return command;
    }
    public RequestCommand getReferenceCommand() {
        return referenceCommand;
    }

    public int getLength() {
        return length;
    }
    @Override
    public int hashCode()
    {
        return command.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return command.equals(obj);
    }
}
