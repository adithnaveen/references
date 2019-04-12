package com.training.TrainingWorks.user.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.training.TrainingWorks.user.User;

/**
 * 
 * @author Naveen Srinivas
 * @see This interface shall register all the custom methods required, there are
 *      CRUD methods which are already defined in MongoRepository those can be
 *      excluded rest can be entered here, the methods can also take an
 *      annotation @Query where we can pass custom query
 */
public interface UserRepository extends MongoRepository<User, Integer> {
	// here we can write any number of methods

	// for getting the user given email
	public User findByEmail(String email);
	public User findByName(String name);

	
	public List<User> findAll();
	public User insert(User user); 
	
	@Query(value= "{'income':{$gt:?0}}", fields="{'name':1, 'email':1}")
	List<User> findByUserIncome(double income); 	
}
