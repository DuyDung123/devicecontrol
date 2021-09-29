package com.laptrinhjavaweb.devicecontrol.entity;


import javax.persistence.*;

@Entity
@Table(name = "status")
public class StatusEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceEntity device ;

    @Column
    private float temperature;

    @Column
    private float humidity;

    public DeviceEntity getDevice() {
        return device;
    }

    public void setDevice(DeviceEntity device) {
        this.device = device;
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
