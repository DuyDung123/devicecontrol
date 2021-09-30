package com.laptrinhjavaweb.devicecontrol.controller;

import com.laptrinhjavaweb.devicecontrol.dto.DeviceDTO;
import com.laptrinhjavaweb.devicecontrol.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IDeviceService deviceService;


    @RequestMapping("/")
    public String index(Model model){
        List<DeviceDTO> deviceDTOS = deviceService.findAll(null);
        model.addAttribute("device", deviceDTOS);
        return "views/index";
    }
}
