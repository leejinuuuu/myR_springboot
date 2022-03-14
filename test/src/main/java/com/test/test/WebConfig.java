package com.test.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.Value;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private String connectPath = "/images/**";
    private String resourcePath = "file:///C:/Users/jinw8/Desktop/springboot_upload/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }

}
