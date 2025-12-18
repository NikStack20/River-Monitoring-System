package com.riverwatch.system.Appication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riverwatch.system.Appication.model.AlertLog;
import com.riverwatch.system.Appication.model.RiverLevelLog;
import com.riverwatch.system.Appication.repository.AlertRepository;
import com.riverwatch.system.Appication.repository.RiverLevelRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/river")
@RequiredArgsConstructor
public class RiverController {

    private final RiverLevelRepository riverRepo;
    private final AlertRepository alertRepo;

    @GetMapping("/levels")
    public List<RiverLevelLog> levels(
            @RequestParam(defaultValue = "50") int limit) {

        return riverRepo.findTop50ByOrderByTimestampDesc()
                        .stream().limit(limit).toList();
    }

    @GetMapping("/status")
    public AlertLog status() {
        return alertRepo.findTopByOrderByTimestampDesc().orElse(null);
    }
}
