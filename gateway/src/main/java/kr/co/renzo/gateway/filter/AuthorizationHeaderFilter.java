package kr.co.renzo.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {
    public AuthorizationHeaderFilter() {
        super(Config.class);
    }

    public static class Config {
        // Put configuration properties here
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            if (request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                String authorizationHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//                String jwt = authorizationHeader.replace("Bearer", "");
//
//                if (!isJwtValid(jwt)) {
//                    return onError(exchange, "JWT token is not valid", HttpStatus.UNAUTHORIZED);
//                }

                // 토큰 검증
            }

            return chain.filter(exchange);
        };
    }

}