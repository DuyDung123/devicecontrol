package com.laptrinhjavaweb.devicecontrol.converter;

import com.laptrinhjavaweb.devicecontrol.dto.StatusDTO;
import com.laptrinhjavaweb.devicecontrol.entity.StatusEntity;

import java.util.Date;

public class StatusConverter {
    public StatusEntity toEntity(StatusDTO statusDTO){
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setHumidity(statusDTO.getHumidity());
        statusEntity.setCreatedDate(new Date());
        statusEntity.setTemperature(statusDTO.getTemperature());
        return statusEntity;
    }
}
