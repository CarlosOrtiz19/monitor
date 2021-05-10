package com.monitorchanges.monitor.service;


import com.monitorchanges.monitor.model.Crop;
import com.monitorchanges.monitor.repository.CropImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropImageService {

    @Autowired
    CropImageRepository cropImageRepository;

    public Crop saveCropInformation(Crop crop) {
        System.out.println("info");
        System.out.println(crop);
        return cropImageRepository.save(crop);

    }
}
