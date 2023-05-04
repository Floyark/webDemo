package com.controller;

import com.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private ProviderService providerService;

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/info")
    public String getApplicationInfo() {
        String info = providerService.getProviderInfo();
        logger.info(info);
        return info;
    }
}
