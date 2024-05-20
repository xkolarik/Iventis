package com.baeldung.apiswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDateTime;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.baeldung.apiswagger"))
                .paths(PathSelectors.any()).build().directModelSubstitute(LocalDateTime.class, String.class);
    }

}