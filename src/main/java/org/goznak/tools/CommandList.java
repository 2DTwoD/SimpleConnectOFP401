package org.goznak.tools;

import org.goznak.models.Command;

public class CommandList {
    public static final Command WRITE_PIN_FUNCTION = new Command("030P0");
    public static final Command MAKE_ASSIGNED_TEACH = new Command("040O0A");
    public static final Command WRITE_ASSIGNED_TEACH = new Command("080O0A");
    public static final Command MAKE_WINDOW_TEACH = new Command("040O0a");
    public static final Command WRITE_SWITCHING_POINTS = new Command("140O0a");
    public static final Command WRITE_WINDOW_SIZE = new Command("070O0");
    public static final Command WRITE_WINDOW_SIZE_AUX = new Command("080O0c");
    public static final Command WRITE_DELAY_IMPULSE = new Command("070O0");
    public static final Command WRITE_OPERATING_MODE = new Command("020M0");
    public static final Command WRITE_FILTER_SIZE = new Command("020F0");
    public static final Command WRITE_EMITTED_LIGHT = new Command("020L0");
    public static final Command WRITE_SENSOR_SELECT = new Command("020J0");
    public static final Command WRITE_TEST_OUTPUT = new Command("030t0");
    public static final Command WRITE_EXPERT_MENU = new Command("020E");
    public static final Command RESET_SENSOR = new Command("000R4D");
    public static final Command _READ_PIN_FUNCTION = new Command("020P0");
    public static final Command _READ_SWITCHING_POINTS = new Command("040O0a");
    public static final Command _READ_RGB = new Command("020D0s1A");
    public static final Command _READ_HSL = new Command("020D0p19");
    public static final Command _READ_XYZ = new Command("020D0r1B");
    public static final Command _READ_WINDOW_SIZE = new Command("030O0");
    public static final Command _READ_WINDOW_SIZE_AUX = new Command("040O0c");
    public static final Command _READ_DELAY = new Command("030O0");
    public static final Command _READ_IMPULSE = new Command("031000F0O0l");
    public static final Command _READ_OPERATING_MODE = new Command("010M063");
    public static final Command _READ_FILTER_SIZE = new Command("010F068");
    public static final Command _READ_EMITTED_LIGHT = new Command("010L062");
    public static final Command _READ_SENSOR_SELECT = new Command("010J064");
    public static final Command _READ_TEST_OUTPUT = new Command("020t0");
    public static final Command _READ_QUERY_STATUS = new Command("000W48");
    public static final Command _READ_EXPERT_MENU = new Command("000E5A");
    public static final Command _READ_SENSOR_VERSION = new Command("000V49");
    public static final String READ_PIN1_FUNCTION = _READ_PIN_FUNCTION.getCommand(new String[]{"1"});
    public static final String READ_PIN2_FUNCTION = _READ_PIN_FUNCTION.getCommand(new String[]{"2"});
    public static final String READ_PIN3_FUNCTION = _READ_PIN_FUNCTION.getCommand(new String[]{"3"});
    public static final String READ_SWITCHING_POINTS_RED_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "R"});
    public static final String READ_SWITCHING_POINTS_RED_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "R"});
    public static final String READ_SWITCHING_POINTS_RED_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "R"});
    public static final String READ_SWITCHING_POINTS_GREEN_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "G"});
    public static final String READ_SWITCHING_POINTS_GREEN_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "G"});
    public static final String READ_SWITCHING_POINTS_GREEN_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "G"});
    public static final String READ_SWITCHING_POINTS_BLUE_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "B"});
    public static final String READ_SWITCHING_POINTS_BLUE_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "B"});
    public static final String READ_SWITCHING_POINTS_BLUE_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "B"});
    public static final String READ_SWITCHING_POINTS_SAT_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "S"});
    public static final String READ_SWITCHING_POINTS_SAT_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "S"});
    public static final String READ_SWITCHING_POINTS_SAT_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "S"});
    public static final String READ_SWITCHING_POINTS_LIGHT_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "L"});
    public static final String READ_SWITCHING_POINTS_LIGHT_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "L"});
    public static final String READ_SWITCHING_POINTS_LIGHT_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "L"});
    public static final String READ_RGB = _READ_RGB.getCommand();
    public static final String READ_HSL = _READ_HSL.getCommand();
    public static final String READ_XYZ = _READ_XYZ.getCommand();
    public static final String READ_WINDOW_SIZE_COMMON_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"b", "1"});
    public static final String READ_WINDOW_SIZE_COMMON_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"b", "2"});
    public static final String READ_WINDOW_SIZE_COMMON_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"b", "3"});
    public static final String READ_WINDOW_SIZE_HUE_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"c", "1"});
    public static final String READ_WINDOW_SIZE_HUE_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"c", "2"});
    public static final String READ_WINDOW_SIZE_HUE_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"c", "3"});
    public static final String READ_WINDOW_SIZE_SAT_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"d", "1"});
    public static final String READ_WINDOW_SIZE_SAT_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"d", "2"});
    public static final String READ_WINDOW_SIZE_SAT_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"d", "3"});
    public static final String READ_WINDOW_SIZE_LIGHT_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"e", "1"});
    public static final String READ_WINDOW_SIZE_LIGHT_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"e", "2"});
    public static final String READ_WINDOW_SIZE_LIGHT_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"e", "3"});
    public static final String READ_WINDOW_SIZE_AUX_RED_PIN1 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"1", "R"});
    public static final String READ_WINDOW_SIZE_AUX_RED_PIN2 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"2", "R"});
    public static final String READ_WINDOW_SIZE_AUX_RED_PIN3 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"3", "R"});
    public static final String READ_WINDOW_SIZE_AUX_GREEN_PIN1 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"1", "G"});
    public static final String READ_WINDOW_SIZE_AUX_GREEN_PIN2 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"2", "G"});
    public static final String READ_WINDOW_SIZE_AUX_GREEN_PIN3 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"3", "G"});
    public static final String READ_WINDOW_SIZE_AUX_BLUE_PIN1 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"1", "B"});
    public static final String READ_WINDOW_SIZE_AUX_BLUE_PIN2 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"2", "B"});
    public static final String READ_WINDOW_SIZE_AUX_BLUE_PIN3 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"3", "B"});
    public static final String READ_ON_DELAY_PIN1 = _READ_DELAY.getCommand(new String[]{"j", "1"});
    public static final String READ_ON_DELAY_PIN2 = _READ_DELAY.getCommand(new String[]{"j", "2"});
    public static final String READ_ON_DELAY_PIN3 = _READ_DELAY.getCommand(new String[]{"j", "3"});
    public static final String READ_OFF_DELAY_PIN1 = _READ_DELAY.getCommand(new String[]{"k", "1"});
    public static final String READ_OFF_DELAY_PIN2 = _READ_DELAY.getCommand(new String[]{"k", "2"});
    public static final String READ_OFF_DELAY_PIN3 = _READ_DELAY.getCommand(new String[]{"k", "3"});
    public static final String READ_IMPULSE_PIN1 = _READ_IMPULSE.getCommand(new String[]{"1"});
    public static final String READ_IMPULSE_PIN2 = _READ_IMPULSE.getCommand(new String[]{"2"});
    public static final String READ_IMPULSE_PIN3 = _READ_IMPULSE.getCommand(new String[]{"3"});
    public static final String READ_OPERATING_MODE = _READ_OPERATING_MODE.getCommand();
    public static final String READ_FILTER_SIZE = _READ_FILTER_SIZE.getCommand();
    public static final String READ_EMITTED_LIGHT = _READ_EMITTED_LIGHT.getCommand();
    public static final String READ_SENSOR_SELECT = _READ_SENSOR_SELECT.getCommand();
    public static final String READ_TEST_OUTPUT_PIN1 = _READ_TEST_OUTPUT.getCommand(new String[]{"1"});
    public static final String READ_TEST_OUTPUT_PIN2 = _READ_TEST_OUTPUT.getCommand(new String[]{"2"});
    public static final String READ_TEST_OUTPUT_PIN3 = _READ_TEST_OUTPUT.getCommand(new String[]{"3"});
    public static final String READ_QUERY_STATUS = _READ_QUERY_STATUS.getCommand();
    public static final String READ_EXPERT_MENU = _READ_EXPERT_MENU.getCommand();
    public static final String READ_SENSOR_VERSION = _READ_SENSOR_VERSION.getCommand();

    private static final String[] readCommands = { READ_PIN1_FUNCTION, READ_PIN2_FUNCTION, READ_PIN3_FUNCTION,
            READ_SWITCHING_POINTS_RED_PIN1, READ_SWITCHING_POINTS_RED_PIN2, READ_SWITCHING_POINTS_RED_PIN3,
            READ_SWITCHING_POINTS_GREEN_PIN1, READ_SWITCHING_POINTS_GREEN_PIN2, READ_SWITCHING_POINTS_GREEN_PIN3,
            READ_SWITCHING_POINTS_BLUE_PIN1, READ_SWITCHING_POINTS_BLUE_PIN2, READ_SWITCHING_POINTS_BLUE_PIN3,
            READ_SWITCHING_POINTS_SAT_PIN1, READ_SWITCHING_POINTS_SAT_PIN2, READ_SWITCHING_POINTS_SAT_PIN3,
            READ_SWITCHING_POINTS_LIGHT_PIN1, READ_SWITCHING_POINTS_LIGHT_PIN2, READ_SWITCHING_POINTS_LIGHT_PIN3,
            READ_RGB, READ_HSL, READ_XYZ, READ_WINDOW_SIZE_COMMON_PIN1, READ_WINDOW_SIZE_COMMON_PIN2,
            READ_WINDOW_SIZE_COMMON_PIN3, READ_WINDOW_SIZE_HUE_PIN1, READ_WINDOW_SIZE_HUE_PIN2,
            READ_WINDOW_SIZE_HUE_PIN3, READ_WINDOW_SIZE_SAT_PIN1, READ_WINDOW_SIZE_SAT_PIN2,
            READ_WINDOW_SIZE_SAT_PIN3, READ_WINDOW_SIZE_LIGHT_PIN1, READ_WINDOW_SIZE_LIGHT_PIN2,
            READ_WINDOW_SIZE_LIGHT_PIN3, READ_WINDOW_SIZE_AUX_RED_PIN1, READ_WINDOW_SIZE_AUX_RED_PIN2,
            READ_WINDOW_SIZE_AUX_RED_PIN3, READ_WINDOW_SIZE_AUX_GREEN_PIN1, READ_WINDOW_SIZE_AUX_GREEN_PIN2,
            READ_WINDOW_SIZE_AUX_GREEN_PIN3, READ_WINDOW_SIZE_AUX_BLUE_PIN1, READ_WINDOW_SIZE_AUX_BLUE_PIN2,
            READ_WINDOW_SIZE_AUX_BLUE_PIN3, READ_ON_DELAY_PIN1, READ_ON_DELAY_PIN2, READ_ON_DELAY_PIN3,
            READ_OFF_DELAY_PIN1, READ_OFF_DELAY_PIN2, READ_OFF_DELAY_PIN3, READ_IMPULSE_PIN1, READ_IMPULSE_PIN2,
            READ_IMPULSE_PIN3, READ_OPERATING_MODE, READ_FILTER_SIZE, READ_EMITTED_LIGHT, READ_SENSOR_SELECT,
            READ_TEST_OUTPUT_PIN1, READ_TEST_OUTPUT_PIN2, READ_TEST_OUTPUT_PIN3, READ_QUERY_STATUS, READ_EXPERT_MENU,
            READ_SENSOR_VERSION };
    private static int cur = 0;
    private static final int length = readCommands.length;

    public static String next(){
        cur = cur == length - 1? 0: cur + 1;
        return current();
    }

    public static String current(){
        return readCommands[cur];
    }
    public static String[] getReadCommands(){
        return readCommands;
    }
}
