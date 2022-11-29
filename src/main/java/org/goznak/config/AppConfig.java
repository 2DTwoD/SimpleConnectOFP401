package org.goznak.config;

import org.goznak.model_dao.DataFromSensor;
import org.goznak.tools.ConnectTool;
import org.goznak.tools.WatchDog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.goznak")
public class AppConfig {
    @Bean
    public ConnectTool connectTool() {
        return new ConnectTool();
    }
    @Bean
    public DataFromSensor dataFromSensor(){
        return new DataFromSensor();
    }
    @Bean
    public WatchDog watchDog(){
        return new WatchDog();
    }
}