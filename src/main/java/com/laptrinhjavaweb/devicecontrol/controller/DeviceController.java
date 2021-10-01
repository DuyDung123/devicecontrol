package com.laptrinhjavaweb.devicecontrol.controller;

import com.laptrinhjavaweb.devicecontrol.dto.CategoryDTO;
import com.laptrinhjavaweb.devicecontrol.dto.DeviceDTO;
import com.laptrinhjavaweb.devicecontrol.service.ICategoryService;
import com.laptrinhjavaweb.devicecontrol.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    IDeviceService deviceService;

    @Autowired
    ICategoryService categoryService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        List<DeviceDTO> deviceDTOS = deviceService.findAll(null);
        model.addAttribute("device", deviceDTOS);
        return "views/index";
    }

    @RequestMapping(value = "/device/list",method = RequestMethod.GET)
    public String listDevice(Model model){
        List<DeviceDTO> deviceDTOS = deviceService.findAll(null);
        List<CategoryDTO> categoryDTOS = categoryService.findAll();
        model.addAttribute("device", deviceDTOS);
        model.addAttribute("category", categoryDTOS);
        return "views/device";
    }

}
