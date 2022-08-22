package com.sanket.blogappapis.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getinfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getinfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("Blog Api", "This Project is developed by Sanket Annadate", "1.0.0", "Terms of service",
				new Contact("Sanket", "Bloggging.com", "sanketannadatejain@gmail.com"), "License of Apis",
				"Api license URLs", Collections.emptyList());
	};

}
