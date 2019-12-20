package cn.yzstu.common.cinfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/20
 * \* Time: 11:04
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class Swagger2 {

    private static final String BASE_PACKAGE = "cn.yzstu.baldwinblog.controller";
    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket loginDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                //用于分组功能
                .groupName("login")
                //注册整体api信息
                .apiInfo(apiInfo())
                //swagger功能是否启用
                .enable(enableSwagger)
                .select()
                //指定扫描的包
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                //设置此组只匹配/login/**的请求
                .paths(PathSelectors.ant("/login/**"))
                .build();
    }

    @Bean
    public Docket serviceDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("service")
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.ant("/test/**"))
                //                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("test")
                .contact(new Contact("Baldwin", "www.yzstu.cn", "DikeyWang@163.com"))
                .version("1.0.0")
                .build();
    }
}