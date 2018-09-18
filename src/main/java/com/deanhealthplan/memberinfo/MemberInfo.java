package com.deanhealthplan.memberinfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.deanhealthplan.memberinfo.SwaggerVisible;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@ComponentScan(basePackages="com.deanhealthplan.memberinfo")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class MemberInfo {

	private static final Logger log = LogManager.getLogger(MemberInfo.class);

	public static void main(String[] args) {		
		SpringApplication.run(MemberInfo.class, args);
	}
	

	  @Bean
	    public Docket newsApi() {
	        return new Docket(DocumentationType.SWAGGER_2)         
	                .groupName("MEMBER INFO")
	                .apiInfo(apiInfo())
	                .select()                               
	                .apis(RequestHandlerSelectors.withMethodAnnotation(SwaggerVisible.class))             
	                .build();                        
//	                
	    }
	  
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	        		  .title("Spring REST Sample with Swagger")
	                  .description("Spring REST Sample with Swagger")
//	                  .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
//	                  .contact("Niklas Heidloff")
//	                  .license("Apache	 License Version 2.0")
//	                  .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
	                  .version("2.0")
	                  .build();
	    }
	    
		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}
}
