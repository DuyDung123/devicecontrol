package com.laptrinhjavaweb.devicecontrol;

import com.laptrinhjavaweb.devicecontrol.dto.CategoryDTO;
import com.laptrinhjavaweb.devicecontrol.entity.CategoryEntity;
import com.laptrinhjavaweb.devicecontrol.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DeviceControlApplication implements CommandLineRunner {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String checkDb = "";

    @Autowired
    private ICategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(DeviceControlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createCategory(checkDb);
    }

    private void createCategory(String checkDb){
        if (checkDb.equals("create")){

            Map<String, String > category = new HashMap<>();
            category.put("den", "Đèn");
            category.put("quat", "Quạt");
            category.put("nhiet-do-do-am", "Nhiệt độ - đô ẩm");
            for(Map.Entry<String, String> entry : category.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                CategoryDTO categoryDTO = new CategoryDTO(key, value);
                categoryService.save(categoryDTO);
            }
        }
    }
}
