package com.myJava.study.web;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {
        model.addAttribute("now", 
                DateFormat.getDateTimeInstance().format(new Date()));
        if(true) {
            throw new Exception("Test Exception");
        }
        return "Hello, World";
    }
}
