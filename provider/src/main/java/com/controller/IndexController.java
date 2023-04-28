package com.controller;

import com.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/info")
    public String getApplicationInfo() {
        return providerService.getProviderInfo();
    }
}
