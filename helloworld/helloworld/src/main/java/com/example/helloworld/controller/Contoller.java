package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.helloworld.service.Service;

@RestController
public class Contoller {
    
    private Service service = new Service();

    @GetMapping("/hello")
    public String hello() {
        return service.hello();
    }
}
