package com.br.planningpoker.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
public class SpringFoxConfig {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("description")
                .license("")
                .licenseUrl("http://unlicense.org/%22")
                        .termsOfServiceUrl("")
                        .version("1.0.0")
                        .contact(new Contact("", "", ""))
                        .build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.br.planningpoker.controller.impl"))
                .build()
                .apiInfo(apiInfo());
    }
}
