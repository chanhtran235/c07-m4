package com.example.demo_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}