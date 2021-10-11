package com.project.main;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EntityScan(basePackages = "com.project.entities")
@ComponentScan(basePackages = "com.project")
@EnableJpaRepositories(basePackages = "com.project.dataAccess")
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "et-ya",
				"api_key", "192246249743585",
				"api_secret", "ESJN1lhspr4WbOT-rlz_Rsu_bsg",
				"secure", true));
		
		File file = new File("foto.jpeg");
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		//http://res.cloudinary.com/et-ya/image/upload/v1631013309/aquatyhvnm5l9voo7cgm.jpg
	}

	@Bean
	public Docket api() {
		return new 
				Docket(DocumentationType.SWAGGER_2).
				select().
				apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.any()).
				build();
	}
}
