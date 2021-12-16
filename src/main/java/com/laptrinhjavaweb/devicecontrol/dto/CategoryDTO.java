package com.laptrinhjavaweb.devicecontrol.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends AbstractDTO<CategoryDTO>{
    private String code;
    private String name;
    private List<DeviceDTO> devices = new ArrayList<>();

    public CategoryDTO() {
    }

    public CategoryDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDTO> devices) {
        this.devices = devices;
    }
}
