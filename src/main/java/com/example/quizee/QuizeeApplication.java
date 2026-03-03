package com.example.quizee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.quizee.dao")
public class QuizeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizeeApplication.class, args);
	}

}
