package com.laptrinhjavaweb.devicecontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "views/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checklogin(){
        //return new ModelAndView("redirect:" + "/");
        return "redirect:/";
    }
}
