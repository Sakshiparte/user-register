package com.example.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserServices;

//@CrossOrigin(origins ="https://prakash7277.github.io/")
@RestController
@RequestMapping("v1/api/users")
public class UserController {

	@Autowired
	UserServices userServices;
	
	@GetMapping()
	public List<User> getAllUsers()
	{
		return userServices.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id){
	 User user_data =	userServices.getById(id);
	 return user_data;
	}
	
	@PostMapping()
	public User createUser(@RequestBody User user)
	{
		
		return userServices.createUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id)
	{
		System.out.println(id);
		userServices.deleteUser(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user)
	{
	
		return userServices.updateUser(id, user);
	}


	
}
