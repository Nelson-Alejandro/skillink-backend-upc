package com.upc.proyecto.backendskillink.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapea las solicitudes a /Imagenes/** hacia la carpeta local src/main/Imagenes
        registry.addResourceHandler("/Imagenes/**")
                .addResourceLocations("classpath:/static/Imagenes/")
                .setCachePeriod(86400)
                .resourceChain(true);
    }
}
