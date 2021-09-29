package com.laptrinhjavaweb.devicecontrol.converter;

import com.laptrinhjavaweb.devicecontrol.dto.CategoryDTO;
import com.laptrinhjavaweb.devicecontrol.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(CategoryEntity categoryEntity){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(categoryEntity.getId());
        dto.setName(categoryEntity.getName());
        dto.setCode(categoryEntity.getCode());
        return dto;
    }

    public CategoryEntity toEntity(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setCode(categoryDTO.getCode());
        return categoryEntity;
    }

    public CategoryEntity toEntity(CategoryDTO categoryDTO, CategoryEntity oldCategoryEntity){
        oldCategoryEntity.setName(categoryDTO.getName());
        oldCategoryEntity.setCode(categoryDTO.getCode());
        return oldCategoryEntity;
    }
}
