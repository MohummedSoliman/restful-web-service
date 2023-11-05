package com.mohamed.restulwebservice.restfulwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "Mohamed", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Zain El Dain", LocalDate.now().minusYears(3)));
		users.add(new User(++userCount, "Ezz", LocalDate.now().minusYears(1)));
	}
	
	public List<User> findAll(){
		return users;
	}

	public User findById(int id) {
		Predicate<? super User> predicate = 
				user -> user.getId() == id;
		User user = users.stream().filter(predicate).findFirst().get();
		return user;
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
}
