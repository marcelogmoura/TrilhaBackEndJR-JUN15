package com.marcelo.infrastructure.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marcelo.infrastructure.filters.AuthenticationFilter;

@Configuration
public class JwtBearerConfig {

	@Bean
	public FilterRegistrationBean<AuthenticationFilter> jwtFilter() {
		FilterRegistrationBean<AuthenticationFilter> filter = new FilterRegistrationBean<AuthenticationFilter>();
		filter.setFilter(new AuthenticationFilter());
		filter.addUrlPatterns("/api/tarefas/*");
		return filter;
	}

}
