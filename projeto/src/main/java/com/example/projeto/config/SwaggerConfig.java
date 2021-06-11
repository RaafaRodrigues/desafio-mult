package com.example.projeto.config;



import java.util.*;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${application.version}")
    private String applicationVersion;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${springfox.documentation.swagger.v2.contactEmail}")
    private String email;

    @Autowired
    private  Docket dock;

    @Bean
    public Docket customersApi() {
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .paths(PathSelectors.ant("/**"))
                .apis(RequestHandlerSelectors.basePackage("com.example.projeto"))
                .build()
                .apiInfo(metaData());
    }


    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description("API para teste Mult-e")
                .version(applicationVersion)
                .contact(new Contact("Squad", null, email))
                .build();
    }

}
