package org.goznak.tools;

public class CommandList {
    private static final String[] commands = {"020D0s1A", "020D0p19"};
    private static int cur = 0;
    private static final int length = commands.length;

    public static String next(){
        cur = cur == length - 1? 0: cur + 1;
        return commands[cur];
    }

    public static String current(){
        return commands[cur];
    }
    public static String[] getCommands(){
        return commands;
    }
}
