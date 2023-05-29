package com.handler;

import com.entity.R;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;

@Slf4j
@Component
public class CallBackHandler implements HandlerFunction<ServerResponse> {
    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Optional<Object> originalUris = serverRequest.attribute(GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        originalUris.ifPresent(uri -> log.error("网关执行请求:{}失败,hystrix服务降级处理", uri));
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Gson().toJson(R.error("服务已熔断"))));
    }
}