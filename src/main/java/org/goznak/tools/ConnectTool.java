package org.goznak.tools;

import javafx.application.Platform;
import jssc.*;
import org.goznak.App;
import org.goznak.models.DataFromSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ConnectTool {
    @Autowired
    DataFromSensor dataFromSensor;
    @Autowired
    WatchDog watchDog;
    SerialPort serialPort;
    ScheduledExecutorService executorService;
    String comPort;
    int baudRate = 38400;
    public static final String NO_PORTS = "Нет портов";
    public void connect(){
        if (comPort.equals(NO_PORTS)){
            Dialog.getWarning("Сначала выберите порт для подключения");
            return;
        }
        if(executorService != null && !executorService.isShutdown()){
            return;
        }
        if(serialPort != null && serialPort.isOpened()){
            try {
                serialPort.closePort();
            } catch (SerialPortException e) {
                Platform.runLater(() -> Dialog.getError(e));
                throw new RuntimeException(e);
            }
        }
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            if(!watchDog.isOk()){
                Platform.runLater(() -> Dialog.getWarning("Нет связи с датчиком"));
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

            PortReader portReader = (PortReader) App.getContext().getBean("portReader", serialPort);
            serialPort.addEventListener(portReader, SerialPort.MASK_RXCHAR);
            serialPort.writeBytes(CommandList.current().getCommand().getBytes(StandardCharsets.US_ASCII));
        }
        catch (SerialPortException e) {
            Dialog.getError(e);
            disconnect();
        }
    }
    public void disconnect(){
        try {
            executorService.shutdownNow();
            watchDog.setOk(false);
            if(serialPort.isOpened()) {
                serialPort.closePort();
            }
        } catch (SerialPortException e) {
            Dialog.getError(e);
            throw new RuntimeException(e);
        }
    }
    public boolean connected(){
        if(serialPort == null){
            return false;
        }
        return serialPort.isOpened() && watchDog.isOk();
    }
    public void setComPort(String comPort) {
        this.comPort = comPort;
    }
    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }
}