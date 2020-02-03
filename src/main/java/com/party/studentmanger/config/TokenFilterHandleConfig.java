package com.party.studentmanger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 将设定好的过滤器通过实现接口方式交由spring管理
 * */
@Configuration
public class TokenFilterHandleConfig implements WebMvcConfigurer{
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenFilterHandle())
                .addPathPatterns("/**");   
    }
    @Bean
    public TokenFilterHandle tokenFilterHandle() {
        return new TokenFilterHandle();
    }
}
