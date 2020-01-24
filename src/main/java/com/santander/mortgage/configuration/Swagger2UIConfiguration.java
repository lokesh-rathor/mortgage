/*
 * package com.santander.mortgage.configuration;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 * 
 * import springfox.documentation.builders.ApiInfoBuilder; import
 * springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.swagger2.annotations.EnableSwagger2;
 * 
 * 
 * package com.santander.mortgage.configuration;
 * 
 * import
 * org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
 * import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 * 
 * import com.google.common.base.Predicates;
 * 
 * import springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.swagger2.annotations.EnableSwagger2;
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Configuration
 * 
 * @EnableSwagger2 public class Swagger2UIConfiguration extends
 * WebMvcConfigurerAdapter{
 * 
 * @Bean public Docket api() { // @formatter:off //Register the controllers to
 * swagger //Also it is configuring the Swagger Docket return new
 * Docket(DocumentationType.SWAGGER_2).select() //
 * .apis(RequestHandlerSelectors.any())
 * .apis(Predicates.not(RequestHandlerSelectors.basePackage(
 * "com.santander.mortgage"))) .paths(PathSelectors.any())
 * .paths(PathSelectors.ant("/swagger2-mortgage")) .build(); // @formatter:on }
 * 
 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
 * //enabling swagger-ui part for visual documentation
 * registry.addResourceHandler("swagger-ui.html").addResourceLocations(
 * "classpath:/META-INF/resources/");
 * registry.addResourceHandler("/webjars/**").addResourceLocations(
 * "classpath:/META-INF/resources/webjars/"); }
 * 
 * }
 * 
 * @Configuration
 * 
 * @EnableSwagger2 public class Swagger2UIConfiguration {
 * 
 * @Bean public Docket apiDocket() { String groupName = "Swagger"; return new
 * Docket(DocumentationType.SWAGGER_2) .select()
 * .apis(RequestHandlerSelectors.basePackage("com.santander.mortgage"))
 * .paths(PathSelectors.ant("/mortgage-service/**")) .build()
 * .groupName(groupName) .apiInfo(apiInfo()); }
 * 
 * // Describe the apis private ApiInfo apiInfo() { return new ApiInfoBuilder()
 * .title("test") .description("Test") .version("1.0.0") .license("vvv")
 * .build(); }
 * 
 * }
 */