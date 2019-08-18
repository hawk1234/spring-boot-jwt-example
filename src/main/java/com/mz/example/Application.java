package com.mz.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		Application.class,
		//We’ll be using Java 8 Data/Time classes in our domain models. We’ll need to register JPA 2.1 converters
		// so that all the Java 8 Date/Time fields in the domain models automatically get converted to SQL types
		// when we persist them in the database.
		Jsr310JpaConverters.class
})
//https://www.callicoder.com/series/spring-security-react/
//TODO: write unit tests
//TODO: common error handling and standardized error message returned
//TODO: check how this works with postman
//	- check password saved in DB is encoded
//  - check how date is stored in DB
//TODO: read about other TODOs
//TODO: try to hack JWT
//  - try to decode JWT token within other app using same secret
//  - try to steal JWT token using JavaScript - probably best to do that when ReactJS client will be ready. Can I steal JWT from cookies?
public class Application {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
