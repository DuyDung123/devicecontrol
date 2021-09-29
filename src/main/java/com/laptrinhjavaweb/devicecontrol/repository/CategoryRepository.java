package com.laptrinhjavaweb.devicecontrol.repository;

import com.laptrinhjavaweb.devicecontrol.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findByCode(String code);
}
