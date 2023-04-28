package com.service;

import com.fallback.ErrorServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "errorProvider", path = "", fallback = ErrorServiceFallback.class)
public interface ErrorService {

    @ResponseBody
    @GetMapping("/errorInfo")
    public String errorInfo();
}
