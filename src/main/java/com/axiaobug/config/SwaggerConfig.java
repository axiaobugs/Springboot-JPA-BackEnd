package com.axiaobug.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.axiaobug.controller"))
                .build();
    }


    private ApiInfo apiInfo(){
        Contact DEFAULT_CONTACT = new Contact("Yanxiao Fang",
                "https://github.com/axiaobugs",
                "axiaobug@hotmail.com");
        return new ApiInfo(
                "JPA Swagger",
                "A demo SpringBoot Poject",
                "1.0",
                "https://github.com/axiaobugs",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }




}
