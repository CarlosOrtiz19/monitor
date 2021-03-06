package com.monitorchanges.monitor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private String url;
    private String email;
    private LocalDate createDate = LocalDate.now();
    @JsonIgnore
    @OneToOne(mappedBy = "crop")
    private CropQuartz cropQuartz;

    @OneToOne
    private ImageCrop imageCrop;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private User user;
}
