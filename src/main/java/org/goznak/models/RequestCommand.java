package org.goznak.models;

public class RequestCommand {
    String command;
    int length;

    public RequestCommand(String command, int length) {
        this.command = command;
        this.length = length;
    }

    public String getCommand() {
        return command;
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
