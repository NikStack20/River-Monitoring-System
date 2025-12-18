package com.riverwatch.system.Appication.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnomalyDetectionService {

    public boolean isSpike(double prev, double curr, double maxJump) {
        boolean spike = Math.abs(curr - prev) > maxJump;
        if (spike) {
            log.warn("Spike detected prev={} curr={}", prev, curr);
        }
        return spike;
    }
}

