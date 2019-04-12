package com.training.TrainingWorks.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 103;

//	static {
//		users.add(new User(101, "NAVEEN", new Date(), "naveen@probits.in", ));
//		users.add(new User(102, "Kumar", new Date(), "kumar@probits.in"));
//		users.add(new User(103, "Hari", new Date(), "hari@probits.in"));
//	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();

			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
