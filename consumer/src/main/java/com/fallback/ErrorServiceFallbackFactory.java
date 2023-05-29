package com.fallback;

import com.service.ErrorService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorServiceFallbackFactory implements FallbackFactory<ErrorService> {

    @Override
    public ErrorService create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new ErrorService(){
            @Override
            public String errorInfo() {
                return "errorInfo";
            }
        };
    }
}
