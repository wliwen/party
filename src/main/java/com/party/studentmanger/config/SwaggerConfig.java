package com.party.studentmanger.config;

import org.springframework.context.annotation.Bean;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	/**
	 * swagger接口文档配置
	 * **/
	 	@Bean
	    public Docket swaggerSpringMvcPlugin() {
	        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
	    }
}
