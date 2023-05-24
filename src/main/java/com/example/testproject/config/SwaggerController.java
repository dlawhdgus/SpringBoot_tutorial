package com.example.testproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "TestProject",
    description = "Spring-Boot_Swagger",
    version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerController {

    @Bean
    public GroupedOpenApi group1() {
        return GroupedOpenApi.builder()
            .group("API")
            .pathsToMatch("/api/v1/**")
            .build();
    }

}
