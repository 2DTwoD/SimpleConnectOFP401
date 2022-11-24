package org.goznak.tools;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import org.goznak.models.DataFromSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PortReader implements SerialPortEventListener {
    @Autowired
    WatchDog watchDog;
    @Autowired
    DataFromSensor dataFromSensor;
    @Autowired
    ConnectTool connectTool;
    private final SerialPort serialPort;
    String currentResult;
    private boolean startFlag = false;

    public PortReader(SerialPort serialPort) {
        this.serialPort = serialPort;
    }
    @Override
    public void serialEvent(SerialPortEvent event) {
        if(event.isRXCHAR() && event.getEventValue() > 0){
            try {
                watchDog.setOk(true);
                int start;
                int end;
                String data = serialPort.readString();
                if(!startFlag){
                    start = data.lastIndexOf('/');
                    if(start != -1) {
                        String subData = data.substring(start);
                        end = subData.indexOf('.');
                        if(end != -1){
                            currentResult = subData.substring(0, end + 1);
                            setDataAndGetNewCommand(currentResult);
                        } else {
                            currentResult = data.substring(start);
                            repeatCommand();
                            startFlag = true;
                        }
                    }
                } else {
                    end = data.indexOf('.');
                    if(end != -1){
                        currentResult += data.substring(0, end + 1);
                        setDataAndGetNewCommand(currentResult);
                        startFlag = false;
                    } else {
                        currentResult += data;
                        repeatCommand();
                    }
                }
            }
            catch (SerialPortException e) {
                Dialog.getFullError(e);
                connectTool.disconnect();
            }
        }
    }
    private void setDataAndGetNewCommand(String data) throws SerialPortException {
        dataFromSensor.setData(CommandList.current(), data);
        serialPort.writeBytes(CommandList.next().getCommand().getBytes(StandardCharsets.US_ASCII));
    }
    private void repeatCommand() throws SerialPortException {
        serialPort.writeBytes(CommandList.current().getCommand().getBytes(StandardCharsets.US_ASCII));
    }
}
