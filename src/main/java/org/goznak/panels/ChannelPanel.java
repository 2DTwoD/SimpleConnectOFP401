package org.goznak.panels;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import org.goznak.App;
import org.goznak.inputs.NumericTextField;
import org.goznak.model_dao.DataFromSensor;
import org.goznak.tools.ConnectTool;
import org.goznak.tools.Dialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ChannelPanel extends Parent implements Initializable {
    @Autowired
    DataFromSensor dataFromSensor;
    @Autowired
    ConnectTool connectTool;
    ScheduledExecutorService executorService;
    @FXML
    Label channelFunctionLabel;
    @FXML
    ComboBox<String> channelFunctionCombo;
    @FXML
    Button applyChannelFunctionButton;
    @FXML
    Button assignTeachButton;
    @FXML
    Button windowTeachButton;
    @FXML
    Button windowTeachOKButton;
    @FXML
    Button windowTeachNOKButton;
    @FXML
    Label assignRedLabel;
    @FXML
    Label assignGreenLabel;
    @FXML
    Label assignBlueLabel;
    @FXML
    NumericTextField assignRedField;
    @FXML
    NumericTextField assignGreenField;
    @FXML
    NumericTextField assignBlueField;
    @FXML
    Button applyAssignRedButton;
    @FXML
    Button applyAssignGreenButton;
    @FXML
    Button applyAssignBlueButton;
    @FXML
    Label winCommLabel;
    @FXML
    Label winHueLabel;
    @FXML
    Label winSatLabel;
    @FXML
    Label winLightLabel;
    @FXML
    Label winRedLabel;
    @FXML
    Label winGreenLabel;
    @FXML
    Label winBlueLabel;
    @FXML
    NumericTextField winCommField;
    @FXML
    NumericTextField winHueField;
    @FXML
    NumericTextField winSatField;
    @FXML
    NumericTextField winLightField;
    @FXML
    NumericTextField winRedField;
    @FXML
    NumericTextField winGreenField;
    @FXML
    NumericTextField winBlueField;
    @FXML
    Button applyWinCommButton;
    @FXML
    Button applyWinHueButton;
    @FXML
    Button applyWinSatButton;
    @FXML
    Button applyWinLightButton;
    @FXML
    Button applyWinRedButton;
    @FXML
    Button applyWinGreenButton;
    @FXML
    Button applyWinBlueButton;
    @FXML
    Label onDelayLabel;
    @FXML
    Label offDelayLabel;
    @FXML
    Label impulseLabel;
    @FXML
    NumericTextField onDelayField;
    @FXML
    NumericTextField offDelayField;
    @FXML
    NumericTextField impulseField;
    @FXML
    Button onDelayButton;
    @FXML
    Button offDelayButton;
    @FXML
    Button impulseButton;
    @FXML
    ComboBox<String> testCombo;
    @FXML
    CheckBox testCheckBox;
    @FXML
    Label spRedHoffLabel;
    @FXML
    Label spRedHonLabel;
    @FXML
    Label spRedLonLabel;
    @FXML
    Label spRedLoffLabel;
    @FXML
    Label spGreenHoffLabel;
    @FXML
    Label spGreenHonLabel;
    @FXML
    Label spGreenLonLabel;
    @FXML
    Label spGreenLoffLabel;
    @FXML
    Label spBlueHoffLabel;
    @FXML
    Label spBlueHonLabel;
    @FXML
    Label spBlueLonLabel;
    @FXML
    Label spBlueLoffLabel;
    @FXML
    Label spSatHoffLabel;
    @FXML
    Label spSatHonLabel;
    @FXML
    Label spSatLonLabel;
    @FXML
    Label spSatLoffLabel;
    @FXML
    Label spLightHoffLabel;
    @FXML
    Label spLightHonLabel;
    @FXML
    Label spLightLonLabel;
    @FXML
    Label spLightLoffLabel;
    @FXML
    NumericTextField spRedHoffField;
    @FXML
    NumericTextField spRedHonField;
    @FXML
    NumericTextField spRedLonField;
    @FXML
    NumericTextField spRedLoffField;
    @FXML
    NumericTextField spGreenHoffField;
    @FXML
    NumericTextField spGreenHonField;
    @FXML
    NumericTextField spGreenLonField;
    @FXML
    NumericTextField spGreenLoffField;
    @FXML
    NumericTextField spBlueHoffField;
    @FXML
    NumericTextField spBlueHonField;
    @FXML
    NumericTextField spBlueLonField;
    @FXML
    NumericTextField spBlueLoffField;
    @FXML
    NumericTextField spSatHoffField;
    @FXML
    NumericTextField spSatHonField;
    @FXML
    NumericTextField spSatLonField;
    @FXML
    NumericTextField spSatLoffField;
    @FXML
    NumericTextField spLightHoffField;
    @FXML
    NumericTextField spLightHonField;
    @FXML
    NumericTextField spLightLonField;
    @FXML
    NumericTextField spLightLoffField;
    @FXML
    Button spRedHoffButton;
    @FXML
    Button spRedHonButton;
    @FXML
    Button spRedLonButton;
    @FXML
    Button spRedLoffButton;
    @FXML
    Button spGreenHoffButton;
    @FXML
    Button spGreenHonButton;
    @FXML
    Button spGreenLonButton;
    @FXML
    Button spGreenLoffButton;
    @FXML
    Button spBlueHoffButton;
    @FXML
    Button spBlueHonButton;
    @FXML
    Button spBlueLonButton;
    @FXML
    Button spBlueLoffButton;
    @FXML
    Button spSatHoffButton;
    @FXML
    Button spSatHonButton;
    @FXML
    Button spSatLonButton;
    @FXML
    Button spSatLoffButton;
    @FXML
    Button spLightHoffButton;
    @FXML
    Button spLightHonButton;
    @FXML
    Button spLightLonButton;
    @FXML
    Button spLightLoffButton;
    @FXML
    Label titleLabel;
    @FXML
    Label testLabel;
    private int channel;
    boolean connectedAux;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        channelFunctionCombo.setValue("?");
        ObservableList<String> testList = DataFromSensor.getTestOutputListCut();
        testCombo.setItems(testList);
        testCombo.setValue(testList.get(0));
        applyChannelFunctionButton.setOnAction(e -> setPinFunction());
        assignTeachButton.setOnAction(e -> makeAssignedTeach());
        applyAssignRedButton.setOnAction(e -> setAssignTeach(assignRedField.getText(), dataFromSensor.getAssignedTeachRed(channel), "R"));
        applyAssignGreenButton.setOnAction(e -> setAssignTeach(assignGreenField.getText(), dataFromSensor.getAssignedTeachGreen(channel), "G"));
        applyAssignBlueButton.setOnAction(e -> setAssignTeach(assignBlueField.getText(), dataFromSensor.getAssignedTeachBlue(channel), "B"));
        windowTeachButton.setOnAction(e -> makeWindowTeach("0"));
        windowTeachOKButton.setOnAction(e -> makeWindowTeach("1"));
        windowTeachNOKButton.setOnAction(e -> makeWindowTeach("2"));
        spRedHoffButton.setOnAction(e -> setSwitchingPoints(spRedHoffField.getText(), dataFromSensor.getSwitchingPointsRed(channel)[0], "R", "Hoff"));
        spRedHonButton.setOnAction(e -> setSwitchingPoints(spRedHonField.getText(), dataFromSensor.getSwitchingPointsRed(channel)[1], "R", "Hon"));
        spRedLonButton.setOnAction(e -> setSwitchingPoints(spRedLonField.getText(), dataFromSensor.getSwitchingPointsRed(channel)[2], "R", "Lon"));
        spRedLoffButton.setOnAction(e -> setSwitchingPoints(spRedLoffField.getText(), dataFromSensor.getSwitchingPointsRed(channel)[3], "R", "Loff"));
        spGreenHoffButton.setOnAction(e -> setSwitchingPoints(spGreenHoffField.getText(), dataFromSensor.getSwitchingPointsGreen(channel)[0], "G", "Hoff"));
        spGreenHonButton.setOnAction(e -> setSwitchingPoints(spGreenHonField.getText(), dataFromSensor.getSwitchingPointsGreen(channel)[1], "G", "Hon"));
        spGreenLonButton.setOnAction(e -> setSwitchingPoints(spGreenLonField.getText(), dataFromSensor.getSwitchingPointsGreen(channel)[2], "G", "Lon"));
        spGreenLoffButton.setOnAction(e -> setSwitchingPoints(spGreenLoffField.getText(), dataFromSensor.getSwitchingPointsGreen(channel)[3], "G", "Loff"));
        spBlueHoffButton.setOnAction(e -> setSwitchingPoints(spBlueHoffField.getText(), dataFromSensor.getSwitchingPointsBlue(channel)[0], "B", "Hoff"));
        spBlueHonButton.setOnAction(e -> setSwitchingPoints(spBlueHonField.getText(), dataFromSensor.getSwitchingPointsBlue(channel)[1], "B", "Hon"));
        spBlueLonButton.setOnAction(e -> setSwitchingPoints(spBlueLonField.getText(), dataFromSensor.getSwitchingPointsBlue(channel)[2], "B", "Lon"));
        spBlueLoffButton.setOnAction(e -> setSwitchingPoints(spBlueLoffField.getText(), dataFromSensor.getSwitchingPointsBlue(channel)[3], "B", "Loff"));
        spSatHoffButton.setOnAction(e -> setSwitchingPoints(spSatHoffField.getText(), dataFromSensor.getSwitchingPointsSat(channel)[0], "S", "Hoff"));
        spSatHonButton.setOnAction(e -> setSwitchingPoints(spSatHonField.getText(), dataFromSensor.getSwitchingPointsSat(channel)[1], "S", "Hon"));
        spSatLonButton.setOnAction(e -> setSwitchingPoints(spSatLonField.getText(), dataFromSensor.getSwitchingPointsSat(channel)[2], "S", "Lon"));
        spSatLoffButton.setOnAction(e -> setSwitchingPoints(spSatLoffField.getText(), dataFromSensor.getSwitchingPointsSat(channel)[3], "S", "Loff"));
        spLightHoffButton.setOnAction(e -> setSwitchingPoints(spLightHoffField.getText(), dataFromSensor.getSwitchingPointsLight(channel)[0], "L", "Hoff"));
        spLightHonButton.setOnAction(e -> setSwitchingPoints(spLightHonField.getText(), dataFromSensor.getSwitchingPointsLight(channel)[1], "L", "Hon"));
        spLightLonButton.setOnAction(e -> setSwitchingPoints(spLightLonField.getText(), dataFromSensor.getSwitchingPointsLight(channel)[2], "L", "Lon"));
        spLightLoffButton.setOnAction(e -> setSwitchingPoints(spLightLoffField.getText(), dataFromSensor.getSwitchingPointsLight(channel)[3], "L", "Loff"));
        applyWinCommButton.setOnAction(e-> setWindowSize(winCommField.getText(), dataFromSensor.getWinSizeComm(channel), "b"));
        applyWinHueButton.setOnAction(e-> setWindowSize(winHueField.getText(), dataFromSensor.getWinSizeHue(channel), "c"));
        applyWinSatButton.setOnAction(e-> setWindowSize(winSatField.getText(), dataFromSensor.getWinSizeSat(channel), "d"));
        applyWinLightButton.setOnAction(e-> setWindowSize(winLightField.getText(), dataFromSensor.getWinSizeLight(channel), "e"));
        applyWinRedButton.setOnAction(e-> setWindowSize(winRedField.getText(), dataFromSensor.getWinSizeRed(channel), "R"));
        applyWinGreenButton.setOnAction(e-> setWindowSize(winGreenField.getText(), dataFromSensor.getWinSizeGreen(channel), "G"));
        applyWinBlueButton.setOnAction(e-> setWindowSize(winBlueField.getText(), dataFromSensor.getWinSizeBlue(channel), "B"));
        onDelayButton.setOnAction(e-> setDelayImpulse(onDelayField.getText(), dataFromSensor.getOnDelay(channel), "j"));
        offDelayButton.setOnAction(e-> setDelayImpulse(offDelayField.getText(), dataFromSensor.getOffDelay(channel), "k"));
        impulseButton.setOnAction(e-> setDelayImpulse(impulseField.getText(), dataFromSensor.getImpulse(channel), "l"));
        testCombo.setOnAction(e -> changeTestOutput());
        testCheckBox.setOnAction(e -> setTestOutput());
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                Platform.runLater(this::runTime);
            }
            catch(Exception e){
                Platform.runLater(() -> Dialog.getError(e));
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }
    public void setChannel(int value){
        channel = value;
        titleLabel.setText("?????????????????? ???????????? A" + channel + ":");
        channelFunctionCombo.setItems(DataFromSensor.getChannelFunctionList(channel));
    }
    private void runTime(){
        String channelFunction = dataFromSensor.getChannelFunction(channel);
        int channelFunctionIndex = DataFromSensor.getChannelFunctionList(channel).indexOf(channelFunction);
        int assignedTechRed = dataFromSensor.getAssignedTeachRed(channel);
        int assignedTechGreen = dataFromSensor.getAssignedTeachGreen(channel);
        int assignedTechBlue = dataFromSensor.getAssignedTeachBlue(channel);
        int[] switchingPointsRed = dataFromSensor.getSwitchingPointsRed(channel);
        int[] switchingPointsGreen = dataFromSensor.getSwitchingPointsGreen(channel);
        int[] switchingPointsBlue = dataFromSensor.getSwitchingPointsBlue(channel);
        int[] switchingPointsSat = dataFromSensor.getSwitchingPointsSat(channel);
        int[] switchingPointsLight = dataFromSensor.getSwitchingPointsLight(channel);
        int winSizeComm = dataFromSensor.getWinSizeComm(channel);
        int winSizeHue = dataFromSensor.getWinSizeHue(channel);
        int winSizeSat = dataFromSensor.getWinSizeSat(channel);
        int winSizeLight = dataFromSensor.getWinSizeLight(channel);
        int winSizeRed = dataFromSensor.getWinSizeRed(channel);
        int winSizeGreen = dataFromSensor.getWinSizeGreen(channel);
        int winSizeBlue = dataFromSensor.getWinSizeBlue(channel);
        int onDelay = dataFromSensor.getOnDelay(channel);
        int offDelay = dataFromSensor.getOffDelay(channel);
        int impulse = dataFromSensor.getImpulse(channel);
        String testOutput = dataFromSensor.getTestOutput(channel);
        boolean withoutOptionFunction = channelFunctionIndex > 18 || channelFunctionIndex == 0;
        boolean disableOffDelay = impulse > 0;
        boolean connected = connectTool.connected() || connectedAux;
        ObservableList<String> opModeList = DataFromSensor.getOpModeList();
        boolean modeHSL = !dataFromSensor.getOpMode().equals(opModeList.get(0)) || !connected || withoutOptionFunction;
        boolean modeAssign = !dataFromSensor.getOpMode().equals(opModeList.get(1)) || !connected || withoutOptionFunction;
        boolean modeRGB = !dataFromSensor.getOpMode().equals(opModeList.get(2)) || !connected || withoutOptionFunction;
        boolean modeHSLRGB = !modeAssign || !connected || withoutOptionFunction;
        connectedAux = connectTool.connected();

        applyChannelFunctionButton.setDisable(!connected);
        assignTeachButton.setDisable(modeAssign);

        disableNodes(assignRedLabel, assignRedField, applyAssignRedButton, modeAssign);
        disableNodes(assignGreenLabel, assignGreenField, applyAssignGreenButton, modeAssign);
        disableNodes(assignBlueLabel, assignBlueField, applyAssignBlueButton, modeAssign);
        windowTeachButton.setDisable(modeHSLRGB);
        windowTeachOKButton.setDisable(modeHSLRGB);
        windowTeachNOKButton.setDisable(modeHSLRGB);
        disableNodes(winCommLabel, winCommField, applyWinCommButton, modeHSLRGB);
        disableNodes(winRedLabel, winRedField, applyWinRedButton, modeRGB);
        disableNodes(winGreenLabel, winGreenField, applyWinGreenButton, modeRGB);
        disableNodes(winBlueLabel, winBlueField, applyWinBlueButton, modeRGB);
        disableNodes(winHueLabel, winHueField, applyWinHueButton, modeHSL);
        disableNodes(winSatLabel, winSatField, applyWinSatButton, modeHSL);
        disableNodes(winLightLabel, winLightField, applyWinLightButton, modeHSL);
        disableNodes(spRedHoffLabel, spRedHoffField, spRedHoffButton, modeHSLRGB);
        disableNodes(spRedHonLabel, spRedHonField, spRedHonButton, modeHSLRGB);
        disableNodes(spRedLonLabel, spRedLonField, spRedLonButton, modeHSLRGB);
        disableNodes(spRedLoffLabel, spRedLoffField, spRedLoffButton, modeHSLRGB);
        disableNodes(spGreenHoffLabel, spGreenHoffField, spGreenHoffButton, modeHSLRGB);
        disableNodes(spGreenHonLabel, spGreenHonField, spGreenHonButton, modeHSLRGB);
        disableNodes(spGreenLonLabel, spGreenLonField, spGreenLonButton, modeHSLRGB);
        disableNodes(spGreenLoffLabel, spGreenLoffField, spGreenLoffButton, modeHSLRGB);
        disableNodes(spBlueHoffLabel, spBlueHoffField, spBlueHoffButton, modeHSLRGB);
        disableNodes(spBlueHonLabel, spBlueHonField, spBlueHonButton, modeHSLRGB);
        disableNodes(spBlueLonLabel, spBlueLonField, spBlueLonButton, modeHSLRGB);
        disableNodes(spBlueLoffLabel, spBlueLoffField, spBlueLoffButton, modeHSLRGB);
        disableNodes(spSatHoffLabel, spSatHoffField, spSatHoffButton, modeHSLRGB);
        disableNodes(spSatHonLabel, spSatHonField, spSatHonButton, modeHSLRGB);
        disableNodes(spSatLonLabel, spSatLonField, spSatLonButton, modeHSLRGB);
        disableNodes(spSatLoffLabel, spSatLoffField, spSatLoffButton, modeHSLRGB);
        disableNodes(spLightHoffLabel, spLightHoffField, spLightHoffButton, modeHSLRGB);
        disableNodes(spLightHonLabel, spLightHonField, spLightHonButton, modeHSLRGB);
        disableNodes(spLightLonLabel, spLightLonField, spLightLonButton, modeHSLRGB);
        disableNodes(spLightLoffLabel, spLightLoffField, spLightLoffButton, modeHSLRGB);
        disableNodes(onDelayLabel, onDelayField, onDelayButton, !connected || withoutOptionFunction);
        disableNodes(offDelayLabel, offDelayField, offDelayButton, !connected || withoutOptionFunction || disableOffDelay);
        disableNodes(impulseLabel, impulseField, impulseButton, !connected || withoutOptionFunction);
        testCheckBox.setDisable(!connected || withoutOptionFunction);
        testLabel.setDisable(!connected || withoutOptionFunction);

        channelFunctionLabel.setText(channelFunction);
        assignRedLabel.setText(String.valueOf(assignedTechRed));
        assignGreenLabel.setText(String.valueOf(assignedTechGreen));
        assignBlueLabel.setText(String.valueOf(assignedTechBlue));
        spRedHoffLabel.setText(String.valueOf(switchingPointsRed[0]));
        spRedHonLabel.setText(String.valueOf(switchingPointsRed[1]));
        spRedLonLabel.setText(String.valueOf(switchingPointsRed[2]));
        spRedLoffLabel.setText(String.valueOf(switchingPointsRed[3]));
        spGreenHoffLabel.setText(String.valueOf(switchingPointsGreen[0]));
        spGreenHonLabel.setText(String.valueOf(switchingPointsGreen[1]));
        spGreenLonLabel.setText(String.valueOf(switchingPointsGreen[2]));
        spGreenLoffLabel.setText(String.valueOf(switchingPointsGreen[3]));
        spBlueHoffLabel.setText(String.valueOf(switchingPointsBlue[0]));
        spBlueHonLabel.setText(String.valueOf(switchingPointsBlue[1]));
        spBlueLonLabel.setText(String.valueOf(switchingPointsBlue[2]));
        spBlueLoffLabel.setText(String.valueOf(switchingPointsBlue[3]));
        spSatHoffLabel.setText(String.valueOf(switchingPointsSat[0]));
        spSatHonLabel.setText(String.valueOf(switchingPointsSat[1]));
        spSatLonLabel.setText(String.valueOf(switchingPointsSat[2]));
        spSatLoffLabel.setText(String.valueOf(switchingPointsSat[3]));
        spLightHoffLabel.setText(String.valueOf(switchingPointsLight[0]));
        spLightHonLabel.setText(String.valueOf(switchingPointsLight[1]));
        spLightLonLabel.setText(String.valueOf(switchingPointsLight[2]));
        spLightLoffLabel.setText(String.valueOf(switchingPointsLight[3]));
        winCommLabel.setText(String.valueOf(winSizeComm));
        winHueLabel.setText(String.valueOf(winSizeHue));
        winSatLabel.setText(String.valueOf(winSizeSat));
        winLightLabel.setText(String.valueOf(winSizeLight));
        winRedLabel.setText(String.valueOf(winSizeRed));
        winGreenLabel.setText(String.valueOf(winSizeGreen));
        winBlueLabel.setText(String.valueOf(winSizeBlue));
        onDelayLabel.setText(String.valueOf(onDelay));
        offDelayLabel.setText(String.valueOf(offDelay));
        impulseLabel.setText(String.valueOf(impulse));
        testLabel.setText(testOutput);
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
    private void setPinFunction(){
        String value = channelFunctionCombo.getValue();
        if(badFirstConditionDialog(value, dataFromSensor.getChannelFunction(channel),
                "???????????????? ?????????????? ???????????? A" + channel + "? ?????????????? ??????????????: %s, ?????????????????? ??????????????: %s")){
            return;
        }
        dataFromSensor.setPinFunction(channel, channelFunctionCombo.getValue());
    }
    private void makeAssignedTeach(){
        if(!connectTool.connected() || !Dialog.getConfirm("?????????????? ???????????????? ???? ???????????????????? ?????? ???????????? A" + channel + "?")){
            return;
        }
        dataFromSensor.makeAssignTeach(channel);
    }
    private void setAssignTeach(String value, int curValue, String color) {
        if(badFirstConditionDialog(value, String.valueOf(curValue), "?????????????????? ???????????????? %s? ?????????????? ??????????????????: %s")){
            return;
        }
        dataFromSensor.setAssignedTeach(channel, value, color);
    }
    private void makeWindowTeach(String function){
        String message = switch(function){
            case "0" -> "?????????????? ???????????????? ???? ????????";
            case "1" -> "?????????????? ???????????????? ???? ?????????????? OK";
            default -> "?????????????? ???????????????? ???? ?????????????? NOK";
        };
        if(!connectTool.connected() || !Dialog.getConfirm(message + " ?????? ???????????? A" + channel + "?")){
            return;
        }
        dataFromSensor.makeWindowTeach(channel, function);
    }
    private void setSwitchingPoints(String value, int curValue, String function, String target){
        if(badFirstConditionDialog(value, String.valueOf(curValue), "?????????????????? ???????????????? %s? ?????????????? ??????????????????: %s")){
            return;
        }
        dataFromSensor.setSwitchingPoints(channel, value, function, target);
    }
    private void setWindowSize(String value, int curValue, String function){
        if(badFirstConditionDialog(value, String.valueOf(curValue), "?????????????????? ???????????????? %s? ?????????????? ??????????????????: %s")){
            return;
        }
        dataFromSensor.setWindowSize(channel, value, function);
    }
    private void setDelayImpulse(String value, int curValue, String function){
        if(badFirstConditionDialog(value, String.valueOf(curValue), "?????????????????? ???????????????? %s? ?????????????? ??????????????????: %s")){
            return;
        }
        dataFromSensor.setDelayImpulse(channel, value, function);
    }
    private void setTestOutput(){
        if(!connectTool.connected() || testCheckBox.isSelected() && !Dialog.getConfirm("???????????????? ?????????????????? ?????????????????? ?????????????? ???????????? ??" + channel + "?")){
            testCheckBox.setSelected(false);
            return;
        }
        changeTestOutput();
    }
    private void changeTestOutput(){
        if(!connectTool.connected()){
            return;
        }
        dataFromSensor.setTestOutput(channel, testCheckBox.isSelected(), testCombo.getValue());
        String simText = testCheckBox.isSelected()? "????????????????": "??????????????????";
        App.LOGGER.info(String.format("?????????????????? ?????????????????? ?????????????? ???? ???????????? A%d ???? ????????????????: %s, ?????????????????? ?? ???????????? ???????????? %s"
                ,channel, testCombo.getValue(), simText));
    }
    private boolean badFirstConditionDialog(String value, String curValue, String message){
        if(!connectTool.connected()){
            return true;
        }
        if(value.equals(DataFromSensor.UNKNOWN_SYMBOL)){
            Dialog.getInformation("???????????????? ???????????????? ???????????? ?????? ??????????????????");
            return true;
        }
        if(value.isEmpty()){
            Dialog.getInformation("?????????????? ???????????????? ???????????? ?????? ??????????????????");
            return true;
        }
        if(!Dialog.getConfirm(String.format(message, value, curValue))){
            return true;
        }
        return false;
    }
    private void disableNodes(Label label, TextField textField, Button button, boolean value){
        label.setDisable(value);
        textField.setDisable(value);
        button.setDisable(value);
    }
}
