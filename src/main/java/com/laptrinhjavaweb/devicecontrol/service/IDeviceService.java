package com.laptrinhjavaweb.devicecontrol.service;

import com.laptrinhjavaweb.devicecontrol.dto.DeviceDTO;
import com.laptrinhjavaweb.devicecontrol.dto.StatusDTO;

import java.util.List;

public interface IDeviceService {
    DeviceDTO findOne(long id);
    List<DeviceDTO> findAll(Integer categoryId);
    DeviceDTO save(DeviceDTO deviceDTO);
    DeviceDTO finOneByCode(String code);
    DeviceDTO updateStatus(String code, long status);
    DeviceDTO updateStatusHumAndTem(String codeDevice, StatusDTO statusDTO);
    void delete(long[] ids);
}
