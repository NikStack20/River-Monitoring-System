package com.riverwatch.system.Appication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riverwatch.system.Appication.model.RiverLevelLog;

public interface RiverLevelRepository
extends JpaRepository<RiverLevelLog, Long> {

List<RiverLevelLog> findTop50ByOrderByTimestampDesc();
}

