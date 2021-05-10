package com.monitorchanges.monitor.repository;


import com.monitorchanges.monitor.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropImageRepository extends JpaRepository<Crop, Long> {
}
