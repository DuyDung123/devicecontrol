package com.laptrinhjavaweb.devicecontrol.converter;

import com.laptrinhjavaweb.devicecontrol.dto.DeviceDTO;
import com.laptrinhjavaweb.devicecontrol.dto.StatusDTO;
import com.laptrinhjavaweb.devicecontrol.entity.DeviceEntity;
import com.laptrinhjavaweb.devicecontrol.entity.StatusEntity;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DeviceConverter {
    public DeviceDTO toDTO(DeviceEntity deviceEntity){
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(deviceEntity.getId());
        deviceDTO.setName(deviceEntity.getName());
        deviceDTO.setDevicecode(deviceEntity.getDevicecode());
        deviceDTO.setCategory(deviceEntity.getCategory().getId());
        deviceDTO.setStatus(deviceEntity.getStatus());
        if (!deviceEntity.getStatuss().isEmpty()){
            List<StatusDTO> statusDTOS = new ArrayList<>();
            for (StatusEntity item: deviceEntity.getStatuss()){
                StatusDTO statusDTO = new StatusDTO();
                statusDTO.setId(item.getId());
                statusDTO.setDeviceid(item.getDevice().getId());
                statusDTO.setHumidity(item.getHumidity());
                statusDTO.setTemperature(item.getTemperature());
                statusDTO.setCreatedDate(item.getCreatedDate());
                statusDTOS.add(statusDTO);
            }
            deviceDTO.setListStatus(statusDTOS);
        }
        return deviceDTO;
    }

    public DeviceEntity toEntity(DeviceDTO deviceDTO){
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setId(deviceDTO.getId());
        deviceEntity.setName(deviceDTO.getName());
        deviceEntity.setCreatedDate(new Date());
        deviceEntity.setDevicecode(getCode(deviceDTO.getName()));
        return deviceEntity;
    }

    public DeviceEntity toEntity(DeviceDTO deviceDTO, DeviceEntity oldDeviceEntity){
        oldDeviceEntity.setId(deviceDTO.getId());
        oldDeviceEntity.setName(deviceDTO.getName());
        oldDeviceEntity.setModifiedDate(new Date());
        oldDeviceEntity.setDevicecode(getCode(deviceDTO.getName()));
        return oldDeviceEntity;
    }


    private static String getCode(String data){
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        int index = random.nextInt(lexicon.length());
        data += lexicon.charAt(index);
        byte[] encodedBytes = Base64.encodeBase64(data.getBytes());
        return new String(encodedBytes) + lexicon.charAt(index);
    }
}
