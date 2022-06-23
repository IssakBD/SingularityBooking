package kz.arab.SingularityHackathon.demo;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(  name = "Bearer Authentication",   type = SecuritySchemeType.HTTP,   bearerFormat = "JWT",   scheme = "bearer" )
public class SingularityBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SingularityBookingApplication.class, args);
	}

}
