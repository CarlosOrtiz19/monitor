package com.monitorchanges.monitor.repository;


import com.monitorchanges.monitor.model.ScreenShot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenShotRepository extends JpaRepository<ScreenShot, Long> {
}
