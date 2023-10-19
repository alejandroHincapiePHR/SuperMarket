package com.SuperMarket.SuperMarket.adapters.in.api.rest.openapiConfig;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Your API Title")
                        .description("Your API Description")
                        .version("1.0"));
    }

    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**") // Especifica el patrón de URL que deseas documentar
                .build();
    }
}