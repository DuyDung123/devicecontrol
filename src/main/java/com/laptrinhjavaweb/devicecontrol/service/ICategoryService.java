package com.laptrinhjavaweb.devicecontrol.service;

import com.laptrinhjavaweb.devicecontrol.dto.CategoryDTO;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findOne(long id);
    CategoryDTO findOneByCode(String code);
    CategoryDTO save(CategoryDTO categoryDTO);
}
