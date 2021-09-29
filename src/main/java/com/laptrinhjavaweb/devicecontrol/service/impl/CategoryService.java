package com.laptrinhjavaweb.devicecontrol.service.impl;

import com.laptrinhjavaweb.devicecontrol.converter.CategoryConverter;
import com.laptrinhjavaweb.devicecontrol.dto.CategoryDTO;
import com.laptrinhjavaweb.devicecontrol.entity.CategoryEntity;
import com.laptrinhjavaweb.devicecontrol.repository.CategoryRepository;
import com.laptrinhjavaweb.devicecontrol.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity item: categoryEntityList) {
            CategoryDTO dto = categoryConverter.toDTO(item);
            categoryDTOList.add(dto);
        }
        return categoryDTOList;
    }

    @Override
    public CategoryDTO findOne(long id) {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        return categoryConverter.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO findOneByCode(String code) {
        CategoryEntity categoryEntity = categoryRepository.findByCode(code);
        return categoryConverter.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity;
        if(categoryDTO.getId()!= null){
            categoryEntity = categoryRepository.getById(categoryDTO.getId());
            categoryEntity = categoryConverter.toEntity(categoryDTO,categoryEntity);
        }else {
            categoryEntity = categoryConverter.toEntity(categoryDTO);
        }
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryConverter.toDTO(categoryEntity);
    }
}
