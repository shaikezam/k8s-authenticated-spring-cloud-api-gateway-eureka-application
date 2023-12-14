package io.shaikezam.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebFluxSecurity
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
                        .filters(f -> f.rewritePath("/webapi/(?<segment>.*)", "/api/v1/${segment}")
                                //.tokenRelay()
                        )
                        .uri("lb://product-service"))
                .route("order-service", r -> r.path("/webapi/orders/**")
                        .filters(f -> f.rewritePath("/webapi/(?<segment>.*)", "/api/v1/${segment}")
                                //.tokenRelay()
                        )
                        .uri("lb://order-service"))
//                .route("keycloak-route", r -> r
//                        .path("/auth/**")  // Path to match for Keycloak requests
//                        .filters(f -> f.rewritePath("/auth/(?<segment>.*)", "/${segment}"))  // Rewrite path after /auth
//                        .uri("http://keycloak:8005"))  // Replace with the actual URI of your Keycloak server
                .build();
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
//                .oauth2Login(withDefaults());
//        http.csrf().disable();
//        return http.build();
        return http.authorizeExchange()
                .pathMatchers("/", "/oauth2**", "/oauth2/authorization/keycloak", "/auth**", "/callback**")
                .permitAll()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Login(withDefaults())
                .csrf()
                .disable()
                .build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.authorizeHttpRequests()
//                .requestMatchers("/login/oauth2/code/keycloak").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login();
//
//        return  httpSecurity.build();
//    }

}
