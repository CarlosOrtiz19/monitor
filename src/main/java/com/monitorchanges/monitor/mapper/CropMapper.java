package com.monitorchanges.monitor.mapper;


import com.monitorchanges.monitor.dto.CropDto;
import com.monitorchanges.monitor.model.Crop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CropMapper {
    CropMapper INSTANCE = Mappers.getMapper(CropMapper.class);

    CropDto ToCropDto(Crop crop);

    default List<CropDto> toDtoList(List<Crop> cropList) {
        if (cropList == null) {
            return new ArrayList<>();
        }
        return cropList.stream().map(this::ToCropDto).collect(Collectors.toList());
    }
}
