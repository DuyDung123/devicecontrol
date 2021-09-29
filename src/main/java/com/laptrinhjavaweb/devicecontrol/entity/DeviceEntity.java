package com.laptrinhjavaweb.devicecontrol.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "device")
public class DeviceEntity extends BaseEntity{

    @Column
    private String name;

    @Column
    private String devicecode;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @OneToMany(mappedBy = "device", cascade=CascadeType.PERSIST)
    @OrderBy("createdDate DESC")
    private List<StatusEntity> statuss = new ArrayList<>();

    @Column
    private Long status;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<StatusEntity> getStatuss() {
        return statuss;
    }

    public void setStatuss(List<StatusEntity> statuss) {
        this.statuss = statuss;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
