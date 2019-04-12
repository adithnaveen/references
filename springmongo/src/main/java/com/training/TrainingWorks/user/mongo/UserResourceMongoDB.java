package com.training.TrainingWorks.user.mongo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.training.TrainingWorks.user.User;
import com.training.TrainingWorks.user.UserNotFoundException;

@RestController
public class UserResourceMongoDB {

	@Autowired
	private UserService serivce; 
	
	@GetMapping(path="/dbusers/{name}")
	public Resource<User> retriveDBUser(@PathVariable String name) {
		User user =  this.serivce.getByName(name);
		
		
		if (user == null) {
			throw new UserNotFoundException("id : " + name);
		}

		// for this to happen in pom.xml file need to import HATEOAS
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(linkTo.withRel("all-users"));
		return resource;

		
	}
	
	
	@PostMapping(path="/dbusers")
	public User insertDBUser(@RequestBody User user) {
		return this.serivce.insertUser(user); 
	}
	
	@GetMapping(path="/dbusers")
	public List<User> getAllUser(){
		return this.serivce.getAllUsers(); 
	}

	@PutMapping(path="/dbusers")
	public User updateUser(@RequestBody User user) {
		return this.serivce.updateUser(user);
	}
	
	
	@DeleteMapping(path="/dbusers/{id}")
	public String deleteUserById(@PathVariable Integer id) {
		if(this.serivce.getUserById(id).isPresent()) {
			this.serivce.deleteUserById(id);
			return "User Deleted with Id " + id;
		}
		
		return "Sorry User Not Found for : " + id; 
	}
	
	@GetMapping(path="/dbusers/income/{income}")
	public List<User> getUserGreaterThanIncome(@PathVariable double income){
		System.out.println("Requested Income " + income);
		return this.serivce.getUserGreaterThanIncome(income); 
	}
	
	public List<User> getUsersBasedOnState(@PathVariable String state){
		return null;
	}
	
}
