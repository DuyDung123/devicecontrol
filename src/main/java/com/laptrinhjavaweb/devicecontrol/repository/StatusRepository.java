package com.laptrinhjavaweb.devicecontrol.repository;

import com.laptrinhjavaweb.devicecontrol.entity.DeviceEntity;
import com.laptrinhjavaweb.devicecontrol.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity,Long> {
    StatusEntity getByDevice(DeviceEntity device);
    void deleteByDevice(DeviceEntity device);
}
