package org.goznak.tools;

import jssc.*;
import org.goznak.Main;
import org.goznak.models.DataFromSensor;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class ConnectTool {
    Main main;
    SerialPort serialPort;
    ExecutorService executor;
    public ConnectTool(Main main) {
        this.main = main;
    }
    public void connect(){
//        executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
            serialPort = new SerialPort("COM4");//main.connectSettingsPanel.getPort()
            try {
                serialPort.openPort();
                serialPort.setParams(main.connectSettingsPanel.getBaudRate(),
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                serialPort.addEventListener(new PortReader(serialPort, main.dataFromSensor), SerialPort.MASK_RXCHAR);
                serialPort.writeBytes(getFullCommandName(CommandList.current()).getBytes(StandardCharsets.US_ASCII));
            }
            catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
            }
//        });

    }
    static String getFullCommandName(String command){
        return String.format("/%s.", command);
    }
    static String getWriteCommandName(String command){
        byte checkSum = '/';
        for(byte b: command.getBytes(StandardCharsets.US_ASCII)){
            checkSum ^= b;
        }
        return String.format("/%s%02X.", command, checkSum);
    }
    public void disconnect(){
        try {
            //executor.shutdownNow();
            serialPort.closePort();
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
    }
}
class PortReader implements SerialPortEventListener {
    private final SerialPort serialPort;
    DataFromSensor dataFromSensor;
    String currentResult;
    private boolean startFlag = false;
    private boolean repeatFlag = true;
    public PortReader(SerialPort serialPort, DataFromSensor dataFromSensor) {
        this.serialPort = serialPort;
        this.dataFromSensor = dataFromSensor;
    }
    @Override
    public void serialEvent(SerialPortEvent event) {
        if(event.isRXCHAR() && event.getEventValue() > 0){
            try {
                if(repeatFlag){
                    repeatCommand();
                    repeatFlag = false;
                    return;
                }
                int start;
                int end;
                String data = serialPort.readString();
                if(!startFlag){
                    start = data.lastIndexOf('/');
                    if(start != -1) {
                        String subData = data.substring(start);
                        end = subData.lastIndexOf('.');
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
            catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    private void setDataAndGetNewCommand(String data) throws SerialPortException {
        dataFromSensor.setData(CommandList.current(), data);
        serialPort.writeBytes(ConnectTool.getFullCommandName(CommandList.next()).getBytes(StandardCharsets.US_ASCII));
        repeatFlag = true;
    }
    private void repeatCommand() throws SerialPortException {
        serialPort.writeBytes(ConnectTool.getFullCommandName(CommandList.current()).getBytes(StandardCharsets.US_ASCII));
    }
}