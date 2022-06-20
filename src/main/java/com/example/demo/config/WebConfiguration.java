package com.example.demo.config;

import com.example.demo.interceptor.HeaderTenantInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Binh Nguyen
 * Jun 20, 2022
 */

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final HeaderTenantInterceptor headerTenantInterceptor;

    public WebConfiguration(HeaderTenantInterceptor headerTenantInterceptor) {
        this.headerTenantInterceptor = headerTenantInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(headerTenantInterceptor);
    }
}
