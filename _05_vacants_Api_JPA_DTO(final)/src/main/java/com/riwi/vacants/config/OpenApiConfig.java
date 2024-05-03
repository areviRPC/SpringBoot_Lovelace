package com.riwi.vacants.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//102

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "api para administrar compañias y vacantes",
        version = "1.0",
        description = "tablero de anotaciones"
    )
)
public class OpenApiConfig {
    
}
