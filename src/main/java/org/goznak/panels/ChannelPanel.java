package org.goznak.panels;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import org.goznak.inputs.NumericTextField;
import org.goznak.models.DataFromSensor;
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
    private int channel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        channelFunctionCombo.setItems(DataFromSensor.channelFunction);
        channelFunctionCombo.setValue("?");
        testCombo.setItems(DataFromSensor.testOutputList);
        testCombo.setValue(DataFromSensor.testOutputList.get(0));
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                Platform.runLater(this::runTime);
            }
            catch(Exception e){
                Platform.runLater(() -> Dialog.getFullError(e));
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }
    public void setChannel(int value){
        channel = value;
        titleLabel.setText("Настройки канала A" + channel + ":");
    }
    private void runTime(){
        String channelFunction = dataFromSensor.getChannelFunction(channel);
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
        boolean notConnected = !connectTool.connected();
        boolean modeHSL = !dataFromSensor.getOpMode().equals(DataFromSensor.opModeList.get(0)) || notConnected;
        boolean modeAssign = !dataFromSensor.getOpMode().equals(DataFromSensor.opModeList.get(1)) || notConnected;
        boolean modeRGB = !dataFromSensor.getOpMode().equals(DataFromSensor.opModeList.get(2)) || notConnected;
        boolean modeHSLRGB = !modeAssign || notConnected;

        applyChannelFunctionButton.setDisable(notConnected);
        assignTeachButton.setDisable(modeAssign);
        disableNodes(assignRedField, applyAssignRedButton, modeAssign);
        disableNodes(assignGreenField, applyAssignGreenButton, modeAssign);
        disableNodes(assignBlueField, applyAssignBlueButton, modeAssign);
        windowTeachButton.setDisable(modeHSLRGB);
        windowTeachOKButton.setDisable(modeHSLRGB);
        windowTeachNOKButton.setDisable(modeHSLRGB);
        disableNodes(winRedField, applyWinRedButton, modeRGB);
        disableNodes(winGreenField, applyWinGreenButton, modeRGB);
        disableNodes(winBlueField, applyWinBlueButton, modeRGB);
        disableNodes(winHueField, applyWinHueButton, modeHSL);
        disableNodes(winSatField, applyWinSatButton, modeHSL);
        disableNodes(winLightField, applyWinLightButton, modeHSL);
        disableNodes(winCommField, applyWinCommButton, modeHSLRGB);
        disableNodes(spRedHoffField, spRedHoffButton, modeHSLRGB);
        disableNodes(spRedHonField, spRedHonButton, modeHSLRGB);
        disableNodes(spRedLonField, spRedLonButton, modeHSLRGB);
        disableNodes(spRedLoffField, spRedLoffButton, modeHSLRGB);
        disableNodes(spGreenHoffField, spGreenHoffButton, modeHSLRGB);
        disableNodes(spGreenHonField, spGreenHonButton, modeHSLRGB);
        disableNodes(spGreenLonField, spGreenLonButton, modeHSLRGB);
        disableNodes(spGreenLoffField, spGreenLoffButton, modeHSLRGB);
        disableNodes(spBlueHoffField, spBlueHoffButton, modeHSLRGB);
        disableNodes(spBlueHonField, spBlueHonButton, modeHSLRGB);
        disableNodes(spBlueLonField, spBlueLonButton, modeHSLRGB);
        disableNodes(spBlueLoffField, spBlueLoffButton, modeHSLRGB);
        disableNodes(spSatHoffField, spSatHoffButton, modeHSLRGB);
        disableNodes(spSatHonField, spSatHonButton, modeHSLRGB);
        disableNodes(spSatLonField, spSatLonButton, modeHSLRGB);
        disableNodes(spSatLoffField, spSatLoffButton, modeHSLRGB);
        disableNodes(spLightHoffField, spLightHoffButton, modeHSLRGB);
        disableNodes(spLightHonField, spLightHonButton, modeHSLRGB);
        disableNodes(spLightLonField, spLightLonButton, modeHSLRGB);
        disableNodes(spLightLoffField, spLightLoffButton, modeHSLRGB);
        disableNodes(onDelayField, onDelayButton, notConnected);
        disableNodes(offDelayField, offDelayButton, notConnected);
        disableNodes(impulseField, impulseButton, notConnected);
        testCheckBox.setDisable(notConnected);

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

        applyChannelFunctionButton.setOnAction(e -> setPinFunction());
        assignTeachButton.setOnAction(e -> makeAssignedTeach());
        applyAssignRedButton.setOnAction(e -> setAssignTeach(assignRedField.getText(), "R"));
        applyAssignGreenButton.setOnAction(e -> setAssignTeach(assignGreenField.getText(), "G"));
        applyAssignBlueButton.setOnAction(e -> setAssignTeach(assignBlueField.getText(), "B"));
        windowTeachButton.setOnAction(e -> makeWindowTeach("0"));
        windowTeachOKButton.setOnAction(e -> makeWindowTeach("1"));
        windowTeachNOKButton.setOnAction(e -> makeWindowTeach("2"));
        spRedHoffButton.setOnAction(e -> setSwitchingPoints(spRedHoffField.getText(), "R", "Hoff"));
        spRedHonButton.setOnAction(e -> setSwitchingPoints(spRedHonField.getText(), "R", "Hon"));
        spRedLonButton.setOnAction(e -> setSwitchingPoints(spRedLonField.getText(), "R", "Lon"));
        spRedLoffButton.setOnAction(e -> setSwitchingPoints(spRedLoffField.getText(), "R", "Loff"));
        spGreenHoffButton.setOnAction(e -> setSwitchingPoints(spGreenHoffField.getText(), "G", "Hoff"));
        spGreenHonButton.setOnAction(e -> setSwitchingPoints(spGreenHonField.getText(), "G", "Hon"));
        spGreenLonButton.setOnAction(e -> setSwitchingPoints(spGreenLonField.getText(), "G", "Lon"));
        spGreenLoffButton.setOnAction(e -> setSwitchingPoints(spGreenLoffField.getText(), "G", "Loff"));
        spBlueHoffButton.setOnAction(e -> setSwitchingPoints(spBlueHoffField.getText(), "B", "Hoff"));
        spBlueHonButton.setOnAction(e -> setSwitchingPoints(spBlueHonField.getText(), "B", "Hon"));
        spBlueLonButton.setOnAction(e -> setSwitchingPoints(spBlueLonField.getText(), "B", "Lon"));
        spBlueLoffButton.setOnAction(e -> setSwitchingPoints(spBlueLoffField.getText(), "B", "Loff"));
        spSatHoffButton.setOnAction(e -> setSwitchingPoints(spSatHoffField.getText(), "S", "Hoff"));
        spSatHonButton.setOnAction(e -> setSwitchingPoints(spSatHonField.getText(), "S", "Hon"));
        spSatLonButton.setOnAction(e -> setSwitchingPoints(spSatLonField.getText(), "S", "Lon"));
        spSatLoffButton.setOnAction(e -> setSwitchingPoints(spSatLoffField.getText(), "S", "Loff"));
        spLightHoffButton.setOnAction(e -> setSwitchingPoints(spLightHoffField.getText(), "L", "Hoff"));
        spLightHonButton.setOnAction(e -> setSwitchingPoints(spLightHonField.getText(), "L", "Hon"));
        spLightLonButton.setOnAction(e -> setSwitchingPoints(spLightLonField.getText(), "L", "Lon"));
        spLightLoffButton.setOnAction(e -> setSwitchingPoints(spLightLoffField.getText(), "L", "Loff"));
        applyWinCommButton.setOnAction(e-> setWindowSize(winCommField.getText(), "b"));
        applyWinHueButton.setOnAction(e-> setWindowSize(winHueField.getText(), "c"));
        applyWinSatButton.setOnAction(e-> setWindowSize(winSatField.getText(), "d"));
        applyWinLightButton.setOnAction(e-> setWindowSize(winLightField.getText(), "e"));
        applyWinRedButton.setOnAction(e-> setWindowSize(winRedField.getText(), "R"));
        applyWinGreenButton.setOnAction(e-> setWindowSize(winGreenField.getText(), "G"));
        applyWinBlueButton.setOnAction(e-> setWindowSize(winBlueField.getText(), "B"));
        onDelayButton.setOnAction(e-> setDelayImpulse(onDelayField.getText(), "j"));
        offDelayButton.setOnAction(e-> setDelayImpulse(offDelayField.getText(), "k"));
        impulseButton.setOnAction(e-> setDelayImpulse(impulseField.getText(), "l"));
        testCombo.setOnAction(e -> changeTestOutput());
        testCheckBox.setOnAction(e -> setTestOutput());
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
    private void setPinFunction(){
        String value = channelFunctionCombo.getValue();
        if(badFirstConditionDialog(value, "Изменить функцию канала A" + channel + "?")){
            return;
        }
        dataFromSensor.setPinFunction(channel, channelFunctionCombo.getValue());
    }
    private void makeAssignedTeach(){
        if(!connectTool.connected() || !Dialog.getConfirm("Сделать обучение по назначению для канала A" + channel + "?")){
            return;
        }
        dataFromSensor.makeAssignTeach(channel);
    }
    private void setAssignTeach(String value, String color) {
        if(badFirstConditionDialog(value, "Применить значение %s?")){
            return;
        }
        dataFromSensor.setAssignedTeach(channel, value, color);
    }
    private void makeWindowTeach(String function){
        if(!connectTool.connected() || !Dialog.getConfirm("Сделать обучение по окну для канала A" + channel + "?")){
            return;
        }
        dataFromSensor.makeWindowTeach(channel, function);
    }
    private void setSwitchingPoints(String value, String function, String target){
        if(badFirstConditionDialog(value, "Применить значение %s?")){
            return;
        }
        dataFromSensor.setSwitchingPoints(channel, value, function, target);
    }
    private void setWindowSize(String value, String function){
        if(badFirstConditionDialog(value, "Применить значение %s?")){
            return;
        }
        dataFromSensor.setWindowSize(channel, value, function);
    }
    private void setDelayImpulse(String value, String function){
        if(badFirstConditionDialog(value, "Применить значение %s?")){
            return;
        }
        dataFromSensor.setDelayImpulse(channel, value, function);
    }
    private void setTestOutput(){
        if(!connectTool.connected() || testCheckBox.isSelected() && !Dialog.getConfirm("Включить симуляцию выходного сигнала канала А" + channel + "?")){
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
    }
    private boolean badFirstConditionDialog(String value, String message){
        if(!connectTool.connected()){
            return true;
        }
        if(value.equals(DataFromSensor.UNKNOWN_SYMBOL)){
            Dialog.getInformation("Выберите значение прежде чем применять");
            return true;
        }
        if(value.isEmpty()){
            Dialog.getInformation("Введите значение прежде чем применять");
            return true;
        }
        if(!Dialog.getConfirm(String.format(message, value))){
            return true;
        }
        return false;
    }
    private void disableNodes(TextField textField, Button button, boolean value){
        textField.setDisable(value);
        button.setDisable(value);
    }
}
