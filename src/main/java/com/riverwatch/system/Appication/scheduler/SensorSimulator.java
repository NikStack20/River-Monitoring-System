package com.riverwatch.system.Appication.scheduler;
import java.util.Random;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.riverwatch.system.Appication.service.RiverMonitoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class SensorSimulator {

    private final RiverMonitoringService service;
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void generate() {
        double level = 4 + random.nextDouble() * 5;
        service.process(level, "mountain_river");
    }

}

