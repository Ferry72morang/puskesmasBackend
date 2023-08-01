package puskesmas.app.patientservice.puskesmasbackend.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("puskesmas.app.patientservice.puskesmasbackend.controller")) // Ganti dengan package tempat berada kontroler Anda
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API for PuskesmasApps",
                "RESTful API For PuskesmasApps.",
                "0.20230801.v1",
                "Ferry",
                new Contact("Ferry Situmorang", "ICN", "ferrypriantositumorangcr7@gmail.com"),
                "For internal usage only", "ICN", Collections.emptyList());
    }
}
