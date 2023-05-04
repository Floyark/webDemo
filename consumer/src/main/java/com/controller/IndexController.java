package com.controller;

import com.service.ErrorService;
import com.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ProviderService providerService;
    @Autowired
    private ErrorService errorService;

    @GetMapping("/info")
    public String getApplicationInfo() {
        logger.info(applicationName);
        return applicationName;
    }

    @GetMapping("/providerInfo")
    public String getProviderInfo() {
        String applicationInfo = providerService.getApplicationInfo();
        logger.info(applicationInfo);
        return applicationInfo;
    }

    @GetMapping("/errorInfo")
    public String errorInfo() {
        String errorInfo = errorService.errorInfo();
        logger.info(errorInfo);
        return errorInfo;
    }
}
