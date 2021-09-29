package com.laptrinhjavaweb.devicecontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {

    @RequestMapping("/")
    public String index(Model model){
        String message = "dinh van dung";
        model.addAttribute("message", message);
        return "index";
    }
}
