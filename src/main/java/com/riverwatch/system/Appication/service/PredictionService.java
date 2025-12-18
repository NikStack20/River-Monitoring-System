package com.riverwatch.system.Appication.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    public double predict(List<Double> window) {
        return window.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double confidence(int windowSize, int expectedSize) {
        return Math.min(1.0, (double) windowSize / expectedSize);
    }
}

