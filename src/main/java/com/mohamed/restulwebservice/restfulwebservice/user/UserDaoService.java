package com.mohamed.restulwebservice.restfulwebservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Mohamed", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Zain El Dain", LocalDate.now().minusYears(3)));
		users.add(new User(3, "Ezz", LocalDate.now().minusYears(1)));
	}
	
	public List<User> findAll(){
		return users;
	}
}
