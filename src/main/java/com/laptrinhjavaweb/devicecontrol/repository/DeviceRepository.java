package com.laptrinhjavaweb.devicecontrol.repository;

import com.laptrinhjavaweb.devicecontrol.entity.CategoryEntity;
import com.laptrinhjavaweb.devicecontrol.entity.DeviceEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity,Long> {
    DeviceEntity findByDevicecode(String deviceCode);

    List<DeviceEntity> findByCategory(CategoryEntity category);

    List<DeviceEntity> findByCategoryOrderByStatussDesc(CategoryEntity category, Sort sort);
}
