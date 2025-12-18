package com.riverwatch.system.Appication.service;
import org.springframework.stereotype.Service;
import com.riverwatch.system.Appication.config.LocationPresetConfig;
import com.riverwatch.system.Appication.model.LocationPreset;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationPresetService {

    private final LocationPresetConfig config;

    public LocationPreset getPreset(String location) {
        LocationPreset preset = config.getLocations().get(location);

        if (preset == null) {
            throw new IllegalArgumentException(
                "No preset found for location: " + location +
                ". Available: " + config.getLocations().keySet()
            );
        }

        return preset;
    }
}



