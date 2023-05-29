package com.config;

import com.handler.CallBackHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
@AllArgsConstructor
public class RouterFunctionConfiguration {

    private final CallBackHandler callBackHandler;

    @Bean
    public RouterFunction<?> routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.path("/fallback")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), callBackHandler);
    }
}
