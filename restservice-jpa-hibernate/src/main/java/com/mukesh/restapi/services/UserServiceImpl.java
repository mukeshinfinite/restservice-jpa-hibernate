package com.mukesh.restapi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukesh.restapi.dto.User;
import com.mukesh.restapi.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<User> getUsers() {

		return userRepository.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int id) {
		return userRepository.getUser(id);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return userRepository.saveUser(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		
		return userRepository.updateUser(user);
	}

	@Override
	@Transactional
	public User deleteUser(User user) {
		
		return userRepository.deleteUser(user);
	}

}
