package com.example.softwarearchitectureexamples.config;

import com.example.softwarearchitectureexamples.interceptor.AdminInterceptor;
import com.example.softwarearchitectureexamples.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;
    private final AdminInterceptor adminInterceptor;

    public WebMvcConfiguration(LoginInterceptor loginInterceptor, AdminInterceptor adminInterceptor) {
        this.loginInterceptor = loginInterceptor;
        this.adminInterceptor = adminInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login");

        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/api/admin/**");
    }
}
