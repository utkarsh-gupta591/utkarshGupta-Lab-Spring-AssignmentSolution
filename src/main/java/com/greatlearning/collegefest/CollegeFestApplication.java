package com.greatlearning.collegefest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.collegefest.entity.*;
import com.greatlearning.collegefest.repository.*;

@SpringBootApplication
public class CollegeFestApplication {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CollegeFestApplication.class, args);
	}
	
	@Bean
	public void createStudents() {

		Student std1 = new Student();
		std1.setName("Harsh");
		std1.setDepartment("Mech");
		std1.setCountry("India");
		studentRepository.save(std1);

		Student std2 = new Student();
		std2.setName("Akshay");
		std2.setDepartment("CSE");
		std2.setCountry("India");
		studentRepository.save(std2);

		Student std3 = new Student();
		std3.setName("Arjun");
		std3.setDepartment("Civil");
		std3.setCountry("India");
		studentRepository.save(std3);

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);

		User user1 = new User();
		user1.setUsername("abc");
		user1.setPassword(encoder().encode("abc"));
		user1.setRoles(Arrays.asList(adminRole, userRole));

		userRepository.save(user1);

		User user2 = new User();
		user2.setUsername("xyz");
		user2.setPassword(encoder().encode("xyz"));
		user2.setRoles(Arrays.asList(userRole));
		userRepository.save(user2);

	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
