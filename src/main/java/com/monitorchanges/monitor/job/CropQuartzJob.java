package com.monitorchanges.monitor.job;


import com.monitorchanges.monitor.model.Crop;
import com.monitorchanges.monitor.model.CropQuartz;
import com.monitorchanges.monitor.repository.CropQuartzRepository;
import com.monitorchanges.monitor.service.CropService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CropQuartzJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(CropQuartzJob.class);

    @Autowired
    private CropQuartzRepository cropQuartzRepository;

    @Autowired
    private CropService cropService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {


        /* Get message id recorded by scheduler during scheduling */
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String cropQuartzId = dataMap.getString("cropQuartzId");

        log.info("Executing job for cropQuartzId id {}", cropQuartzId);

        /* Get message from database by id */
        long id = Long.parseLong(cropQuartzId);
        Optional<CropQuartz> cropQuartz = cropQuartzRepository.findById(id);

        log.info("cropQuartz id {}", cropQuartz.get().getId());

        Crop crop = cropQuartz.get().getCrop();

        boolean isSimilar = cropService.compareCrops(crop);

        System.out.println("isSimilar = " + isSimilar);


       /* try {
            context.getScheduler().deleteJob(new JobKey(cropQuartzId));

            TriggerKey triggerKey = new TriggerKey(cropQuartzId);

            context.getScheduler().unscheduleJob(triggerKey);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/


    }
}
