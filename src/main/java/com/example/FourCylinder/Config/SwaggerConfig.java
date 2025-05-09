package com.example.FourCylinder.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI().info(getInfo());

    }

    private Info getInfo() {
      return new Info()
              .title("FourCylinder API")
              .version("1.0")
              .description("FourCylinder 프로젝트 스웨거")
              .contact(new Contact()
                      .name("홍문일")
                      .email("child4564@gmail.com"));
    }



}