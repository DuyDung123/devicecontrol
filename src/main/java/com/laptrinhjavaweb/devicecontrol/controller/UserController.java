package com.laptrinhjavaweb.devicecontrol.controller;

import com.laptrinhjavaweb.devicecontrol.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String listUser(Model model){
        List<UserDTO> userDTOS = new ArrayList<>();
        model.addAttribute("user",userDTOS);
        return "views/user";
    }
}
