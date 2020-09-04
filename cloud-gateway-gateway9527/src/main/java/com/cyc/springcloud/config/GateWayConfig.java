package com.cyc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /**
     * 代码形式的路由映射配置
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator coustomRouteLoader(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_rote_cyc", r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();


    }
    @Bean
    public RouteLocator coustomRouteLoader2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_rote_cyc1", r -> r.path("/index").uri("http://tieba.baidu.com"))
                .route("path_routh_cyc2",r->r.path("/payment/**").uri("http://localhost:8001")).build();
        return routes.build();


    }
}
