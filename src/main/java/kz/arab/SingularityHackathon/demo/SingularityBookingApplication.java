package kz.arab.SingularityHackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SingularityBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SingularityBookingApplication.class, args);
	}

}
