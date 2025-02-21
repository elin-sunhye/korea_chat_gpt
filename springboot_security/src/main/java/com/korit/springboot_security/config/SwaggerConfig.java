package com.korit.springboot_security.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** swagger setting */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.info(getInfo());
        openAPI.addSecurityItem(getSecurityRequirement());
        openAPI.components(new Components().addSecuritySchemes(
                "Bearer Authentication",
                new SecurityScheme()
                        .name("Bearer Authentication")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
        ));
        return openAPI;
    }

    private Info getInfo() {
        Info info = new Info();
        info.title("Spring Boot Security");
        info.version("1.0.0");
        info.description("security");
        info.contact(getContact());
        return info;
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.name("김선혜");
        contact.email("tjsgp1401@naver.com");
        return contact;
    }

    private SecurityRequirement getSecurityRequirement() {
        return new SecurityRequirement().addList("Bearer Authentication");
    }

}
