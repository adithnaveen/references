package com.training.TrainingWorks.user.mongo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.training.TrainingWorks.user.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User getByName(String name) {
		return userRepository.findByName(name);
	}

	public User insertUser(User user) {
		return userRepository.insert(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> getUserById(Integer id) {
		System.out.println("id got for delete" + id);
		User user  = userRepository.findById(id).get();
		System.out.println("user got by id " + user);
		return userRepository.findById(id); 
	}
	
	public List<User> getUserGreaterThanIncome(double income){
		return this.userRepository.findByUserIncome(income); 
	}
	
	
}
