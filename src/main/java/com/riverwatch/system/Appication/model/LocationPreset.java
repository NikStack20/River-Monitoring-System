package com.riverwatch.system.Appication.model;
import lombok.Data;

@Data
public class LocationPreset {
    private double maxJump;
    private int windowSize;
    private double warningLevel;
    private double dangerLevel;
}

