package org.goznak.tools;

import javafx.application.Platform;
import jssc.*;
import org.goznak.models.DataFromSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ConnectTool {
    @Autowired
    DataFromSensor dataFromSensor;
    SerialPort serialPort;
    WatchDog watchDog = new WatchDog();
    ScheduledExecutorService executorService;
    String comPort;
    int baudRate = 38400;
    public void connect(){
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            if(!watchDog.isOk()){
                disconnect();
            }
            watchDog.setOk(false);
        },2 , 2, TimeUnit.SECONDS);
            serialPort = new SerialPort(comPort);
            try {
                serialPort.openPort();
                serialPort.setParams(baudRate,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                serialPort.addEventListener(new PortReader(serialPort, dataFromSensor, watchDog), SerialPort.MASK_RXCHAR);
                serialPort.writeBytes(CommandList.current().getCommand().getBytes(StandardCharsets.US_ASCII));

            }
            catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
            }
    }
    public void setComPort(String comPort) {
        this.comPort = comPort;
    }
    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }
    public void disconnect(){
        try {
            watchDog.setOk(false);
            executorService.shutdown();
            serialPort.closePort();
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean connected(){
        if(serialPort == null){
            return false;
        }
        return serialPort.isOpened() && watchDog.isOk();
    }
}
class PortReader implements SerialPortEventListener {
    WatchDog watchDog;
    private final SerialPort serialPort;
    DataFromSensor dataFromSensor;
    String currentResult;
    private boolean startFlag = false;
    public PortReader(SerialPort serialPort, DataFromSensor dataFromSensor, WatchDog watchDog) {
        this.serialPort = serialPort;
        this.dataFromSensor = dataFromSensor;
        this.watchDog = watchDog;
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
            catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
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