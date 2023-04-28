package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String getProviderInfo() {
        return applicationName;
    }

}
