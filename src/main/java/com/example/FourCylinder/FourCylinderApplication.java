package com.example.FourCylinder;

import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FourCylinderApplication {
	private final UserRepository userRepository;

	public FourCylinderApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	public static void main(String[] args) {
		SpringApplication.run(FourCylinderApplication.class, args);
	}

	public void run(String... args){
		User user = User.builder()
				.username("test")
				.password("1234")
				.email("baer4564@naver.com")
				.build();

	userRepository.save(user);
	}


}
