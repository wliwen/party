package com.party.studentmanger.base;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@ComponentScan(basePackages = "com.party.studentmanger.*")//开启全局扫描组件注解，并将其注册成组件
@EnableSwagger2 //开启swagger文档
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages="com.party.studentmanger.mapper")
@SpringBootApplication
public class PartyApplication {
	/**
	 * 项目启动入口
	 * **/
	public static void main(String[] args) {
        SpringApplication.run(PartyApplication.class, args);
    }
	/**
     * 文件上传配置
     * 单文件上传大小配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("5120KB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("5120KB");
        return factory.createMultipartConfig();
    }
}
