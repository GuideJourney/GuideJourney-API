package com.guidejourney.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow CORS on all paths
                .allowedOrigins("http://localhost:4200") // Example for a local frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Common methods
                .allowedHeaders("*") 
                .allowCredentials(true); 
    }

}
