package com.riverwatch.system.Appication.service;
import java.time.LocalDateTime; 
import java.util.List;
import org.springframework.stereotype.Service;
import com.riverwatch.system.Appication.model.AlertLog;
import com.riverwatch.system.Appication.model.LocationPreset;
import com.riverwatch.system.Appication.model.RiverLevelLog;
import com.riverwatch.system.Appication.repository.AlertRepository;
import com.riverwatch.system.Appication.repository.RiverLevelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiverMonitoringService {

    private final RiverLevelRepository riverRepo;
    private final AlertRepository alertRepo;
    private final LocationPresetService presetService;
    private final AnomalyDetectionService anomalyService;
    private final PredictionService predictionService;

    public void process(double level, String location) {
        LocationPreset preset = presetService.getPreset(location);

        List<RiverLevelLog> recent = riverRepo.findTop50ByOrderByTimestampDesc();
        if (!recent.isEmpty()) {
            double prev = recent.get(0).getWaterLevel();
            if (anomalyService.isSpike(prev, level, preset.getMaxJump())) {
                return; // ignore spike
            }
        }

        RiverLevelLog e = new RiverLevelLog();
        e.setWaterLevel(level);
        e.setTimestamp(LocalDateTime.now());
        riverRepo.save(e);

        evaluate(location, preset);
    }

    private void evaluate(String location, LocationPreset preset) {
        List<Double> window = riverRepo.findTop50ByOrderByTimestampDesc()
                .stream()
                .limit(preset.getWindowSize())
                .map(RiverLevelLog::getWaterLevel)
                .toList();

        double predicted = predictionService.predict(window);
        double conf = predictionService.confidence(window.size(), preset.getWindowSize());

        String risk = predicted >= preset.getDangerLevel() ? "DANGER"
                   : predicted >= preset.getWarningLevel() ? "WARNING"
                   : "SAFE";

        AlertLog a = new AlertLog();
        a.setLocation(location);
        a.setRisk(risk);
        a.setConfidence(conf);
        a.setTimestamp(LocalDateTime.now());
        alertRepo.save(a);

        log.info("Location={} Risk={} Confidence={}", location, risk, conf);
    }
}
