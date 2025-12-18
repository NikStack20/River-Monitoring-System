package com.riverwatch.system.Appication.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.riverwatch.system.Appication.model.LocationPreset;

import lombok.Data;

@Data
@Component
@ConfigurationProperties
public class LocationPresetConfig {

    private Map<String, LocationPreset> locations = new HashMap<>();
}



