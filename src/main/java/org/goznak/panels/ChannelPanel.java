package org.goznak.panels;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import org.goznak.models.DataFromSensor;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ChannelPanel extends Parent implements Initializable {
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
    private int channel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        channelFunctionCombo.setItems(DataFromSensor.channelFunction);
        channelFunctionCombo.setValue("?");
    }
    public void setChannel(int value){
        channel = value;
    }
    public int getChannel() {
        return channel;
    }
}
