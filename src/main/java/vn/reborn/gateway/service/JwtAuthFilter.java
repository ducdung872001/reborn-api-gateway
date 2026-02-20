//package vn.reborn.gateway.service;
//
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//import vn.reborn.gateway.util.JwtUtil;
//
//@Component
//public class JwtAuthFilter implements GatewayFilterFactory<JwtAuthFilter.Config> {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//                return unauthorized(exchange);
//            }
//
//            String token = authHeader.substring(7);
//
//            try {
//                Claims claims = jwtUtil.validateToken(token);
//                ServerHttpRequest mutatedRequest = exchange.getRequest()
//                        .mutate()
//                        .header("X-User-Id", claims.getSubject()) // hoặc custom claim
//                        .build();
//                return chain.filter(exchange.mutate().request(mutatedRequest).build());
//            } catch (Exception e) {
//                return unauthorized(exchange);
//            }
//        };
//    }
//
//    private Mono<Void> unauthorized(ServerWebExchange exchange) {
//        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//        return exchange.getResponse().setComplete();
//    }
//
//    public static class Config {
//    }
//}
