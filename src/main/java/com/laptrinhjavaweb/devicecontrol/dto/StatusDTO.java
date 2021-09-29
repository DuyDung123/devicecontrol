package com.laptrinhjavaweb.devicecontrol.dto;

public class StatusDTO extends AbstractDTO<StatusDTO>{

    private Long deviceid;
    private float temperature;
    private float humidity;

    public Long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Long deviceid) {
        this.deviceid = deviceid;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
