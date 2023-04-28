package com.controller;

import com.service.ErrorService;
import com.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ProviderService providerService;
    @Autowired
    private ErrorService errorService;

    @GetMapping("/info")
    public String getApplicationInfo() {
        return applicationName;
    }

    @GetMapping("/providerInfo")
    public String getProviderInfo() {
        return providerService.getApplicationInfo();
    }

    @GetMapping("/errorInfo")
    public String errorInfo() {
        return errorService.errorInfo();
    }
}
