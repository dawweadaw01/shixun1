package com.lhj.shixun1.property.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class Testcontroller {
    @GetMapping("/hello")
    public String test(){
        return "Hello World!";
    }
}
