package org.goznak.model_dao;

import org.goznak.model_dao.Command;
import org.goznak.model_dao.RequestCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    public static final Command WRITE_PIN_FUNCTION = new Command("030P0", 13);
    public static final Command MAKE_ASSIGNED_TEACH = new Command("040O0A", 14);
    public static final Command WRITE_ASSIGNED_TEACH = new Command("080O0A", 18);
    public static final Command MAKE_WINDOW_TEACH = new Command("040O0a", 14);
    public static final Command WRITE_SWITCHING_POINTS = new Command("140O0a", 30);
    public static final Command WRITE_WINDOW_SIZE = new Command("070O0", 17);
    public static final Command WRITE_WINDOW_SIZE_AUX = new Command("080O0c", 18);
    public static final Command WRITE_DELAY_IMPULSE = new Command("070O0", 17);
    public static final Command WRITE_OPERATING_MODE = new Command("020M0", 12);
    public static final Command WRITE_FILTER_SIZE = new Command("020F0", 12);
    public static final Command WRITE_EMITTED_LIGHT = new Command("020L0", 12);
    public static final Command WRITE_SENSOR_SELECT = new Command("020J0", 12);
    public static final Command WRITE_TEST_OUTPUT = new Command("030t0", 13);
    public static final Command WRITE_EXPERT_MENU = new Command("020E0", 12);
    public static final Command RESET_SENSOR = new Command("000R4D", 15);
    public static final Command _READ_PIN_FUNCTION = new Command("020P0", 13);
    public static final Command _READ_ASSIGNED_TEACH = new Command("040O0A", 18);
    public static final Command _READ_SWITCHING_POINTS = new Command("040O0a", 30);
    public static final Command _READ_RGB = new Command("020D0s1A", 18);
    public static final Command _READ_HSL = new Command("020D0p19", 27);
    public static final Command _READ_XYZ = new Command("020D0r1B", 21);
    public static final Command _READ_WINDOW_SIZE = new Command("030O0", 17);
    public static final Command _READ_WINDOW_SIZE_AUX = new Command("040O0c", 18);
    public static final Command _READ_DELAY = new Command("030O0", 17);
    public static final Command _READ_IMPULSE = new Command("031O0l", 17);
    public static final Command _READ_OPERATING_MODE = new Command("010M063", 12);
    public static final Command _READ_FILTER_SIZE = new Command("010F068", 12);
    public static final Command _READ_EMITTED_LIGHT = new Command("010L062", 12);
    public static final Command _READ_SENSOR_SELECT = new Command("010J064", 12);
    public static final Command _READ_TEST_OUTPUT = new Command("020t0", 13);
    public static final Command _READ_QUERY_STATUS = new Command("000W48", 18);
    public static final Command _READ_EXPERT_MENU = new Command("000E5A", 12);
    public static final Command _READ_SENSOR_VERSION = new Command("000V49", 15);
    public static final RequestCommand READ_PIN1_FUNCTION = _READ_PIN_FUNCTION.getCommand(new String[]{"1"});
    public static final RequestCommand READ_PIN2_FUNCTION = _READ_PIN_FUNCTION.getCommand(new String[]{"2"});
    public static final RequestCommand READ_PIN3_FUNCTION = _READ_PIN_FUNCTION.getCommand(new String[]{"3"});
    public static final RequestCommand READ_ASSIGNED_TEACH_RED_PIN1 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"1", "R"});
    public static final RequestCommand READ_ASSIGNED_TEACH_RED_PIN2 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"2", "R"});
    public static final RequestCommand READ_ASSIGNED_TEACH_RED_PIN3 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"3", "R"});
    public static final RequestCommand READ_ASSIGNED_TEACH_GREEN_PIN1 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"1", "G"});
    public static final RequestCommand READ_ASSIGNED_TEACH_GREEN_PIN2 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"2", "G"});
    public static final RequestCommand READ_ASSIGNED_TEACH_GREEN_PIN3 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"3", "G"});
    public static final RequestCommand READ_ASSIGNED_TEACH_BLUE_PIN1 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"1", "B"});
    public static final RequestCommand READ_ASSIGNED_TEACH_BLUE_PIN2 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"2", "B"});
    public static final RequestCommand READ_ASSIGNED_TEACH_BLUE_PIN3 = _READ_ASSIGNED_TEACH.getCommand(new String[]{"3", "B"});
    public static final RequestCommand READ_SWITCHING_POINTS_RED_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "R"});
    public static final RequestCommand READ_SWITCHING_POINTS_RED_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "R"});
    public static final RequestCommand READ_SWITCHING_POINTS_RED_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "R"});
    public static final RequestCommand READ_SWITCHING_POINTS_GREEN_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "G"});
    public static final RequestCommand READ_SWITCHING_POINTS_GREEN_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "G"});
    public static final RequestCommand READ_SWITCHING_POINTS_GREEN_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "G"});
    public static final RequestCommand READ_SWITCHING_POINTS_BLUE_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "B"});
    public static final RequestCommand READ_SWITCHING_POINTS_BLUE_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "B"});
    public static final RequestCommand READ_SWITCHING_POINTS_BLUE_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "B"});
    public static final RequestCommand READ_SWITCHING_POINTS_SAT_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "S"});
    public static final RequestCommand READ_SWITCHING_POINTS_SAT_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "S"});
    public static final RequestCommand READ_SWITCHING_POINTS_SAT_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "S"});
    public static final RequestCommand READ_SWITCHING_POINTS_LIGHT_PIN1 = _READ_SWITCHING_POINTS.getCommand(new String[]{"1", "L"});
    public static final RequestCommand READ_SWITCHING_POINTS_LIGHT_PIN2 = _READ_SWITCHING_POINTS.getCommand(new String[]{"2", "L"});
    public static final RequestCommand READ_SWITCHING_POINTS_LIGHT_PIN3 = _READ_SWITCHING_POINTS.getCommand(new String[]{"3", "L"});
    public static final RequestCommand READ_RGB = _READ_RGB.getCommand();
    public static final RequestCommand READ_HSL = _READ_HSL.getCommand();
    public static final RequestCommand READ_XYZ = _READ_XYZ.getCommand();
    public static final RequestCommand READ_WINDOW_SIZE_COMMON_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"b", "1"});
    public static final RequestCommand READ_WINDOW_SIZE_COMMON_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"b", "2"});
    public static final RequestCommand READ_WINDOW_SIZE_COMMON_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"b", "3"});
    public static final RequestCommand READ_WINDOW_SIZE_HUE_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"c", "1"});
    public static final RequestCommand READ_WINDOW_SIZE_HUE_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"c", "2"});
    public static final RequestCommand READ_WINDOW_SIZE_HUE_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"c", "3"});
    public static final RequestCommand READ_WINDOW_SIZE_SAT_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"d", "1"});
    public static final RequestCommand READ_WINDOW_SIZE_SAT_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"d", "2"});
    public static final RequestCommand READ_WINDOW_SIZE_SAT_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"d", "3"});
    public static final RequestCommand READ_WINDOW_SIZE_LIGHT_PIN1 = _READ_WINDOW_SIZE.getCommand(new String[]{"e", "1"});
    public static final RequestCommand READ_WINDOW_SIZE_LIGHT_PIN2 = _READ_WINDOW_SIZE.getCommand(new String[]{"e", "2"});
    public static final RequestCommand READ_WINDOW_SIZE_LIGHT_PIN3 = _READ_WINDOW_SIZE.getCommand(new String[]{"e", "3"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_RED_PIN1 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"1", "R"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_RED_PIN2 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"2", "R"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_RED_PIN3 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"3", "R"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_GREEN_PIN1 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"1", "G"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_GREEN_PIN2 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"2", "G"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_GREEN_PIN3 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"3", "G"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_BLUE_PIN1 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"1", "B"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_BLUE_PIN2 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"2", "B"});
    public static final RequestCommand READ_WINDOW_SIZE_AUX_BLUE_PIN3 = _READ_WINDOW_SIZE_AUX.getCommand(new String[]{"3", "B"});
    public static final RequestCommand READ_ON_DELAY_PIN1 = _READ_DELAY.getCommand(new String[]{"j", "1"});
    public static final RequestCommand READ_ON_DELAY_PIN2 = _READ_DELAY.getCommand(new String[]{"j", "2"});
    public static final RequestCommand READ_ON_DELAY_PIN3 = _READ_DELAY.getCommand(new String[]{"j", "3"});
    public static final RequestCommand READ_OFF_DELAY_PIN1 = _READ_DELAY.getCommand(new String[]{"k", "1"});
    public static final RequestCommand READ_OFF_DELAY_PIN2 = _READ_DELAY.getCommand(new String[]{"k", "2"});
    public static final RequestCommand READ_OFF_DELAY_PIN3 = _READ_DELAY.getCommand(new String[]{"k", "3"});
    public static final RequestCommand READ_IMPULSE_PIN1 = _READ_IMPULSE.getCommand(new String[]{"1"});
    public static final RequestCommand READ_IMPULSE_PIN2 = _READ_IMPULSE.getCommand(new String[]{"2"});
    public static final RequestCommand READ_IMPULSE_PIN3 = _READ_IMPULSE.getCommand(new String[]{"3"});
    public static final RequestCommand READ_OPERATING_MODE = _READ_OPERATING_MODE.getCommand();
    public static final RequestCommand READ_FILTER_SIZE = _READ_FILTER_SIZE.getCommand();
    public static final RequestCommand READ_EMITTED_LIGHT = _READ_EMITTED_LIGHT.getCommand();
    public static final RequestCommand READ_SENSOR_SELECT = _READ_SENSOR_SELECT.getCommand();
    public static final RequestCommand READ_TEST_OUTPUT_PIN1 = _READ_TEST_OUTPUT.getCommand(new String[]{"1"});
    public static final RequestCommand READ_TEST_OUTPUT_PIN2 = _READ_TEST_OUTPUT.getCommand(new String[]{"2"});
    public static final RequestCommand READ_TEST_OUTPUT_PIN3 = _READ_TEST_OUTPUT.getCommand(new String[]{"3"});
    public static final RequestCommand READ_QUERY_STATUS = _READ_QUERY_STATUS.getCommand();
    public static final RequestCommand READ_EXPERT_MENU = _READ_EXPERT_MENU.getCommand();
    public static final RequestCommand READ_SENSOR_VERSION = _READ_SENSOR_VERSION.getCommand();
    private static final RequestCommand[] firstPriority = { READ_RGB, READ_HSL, READ_XYZ, READ_QUERY_STATUS };
    private static final RequestCommand[] lastPriority = { READ_PIN1_FUNCTION, READ_PIN2_FUNCTION, READ_PIN3_FUNCTION,
            READ_ASSIGNED_TEACH_RED_PIN1, READ_ASSIGNED_TEACH_RED_PIN2, READ_ASSIGNED_TEACH_RED_PIN3,
            READ_ASSIGNED_TEACH_GREEN_PIN1, READ_ASSIGNED_TEACH_GREEN_PIN2, READ_ASSIGNED_TEACH_GREEN_PIN3,
            READ_ASSIGNED_TEACH_BLUE_PIN1, READ_ASSIGNED_TEACH_BLUE_PIN2, READ_ASSIGNED_TEACH_BLUE_PIN3,
            READ_SWITCHING_POINTS_RED_PIN1, READ_SWITCHING_POINTS_RED_PIN2, READ_SWITCHING_POINTS_RED_PIN3,
            READ_SWITCHING_POINTS_GREEN_PIN1, READ_SWITCHING_POINTS_GREEN_PIN2, READ_SWITCHING_POINTS_GREEN_PIN3,
            READ_SWITCHING_POINTS_BLUE_PIN1, READ_SWITCHING_POINTS_BLUE_PIN2, READ_SWITCHING_POINTS_BLUE_PIN3,
            READ_SWITCHING_POINTS_SAT_PIN1, READ_SWITCHING_POINTS_SAT_PIN2, READ_SWITCHING_POINTS_SAT_PIN3,
            READ_SWITCHING_POINTS_LIGHT_PIN1, READ_SWITCHING_POINTS_LIGHT_PIN2, READ_SWITCHING_POINTS_LIGHT_PIN3,
            READ_WINDOW_SIZE_COMMON_PIN1, READ_WINDOW_SIZE_COMMON_PIN2,
            READ_WINDOW_SIZE_COMMON_PIN3, READ_WINDOW_SIZE_HUE_PIN1, READ_WINDOW_SIZE_HUE_PIN2,
            READ_WINDOW_SIZE_HUE_PIN3, READ_WINDOW_SIZE_SAT_PIN1, READ_WINDOW_SIZE_SAT_PIN2,
            READ_WINDOW_SIZE_SAT_PIN3, READ_WINDOW_SIZE_LIGHT_PIN1, READ_WINDOW_SIZE_LIGHT_PIN2,
            READ_WINDOW_SIZE_LIGHT_PIN3, READ_WINDOW_SIZE_AUX_RED_PIN1, READ_WINDOW_SIZE_AUX_RED_PIN2,
            READ_WINDOW_SIZE_AUX_RED_PIN3, READ_WINDOW_SIZE_AUX_GREEN_PIN1, READ_WINDOW_SIZE_AUX_GREEN_PIN2,
            READ_WINDOW_SIZE_AUX_GREEN_PIN3, READ_WINDOW_SIZE_AUX_BLUE_PIN1, READ_WINDOW_SIZE_AUX_BLUE_PIN2,
            READ_WINDOW_SIZE_AUX_BLUE_PIN3, READ_ON_DELAY_PIN1, READ_ON_DELAY_PIN2, READ_ON_DELAY_PIN3,
            READ_OFF_DELAY_PIN1, READ_OFF_DELAY_PIN2, READ_OFF_DELAY_PIN3, READ_OPERATING_MODE, READ_FILTER_SIZE,
            READ_EMITTED_LIGHT, READ_SENSOR_SELECT, READ_EXPERT_MENU, READ_SENSOR_VERSION, READ_IMPULSE_PIN1,
            READ_IMPULSE_PIN2, READ_IMPULSE_PIN3,READ_TEST_OUTPUT_PIN1, READ_TEST_OUTPUT_PIN2, READ_TEST_OUTPUT_PIN3};
    private static RequestCommand writeCommand;
    private static int firstPriorityCur = 0;
    private static int lastPriorityCur = 0;
    private static int countPriority = 0;
    private static RequestCommand writeCommandRetain;
    public static RequestCommand readPinFunction(int channel){
        return switch (channel) {
            case 1 -> READ_PIN1_FUNCTION;
            case 2 -> READ_PIN2_FUNCTION;
            default -> READ_PIN3_FUNCTION;
        };
    }
    public static RequestCommand readAssignedTeachRed(int channel){
        return switch (channel) {
            case 1 -> READ_ASSIGNED_TEACH_RED_PIN1;
            case 2 -> READ_ASSIGNED_TEACH_RED_PIN2;
            default -> READ_ASSIGNED_TEACH_RED_PIN3;
        };
    }
    public static RequestCommand readAssignedTeachGreen(int channel){
        return switch (channel) {
            case 1 -> READ_ASSIGNED_TEACH_GREEN_PIN1;
            case 2 -> READ_ASSIGNED_TEACH_GREEN_PIN2;
            default -> READ_ASSIGNED_TEACH_GREEN_PIN3;
        };
    }
    public static RequestCommand readAssignedTeachBlue(int channel){
        return switch (channel) {
            case 1 -> READ_ASSIGNED_TEACH_BLUE_PIN1;
            case 2 -> READ_ASSIGNED_TEACH_BLUE_PIN2;
            default -> READ_ASSIGNED_TEACH_BLUE_PIN3;
        };
    }
    public static RequestCommand readSwitchingPointsRed(int channel){
        return switch (channel) {
            case 1 -> READ_SWITCHING_POINTS_RED_PIN1;
            case 2 -> READ_SWITCHING_POINTS_RED_PIN2;
            default -> READ_SWITCHING_POINTS_RED_PIN3;
        };
    }
    public static RequestCommand readSwitchingPointsGreen(int channel){
        return switch (channel) {
            case 1 -> READ_SWITCHING_POINTS_GREEN_PIN1;
            case 2 -> READ_SWITCHING_POINTS_GREEN_PIN2;
            default -> READ_SWITCHING_POINTS_GREEN_PIN3;
        };
    }
    public static RequestCommand readSwitchingPointsBlue(int channel){
        return switch (channel) {
            case 1 -> READ_SWITCHING_POINTS_BLUE_PIN1;
            case 2 -> READ_SWITCHING_POINTS_BLUE_PIN2;
            default -> READ_SWITCHING_POINTS_BLUE_PIN3;
        };
    }
    public static RequestCommand readSwitchingPointsSat(int channel){
        return switch (channel) {
            case 1 -> READ_SWITCHING_POINTS_SAT_PIN1;
            case 2 -> READ_SWITCHING_POINTS_SAT_PIN2;
            default -> READ_SWITCHING_POINTS_SAT_PIN3;
        };
    }
    public static RequestCommand readSwitchingPointsLight(int channel){
        return switch (channel) {
            case 1 -> READ_SWITCHING_POINTS_LIGHT_PIN1;
            case 2 -> READ_SWITCHING_POINTS_LIGHT_PIN2;
            default -> READ_SWITCHING_POINTS_LIGHT_PIN3;
        };
    }
    public static RequestCommand readWindowSizeComm(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_COMMON_PIN1;
            case 2 -> READ_WINDOW_SIZE_COMMON_PIN2;
            default -> READ_WINDOW_SIZE_COMMON_PIN3;
        };
    }
    public static RequestCommand readWindowSizeHue(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_HUE_PIN1;
            case 2 -> READ_WINDOW_SIZE_HUE_PIN2;
            default -> READ_WINDOW_SIZE_HUE_PIN3;
        };
    }
    public static RequestCommand readWindowSizeSat(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_SAT_PIN1;
            case 2 -> READ_WINDOW_SIZE_SAT_PIN2;
            default -> READ_WINDOW_SIZE_SAT_PIN3;
        };
    }
    public static RequestCommand readWindowSizeLight(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_LIGHT_PIN1;
            case 2 -> READ_WINDOW_SIZE_LIGHT_PIN2;
            default -> READ_WINDOW_SIZE_LIGHT_PIN3;
        };
    }
    public static RequestCommand readWindowSizeRed(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_AUX_RED_PIN1;
            case 2 -> READ_WINDOW_SIZE_AUX_RED_PIN2;
            default -> READ_WINDOW_SIZE_AUX_RED_PIN3;
        };
    }
    public static RequestCommand readWindowSizeGreen(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_AUX_GREEN_PIN1;
            case 2 -> READ_WINDOW_SIZE_AUX_GREEN_PIN2;
            default -> READ_WINDOW_SIZE_AUX_GREEN_PIN3;
        };
    }
    public static RequestCommand readWindowSizeBlue(int channel){
        return switch (channel) {
            case 1 -> READ_WINDOW_SIZE_AUX_BLUE_PIN1;
            case 2 -> READ_WINDOW_SIZE_AUX_BLUE_PIN2;
            default -> READ_WINDOW_SIZE_AUX_BLUE_PIN3;
        };
    }
    public static RequestCommand readOnDelay(int channel){
        return switch (channel) {
            case 1 -> READ_ON_DELAY_PIN1;
            case 2 -> READ_ON_DELAY_PIN2;
            default -> READ_ON_DELAY_PIN3;
        };
    }
    public static RequestCommand readOffDelay(int channel){
        return switch (channel) {
            case 1 -> READ_OFF_DELAY_PIN1;
            case 2 -> READ_OFF_DELAY_PIN2;
            default -> READ_OFF_DELAY_PIN3;
        };
    }
    public static RequestCommand readImpulse(int channel){
        return switch (channel) {
            case 1 -> READ_IMPULSE_PIN1;
            case 2 -> READ_IMPULSE_PIN2;
            default -> READ_IMPULSE_PIN3;
        };
    }
    public static RequestCommand readTestOutput(int channel){
        return switch (channel) {
            case 1 -> READ_TEST_OUTPUT_PIN1;
            case 2 -> READ_TEST_OUTPUT_PIN2;
            default -> READ_TEST_OUTPUT_PIN3;
        };
    }
    public static RequestCommand next(){
        if (writeCommand != null) {
            writeCommandRetain = writeCommand;
            writeCommand = null;
            return writeCommandRetain;
        } else {
            writeCommandRetain = null;
        }
        countPriority = countPriority >= 2? 0: ++countPriority;
        if (countPriority == 1) {
            lastPriorityCur = lastPriorityCur >= lastPriority.length - 1 ? 0 : ++lastPriorityCur;
            return current();
        }
        firstPriorityCur = firstPriorityCur >= firstPriority.length - 1 ? 0 : ++firstPriorityCur;
        return current();
    }
    public static RequestCommand current(){
        if (writeCommandRetain != null){
            return writeCommandRetain;
        }
        if (countPriority == 1) {
            return lastPriority[lastPriorityCur];
        }
        return firstPriority[firstPriorityCur];
    }
    public static RequestCommand[] getReadCommands(){
        ArrayList<RequestCommand> list = new ArrayList<>(List.of(firstPriority));
        list.addAll(List.of(lastPriority));
        return list.toArray(RequestCommand[]::new);
    }
    public static void setWriteCommand(RequestCommand command){
        if(writeCommand == null) {
            writeCommand = command;
        }
    }
}