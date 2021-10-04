package com.laptrinhjavaweb.devicecontrol.service.impl;

import com.laptrinhjavaweb.devicecontrol.converter.DeviceConverter;
import com.laptrinhjavaweb.devicecontrol.converter.StatusConverter;
import com.laptrinhjavaweb.devicecontrol.dto.DeviceDTO;
import com.laptrinhjavaweb.devicecontrol.dto.StatusDTO;
import com.laptrinhjavaweb.devicecontrol.entity.CategoryEntity;
import com.laptrinhjavaweb.devicecontrol.entity.DeviceEntity;
import com.laptrinhjavaweb.devicecontrol.entity.StatusEntity;
import com.laptrinhjavaweb.devicecontrol.repository.CategoryRepository;
import com.laptrinhjavaweb.devicecontrol.repository.DeviceRepository;
import com.laptrinhjavaweb.devicecontrol.repository.StatusRepository;
import com.laptrinhjavaweb.devicecontrol.service.IDeviceService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeviceService implements IDeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceConverter deviceConverter;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    StatusConverter statusConverter;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public DeviceDTO findOne(long id) {
        return deviceConverter.toDTO(deviceRepository.getById(id));
    }

    @Override
    public List<DeviceDTO> findAll(Integer categoryId) {
        List<DeviceDTO> deviceDTOS = new ArrayList<>();
        List<DeviceEntity> deviceEntities;
        if(categoryId != null){
            CategoryEntity categoryEntity = categoryRepository.findById(categoryId.longValue()).orElse(null);
            deviceEntities = deviceRepository.findByCategory(categoryEntity);
        }else {
            deviceEntities = deviceRepository.findAll();
        }

        for (DeviceEntity item: deviceEntities) {
            deviceDTOS.add(deviceConverter.toDTO(item));
        }
        return deviceDTOS;
    }

    @Override
    public DeviceDTO updateStatusHumAndTem(String codeDevice, StatusDTO statusDTO) {
        StatusEntity statusEntity = statusConverter.toEntity(statusDTO);
        DeviceEntity deviceEntity = deviceRepository.findByDevicecode(codeDevice);
        statusEntity.setDevice(deviceEntity);
        statusRepository.save(statusEntity);
        return deviceConverter.toDTO(deviceEntity);
    }

    @Override
    public DeviceDTO save(DeviceDTO deviceDTO) {
        DeviceEntity deviceEntity;
        CategoryEntity categoryEntity;

        categoryEntity = categoryRepository.findById(deviceDTO.getCategory()).orElse(null);

        if (deviceDTO.getId() != null){
            deviceEntity = deviceRepository.getById(deviceDTO.getId());
            deviceEntity = deviceConverter.toEntity(deviceDTO,deviceEntity);
        }else {
            deviceEntity = deviceConverter.toEntity(deviceDTO);
            deviceEntity.setStatus(1l);
        }
        deviceEntity.setCategory(categoryEntity);
        deviceEntity = deviceRepository.save(deviceEntity);

        if(deviceDTO.getId() == null && deviceEntity.getCategory().getId() == 3){
            StatusEntity statusEntity = new StatusEntity();
            statusEntity.setDevice(deviceEntity);
            statusEntity.setTemperature(0);
            statusEntity.setHumidity(0);
            statusEntity.setCreatedDate(new Date());
            statusRepository.save(statusEntity);
        }
        return deviceConverter.toDTO(deviceEntity);
    }

    @Override
    public DeviceDTO finOneByCode(String code) {
        return deviceConverter.toDTO(deviceRepository.findByDevicecode(code));
    }

    @Override
    public DeviceDTO updateStatus(String code, long status) {
        DeviceEntity deviceEntity = deviceRepository.findByDevicecode(code);
        deviceEntity.setStatus(status);
        deviceEntity = deviceRepository.save(deviceEntity);
        return deviceConverter.toDTO(deviceEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids) {
            DeviceEntity deviceEntity = deviceRepository.getById(id);
            statusRepository.deleteByDevice(deviceEntity);
            deviceRepository.deleteById(id);
        }
    }
}
