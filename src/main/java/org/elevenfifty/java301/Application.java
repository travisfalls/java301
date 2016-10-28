package org.elevenfifty.java301;

import java.time.LocalDate;

import org.elevenfifty.java301.beans.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public User instructor() {
		User u = new User();
		u.setActive(true);
		u.setFirstName("James");
		u.setLastName("Keim");
		u.setId(1);
		u.setEmail("james@smoothie.com");
		u.setPhoneNumber("317.867.5309");
		return u;
	}
}
