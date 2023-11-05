package com.mohamed.restulwebservice.restfulwebservice.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("users/{id}") 
	public User retrieveUser(@PathVariable int id) {
		User user = service.findById(id);
		return user;
	}
	
	@PostMapping("users")
	public void createUser(@RequestBody User user) {
		service.save(user);
	}
}