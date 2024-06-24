package com.marcelo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		OpenAPI openAPI = new OpenAPI().components(new Components())
						.info(new Info()
						.title("API Tarefas")
						.description("API Spring Boot para controle de tarefas.")
						.version("v1.0")
						.contact(new Contact()
						.name("Marcelo Moura")
						.email("mgmoura@gmail.com")
						.url("https://github.com/marcelogmoura")));
		
		return openAPI;
	}

}
