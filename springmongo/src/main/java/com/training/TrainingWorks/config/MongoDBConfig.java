package com.training.TrainingWorks.config;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.training.TrainingWorks.user.Address;
import com.training.TrainingWorks.user.User;
import com.training.TrainingWorks.user.mongo.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoDBConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return string -> {
//			userRepository.insert(new User(101, "Naveen", new Date(), "naveen@probits.in", 2500,
//					new Address(101, "KK Lane", "Bengaluru", "India")));
//			
//			userRepository.insert(new User(102, "Chaitra", new Date(), "chaitra@probits.in", 3500,
//					new Address(22, "MK Lane", "Harihara", "America")));

		};
	}
}
