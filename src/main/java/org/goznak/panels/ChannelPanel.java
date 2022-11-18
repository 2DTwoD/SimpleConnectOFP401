package org.goznak.panels;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import org.goznak.models.DataFromSensor;
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
    TextField assignRedField;
    @FXML
    TextField assignGreenField;
    @FXML
    TextField assignBlueField;
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
    TextField winCommField;
    @FXML
    TextField winHueField;
    @FXML
    TextField winSatField;
    @FXML
    TextField winLightField;
    @FXML
    TextField winRedField;
    @FXML
    TextField winGreenField;
    @FXML
    TextField winBlueField;
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
    TextField onDelayField;
    @FXML
    TextField offDelayField;
    @FXML
    TextField impulseField;
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
    TextField spRedHoffField;
    @FXML
    TextField spRedHonField;
    @FXML
    TextField spRedLonField;
    @FXML
    TextField spRedLoffField;
    @FXML
    TextField spGreenHoffField;
    @FXML
    TextField spGreenHonField;
    @FXML
    TextField spGreenLonField;
    @FXML
    TextField spGreenLoffField;
    @FXML
    TextField spBlueHoffField;
    @FXML
    TextField spBlueHonField;
    @FXML
    TextField spBlueLonField;
    @FXML
    TextField spBlueLoffField;
    @FXML
    TextField spSatHoffField;
    @FXML
    TextField spSatHonField;
    @FXML
    TextField spSatLonField;
    @FXML
    TextField spSatLoffField;
    @FXML
    TextField spLightHoffField;
    @FXML
    TextField spLightHonField;
    @FXML
    TextField spLightLonField;
    @FXML
    TextField spLightLoffField;
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
    Label testLabel;
    private int channel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        channelFunctionCombo.setItems(DataFromSensor.channelFunction);
        channelFunctionCombo.setValue("?");
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            try {
                Platform.runLater(this::runTime);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }
    public void setChannel(int value){
        channel = value;
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
        String testOutput = dataFromSensor.getTestOutput(channel);
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
        testLabel.setText(String.valueOf(testOutput));
    }
    @FXML
    public void setPinFunction(){
        dataFromSensor.setPinFunction(channel, channelFunctionCombo.getValue());
    }
    @FXML
    public void makeAssignedTeach(){
        dataFromSensor.makeAssignTeach(channel);
    }
    public void stopAllThreads(){
        executorService.shutdown();
    }
}
