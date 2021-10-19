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

/**
 * @author +1
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    /*
          关于swagger3的配置引入
           1、在pom中引入swagger3的依赖
           2、建SwaggerConfig配置文件，文件上加@Configuration和@EnableOpenApi
           3、创建controller的示例后，浏览器中查看http://localhost:8080/api/swagger-ui/
           其中api---是yml文件中配置的后缀
   */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30) //设置OpenApi3.0的规范
                .apiInfo(apiInfo())  //配置项目基本信息
                .select()            //选择那些路径和api会生成document
                //扫描有注解的api
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
