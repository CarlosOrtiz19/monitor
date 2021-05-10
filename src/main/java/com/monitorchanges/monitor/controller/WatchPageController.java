package com.monitorchanges.monitor.controller;



import com.monitorchanges.monitor.config.QuartzConfig;
import com.monitorchanges.monitor.dto.CropDto;
import com.monitorchanges.monitor.model.Crop;
import com.monitorchanges.monitor.repository.CropQuartzRepository;
import com.monitorchanges.monitor.service.CropImageService;
import com.monitorchanges.monitor.service.CropService;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/watch")
public class WatchPageController {

    @Autowired
    private CropImageService cropImageService;

    @Autowired
    private CropService cropService;

    @Autowired
    private QuartzConfig quartzConfig;
    @Autowired
    private CropQuartzRepository cropQuartzRepository;



    @PostMapping("/saveCropInfo")
    public ResponseEntity<String> setCropImgae(@RequestBody Crop crop) throws IOException {
        System.out.println("crop = " + crop);

        cropService.saveInitialCrop(crop);


        //cropImageService.saveCropInformation(cropImage);
        return ResponseEntity.status(HttpStatus.OK)
                .body("succes");
    }

    @GetMapping("search/{email}")
    public List<CropDto> getMonitorByEmail(@PathVariable String email) {
        //CropDto cropDto= cropService.getCropByEmail(email);
        return cropService.getCropByEmail(email);
    }


}
