package com.monitorchanges.monitor.repository;


import com.monitorchanges.monitor.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findByEmail(String email);
}
