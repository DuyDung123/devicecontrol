package com.laptrinhjavaweb.devicecontrol.dto;

import java.util.ArrayList;
import java.util.List;

public class DeviceDTO extends AbstractDTO<DeviceDTO>{

    private String name;
    private String devicecode;
    private Long category;
    private Long status;
    private List<StatusDTO> listStatus = new ArrayList<StatusDTO>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public List<StatusDTO> getListStatus() {
        return listStatus;
    }

    public void setListStatus(List<StatusDTO> listStatus) {
        this.listStatus = listStatus;
    }
}
