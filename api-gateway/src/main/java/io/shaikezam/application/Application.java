package io.shaikezam.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/webapi/products/**")
                        .filters(f->f.rewritePath("/webapi/(?<segment>.*)","/api/v1/${segment}"))
                        .uri("lb://product-service"))
                .route("order-service", r -> r.path("/webapi/orders/**")
                        .filters(f->f.rewritePath("/webapi/(?<segment>.*)","/api/v1/${segment}"))
                        .uri("lb://order-service"))
                .build();
    }

}
