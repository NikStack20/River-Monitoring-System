package com.riverwatch.system.Appication;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.riverwatch.system.Appication.config.LocationPresetConfig;

@SpringBootApplication
@EnableScheduling
public class RiverWatchApplication {

    @Autowired
    private LocationPresetConfig presetConfig;

    public static void main(String[] args) {
        SpringApplication.run(RiverWatchApplication.class, args);
    }

    @PostConstruct
    public void logPresets() {
        System.out.println("Loaded presets: " + presetConfig.getLocations().keySet());
    }
}



