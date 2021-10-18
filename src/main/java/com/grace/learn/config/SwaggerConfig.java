package com.grace.learn.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30) //设置OpenApi3.0的规范
                .apiInfo(apiInfo())  //配置项目基本信息
                .select()            //选择那些路径和api会生成document
                //扫描的路径包，用于指定路径接口扫描设置
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("关于excel的学习记录")
                .version("1.0版本")
                //设置管理该API人员的联系信息
                //.contact(new Contact("作者", "作者URL", "作者Email"))
                .build();
    }
}
