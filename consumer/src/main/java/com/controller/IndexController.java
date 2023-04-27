package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/info")
    public String getApplicationInfo() {
        return applicationName;
    }
}
