package com.angryzyh.ylb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("盈利宝")
                .description("全栈项目盈利宝")
                .contact(new Contact("Angryzyh", "https://github.com/Angryzyh/ylb_BE", "1792090548@qq.com"))
                .version("0.0.1")
                .build();
        docket.apiInfo(apiInfo);
        // 指定生成文档的包
        docket.select().apis(RequestHandlerSelectors.basePackage("com.angryzyh.ylb.app")).build();
        return docket;
    }
}
