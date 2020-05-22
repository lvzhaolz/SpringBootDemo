package com.example.demo.config;

import com.example.demo.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCustomInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    CustomInterceptor getCustomInterceptor() {
        return new CustomInterceptor();
    }
}
