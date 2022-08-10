package com.example.springbootswagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket sawggerApiConfig() {
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.example.springbootswagger.controller"))
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee Details")
				.description("Sample Documentaion Generated Usig SWAGGER for our Employee Rest API")
				.termsOfServiceUrl("")
				.license("")
				.build();
	}
}
