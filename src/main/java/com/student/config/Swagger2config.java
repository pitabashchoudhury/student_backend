package com.student.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class Swagger2config {

    @Value("${app.version}")
    private String version;

    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.student")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("student Web Service").description("Backend for product Website/App")
                .contact(new Contact("pitabash", "", "pitabash98@gmail.com")).version(version).build();
    }


}
