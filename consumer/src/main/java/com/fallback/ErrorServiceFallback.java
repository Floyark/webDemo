package com.fallback;

import com.service.ErrorService;
import org.springframework.stereotype.Component;

@Component
public class ErrorServiceFallback implements ErrorService {
    @Override
    public String errorInfo() {
        return "error 快速失败";
    }
}
