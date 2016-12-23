package com.example.restaurantfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestAttributes;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Map;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {
			@Override
			public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
				Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
				// Customize the default entries in errorAttributes to suit your needs
				return errorAttributes;
			}
		};
	}



}
