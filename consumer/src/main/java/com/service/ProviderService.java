package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "defaultProvider", path = "provider")
public interface ProviderService {

    @GetMapping("/info")
    @ResponseBody
    public String getApplicationInfo();
}
