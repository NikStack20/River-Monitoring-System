package com.riverwatch.system.Appication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riverwatch.system.Appication.model.AlertLog;

public interface AlertRepository extends JpaRepository<AlertLog, Long> {
    Optional<AlertLog> findTopByOrderByTimestampDesc();
}

