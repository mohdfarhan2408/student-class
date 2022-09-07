package com.example.studentclass.Configurations;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiConfig() {
        Info info = new Info().title("Live code API").description("Assessment given by Pine Labs Senior Engineer");
        return new OpenAPI().info(info); //Info object to customize wording.
    }

}
