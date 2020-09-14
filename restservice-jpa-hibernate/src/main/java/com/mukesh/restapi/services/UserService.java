package com.mukesh.restapi.services;

import java.util.List;

import com.mukesh.restapi.dto.User;


public interface UserService {

	List<User> getUsers();

	User getUser(int id);

	User saveUser(User user);

	User updateUser(User user);

	User deleteUser(User user);

}
