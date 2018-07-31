package com.hanyf.es.upgrade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @description: swagger2配置
* @author: com.hivescm.es.hanyf
* @date: 2018/5/23 15:01
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {
    /**
     * @Author: hanyf
     * @Description: 创建Docket的Bean
     * @Date: 2018/5/23 15:01
     * @return: springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hanyf.es.upgrade.rest"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * @Author: hanyf
     * @Description: apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
     * @Date: 2018/5/23 15:02
     * @return: springfox.documentation.service.ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("data-es系统提供接口文档")
                .description("data-es系统对外接口文档")
//                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("SCM项目组")
                .version("1.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
