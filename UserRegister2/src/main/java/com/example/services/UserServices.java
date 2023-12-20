package com.example.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.models.User;
import com.example.repositories.UserRepository;

@Service
public class UserServices {


	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		List<User> allUsers=userRepository.findAll();
		return allUsers;
	}
	
	public User getById(int id){
		return userRepository.findById(id).orElseThrow(()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		});
	}
	public User createUser(User user)
	{
		
		return userRepository.save(user);
	}
	
	public String deleteUser(int id)
	{
		userRepository.deleteById(id);
		return "user deleted successfully";
	}
	
	public User updateUser(int id, User user)
	{
		User founded_user=userRepository.findById(id).orElseThrow(
			()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		});
	
		user.setId(id);
		return userRepository.save(user);
	}
	
}
