package br.janioofi.task.configs.infra;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("*")  //.allowedOrigins("*")
				.allowedMethods("POST", "PUT", "DELETE", "GET")
				.allowedHeaders("*")
				.allowCredentials(true);
	}
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        		.addServersItem(new Server().url("https://trilhabackendjr-jun15-production.up.railway.app/swagger-ui/index.html"))
                .addServersItem(new Server().url("http://localhost:8050"));
    }
}
