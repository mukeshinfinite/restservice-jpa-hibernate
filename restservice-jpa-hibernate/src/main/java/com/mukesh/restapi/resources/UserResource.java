package com.mukesh.restapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.restapi.dto.User;
import com.mukesh.restapi.services.UserService;

@RestController
public class UserResource {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return this.userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return this.userService.getUser(id);
	}
	
	@PostMapping("/user")
	public User AddUser(@RequestBody User user) {
		
		return this.userService.saveUser(user);
	}
	
	@PutMapping("/user")
	public User modifyUser(@RequestBody User user) {
		boolean flag = false;
		for(User u :userService.getUsers()) {
			if( u.getUserId() == user.getUserId()) {
				flag = true;
				break;
			}
		}
		if(flag) {
			return this.userService.updateUser(user);
		}else {
			return new User();
		}
		
	}
	
	@DeleteMapping("/user/{id}")
	public User removeUser(@PathVariable int id) {
		boolean flag = false;
		User user = null;
		for(User u :userService.getUsers()) {
			if( u.getUserId() == id) {
				flag = true;
				user = u;
				break;
			}
		}
		if(flag) {
			return this.userService.deleteUser(user);
		}else {
			return new User();
		}
		
	}
}
