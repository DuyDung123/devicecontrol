package com.laptrinhjavaweb.devicecontrol.api;

import com.laptrinhjavaweb.devicecontrol.dto.CategoryDTO;
import com.laptrinhjavaweb.devicecontrol.response.Response;
import com.laptrinhjavaweb.devicecontrol.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryAPI {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public Response<CategoryDTO> getAll(){
        CategoryDTO dto = new CategoryDTO();
        dto.setListResult(categoryService.findAll());
        return new Response<CategoryDTO>(dto);
    }

    @GetMapping("/category/{id}")
    public Response<CategoryDTO> getOne(@PathVariable("id") long id){
        CategoryDTO dto = new CategoryDTO();
        return new Response<CategoryDTO>(categoryService.findOne(id));
    }

//    @PostMapping("/categry")
//    public Response<CategoryDTO>createCategory(@RequestBody CategoryDTO categoryDTO){
//        return new Response<CategoryDTO>(categoryService.save(categoryDTO));
//    }
}
